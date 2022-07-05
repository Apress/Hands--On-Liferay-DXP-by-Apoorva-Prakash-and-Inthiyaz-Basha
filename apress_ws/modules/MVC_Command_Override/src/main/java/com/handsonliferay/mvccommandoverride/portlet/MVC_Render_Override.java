package com.handsonliferay.mvccommandoverride.portlet;

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.constants.MVCRenderConstants;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Apoorva_Inthiyaz
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BlogsPortletKeys.BLOGS,
	        "javax.portlet.name=" + BlogsPortletKeys.BLOGS_ADMIN,
	        "javax.portlet.name=" + BlogsPortletKeys.BLOGS_AGGREGATOR,
	        "mvc.command.name=/blogs/edit_entry"
	    },
	    service = MVCRenderCommand.class
	)
public class MVC_Render_Override implements MVCRenderCommand {

	 @Override
	    public String render(
	        RenderRequest renderRequest, RenderResponse renderResponse) throws
	            PortletException {

	        System.out.println("Rendering custom_edit_entry.jsp");

	        RequestDispatcher requestDispatcher =
	            servletContext.getRequestDispatcher("/custom_edit_entry.jsp");

	        try {
	            HttpServletRequest httpServletRequest = 
	                PortalUtil.getHttpServletRequest(renderRequest);
	            HttpServletResponse httpServletResponse = 
	                PortalUtil.getHttpServletResponse(renderResponse);

	            requestDispatcher.include
	                (httpServletRequest, httpServletResponse);
	        } catch (Exception e) {
	            throw new PortletException
	                ("Unable to include custom_edit_entry.jsp", e);
	        }

	        return MVCRenderConstants.MVC_PATH_VALUE_SKIP_DISPATCH;
	    }
	 
	    @Reference(target = "(osgi.web.symbolicname=com.custom.code.web)")
	    protected ServletContext servletContext;
	    
	    @Reference(target = "(component.name=com.liferay.blogs.web.internal.portlet.action.EditEntryMVCRenderCommand)")
	    protected MVCRenderCommand mvcRenderCommand;
}

