CREATE TABLE MEMBER (
    ID VARCHAR(255) NOT NULL,
    NAME VARCHAR(255),
    age INTEGER,
    roleType varchar(255),
    createdDate timestamp,
    lastModifiedDate timestamp,
    description clob,
    PRIMARY KEY (ID)
);
