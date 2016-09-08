create table ectm_cargo_colaborador (
    co_cargo_colaborador char(2),
    de_cargo_colaborador varchar(50),
    primary key (co_cargo_colaborador)
);

insert into ectm_cargo_colaborador (co_cargo_colaborador, de_cargo_colaborador) values ('MZ', 'MOZO');
insert into ectm_cargo_colaborador (co_cargo_colaborador, de_cargo_colaborador) values ('EC', 'ENCUESTADOR');
insert into ectm_cargo_colaborador (co_cargo_colaborador, de_cargo_colaborador) values ('AD', 'ADMIN');

alter table ectm_colaborador add co_cargo_colaborador char(2);
alter table ectm_colaborador add constraint fk_cargo_colaborador foreign key (co_cargo_colaborador) references ectm_cargo_colaborador(co_cargo_colaborador);