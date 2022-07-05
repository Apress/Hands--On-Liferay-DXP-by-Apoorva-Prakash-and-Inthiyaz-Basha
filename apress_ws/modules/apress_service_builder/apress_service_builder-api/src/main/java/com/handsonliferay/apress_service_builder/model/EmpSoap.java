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
 * This class is used by SOAP remote services, specifically {@link com.handsonliferay.apress_service_builder.service.http.EmpServiceSoap}.
 *
 * @author Apoorva_Inthiyaz
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmpSoap implements Serializable {

	public static EmpSoap toSoapModel(Emp model) {
		EmpSoap soapModel = new EmpSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setProjectName(model.getProjectName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setIsCoding(model.isIsCoding());

		return soapModel;
	}

	public static EmpSoap[] toSoapModels(Emp[] models) {
		EmpSoap[] soapModels = new EmpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSoap[][] toSoapModels(Emp[][] models) {
		EmpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSoap[] toSoapModels(List<Emp> models) {
		List<EmpSoap> soapModels = new ArrayList<EmpSoap>(models.size());

		for (Emp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSoap[soapModels.size()]);
	}

	public EmpSoap() {
	}

	public long getPrimaryKey() {
		return _EmpId;
	}

	public void setPrimaryKey(long pk) {
		setEmpId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmpId() {
		return _EmpId;
	}

	public void setEmpId(long EmpId) {
		_EmpId = EmpId;
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

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public String getProjectName() {
		return _projectName;
	}

	public void setProjectName(String projectName) {
		_projectName = projectName;
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
	private long _EmpId;
	private long _groupId;
	private long _companyId;
	private long _projectId;
	private String _projectName;
	private Date _createDate;
	private boolean _isCoding;

}