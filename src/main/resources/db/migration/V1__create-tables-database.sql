create table medicos(
    id SERIAL primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    hora_inicio time not null,
    hora_termino time not null
);

create table recepcionistas(
    id SERIAL primary key,
    nome varchar(100) not null,
    telefone varchar(11) not null unique
);

create table consultas(
    id Serial primary key,
    data date not null,
    hora time not null
);

create table pacientes(
    id Serial primary key,
    nome varchar(100) not null,
    telefone varchar(100) not null,
    cpf varchar(11) not null,
    data_nasc date not null,
    idade integer not null
);