create database quan_ly_hoc_sinh

use quan_ly_hoc_sinh


create table students (
	id int primary key ,
	name varchar(50),
	gender bit,
	birthday date,
	email varchar(50),
	score tinyint,
	username varchar(50) unique,
	class_id int 
);
-- ALTER  table students (
-- 	foreign key username references 
-- 
-- )
create table phone(
	phone_number varchar(50) primary key,
	student_id int,
	foreign key (student_id) references students(id)
	
);
create table james(
	username varchar(50) primary key,
	password varchar(50),
	constraint  fk_key  foreign key (username) references students(username)
);
create table classes(
	id int primary key,
	name varchar(50)
);
create table instructors(
	id int primary key,
	name varchar(50),
	birthday date
);
create table instructor_class(
	instructor_id int,
	class_id int,
	start_time date,
	primary key(instructor_id, class_id),
	foreign key (instructor_id) references instructors(id),
	foreign key (class_id) references classes(id)
)

insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES 
(1, "nguyen ngoc cu",1,"81-12-12","cunn@gmail.com",8,"cunn",1),
 (2, "le hai chung",1,"81-12-12","chunglh@gmail.com",5,"chunglh",1),
 (3, "hoang huu hoan",1,"90-12-12","hoanhh@gmail.com",6,"hoanhh",2),
 (4, "dau dung",1,"87-12-12","dungd@gmail.com",8,"dungd",1),
 (5, "ta dinh huynh",1,"81-12-12","huynhtd@gmail.com",9,"huynhtd",2),
 (6, "nguyen minh hai",1,"87-12-12","hainm@gmail.com",9,"hainm",1),
 (7, "tran van nam",1,"89-12-12","namtv@gmail.com",4,"namtv",2),
 (8, "vo minh hieu",1,"81-12-12","hieuvm@gmail.com",3,"hieuvm",1),
 (9, "le xuan ky",1,"81-12-12","kylx@gmail.com",7,"kynx",2),
 (10, "le minh vu",1,"81-12-12","vu@gmail.com",7,"vulm",1),
 (11, "nguyen van a",1,"81-12-12","anv@gmail.com",8,null,null),
 (12, "tran van b",1,"81-12-12","btv@gmail.com",5,null,null);

insert into classes (id, name) values 
(1,'c1121g1'),
(2,'c1221g1'),
(3,'a0821i1'),
(4,'a0921i1');

INSERT INTO phone(phone_number, student_id)
VALUES
('905973141', 1),
('905973142', 1),
('905973143', 2),
('905973144', 2),
('905973145', 3),
('905973146', 4),
('905973147', 5),
('905973148', 6),
('905973149', 7),
('905973140', 8),
('905973150', 9),
('905973151', 10);

insert into james (username,password) values
('cunn', '123'),
('chunglh', '123'),
('hoanhh', '123'),
('dungd', '123'),
('huynhtd', '123'),
('hainm', '123'),
('namtv', '123'),
('hieuvm', '123'),
('kynx', '123'),
('vulm', '123');

insert into instructors (id,name,birthday) values
(1, 'tran van chanh', '1985-03-02'),
(2, 'tran minh chien', '1985-03-02'),
(3, 'vu thanh tien', '1985-03-02'),
(4, 'tran van nam', '1989-12-12');


insert into instructor_class (instructor_id,class_id,start_time) values
(1, 1, NULL),
(1, 2, NULL),
(1, 3, NULL),
(2, 1, NULL),
(2, 2, NULL),
(2, 3, NULL);


-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (2, "le hai chung",1,"81-12-12","chunglh@gmail.com",5,"chunglh",1),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (3, "hoang huu hoan",1,"90-12-12","hoanhh@gmail.com",6,"hoanhhh",2),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (4, "dau dung",1,"87-12-12","dungd@gmail.com",8,"dungd",1);
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (5, "ta dinh huynh",1,"81-12-12","huynhtd@gmail.com",9,"huynhtd",2);
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (6, "nguyen minh hai",1,"87-12-12","hainm@gmail.com",9,"hainm",1),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (7, "tran van nam",1,"89-12-12","namtv@gmail.com",4,"namtv",2),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (8, "vo minh hieu",1,"81-12-12","hieuvm@gmail.com",3,"hieuvm",1),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (9, "le xuan ky",1,"81-12-12","kylx@gmail.com",7,"kynx",2),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (10, "le minh vu",1,"81-12-12","vu@gmail.com",7,"vulm",1),
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (11, "nguyen van a",1,"81-12-12","anv@gmail.com",8,null,null);
-- insert into students (id,name,gender,birthday,email,score,username,class_id) VALUES (12, "tran van b",1,"81-12-12","btv@gmail.com",5,null,null);

