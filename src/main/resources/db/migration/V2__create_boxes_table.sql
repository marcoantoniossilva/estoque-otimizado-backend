CREATE SEQUENCE boxes_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 100;

CREATE TABLE boxes (
  id smallint check (id > 0) NOT NULL DEFAULT NEXTVAL ('boxes_seq'),
  code varchar(13) NOT NULL,
  street varchar(4) NOT NULL,
  rack varchar(3) NOT NULL,
  box_column varchar(3) NOT NULL,
  line varchar(3) NOT NULL,
  register_in TIMESTAMP(0) NOT NULL,
  register_by smallint check (register_by > 0) NOT NULL,
  updated_in TIMESTAMP(0) DEFAULT NULL,
  updated_by smallint check (updated_by > 0) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT boxes_ibfk_1 FOREIGN KEY (register_by) REFERENCES users (id),
  CONSTRAINT boxes_ibfk_2 FOREIGN KEY (updated_by) REFERENCES users (id)
);