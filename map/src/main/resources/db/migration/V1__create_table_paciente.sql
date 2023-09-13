create table Pacientes(

    id bigserial,
    nome varchar(100) not null,
    telefone varchar(30) not null,
    cpf varchar(20) not null,
    data_nasc varchar(20) not null,
    idade INT not null,

    primary key(id)
  );