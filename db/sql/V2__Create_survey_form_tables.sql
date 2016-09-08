alter table ectc_plantilla_encuesta
add de_encuesta_largo character varying(100) NULL, 
add de_encuesta_corto character varying(30) NULL, 
add co_tipo_encuesta character(4) NULL;

--alter table ectd_plantilla_encuesta
-- add de_pregunta character varying(200) NULL;

alter table ectd_plantilla_encuesta
add co_tipo_pregunta character (4) NULL;


CREATE SEQUENCE ectd_plantilla_encuesta_respuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--tabla de respuesta a las preguntas de la encuesta
CREATE TABLE ectd_plantilla_encuesta_respuesta
(
ID_RESPUESTA serial NOT NULL,
de_RESPUESTA character varying(100) NULL, 
nu_orden integer null,
ID_PLANTILLA_ENCUESTA_DETALLE INT
);

ALTER TABLE ONLY ectd_plantilla_encuesta_respuesta
    ADD CONSTRAINT ectd_plantilla_encuesta_respuesta_pk PRIMARY KEY (ID_RESPUESTA);

ALTER TABLE ONLY ectd_plantilla_encuesta_respuesta
    ADD CONSTRAINT ectd_plantilla_encuesta_respuesta_pregunta_fk 
    FOREIGN KEY (ID_PLANTILLA_ENCUESTA_DETALLE) 
    REFERENCES ectd_plantilla_encuesta(ID_PLANTILLA_ENCUESTA_DETALLE);


    alter table ectd_plantilla_encuesta
--add nu_orden integer NULL,
add estado character(1) NULL;--,
--add fe_crea_registro timestamp with time zone null,
--add id_crea_registro integer null,
--add fe_mod_registro timestamp with time zone null,
--add id_mod_registro integer null;