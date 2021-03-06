/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.microservice.tenant;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.microservice.lifecycle.ILifecycleComponent;
import com.sitewhere.spi.search.ISearchResults;
import com.sitewhere.spi.search.tenant.ITenantSearchCriteria;
import com.sitewhere.spi.tenant.ITenant;
import com.sitewhere.spi.tenant.request.ITenantCreateRequest;

/**
 * Interface for tenant management operations.
 */
public interface ITenantManagement extends ILifecycleComponent {

    /**
     * Create a new tenant.
     * 
     * @param request
     * @return
     * @throws SiteWhereException
     */
    ITenant createTenant(ITenantCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing tenant.
     * 
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    ITenant updateTenant(String token, ITenantCreateRequest request) throws SiteWhereException;

    /**
     * Get a tenant by tenant id.
     * 
     * @param token
     * @return
     * @throws SiteWhereException
     */
    ITenant getTenant(String token) throws SiteWhereException;

    /**
     * Find all tenants that match the given criteria.
     * 
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    ISearchResults<ITenant> listTenants(ITenantSearchCriteria criteria) throws SiteWhereException;

    /**
     * Delete an existing tenant.
     * 
     * @param token
     * @return
     * @throws SiteWhereException
     */
    ITenant deleteTenant(String token) throws SiteWhereException;
}