DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
id INT(4) PRIMARY KEY NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(15) NOT NULL
);

INSERT INTO ACCOUNTS (id, last_name, phone_number) VALUES
  (111, 'Smith', '07943437564'),
  (222, 'Brown', '08473620586'),
  (333, 'Johnson', '02948574957');

