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

package com.handsonliferay.apress_service_builder.service.persistence;

import com.handsonliferay.apress_service_builder.model.ApressBook;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the apress book service. This utility wraps <code>com.handsonliferay.apress_service_builder.service.persistence.impl.ApressBookPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBookPersistence
 * @generated
 */
public class ApressBookUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ApressBook apressBook) {
		getPersistence().clearCache(apressBook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ApressBook> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ApressBook> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApressBook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApressBook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApressBook update(ApressBook apressBook) {
		return getPersistence().update(apressBook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApressBook update(
		ApressBook apressBook, ServiceContext serviceContext) {

		return getPersistence().update(apressBook, serviceContext);
	}

	/**
	 * Returns all the apress books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching apress books
	 */
	public static List<ApressBook> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the apress books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @return the range of matching apress books
	 */
	public static List<ApressBook> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the apress books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching apress books
	 */
	public static List<ApressBook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the apress books where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching apress books
	 */
	public static List<ApressBook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByUuid_First(
			String uuid, OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByUuid_First(
		String uuid, OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByUuid_Last(
			String uuid, OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByUuid_Last(
		String uuid, OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the apress books before and after the current apress book in the ordered set where uuid = &#63;.
	 *
	 * @param bookId the primary key of the current apress book
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public static ApressBook[] findByUuid_PrevAndNext(
			long bookId, String uuid,
			OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUuid_PrevAndNext(
			bookId, uuid, orderByComparator);
	}

	/**
	 * Removes all the apress books where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of apress books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching apress books
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchApressBookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByUUID_G(String uuid, long groupId)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the apress book where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the apress book that was removed
	 */
	public static ApressBook removeByUUID_G(String uuid, long groupId)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of apress books where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching apress books
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching apress books
	 */
	public static List<ApressBook> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @return the range of matching apress books
	 */
	public static List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching apress books
	 */
	public static List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching apress books
	 */
	public static List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the apress books before and after the current apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bookId the primary key of the current apress book
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public static ApressBook[] findByUuid_C_PrevAndNext(
			long bookId, String uuid, long companyId,
			OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByUuid_C_PrevAndNext(
			bookId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the apress books where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching apress books
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the apress books where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the matching apress books
	 */
	public static List<ApressBook> findByIsCoding(boolean isCoding) {
		return getPersistence().findByIsCoding(isCoding);
	}

	/**
	 * Returns a range of all the apress books where isCoding = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param isCoding the is coding
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @return the range of matching apress books
	 */
	public static List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end) {

		return getPersistence().findByIsCoding(isCoding, start, end);
	}

	/**
	 * Returns an ordered range of all the apress books where isCoding = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param isCoding the is coding
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching apress books
	 */
	public static List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().findByIsCoding(
			isCoding, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the apress books where isCoding = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param isCoding the is coding
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching apress books
	 */
	public static List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end,
		OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsCoding(
			isCoding, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByIsCoding_First(
			boolean isCoding, OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByIsCoding_First(
			isCoding, orderByComparator);
	}

	/**
	 * Returns the first apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByIsCoding_First(
		boolean isCoding, OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().fetchByIsCoding_First(
			isCoding, orderByComparator);
	}

	/**
	 * Returns the last apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public static ApressBook findByIsCoding_Last(
			boolean isCoding, OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByIsCoding_Last(
			isCoding, orderByComparator);
	}

	/**
	 * Returns the last apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public static ApressBook fetchByIsCoding_Last(
		boolean isCoding, OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().fetchByIsCoding_Last(
			isCoding, orderByComparator);
	}

	/**
	 * Returns the apress books before and after the current apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param bookId the primary key of the current apress book
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public static ApressBook[] findByIsCoding_PrevAndNext(
			long bookId, boolean isCoding,
			OrderByComparator<ApressBook> orderByComparator)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByIsCoding_PrevAndNext(
			bookId, isCoding, orderByComparator);
	}

	/**
	 * Removes all the apress books where isCoding = &#63; from the database.
	 *
	 * @param isCoding the is coding
	 */
	public static void removeByIsCoding(boolean isCoding) {
		getPersistence().removeByIsCoding(isCoding);
	}

	/**
	 * Returns the number of apress books where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the number of matching apress books
	 */
	public static int countByIsCoding(boolean isCoding) {
		return getPersistence().countByIsCoding(isCoding);
	}

	/**
	 * Caches the apress book in the entity cache if it is enabled.
	 *
	 * @param apressBook the apress book
	 */
	public static void cacheResult(ApressBook apressBook) {
		getPersistence().cacheResult(apressBook);
	}

	/**
	 * Caches the apress books in the entity cache if it is enabled.
	 *
	 * @param apressBooks the apress books
	 */
	public static void cacheResult(List<ApressBook> apressBooks) {
		getPersistence().cacheResult(apressBooks);
	}

	/**
	 * Creates a new apress book with the primary key. Does not add the apress book to the database.
	 *
	 * @param bookId the primary key for the new apress book
	 * @return the new apress book
	 */
	public static ApressBook create(long bookId) {
		return getPersistence().create(bookId);
	}

	/**
	 * Removes the apress book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book that was removed
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public static ApressBook remove(long bookId)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().remove(bookId);
	}

	public static ApressBook updateImpl(ApressBook apressBook) {
		return getPersistence().updateImpl(apressBook);
	}

	/**
	 * Returns the apress book with the primary key or throws a <code>NoSuchApressBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public static ApressBook findByPrimaryKey(long bookId)
		throws com.handsonliferay.apress_service_builder.exception.
			NoSuchApressBookException {

		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	 * Returns the apress book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book, or <code>null</code> if a apress book with the primary key could not be found
	 */
	public static ApressBook fetchByPrimaryKey(long bookId) {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	/**
	 * Returns all the apress books.
	 *
	 * @return the apress books
	 */
	public static List<ApressBook> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the apress books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @return the range of apress books
	 */
	public static List<ApressBook> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the apress books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of apress books
	 */
	public static List<ApressBook> findAll(
		int start, int end, OrderByComparator<ApressBook> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the apress books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApressBookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of apress books
	 * @param end the upper bound of the range of apress books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of apress books
	 */
	public static List<ApressBook> findAll(
		int start, int end, OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the apress books from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of apress books.
	 *
	 * @return the number of apress books
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApressBookPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ApressBookPersistence _persistence;

}