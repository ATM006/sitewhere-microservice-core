/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.microservice.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.microservice.security.ITokenManagement;
import com.sitewhere.spi.user.IRole;
import com.sitewhere.spi.user.IUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * Manages creation and validation of JWT tokens.
 */
@ApplicationScoped
public class TokenManagement implements ITokenManagement {

    /** Token issuer */
    private static final String ISSUER = "sitewhere";

    /** Claim identifier for granted authorities */
    private static final String CLAIM_GRANTED_AUTHORITIES = "auth";

    /** Secret used for encoding */
    private String secret = "secret";

    /** Signature algorithm */
    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.microservice.spi.security.ITokenManagement#generateToken(
     * com.sitewhere.spi.user.IUser)
     */
    public String generateToken(IUser user, int expirationInMinutes) throws SiteWhereException {
	try {
	    JwtBuilder builder = Jwts.builder().setIssuer(ISSUER).setSubject(user.getUsername()).setIssuedAt(new Date())
		    .setExpiration(getExpirationDate(expirationInMinutes)).signWith(SIGNATURE_ALGORITHM, getSecret());
	    builder.claim(CLAIM_GRANTED_AUTHORITIES, getAuthorities(user));
	    return builder.compact();
	} catch (Throwable t) {
	    throw new SiteWhereException("Unable to generate JWT.", t);
	}
    }

    private List<String> getAuthorities(IUser user) {
	List<String> authorities = new ArrayList<>();
	for (IRole role : user.getRoles()) {
	    List<String> authoritiesToAdd = role.getAuthorities().stream().map(result -> result.getAuthority())
		    .collect(Collectors.toList());
	    authorities.addAll(authoritiesToAdd);
	}
	return authorities;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.microservice.spi.security.ITokenManagement#
     * getClaimsForToken(java.lang.String)
     */
    public Claims getClaimsForToken(String token) throws SiteWhereException {
	try {
	    return Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token).getBody();
	} catch (ExpiredJwtException e) {
	    throw new JwtExpiredException("JWT has expired.", e);
	} catch (UnsupportedJwtException e) {
	    throw new InvalidJwtException("JWT not in supported format.", e);
	} catch (MalformedJwtException e) {
	    throw new InvalidJwtException("JWT not correctly formatted.", e);
	} catch (Throwable t) {
	    throw new SiteWhereException("Error decoding JWT.", t);
	}
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.microservice.spi.security.ITokenManagement#
     * getUsernameFromToken(java.lang.String)
     */
    public String getUsernameFromToken(String token) throws SiteWhereException {
	return getUsernameFromClaims(getClaimsForToken(token));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sitewhere.microservice.spi.security.ITokenManagement#
     * getUsernameFromClaims(io.jsonwebtoken.Claims)
     */
    @Override
    public String getUsernameFromClaims(Claims claims) throws SiteWhereException {
	return claims.getSubject();
    }

    /*
     * @see com.sitewhere.spi.microservice.security.ITokenManagement#
     * getGrantedAuthoritiesFromToken(java.lang.String)
     */
    public List<String> getGrantedAuthoritiesFromToken(String token) throws SiteWhereException {
	return getGrantedAuthoritiesFromClaims(getClaimsForToken(token));
    }

    /*
     * @see com.sitewhere.spi.microservice.security.ITokenManagement#
     * getGrantedAuthoritiesFromClaims(io.jsonwebtoken.Claims)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<String> getGrantedAuthoritiesFromClaims(Claims claims) throws SiteWhereException {
	return (List<String>) claims.get(CLAIM_GRANTED_AUTHORITIES, List.class);
    }

    public Date getExpirationDate(int expirationInMinutes) {
	return new Date(System.currentTimeMillis() + (expirationInMinutes * 60 * 1000));
    }

    public String getSecret() {
	return secret;
    }

    public void setSecret(String secret) {
	this.secret = secret;
    }
}