DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS cart;

CREATE TABLE IF NOT EXISTS products (ID bigserial NOT NULL, TITLE varchar(255) NOT NULL, PRICE real NOT NULL DEFAULT 0.55, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS products (ID bigserial NOT NULL, TITLE varchar(255) NOT NULL, PRICE real NOT NULL DEFAULT 0.00, COUNT integer NOT NULL default  0, PRIMARY KEY (ID));

INSERT INTO products (TITLE, PRICE) VALUES ('Milk', 1.05),('Eggs', 2.15),('Nuts', 4.09),('Beer', 3.12),('Fish', 2.78),('Ice cream', 0.99),('Curd cheese', 0.83);
