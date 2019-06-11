DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS review CASCADE;
DROP TABLE IF EXISTS book_order CASCADE;
DROP TABLE IF EXISTS order_detail CASCADE;


CREATE TABLE users (
  user_id SERIAL NOT NULL,
  email varchar(30) NOT NULL,
  password varchar(16) NOT NULL,
  full_name varchar(30) NOT NULL,
  PRIMARY KEY (user_id),
  CONSTRAINT user_id_UNIQUE UNIQUE  (user_id)
);


CREATE TABLE category (
  category_id SERIAL NOT NULL,
  category_name varchar(30) NOT NULL,
  PRIMARY KEY (category_id),
  CONSTRAINT category_id_UNIQUE UNIQUE  (category_id)
);


CREATE TABLE book (
  book_id SERIAL NOT NULL,
  title varchar(128) NOT NULL,
  author varchar(64) NOT NULL,
  description text NOT NULL,
  price int NOT NULL,
  category_id int NOT NULL,
  PRIMARY KEY (book_id),
  CONSTRAINT book_id_UNIQUE UNIQUE  (book_id),
  CONSTRAINT title_UNIQUE UNIQUE  (title),
  CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX category_fk_idx ON book (category_id);



CREATE TABLE customer (
  customer_id SERIAL NOT NULL,
  email varchar(64) NOT NULL,
  password varchar(16) NOT NULL,
  fullname varchar(30) NOT NULL,
  address varchar(128) NOT NULL,
  cash_amount int DEFAULT 50000,
  PRIMARY KEY (customer_id),
  CONSTRAINT customer_id_UNIQUE UNIQUE  (customer_id),
  CONSTRAINT email_UNIQUE UNIQUE  (email)
);



CREATE TABLE review (
  review_id SERIAL NOT NULL,
  book_id int NOT NULL,
  customer_id int NOT NULL,
  rating int NOT NULL,
  headline varchar(128) NOT NULL,
  comment varchar(500) NOT NULL,
  PRIMARY KEY (review_id),
  CONSTRAINT review_id_UNIQUE UNIQUE  (review_id),
  CONSTRAINT book_fk FOREIGN KEY (book_id) REFERENCES book (book_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT customer_fk FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX book_fk_idx ON review (book_id);
CREATE INDEX customer_fk_idx ON review (customer_id);


CREATE TABLE book_order (
  order_id SERIAL NOT NULL,
  customer_id int NOT NULL,
  shipping_address varchar(256) NOT NULL,
  recipient_name varchar(30) NOT NULL,
  order_date DATE NOT NULL DEFAULT CURRENT_DATE,
  total double precision NOT NULL,
  status varchar(20) NOT NULL,
  PRIMARY KEY (order_id),
  CONSTRAINT order_id_UNIQUE UNIQUE  (order_id),
  CONSTRAINT customer_fk_2 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE order_detail (
  order_id int DEFAULT NULL,
  book_id int DEFAULT NULL,
  quantity int NOT NULL,
  subtotal double precision NOT NULL,
  CONSTRAINT book_fk_2 FOREIGN KEY (book_id) REFERENCES book (book_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES book_order (order_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX order_fk_idx ON order_detail (order_id);
CREATE INDEX book_fk_2_idx ON order_detail (book_id);


INSERT INTO users VALUES
    (1, 'user1@user1.com', 'user1', 'Urbin Andras'),
    (2, 'user2@user2.com', 'user2', 'Kovacs Peter');

INSERT INTO category VALUES
    (1, 'Sci-Fi'),
    (2, 'Romantic'),
    (3, 'Thriller'),
    (4, 'Self-improvement');

INSERT INTO book VALUES
    (1, 'The Alchemist', 'Paulo Coelho', 'A great book', 20, 4),
    (2, 'Pet Cemetery', 'Stephen King', 'Thrilling book', 25, 3);

INSERT INTO customer (email, password, fullname, address, cash_amount) VALUES
    ('customer1@customer.com', 'customer1', 'Vladimir Putin', '666, Moskow, Stalin Street 66, Russia', 50000);

INSERT INTO review values
    (1, 2, 1, 5, 'Recommended 5*', 'Got a nightmare from this one!');

INSERT INTO book_order VALUES
    (1, 1, '666, Moskow, Stalin Street 66, Russia', 'Vladimir Putin', '2017-07-11', 20, 'Under delivery');

INSERT INTO order_detail VALUES
    (1, 1, 1, 20);
