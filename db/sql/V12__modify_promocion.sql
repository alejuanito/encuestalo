
alter table ectm_cliente add column in_promocion boolean null;



alter table ectc_promocion_enviada add  column fe_envio timestamp without time zone;
 
ALTER TABLE ECTC_PROMOCION_ENVIADA ADD ID_EMPRESA INT;

alter table ECTC_PROMOCION_ENVIADA add CONSTRAINT FK_ECTC_PROMOCION_ENVIADA_ECTM_EMPRESA 
FOREIGN KEY (ID_EMPRESA) REFERENCES ECTM_EMPRESA (ID_EMPRESA);


alter table ectm_promocion add  column es_promocion char(1);
