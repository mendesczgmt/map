alter table if exists medicos alter column hora_inicio set data type time(6) USING hora_inicio::time(6) without time zone;
alter table if exists medicos alter column hora_termino set data type time(6) USING hora_termino::time(6) without time zone;
alter table pacientes alter column telefone set data type varchar(20) using telefone::varchar(20);
alter table pacientes alter column telefone set not null;
alter table pacientes add constraint unique_telefone unique (telefone);
alter table pacientes alter column cpf set data type varchar(20) using telefone::varchar(20);
alter table pacientes alter column cpf set not null;
alter table pacientes add constraint unique_cpf unique (cpf);