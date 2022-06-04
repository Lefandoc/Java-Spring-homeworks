create table public.users
(
    id       bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    email    varchar(50) unique,
    primary key (id)
);

create table public.roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE public.users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references public.users (id),
    foreign key (role_id) references public.roles (id)
);

insert into public.users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
       ('admin', '$2a$04$hys1d0CA43VoVHVNxKJI6.L4JRer4Pfcpyyp5oBFC26H5wjinV1/6', 'admin@gmail.com');

insert into public.roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into public.roles (name)
values ('can_get_all'),
       ('can_get_id');

insert into public.users_roles (user_id, role_id)
values (1, 1),
       (1, 3),
       (1, 4),
       (2, 2);
