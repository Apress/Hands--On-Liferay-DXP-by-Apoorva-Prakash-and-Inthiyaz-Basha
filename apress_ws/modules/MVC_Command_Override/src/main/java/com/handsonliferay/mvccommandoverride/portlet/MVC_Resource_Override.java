package com.handsonliferay.mvccommandoverride.portlet;

import com.liferay.login.web.constants.LoginPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Apoorva_Inthiyaz
 */
@Component(
	    property = { 
	        "javax.portlet.name=" + LoginPortletKeys.LOGIN,
	        "mvc.command.name=/login/captcha"
	    }, 
	    service = MVCResourceCommand.class
)
public class MVC_Resource_Override implements MVCResourceCommand{

    @Reference(target = 
            "(component.name=com.liferay.login.web.internal.portlet.action.CaptchaMVCResourceCommand)")
        protected MVCResourceCommand mvcResourceCommand;

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		 System.out.println("Serving login captcha image");

	        return mvcResourceCommand.serveResource(resourceRequest, resourceResponse);
	}
}


