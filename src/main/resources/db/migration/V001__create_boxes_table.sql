CREATE SEQUENCE boxes_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 100;

CREATE TABLE boxes (
  id_box smallint check (id > 0) NOT NULL DEFAULT NEXTVAL ('boxes_seq'),
  street varchar(2) NOT NULL,
  rack varchar(2) NOT NULL,
  box_column varchar(2) NOT NULL,
  line varchar(2) NOT NULL,
  PRIMARY KEY (id_box)
);