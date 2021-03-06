/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.api.device;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.common.BrandedEntity;
import com.sitewhere.rest.model.device.marshaling.MarshaledAreaType;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.area.IAreaType;

/**
 * Configurable helper class that allows {@link AreaType} model objects to be
 * created from {@link IAreaType} SPI objects.
 */
public class AreaTypeMarshalHelper {

    /** Static logger instance */
    @SuppressWarnings("unused")
    private static Logger LOGGER = LoggerFactory.getLogger(AreaTypeMarshalHelper.class);

    /** Device management */
    private IDeviceManagement deviceManagement;

    /** Indicates whether contained area types are to be included */
    private boolean includeContainedAreaTypes = false;

    public AreaTypeMarshalHelper(IDeviceManagement deviceManagement) {
	this.deviceManagement = deviceManagement;
    }

    /**
     * Convert the SPI into a model object based on marshaling parameters.
     * 
     * @param source
     * @return
     * @throws SiteWhereException
     */
    public MarshaledAreaType convert(IAreaType source) throws SiteWhereException {
	MarshaledAreaType type = new MarshaledAreaType();
	type.setName(source.getName());
	type.setDescription(source.getDescription());
	BrandedEntity.copy(source, type);
	if (isIncludeContainedAreaTypes()) {
	    type.setContainedAreaTypes(getDeviceManagement().getContainedAreaTypes(source.getId()));
	}
	return type;
    }

    public boolean isIncludeContainedAreaTypes() {
	return includeContainedAreaTypes;
    }

    public void setIncludeContainedAreaTypes(boolean includeContainedAreaTypes) {
	this.includeContainedAreaTypes = includeContainedAreaTypes;
    }

    public IDeviceManagement getDeviceManagement() {
	return deviceManagement;
    }

    public void setDeviceManagement(IDeviceManagement deviceManagement) {
	this.deviceManagement = deviceManagement;
    }
}