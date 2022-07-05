package com.handsonliferay.servicewrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Apoorva_Inthiyaz
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class UserServiceOverride extends UserLocalServiceWrapper {

	public UserServiceOverride() {
		super(null);
	}
	
	@Override
		public User addUser(long creatorUserId, long companyId, boolean autoPassword, String password1, String password2,
				boolean autoScreenName, String screenName, String emailAddress, Locale locale, String firstName,
				String middleName, String lastName, long prefixId, long suffixId, boolean male, int birthdayMonth,
				int birthdayDay, int birthdayYear, String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds,
				long[] userGroupIds, boolean sendEmail, ServiceContext serviceContext) throws PortalException {
			// TODO Auto-generated method stub
		
		System.out.println(" User First Name "+firstName);
		System.out.println(" User middle Name "+middleName);
		System.out.println("User Last Name "+lastName);
		
			return super.addUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName,
					emailAddress, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
					birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		}

	@Override
	public User getUser(long userId) throws PortalException {
	    System.out.println("Getting user by id " + userId);
	    return super.getUser(userId);
	}
	
	@Reference(unbind = "-")
	private void serviceSetter(UserLocalService userLocalService) {
	    setWrappedService(userLocalService);
	}
}


