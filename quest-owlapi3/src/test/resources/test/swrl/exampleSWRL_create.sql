CREATE TABLE PERSON (
    ID INT  PRIMARY KEY,
    NAME VARCHAR(255),
    HAS_CAR BOOLEAN,
    GENDER CHAR(1),
    AGE INT
);       

CREATE TABLE SIBLING(
    ID1 INT,
    ID2 INT
);

CREATE TABLE SPOUSE(
    ID1 INT,
    ID2 INT
);

CREATE TABLE PARENT(
    CHILD_ID INT,
    PARENT_ID INT
);
