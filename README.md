# **WebFlux**

1. [Описание проекта](#1.-Описани-проекта)
1. [Руководство по запуску](#2.-Руководство-по-запуску-проекта)
1. [База данных](#3.-База-данных)
1. [Request](#4.-Request)
---


## 1. Описание проекта

Проект собран при помощи Gradle на основе зависимостей:

```
    implementation 'org.springframework.boot:spring-boot-starter-data-r2dbc'
    implementation 'org.springframework.boot:spring-boot-starter-mustache'
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.springframework:spring-jdbc'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'org.postgresql:postgresql'
    runtimeOnly 'org.postgresql:r2dbc-postgresql'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'io.projectreactor:reactor-test'

    implementation 'io.r2dbc:r2dbc-pool'
```

## 2. Руководство по запуску проекта


### Запуск проекта

1. Первым делом нам надо собрать jar архивы с нашими spring boot приложениями. Для этого в терминале в корне нашего проект выполните команду:

Для gradle: `./gradlew clean build` (если пишет Permission denied тогда сначала выполните `chmod +x ./gradlew`)

- После успешной сборки в папке будет находиться jar файл:`catalizator-0.0.1-SNAPSHOT.jar`;
- В терминале выполнить команду по сборке images и containers: ```docker-compose up```;
- В докере запустятся 2 приложения:
    - server-app, Java 11 на порту: ```http://localhost:8080```;
    - projects-teams-users-bd на порту: ```http://localhost:5432```;


### Завершение работы
- Выход из приложения: в терминале нажать "Ctrl+C"
- Удаление Docker контейнера: ```docker-compose down```


## 3. База данных

В приложении используется СУБД Postgresql, со следующими настройками:

`spring.r2dbc.url=r2dbc:postgresql://${POSTGRES_HOST:localhost}:${POSTGRES_PORT:5432}/${POSTGRES_DB:projects_teams_users}`

`spring.r2dbc.username=${POSTGRES_USER:cloudPeople}`

`spring.r2dbc.password=${POSTGRES_PASSWORD:soCloudPass}`

В программе используется таблицы БД:

```sql
create table users
(
id               bigserial primary key,
name             varchar(20),
telephone_number varchar(14) unique
);

create table teams
(
id            bigserial PRIMARY KEY,
title         VARCHAR(255) NOT NULL unique,
description   TEXT,
logo          VARCHAR(255),
creation_date timestamp with time zone default now(),
total_users   INT
);

CREATE TABLE teamMembers
(
team_id INT,
user_id INT,
PRIMARY KEY (team_id, user_id),
FOREIGN KEY (team_id) REFERENCES teams (id),
FOREIGN KEY (user_id) REFERENCES users (id)
);

create table Project
(
id              bigserial PRIMARY KEY,
title           VARCHAR(255) NOT NULL unique,
description     TEXT,
logo            VARCHAR(255),
creation_date   timestamp with time zone default now(),
completion_date timestamp with time zone
);

create table projectMembers
(
project_id INT,
team_id INT,
PRIMARY KEY (team_id, project_id),
FOREIGN KEY (team_id) REFERENCES teams (id),
FOREIGN KEY (project_id) REFERENCES Project (id)
)
```

### Миграции

В приложении используется Flyway, со следующими настройками:

`spring.flyway.url=jdbc:postgresql://${POSTGRES_HOST:localhost}:${POSTGRES_PORT:5432}/${POSTGRES_DB:projects_teams_users}`

`spring.flyway.user=${POSTGRES_USER:cloudPeople}`

`spring.flyway.password=${POSTGRES_PASSWORD:soCloudPass}`

### Данные в таблицах

```sql
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

```

## 4. Request

[Полный пакет request для тестирования сервера](src/main/resources/request.http)
