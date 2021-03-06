/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.microservice.lifecycle;

/**
 * Provides context for a monitoring a lifecycle operation.
 */
public interface ILifecycleProgressContext {

    /**
     * Get task name for context.
     * 
     * @return
     */
    String getTaskName();

    /**
     * Get number of operations expected within context.
     * 
     * @return
     */
    int getOperationCount();

    /**
     * Get index of current operation.
     * 
     * @return
     */
    int getCurrentOperationIndex();

    /**
     * Set index of current operation.
     * 
     * @param index
     */
    void setCurrentOperationIndex(int index);

    /**
     * Get message associated with current operation.
     * 
     * @return
     */
    String getCurrentOperationMessage();

    /**
     * Set message associated with current operation.
     * 
     * @param message
     */
    void setCurrentOperationMessage(String message);
}