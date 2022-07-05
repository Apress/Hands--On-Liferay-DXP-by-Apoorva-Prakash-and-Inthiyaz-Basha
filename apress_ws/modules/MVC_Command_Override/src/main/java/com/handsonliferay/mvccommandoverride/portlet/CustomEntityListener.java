package com.handsonliferay.mvccommandoverride.portlet;

import com.handsonliferay.apress_service_builder.model.ApressBook;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;

/**
 * @author Apoorva_Inthiyaz
 */
@Component(
	    immediate = true,
	    service = ModelListener.class
)
public class CustomEntityListener extends BaseModelListener<ApressBook>{

   
}


