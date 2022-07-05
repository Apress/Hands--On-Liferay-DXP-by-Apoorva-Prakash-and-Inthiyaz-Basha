package com.handsonliferay.messagebus.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.handsonliferay.messagebus.constants.LiferayMessageBusPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Apoorva
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LiferayMessagebusExample",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LiferayMessageBusPortletKeys.LIFERAYMESSAGEBUSEXAMPLE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LiferayMessagebusExamplePortlet extends MVCPortlet {
}