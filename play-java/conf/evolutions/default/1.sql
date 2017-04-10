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

create table vuln_data (
  id                            bigint not null,
  type                          varchar(255),
  user_name                     varchar(255),
  password                      varchar(255),
  constraint pk_vuln_data primary key (id)
);
create sequence vuln_data_seq;


# --- !Downs

drop table if exists level;
drop sequence if exists Level_seq;

drop table if exists user;

drop table if exists vuln_data;
drop sequence if exists vuln_data_seq;

