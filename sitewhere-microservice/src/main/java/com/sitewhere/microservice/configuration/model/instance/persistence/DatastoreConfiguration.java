/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.configuration.model.instance.persistence;

import com.fasterxml.jackson.databind.JsonNode;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * Common base class for datastore configuration.
 */
@RegisterForReflection
public class DatastoreConfiguration {

    /** Datastore type */
    private String type;

    /** Nested datasore configuration */
    private JsonNode configuration;

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public JsonNode getConfiguration() {
	return configuration;
    }

    public void setConfiguration(JsonNode configuration) {
	this.configuration = configuration;
    }
}
