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

package com.handsonliferay.apress_service_builder.model.impl;

import com.handsonliferay.apress_service_builder.model.ApressBook;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ApressBook in entity cache.
 *
 * @author Apoorva_Inthiyaz
 * @generated
 */
public class ApressBookCacheModel
	implements CacheModel<ApressBook>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ApressBookCacheModel)) {
			return false;
		}

		ApressBookCacheModel apressBookCacheModel =
			(ApressBookCacheModel)object;

		if (bookId == apressBookCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", chapterId=");
		sb.append(chapterId);
		sb.append(", chapterName=");
		sb.append(chapterName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", isCoding=");
		sb.append(isCoding);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApressBook toEntityModel() {
		ApressBookImpl apressBookImpl = new ApressBookImpl();

		if (uuid == null) {
			apressBookImpl.setUuid("");
		}
		else {
			apressBookImpl.setUuid(uuid);
		}

		apressBookImpl.setBookId(bookId);
		apressBookImpl.setGroupId(groupId);
		apressBookImpl.setCompanyId(companyId);
		apressBookImpl.setChapterId(chapterId);

		if (chapterName == null) {
			apressBookImpl.setChapterName("");
		}
		else {
			apressBookImpl.setChapterName(chapterName);
		}

		if (createDate == Long.MIN_VALUE) {
			apressBookImpl.setCreateDate(null);
		}
		else {
			apressBookImpl.setCreateDate(new Date(createDate));
		}

		apressBookImpl.setIsCoding(isCoding);

		apressBookImpl.resetOriginalValues();

		return apressBookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bookId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		chapterId = objectInput.readLong();
		chapterName = objectInput.readUTF();
		createDate = objectInput.readLong();

		isCoding = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bookId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(chapterId);

		if (chapterName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chapterName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeBoolean(isCoding);
	}

	public String uuid;
	public long bookId;
	public long groupId;
	public long companyId;
	public long chapterId;
	public String chapterName;
	public long createDate;
	public boolean isCoding;

}