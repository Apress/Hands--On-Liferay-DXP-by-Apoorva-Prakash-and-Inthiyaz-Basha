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

package com.handsonliferay.apress_service_builder.service.persistence.impl;

import com.handsonliferay.apress_service_builder.exception.NoSuchApressBookException;
import com.handsonliferay.apress_service_builder.model.ApressBook;
import com.handsonliferay.apress_service_builder.model.ApressBookTable;
import com.handsonliferay.apress_service_builder.model.impl.ApressBookImpl;
import com.handsonliferay.apress_service_builder.model.impl.ApressBookModelImpl;
import com.handsonliferay.apress_service_builder.service.persistence.ApressBookPersistence;
import com.handsonliferay.apress_service_builder.service.persistence.ApressBookUtil;
import com.handsonliferay.apress_service_builder.service.persistence.impl.constants.apressPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the apress book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @generated
 */
@Component(service = {ApressBookPersistence.class, BasePersistence.class})
public class ApressBookPersistenceImpl
	extends BasePersistenceImpl<ApressBook> implements ApressBookPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ApressBookUtil</code> to access the apress book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ApressBookImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the apress books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching apress books
	 */
	@Override
	public List<ApressBook> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ApressBook> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ApressBook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ApressBook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ApressBook> list = null;

		if (useFinderCache) {
			list = (List<ApressBook>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ApressBook apressBook : list) {
					if (!uuid.equals(apressBook.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ApressBookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ApressBook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	@Override
	public ApressBook findByUuid_First(
			String uuid, OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByUuid_First(uuid, orderByComparator);

		if (apressBook != null) {
			return apressBook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchApressBookException(sb.toString());
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByUuid_First(
		String uuid, OrderByComparator<ApressBook> orderByComparator) {

		List<ApressBook> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	@Override
	public ApressBook findByUuid_Last(
			String uuid, OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByUuid_Last(uuid, orderByComparator);

		if (apressBook != null) {
			return apressBook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchApressBookException(sb.toString());
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByUuid_Last(
		String uuid, OrderByComparator<ApressBook> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ApressBook> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ApressBook[] findByUuid_PrevAndNext(
			long bookId, String uuid,
			OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		uuid = Objects.toString(uuid, "");

		ApressBook apressBook = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			ApressBook[] array = new ApressBookImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, apressBook, uuid, orderByComparator, true);

			array[1] = apressBook;

			array[2] = getByUuid_PrevAndNext(
				session, apressBook, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApressBook getByUuid_PrevAndNext(
		Session session, ApressBook apressBook, String uuid,
		OrderByComparator<ApressBook> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ApressBookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(apressBook)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApressBook> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apress books where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ApressBook apressBook :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(apressBook);
		}
	}

	/**
	 * Returns the number of apress books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching apress books
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APRESSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"apressBook.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(apressBook.uuid IS NULL OR apressBook.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchApressBookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	@Override
	public ApressBook findByUUID_G(String uuid, long groupId)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByUUID_G(uuid, groupId);

		if (apressBook == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchApressBookException(sb.toString());
		}

		return apressBook;
	}

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the apress book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof ApressBook) {
			ApressBook apressBook = (ApressBook)result;

			if (!Objects.equals(uuid, apressBook.getUuid()) ||
				(groupId != apressBook.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ApressBook> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ApressBook apressBook = list.get(0);

					result = apressBook;

					cacheResult(apressBook);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ApressBook)result;
		}
	}

	/**
	 * Removes the apress book where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the apress book that was removed
	 */
	@Override
	public ApressBook removeByUUID_G(String uuid, long groupId)
		throws NoSuchApressBookException {

		ApressBook apressBook = findByUUID_G(uuid, groupId);

		return remove(apressBook);
	}

	/**
	 * Returns the number of apress books where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching apress books
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APRESSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"apressBook.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(apressBook.uuid IS NULL OR apressBook.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"apressBook.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching apress books
	 */
	@Override
	public List<ApressBook> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ApressBook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ApressBook> list = null;

		if (useFinderCache) {
			list = (List<ApressBook>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ApressBook apressBook : list) {
					if (!uuid.equals(apressBook.getUuid()) ||
						(companyId != apressBook.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ApressBookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ApressBook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ApressBook findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (apressBook != null) {
			return apressBook;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchApressBookException(sb.toString());
	}

	/**
	 * Returns the first apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ApressBook> orderByComparator) {

		List<ApressBook> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ApressBook findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (apressBook != null) {
			return apressBook;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchApressBookException(sb.toString());
	}

	/**
	 * Returns the last apress book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ApressBook> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ApressBook> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ApressBook[] findByUuid_C_PrevAndNext(
			long bookId, String uuid, long companyId,
			OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		uuid = Objects.toString(uuid, "");

		ApressBook apressBook = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			ApressBook[] array = new ApressBookImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, apressBook, uuid, companyId, orderByComparator, true);

			array[1] = apressBook;

			array[2] = getByUuid_C_PrevAndNext(
				session, apressBook, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApressBook getByUuid_C_PrevAndNext(
		Session session, ApressBook apressBook, String uuid, long companyId,
		OrderByComparator<ApressBook> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ApressBookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(apressBook)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApressBook> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apress books where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ApressBook apressBook :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(apressBook);
		}
	}

	/**
	 * Returns the number of apress books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching apress books
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APRESSBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"apressBook.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(apressBook.uuid IS NULL OR apressBook.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"apressBook.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByIsCoding;
	private FinderPath _finderPathWithoutPaginationFindByIsCoding;
	private FinderPath _finderPathCountByIsCoding;

	/**
	 * Returns all the apress books where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the matching apress books
	 */
	@Override
	public List<ApressBook> findByIsCoding(boolean isCoding) {
		return findByIsCoding(
			isCoding, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end) {

		return findByIsCoding(isCoding, start, end, null);
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
	@Override
	public List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end,
		OrderByComparator<ApressBook> orderByComparator) {

		return findByIsCoding(isCoding, start, end, orderByComparator, true);
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
	@Override
	public List<ApressBook> findByIsCoding(
		boolean isCoding, int start, int end,
		OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsCoding;
				finderArgs = new Object[] {isCoding};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsCoding;
			finderArgs = new Object[] {isCoding, start, end, orderByComparator};
		}

		List<ApressBook> list = null;

		if (useFinderCache) {
			list = (List<ApressBook>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ApressBook apressBook : list) {
					if (isCoding != apressBook.isIsCoding()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

			sb.append(_FINDER_COLUMN_ISCODING_ISCODING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ApressBookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isCoding);

				list = (List<ApressBook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	@Override
	public ApressBook findByIsCoding_First(
			boolean isCoding, OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByIsCoding_First(
			isCoding, orderByComparator);

		if (apressBook != null) {
			return apressBook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isCoding=");
		sb.append(isCoding);

		sb.append("}");

		throw new NoSuchApressBookException(sb.toString());
	}

	/**
	 * Returns the first apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByIsCoding_First(
		boolean isCoding, OrderByComparator<ApressBook> orderByComparator) {

		List<ApressBook> list = findByIsCoding(
			isCoding, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book
	 * @throws NoSuchApressBookException if a matching apress book could not be found
	 */
	@Override
	public ApressBook findByIsCoding_Last(
			boolean isCoding, OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByIsCoding_Last(
			isCoding, orderByComparator);

		if (apressBook != null) {
			return apressBook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isCoding=");
		sb.append(isCoding);

		sb.append("}");

		throw new NoSuchApressBookException(sb.toString());
	}

	/**
	 * Returns the last apress book in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apress book, or <code>null</code> if a matching apress book could not be found
	 */
	@Override
	public ApressBook fetchByIsCoding_Last(
		boolean isCoding, OrderByComparator<ApressBook> orderByComparator) {

		int count = countByIsCoding(isCoding);

		if (count == 0) {
			return null;
		}

		List<ApressBook> list = findByIsCoding(
			isCoding, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ApressBook[] findByIsCoding_PrevAndNext(
			long bookId, boolean isCoding,
			OrderByComparator<ApressBook> orderByComparator)
		throws NoSuchApressBookException {

		ApressBook apressBook = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			ApressBook[] array = new ApressBookImpl[3];

			array[0] = getByIsCoding_PrevAndNext(
				session, apressBook, isCoding, orderByComparator, true);

			array[1] = apressBook;

			array[2] = getByIsCoding_PrevAndNext(
				session, apressBook, isCoding, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApressBook getByIsCoding_PrevAndNext(
		Session session, ApressBook apressBook, boolean isCoding,
		OrderByComparator<ApressBook> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APRESSBOOK_WHERE);

		sb.append(_FINDER_COLUMN_ISCODING_ISCODING_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ApressBookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isCoding);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(apressBook)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApressBook> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apress books where isCoding = &#63; from the database.
	 *
	 * @param isCoding the is coding
	 */
	@Override
	public void removeByIsCoding(boolean isCoding) {
		for (ApressBook apressBook :
				findByIsCoding(
					isCoding, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(apressBook);
		}
	}

	/**
	 * Returns the number of apress books where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the number of matching apress books
	 */
	@Override
	public int countByIsCoding(boolean isCoding) {
		FinderPath finderPath = _finderPathCountByIsCoding;

		Object[] finderArgs = new Object[] {isCoding};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APRESSBOOK_WHERE);

			sb.append(_FINDER_COLUMN_ISCODING_ISCODING_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isCoding);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISCODING_ISCODING_2 =
		"apressBook.isCoding = ?";

	public ApressBookPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ApressBook.class);

		setModelImplClass(ApressBookImpl.class);
		setModelPKClass(long.class);

		setTable(ApressBookTable.INSTANCE);
	}

	/**
	 * Caches the apress book in the entity cache if it is enabled.
	 *
	 * @param apressBook the apress book
	 */
	@Override
	public void cacheResult(ApressBook apressBook) {
		entityCache.putResult(
			ApressBookImpl.class, apressBook.getPrimaryKey(), apressBook);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {apressBook.getUuid(), apressBook.getGroupId()},
			apressBook);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the apress books in the entity cache if it is enabled.
	 *
	 * @param apressBooks the apress books
	 */
	@Override
	public void cacheResult(List<ApressBook> apressBooks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (apressBooks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ApressBook apressBook : apressBooks) {
			if (entityCache.getResult(
					ApressBookImpl.class, apressBook.getPrimaryKey()) == null) {

				cacheResult(apressBook);
			}
		}
	}

	/**
	 * Clears the cache for all apress books.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApressBookImpl.class);

		finderCache.clearCache(ApressBookImpl.class);
	}

	/**
	 * Clears the cache for the apress book.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApressBook apressBook) {
		entityCache.removeResult(ApressBookImpl.class, apressBook);
	}

	@Override
	public void clearCache(List<ApressBook> apressBooks) {
		for (ApressBook apressBook : apressBooks) {
			entityCache.removeResult(ApressBookImpl.class, apressBook);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ApressBookImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ApressBookImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ApressBookModelImpl apressBookModelImpl) {

		Object[] args = new Object[] {
			apressBookModelImpl.getUuid(), apressBookModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, apressBookModelImpl);
	}

	/**
	 * Creates a new apress book with the primary key. Does not add the apress book to the database.
	 *
	 * @param bookId the primary key for the new apress book
	 * @return the new apress book
	 */
	@Override
	public ApressBook create(long bookId) {
		ApressBook apressBook = new ApressBookImpl();

		apressBook.setNew(true);
		apressBook.setPrimaryKey(bookId);

		String uuid = PortalUUIDUtil.generate();

		apressBook.setUuid(uuid);

		apressBook.setCompanyId(CompanyThreadLocal.getCompanyId());

		return apressBook;
	}

	/**
	 * Removes the apress book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book that was removed
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	@Override
	public ApressBook remove(long bookId) throws NoSuchApressBookException {
		return remove((Serializable)bookId);
	}

	/**
	 * Removes the apress book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the apress book
	 * @return the apress book that was removed
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	@Override
	public ApressBook remove(Serializable primaryKey)
		throws NoSuchApressBookException {

		Session session = null;

		try {
			session = openSession();

			ApressBook apressBook = (ApressBook)session.get(
				ApressBookImpl.class, primaryKey);

			if (apressBook == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApressBookException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(apressBook);
		}
		catch (NoSuchApressBookException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ApressBook removeImpl(ApressBook apressBook) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(apressBook)) {
				apressBook = (ApressBook)session.get(
					ApressBookImpl.class, apressBook.getPrimaryKeyObj());
			}

			if (apressBook != null) {
				session.delete(apressBook);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (apressBook != null) {
			clearCache(apressBook);
		}

		return apressBook;
	}

	@Override
	public ApressBook updateImpl(ApressBook apressBook) {
		boolean isNew = apressBook.isNew();

		if (!(apressBook instanceof ApressBookModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(apressBook.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(apressBook);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in apressBook proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ApressBook implementation " +
					apressBook.getClass());
		}

		ApressBookModelImpl apressBookModelImpl =
			(ApressBookModelImpl)apressBook;

		if (Validator.isNull(apressBook.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			apressBook.setUuid(uuid);
		}

		if (isNew && (apressBook.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				apressBook.setCreateDate(date);
			}
			else {
				apressBook.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(apressBook);
			}
			else {
				apressBook = (ApressBook)session.merge(apressBook);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ApressBookImpl.class, apressBookModelImpl, false, true);

		cacheUniqueFindersCache(apressBookModelImpl);

		if (isNew) {
			apressBook.setNew(false);
		}

		apressBook.resetOriginalValues();

		return apressBook;
	}

	/**
	 * Returns the apress book with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the apress book
	 * @return the apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	@Override
	public ApressBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApressBookException {

		ApressBook apressBook = fetchByPrimaryKey(primaryKey);

		if (apressBook == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApressBookException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return apressBook;
	}

	/**
	 * Returns the apress book with the primary key or throws a <code>NoSuchApressBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book
	 * @throws NoSuchApressBookException if a apress book with the primary key could not be found
	 */
	@Override
	public ApressBook findByPrimaryKey(long bookId)
		throws NoSuchApressBookException {

		return findByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns the apress book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the apress book
	 * @return the apress book, or <code>null</code> if a apress book with the primary key could not be found
	 */
	@Override
	public ApressBook fetchByPrimaryKey(long bookId) {
		return fetchByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns all the apress books.
	 *
	 * @return the apress books
	 */
	@Override
	public List<ApressBook> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ApressBook> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ApressBook> findAll(
		int start, int end, OrderByComparator<ApressBook> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ApressBook> findAll(
		int start, int end, OrderByComparator<ApressBook> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ApressBook> list = null;

		if (useFinderCache) {
			list = (List<ApressBook>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APRESSBOOK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APRESSBOOK;

				sql = sql.concat(ApressBookModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ApressBook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the apress books from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApressBook apressBook : findAll()) {
			remove(apressBook);
		}
	}

	/**
	 * Returns the number of apress books.
	 *
	 * @return the number of apress books
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APRESSBOOK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "bookId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APRESSBOOK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApressBookModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the apress book persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByIsCoding = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsCoding",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isCoding"}, true);

		_finderPathWithoutPaginationFindByIsCoding = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsCoding",
			new String[] {Boolean.class.getName()}, new String[] {"isCoding"},
			true);

		_finderPathCountByIsCoding = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsCoding",
			new String[] {Boolean.class.getName()}, new String[] {"isCoding"},
			false);

		_setApressBookUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setApressBookUtilPersistence(null);

		entityCache.removeCache(ApressBookImpl.class.getName());
	}

	private void _setApressBookUtilPersistence(
		ApressBookPersistence apressBookPersistence) {

		try {
			Field field = ApressBookUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, apressBookPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = apressPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = apressPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = apressPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_APRESSBOOK =
		"SELECT apressBook FROM ApressBook apressBook";

	private static final String _SQL_SELECT_APRESSBOOK_WHERE =
		"SELECT apressBook FROM ApressBook apressBook WHERE ";

	private static final String _SQL_COUNT_APRESSBOOK =
		"SELECT COUNT(apressBook) FROM ApressBook apressBook";

	private static final String _SQL_COUNT_APRESSBOOK_WHERE =
		"SELECT COUNT(apressBook) FROM ApressBook apressBook WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "apressBook.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ApressBook exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ApressBook exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ApressBookPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ApressBookModelArgumentsResolver _apressBookModelArgumentsResolver;

}