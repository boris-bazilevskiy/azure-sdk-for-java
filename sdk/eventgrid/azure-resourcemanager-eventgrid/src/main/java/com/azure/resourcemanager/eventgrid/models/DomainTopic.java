// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.resourcemanager.eventgrid.fluent.models.DomainTopicInner;

/** An immutable client-side representation of DomainTopic. */
public interface DomainTopic {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the provisioningState property: Provisioning state of the domain topic.
     *
     * @return the provisioningState value.
     */
    DomainTopicProvisioningState provisioningState();

    /**
     * Gets the inner com.azure.resourcemanager.eventgrid.fluent.models.DomainTopicInner object.
     *
     * @return the inner object.
     */
    DomainTopicInner innerModel();
}
