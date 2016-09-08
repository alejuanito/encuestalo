-- Agregamos el estado de la plantilla de encuesta para seleccionar sólo las activas
alter table ectc_plantilla_encuesta add es_plantilla_encuesta char(1);

update ectc_plantilla_encuesta set es_plantilla_encuesta = 'A';