/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.microservice.tenant;

import java.io.Serializable;

import com.sitewhere.spi.microservice.lifecycle.LifecycleComponentType;
import com.sitewhere.spi.microservice.lifecycle.LifecycleStatus;

/**
 * Interface for tenant engine components.
 */
public interface ITenantEngineComponent extends Serializable {

    /**
     * Get component id.
     * 
     * @return
     */
    String getId();

    /**
     * Get component name.
     * 
     * @return
     */
    String getName();

    /**
     * Get component type.
     * 
     * @return
     */
    LifecycleComponentType getType();

    /**
     * Get component status.
     * 
     * @return
     */
    LifecycleStatus getStatus();

    /**
     * Get parent component id.
     * 
     * @return
     */
    String getParentId();
}