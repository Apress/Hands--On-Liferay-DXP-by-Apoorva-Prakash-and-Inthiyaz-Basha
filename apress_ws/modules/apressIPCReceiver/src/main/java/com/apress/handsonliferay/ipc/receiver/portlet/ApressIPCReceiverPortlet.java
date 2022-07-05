package com.apress.handsonliferay.ipc.receiver.portlet;

import com.apress.handsonliferay.ipc.receiver.constants.ApressIPCReceiverPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.display-name=ApressIPCReceiver",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ApressIPCReceiverPortletKeys.APRESSIPCRECEIVER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=inputMessage",
		"javax.portlet.supported-processing-event=produceMessage;http://inthiyaz.com"
	},
	service = Portlet.class
)
public class ApressIPCReceiverPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String passMessageVal =  ParamUtil.getString(renderRequest, "inputMessage","");
		System.out.println("Received Message "+passMessageVal);
		renderRequest.setAttribute("recievedMessage", passMessageVal);
		
		
		PortletSession portletSession = renderRequest.getPortletSession();
		renderRequest.setAttribute("recievedSessionMessage", 
				(String)portletSession.getAttribute("Liferay_Shared_Session_Para",PortletSession.APPLICATION_SCOPE));
		super.doView(renderRequest, renderResponse);
		}
	
	@ProcessEvent(qname = "{http://inthiyaz.com}produceMessage")
		public void consumeMessage(EventRequest eventRequest,EventResponse eventResponse) {
		Event event = eventRequest.getEvent();
		String receivedValue = (String)event.getValue();
		eventRequest.setAttribute("message", receivedValue);
		System.out.println("Event Message "+ receivedValue);
	}
}