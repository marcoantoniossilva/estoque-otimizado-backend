CREATE SEQUENCE products_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 100;

CREATE TABLE products (
  id_product smallint check (id_product > 0) NOT NULL DEFAULT NEXTVAL ('products_seq'),
  description varchar(200) NOT NULL,
  bar_code varchar(13) NOT NULL,
  id_box varchar(11) NOT NULL,
  PRIMARY KEY (id_product),
  CONSTRAINT products_ibfk_1 FOREIGN KEY (id_box) REFERENCES boxes (id_box) ON DELETE CASCADE
);