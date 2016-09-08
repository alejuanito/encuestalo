alter table ectm_colaborador add id_local int;
alter table ectm_colaborador add FOREIGN KEY (id_local) REFERENCES ectm_local (id_local);