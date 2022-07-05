package com.apress.handsonliferay.ipc.sender.portlet;

import com.apress.handsonliferay.ipc.sender.constants.ApressIPCSenderPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inthiyaz
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.ipc",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=ApressIPCSender",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ApressIPCSenderPortletKeys.APRESSIPCSENDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=inputMessage",
		"javax.portlet.supported-publishing-event=produceMessage;http://inthiyaz.com"
	},
	service = Portlet.class
)
public class ApressIPCSenderPortlet extends MVCPortlet {

	public void passMessage(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String passMessageVal = ParamUtil.getString(actionRequest, "inputMessage","");
		actionResponse.getRenderParameters().setValue("inputMessage", passMessageVal);
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletSession portletSession = renderRequest.getPortletSession();
		portletSession.setAttribute("Liferay_Shared_Session_Para", "Session Param", PortletSession.APPLICATION_SCOPE);
		super.doView(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "producerevent")
	public void producerEvent(ActionRequest actionRequest,ActionResponse actionResponse) {
		String message = ParamUtil.getString(actionRequest, "eventmessage","");
		QName qName = new QName("http://inthiyaz.com","produceMessage");
		System.out.println("----"+message);
		actionResponse.setEvent(qName, message);
	}

}