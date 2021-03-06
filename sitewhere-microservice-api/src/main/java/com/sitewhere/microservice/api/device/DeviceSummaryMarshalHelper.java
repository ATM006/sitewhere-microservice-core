/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.api.device;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sitewhere.microservice.api.asset.IAssetManagement;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.rest.model.device.DeviceSummary;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDeviceAssignmentSummary;
import com.sitewhere.spi.device.IDeviceSummary;

/**
 * Configurable helper class that allows {@link DeviceSummary} model objects to
 * be created from {@link IDeviceSummary} SPI objects.
 */
public class DeviceSummaryMarshalHelper {

    /** Static logger instance */
    @SuppressWarnings("unused")
    private static Logger LOGGER = LoggerFactory.getLogger(DeviceSummaryMarshalHelper.class);

    /** Flag for whether to include assignment asset information */
    private boolean includeAsset = false;

    public DeviceSummary convert(IDeviceSummary api, IAssetManagement assetManagement) throws SiteWhereException {
	DeviceAssignmentSummaryMarshalHelper helper = new DeviceAssignmentSummaryMarshalHelper();
	DeviceSummary summary = new DeviceSummary();
	summary.setComments(api.getComments());
	summary.setStatus(api.getStatus());
	summary.setParentDeviceId(api.getParentDeviceId());
	summary.setDeviceTypeId(api.getDeviceTypeId());
	summary.setDeviceTypeName(api.getDeviceTypeName());
	summary.setDeviceTypeImageUrl(api.getDeviceTypeImageUrl());
	summary.setDeviceAssignmentSummaries(new ArrayList<>());
	for (IDeviceAssignmentSummary assnApi : api.getDeviceAssignmentSummaries()) {
	    summary.getDeviceAssignmentSummaries().add(helper.convert(assnApi, assetManagement));
	}
	PersistentEntity.copy(api, summary);
	return summary;
    }

    public boolean isIncludeAsset() {
	return includeAsset;
    }

    public void setIncludeAsset(boolean includeAsset) {
	this.includeAsset = includeAsset;
    }
}
