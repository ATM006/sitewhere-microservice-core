/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.configuration.model.instance;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * Top level of instance configuration hierarchy.
 */
@RegisterForReflection
public class InstanceConfiguration {

    /** Persistence configurations */
    private PersistenceConfigurations persistenceConfigurations;

    public PersistenceConfigurations getPersistenceConfigurations() {
	return persistenceConfigurations;
    }

    public void setPersistenceConfigurations(PersistenceConfigurations persistenceConfigurations) {
	this.persistenceConfigurations = persistenceConfigurations;
    }
}
