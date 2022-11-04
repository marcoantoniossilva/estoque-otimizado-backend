CREATE SEQUENCE products_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 100;

CREATE TABLE products (
  id smallint check (id > 0) NOT NULL DEFAULT NEXTVAL ('products_seq'),
  description varchar(200) NOT NULL,
  barcode varchar(13) NOT NULL,
  box_id smallint check (box_id > 0) NOT NULL,
  register_in TIMESTAMP(0) NOT NULL,
  register_by smallint check (register_by > 0) NOT NULL,
  updated_in TIMESTAMP(0) DEFAULT NULL,
  updated_by smallint check (updated_by > 0) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT products_ibfk_1 FOREIGN KEY (box_id) REFERENCES boxes (id),
  CONSTRAINT products_ibfk_2 FOREIGN KEY (register_by) REFERENCES users (id),
  CONSTRAINT products_ibfk_3 FOREIGN KEY (updated_by) REFERENCES users (id)
);