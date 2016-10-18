/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.sql.DataMaskingRuleProperties;

/**
 * Represents an Azure SQL Database data masking rule.
 */
public class DataMaskingRuleInner extends com.microsoft.azure.management.sql.SubResource {
    /**
     * Represents the properties of the resource.
     */
    private DataMaskingRuleProperties properties;

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public DataMaskingRuleProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     * @return the DataMaskingRuleInner object itself.
     */
    public DataMaskingRuleInner withProperties(DataMaskingRuleProperties properties) {
        this.properties = properties;
        return this;
    }

}
