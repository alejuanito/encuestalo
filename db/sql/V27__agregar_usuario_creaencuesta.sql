alter table ectc_plantilla_encuesta add column id_usuario_registro integer;

alter table ectc_plantilla_encuesta add constraint fk_usario_registro foreign key (id_usuario_registro) references ectm_usuario(id_usuario);

