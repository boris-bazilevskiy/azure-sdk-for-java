/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Represents the activity on an Azure SQL Elastic Pool.
 */
@JsonFlatten
public class ElasticPoolDatabaseActivityInner extends Resource {
    /**
     * The database name.
     */
    @JsonProperty(value = "properties.databaseName", access = JsonProperty.Access.WRITE_ONLY)
    private String databaseName;

    /**
     * The time the operation finished.
     */
    @JsonProperty(value = "properties.endTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime endTime;

    /**
     * The error code if available.
     */
    @JsonProperty(value = "properties.errorCode", access = JsonProperty.Access.WRITE_ONLY)
    private Integer errorCode;

    /**
     * The error message if available.
     */
    @JsonProperty(value = "properties.errorMessage", access = JsonProperty.Access.WRITE_ONLY)
    private String errorMessage;

    /**
     * The error severity if available.
     */
    @JsonProperty(value = "properties.errorSeverity", access = JsonProperty.Access.WRITE_ONLY)
    private Integer errorSeverity;

    /**
     * The operation name.
     */
    @JsonProperty(value = "properties.operation", access = JsonProperty.Access.WRITE_ONLY)
    private String operation;

    /**
     * The unique operation ID.
     */
    @JsonProperty(value = "properties.operationId", access = JsonProperty.Access.WRITE_ONLY)
    private String operationId;

    /**
     * The percentage complete if available.
     */
    @JsonProperty(value = "properties.percentComplete", access = JsonProperty.Access.WRITE_ONLY)
    private Integer percentComplete;

    /**
     * The name for the Elastic Pool the database is moving into if available.
     */
    @JsonProperty(value = "properties.requestedElasticPoolName", access = JsonProperty.Access.WRITE_ONLY)
    private String requestedElasticPoolName;

    /**
     * The name of the current Elastic Pool the database is in if available.
     */
    @JsonProperty(value = "properties.currentElasticPoolName", access = JsonProperty.Access.WRITE_ONLY)
    private String currentElasticPoolName;

    /**
     * The name of the current service objective if available.
     */
    @JsonProperty(value = "properties.currentServiceObjective", access = JsonProperty.Access.WRITE_ONLY)
    private String currentServiceObjective;

    /**
     * The name of the requested service objective if available.
     */
    @JsonProperty(value = "properties.requestedServiceObjective", access = JsonProperty.Access.WRITE_ONLY)
    private String requestedServiceObjective;

    /**
     * The name of the Azure SQL Server the Elastic Pool is in.
     */
    @JsonProperty(value = "properties.serverName", access = JsonProperty.Access.WRITE_ONLY)
    private String serverName;

    /**
     * The time the operation started.
     */
    @JsonProperty(value = "properties.startTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime startTime;

    /**
     * The current state of the operation.
     */
    @JsonProperty(value = "properties.state", access = JsonProperty.Access.WRITE_ONLY)
    private String state;

    /**
     * Get the databaseName value.
     *
     * @return the databaseName value
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Get the endTime value.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Get the errorCode value.
     *
     * @return the errorCode value
     */
    public Integer errorCode() {
        return this.errorCode;
    }

    /**
     * Get the errorMessage value.
     *
     * @return the errorMessage value
     */
    public String errorMessage() {
        return this.errorMessage;
    }

    /**
     * Get the errorSeverity value.
     *
     * @return the errorSeverity value
     */
    public Integer errorSeverity() {
        return this.errorSeverity;
    }

    /**
     * Get the operation value.
     *
     * @return the operation value
     */
    public String operation() {
        return this.operation;
    }

    /**
     * Get the operationId value.
     *
     * @return the operationId value
     */
    public String operationId() {
        return this.operationId;
    }

    /**
     * Get the percentComplete value.
     *
     * @return the percentComplete value
     */
    public Integer percentComplete() {
        return this.percentComplete;
    }

    /**
     * Get the requestedElasticPoolName value.
     *
     * @return the requestedElasticPoolName value
     */
    public String requestedElasticPoolName() {
        return this.requestedElasticPoolName;
    }

    /**
     * Get the currentElasticPoolName value.
     *
     * @return the currentElasticPoolName value
     */
    public String currentElasticPoolName() {
        return this.currentElasticPoolName;
    }

    /**
     * Get the currentServiceObjective value.
     *
     * @return the currentServiceObjective value
     */
    public String currentServiceObjective() {
        return this.currentServiceObjective;
    }

    /**
     * Get the requestedServiceObjective value.
     *
     * @return the requestedServiceObjective value
     */
    public String requestedServiceObjective() {
        return this.requestedServiceObjective;
    }

    /**
     * Get the serverName value.
     *
     * @return the serverName value
     */
    public String serverName() {
        return this.serverName;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public String state() {
        return this.state;
    }

}
