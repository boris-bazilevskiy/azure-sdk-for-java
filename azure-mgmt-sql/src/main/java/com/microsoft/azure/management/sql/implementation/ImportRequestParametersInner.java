/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.sql.ImportExportDatabaseEditions;

/**
 * Import Azure SQL Database parameters.
 */
public class ImportRequestParametersInner extends ExportRequestParametersInner {
    /**
     * The name of the Azure SQL database to import.
     */
    private String databaseName;

    /**
     * The edition for the Azure SQL Database being created. Possible values
     * include: 'Basic', 'Standard', 'Premium'.
     */
    private ImportExportDatabaseEditions edition;

    /**
     * The name of the service objective to assign to the Azure SQL Database.
     */
    private String serviceObjectiveName;

    /**
     * The maximum size for the newly imported database.
     */
    private String maxSizeBytes;

    /**
     * Get the databaseName value.
     *
     * @return the databaseName value
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Set the databaseName value.
     *
     * @param databaseName the databaseName value to set
     * @return the ImportRequestParametersInner object itself.
     */
    public ImportRequestParametersInner withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * Get the edition value.
     *
     * @return the edition value
     */
    public ImportExportDatabaseEditions edition() {
        return this.edition;
    }

    /**
     * Set the edition value.
     *
     * @param edition the edition value to set
     * @return the ImportRequestParametersInner object itself.
     */
    public ImportRequestParametersInner withEdition(ImportExportDatabaseEditions edition) {
        this.edition = edition;
        return this;
    }

    /**
     * Get the serviceObjectiveName value.
     *
     * @return the serviceObjectiveName value
     */
    public String serviceObjectiveName() {
        return this.serviceObjectiveName;
    }

    /**
     * Set the serviceObjectiveName value.
     *
     * @param serviceObjectiveName the serviceObjectiveName value to set
     * @return the ImportRequestParametersInner object itself.
     */
    public ImportRequestParametersInner withServiceObjectiveName(String serviceObjectiveName) {
        this.serviceObjectiveName = serviceObjectiveName;
        return this;
    }

    /**
     * Get the maxSizeBytes value.
     *
     * @return the maxSizeBytes value
     */
    public String maxSizeBytes() {
        return this.maxSizeBytes;
    }

    /**
     * Set the maxSizeBytes value.
     *
     * @param maxSizeBytes the maxSizeBytes value to set
     * @return the ImportRequestParametersInner object itself.
     */
    public ImportRequestParametersInner withMaxSizeBytes(String maxSizeBytes) {
        this.maxSizeBytes = maxSizeBytes;
        return this;
    }

}
