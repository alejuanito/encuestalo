-- password = demo
update ectm_usuario set de_password = 'fe01ce2a7fbac8fafaed7c982a04e229' where no_usuario = 'demo';

alter table ectm_usuario add column id_empresa int;
ALTER TABLE ectm_usuario ADD CONSTRAINT fk_usuario_empresa FOREIGN KEY (id_empresa) REFERENCES ectm_empresa (id_empresa);

update ectm_usuario set id_empresa = 1 where no_usuario = 'demo';