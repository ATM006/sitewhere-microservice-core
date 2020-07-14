/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.tenant;

import com.sitewhere.microservice.lifecycle.LifecycleComponentDecorator;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.microservice.tenant.ITenantManagement;
import com.sitewhere.spi.search.ISearchResults;
import com.sitewhere.spi.search.tenant.ITenantSearchCriteria;
import com.sitewhere.spi.tenant.ITenant;
import com.sitewhere.spi.tenant.request.ITenantCreateRequest;

/**
 * Uses decorator pattern to allow behaviors to be injected around tenant
 * management API calls.
 */
public class TenantManagementDecorator extends LifecycleComponentDecorator<ITenantManagement>
	implements ITenantManagement {

    public TenantManagementDecorator(ITenantManagement delegate) {
	super(delegate);
    }

    /*
     * @see
     * com.sitewhere.spi.microservice.tenant.ITenantManagement#createTenant(com.
     * sitewhere.spi.tenant.request.ITenantCreateRequest)
     */
    @Override
    public ITenant createTenant(ITenantCreateRequest request) throws SiteWhereException {
	return getDelegate().createTenant(request);
    }

    /*
     * @see
     * com.sitewhere.spi.microservice.tenant.ITenantManagement#updateTenant(java.
     * lang.String, com.sitewhere.spi.tenant.request.ITenantCreateRequest)
     */
    @Override
    public ITenant updateTenant(String token, ITenantCreateRequest request) throws SiteWhereException {
	return getDelegate().updateTenant(token, request);
    }

    /*
     * @see
     * com.sitewhere.spi.microservice.tenant.ITenantManagement#getTenant(java.lang.
     * String)
     */
    @Override
    public ITenant getTenant(String token) throws SiteWhereException {
	return getDelegate().getTenant(token);
    }

    /*
     * @see com.sitewhere.spi.microservice.tenant.ITenantManagement#listTenants(com.
     * sitewhere.spi.search.tenant.ITenantSearchCriteria)
     */
    @Override
    public ISearchResults<ITenant> listTenants(ITenantSearchCriteria criteria) throws SiteWhereException {
	return getDelegate().listTenants(criteria);
    }

    /*
     * @see
     * com.sitewhere.spi.microservice.tenant.ITenantManagement#deleteTenant(java.
     * lang.String)
     */
    @Override
    public ITenant deleteTenant(String token) throws SiteWhereException {
	return getDelegate().deleteTenant(token);
    }
}