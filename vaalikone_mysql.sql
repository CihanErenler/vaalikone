create database vaalikone;
use vaalikone;

CREATE TABLE admin (
id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
fname varchar(255) NOT NULL,
lname varchar(255) NOT NULL,
email varchar(255) NOT NULL,
pwd varchar(255) NOT NULL
);

CREATE TABLE candidate (
id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
fname varchar(255) NOT NULL,
lname varchar(255) NOT NULL,
city varchar(255) NOT NULL,
age int NOT NULL,
profession varchar(255) NOT NULL,
political_party varchar(255) NOT NULL,
why_candidate text NOT NULL,
about text NOT NULL,
profile_pic text NOT NULL
);

CREATE TABLE question (
id int auto_increment PRIMARY KEY NOT NULL,
question text NOT NULL
);

CREATE TABLE answer (
id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
can_id int NOT NULL,
question_id int NOT NULL,
answer enum('1','2', '3', '4', '5') NOT NULL,
FOREIGN KEY (can_id) REFERENCES candidate (id) ON DELETE CASCADE,
FOREIGN KEY (question_id) REFERENCES question (id) ON DELETE CASCADE 
);

INSERT INTO admin (fname, lname, email, pwd) VALUES
("Anna", "Kot", "anna@anna.anna", "Password1"),
("Cihan", "Erenler", "cihan@cihan.cihan", "Password1");

INSERT INTO candidate (fname, lname, city, age, profession, political_party, why_candidate, about, profile_pic) VALUES
("Rubeus", "Hagrid", "Hogwards", 72, "Teacher", "Gryffindor", "I am good with animals so I must be good with humans too, theyre much more stupid", "I am awesome and huge", "rubeus-hagrid.jpg"),
("James", "Howlett", "Canada", 189, "Intelligence operative", "X-men", "Release the wolves, reforest the environment, go wild", "Handsome and deadly", "wolverine.jpg");

INSERT INTO question (question) VALUES
("I am always protecting animals rights and their well-being."),
("I prefer anarchy over the order."),
("Military action that defies international law is sometimes justified."),
("There is now a worrying fusion of information and entertainment.");

INSERT INTO answer (can_id, question_id, answer) VALUES
(1, 1, 5),
(1, 2, 3),
(1, 3, 1),
(1, 4, 3);

INSERT INTO answer (can_id, question_id, answer) VALUES
(2, 1, 5),
(2, 2, 1),
(2, 3, 2),
(2, 4, 4);
