alter table pacientes alter column telefone set data type varchar(20) using telefone::varchar(20);
alter table pacientes alter column telefone set not null;
alter table pacientes add constraint unique_telefone unique (telefone);
alter table pacientes alter column cpf set data type varchar(20) using telefone::varchar(20);
alter table pacientes alter column cpf set not null;
alter table pacientes add constraint unique_cpf unique (cpf);