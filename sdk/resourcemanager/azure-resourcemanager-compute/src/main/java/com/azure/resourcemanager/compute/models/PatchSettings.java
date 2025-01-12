// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The PatchSettings model. */
@Fluent
public final class PatchSettings {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PatchSettings.class);

    /*
     * Specifies the mode of in-guest patching to IaaS virtual machine.<br
     * /><br /> Possible values are:<br /><br /> **Manual** - You  control the
     * application of patches to a virtual machine. You do this by applying
     * patches manually inside the VM. In this mode, automatic updates are
     * disabled; the property WindowsConfiguration.enableAutomaticUpdates must
     * be false<br /><br /> **AutomaticByOS** - The virtual machine will
     * automatically be updated by the OS. The property
     * WindowsConfiguration.enableAutomaticUpdates must be true. <br /><br />
     * ** AutomaticByPlatform** - the virtual machine will automatically
     * updated by the platform. The properties provisionVMAgent and
     * WindowsConfiguration.enableAutomaticUpdates must be true
     */
    @JsonProperty(value = "patchMode")
    private InGuestPatchMode patchMode;

    /**
     * Get the patchMode property: Specifies the mode of in-guest patching to IaaS virtual machine.&lt;br /&gt;&lt;br
     * /&gt; Possible values are:&lt;br /&gt;&lt;br /&gt; **Manual** - You control the application of patches to a
     * virtual machine. You do this by applying patches manually inside the VM. In this mode, automatic updates are
     * disabled; the property WindowsConfiguration.enableAutomaticUpdates must be false&lt;br /&gt;&lt;br /&gt;
     * **AutomaticByOS** - The virtual machine will automatically be updated by the OS. The property
     * WindowsConfiguration.enableAutomaticUpdates must be true. &lt;br /&gt;&lt;br /&gt; ** AutomaticByPlatform** - the
     * virtual machine will automatically updated by the platform. The properties provisionVMAgent and
     * WindowsConfiguration.enableAutomaticUpdates must be true.
     *
     * @return the patchMode value.
     */
    public InGuestPatchMode patchMode() {
        return this.patchMode;
    }

    /**
     * Set the patchMode property: Specifies the mode of in-guest patching to IaaS virtual machine.&lt;br /&gt;&lt;br
     * /&gt; Possible values are:&lt;br /&gt;&lt;br /&gt; **Manual** - You control the application of patches to a
     * virtual machine. You do this by applying patches manually inside the VM. In this mode, automatic updates are
     * disabled; the property WindowsConfiguration.enableAutomaticUpdates must be false&lt;br /&gt;&lt;br /&gt;
     * **AutomaticByOS** - The virtual machine will automatically be updated by the OS. The property
     * WindowsConfiguration.enableAutomaticUpdates must be true. &lt;br /&gt;&lt;br /&gt; ** AutomaticByPlatform** - the
     * virtual machine will automatically updated by the platform. The properties provisionVMAgent and
     * WindowsConfiguration.enableAutomaticUpdates must be true.
     *
     * @param patchMode the patchMode value to set.
     * @return the PatchSettings object itself.
     */
    public PatchSettings withPatchMode(InGuestPatchMode patchMode) {
        this.patchMode = patchMode;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
