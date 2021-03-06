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

package com.handsonliferay.messagebus.portlet.action;

import com.handsonliferay.messagebus.constants.LiferayMessageBusPortletKeys;
import com.handsonliferay.messagebus.service.MessageSenderServiceImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationStatistics;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Wilson S. Man
 * @author Thiago Moreira
 * @author Juan Fernández
 * @author Zsolt Berentey
 * @author Levente Hudák
 */

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + LiferayMessageBusPortletKeys.LIFERAYMESSAGEBUSEXAMPLE,
			"mvc.command.name=/destination/statistics"
	},
	service = MVCActionCommand.class
)
public class DestinationStatisticsMVCActionCommand extends BaseMVCActionCommand {

	
	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String destinationName = ParamUtil.getString(actionRequest, "destination");
		DestinationStatistics dstats = messageSenderService.getDestinationStatistics(destinationName);
		
		if(Validator.isNotNull(dstats)) {
			actionRequest.setAttribute("destinationStats", dstats);
			actionRequest.setAttribute("listeners", messageSenderService.getListeners(destinationName));
		}
		actionResponse.setRenderParameter("mvcRenderCommandName", "/view/destination_statistics");
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
		DestinationStatisticsMVCActionCommand.class);
	@Reference
    private MessageSenderServiceImpl messageSenderService;
}