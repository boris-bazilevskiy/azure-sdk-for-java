// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import com.azure.core.util.BinaryData;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.models.CreateMessageBatchOptions;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Contains code snippets when generating javadocs through doclets for {@link ServiceBusSenderAsyncClient}.
 */
public class ServiceBusSenderAsyncClientJavaDocCodeSamples {
    /**
     * Code snippet demonstrating how to create an {@link ServiceBusSenderAsyncClient}.
     */
    public void instantiate() {
        // BEGIN: com.azure.messaging.servicebus.servicebusasyncsenderclient.instantiation
        // The required parameter is a way to authenticate with Service Bus using credentials.
        // The connectionString provides a way to authenticate with Service Bus.
        ServiceBusSenderAsyncClient sender = new ServiceBusClientBuilder()
            .connectionString(
                "Endpoint={fully-qualified-namespace};SharedAccessKeyName={policy-name};SharedAccessKey={key}")
            .sender()
            .queueName("<< QUEUE NAME >>")
            .buildAsyncClient();
        // END: com.azure.messaging.servicebus.servicebusasyncsenderclient.instantiation

        sender.close();
    }

    /**
     * Code snippet demonstrating how to create an {@link ServiceBusSenderAsyncClient}.
     */
    public void instantiateWithDefaultCredential() {
        // BEGIN: com.azure.messaging.servicebus.servicebusasyncsenderclient.instantiateWithDefaultCredential
        // The required parameter is a way to authenticate with Service Bus using credentials.
        // The connectionString provides a way to authenticate with Service Bus.
        ServiceBusSenderAsyncClient sender = new ServiceBusClientBuilder()
            .credential("<<fully-qualified-namespace>>",
                new DefaultAzureCredentialBuilder().build())
            .sender()
            .queueName("<< QUEUE NAME >>")
            .buildAsyncClient();
        // END: com.azure.messaging.servicebus.servicebusasyncsenderclient.instantiateWithDefaultCredential

        sender.close();
    }

    /**
     * Code snippet demonstrating how to send a batch to Service Bus queue or topic.
     */
    public void sendBatch() {
        // BEGIN: com.azure.messaging.servicebus.servicebusasyncsenderclient.createMessageBatch
        // The required parameter is a way to authenticate with Service Bus using credentials.
        // The connectionString provides a way to authenticate with Service Bus.
        ServiceBusSenderAsyncClient sender = new ServiceBusClientBuilder()
            .connectionString(
                "Endpoint={fully-qualified-namespace};SharedAccessKeyName={policy-name};SharedAccessKey={key}")
            .sender()
            .queueName("<QUEUE OR TOPIC NAME>")
            .buildAsyncClient();

        // Creating a batch without options set, will allow for automatic routing of events to any partition.
        sender.createMessageBatch().flatMap(batch -> {
            batch.tryAddMessage(new ServiceBusMessage(BinaryData.fromBytes("test-1".getBytes(UTF_8))));
            batch.tryAddMessage(new ServiceBusMessage(BinaryData.fromBytes("test-2".getBytes(UTF_8))));
            return sender.sendMessages(batch);
        }).subscribe(unused -> {
        },
            error -> System.err.println("Error occurred while sending batch:" + error),
            () -> System.out.println("Send complete."));
        // END: com.azure.messaging.servicebus.servicebusasyncsenderclient.createMessageBatch

        sender.close();
    }


    /**
     * Code snippet demonstrating how to create a size-limited {@link ServiceBusMessageBatch} and send it.
     */
    public void batchSizeLimited() {
        ServiceBusSenderAsyncClient sender = new ServiceBusClientBuilder()
            .sender()
            .buildAsyncClient();

        ServiceBusMessage firstMessage = new ServiceBusMessage(BinaryData.fromBytes("92".getBytes(UTF_8)));
        firstMessage.getApplicationProperties().put("telemetry", "latency");
        ServiceBusMessage secondMessage = new ServiceBusMessage(BinaryData.fromBytes("98".getBytes(UTF_8)));
        secondMessage.getApplicationProperties().put("telemetry", "cpu-temperature");

        // BEGIN: com.azure.messaging.servicebus.servicebusasyncsenderclient.createMessageBatch#CreateMessageBatchOptionsLimitedSize
        Flux<ServiceBusMessage> telemetryMessages = Flux.just(firstMessage, secondMessage);

        // Setting `setMaximumSizeInBytes` when creating a batch, limits the size of that batch.
        // In this case, all the batches created with these options are limited to 256 bytes.
        CreateMessageBatchOptions options = new CreateMessageBatchOptions()
            .setMaximumSizeInBytes(256);
        AtomicReference<ServiceBusMessageBatch> currentBatch = new AtomicReference<>(
            sender.createMessageBatch(options).block());

        // The sample Flux contains two messages, but it could be an infinite stream of telemetry messages.
        telemetryMessages.flatMap(message -> {
            ServiceBusMessageBatch batch = currentBatch.get();
            if (batch.tryAddMessage(message)) {
                return Mono.empty();
            }

            return Mono.when(
                sender.sendMessages(batch),
                sender.createMessageBatch(options).map(newBatch -> {
                    currentBatch.set(newBatch);

                    // Add the message that did not fit in the previous batch.
                    if (!newBatch.tryAddMessage(message)) {
                        throw Exceptions.propagate(new IllegalArgumentException(
                            "Message was too large to fit in an empty batch. Max size: " + newBatch.getMaxSizeInBytes()));
                    }

                    return newBatch;
                }));
        }).then()
            .doFinally(signal -> {
                ServiceBusMessageBatch batch = currentBatch.getAndSet(null);
                if (batch != null && batch.getCount() > 0) {
                    sender.sendMessages(batch).block();
                }
            });
        // END: com.azure.messaging.servicebus.servicebusasyncsenderclient.createMessageBatch#CreateMessageBatchOptionsLimitedSize
    }
}
