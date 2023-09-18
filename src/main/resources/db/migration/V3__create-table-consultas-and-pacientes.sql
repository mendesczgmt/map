create table consultas(
    id Serial primary key,
    data date not null,
    hora time not null,
    medicoId Serial not null,
    pacienteId Serial not null,
    recepcionistaId Serial not null
);

create table pacientes(
    id Serial primary key,
    nome varchar(100) not null,
    telefone varchar(100) not null,
    cpf varchar(11) not null,
    data_nasc date not null,
    idade integer not null
);