# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  user_id                       integer not null,
  password                      varchar(255),
  email                         varchar(255),
  login_name                    varchar(255),
  constraint pk_user primary key (user_id)
);
create sequence user_seq;


# --- !Downs

drop table if exists user;
drop sequence if exists user_seq;

