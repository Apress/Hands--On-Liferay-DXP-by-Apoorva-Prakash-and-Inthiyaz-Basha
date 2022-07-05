package com.handsonliferay.mvccommandoverride.portlet;

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Apoorva_Inthiyaz
 */
@Component(
	immediate = true,
	property = { 
		"javax.portlet.name=" + BlogsPortletKeys.BLOGS_ADMIN, 
		"mvc.command.name=/blogs/edit_entry",
		"service.ranking:Integer=100" 
		}, 
	service = MVCActionCommand.class
)
public class MVC_Action_Override extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Add your custom logic in this method
		mvcActionCommand.processAction(actionRequest, actionResponse);
	}
	@Reference(
		    target = "(component.name=com.liferay.blogs.web.internal.portlet.action.EditEntryMVCActionCommand)")
		protected MVCActionCommand mvcActionCommand;
}




