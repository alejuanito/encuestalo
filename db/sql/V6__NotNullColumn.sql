alter table ectm_cliente
ALTER COLUMN id_empresa drop not null;


alter table ectd_encuesta_respuesta
add de_respuesta character varying(100) NULL;