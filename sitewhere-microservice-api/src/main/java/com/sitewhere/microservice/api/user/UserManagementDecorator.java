/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.api.user;

import java.util.List;

import com.sitewhere.microservice.lifecycle.LifecycleComponentDecorator;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.search.ISearchResults;
import com.sitewhere.spi.user.*;
import com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest;
import com.sitewhere.spi.user.request.IRoleCreateRequest;
import com.sitewhere.spi.user.request.IUserCreateRequest;

/**
 * Uses decorator pattern to allow behaviors to be injected around user
 * management API calls.
 */
public class UserManagementDecorator extends LifecycleComponentDecorator<IUserManagement> implements IUserManagement {

    public UserManagementDecorator(IUserManagement delegate) {
	super(delegate);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.sitewhere.spi.user.IUserManagement#createUser(com.sitewhere.spi.user.
     * request.IUserCreateRequest, java.lang.Boolean)
     */
    @Override
    public IUser createUser(IUserCreateRequest request, Boolean encodePassword) throws SiteWhereException {
	return getDelegate().createUser(request, encodePassword);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.sitewhere.spi.user.IUserManagement#importUser(com.sitewhere.spi.user.
     * IUser, boolean)
     */
    @Override
    public IUser importUser(IUser user, boolean overwrite) throws SiteWhereException {
	return getDelegate().importUser(user, overwrite);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#authenticate(java.lang.String,
     * java.lang.String, boolean)
     */
    @Override
    public IUser authenticate(String username, String password, boolean updateLastLogin) throws SiteWhereException {
	return getDelegate().authenticate(username, password, updateLastLogin);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#updateUser(java.lang.String,
     * com.sitewhere.spi.user.request.IUserCreateRequest, boolean)
     */
    @Override
    public IUser updateUser(String username, IUserCreateRequest request, boolean encodePassword)
	    throws SiteWhereException {
	return getDelegate().updateUser(username, request, encodePassword);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#getUserByUsername(java.lang.
     * String)
     */
    @Override
    public IUser getUserByUsername(String username) throws SiteWhereException {
	return getDelegate().getUserByUsername(username);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#getGrantedAuthorities(java.lang.
     * String)
     */
    @Override
    public List<IGrantedAuthority> getGrantedAuthorities(String username) throws SiteWhereException {
	return getDelegate().getGrantedAuthorities(username);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#addGrantedAuthorities(java.lang.
     * String, java.util.List)
     */
    @Override
    public List<IGrantedAuthority> addGrantedAuthorities(String username, List<String> authorities)
	    throws SiteWhereException {
	return getDelegate().addGrantedAuthorities(username, authorities);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.sitewhere.spi.user.IUserManagement#removeGrantedAuthorities(java.lang
     * .String, java.util.List)
     */
    @Override
    public List<IGrantedAuthority> removeGrantedAuthorities(String username, List<String> authorities)
	    throws SiteWhereException {
	return getDelegate().removeGrantedAuthorities(username, authorities);
    }

    /*
     * @see com.sitewhere.spi.user.IUserManagement#listUsers(com.sitewhere.spi.user.
     * IUserSearchCriteria)
     */
    @Override
    public ISearchResults<IUser> listUsers(IUserSearchCriteria criteria) throws SiteWhereException {
	return getDelegate().listUsers(criteria);
    }

    /*
     * @see com.sitewhere.spi.user.IUserManagement#deleteUser(java.lang.String)
     */
    @Override
    public IUser deleteUser(String username) throws SiteWhereException {
	return getDelegate().deleteUser(username);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#createGrantedAuthority(com.
     * sitewhere.spi. user.request.IGrantedAuthorityCreateRequest)
     */
    @Override
    public IGrantedAuthority createGrantedAuthority(IGrantedAuthorityCreateRequest request) throws SiteWhereException {
	return getDelegate().createGrantedAuthority(request);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#getGrantedAuthorityByName(java.
     * lang.String)
     */
    @Override
    public IGrantedAuthority getGrantedAuthorityByName(String name) throws SiteWhereException {
	return getDelegate().getGrantedAuthorityByName(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#updateGrantedAuthority(java.lang.
     * String, com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest)
     */
    @Override
    public IGrantedAuthority updateGrantedAuthority(String name, IGrantedAuthorityCreateRequest request)
	    throws SiteWhereException {
	return getDelegate().updateGrantedAuthority(name, request);
    }

    /*
     * @see
     * com.sitewhere.spi.user.IUserManagement#listGrantedAuthorities(com.sitewhere.
     * spi.user.IGrantedAuthoritySearchCriteria)
     */
    @Override
    public ISearchResults<IGrantedAuthority> listGrantedAuthorities(IGrantedAuthoritySearchCriteria criteria)
	    throws SiteWhereException {
	return getDelegate().listGrantedAuthorities(criteria);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.spi.user.IUserManagement#deleteGrantedAuthority(java.lang.
     * String)
     */
    @Override
    public void deleteGrantedAuthority(String authority) throws SiteWhereException {
	getDelegate().deleteGrantedAuthority(authority);
    }

    @Override
    public List<IRole> getRoles(String username) throws SiteWhereException {
	return getDelegate().getRoles(username);
    }

    @Override
    public List<IRole> addRoles(String username, List<String> roles) throws SiteWhereException {
	return getDelegate().addRoles(username, roles);
    }

    @Override
    public List<IRole> removeRoles(String username, List<String> roles)
		    throws SiteWhereException {
	return getDelegate().removeRoles(username, roles);
    }

    @Override
    public IRole createRole(IRoleCreateRequest request) throws SiteWhereException {
	return getDelegate().createRole(request);
    }

    @Override
    public IRole getRoleByName(String name) throws SiteWhereException {
	return getDelegate().getRoleByName(name);
    }

    @Override
    public IRole updateRole(String name, IRoleCreateRequest request)
		    throws SiteWhereException {
	return getDelegate().updateRole(name, request);
    }

    @Override
    public ISearchResults<IRole> listRoles(IRoleSearchCriteria criteria)
		    throws SiteWhereException {
	return getDelegate().listRoles(criteria);
    }

    @Override
    public void deleteRole(String role) throws SiteWhereException {
	getDelegate().deleteRole(role);
    }
}