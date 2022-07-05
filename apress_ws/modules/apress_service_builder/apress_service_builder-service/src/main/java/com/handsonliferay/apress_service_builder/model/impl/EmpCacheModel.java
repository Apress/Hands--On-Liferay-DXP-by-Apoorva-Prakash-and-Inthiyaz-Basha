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

import com.handsonliferay.apress_service_builder.model.Emp;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Emp in entity cache.
 *
 * @author Apoorva_Inthiyaz
 * @generated
 */
public class EmpCacheModel implements CacheModel<Emp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmpCacheModel)) {
			return false;
		}

		EmpCacheModel empCacheModel = (EmpCacheModel)object;

		if (EmpId == empCacheModel.EmpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, EmpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", EmpId=");
		sb.append(EmpId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", isCoding=");
		sb.append(isCoding);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Emp toEntityModel() {
		EmpImpl empImpl = new EmpImpl();

		if (uuid == null) {
			empImpl.setUuid("");
		}
		else {
			empImpl.setUuid(uuid);
		}

		empImpl.setEmpId(EmpId);
		empImpl.setGroupId(groupId);
		empImpl.setCompanyId(companyId);
		empImpl.setProjectId(projectId);

		if (projectName == null) {
			empImpl.setProjectName("");
		}
		else {
			empImpl.setProjectName(projectName);
		}

		if (createDate == Long.MIN_VALUE) {
			empImpl.setCreateDate(null);
		}
		else {
			empImpl.setCreateDate(new Date(createDate));
		}

		empImpl.setIsCoding(isCoding);

		empImpl.resetOriginalValues();

		return empImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		EmpId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		projectId = objectInput.readLong();
		projectName = objectInput.readUTF();
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

		objectOutput.writeLong(EmpId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(projectId);

		if (projectName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeBoolean(isCoding);
	}

	public String uuid;
	public long EmpId;
	public long groupId;
	public long companyId;
	public long projectId;
	public String projectName;
	public long createDate;
	public boolean isCoding;

}