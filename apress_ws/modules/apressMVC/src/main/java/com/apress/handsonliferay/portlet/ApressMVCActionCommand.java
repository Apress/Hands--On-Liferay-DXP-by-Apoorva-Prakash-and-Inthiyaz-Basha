package com.apress.handsonliferay.portlet;

import com.apress.handsonliferay.constants.ApressMVCPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inthiyaz
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ApressMVCPortletKeys.APRESSMVC,
		"mvc.command.name=/apressmvcactioncommand"
	},
	service = MVCActionCommand.class
)
public class ApressMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// TODO Auto-generated method stub
		System.out.println("Invoking Action Command Method ");
		return false;
	}
}