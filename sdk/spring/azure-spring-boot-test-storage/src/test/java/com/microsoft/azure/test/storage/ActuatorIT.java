// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.microsoft.azure.test.storage;


import com.azure.spring.test.AppRunner;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActuatorIT {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final String AZURE_STORAGE_ACCOUNT_NAME = System.getenv("AZURE_STORAGE_ACCOUNT_NAME");
    private static final String AZURE_STORAGE_ACCOUNT_KEY = System.getenv("AZURE_STORAGE_ACCOUNT_KEY");
    private static final String AZURE_STORAGE_BLOB_ENDPOINT = System.getenv("AZURE_STORAGE_BLOB_ENDPOINT");
    private static final String AZURE_STORAGE_FILE_ENDPOINT = System.getenv("AZURE_STORAGE_FILE_ENDPOINT");
    private static final String AZURE_STORAGE_BLOB = System.getenv("AZURE_STORAGE_BLOB");
    private static final String AZURE_STORAGE_FILE = System.getenv("AZURE_STORAGE_FILE");

    @Test
    public void testBlobStorageActuatorHealth() {
        try (AppRunner app = new AppRunner(DummyApp.class)) {
            //set properties
            app.property("azure.storage.account-name", AZURE_STORAGE_ACCOUNT_NAME);
            app.property("azure.storage.account-key", AZURE_STORAGE_ACCOUNT_KEY);
            app.property("azure.storage.blob-endpoint", AZURE_STORAGE_BLOB_ENDPOINT);
            app.property("blob", AZURE_STORAGE_BLOB);
            app.property("management.endpoint.health.show-details", "always");
            app.property("management.endpoints.web.exposure.include", "*");
            //start app
            app.start();
            String response = null;
            int count = 3;
            while (count > 0) {
                try {
                    response = REST_TEMPLATE.getForObject(
                        "http://localhost:" + app.port() + "/actuator/health/blobStorage", String.class);
                    break;
                } catch (Exception e) {
                    count--;
                }
            }
            assertTrue(response != null && response.contains("\"status\":\"UP\""));
        }
    }

    @Test
    public void testFileStorageActuatorHealth() {
        try (AppRunner app = new AppRunner(DummyApp.class)) {
            //set properties
            app.property("azure.storage.account-name", AZURE_STORAGE_ACCOUNT_NAME);
            app.property("azure.storage.account-key", AZURE_STORAGE_ACCOUNT_KEY);
            app.property("azure.storage.file-endpoint", AZURE_STORAGE_FILE_ENDPOINT);
            app.property("file", AZURE_STORAGE_FILE);
            app.property("management.endpoint.health.show-details", "always");
            //start app
            app.start();
            String response = null;
            int count = 3;
            while (count > 0) {
                try {
                    response = REST_TEMPLATE.getForObject(
                        "http://localhost:" + app.port() + "/actuator/health/fileStorage", String.class);
                    break;
                } catch (Exception e) {
                    count--;
                }
            }
            assertTrue(response != null && response.contains("\"status\":\"UP\""));
        }
    }
}
