USE library;
CREATE TABLE IF NOT EXISTS book_type(
  type_code VARCHAR(255),
  type_subcode VARCHAR(255),
  type_name VARCHAR(255),
  PRIMARY KEY(type_code, type_subcode)
);
INSERT INTO book_type(type_code, type_subcode, type_name)
values ("C001", "SC001", "Fiction-Horror"),
  ("C001", "SC002", "Fiction-Mistry"),
  ("C001", "SC003", "Fiction-Thriller");
ALTER TABLE IF EXISTS book
ADD COLUMN author_id INT;
ALTER TABLE book
ADD CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES author(author_id);
ALTER TABLE IF EXISTS author
ADD COLUMN street VARCHAR(255),
  ADD COLUMN city VARCHAR(255),
  ADD COLUMN postal_code VARCHAR(255);
INSERT INTO author(author_name, street, city, postal_code)
values ("Jane", "street1", "London", "12345"),
  ("Allen", "street2", "New York", "45678"),
  ("John", "street3", "London", "56789");
INSERT INTO book(book_name, isbn, author_id)
values ("Book1", "111-1111", 1),
  ("Book2", "222-2222", 1),
  ("Book3", "333-3333", 2);