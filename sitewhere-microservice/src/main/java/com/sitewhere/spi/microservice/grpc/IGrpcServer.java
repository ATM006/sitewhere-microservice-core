/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.microservice.grpc;

import com.sitewhere.spi.microservice.lifecycle.ILifecycleComponent;

import io.grpc.BindableService;

/**
 * Wraps a GRPC server so that its lifecycle can be managed within a
 * microservice.
 */
public interface IGrpcServer extends ILifecycleComponent {

    /**
     * Get the wrapped {@link BindableService}.
     * 
     * @return
     */
    BindableService getServiceImplementation();
}