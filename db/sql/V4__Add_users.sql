--------------------------------------------------------------
--                          Leyenda                         --
--------------------------------------------------------------
-- co: codigo                                               --
-- dl: descripcion larga                                    --
-- dc: descripcion corta                                    --
-- no: nombre                                               --
-- ap: apellido paterno                                     --
-- am: apellido materno                                     --
-- es: estado                                               --
-- in: indicador                                            --
-- nu: numero                                               --
--------------------------------------------------------------

CREATE SEQUENCE ectm_usuario_id_usuario_seq;

CREATE TABLE ectm_usuario (
  id_usuario  INT         NOT NULL DEFAULT nextval('ectm_usuario_id_usuario_seq'),
  id_persona  INT,
  no_usuario  VARCHAR(12) NOT NULL,
  de_password VARCHAR(32) NOT NULL,
  es_usuario  CHAR(1)     NOT NULL,
  in_admin    BOOLEAN,
  PRIMARY KEY (id_usuario)
);

ALTER SEQUENCE ectm_usuario_id_usuario_seq OWNED BY ectm_usuario.id_usuario;

ALTER TABLE ectm_usuario ADD CONSTRAINT fk_usuario_persona
FOREIGN KEY (id_persona) REFERENCES ectm_persona (id_persona);

ALTER TABLE ectm_usuario ADD CONSTRAINT uq_usuario_no_usuario
UNIQUE (no_usuario);

CREATE SEQUENCE ectm_rol_id_rol_seq;

CREATE TABLE ectm_rol (
  id_rol INT         NOT NULL DEFAULT nextval('ectm_rol_id_rol_seq'),
  no_rol VARCHAR(20) NOT NULL,
  es_rol CHAR(1)     NOT NULL,
  PRIMARY KEY (id_rol)
);

ALTER SEQUENCE ectm_rol_id_rol_seq OWNED BY ectm_rol.id_rol;

CREATE TABLE ectm_usuario_rol (
  id_usuario INT NOT NULL,
  id_rol     INT NOT NULL,
  PRIMARY KEY (id_usuario, id_rol)
);

ALTER TABLE ectm_usuario_rol ADD CONSTRAINT fk_usuario_rol_usuario
FOREIGN KEY (id_usuario) REFERENCES ectm_usuario (id_usuario);

ALTER TABLE ectm_usuario_rol ADD CONSTRAINT fk_usuario_rol_rol
FOREIGN KEY (id_rol) REFERENCES ectm_rol (id_rol);

CREATE TABLE ectm_opcion (
  co_opcion VARCHAR(5)  NOT NULL,
  no_opcion VARCHAR(50) NOT NULL,
  de_url    VARCHAR(50) NOT NULL,
  es_opcion CHAR(1)     NOT NULL,
  PRIMARY KEY (co_opcion)
);

CREATE TABLE ectm_rol_opcion (
  id_rol    INT        NOT NULL,
  co_opcion VARCHAR(5) NOT NULL,
  PRIMARY KEY (id_rol, co_opcion)
);

ALTER TABLE ectm_rol_opcion ADD CONSTRAINT fk_rol_opcion_rol
FOREIGN KEY (id_rol) REFERENCES ectm_rol (id_rol);

ALTER TABLE ectm_rol_opcion ADD CONSTRAINT fk_rol_opcion_opcion
FOREIGN KEY (co_opcion) REFERENCES ectm_opcion (co_opcion);


-- preloading data
-- tipo documento
INSERT INTO ectm_tipo_documento (co_tipo_documento, de_larga, de_corto)
VALUES ('01', 'DNI', 'DNI');

INSERT INTO ectm_tipo_documento (co_tipo_documento, de_larga, de_corto)
VALUES ('04', 'CARNET DE EXTRANJERIA', 'CARNET EXT.');

INSERT INTO ectm_tipo_documento (co_tipo_documento, de_larga, de_corto)
VALUES ('06', 'REG. UNICO DE CONTRIBUYENTES', 'RUC');

INSERT INTO ectm_tipo_documento (co_tipo_documento, de_larga, de_corto)
VALUES ('07', 'PASAPORTE', 'PASAPORTE');

INSERT INTO ectm_tipo_documento (co_tipo_documento, de_larga, de_corto)
VALUES ('11', 'PART. DE NACIMIENTO-IDENTIDAD', 'P. NAC.');

INSERT INTO ectm_tipo_documento (co_tipo_documento, de_larga, de_corto)
VALUES ('00', 'OTROS', 'OTROS');

insert into ectm_persona (id_persona, am_persona, no_persona, ap_persona, fe_nacimiento,
nu_telefono_fijo, nu_telefono_celular, de_email, es_persona, nu_documento, co_sexo, co_tipo_documento)
values (2, 'DEMO', 'DEMO', 'DEMO', to_date('01/01/2000', 'DD/MM/YYYY'), '99999999', '9999999999', 
'demo@piombino.com.pe', 'A', '99999999', 'M', '01');


INSERT INTO ectm_persona (id_persona, am_persona, co_tipo_documento, no_persona, ap_persona, fe_nacimiento, nu_telefono_fijo, nu_telefono_celular, 
de_email, es_persona, nu_documento, co_sexo) VALUES (1, 'aaa', '01', 'AAA', 'AAA', NULL, NULL, NULL, NULL, 'A', NULL, NULL);

-- usuario
INSERT INTO ectm_usuario (id_usuario, id_persona, no_usuario, de_password, es_usuario, in_admin)
VALUES (1, 2, 'demo', 'demo', 'A', TRUE);

ALTER SEQUENCE ectm_usuario_id_usuario_seq RESTART WITH 3;
INSERT INTO ectm_colaborador (id_colaborador, id_persona) VALUES (1, 1);

-- rol
INSERT INTO ectm_rol (id_rol, no_rol, es_rol)
VALUES (1, 'ADMIN', 'A');

ALTER SEQUENCE ectm_rol_id_rol_seq RESTART WITH 2;

INSERT INTO ectm_usuario_rol (id_usuario, id_rol)
VALUES (1, 1);