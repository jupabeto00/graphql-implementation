drop table if exists accounts cascade ;
drop table if exists credit_cards cascade ;
drop table if exists credits cascade ;
drop table if exists movements cascade ;
drop table if exists products cascade ;
drop table if exists users cascade ;
create table accounts (balance float(53) not null, id bigint generated by default as identity, product_id bigint not null unique, primary key (id));
create table credit_cards (balance float(53) not null, id bigint generated by default as identity, product_id bigint not null unique, primary key (id));
create table credits (balance float(53) not null, id bigint generated by default as identity, product_id bigint not null unique, primary key (id));
create table movements (amount float(53) not null, created_at timestamp(6) not null, id bigint generated by default as identity, product_id bigint not null, transaction_date timestamp(6) not null, description varchar(255) not null, primary key (id));
create table products (user_id bigint not null, created_date timestamp(6) not null, id bigint generated by default as identity, number varchar(10) not null, type varchar(255) not null, primary key (id));
create table users (created_date timestamp(6) not null, id bigint generated by default as identity, name varchar(10) not null, primary key (id));
alter table if exists accounts add constraint FK4dmgcni7d05i3ka4ynr2uqahx foreign key (product_id) references products;
alter table if exists credit_cards add constraint FKc7xrjtwf55mev7g1jgy123ti2 foreign key (product_id) references products;
alter table if exists credits add constraint FKghl6s72fpuang0uqtahrcxj0 foreign key (product_id) references products;
alter table if exists movements add constraint FKsa9yjx1fbsv0amnaa0ffrdu33 foreign key (product_id) references products;
alter table if exists products add constraint FKsa9yjx1fbsv0amnaa0ffrck10 foreign key (user_id) references users;
