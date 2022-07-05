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
 * The table class for the &quot;apress_book&quot; database table.
 *
 * @author Apoorva_Inthiyaz
 * @see book
 * @generated
 */
public class bookTable extends BaseTable<bookTable> {

	public static final bookTable INSTANCE = new bookTable();

	public final Column<bookTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<bookTable, Long> bookId = createColumn(
		"bookId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<bookTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<bookTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<bookTable, Long> chapterId = createColumn(
		"chapterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<bookTable, String> chapterName = createColumn(
		"chapterName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<bookTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<bookTable, Boolean> isCoding = createColumn(
		"isCoding", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private bookTable() {
		super("apress_book", bookTable::new);
	}

}