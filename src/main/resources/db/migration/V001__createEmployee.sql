create table if not exists company
(
    id serial not null
    primary key,
    company_name varchar(100) not null,
    address varchar(255),
    industry_type varchar(100)
    );

create table if not exists employee
(

    id serial not null
    primary key,
    name varchar(100),
    surname varchar(100),
    email varchar(100),
    company_id int,
    foreign key (company_id) references company(id)
    );