create database quan_ly_khu_nghi_duong_furama;

use quan_ly_khu_nghi_duong_furama;

create table rent_type(
	id int primary key,
	name varchar(45)
);

create table service_type(
	id int primary key,
	name varchar(45)
);

create table services (
	id int primary key,
	name varchar(45),
	usable_area int,
	rental_cost double,
	number_of_participants int,
	rent_type int,
	service_type int,
	room_type varchar (45),
	description_other_service varchar(45),
	pool_area double,
	numb_floor int,
	foreign key (rent_type) references rent_type(id),
	foreign key (service_type) references service_type(id)

)
create table additional_services(
	id int primary key,
	name varchar(50),
	unit varchar(50),
	price double,
	status varchar(45)
)

create table qualification(
	id int primary key,
	name varchar(100)
);

create table `position` (
	id int primary key,
	name varchar(50)
)
create table department
(
	id int primary key,
	name varchar(50)
)


create table employee
(
	id int primary key,
	name varchar(50),
	birthday date,
	identity_id varchar(45),
	salary double,
	phone varchar (20),
	email varchar(100),
	place varchar(45),
	`position_id` int,
	qualification_id int,
	department int,
	foreign key (`position_id`) references `position`(id),
	foreign key (qualification_id) references qualification(id),
	foreign key (department) references department(id)

)
create table customer_type
(
	id int primary key,
	name varchar(50)
)
create table customer(
	id int primary key,
	name varchar(50),
	birthday date,
	gender bit,
	cmnd varchar(50),
	phone varchar(50),
	email varchar(50),
	customer_type int,
	place varchar(200),
	
	foreign key (customer_type) references customer_type(id)

)

create table contract
(
	contract_id int primary key,
	start_date date,
	end_date date,
	deposit_amount double,
	employee_id int,
	customer_id int,
	service_id int,
	foreign key (employee_id) references employee(id),
	foreign key (customer_id) references customer(id),
	foreign key(service_id) references services(id)
)


create table detail_contracts
(
	id int primary key,
	contract_id int,
	additional_service_id int,
	quantity int,

	foreign key (contract_id) references contract(contract_id),
	foreign key (additional_service_id) references additional_services(id)
)