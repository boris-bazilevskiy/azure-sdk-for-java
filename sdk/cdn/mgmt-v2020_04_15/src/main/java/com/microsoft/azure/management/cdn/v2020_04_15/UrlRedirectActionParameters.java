/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn.v2020_04_15;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the parameters for the url redirect action.
 */
public class UrlRedirectActionParameters {
    /**
     * The odatatype property.
     */
    @JsonProperty(value = "@odata\\.type", required = true)
    private String odatatype;

    /**
     * The redirect type the rule will use when redirecting traffic. Possible
     * values include: 'Moved', 'Found', 'TemporaryRedirect',
     * 'PermanentRedirect'.
     */
    @JsonProperty(value = "redirectType", required = true)
    private RedirectType redirectType;

    /**
     * Protocol to use for the redirect. The default value is MatchRequest.
     * Possible values include: 'MatchRequest', 'Http', 'Https'.
     */
    @JsonProperty(value = "destinationProtocol")
    private DestinationProtocol destinationProtocol;

    /**
     * The full path to redirect. Path cannot be empty and must start with /.
     * Leave empty to use the incoming path as destination path.
     */
    @JsonProperty(value = "customPath")
    private String customPath;

    /**
     * Host to redirect. Leave empty to use the incoming host as the
     * destination host.
     */
    @JsonProperty(value = "customHostname")
    private String customHostname;

    /**
     * The set of query strings to be placed in the redirect URL. Setting this
     * value would replace any existing query string; leave empty to preserve
     * the incoming query string. Query string must be in
     * &lt;key&gt;=&lt;value&gt; format. ? and &amp; will be added
     * automatically so do not include them.
     */
    @JsonProperty(value = "customQueryString")
    private String customQueryString;

    /**
     * Fragment to add to the redirect URL. Fragment is the part of the URL
     * that comes after #. Do not include the #.
     */
    @JsonProperty(value = "customFragment")
    private String customFragment;

    /**
     * Creates an instance of UrlRedirectActionParameters class.
     * @param redirectType the redirect type the rule will use when redirecting traffic. Possible values include: 'Moved', 'Found', 'TemporaryRedirect', 'PermanentRedirect'.
     */
    public UrlRedirectActionParameters() {
        odatatype = "#Microsoft.Azure.Cdn.Models.DeliveryRuleUrlRedirectActionParameters";
    }

    /**
     * Get the odatatype value.
     *
     * @return the odatatype value
     */
    public String odatatype() {
        return this.odatatype;
    }

    /**
     * Set the odatatype value.
     *
     * @param odatatype the odatatype value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withOdatatype(String odatatype) {
        this.odatatype = odatatype;
        return this;
    }

    /**
     * Get the redirect type the rule will use when redirecting traffic. Possible values include: 'Moved', 'Found', 'TemporaryRedirect', 'PermanentRedirect'.
     *
     * @return the redirectType value
     */
    public RedirectType redirectType() {
        return this.redirectType;
    }

    /**
     * Set the redirect type the rule will use when redirecting traffic. Possible values include: 'Moved', 'Found', 'TemporaryRedirect', 'PermanentRedirect'.
     *
     * @param redirectType the redirectType value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withRedirectType(RedirectType redirectType) {
        this.redirectType = redirectType;
        return this;
    }

    /**
     * Get protocol to use for the redirect. The default value is MatchRequest. Possible values include: 'MatchRequest', 'Http', 'Https'.
     *
     * @return the destinationProtocol value
     */
    public DestinationProtocol destinationProtocol() {
        return this.destinationProtocol;
    }

    /**
     * Set protocol to use for the redirect. The default value is MatchRequest. Possible values include: 'MatchRequest', 'Http', 'Https'.
     *
     * @param destinationProtocol the destinationProtocol value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withDestinationProtocol(DestinationProtocol destinationProtocol) {
        this.destinationProtocol = destinationProtocol;
        return this;
    }

    /**
     * Get the full path to redirect. Path cannot be empty and must start with /. Leave empty to use the incoming path as destination path.
     *
     * @return the customPath value
     */
    public String customPath() {
        return this.customPath;
    }

    /**
     * Set the full path to redirect. Path cannot be empty and must start with /. Leave empty to use the incoming path as destination path.
     *
     * @param customPath the customPath value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withCustomPath(String customPath) {
        this.customPath = customPath;
        return this;
    }

    /**
     * Get host to redirect. Leave empty to use the incoming host as the destination host.
     *
     * @return the customHostname value
     */
    public String customHostname() {
        return this.customHostname;
    }

    /**
     * Set host to redirect. Leave empty to use the incoming host as the destination host.
     *
     * @param customHostname the customHostname value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withCustomHostname(String customHostname) {
        this.customHostname = customHostname;
        return this;
    }

    /**
     * Get the set of query strings to be placed in the redirect URL. Setting this value would replace any existing query string; leave empty to preserve the incoming query string. Query string must be in &lt;key&gt;=&lt;value&gt; format. ? and &amp; will be added automatically so do not include them.
     *
     * @return the customQueryString value
     */
    public String customQueryString() {
        return this.customQueryString;
    }

    /**
     * Set the set of query strings to be placed in the redirect URL. Setting this value would replace any existing query string; leave empty to preserve the incoming query string. Query string must be in &lt;key&gt;=&lt;value&gt; format. ? and &amp; will be added automatically so do not include them.
     *
     * @param customQueryString the customQueryString value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withCustomQueryString(String customQueryString) {
        this.customQueryString = customQueryString;
        return this;
    }

    /**
     * Get fragment to add to the redirect URL. Fragment is the part of the URL that comes after #. Do not include the #.
     *
     * @return the customFragment value
     */
    public String customFragment() {
        return this.customFragment;
    }

    /**
     * Set fragment to add to the redirect URL. Fragment is the part of the URL that comes after #. Do not include the #.
     *
     * @param customFragment the customFragment value to set
     * @return the UrlRedirectActionParameters object itself.
     */
    public UrlRedirectActionParameters withCustomFragment(String customFragment) {
        this.customFragment = customFragment;
        return this;
    }

}
