create table(

    id bigserial,
    nome varchar(100) not null,
    telefone varchar(30) not null,
    cpf varchar(20) not null,
    dataNasc varchar(20) not null,
    idade INT(100) not null,

  primary key(id)
  );