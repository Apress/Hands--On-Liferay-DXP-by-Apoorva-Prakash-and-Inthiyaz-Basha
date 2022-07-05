/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.handsonliferay.apress_service_builder.service;

import com.handsonliferay.apress_service_builder.model.ApressBook;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ApressBook. This utility wraps
 * <code>com.handsonliferay.apress_service_builder.service.impl.ApressBookLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBookLocalService
 * @generated
 */
public class ApressBookLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.handsonliferay.apress_service_builder.service.impl.ApressBookLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the apress book to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApressBookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apressBook the apress book
	 * @return the apress book that was added
	 */
	public static ApressBook addApressBook(ApressBook apressBook) {
		return getService().addApressBook(apressBook);
	}

	/**
	 * Creates a new apress book with the primary key. Does not add the apress book to the database.
	 *
	 * @param bookId the primary key for the new apress book
	 * @return the new apress book
	 */
	public static ApressBook createApressBook(long bookId) {
		return getService().createApressBook(bookId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the apress book from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApressBookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apressBook the apress book
	 * @return the apress book that was removed
	 */
	public static ApressBook deleteApressBook(ApressBook apressBook) {
		return getService().deleteApressBook(apressBook);
	}

	/**
	 * Deletes the apress book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApressBookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book that was removed
	 * @throws PortalException if a apress book with the primary key could not be found
	 */
	public static ApressBook deleteApressBook(long bookId)
		throws PortalException {

		return getService().deleteApressBook(bookId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.handsonliferay.apress_service_builder.model.impl.ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.handsonliferay.apress_service_builder.model.impl.ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ApressBook fetchApressBook(long bookId) {
		return getService().fetchApressBook(bookId);
	}

	/**
	 * Returns the apress book matching the UUID and group.
	 *
	 * @param uuid the apress book's UUID
	 * @param groupId the primary key of the group
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchApressBookByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchApressBookByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.Collection<ApressBook> findByisCoding(
		Boolean iscode) {

		return getService().findByisCoding(iscode);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the apress book with the primary key.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book
	 * @throws PortalException if a apress book with the primary key could not be found
	 */
	public static ApressBook getApressBook(long bookId) throws PortalException {
		return getService().getApressBook(bookId);
	}

	/**
	 * Returns the apress book matching the UUID and group.
	 *
	 * @param uuid the apress book's UUID
	 * @param groupId the primary key of the group
	 * @return the matching apress book
	 * @throws PortalException if a matching apress book could not be found
	 */
	public static ApressBook getApressBookByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getApressBookByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the apress books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.handsonliferay.apress_service_builder.model.impl.ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @return the range of apress books
	 */
	public static List<ApressBook> getApressBooks(int start, int end) {
		return getService().getApressBooks(start, end);
	}

	/**
	 * Returns all the apress books matching the UUID and company.
	 *
	 * @param uuid the UUID of the apress books
	 * @param companyId the primary key of the company
	 * @return the matching apress books, or an empty list if no matches were found
	 */
	public static List<ApressBook> getApressBooksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getApressBooksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of apress books matching the UUID and company.
	 *
	 * @param uuid the UUID of the apress books
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching apress books, or an empty list if no matches were found
	 */
	public static List<ApressBook> getApressBooksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return getService().getApressBooksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of apress books.
	 *
	 * @return the number of apress books
	 */
	public static int getApressBooksCount() {
		return getService().getApressBooksCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the apress book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApressBookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apressBook the apress book
	 * @return the apress book that was updated
	 */
	public static ApressBook updateApressBook(ApressBook apressBook) {
		return getService().updateApressBook(apressBook);
	}

	public static ApressBookLocalService getService() {
		return _service;
	}

	private static volatile ApressBookLocalService _service;

}