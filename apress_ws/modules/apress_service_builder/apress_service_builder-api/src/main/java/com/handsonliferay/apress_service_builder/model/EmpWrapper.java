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
 * This class is a wrapper for {@link Emp}.
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @see Emp
 * @generated
 */
public class EmpWrapper
	extends BaseModelWrapper<Emp> implements Emp, ModelWrapper<Emp> {

	public EmpWrapper(Emp emp) {
		super(emp);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("EmpId", getEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectId", getProjectId());
		attributes.put("projectName", getProjectName());
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

		Long EmpId = (Long)attributes.get("EmpId");

		if (EmpId != null) {
			setEmpId(EmpId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
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
	public Emp cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this emp.
	 *
	 * @return the company ID of this emp
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this emp.
	 *
	 * @return the create date of this emp
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the emp ID of this emp.
	 *
	 * @return the emp ID of this emp
	 */
	@Override
	public long getEmpId() {
		return model.getEmpId();
	}

	/**
	 * Returns the group ID of this emp.
	 *
	 * @return the group ID of this emp
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is coding of this emp.
	 *
	 * @return the is coding of this emp
	 */
	@Override
	public boolean getIsCoding() {
		return model.getIsCoding();
	}

	/**
	 * Returns the primary key of this emp.
	 *
	 * @return the primary key of this emp
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this emp.
	 *
	 * @return the project ID of this emp
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the project name of this emp.
	 *
	 * @return the project name of this emp
	 */
	@Override
	public String getProjectName() {
		return model.getProjectName();
	}

	/**
	 * Returns the uuid of this emp.
	 *
	 * @return the uuid of this emp
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this emp is is coding.
	 *
	 * @return <code>true</code> if this emp is is coding; <code>false</code> otherwise
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
	 * Sets the company ID of this emp.
	 *
	 * @param companyId the company ID of this emp
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this emp.
	 *
	 * @param createDate the create date of this emp
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the emp ID of this emp.
	 *
	 * @param EmpId the emp ID of this emp
	 */
	@Override
	public void setEmpId(long EmpId) {
		model.setEmpId(EmpId);
	}

	/**
	 * Sets the group ID of this emp.
	 *
	 * @param groupId the group ID of this emp
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this emp is is coding.
	 *
	 * @param isCoding the is coding of this emp
	 */
	@Override
	public void setIsCoding(boolean isCoding) {
		model.setIsCoding(isCoding);
	}

	/**
	 * Sets the primary key of this emp.
	 *
	 * @param primaryKey the primary key of this emp
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this emp.
	 *
	 * @param projectId the project ID of this emp
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the project name of this emp.
	 *
	 * @param projectName the project name of this emp
	 */
	@Override
	public void setProjectName(String projectName) {
		model.setProjectName(projectName);
	}

	/**
	 * Sets the uuid of this emp.
	 *
	 * @param uuid the uuid of this emp
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EmpWrapper wrap(Emp emp) {
		return new EmpWrapper(emp);
	}

}