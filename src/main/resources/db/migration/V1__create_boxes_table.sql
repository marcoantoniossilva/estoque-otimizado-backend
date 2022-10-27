CREATE TABLE boxes (
  id_box varchar(11) NOT NULL,
  street varchar(2) NOT NULL,
  rack varchar(2) NOT NULL,
  box_column varchar(2) NOT NULL,
  line varchar(2) NOT NULL,
  register_in TIMESTAMP(0) DEFAULT NULL,
  register_by smallint check (register_by > 0) NOT NULL,
  updated_in TIMESTAMP(0) DEFAULT NULL,
  updated_by smallint check (updated_by > 0) NOT NULL,
  PRIMARY KEY (id_box),
  CONSTRAINT boxes_ibfk_1 FOREIGN KEY (register_by) REFERENCES users (id_user) ON DELETE CASCADE,
  CONSTRAINT boxes_ibfk_2 FOREIGN KEY (updated_by) REFERENCES users (id_user) ON DELETE CASCADE
);