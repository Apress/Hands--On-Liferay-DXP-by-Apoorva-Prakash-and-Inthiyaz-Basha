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

import com.handsonliferay.apress_service_builder.exception.NoSuchApressBookException;
import com.handsonliferay.apress_service_builder.model.ApressBook;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the apress book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBookUtil
 * @generated
 */
@ProviderType
public interface ApressBookPersistence extends BasePersistence<ApressBook> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApressBookUtil} to access the apress book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the apress books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching apress books
	 */
	public java.util.List<ApressBook> findByUuid(String uuid);

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
	public java.util.List<ApressBook> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ApressBook> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

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
	public java.util.List<ApressBook> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

	/**
	 * Returns the apress books before and after the current apress book in the ordered set where uuid = &#63;.
	 *
	 * @param bookId the primary key of the current apress book
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public ApressBook[] findByUuid_PrevAndNext(
			long bookId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Removes all the apress books where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of apress books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching apress books
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchApressBookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByUUID_G(String uuid, long groupId)
		throws NoSuchApressBookException;

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the apress book where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the apress book that was removed
	 */
	public ApressBook removeByUUID_G(String uuid, long groupId)
		throws NoSuchApressBookException;

	/**
	 * Returns the number of apress books where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching apress books
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching apress books
	 */
	public java.util.List<ApressBook> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

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
	public java.util.List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

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
	public ApressBook[] findByUuid_C_PrevAndNext(
			long bookId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Removes all the apress books where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching apress books
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the apress books where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the matching apress books
	 */
	public java.util.List<ApressBook> findByIsCoding(boolean isCoding);

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
	public java.util.List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end);

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
	public java.util.List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

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
	public java.util.List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByIsCoding_First(
			boolean isCoding,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Returns the first apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByIsCoding_First(
		boolean isCoding,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

	/**
	 * Returns the last apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	public ApressBook findByIsCoding_Last(
			boolean isCoding,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Returns the last apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	public ApressBook fetchByIsCoding_Last(
		boolean isCoding,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

	/**
	 * Returns the apress books before and after the current apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param bookId the primary key of the current apress book
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public ApressBook[] findByIsCoding_PrevAndNext(
			long bookId, boolean isCoding,
			com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
				orderByComparator)
		throws NoSuchApressBookException;

	/**
	 * Removes all the apress books where isCoding = &#63; from the database.
	 *
	 * @param isCoding the is coding
	 */
	public void removeByIsCoding(boolean isCoding);

	/**
	 * Returns the number of apress books where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the number of matching apress books
	 */
	public int countByIsCoding(boolean isCoding);

	/**
	 * Caches the apress book in the entity cache if it is enabled.
	 *
	 * @param apressBook the apress book
	 */
	public void cacheResult(ApressBook apressBook);

	/**
	 * Caches the apress books in the entity cache if it is enabled.
	 *
	 * @param apressBooks the apress books
	 */
	public void cacheResult(java.util.List<ApressBook> apressBooks);

	/**
	 * Creates a new apress book with the primary key. Does not add the apress book to the database.
	 *
	 * @param bookId the primary key for the new apress book
	 * @return the new apress book
	 */
	public ApressBook create(long bookId);

	/**
	 * Removes the apress book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book that was removed
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public ApressBook remove(long bookId) throws NoSuchApressBookException;

	public ApressBook updateImpl(ApressBook apressBook);

	/**
	 * Returns the apress book with the primary key or throws a <code>NoSuchApressBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	public ApressBook findByPrimaryKey(long bookId)
		throws NoSuchApressBookException;

	/**
	 * Returns the apress book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book, or <code>null</code> if a apress book with the primary key could not be found
	 */
	public ApressBook fetchByPrimaryKey(long bookId);

	/**
	 * Returns all the apress books.
	 *
	 * @return the apress books
	 */
	public java.util.List<ApressBook> findAll();

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
	public java.util.List<ApressBook> findAll(int start, int end);

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
	public java.util.List<ApressBook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator);

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
	public java.util.List<ApressBook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApressBook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the apress books from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of apress books.
	 *
	 * @return the number of apress books
	 */
	public int countAll();

}