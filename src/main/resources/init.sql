DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS review CASCADE;
DROP TABLE IF EXISTS book_order CASCADE;
DROP TABLE IF EXISTS order_detail CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_rows CASCADE;



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
    CONSTRAINT customer_email_not_empty CHECK (email <> ''),
  password varchar(16) NOT NULL,
    CONSTRAINT customer_password_not_empty CHECK (password <> ''),
  fullname varchar(30) NOT NULL,
    CONSTRAINT customer_fullname_not_empty CHECK (fullname <> ''),
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


CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER,
    	FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    total INTEGER DEFAULT 0,
	dateOfCreation DATE DEFAULT current_timestamp
);

CREATE TABLE order_rows (
	order_id INTEGER,
		FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE,
	book_id INTEGER,
		FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE OR REPLACE FUNCTION count_total_value() RETURNS TRIGGER AS '
    DECLARE
        total_price int;
		book_price int;
    BEGIN
		SELECT total INTO total_price FROM orders WHERE orders.id = NEW.orderId;
		SELECT price INTO book_price FROM book WHERE NEW.book_id = book.book_id;
        UPDATE orders SET total = total_price + (product_price * NEW.quantity) WHERE NEW.orderId = orders.id;
        RETURN NEW;
    END; '
    LANGUAGE plpgsql;



INSERT INTO users VALUES
    (1, 'user1@user1.com', 'user1', 'Urbin Andras'),
    (2, 'user2@user2.com', 'user2', 'Kovacs Peter');

INSERT INTO category(category_name) VALUES
    ('Sci-Fi'),
    ('Romantic'),
    ('Thriller'),
    ('Self-improvement');

INSERT INTO book(title, author, description, price, category_id) VALUES
    ('The Alchemist', 'Paulo Coelho', 'A great book', 20, 4),
    ('Pet Cemetery', 'Stephen King', 'Thrilling book', 25, 3);

INSERT INTO customer (email, password, fullname, address, cash_amount) VALUES
    ('customer1@customer.com', 'customer1', 'Vladimir Putin', '666, Moskow, Stalin Street 66, Russia', 50000);

INSERT INTO review values
    (1, 2, 1, 5, 'Recommended 5*', 'Got a nightmare from this one!');

INSERT INTO orders (customer_id) VALUES
	(1),
	(1);

INSERT INTO order_rows (order_id, book_id) VALUES
	(1, 2),
	(1, 1);
