create table recepcionistas(
    id SERIAL primary key,
    nome varchar(100) not null,
    telefone varchar(11) not null unique
);
