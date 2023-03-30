create table message (
    id bigserial primary key,
    message varchar(1024)
);

insert into message(message)
values ('Как дела товарищи????');