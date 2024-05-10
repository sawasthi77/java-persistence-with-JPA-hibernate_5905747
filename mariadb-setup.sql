-- Create a table in the database
CREATE TABLE MyTable (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  Item VARCHAR(255),
  PRIMARY KEY (ID)
);

-- Populate the table
INSERT INTO MyTable (Item) VALUES ('One'), ('Two'), ('Three');

-- After running this setup file, run the contents of mariadb-test.sql. Just open the file and click 