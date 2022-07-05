create table apress_ApressBook (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	chapterId LONG,
	chapterName VARCHAR(75) null,
	createDate DATE null,
	isCoding BOOLEAN
);

create table apress_Emp (
	uuid_ VARCHAR(75) null,
	EmpId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	projectId LONG,
	projectName VARCHAR(75) null,
	createDate DATE null,
	isCoding BOOLEAN
);

create table apress_book (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	chapterId LONG,
	chapterName VARCHAR(75) null,
	createDate DATE null,
	isCoding BOOLEAN
);