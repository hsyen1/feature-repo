DROP TABLE IF EXISTS user;
create table user (
    id integer auto_increment not null,
    email varchar(64) not null,
    name varchar(64) not null,
    created_date timestamp,
    primary key (id),
    unique(email)
);

drop table if exists feature;
create table feature (
    id integer auto_increment not null,
    feature_name varchar(64) not null,
    feature_description varchar(64) not null,
    primary key (id),
    unique(feature_name)
);

drop table if exists user_feature_access;
create table user_feature_access (
    id integer auto_increment not null,
    user_id integer not null,
    feature_id integer not null,
    primary key (id)
);

-- mock data for user table
insert into user (id, email, name, created_date)
values (1, 'john@testing.com', 'John Doe', sysdate());

insert into user (id, email, name, created_date)
values (2, 'jack@testing.com', 'Jack Kyle', sysdate());

insert into user (id, email, name, created_date)
values (3, 'raj@testing.com', 'Raj Luke', sysdate());

insert into user (id, email, name, created_date)
values (4, 'may@testing.com', 'May Vee', sysdate());


-- mock data for feature table
insert into feature (id, feature_name, feature_description)
values (1, 'VIEW_CONSOLE', 'View Console');

insert into feature (id, feature_name, feature_description)
values (2, 'EDIT_CONSOLE', 'Edit Console');

insert into feature (id, feature_name, feature_description)
values (3, 'VIEW_TXN_HISTORY', 'View Transaction History');

insert into feature (id, feature_name, feature_description)
values (4, 'DOWNLOAD_TXN_HISTORY', 'Download Transaction History');


-- mock access for users
insert into user_feature_access (id, user_id, feature_id)
values (1, 3, 3);

insert into user_feature_access (id, user_id, feature_id)
values (2, 3, 4);

insert into user_feature_access (id, user_id, feature_id)
values (3, 1, 1);