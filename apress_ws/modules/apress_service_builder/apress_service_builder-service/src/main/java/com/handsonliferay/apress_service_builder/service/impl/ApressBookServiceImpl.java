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

package com.handsonliferay.apress_service_builder.service.impl;

import com.handsonliferay.apress_service_builder.service.base.ApressBookServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Apoorva_Inthiyaz
 */
@Component(
	property = {
		"json.web.service.context.name=apress",
		"json.web.service.context.path=ApressBook"
	},
	service = AopService.class
)
@JSONWebService("abs")
public class ApressBookServiceImpl extends ApressBookServiceBaseImpl {
	
	public String helloWorld(String worldName) {
	    return "Hello world: " + worldName;
	}
	
	@JSONWebService(value = "add-book-wow", method = "PUT")
	public boolean addBook() {
		return false;
	}
	
	@JSONWebService("/add-something-very-specific")
	public boolean addApressBook() {
		return true;
	}
}