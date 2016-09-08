alter table ectm_local add column nu_local int null;

alter table ectc_encuesta add column id_local int null;

ALTER TABLE ectc_encuesta ADD CONSTRAINT ectc_encuesta_ectm_local_FK 
FOREIGN KEY (id_local) REFERENCES ectm_local(id_local);


alter table ectc_encuesta add column nu_encuesta character varying(10) null;

alter table ectc_encuesta add column nu_correlativo int null;
update ectm_local set no_local='LOCAL 1', nu_local=1;