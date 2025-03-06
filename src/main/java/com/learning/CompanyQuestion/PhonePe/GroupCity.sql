question
https://www.db-fiddle.com/f/rjQ3XobsvnHKLbHKd4QKuH/4


-- Problem Statement:
-- We are running an online classroom. Students sign up on
-- our platform. During sign up, they provide us their name
-- and the city they come from. Providing city is optional, so
-- some students do not provide that. Our database schema is
-- as follows.

-- We need to write SQL query to find out how many students
-- we have from each city. The report should have two
-- columns - the left column should have the name of the city
-- and the right column should have the number of students
-- from each city.

-- Expected output (order of rows does not matter):
-- Delhi  2
-- Jaipur 1
-- Patna  3
-- null   3



Answer
select c.name,count(*) from city c
right join student st on st.city_id= c.id group by c.name;

CREATE TABLE city (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);


CREATE TABLE student (
  id INTEGER NOT NULL PRIMARY KEY,
  name vARCHAR(100) NOT NULL,
  city_id INTEGER,
  FOREIGN KEY (city_id) REFERENCES city(id)
);


INSERT INTO city
(id, name)
VALUES
(1, 'Delhi'),
(2, 'Jaipur'),
(3, 'Patna'),
(4, 'Pune');

INSERT INTO student
(id, name, city_id)
VALUES
(1, 'Ravi',    1),
(2, 'Ajay',    1),
(3, 'Shubham', 2),
(4, 'Mansi',   null),
(5, 'Rachna',  3),
(6, 'Mohit',   3),
(7, 'Ankita',  null),
(8, 'Anshul',  3),
(9, 'Sanchit', null);
