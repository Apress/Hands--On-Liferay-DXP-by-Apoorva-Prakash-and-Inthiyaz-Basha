package com.apress.handsonliferay.portlet;

import com.apress.handsonliferay.constants.ApressMVCPortletKeys;
import com.handsonliferay.apress_service_builder.model.ApressBook;
import com.handsonliferay.apress_service_builder.model.impl.ApressBookImpl;
import com.handsonliferay.apress_service_builder.service.ApressBookLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoRow;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoRowLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inthiyaz
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ApressMVC",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ApressMVCPortletKeys.APRESSMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ApressMVCPortlet extends MVCPortlet {
	
	public void firstAction(
			ActionRequest actionRequest, ActionResponse actionResponse) {
		
		
		System.out.println("Invoking first Action");
	}

	public void secondAction(
			ActionRequest actionRequest, ActionResponse actionResponse) {

		System.out.println("Invoking second Action");
	}

	@ProcessAction(name = "nameForMoreActionsMethod")
	public void moreActionsMethod(
			ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Invoking nameForMoreActionsMethod ");
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String mvcPath = renderRequest.getParameter("mvcPath");
		System.out.println("MVC Path "+mvcPath);
		
		ApressBook apressBook = new ApressBookImpl();
			apressBook.setBookId(CounterLocalServiceUtil.increment());
			apressBook.setChapterName("Liferay");
			apressBook.setCreateDate(new Date());
			apressBook.setIsCoding(true);
		ApressBookLocalServiceUtil.addApressBook(apressBook);
		
		
		/*
		 * ApressBook apressBook1 = ApressBookLocalServiceUtil.fetchApressBook(1234);
		 * 
		 * apressBook1.setChapterName("HandsOnliferay");
		 * 
		 * ApressBookLocalServiceUtil.updateApressBook(apressBook1);
		 * 
		 * ApressBook apressBook1 = ApressBookLocalServiceUtil.fetchApressBook(1234);
		 * 
		 * apressBook1.setChapterName("HandsOnliferay");
		 */
		
		//Method one by using book Id
		/*
		 * ApressBookLocalServiceUtil.deleteApressBook(1234);
		 * 
		 * //Method two by using object ApressBook apressBookOb =
		 * ApressBookLocalServiceUtil.fetchApressBook(1234);
		 * ApressBookLocalServiceUtil.deleteApressBook(apressBookOb);
		 */
		
		try {
			Collection<ApressBook> apressBookObj = ApressBookLocalServiceUtil.findByisCoding(false);
			
			DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class, "user",
					PortalClassLoaderUtil.getClassLoader());
			userQuery.add(RestrictionsFactoryUtil.like("user.emailAddress", "test%"));
			try {
				List<User> customUsersList = UserLocalServiceUtil.dynamicQuery(userQuery);
				for (User user : customUsersList) {
					System.out.println("ID: " + user.getUserId() + " Name: " + user.getFirstName() + " Email ID: " + user.getEmailAddress());
				}
			} catch (SystemException e) {
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(renderRequest, renderResponse);
	}
	public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
    throws IOException, PortletException {
 
	   System.out.println("START... Process Expando...");
	    ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 
	    ExpandoTable userExpandoTable = getOrAddExpandoTable(themeDisplay.getCompanyId(), User.class.getName(),
	    		ExpandoTableConstants.DEFAULT_TABLE_NAME);
	 
	   System.out.println("User Expando Table ID : " + userExpandoTable.getTableId());
	 
	    ExpandoColumn designationExpandoColumn = getOrAddExpandoColumn(themeDisplay.getCompanyId(), User.class.getName(), 
	    		ExpandoTableConstants.DEFAULT_TABLE_NAME, "Designation", userExpandoTable);
	 
	   System.out.println("Designation Expando Column ID : " + designationExpandoColumn.getColumnId());
	   System.out.println("DONE... Process Expando...");
	    include(viewTemplate, renderRequest, renderResponse);
	}

	public ExpandoTable getOrAddExpandoTable(long companyId, String className, String tableName) {
	    ExpandoTable expandoTable = null;
	    try {
	        expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);
	    } catch (NoSuchTableException e) {
	        try {
	            expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId, className, tableName);
	        } catch (Exception e1) {
	           }
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	    return expandoTable;
	}
	 
	public ExpandoColumn getOrAddExpandoColumn(long companyId, String className, String tableName, String columnName,
	        ExpandoTable expandoTable) {
	    ExpandoColumn exandoColumn = null;
	    try {
	        exandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
	        if (exandoColumn == null) {
	            exandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), columnName,
	                    ExpandoColumnConstants.STRING, StringPool.BLANK);
	        }
	    } catch (SystemException e) {
	    	System.out.println(e);
	    } catch (PortalException e) {
	    	System.out.println(e);
	    }       
	    return exandoColumn;
	}
	
	public ExpandoRow getOrAddExpandoRow(long tableId,long rowId , long classPK) {
		ExpandoRow expandoRow = null;
		
		try {
			expandoRow = ExpandoRowLocalServiceUtil.getRow(rowId);
			if(expandoRow ==null) {
			expandoRow	= ExpandoRowLocalServiceUtil.addRow(tableId, classPK);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expandoRow;
	}
	
	public void getExpandoValue(long companyId,long classNameId, long tableName) {
		
		ExpandoValue expandoValue =  ExpandoValueLocalServiceUtil.getValue(companyId, classNameId, tableName);
	}
	

	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
			System.out.println("Invoking Resource Method ");
			resourceResponse.setContentType("text/csv");
			resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,
		      "attachment;filename=apressMVCResource.csv");
			OutputStream out = resourceResponse.getPortletOutputStream();
			out.flush();
			System.out.println("Resource File Downloaded Successfully ");
	}	
}