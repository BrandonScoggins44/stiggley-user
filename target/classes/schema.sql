DROP TABLE IF EXISTS stiggley_user CASCADE;
CREATE TABLE IF NOT EXISTS stiggley_user
(id INTEGER NOT NULL,
username VARCHAR(25) UNIQUE NOT NULL,
password VARCHAR(25) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
PRIMARY KEY (id));

DROP SEQUENCE IF EXISTS stiggley_user_seq;
CREATE SEQUENCE IF NOT EXISTS stiggley_user_seq START WITH 5;