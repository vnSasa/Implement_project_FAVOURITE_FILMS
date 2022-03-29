## implementation of the maven project "library of favorite movies"

- the administrator fills the movie library;

- users can browse the library and add favorite movies to their own library;

create DB in MySQL: 

CREATE DATABASE my_films
CHARACTER SET utf8
COLLATE utf8_general_ci;

CREATE TABLE my_films.user (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  role varchar(255) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE my_films.product (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  genre varchar(255) NOT NULL,
  alternativegenre varchar(255) NOT NULL,
  release int NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE my_films.bucket (
  id int NOT NULL AUTO_INCREMENT,
  user_id int DEFAULT NULL,
  product_id int DEFAULT NULL,
  purchase_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
)

ALTER TABLE my_films.bucket
ADD CONSTRAINT product_id_FK FOREIGN KEY (product_id)
REFERENCES my_films.product (id) ON DELETE CASCADE;

ALTER TABLE my_films.bucket
ADD CONSTRAINT user_id_FK FOREIGN KEY (user_id)
REFERENCES my_films.user (id) ON DELETE CASCADE;