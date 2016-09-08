alter table ectc_promocion_enviada add column id_usuario_registro_promo integer;

alter table ectc_promocion_enviada add constraint fk_usario_registro foreign key (id_usuario_registro_promo) references ectm_usuario(id_usuario);

