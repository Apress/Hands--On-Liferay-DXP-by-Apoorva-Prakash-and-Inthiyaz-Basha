package com.apress.handsonliferay.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HelloApressPortlet extends GenericPortlet {
	
	private static int myRenderCount = 0;
	private static int myActionCount = 0;
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		synchronized (this) {
			myRenderCount++;
		}
		response.getWriter().print("<form action="+response.createActionURL()+">"
				+"<p> Show the Render Count <b>"+myRenderCount+"</b></p>"
				+"<p> Show the Action Count <b>"+myActionCount+"</b></p>"
				+"<input type='submit'/></form>");
	}
	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		synchronized (this) {
			myActionCount++;
		}
	}
	@Override
	public void processEvent(EventRequest request, EventResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.processEvent(request, response);
	}
	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.doView(request, response);
	}
	@Override
	protected void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.doEdit(request, response);
	}
	@Override
	protected void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.doHelp(request, response);
	}
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
	}
}
