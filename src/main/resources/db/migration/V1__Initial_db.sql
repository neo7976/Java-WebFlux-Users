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
    id bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL unique,
    description TEXT,
    logo VARCHAR(255),
    creation_date timestamp with time zone default now(),
    total_users INT
);

CREATE TABLE teamMembers
(
    team_id INT,
    user_id INT,
    PRIMARY KEY (team_id, user_id),
    FOREIGN KEY (team_id) REFERENCES teams (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- ALTER TABLE Teams ADD COLUMN user_list TEXT;


INSERT INTO teams (id, title, description, creation_date, total_users) VALUES (1, 'Team A', 'Команда из Рязани', '2022.12.10', 2);
INSERT INTO teamMembers (team_id, user_id) VALUES (1, 1);
INSERT INTO teamMembers (team_id, user_id) VALUES (1, 2);

