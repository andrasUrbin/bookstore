DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS review CASCADE;

CREATE TABLE users (
	user_id SERIAL NOT NULL UNIQUE PRIMARY KEY,
	email varchar(30) NOT NULL,
	password varchar(16) NOT NULL,
	full_name varchar(30) NOT NULL
);

CREATE TABLE category (
	category_id SERIAL NOT NULL UNIQUE PRIMARY KEY,
	category_name varchar(30) NOT NULL
);

CREATE TABLE book (
	book_id SERIAL NOT NULL UNIQUE PRIMARY KEY,
	title varchar(128) UNIQUE NOT NULL,
	author varchar(64) NOT NULL,
	description text NOT NULL,
	isbn varchar(15) NOT NULL,
	image bytea NOT NULL,
	price float NOT NULL,
	publish_date date NOT NULL,
	last_update_time date NOT NULL,
	category_id SERIAL NOT NULL
);

CREATE TABLE customer (
	customer_id SERIAL NOT NULL UNIQUE PRIMARY KEY,
	email varchar(64) NOT NULL UNIQUE,
	fullname varchar(30) NOT NULL,
	address varchar(128) NOT NULL,
	city varchar(32) NOT NULL,
	country varchar(64) NOT NULL,
	phone varchar(15) NOT NULL,
	zipcode varchar(24) NOT NULL,
	customer_password varchar(16) NOT NULL,
	register_date date NOT NULL
);

CREATE TABLE review (
	review_id SERIAL UNIQUE NOT NULL PRIMARY KEY,
	book_id INTEGER NOT NULL, 
	customer_id INTEGER NOT NULL,
	rating INTEGER NOT NULL,
	headline varchar(128) NOT NULL,
	review_comment varchar(500) NOT NULL,
	review_time date NOT NULL
);

ALTER TABLE book
	ADD CONSTRAINT category_id FOREIGN KEY (category_id) REFERENCES category (category_id);

ALTER TABLE review
	ADD CONSTRAINT book_id FOREIGN KEY (book_id) REFERENCES book (book_id);
	
ALTER TABLE review
	ADD CONSTRAINT customer_id FOREIGN KEY (customer_id) REFERENCES customer (customer_id);