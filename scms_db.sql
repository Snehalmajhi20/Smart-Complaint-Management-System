Create database SCMS_DB;
use SCMS_DB;
show tables;
CREATE TABLE users(
id INT PRIMARY KEY auto_increment,
name varchar(100),
email varchar(100) unique,
password varchar(100),
role varchar(20) default 'users');
desc users;

select * from users;

CREATE TABLE departments(
id INT PRIMARY KEY auto_increment,
name varchar(100),
email varchar(100));
desc departments;
select * from departments;

CREATE TABLE complaints (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  category VARCHAR(100),
  description TEXT,
  status VARCHAR(30) DEFAULT 'Pending',
  assigned_to VARCHAR(100) DEFAULT 'Not Assigned',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
desc complaints;
select * from complaints;
