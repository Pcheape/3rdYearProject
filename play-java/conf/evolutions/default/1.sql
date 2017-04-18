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
  id                            integer not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_level3data primary key (id)
);
create sequence level3data_seq;

create table user (
  usertype                      varchar(31) not null,
  email                         varchar(255) not null,
  password                      varchar(255),
  score                         integer,
  level                         integer,
  hint                          integer,
  solution                      integer,
  login_name                    varchar(255),
  constraint pk_user primary key (email)
);

create table vulndata (
  id                            integer not null,
  type                          varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_vulndata primary key (id)
);
create sequence vulndata_seq;


# --- !Downs

drop table if exists level;
drop sequence if exists Level_seq;

drop table if exists level3data;
drop sequence if exists level3data_seq;

drop table if exists user;

drop table if exists vulndata;
drop sequence if exists vulndata_seq;

