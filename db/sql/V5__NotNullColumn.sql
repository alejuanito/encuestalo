alter table ectm_atencion
ALTER COLUMN nu_mesa drop not null;


alter table ectd_plantilla_encuesta_respuesta
add no_img character varying(30) NULL;


alter table ectd_encuesta_respuesta
add id_respuesta int ;



alter table ectd_encuesta_respuesta add FOREIGN KEY (id_respuesta)
 REFERENCES ectd_plantilla_encuesta_respuesta (id_respuesta);