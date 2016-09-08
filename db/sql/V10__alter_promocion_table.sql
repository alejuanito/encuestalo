
ALTER TABLE ectm_promocion DROP CONSTRAINT ectm_empresa_ectm_promocion_fk;
ALTER TABLE ectm_promocion DROP COLUMN id_empresa;
alter table ectm_promocion add id_local int ;

alter table ectm_promocion add FOREIGN KEY (id_local)
 REFERENCES ectm_local (id_local);


 alter table ectm_promocion add co_promocion character varying(10) ;
 alter table ectm_promocion add de_titulo character varying(100) ;
 alter table ectm_promocion add de_descripcion character varying(300) ;

  alter table ectm_promocion add fe_inicio timestamp without time zone ;
  alter table ectm_promocion add fe_fin timestamp without time zone ;
  alter table ectm_promocion add hr_envio character varying(8) ;

  alter table ectm_promocion add no_imagen character varying(50) ;

  alter table ectm_motivo_promocion add de_motivo character varying(50) ;

alter table ectm_tipo_promocion add de_tipo character varying(50) ;


alter table ectm_local add no_local character varying(50) ;


 