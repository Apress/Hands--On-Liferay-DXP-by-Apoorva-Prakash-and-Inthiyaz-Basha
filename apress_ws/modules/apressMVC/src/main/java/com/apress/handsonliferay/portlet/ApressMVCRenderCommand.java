package com.apress.handsonliferay.portlet;

import com.apress.handsonliferay.constants.ApressMVCPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inthiyaz
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ApressMVCPortletKeys.APRESSMVC,
		"mvc.command.name=/apressmvcrendercommand"
	},
	service = MVCRenderCommand.class
)
public class ApressMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("Invoking Render Command Method ");
		return "/apressmvcrendercommand.jsp";
	}
}