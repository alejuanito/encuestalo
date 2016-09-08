alter table ectc_plantilla_encuesta add id_local int;
update ectc_plantilla_encuesta set id_local = 1;
alter table ectc_plantilla_encuesta alter column id_local set not null;
alter table ectc_plantilla_encuesta alter column id_empresa drop not null;
update ectc_plantilla_encuesta set id_empresa = null;
alter table ectc_plantilla_encuesta drop column id_empresa;