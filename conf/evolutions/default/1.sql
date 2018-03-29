# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table driver (
  driver_id                     integer auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  nic                           varchar(255),
  mobile_number                 varchar(255),
  email                         varchar(255),
  rating                        integer,
  constraint pk_driver primary key (driver_id)
);


# --- !Downs

drop table if exists driver;

