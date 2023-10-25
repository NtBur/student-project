CREATE database my_db;

USE my_db;

CREATE TABLE students (
  id int NOT NULL AUTO_INCREMENT,
  first_name varchar(25),
  last_name varchar(25),
  email varchar(30),
  PRIMARY KEY (id)
) ;

INSERT INTO my_db.students (first_name, last_name, email)
VALUES
	('Ivan', 'Ivanchenko', 'ivan123@gmail.com'),
	('Stepan', 'Stepanchenko', 'stepan123@gmail.com'),
	('Petro', 'Petrenko', 'petro123@gmail.com');