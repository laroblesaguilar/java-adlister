CREATE DATABASE adlister_db;
CREATE USER 'luisad'@'localhost' IDENTIFIED BY 'codeup';
GRANT ALL ON adlister_db.* TO 'luisad'@'localhost';

USE adlister_db;

CREATE TABLE users(
id int unsigned not null primary key auto_increment,
username varchar(200) not null,
email varchar(200) unique not null,
password varchar(200)
);

CREATE TABLE ads(
id int unsigned not null primary key auto_increment,
user_id int unsigned not null,
title varchar(200),
description varchar(200),
foreign key (user_id) references users (id)
);

insert into users(username, email, password) values ('test','test','test');