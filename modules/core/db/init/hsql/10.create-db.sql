-- begin CEOTOCF_ORDER
create table CEOTOCF_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    DELIVERY_ADDRESS_ID varchar(36),
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CEOTOCF_ORDER
-- begin CEOTOCF_CUSTOMER
create table CEOTOCF_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    INVOICE_ADDRESS_ID varchar(36),
    --
    primary key (ID)
)^
-- end CEOTOCF_CUSTOMER
-- begin CEOTOCF_ADDRESS
create table CEOTOCF_ADDRESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STREET varchar(255),
    HOUSE_NUMBER varchar(255),
    POSTCODE varchar(255),
    CITY varchar(255),
    --
    primary key (ID)
)^
-- end CEOTOCF_ADDRESS
-- begin CEOTOCF_PRODUCER
create table CEOTOCF_PRODUCER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    ADDRESS_ID varchar(36),
    --
    primary key (ID)
)^
-- end CEOTOCF_PRODUCER
