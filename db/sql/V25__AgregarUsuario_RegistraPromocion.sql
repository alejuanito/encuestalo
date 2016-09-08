alter table ectm_promocion add column id_usuario_registro integer;

alter table ectm_promocion add constraint fk_usario_registro foreign key (id_usuario_registro) references ectm_usuario(id_usuario);

