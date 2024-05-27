USE library;
ALTER TABLE IF EXISTS book
ADD COLUMN author_id INT;
ALTER TABLE book
ADD CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES author(author_id);
INSERT INTO author(author_name)
values ("Jane"),
  ("Allen"),
  ("John");
INSERT INTO book(book_name, isbn, author_id)
values ("Book1", "111-1111", 1),
  ("Book2", "222-2222", 1),
  ("Book3", "333-3333", 2);