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
 * The table class for the &quot;apress_ApressBook&quot; database table.
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBook
 * @generated
 */
public class ApressBookTable extends BaseTable<ApressBookTable> {

	public static final ApressBookTable INSTANCE = new ApressBookTable();

	public final Column<ApressBookTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ApressBookTable, Long> bookId = createColumn(
		"bookId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ApressBookTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ApressBookTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ApressBookTable, Long> chapterId = createColumn(
		"chapterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ApressBookTable, String> chapterName = createColumn(
		"chapterName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ApressBookTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ApressBookTable, Boolean> isCoding = createColumn(
		"isCoding", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private ApressBookTable() {
		super("apress_ApressBook", ApressBookTable::new);
	}

}