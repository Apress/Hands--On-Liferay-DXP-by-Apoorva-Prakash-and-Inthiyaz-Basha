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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApressBookLocalService}.
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBookLocalService
 * @generated
 */
public class ApressBookLocalServiceWrapper
	implements ApressBookLocalService, ServiceWrapper<ApressBookLocalService> {

	public ApressBookLocalServiceWrapper(
		ApressBookLocalService apressBookLocalService) {

		_apressBookLocalService = apressBookLocalService;
	}

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
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
		addApressBook(
			com.handsonliferay.apress_service_builder.model.ApressBook
				apressBook) {

		return _apressBookLocalService.addApressBook(apressBook);
	}

	/**
	 * Creates a new apress book with the primary key. Does not add the apress book to the database.
	 *
	 * @param bookId the primary key for the new apress book
	 * @return the new apress book
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
		createApressBook(long bookId) {

		return _apressBookLocalService.createApressBook(bookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apressBookLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
		deleteApressBook(
			com.handsonliferay.apress_service_builder.model.ApressBook
				apressBook) {

		return _apressBookLocalService.deleteApressBook(apressBook);
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
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
			deleteApressBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apressBookLocalService.deleteApressBook(bookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apressBookLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _apressBookLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _apressBookLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _apressBookLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _apressBookLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _apressBookLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _apressBookLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _apressBookLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _apressBookLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
		fetchApressBook(long bookId) {

		return _apressBookLocalService.fetchApressBook(bookId);
	}

	/**
	 * Returns the apress book matching the UUID and group.
	 *
	 * @param uuid the apress book's UUID
	 * @param groupId the primary key of the group
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
		fetchApressBookByUuidAndGroupId(String uuid, long groupId) {

		return _apressBookLocalService.fetchApressBookByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.Collection
		<com.handsonliferay.apress_service_builder.model.ApressBook>
			findByisCoding(Boolean iscode) {

		return _apressBookLocalService.findByisCoding(iscode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _apressBookLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the apress book with the primary key.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book
	 * @throws PortalException if a apress book with the primary key could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
			getApressBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apressBookLocalService.getApressBook(bookId);
	}

	/**
	 * Returns the apress book matching the UUID and group.
	 *
	 * @param uuid the apress book's UUID
	 * @param groupId the primary key of the group
	 * @return the matching apress book
	 * @throws PortalException if a matching apress book could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
			getApressBookByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apressBookLocalService.getApressBookByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List
		<com.handsonliferay.apress_service_builder.model.ApressBook>
			getApressBooks(int start, int end) {

		return _apressBookLocalService.getApressBooks(start, end);
	}

	/**
	 * Returns all the apress books matching the UUID and company.
	 *
	 * @param uuid the UUID of the apress books
	 * @param companyId the primary key of the company
	 * @return the matching apress books, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.handsonliferay.apress_service_builder.model.ApressBook>
			getApressBooksByUuidAndCompanyId(String uuid, long companyId) {

		return _apressBookLocalService.getApressBooksByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List
		<com.handsonliferay.apress_service_builder.model.ApressBook>
			getApressBooksByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.handsonliferay.apress_service_builder.model.ApressBook>
						orderByComparator) {

		return _apressBookLocalService.getApressBooksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of apress books.
	 *
	 * @return the number of apress books
	 */
	@Override
	public int getApressBooksCount() {
		return _apressBookLocalService.getApressBooksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _apressBookLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _apressBookLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apressBookLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.handsonliferay.apress_service_builder.model.ApressBook
		updateApressBook(
			com.handsonliferay.apress_service_builder.model.ApressBook
				apressBook) {

		return _apressBookLocalService.updateApressBook(apressBook);
	}

	@Override
	public ApressBookLocalService getWrappedService() {
		return _apressBookLocalService;
	}

	@Override
	public void setWrappedService(
		ApressBookLocalService apressBookLocalService) {

		_apressBookLocalService = apressBookLocalService;
	}

	private ApressBookLocalService _apressBookLocalService;

}