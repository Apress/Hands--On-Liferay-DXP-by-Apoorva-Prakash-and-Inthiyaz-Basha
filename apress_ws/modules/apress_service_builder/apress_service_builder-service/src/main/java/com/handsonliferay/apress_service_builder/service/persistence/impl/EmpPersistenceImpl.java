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

import com.handsonliferay.apress_service_builder.exception.NoSuchEmpException;
import com.handsonliferay.apress_service_builder.model.Emp;
import com.handsonliferay.apress_service_builder.model.EmpTable;
import com.handsonliferay.apress_service_builder.model.impl.EmpImpl;
import com.handsonliferay.apress_service_builder.model.impl.EmpModelImpl;
import com.handsonliferay.apress_service_builder.service.persistence.EmpPersistence;
import com.handsonliferay.apress_service_builder.service.persistence.EmpUtil;
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
 * The persistence implementation for the emp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @generated
 */
@Component(service = {EmpPersistence.class, BasePersistence.class})
public class EmpPersistenceImpl
	extends BasePersistenceImpl<Emp> implements EmpPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmpUtil</code> to access the emp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmpImpl.class.getName();

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
	 * Returns all the emps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emps
	 */
	@Override
	public List<Emp> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @return the range of matching emps
	 */
	@Override
	public List<Emp> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emps
	 */
	@Override
	public List<Emp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Emp> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emps
	 */
	@Override
	public List<Emp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Emp> orderByComparator, boolean useFinderCache) {

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

		List<Emp> list = null;

		if (useFinderCache) {
			list = (List<Emp>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Emp emp : list) {
					if (!uuid.equals(emp.getUuid())) {
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

			sb.append(_SQL_SELECT_EMP_WHERE);

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
				sb.append(EmpModelImpl.ORDER_BY_JPQL);
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

				list = (List<Emp>)QueryUtil.list(
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
	 * Returns the first emp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByUuid_First(
			String uuid, OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = fetchByUuid_First(uuid, orderByComparator);

		if (emp != null) {
			return emp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmpException(sb.toString());
	}

	/**
	 * Returns the first emp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByUuid_First(
		String uuid, OrderByComparator<Emp> orderByComparator) {

		List<Emp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByUuid_Last(
			String uuid, OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = fetchByUuid_Last(uuid, orderByComparator);

		if (emp != null) {
			return emp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmpException(sb.toString());
	}

	/**
	 * Returns the last emp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByUuid_Last(
		String uuid, OrderByComparator<Emp> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Emp> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emps before and after the current emp in the ordered set where uuid = &#63;.
	 *
	 * @param EmpId the primary key of the current emp
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp[] findByUuid_PrevAndNext(
			long EmpId, String uuid, OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		uuid = Objects.toString(uuid, "");

		Emp emp = findByPrimaryKey(EmpId);

		Session session = null;

		try {
			session = openSession();

			Emp[] array = new EmpImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, emp, uuid, orderByComparator, true);

			array[1] = emp;

			array[2] = getByUuid_PrevAndNext(
				session, emp, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Emp getByUuid_PrevAndNext(
		Session session, Emp emp, String uuid,
		OrderByComparator<Emp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMP_WHERE);

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
			sb.append(EmpModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(emp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Emp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Emp emp :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emp);
		}
	}

	/**
	 * Returns the number of emps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "emp.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(emp.uuid IS NULL OR emp.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the emp where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmpException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByUUID_G(String uuid, long groupId)
		throws NoSuchEmpException {

		Emp emp = fetchByUUID_G(uuid, groupId);

		if (emp == null) {
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

			throw new NoSuchEmpException(sb.toString());
		}

		return emp;
	}

	/**
	 * Returns the emp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the emp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByUUID_G(
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

		if (result instanceof Emp) {
			Emp emp = (Emp)result;

			if (!Objects.equals(uuid, emp.getUuid()) ||
				(groupId != emp.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMP_WHERE);

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

				List<Emp> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Emp emp = list.get(0);

					result = emp;

					cacheResult(emp);
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
			return (Emp)result;
		}
	}

	/**
	 * Removes the emp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emp that was removed
	 */
	@Override
	public Emp removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmpException {

		Emp emp = findByUUID_G(uuid, groupId);

		return remove(emp);
	}

	/**
	 * Returns the number of emps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMP_WHERE);

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
		"emp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(emp.uuid IS NULL OR emp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"emp.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the emps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emps
	 */
	@Override
	public List<Emp> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @return the range of matching emps
	 */
	@Override
	public List<Emp> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emps
	 */
	@Override
	public List<Emp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Emp> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emps
	 */
	@Override
	public List<Emp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Emp> orderByComparator, boolean useFinderCache) {

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

		List<Emp> list = null;

		if (useFinderCache) {
			list = (List<Emp>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Emp emp : list) {
					if (!uuid.equals(emp.getUuid()) ||
						(companyId != emp.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMP_WHERE);

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
				sb.append(EmpModelImpl.ORDER_BY_JPQL);
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

				list = (List<Emp>)QueryUtil.list(
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
	 * Returns the first emp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (emp != null) {
			return emp;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmpException(sb.toString());
	}

	/**
	 * Returns the first emp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<Emp> orderByComparator) {

		List<Emp> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (emp != null) {
			return emp;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmpException(sb.toString());
	}

	/**
	 * Returns the last emp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<Emp> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Emp> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emps before and after the current emp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param EmpId the primary key of the current emp
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp[] findByUuid_C_PrevAndNext(
			long EmpId, String uuid, long companyId,
			OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		uuid = Objects.toString(uuid, "");

		Emp emp = findByPrimaryKey(EmpId);

		Session session = null;

		try {
			session = openSession();

			Emp[] array = new EmpImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, emp, uuid, companyId, orderByComparator, true);

			array[1] = emp;

			array[2] = getByUuid_C_PrevAndNext(
				session, emp, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Emp getByUuid_C_PrevAndNext(
		Session session, Emp emp, String uuid, long companyId,
		OrderByComparator<Emp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMP_WHERE);

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
			sb.append(EmpModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(emp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Emp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Emp emp :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(emp);
		}
	}

	/**
	 * Returns the number of emps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMP_WHERE);

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
		"emp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(emp.uuid IS NULL OR emp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"emp.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByIsCoding;
	private FinderPath _finderPathWithoutPaginationFindByIsCoding;
	private FinderPath _finderPathCountByIsCoding;

	/**
	 * Returns all the emps where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the matching emps
	 */
	@Override
	public List<Emp> findByIsCoding(boolean isCoding) {
		return findByIsCoding(
			isCoding, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emps where isCoding = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param isCoding the is coding
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @return the range of matching emps
	 */
	@Override
	public List<Emp> findByIsCoding(boolean isCoding, int start, int end) {
		return findByIsCoding(isCoding, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emps where isCoding = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param isCoding the is coding
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emps
	 */
	@Override
	public List<Emp> findByIsCoding(
		boolean isCoding, int start, int end,
		OrderByComparator<Emp> orderByComparator) {

		return findByIsCoding(isCoding, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emps where isCoding = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param isCoding the is coding
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emps
	 */
	@Override
	public List<Emp> findByIsCoding(
		boolean isCoding, int start, int end,
		OrderByComparator<Emp> orderByComparator, boolean useFinderCache) {

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

		List<Emp> list = null;

		if (useFinderCache) {
			list = (List<Emp>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Emp emp : list) {
					if (isCoding != emp.isIsCoding()) {
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

			sb.append(_SQL_SELECT_EMP_WHERE);

			sb.append(_FINDER_COLUMN_ISCODING_ISCODING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmpModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isCoding);

				list = (List<Emp>)QueryUtil.list(
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
	 * Returns the first emp in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByIsCoding_First(
			boolean isCoding, OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = fetchByIsCoding_First(isCoding, orderByComparator);

		if (emp != null) {
			return emp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isCoding=");
		sb.append(isCoding);

		sb.append("}");

		throw new NoSuchEmpException(sb.toString());
	}

	/**
	 * Returns the first emp in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByIsCoding_First(
		boolean isCoding, OrderByComparator<Emp> orderByComparator) {

		List<Emp> list = findByIsCoding(isCoding, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp
	 * @throws NoSuchEmpException if a matching emp could not be found
	 */
	@Override
	public Emp findByIsCoding_Last(
			boolean isCoding, OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = fetchByIsCoding_Last(isCoding, orderByComparator);

		if (emp != null) {
			return emp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isCoding=");
		sb.append(isCoding);

		sb.append("}");

		throw new NoSuchEmpException(sb.toString());
	}

	/**
	 * Returns the last emp in the ordered set where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp, or <code>null</code> if a matching emp could not be found
	 */
	@Override
	public Emp fetchByIsCoding_Last(
		boolean isCoding, OrderByComparator<Emp> orderByComparator) {

		int count = countByIsCoding(isCoding);

		if (count == 0) {
			return null;
		}

		List<Emp> list = findByIsCoding(
			isCoding, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emps before and after the current emp in the ordered set where isCoding = &#63;.
	 *
	 * @param EmpId the primary key of the current emp
	 * @param isCoding the is coding
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp[] findByIsCoding_PrevAndNext(
			long EmpId, boolean isCoding,
			OrderByComparator<Emp> orderByComparator)
		throws NoSuchEmpException {

		Emp emp = findByPrimaryKey(EmpId);

		Session session = null;

		try {
			session = openSession();

			Emp[] array = new EmpImpl[3];

			array[0] = getByIsCoding_PrevAndNext(
				session, emp, isCoding, orderByComparator, true);

			array[1] = emp;

			array[2] = getByIsCoding_PrevAndNext(
				session, emp, isCoding, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Emp getByIsCoding_PrevAndNext(
		Session session, Emp emp, boolean isCoding,
		OrderByComparator<Emp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMP_WHERE);

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
			sb.append(EmpModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isCoding);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(emp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Emp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emps where isCoding = &#63; from the database.
	 *
	 * @param isCoding the is coding
	 */
	@Override
	public void removeByIsCoding(boolean isCoding) {
		for (Emp emp :
				findByIsCoding(
					isCoding, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emp);
		}
	}

	/**
	 * Returns the number of emps where isCoding = &#63;.
	 *
	 * @param isCoding the is coding
	 * @return the number of matching emps
	 */
	@Override
	public int countByIsCoding(boolean isCoding) {
		FinderPath finderPath = _finderPathCountByIsCoding;

		Object[] finderArgs = new Object[] {isCoding};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMP_WHERE);

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
		"emp.isCoding = ?";

	public EmpPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Emp.class);

		setModelImplClass(EmpImpl.class);
		setModelPKClass(long.class);

		setTable(EmpTable.INSTANCE);
	}

	/**
	 * Caches the emp in the entity cache if it is enabled.
	 *
	 * @param emp the emp
	 */
	@Override
	public void cacheResult(Emp emp) {
		entityCache.putResult(EmpImpl.class, emp.getPrimaryKey(), emp);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {emp.getUuid(), emp.getGroupId()}, emp);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the emps in the entity cache if it is enabled.
	 *
	 * @param emps the emps
	 */
	@Override
	public void cacheResult(List<Emp> emps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Emp emp : emps) {
			if (entityCache.getResult(EmpImpl.class, emp.getPrimaryKey()) ==
					null) {

				cacheResult(emp);
			}
		}
	}

	/**
	 * Clears the cache for all emps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmpImpl.class);

		finderCache.clearCache(EmpImpl.class);
	}

	/**
	 * Clears the cache for the emp.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Emp emp) {
		entityCache.removeResult(EmpImpl.class, emp);
	}

	@Override
	public void clearCache(List<Emp> emps) {
		for (Emp emp : emps) {
			entityCache.removeResult(EmpImpl.class, emp);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmpImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmpImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(EmpModelImpl empModelImpl) {
		Object[] args = new Object[] {
			empModelImpl.getUuid(), empModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, empModelImpl);
	}

	/**
	 * Creates a new emp with the primary key. Does not add the emp to the database.
	 *
	 * @param EmpId the primary key for the new emp
	 * @return the new emp
	 */
	@Override
	public Emp create(long EmpId) {
		Emp emp = new EmpImpl();

		emp.setNew(true);
		emp.setPrimaryKey(EmpId);

		String uuid = PortalUUIDUtil.generate();

		emp.setUuid(uuid);

		emp.setCompanyId(CompanyThreadLocal.getCompanyId());

		return emp;
	}

	/**
	 * Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param EmpId the primary key of the emp
	 * @return the emp that was removed
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp remove(long EmpId) throws NoSuchEmpException {
		return remove((Serializable)EmpId);
	}

	/**
	 * Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp
	 * @return the emp that was removed
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp remove(Serializable primaryKey) throws NoSuchEmpException {
		Session session = null;

		try {
			session = openSession();

			Emp emp = (Emp)session.get(EmpImpl.class, primaryKey);

			if (emp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(emp);
		}
		catch (NoSuchEmpException noSuchEntityException) {
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
	protected Emp removeImpl(Emp emp) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emp)) {
				emp = (Emp)session.get(EmpImpl.class, emp.getPrimaryKeyObj());
			}

			if (emp != null) {
				session.delete(emp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (emp != null) {
			clearCache(emp);
		}

		return emp;
	}

	@Override
	public Emp updateImpl(Emp emp) {
		boolean isNew = emp.isNew();

		if (!(emp instanceof EmpModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emp.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(emp);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emp proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Emp implementation " +
					emp.getClass());
		}

		EmpModelImpl empModelImpl = (EmpModelImpl)emp;

		if (Validator.isNull(emp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			emp.setUuid(uuid);
		}

		if (isNew && (emp.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				emp.setCreateDate(date);
			}
			else {
				emp.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(emp);
			}
			else {
				emp = (Emp)session.merge(emp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EmpImpl.class, empModelImpl, false, true);

		cacheUniqueFindersCache(empModelImpl);

		if (isNew) {
			emp.setNew(false);
		}

		emp.resetOriginalValues();

		return emp;
	}

	/**
	 * Returns the emp with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp
	 * @return the emp
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpException {

		Emp emp = fetchByPrimaryKey(primaryKey);

		if (emp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return emp;
	}

	/**
	 * Returns the emp with the primary key or throws a <code>NoSuchEmpException</code> if it could not be found.
	 *
	 * @param EmpId the primary key of the emp
	 * @return the emp
	 * @throws NoSuchEmpException if a emp with the primary key could not be found
	 */
	@Override
	public Emp findByPrimaryKey(long EmpId) throws NoSuchEmpException {
		return findByPrimaryKey((Serializable)EmpId);
	}

	/**
	 * Returns the emp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param EmpId the primary key of the emp
	 * @return the emp, or <code>null</code> if a emp with the primary key could not be found
	 */
	@Override
	public Emp fetchByPrimaryKey(long EmpId) {
		return fetchByPrimaryKey((Serializable)EmpId);
	}

	/**
	 * Returns all the emps.
	 *
	 * @return the emps
	 */
	@Override
	public List<Emp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @return the range of emps
	 */
	@Override
	public List<Emp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emps
	 */
	@Override
	public List<Emp> findAll(
		int start, int end, OrderByComparator<Emp> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of emps
	 */
	@Override
	public List<Emp> findAll(
		int start, int end, OrderByComparator<Emp> orderByComparator,
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

		List<Emp> list = null;

		if (useFinderCache) {
			list = (List<Emp>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMP;

				sql = sql.concat(EmpModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Emp>)QueryUtil.list(
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
	 * Removes all the emps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Emp emp : findAll()) {
			remove(emp);
		}
	}

	/**
	 * Returns the number of emps.
	 *
	 * @return the number of emps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMP);

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
		return "EmpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmpModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the emp persistence.
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

		_setEmpUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEmpUtilPersistence(null);

		entityCache.removeCache(EmpImpl.class.getName());
	}

	private void _setEmpUtilPersistence(EmpPersistence empPersistence) {
		try {
			Field field = EmpUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, empPersistence);
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

	private static final String _SQL_SELECT_EMP = "SELECT emp FROM Emp emp";

	private static final String _SQL_SELECT_EMP_WHERE =
		"SELECT emp FROM Emp emp WHERE ";

	private static final String _SQL_COUNT_EMP =
		"SELECT COUNT(emp) FROM Emp emp";

	private static final String _SQL_COUNT_EMP_WHERE =
		"SELECT COUNT(emp) FROM Emp emp WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "emp.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Emp exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Emp exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmpPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EmpModelArgumentsResolver _empModelArgumentsResolver;

}