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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.handsonliferay.apress_service_builder.service.http.ApressBookServiceSoap}.
 *
 * @author Apoorva_Inthiyaz
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ApressBookSoap implements Serializable {

	public static ApressBookSoap toSoapModel(ApressBook model) {
		ApressBookSoap soapModel = new ApressBookSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBookId(model.getBookId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setChapterId(model.getChapterId());
		soapModel.setChapterName(model.getChapterName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setIsCoding(model.isIsCoding());

		return soapModel;
	}

	public static ApressBookSoap[] toSoapModels(ApressBook[] models) {
		ApressBookSoap[] soapModels = new ApressBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApressBookSoap[][] toSoapModels(ApressBook[][] models) {
		ApressBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApressBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApressBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApressBookSoap[] toSoapModels(List<ApressBook> models) {
		List<ApressBookSoap> soapModels = new ArrayList<ApressBookSoap>(
			models.size());

		for (ApressBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApressBookSoap[soapModels.size()]);
	}

	public ApressBookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getChapterId() {
		return _chapterId;
	}

	public void setChapterId(long chapterId) {
		_chapterId = chapterId;
	}

	public String getChapterName() {
		return _chapterName;
	}

	public void setChapterName(String chapterName) {
		_chapterName = chapterName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public boolean getIsCoding() {
		return _isCoding;
	}

	public boolean isIsCoding() {
		return _isCoding;
	}

	public void setIsCoding(boolean isCoding) {
		_isCoding = isCoding;
	}

	private String _uuid;
	private long _bookId;
	private long _groupId;
	private long _companyId;
	private long _chapterId;
	private String _chapterName;
	private Date _createDate;
	private boolean _isCoding;

}