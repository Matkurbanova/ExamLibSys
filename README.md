# ExamLibSys

email: bermet@gmail.com
пароль: 123

Я закинула проект в Heroku. Но там не заходит. 
Ввожу правильно логин и пароль, а пишет не верный логин 
и пароль.
Но сам проект работет. Я сделала скрин проекта и
 закинула как image.png. Можете оттуда посмотреть.


Create TABLE Author
(
 id int not null auto_increment primary key,
 name varchar(255),
 surname varchar(255),
 email varchar(255) ,
 password varchar(255)

);

Create TABLE Book
(
 id int not null auto_increment primary key,
publish_date timestamp,
quantity int not null,
title varchar(255),
image varchar(255),
type int(2)

);

Create table book_type(
id int(2) auto_increment primary key,
name varchar(50),
description varchar(100)
);

INSERT INTO Author(id,name,surname,email,password)
VALUES(2,'Bermet','Matkurbanova','bermet@gmail.com','123');

INSERT INTO Author(id,name,surname,email,password)
VALUES(1,'Aizhan','Arapova','aizhan@gmail.com','456');
select*from author

INSERT INTO book_type(id,name,description)
VALUES(1,'JAVA',''),
VALUES(2,'Бизнес','');

INSERT INTO Book(id,publish_date,quantity,title,image,type)
VALUES(2,sysdate(),265,'Дизайн карьеры и жизни','books2.jpg',2),
VALUES(3,sysdate(),25,'Java for absolute beginners','java.jpg',1),
VALUES(4,sysdate(),10,'Learning Spring Boot','java.jpg',1),
VALUES(5,sysdate(),2,'Core Java','books.jpg',1);

Create table Orders(
id int auto_increment primary key,
order_date datetime,
book_id int(11),
comment text,
time int(11),
quantity int,
status int(11),
author_id int(2)
);
