select * from user;

drop table login;

rename table login to user;

create table IF NOT EXISTS login (
id int primary key auto_increment, 
username varchar(30),
password varchar(20), 
saltedhash varchar(256),
salted varchar(100)
);

alter table user
drop column username;

ALTER TABLE USER 
ADD COLUMN NAME varchar(100) after id;

ALTER TABLE USER 
ADD COLUMN lastname varchar(100) after name;

ALTER TABLE USER 
ADD column email varchar(175) after lastname;

alter table user 
add column confirmPassword varchar(20) after password;

create table airlines_com(
com_id integer,
com_name varchar(60),
country varchar(50),
city varchar(50),
primary key(com_id));

create table flights(
flight_no integer,
origin varchar(50),
destination varchar(50),
airport_arrival varchar(50),
airport_name integer,
foreign key(airport_name) references airlines_com(com_id),
primary key(flight_no));

create table passengers(
p_id integer,
p_name varchar(50),
address varchar(50),
p_country varchar(50),
primary key(p_id));

create table tickets(
id integer,
price decimal,
p_id integer,
flight_no integer,
com_id integer,
class_seat varchar(50),
primary key(id),
foreign key(p_id)references passengers(p_id),
foreign key(flight_no)references flights(flight_no), 
foreign key(com_id)references airlines_com(com_id));