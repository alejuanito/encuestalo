alter table ectm_local add column co_local character varying (8);

CREATE TABLE ectr_cliente_local
(
  id_local integer,
  id_cliente_local serial NOT NULL,
  id_cliente integer,
  fe_crea_registro timestamp without time zone,
  CONSTRAINT ectr_cliente_local_pkey PRIMARY KEY (id_cliente_local),
  CONSTRAINT fk_cliente_local_cliente FOREIGN KEY (id_cliente)
      REFERENCES ectm_cliente (id_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_cliente_local_local FOREIGN KEY (id_local)
      REFERENCES ectm_local (id_local) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE SEQUENCE ectr_cliente_local_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


alter table ectd_encuesta_respuesta add column de_pregunta character varying (100);
alter table ectd_encuesta_respuesta add column de_respuesta_corta character varying (100);


alter table ectd_encuesta_respuesta DROP CONSTRAINT ectd_encuesta_respuesta_id_respuesta_fkey;


--Update data historica
update ectd_encuesta_respuesta set de_pregunta=(select plan.de_pregunta from ectd_encuesta_respuesta res
left join ectd_plantilla_encuesta plan on plan.id_plantilla_encuesta_detalle = res.id_plantilla_encuesta_detalle
left join ectd_plantilla_encuesta_respuesta plan_corta on plan_corta.id_respuesta = res.id_respuesta
where id_encuesta_respuesta = ectd_encuesta_respuesta.id_encuesta_respuesta),
 de_respuesta_corta = (select plan_corta.de_respuesta from ectd_encuesta_respuesta res
left join ectd_plantilla_encuesta plan on plan.id_plantilla_encuesta_detalle = res.id_plantilla_encuesta_detalle
left join ectd_plantilla_encuesta_respuesta plan_corta on plan_corta.id_respuesta = res.id_respuesta
where id_encuesta_respuesta = ectd_encuesta_respuesta.id_encuesta_respuesta)
where ectd_encuesta_respuesta.id_encuesta_respuesta = ectd_encuesta_respuesta.id_encuesta_respuesta

