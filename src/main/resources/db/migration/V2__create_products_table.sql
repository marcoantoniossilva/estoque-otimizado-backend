CREATE SEQUENCE products_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 100;

CREATE TABLE products (
  id_product smallint check (id_product > 0) NOT NULL DEFAULT NEXTVAL ('products_seq'),
  description varchar(200) NOT NULL,
  bar_code varchar(13) NOT NULL,
  id_box varchar(11) NOT NULL,
  register_in TIMESTAMP(0) DEFAULT NULL,
  register_by smallint check (register_by > 0) NOT NULL,
  updated_in TIMESTAMP(0) DEFAULT NULL,
  updated_by smallint check (updated_by > 0) NOT NULL,
  PRIMARY KEY (id_product),
  CONSTRAINT products_ibfk_1 FOREIGN KEY (id_box) REFERENCES boxes (id_box) ON DELETE CASCADE,
  CONSTRAINT products_ibfk_2 FOREIGN KEY (register_by) REFERENCES users (id_user) ON DELETE CASCADE,
  CONSTRAINT products_ibfk_3 FOREIGN KEY (updated_by) REFERENCES users (id_user) ON DELETE CASCADE
);