

alter table ectm_opcion add column no_icon character varying(50) null;
INSERT INTO ectm_opcion (co_opcion, no_opcion, de_url, es_opcion, no_icon) VALUES('USUAR', 'Usuarios', '#usuarios/', 'A','glyphicon glyphicon-user');
INSERT INTO ectm_opcion (co_opcion, no_opcion, de_url, es_opcion, no_icon) VALUES('ROLES', 'Roles', '#roles/', 'A','glyphicon glyphicon-lock');
INSERT INTO ectm_opcion (co_opcion, no_opcion, de_url, es_opcion, no_icon) VALUES('ENCUE', 'Encuestas', '#encuestas/', 'A','glyphicon glyphicon-th-list');
INSERT INTO ectm_opcion (co_opcion, no_opcion, de_url, es_opcion, no_icon) VALUES('RESPU', 'Respuestas', '#respuestas/', 'A','glyphicon glyphicon-ok');
INSERT INTO ectm_opcion (co_opcion, no_opcion, de_url, es_opcion, no_icon) VALUES('PROMO', 'Promociones', '#promociones/', 'A','glyphicon glyphicon-gift');

INSERT INTO ectm_rol_opcion (id_rol, co_opcion) VALUES(1, 'USUAR');
INSERT INTO ectm_rol_opcion (id_rol, co_opcion) VALUES(1, 'ROLES');
INSERT INTO ectm_rol_opcion (id_rol, co_opcion) VALUES(1, 'ENCUE');
INSERT INTO ectm_rol_opcion (id_rol, co_opcion) VALUES(1, 'RESPU');
INSERT INTO ectm_rol_opcion (id_rol, co_opcion) VALUES(1, 'PROMO');
