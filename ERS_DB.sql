drop schema if exists ers cascade;
create schema ers;
set schema   'ers';

create table ers_reimbursement_status(
reimb_status_id serial primary key,
reimb_status text
);

create table ers_reimbursement_type(
reimb_type_id serial primary key,
reim_type text
);


create table ers_user_roles(
user_role_id serial primary key,
user_role text
);

create table ers_users(
ers_users_id serial primary key,
ers_username text unique,
ers_password text,
user_first_name text,
user_last_name text,
user_email text unique,
user_role_id  int references ers_user_roles(user_role_id)
);


create table ers_reimbursement(
reimb_id serial primary key,
reimb_amount numeric(10,2),
reimb_submitted timestamp,
reimb_resolved timestamp,
reimb_description text,
reimb_receipt oid,
reimb_author int references ers_users(ers_users_id),
reimb_resolver int references ers_users(ers_users_id),
reimb_status_id int references ers_reimbursement_status(reimb_status_id),
reimb_type_id int references ers_reimbursement_type(reimb_type_id)
);


insert into ers_reimbursement_status(reimb_status) values ('pending');
insert into ers_reimbursement_status (reimb_status) values ('denied');
insert into ers_reimbursement_status (reimb_status) values ('approved');


insert into ers_reimbursement_type (reim_type) values ('FOOD');
insert into ers_reimbursement_type (reim_type) values ('LODGING');
insert into ers_reimbursement_type (reim_type) values ('TRAVEL');
insert into ers_reimbursement_type (reim_type) values ('OTHER');


insert into ers_user_roles(user_role) values ('employee');
insert into ers_user_roles(user_role) values ('manager');

insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('mahesh','password','Mahesh','Kalle','mkalle@ers.com',1);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('james','bond','James','Bond','jbond@ers.com',1);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('smith','password','Will','Smith','wsmith@ers.com',2);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('noah','noah','Noah','Charlotte','noah@ers.com',2);
