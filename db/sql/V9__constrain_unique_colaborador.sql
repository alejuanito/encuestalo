

CREATE SEQUENCE ectm_colaborador_id_colaborador_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;

ALTER TABLE ectm_colaborador ALTER COLUMN id_colaborador SET DEFAULT nextval('ectm_colaborador_id_colaborador_seq');

insert into ectm_colaborador (id_persona, id_local) values (2,1);

alter table ectm_colaborador
add id_usuario int ;

alter table ectm_colaborador add FOREIGN KEY (id_usuario)
 REFERENCES ectm_usuario (id_usuario);

update ectm_colaborador set id_usuario = '1' where id_persona = 2