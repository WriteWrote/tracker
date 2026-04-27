truncate tracker.users cascade;
truncate tracker.user_roles cascade;
truncate tracker.roles cascade;

insert into tracker.users
values ('00000000-0000-0000-0000-000000000001',
        'test_user_login',
        'test_user_password',
        'test_grade',
        'test_position');

insert into tracker.roles
values (1, 'ADMIN'),
       (2, 'USER');

insert into tracker.user_roles
values ('00000000-0000-0000-0000-000000000001', 1);