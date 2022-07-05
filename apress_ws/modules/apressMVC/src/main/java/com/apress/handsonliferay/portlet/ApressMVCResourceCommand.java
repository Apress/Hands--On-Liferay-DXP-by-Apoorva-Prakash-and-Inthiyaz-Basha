package com.apress.handsonliferay.portlet;

import com.apress.handsonliferay.constants.ApressMVCPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inthiyaz
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ApressMVCPortletKeys.APRESSMVC,
		"mvc.command.name=/apressmvcresourcecommand"
	},
	service = MVCResourceCommand.class
)
public class ApressMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		System.out.println("Invoking Resource Method ");
		  resourceResponse.setContentType("text/csv");
		   resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,
		      "attachment;filename=apressMVCResourceCommadFile.csv");
		   OutputStream out;
		try {
			out = resourceResponse.getPortletOutputStream();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	
}