DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE public.customers (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               name VARCHAR(250) not null,
                               email VARCHAR(250) not null,
                               age INT NOT NULL,
                               phone_numbers INT not null ,
                               password VARCHAR(250) not null,
                               customer_id INTEGER REFERENCES employers (id) not null

);

DROP TABLE IF EXISTS accounts CASCADE;
CREATE TABLE public.accounts (
                       id INTEGER AUTO_INCREMENT PRIMARY KEY,
                       number VARCHAR(250) not null,
                       currency VARCHAR(3) not null,
                       balance NUMERIC (12,2) not null DEFAULT 0,
                       customer_id INTEGER REFERENCES customers (id) not null,
                       account_id INTEGER references accounts (id) not null
);

DROP TABLE IF EXISTS employers CASCADE;
CREATE TABLE public.employers (
                       id INTEGER AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(250) not null,
                       address VARCHAR(250) not null
);

DROP TABLE IF EXISTS customerEmployment CASCADE;
CREATE TABLE public.customerEmployment (
                       id INTEGER AUTO_INCREMENT PRIMARY KEY,
                       customer_id INTEGER REFERENCES customers (id) not null,
                       employer_id INTEGER REFERENCES employers (id) not null
);

