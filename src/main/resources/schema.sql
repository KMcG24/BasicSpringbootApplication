DROP TABLE IF EXISTS account;

CREATE TABLE account (
account_id LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(15) NOT NULL
);
