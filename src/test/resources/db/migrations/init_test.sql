create schema if not exists tracker;

create table if not exists tracker.users
(
    id       uuid primary key default gen_random_uuid(),
    login    varchar(25) not null,
    password varchar(25) not null,
    grade    varchar(25) not null,
    position varchar(25) not null
);

create table if not exists tracker.roles
(
    id        int primary key,
    role_name varchar(25) not null
);

create table if not exists tracker.user_roles
(
    id_user uuid references tracker.users,
    id_role int references tracker.roles
);

create table if not exists tracker.projects
(
    id   uuid primary key default gen_random_uuid(),
    name varchar(25) not null
);

create table if not exists tracker.user_projects
(
    id_user    uuid references tracker.users,
    id_project uuid references tracker.projects
);

create table if not exists tracker.time_intervals
(
    id           uuid primary key unique default gen_random_uuid(),
    id_user      uuid references tracker.users,
    id_project   uuid references tracker.projects,
    time_minutes int not null,
    description  varchar(100)
);
