# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  usertype                      varchar(31) not null,
  email                         varchar(255) not null,
  password                      varchar(255),
  score                         integer,
  login_name                    varchar(255),
  constraint pk_user primary key (email)
);


# --- !Downs

drop table if exists user;

