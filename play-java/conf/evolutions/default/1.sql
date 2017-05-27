# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table level (
  id                            integer not null,
  password                      varchar(255),
  first_solved                  boolean,
  second_solved                 boolean,
  points                        integer,
  constraint pk_level primary key (id)
);
create sequence Level_seq;

create table level3data (
  id                            integer auto_increment not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_level3data primary key (id)
);

create table level4data (
  id                            integer auto_increment not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_level4data primary key (id)
);

create table level5data (
  id                            integer auto_increment not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_level5data primary key (id)
);

create table level6data (
  id                            integer auto_increment not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_level6data primary key (id)
);

create table user (
  usertype                      varchar(31) not null,
  email                         varchar(255) not null,
  password                      varchar(255),
  score                         integer,
  level                         integer,
  hint                          integer,
  solution                      integer,
  first_solve                   integer,
  second_solve                  integer,
  login_name                    varchar(255),
  constraint pk_user primary key (email)
);

create table vulndata (
  id                            integer auto_increment not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_vulndata primary key (id)
);


# --- !Downs

drop table if exists level;
drop sequence if exists Level_seq;

drop table if exists level3data;

drop table if exists level4data;

drop table if exists level5data;

drop table if exists level6data;

drop table if exists user;

drop table if exists vulndata;

