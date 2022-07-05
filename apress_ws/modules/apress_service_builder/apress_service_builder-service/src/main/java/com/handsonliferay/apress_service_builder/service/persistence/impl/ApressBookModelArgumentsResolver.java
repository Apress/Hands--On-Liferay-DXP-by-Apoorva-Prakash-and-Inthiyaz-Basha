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

import com.handsonliferay.apress_service_builder.model.ApressBookTable;
import com.handsonliferay.apress_service_builder.model.impl.ApressBookImpl;
import com.handsonliferay.apress_service_builder.model.impl.ApressBookModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from ApressBook.
 *
 * @author Apoorva_Inthiyaz
 * @generated
 */
@Component(
	immediate = true,
	service = {ApressBookModelArgumentsResolver.class, ArgumentsResolver.class}
)
public class ApressBookModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		ApressBookModelImpl apressBookModelImpl =
			(ApressBookModelImpl)baseModel;

		long columnBitmask = apressBookModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(apressBookModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= apressBookModelImpl.getColumnBitmask(
					columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(ApressBookPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(apressBookModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ApressBookImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ApressBookTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ApressBookModelImpl apressBookModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = apressBookModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = apressBookModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= ApressBookModelImpl.getColumnBitmask(
			"chapterId");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}