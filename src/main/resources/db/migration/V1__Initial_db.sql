create table message
(
    id      bigserial primary key,
    message varchar(1024)
);

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

-- ALTER TABLE Teams ADD COLUMN user_list TEXT;

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



