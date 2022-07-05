/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.handsonliferay.messagebus.register;

import com.handsonliferay.messagebus.event.listener.DestinationRegisteredParallelMessageListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.MessageListener;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component (
	    immediate = true,
	    service = DestinationListenerRegistrator.class
	)
public class DestinationListenerRegistrator{

    private MessageListener _messageListener;
	private static final Log _log = LogFactoryUtil.getLog(DestinationListenerRegistrator.class);

    @Reference(target = "(destination.name="+"Destinationmessage"+")")
    private Destination _destinationParellel;
    
	@Activate
    protected void activate() {
		_messageListener = new DestinationRegisteredParallelMessageListener();
		_destinationParellel.register(_messageListener);
        _log.info("Message Listener Registered.."+_messageListener);
    }
    @Deactivate
    protected void deactivate() {
    	_destinationParellel.unregister(_messageListener);
        _log.info("Message Listener Unregistered.."+_messageListener);
    }
}