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

import com.handsonliferay.apress_service_builder.model.book;
import com.handsonliferay.apress_service_builder.model.bookModel;
import com.handsonliferay.apress_service_builder.model.bookSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the book service. Represents a row in the &quot;apress_book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>bookModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link bookImpl}.
 * </p>
 *
 * @author Apoorva_Inthiyaz
 * @see bookImpl
 * @generated
 */
@JSON(strict = true)
public class bookModelImpl extends BaseModelImpl<book> implements bookModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a book model instance should use the <code>book</code> interface instead.
	 */
	public static final String TABLE_NAME = "apress_book";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"bookId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"chapterId", Types.BIGINT}, {"chapterName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"isCoding", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("chapterId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("chapterName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("isCoding", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table apress_book (uuid_ VARCHAR(75) null,bookId LONG not null primary key,groupId LONG,companyId LONG,chapterId LONG,chapterName VARCHAR(75) null,createDate DATE null,isCoding BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table apress_book";

	public static final String ORDER_BY_JPQL = " ORDER BY book.chapterId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY apress_book.chapterId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISCODING_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CHAPTERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static book toModel(bookSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		book model = new bookImpl();

		model.setUuid(soapModel.getUuid());
		model.setBookId(soapModel.getBookId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setChapterId(soapModel.getChapterId());
		model.setChapterName(soapModel.getChapterName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setIsCoding(soapModel.isIsCoding());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<book> toModels(bookSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<book> models = new ArrayList<book>(soapModels.length);

		for (bookSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public bookModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bookId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return book.class;
	}

	@Override
	public String getModelClassName() {
		return book.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<book, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<book, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<book, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((book)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<book, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<book, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((book)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<book, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<book, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, book>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			book.class.getClassLoader(), book.class, ModelWrapper.class);

		try {
			Constructor<book> constructor =
				(Constructor<book>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<book, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<book, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<book, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<book, Object>>();
		Map<String, BiConsumer<book, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<book, ?>>();

		attributeGetterFunctions.put("uuid", book::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<book, String>)book::setUuid);
		attributeGetterFunctions.put("bookId", book::getBookId);
		attributeSetterBiConsumers.put(
			"bookId", (BiConsumer<book, Long>)book::setBookId);
		attributeGetterFunctions.put("groupId", book::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<book, Long>)book::setGroupId);
		attributeGetterFunctions.put("companyId", book::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<book, Long>)book::setCompanyId);
		attributeGetterFunctions.put("chapterId", book::getChapterId);
		attributeSetterBiConsumers.put(
			"chapterId", (BiConsumer<book, Long>)book::setChapterId);
		attributeGetterFunctions.put("chapterName", book::getChapterName);
		attributeSetterBiConsumers.put(
			"chapterName", (BiConsumer<book, String>)book::setChapterName);
		attributeGetterFunctions.put("createDate", book::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<book, Date>)book::setCreateDate);
		attributeGetterFunctions.put("isCoding", book::getIsCoding);
		attributeSetterBiConsumers.put(
			"isCoding", (BiConsumer<book, Boolean>)book::setIsCoding);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookId = bookId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getChapterId() {
		return _chapterId;
	}

	@Override
	public void setChapterId(long chapterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_chapterId = chapterId;
	}

	@JSON
	@Override
	public String getChapterName() {
		if (_chapterName == null) {
			return "";
		}
		else {
			return _chapterName;
		}
	}

	@Override
	public void setChapterName(String chapterName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_chapterName = chapterName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public boolean getIsCoding() {
		return _isCoding;
	}

	@JSON
	@Override
	public boolean isIsCoding() {
		return _isCoding;
	}

	@Override
	public void setIsCoding(boolean isCoding) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isCoding = isCoding;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsCoding() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isCoding"));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), book.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public book toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, book>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		bookImpl bookImpl = new bookImpl();

		bookImpl.setUuid(getUuid());
		bookImpl.setBookId(getBookId());
		bookImpl.setGroupId(getGroupId());
		bookImpl.setCompanyId(getCompanyId());
		bookImpl.setChapterId(getChapterId());
		bookImpl.setChapterName(getChapterName());
		bookImpl.setCreateDate(getCreateDate());
		bookImpl.setIsCoding(isIsCoding());

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public book cloneWithOriginalValues() {
		bookImpl bookImpl = new bookImpl();

		bookImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		bookImpl.setBookId(this.<Long>getColumnOriginalValue("bookId"));
		bookImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		bookImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		bookImpl.setChapterId(this.<Long>getColumnOriginalValue("chapterId"));
		bookImpl.setChapterName(
			this.<String>getColumnOriginalValue("chapterName"));
		bookImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		bookImpl.setIsCoding(this.<Boolean>getColumnOriginalValue("isCoding"));

		return bookImpl;
	}

	@Override
	public int compareTo(book book) {
		int value = 0;

		if (getChapterId() < book.getChapterId()) {
			value = -1;
		}
		else if (getChapterId() > book.getChapterId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof book)) {
			return false;
		}

		book book = (book)object;

		long primaryKey = book.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<book> toCacheModel() {
		bookCacheModel bookCacheModel = new bookCacheModel();

		bookCacheModel.uuid = getUuid();

		String uuid = bookCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			bookCacheModel.uuid = null;
		}

		bookCacheModel.bookId = getBookId();

		bookCacheModel.groupId = getGroupId();

		bookCacheModel.companyId = getCompanyId();

		bookCacheModel.chapterId = getChapterId();

		bookCacheModel.chapterName = getChapterName();

		String chapterName = bookCacheModel.chapterName;

		if ((chapterName != null) && (chapterName.length() == 0)) {
			bookCacheModel.chapterName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			bookCacheModel.createDate = createDate.getTime();
		}
		else {
			bookCacheModel.createDate = Long.MIN_VALUE;
		}

		bookCacheModel.isCoding = isIsCoding();

		return bookCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<book, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<book, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<book, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((book)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<book, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<book, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<book, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((book)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, book>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _bookId;
	private long _groupId;
	private long _companyId;
	private long _chapterId;
	private String _chapterName;
	private Date _createDate;
	private boolean _isCoding;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<book, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((book)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("bookId", _bookId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("chapterId", _chapterId);
		_columnOriginalValues.put("chapterName", _chapterName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("isCoding", _isCoding);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("bookId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("chapterId", 16L);

		columnBitmasks.put("chapterName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("isCoding", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private book _escapedModel;

}