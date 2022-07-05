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

package com.handsonliferay.apress_service_builder.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;apress_Emp&quot; database table.
 *
 * @author Apoorva_Inthiyaz
 * @see Emp
 * @generated
 */
public class EmpTable extends BaseTable<EmpTable> {

	public static final EmpTable INSTANCE = new EmpTable();

	public final Column<EmpTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmpTable, Long> EmpId = createColumn(
		"EmpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmpTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmpTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmpTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmpTable, String> projectName = createColumn(
		"projectName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmpTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmpTable, Boolean> isCoding = createColumn(
		"isCoding", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private EmpTable() {
		super("apress_Emp", EmpTable::new);
	}

}