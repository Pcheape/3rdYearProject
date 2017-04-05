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


# --- !Downs

drop table if exists level;
drop sequence if exists Level_seq;

drop table if exists user;

