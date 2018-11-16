-- -----------------------------------------------------
-- Schema edata
-- -----------------------------------------------------


-- -------------------------------------------------------
-- -------------------------------------------------------
-- For testing purposes,to drop schema each time on startup
-- Each time that application startups ,deletes previous data
DROP SCHEMA IF EXISTS edata;
-- -------------------------------------------------------
-- -------------------------------------------------------



CREATE SCHEMA IF NOT EXISTS edata DEFAULT CHARACTER SET utf8 ;
USE edata ;

create table if not exists country
(
  countryName varchar(60) not null
    primary key,
  phonePrefix varchar(20)  not null,
  isoCodes    varchar(10) not null,
  constraint country_iso_codes_uindex
  unique (isoCodes)

);

create table if not exists dataFormat
(
  format varchar(10) not null
    primary key
);

create table if not exists nasaPowerIdentifier
(
  identifier varchar(20) not null
    primary key
);

create table if not exists pressureUnit
(
  unitCode        varchar(10)  not null
    primary key,
  unitName        varchar(30) not null,
  unitDescription text        null
);

create table if not exists temperatureUnit
(
  unitCode        varchar(5)  not null
    primary key,
  unitName        varchar(30) not null,
  unitDescription text        null
);

create table if not exists users
(
  id          varchar(60)          not null
    primary key,
  firstName   varchar(60)          not null,
  lastName    varchar(60)          not null,
  password    varchar(160)         not null,
  email       varchar(60)          not null,
  gender      enum ('M', 'F', 'O') not null,
  birthday    date                 null,
  birthplace  varchar(100)         null,
  country     varchar(60)          not null,
  rights      varchar(60)          not null,
  createdDate datetime             not null,
  updatedDate datetime             null,
  constraint users_country_country_name_fk
  foreign key (country) references country (countryName)
);

create table if not exists nasaPowerPressure
(
  id            int(100)     not null
    primary key,
  userId        varchar(60)  not null,
  value         float        not null,
  unit          varchar(10)   not null,
  startDate     date         not null,
  endDate       date         not null,
  url           varchar(150) not null,
  identifier    varchar(20)  not null,
  rawDataFormat varchar(10)  not null,
  constraint nasaPowerPressure_dataFormat_format_fk
  foreign key (rawDataFormat) references dataFormat (format),
  constraint nasaPowerPressure_nasaPowerIdentifier_identifier_fk
  foreign key (identifier) references nasaPowerIdentifier (identifier),
  constraint nasaPowerPressure_pressureUnit_unitCode_fk
  foreign key (unit) references pressureUnit (unitcode),
  constraint nasaPowerPressure_users_id_fk
  foreign key (userId) references users (id)
);

create table if not exists nasaPowerTemperature
(
  id            int(100)     not null
    primary key,
  userId        varchar(60)  null,
  value         float        not null,
  unit          varchar(5)   not null,
  startDate     date         not null,
  endDate       date         not null,
  url           varchar(150) not null,
  identifier    varchar(20)  not null,
  rawDataFormat varchar(10)  null,
  constraint nasaPowerTemperature_dataFormat_format_fk
  foreign key (rawDataFormat) references dataFormat (format),
  constraint nasaPowerTemperature_nasaPowerIdentifier_identifier_fk
  foreign key (identifier) references nasaPowerIdentifier (identifier),
  constraint nasaPowerTemperature_temperatureUnit_unitCode_fk
  foreign key (unit) references temperatureUnit (unitcode),
  constraint nasaPowerTemperature_users_id_fk
  foreign key (userId) references users (id),
  constraint nasaPowerTemperature_users_id_fk_2
  foreign key (userId) references users (id)
);

