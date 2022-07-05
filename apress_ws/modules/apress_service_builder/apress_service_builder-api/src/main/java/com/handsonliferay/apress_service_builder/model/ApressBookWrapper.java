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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ApressBook}.
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBook
 * @generated
 */
public class ApressBookWrapper
	extends BaseModelWrapper<ApressBook>
	implements ApressBook, ModelWrapper<ApressBook> {

	public ApressBookWrapper(ApressBook apressBook) {
		super(apressBook);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bookId", getBookId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("chapterId", getChapterId());
		attributes.put("chapterName", getChapterName());
		attributes.put("createDate", getCreateDate());
		attributes.put("isCoding", isIsCoding());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long chapterId = (Long)attributes.get("chapterId");

		if (chapterId != null) {
			setChapterId(chapterId);
		}

		String chapterName = (String)attributes.get("chapterName");

		if (chapterName != null) {
			setChapterName(chapterName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Boolean isCoding = (Boolean)attributes.get("isCoding");

		if (isCoding != null) {
			setIsCoding(isCoding);
		}
	}

	@Override
	public ApressBook cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the book ID of this apress book.
	 *
	 * @return the book ID of this apress book
	 */
	@Override
	public long getBookId() {
		return model.getBookId();
	}

	/**
	 * Returns the chapter ID of this apress book.
	 *
	 * @return the chapter ID of this apress book
	 */
	@Override
	public long getChapterId() {
		return model.getChapterId();
	}

	/**
	 * Returns the chapter name of this apress book.
	 *
	 * @return the chapter name of this apress book
	 */
	@Override
	public String getChapterName() {
		return model.getChapterName();
	}

	/**
	 * Returns the company ID of this apress book.
	 *
	 * @return the company ID of this apress book
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this apress book.
	 *
	 * @return the create date of this apress book
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this apress book.
	 *
	 * @return the group ID of this apress book
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is coding of this apress book.
	 *
	 * @return the is coding of this apress book
	 */
	@Override
	public boolean getIsCoding() {
		return model.getIsCoding();
	}

	/**
	 * Returns the primary key of this apress book.
	 *
	 * @return the primary key of this apress book
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this apress book.
	 *
	 * @return the uuid of this apress book
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this apress book is is coding.
	 *
	 * @return <code>true</code> if this apress book is is coding; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsCoding() {
		return model.isIsCoding();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the book ID of this apress book.
	 *
	 * @param bookId the book ID of this apress book
	 */
	@Override
	public void setBookId(long bookId) {
		model.setBookId(bookId);
	}

	/**
	 * Sets the chapter ID of this apress book.
	 *
	 * @param chapterId the chapter ID of this apress book
	 */
	@Override
	public void setChapterId(long chapterId) {
		model.setChapterId(chapterId);
	}

	/**
	 * Sets the chapter name of this apress book.
	 *
	 * @param chapterName the chapter name of this apress book
	 */
	@Override
	public void setChapterName(String chapterName) {
		model.setChapterName(chapterName);
	}

	/**
	 * Sets the company ID of this apress book.
	 *
	 * @param companyId the company ID of this apress book
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this apress book.
	 *
	 * @param createDate the create date of this apress book
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this apress book.
	 *
	 * @param groupId the group ID of this apress book
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this apress book is is coding.
	 *
	 * @param isCoding the is coding of this apress book
	 */
	@Override
	public void setIsCoding(boolean isCoding) {
		model.setIsCoding(isCoding);
	}

	/**
	 * Sets the primary key of this apress book.
	 *
	 * @param primaryKey the primary key of this apress book
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this apress book.
	 *
	 * @param uuid the uuid of this apress book
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ApressBookWrapper wrap(ApressBook apressBook) {
		return new ApressBookWrapper(apressBook);
	}

}