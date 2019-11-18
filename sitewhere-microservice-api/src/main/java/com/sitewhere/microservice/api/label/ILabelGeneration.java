/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.api.label;

import java.util.UUID;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.label.ILabel;
import com.sitewhere.spi.microservice.lifecycle.ITenantEngineLifecycleComponent;

/**
 * Management interface for label generation.
 */
public interface ILabelGeneration extends ITenantEngineLifecycleComponent {

    /**
     * For a given generator, get the customer type label.
     * 
     * @param labelGeneratorId
     * @param customerTypeId
     * @return
     * @throws SiteWhereException
     */
    ILabel getCustomerTypeLabel(String labelGeneratorId, UUID customerTypeId) throws SiteWhereException;

    /**
     * For a given generator, get the customer label.
     * 
     * @param labelGeneratorId
     * @param customerId
     * @return
     * @throws SiteWhereException
     */
    ILabel getCustomerLabel(String labelGeneratorId, UUID customerId) throws SiteWhereException;

    /**
     * For a given generator, get the area type label.
     * 
     * @param labelGeneratorId
     * @param areaTypeId
     * @return
     * @throws SiteWhereException
     */
    ILabel getAreaTypeLabel(String labelGeneratorId, UUID areaTypeId) throws SiteWhereException;

    /**
     * For a given generator, get the area label.
     * 
     * @param labelGeneratorId
     * @param areaId
     * @return
     * @throws SiteWhereException
     */
    ILabel getAreaLabel(String labelGeneratorId, UUID areaId) throws SiteWhereException;

    /**
     * For a given generator, get the device type label.
     * 
     * @param labelGeneratorId
     * @param deviceTypeId
     * @return
     * @throws SiteWhereException
     */
    ILabel getDeviceTypeLabel(String labelGeneratorId, UUID deviceTypeId) throws SiteWhereException;

    /**
     * For a given generator, get the device label.
     * 
     * @param labelGeneratorId
     * @param deviceId
     * @return
     * @throws SiteWhereException
     */
    ILabel getDeviceLabel(String labelGeneratorId, UUID deviceId) throws SiteWhereException;

    /**
     * For a given generator, get the device group label.
     * 
     * @param labelGeneratorId
     * @param deviceGroupId
     * @return
     * @throws SiteWhereException
     */
    ILabel getDeviceGroupLabel(String labelGeneratorId, UUID deviceGroupId) throws SiteWhereException;

    /**
     * For a given generator, get the device assignment label.
     * 
     * @param labelGeneratorId
     * @param deviceAssignmentId
     * @return
     * @throws SiteWhereException
     */
    ILabel getDeviceAssignmentLabel(String labelGeneratorId, UUID deviceAssignmentId) throws SiteWhereException;

    /**
     * For a given generator, get the asset type label.
     * 
     * @param labelGeneratorId
     * @param assetTypeId
     * @return
     * @throws SiteWhereException
     */
    ILabel getAssetTypeLabel(String labelGeneratorId, UUID assetTypeId) throws SiteWhereException;

    /**
     * For a given generator, get the asset label.
     * 
     * @param labelGeneratorId
     * @param assetId
     * @return
     * @throws SiteWhereException
     */
    ILabel getAssetLabel(String labelGeneratorId, UUID assetId) throws SiteWhereException;
}