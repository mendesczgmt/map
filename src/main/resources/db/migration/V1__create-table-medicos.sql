create table medicos(
    id SERIAL primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null
);

create table recepcionistas(
    id SERIAL primary key,
    nome varchar(100) not null,
    telefone varchar(100) not null unique
);
