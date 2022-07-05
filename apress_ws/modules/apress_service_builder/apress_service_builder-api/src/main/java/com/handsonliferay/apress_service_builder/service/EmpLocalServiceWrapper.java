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
 * Provides a wrapper for {@link EmpLocalService}.
 *
 * @author Apoorva_Inthiyaz
 * @see EmpLocalService
 * @generated
 */
public class EmpLocalServiceWrapper
	implements EmpLocalService, ServiceWrapper<EmpLocalService> {

	public EmpLocalServiceWrapper(EmpLocalService empLocalService) {
		_empLocalService = empLocalService;
	}

	/**
	 * Adds the emp to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emp the emp
	 * @return the emp that was added
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp addEmp(
		com.handsonliferay.apress_service_builder.model.Emp emp) {

		return _empLocalService.addEmp(emp);
	}

	/**
	 * Creates a new emp with the primary key. Does not add the emp to the database.
	 *
	 * @param EmpId the primary key for the new emp
	 * @return the new emp
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp createEmp(
		long EmpId) {

		return _empLocalService.createEmp(EmpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the emp from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emp the emp
	 * @return the emp that was removed
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp deleteEmp(
		com.handsonliferay.apress_service_builder.model.Emp emp) {

		return _empLocalService.deleteEmp(emp);
	}

	/**
	 * Deletes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param EmpId the primary key of the emp
	 * @return the emp that was removed
	 * @throws PortalException if a emp with the primary key could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp deleteEmp(
			long EmpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empLocalService.deleteEmp(EmpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _empLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _empLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empLocalService.dynamicQuery();
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

		return _empLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.handsonliferay.apress_service_builder.model.impl.EmpModelImpl</code>.
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

		return _empLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.handsonliferay.apress_service_builder.model.impl.EmpModelImpl</code>.
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

		return _empLocalService.dynamicQuery(
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

		return _empLocalService.dynamicQueryCount(dynamicQuery);
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

		return _empLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.handsonliferay.apress_service_builder.model.Emp fetchEmp(
		long EmpId) {

		return _empLocalService.fetchEmp(EmpId);
	}

	/**
	 * Returns the emp matching the UUID and group.
	 *
	 * @param uuid the emp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp
		fetchEmpByUuidAndGroupId(String uuid, long groupId) {

		return _empLocalService.fetchEmpByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _empLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the emp with the primary key.
	 *
	 * @param EmpId the primary key of the emp
	 * @return the emp
	 * @throws PortalException if a emp with the primary key could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp getEmp(
			long EmpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empLocalService.getEmp(EmpId);
	}

	/**
	 * Returns the emp matching the UUID and group.
	 *
	 * @param uuid the emp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emp
	 * @throws PortalException if a matching emp could not be found
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp
			getEmpByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empLocalService.getEmpByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.handsonliferay.apress_service_builder.model.impl.EmpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @return the range of emps
	 */
	@Override
	public java.util.List<com.handsonliferay.apress_service_builder.model.Emp>
		getEmps(int start, int end) {

		return _empLocalService.getEmps(start, end);
	}

	/**
	 * Returns all the emps matching the UUID and company.
	 *
	 * @param uuid the UUID of the emps
	 * @param companyId the primary key of the company
	 * @return the matching emps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.handsonliferay.apress_service_builder.model.Emp>
		getEmpsByUuidAndCompanyId(String uuid, long companyId) {

		return _empLocalService.getEmpsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of emps matching the UUID and company.
	 *
	 * @param uuid the UUID of the emps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching emps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.handsonliferay.apress_service_builder.model.Emp>
		getEmpsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.handsonliferay.apress_service_builder.model.Emp>
					orderByComparator) {

		return _empLocalService.getEmpsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of emps.
	 *
	 * @return the number of emps
	 */
	@Override
	public int getEmpsCount() {
		return _empLocalService.getEmpsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _empLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _empLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the emp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emp the emp
	 * @return the emp that was updated
	 */
	@Override
	public com.handsonliferay.apress_service_builder.model.Emp updateEmp(
		com.handsonliferay.apress_service_builder.model.Emp emp) {

		return _empLocalService.updateEmp(emp);
	}

	@Override
	public EmpLocalService getWrappedService() {
		return _empLocalService;
	}

	@Override
	public void setWrappedService(EmpLocalService empLocalService) {
		_empLocalService = empLocalService;
	}

	private EmpLocalService _empLocalService;

}