create index IX_763B55F6 on apress_ApressBook (isCoding);
create index IX_CCAF96C2 on apress_ApressBook (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8F52E5C4 on apress_ApressBook (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_98EF3659 on apress_Emp (isCoding);
create index IX_C3FA6425 on apress_Emp (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_88A7AFE7 on apress_Emp (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5D77BAF4 on apress_book (isCoding);
create index IX_8F2E1DC0 on apress_book (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_85231442 on apress_book (uuid_[$COLUMN_LENGTH:75$], groupId);