create table message
(
    id      bigserial primary key,
    message varchar(1024)
);

insert into message(message)
values ('Как дела товарищи????');


create table users
(
    id               bigserial primary key,
    name             varchar(20),
    telephone_number varchar(14) unique
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


create table teams
(
    id        bigserial primary key,
    title     varchar(255) unique,
    depiction varchar(1024),
    logo      varchar(1024) unique
);

CREATE TABLE teamMembers
(
    team_id INT,
    user_id INT,
    PRIMARY KEY (team_id, user_id),
    FOREIGN KEY (team_id) REFERENCES teams (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);


INSERT INTO teams (id, title, depiction) VALUES (1, 'Team A', 'Команда из Рязани');
INSERT INTO teamMembers (team_id, user_id) VALUES (1, 1);
INSERT INTO teamMembers (team_id, user_id) VALUES (1, 2);