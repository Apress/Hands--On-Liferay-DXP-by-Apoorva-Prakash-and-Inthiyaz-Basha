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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ApressBook service. Represents a row in the &quot;apress_ApressBook&quot; database table, with each column mapped to a property of this class.
 *
 * @author Apoorva_Inthiyaz
 * @see ApressBookModel
 * @generated
 */
@ImplementationClassName(
	"com.handsonliferay.apress_service_builder.model.impl.ApressBookImpl"
)
@ProviderType
public interface ApressBook extends ApressBookModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.handsonliferay.apress_service_builder.model.impl.ApressBookImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ApressBook, Long> BOOK_ID_ACCESSOR =
		new Accessor<ApressBook, Long>() {

			@Override
			public Long get(ApressBook apressBook) {
				return apressBook.getBookId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ApressBook> getTypeClass() {
				return ApressBook.class;
			}

		};

}