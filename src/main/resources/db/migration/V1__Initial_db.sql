create table message
(
    id      bigserial primary key,
    message varchar(1024)
);

insert into message(message)
values ('Как дела товарищи????');


create table users
(
    id                 bigserial primary key,
    name               varchar(1024),
    telephone_number varchar(1024) unique
);

insert into users (name, telephone_number)
values ('Вася', '+79166158798');
insert into users (name, telephone_number)
values ('Дмитрий', '+79158547485');
insert into users (name, telephone_number)
values ('Алексей', '+79145658545');
insert into users (name, telephone_number)
values ('Петя', '+79122125265');
insert into users (name, telephone_number)
values ('Ольга', '+79100212565');
insert into users (name, telephone_number)
values ('Даниил', '+79999856587');