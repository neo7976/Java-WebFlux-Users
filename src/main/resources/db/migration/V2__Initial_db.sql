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

INSERT INTO teams (title, description, creation_date, total_users)
VALUES ('Team A', 'Команда из Рязани', '2022.12.10', 2);
INSERT INTO teams (title, description, creation_date, total_users)
VALUES ('Team B', 'Команда из Пскова', '2023.01.10', 2);
INSERT INTO teams (title, description, creation_date, total_users)
VALUES ('Team D', 'Команда из Саранска', '2023.02.15', 2);


INSERT INTO teamMembers (team_id, user_id)
VALUES (1, 1);
INSERT INTO teamMembers (team_id, user_id)
VALUES (1, 2);
INSERT INTO teamMembers (team_id, user_id)
VALUES (2, 3);
INSERT INTO teamMembers (team_id, user_id)
VALUES (2, 4);
INSERT INTO teamMembers (team_id, user_id)
VALUES (3, 5);
INSERT INTO teamMembers (team_id, user_id)
VALUES (3, 6);

INSERT INTO project (title, description, creation_date, completion_date)
values ('WEB-Server', 'Создание сервера для нового продукта', '2023.01.10', '2023.02.22');
INSERT INTO project (title, description, creation_date, completion_date)
values ('Message', 'Создание push уведомлений для пользователей', '2023.02.10', '2023.02.27');
INSERT INTO project (title, description, creation_date)
values ('PayPall', 'Разработка сервиса платежей', '2023.03.25');

INSERT INTO projectMembers(project_id, team_id)
VALUES (1,1);
INSERT INTO projectMembers(project_id, team_id)
VALUES (2,3);
INSERT INTO projectMembers(project_id, team_id)
VALUES (3,2);
INSERT INTO projectMembers(project_id, team_id)
VALUES (3,1);