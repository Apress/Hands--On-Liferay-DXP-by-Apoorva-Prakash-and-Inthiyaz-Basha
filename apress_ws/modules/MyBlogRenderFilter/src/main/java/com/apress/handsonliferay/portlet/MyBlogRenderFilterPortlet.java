package com.apress.handsonliferay.portlet;

import com.liferay.portal.kernel.model.PortletFilter;
import com.liferay.portal.kernel.util.PortletKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.RenderResponseWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inthiyaz
 */
@Component(
		 immediate = true,
		    property = {
		            "javax.portlet.name=" + PortletKeys.BLOGS
		    },
		    service = PortletFilter.class
)
public class MyBlogRenderFilterPortlet implements RenderFilter {

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
			throws IOException, PortletException {
		 RenderResponseWrapper renderResponseWrapper = new RenderResponseWrapper(response);

	        chain.doFilter(request, renderResponseWrapper);

	        String text = renderResponseWrapper.toString();

	        if (text != null) {
	            String interestingText = "<input  class=\"field form-control\"";

	            int index = text.lastIndexOf(interestingText);

	            if (index >= 0) {
	                String newText1 = text.substring(0, index);
	                String newText2 = "\n<p>Added by MyBlogs Render Filter!</p>\n";
	                String newText3 = text.substring(index);

	                String newText = newText1 + newText2 + newText3;

	                response.getWriter().write(newText);
	            }
	        }
		
	}
}

