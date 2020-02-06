DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
accountId INT(4) PRIMARY KEY NOT NULL,
lastName VARCHAR(50) NOT NULL,
phoneNumber VARCHAR(15) NOT NULL
);

INSERT INTO ACCOUNTS (accountId, lastName, phoneNumber) VALUES
  (111, 'Smith', '07943437564'),
  (222, 'Brown', '08473620586'),
  (333, 'Johnson', '02948574957'),
  (444, 'Maximus', '07382740976');

