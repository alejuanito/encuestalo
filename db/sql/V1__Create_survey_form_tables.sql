

CREATE TABLE ectc_encuesta (
    id_encuesta integer NOT NULL,
    id_atencion integer NOT NULL
);


CREATE SEQUENCE ectc_encuesta_id_encuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE ectc_encuesta_id_encuesta_seq OWNED BY ectc_encuesta.id_encuesta;


--
-- Name: ectc_plantilla_encuesta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectc_plantilla_encuesta (
    id_plantilla_encuesta integer NOT NULL,
    id_empresa integer NOT NULL
);

--
-- Name: ectc_plantilla_encuesta_id_plantilla_encuesta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectc_plantilla_encuesta_id_plantilla_encuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: ectc_plantilla_encuesta_id_plantilla_encuesta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectc_plantilla_encuesta_id_plantilla_encuesta_seq OWNED BY ectc_plantilla_encuesta.id_plantilla_encuesta;


--
-- Name: ectc_promocion_enviada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectc_promocion_enviada (
    id_promocion_enviada integer NOT NULL,
    id_cliente integer NOT NULL,
    id_promocion integer NOT NULL
);



--
-- Name: ectc_promocion_enviada_id_promocion_enviada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectc_promocion_enviada_id_promocion_enviada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectc_promocion_enviada_id_promocion_enviada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectc_promocion_enviada_id_promocion_enviada_seq OWNED BY ectc_promocion_enviada.id_promocion_enviada;


--
-- Name: ectd_encuesta_respuesta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectd_encuesta_respuesta (
    id_encuesta_respuesta integer NOT NULL,
    id_plantilla_encuesta_detalle integer NOT NULL,
    id_encuesta integer NOT NULL
);



--
-- Name: ectd_encuesta_respuesta_id_encuesta_respuesta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectd_encuesta_respuesta_id_encuesta_respuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectd_encuesta_respuesta_id_encuesta_respuesta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectd_encuesta_respuesta_id_encuesta_respuesta_seq OWNED BY ectd_encuesta_respuesta.id_encuesta_respuesta;


--
-- Name: ectd_plantilla_encuesta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectd_plantilla_encuesta (
id_plantilla_encuesta_detalle serial NOT NULL,
  id_plantilla_encuesta integer,
  nu_orden integer,
  de_pregunta character varying(100),
  in_es_rpta_corta boolean,
  es_plantilla_encuesta_detalle character(1),
  fe_crea_registro timestamp without time zone,
  id_crea_registro character varying(20),
  fe_mod_registro timestamp without time zone,
  id_mod_registro character varying(20)

);



--
-- Name: ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq OWNED BY ectd_plantilla_encuesta.id_plantilla_encuesta_detalle;


--
-- Name: ectm_area; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_area (
    id_area integer NOT NULL,
    id_local integer NOT NULL,
    de_area character varying(100)
);



--
-- Name: ectm_area_id_area_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_area_id_area_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_area_id_area_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_area_id_area_seq OWNED BY ectm_area.id_area;


--
-- Name: ectm_atencion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_atencion (
    id_atencion integer NOT NULL,
    nu_mesa character varying NOT NULL,
    id_colaborador integer NOT NULL,
    id_area integer NOT NULL
);



--
-- Name: ectm_atencion_id_atencion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_atencion_id_atencion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: ectm_atencion_id_atencion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_atencion_id_atencion_seq OWNED BY ectm_atencion.id_atencion;


--
-- Name: ectm_cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_cliente (
    id_cliente integer NOT NULL,
    id_persona integer NOT NULL,
    id_empresa integer NOT NULL
);



--
-- Name: ectm_cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_cliente_id_cliente_seq OWNED BY ectm_cliente.id_cliente;


--
-- Name: ectm_colaborador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_colaborador (
    id_colaborador integer NOT NULL,
    id_persona integer NOT NULL
);



--
-- Name: ectm_empresa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_empresa (
    id_empresa integer NOT NULL,
    de_empresa character varying(100) NOT NULL,
    de_direccion character varying(100),
    fe_crea_registro timestamp without time zone,
    id_crea_registro integer
);


--
-- Name: ectm_empresa_id_empresa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_empresa_id_empresa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_empresa_id_empresa_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_empresa_id_empresa_seq OWNED BY ectm_empresa.id_empresa;


--
-- Name: ectm_local; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_local (
    id_local integer NOT NULL,
    id_empresa integer NOT NULL
);



--
-- Name: ectm_local_id_local_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_local_id_local_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_local_id_local_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_local_id_local_seq OWNED BY ectm_local.id_local;


--
-- Name: ectm_motivo_promocion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_motivo_promocion (
    id_motivo_promocion integer NOT NULL
);



--
-- Name: ectm_motivo_promocion_id_motivo_promocion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_motivo_promocion_id_motivo_promocion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_motivo_promocion_id_motivo_promocion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_motivo_promocion_id_motivo_promocion_seq OWNED BY ectm_motivo_promocion.id_motivo_promocion;


--
-- Name: ectm_parametro; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_parametro (
    co_parametro character varying(250) NOT NULL,
    id_empresa integer NOT NULL,
    de_parametro character varying(250) NOT NULL,
    va_parametro character varying(50) NOT NULL
);



--
-- Name: ectm_persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_persona (
    id_persona integer NOT NULL,
    am_persona character varying(100) NOT NULL,
    co_tipo_documento character varying(2) NOT NULL,
    no_persona character varying(100) NOT NULL,
    ap_persona character varying(100) NOT NULL,
    fe_nacimiento date,
    nu_telefono_fijo character varying(10),
    nu_telefono_celular character varying(10),
    de_email character varying(100),
    es_persona character varying(1) NOT NULL,
    nu_documento character varying(15),
    co_sexo character varying(1)
);



--
-- Name: ectm_persona_id_persona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_persona_id_persona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_persona_id_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_persona_id_persona_seq OWNED BY ectm_persona.id_persona;


--
-- Name: ectm_promocion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_promocion (
    id_promocion integer NOT NULL,
    id_empresa integer NOT NULL,
    id_motivo_promocion integer NOT NULL,
    id_tipo_promocion integer NOT NULL
);



--
-- Name: ectm_promocion_id_promocion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_promocion_id_promocion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;




--
-- Name: ectm_promocion_id_promocion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_promocion_id_promocion_seq OWNED BY ectm_promocion.id_promocion;


--
-- Name: ectm_tipo_documento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_tipo_documento (
    co_tipo_documento character varying(2) NOT NULL,
    de_larga character varying(30) NOT NULL,
    de_corto character varying(15) NOT NULL
);



--
-- Name: ectm_tipo_promocion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ectm_tipo_promocion (
    id_tipo_promocion integer NOT NULL
);



--
-- Name: ectm_tipo_promocion_id_tipo_promocion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ectm_tipo_promocion_id_tipo_promocion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



--
-- Name: ectm_tipo_promocion_id_tipo_promocion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ectm_tipo_promocion_id_tipo_promocion_seq OWNED BY ectm_tipo_promocion.id_tipo_promocion;


--
-- Name: id_encuesta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_encuesta ALTER COLUMN id_encuesta SET DEFAULT nextval('ectc_encuesta_id_encuesta_seq'::regclass);


--
-- Name: id_plantilla_encuesta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_plantilla_encuesta ALTER COLUMN id_plantilla_encuesta SET DEFAULT nextval('ectc_plantilla_encuesta_id_plantilla_encuesta_seq'::regclass);


--
-- Name: id_promocion_enviada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_promocion_enviada ALTER COLUMN id_promocion_enviada SET DEFAULT nextval('ectc_promocion_enviada_id_promocion_enviada_seq'::regclass);


--
-- Name: id_encuesta_respuesta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectd_encuesta_respuesta ALTER COLUMN id_encuesta_respuesta SET DEFAULT nextval('ectd_encuesta_respuesta_id_encuesta_respuesta_seq'::regclass);


--
-- Name: id_plantilla_encuesta_detalle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectd_plantilla_encuesta ALTER COLUMN id_plantilla_encuesta_detalle SET DEFAULT nextval('ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq'::regclass);


--
-- Name: id_area; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_area ALTER COLUMN id_area SET DEFAULT nextval('ectm_area_id_area_seq'::regclass);


--
-- Name: id_atencion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_atencion ALTER COLUMN id_atencion SET DEFAULT nextval('ectm_atencion_id_atencion_seq'::regclass);


--
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_cliente ALTER COLUMN id_cliente SET DEFAULT nextval('ectm_cliente_id_cliente_seq'::regclass);


--
-- Name: id_empresa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_empresa ALTER COLUMN id_empresa SET DEFAULT nextval('ectm_empresa_id_empresa_seq'::regclass);


--
-- Name: id_local; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_local ALTER COLUMN id_local SET DEFAULT nextval('ectm_local_id_local_seq'::regclass);


--
-- Name: id_motivo_promocion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_motivo_promocion ALTER COLUMN id_motivo_promocion SET DEFAULT nextval('ectm_motivo_promocion_id_motivo_promocion_seq'::regclass);


--
-- Name: id_persona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_persona ALTER COLUMN id_persona SET DEFAULT nextval('ectm_persona_id_persona_seq'::regclass);


--
-- Name: id_promocion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_promocion ALTER COLUMN id_promocion SET DEFAULT nextval('ectm_promocion_id_promocion_seq'::regclass);


--
-- Name: id_tipo_promocion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_tipo_promocion ALTER COLUMN id_tipo_promocion SET DEFAULT nextval('ectm_tipo_promocion_id_tipo_promocion_seq'::regclass);


--
-- Data for Name: ectc_encuesta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectc_encuesta_id_encuesta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectc_encuesta_id_encuesta_seq', 1, false);


--
-- Data for Name: ectc_plantilla_encuesta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectc_plantilla_encuesta_id_plantilla_encuesta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectc_plantilla_encuesta_id_plantilla_encuesta_seq', 1, false);


--
-- Data for Name: ectc_promocion_enviada; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectc_promocion_enviada_id_promocion_enviada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectc_promocion_enviada_id_promocion_enviada_seq', 1, false);


--
-- Data for Name: ectd_encuesta_respuesta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectd_encuesta_respuesta_id_encuesta_respuesta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectd_encuesta_respuesta_id_encuesta_respuesta_seq', 1, false);


--
-- Data for Name: ectd_plantilla_encuesta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq', 1, false);


--
-- Data for Name: ectm_area; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ectm_area (id_area, id_local, de_area) VALUES (1, 1, 'Area 1');
INSERT INTO ectm_area (id_area, id_local, de_area) VALUES (2, 1, 'Area 2');


--
-- Name: ectm_area_id_area_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_area_id_area_seq', 1, false);


--
-- Data for Name: ectm_atencion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectm_atencion_id_atencion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_atencion_id_atencion_seq', 1, false);


--
-- Data for Name: ectm_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectm_cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_cliente_id_cliente_seq', 1, false);


--
-- Data for Name: ectm_colaborador; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- Data for Name: ectm_empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ectm_empresa (id_empresa, de_empresa, de_direccion, fe_crea_registro, id_crea_registro) VALUES (1, 'CEBO', NULL, NULL, NULL);


--
-- Name: ectm_empresa_id_empresa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_empresa_id_empresa_seq', 1, false);


--
-- Data for Name: ectm_local; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ectm_local (id_local, id_empresa) VALUES (1, 1);


--
-- Name: ectm_local_id_local_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_local_id_local_seq', 1, false);


--
-- Data for Name: ectm_motivo_promocion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectm_motivo_promocion_id_motivo_promocion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_motivo_promocion_id_motivo_promocion_seq', 1, false);


--
-- Data for Name: ectm_parametro; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: ectm_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Name: ectm_persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_persona_id_persona_seq', 1, false);


--
-- Data for Name: ectm_promocion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectm_promocion_id_promocion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_promocion_id_promocion_seq', 1, false);


--
-- Data for Name: ectm_tipo_documento; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Data for Name: ectm_tipo_promocion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: ectm_tipo_promocion_id_tipo_promocion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ectm_tipo_promocion_id_tipo_promocion_seq', 1, false);


--
-- Name: ectc_encuesta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectc_encuesta
    ADD CONSTRAINT ectc_encuesta_pk PRIMARY KEY (id_encuesta);


--
-- Name: ectc_plantilla_encuesta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectc_plantilla_encuesta
    ADD CONSTRAINT ectc_plantilla_encuesta_pk PRIMARY KEY (id_plantilla_encuesta);


--
-- Name: ectc_promocion_enviada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectc_promocion_enviada
    ADD CONSTRAINT ectc_promocion_enviada_pk PRIMARY KEY (id_promocion_enviada);


--
-- Name: ectd_encuesta_respuesta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectd_encuesta_respuesta
    ADD CONSTRAINT ectd_encuesta_respuesta_pk PRIMARY KEY (id_encuesta_respuesta);


--
-- Name: ectd_plantilla_encuesta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectd_plantilla_encuesta
    ADD CONSTRAINT ectd_plantilla_encuesta_pk PRIMARY KEY (id_plantilla_encuesta_detalle);


--
-- Name: ectm_area_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_area
    ADD CONSTRAINT ectm_area_pk PRIMARY KEY (id_area);


--
-- Name: ectm_atencion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_atencion
    ADD CONSTRAINT ectm_atencion_pk PRIMARY KEY (id_atencion);


--
-- Name: ectm_cliente_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_cliente
    ADD CONSTRAINT ectm_cliente_pk PRIMARY KEY (id_cliente);


--
-- Name: ectm_colaborador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_colaborador
    ADD CONSTRAINT ectm_colaborador_pk PRIMARY KEY (id_colaborador);


--
-- Name: ectm_empresa_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_empresa
    ADD CONSTRAINT ectm_empresa_pk PRIMARY KEY (id_empresa);


--
-- Name: ectm_local_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_local
    ADD CONSTRAINT ectm_local_pk PRIMARY KEY (id_local);


--
-- Name: ectm_motivo_promocion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_motivo_promocion
    ADD CONSTRAINT ectm_motivo_promocion_pk PRIMARY KEY (id_motivo_promocion);


--
-- Name: ectm_parametro_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_parametro
    ADD CONSTRAINT ectm_parametro_pk PRIMARY KEY (co_parametro);


--
-- Name: ectm_persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_persona
    ADD CONSTRAINT ectm_persona_pk PRIMARY KEY (id_persona);


--
-- Name: ectm_promocion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_promocion
    ADD CONSTRAINT ectm_promocion_pk PRIMARY KEY (id_promocion);


--
-- Name: ectm_tipo_documento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_tipo_documento
    ADD CONSTRAINT ectm_tipo_documento_pk PRIMARY KEY (co_tipo_documento);


--
-- Name: ectm_tipo_promocion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ectm_tipo_promocion
    ADD CONSTRAINT ectm_tipo_promocion_pk PRIMARY KEY (id_tipo_promocion);


--
-- Name: ectc_encuesta_ectd_encuesta_respuesta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectd_encuesta_respuesta
    ADD CONSTRAINT ectc_encuesta_ectd_encuesta_respuesta_fk FOREIGN KEY (id_encuesta) REFERENCES ectc_encuesta(id_encuesta);


--
-- Name: ectc_plantilla_encuesta_ectd_plantilla_encuesta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectd_plantilla_encuesta
    ADD CONSTRAINT ectc_plantilla_encuesta_ectd_plantilla_encuesta_fk FOREIGN KEY (id_plantilla_encuesta) REFERENCES ectc_plantilla_encuesta(id_plantilla_encuesta);


--
-- Name: ectd_plantilla_encuesta_ectd_encuesta_respuesta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectd_encuesta_respuesta
    ADD CONSTRAINT ectd_plantilla_encuesta_ectd_encuesta_respuesta_fk FOREIGN KEY (id_plantilla_encuesta_detalle) REFERENCES ectd_plantilla_encuesta(id_plantilla_encuesta_detalle);


--
-- Name: ectm_area_ectm_atencion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_atencion
    ADD CONSTRAINT ectm_area_ectm_atencion_fk FOREIGN KEY (id_area) REFERENCES ectm_area(id_area);


--
-- Name: ectm_atencion_ectc_encuesta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_encuesta
    ADD CONSTRAINT ectm_atencion_ectc_encuesta_fk FOREIGN KEY (id_atencion) REFERENCES ectm_atencion(id_atencion);


--
-- Name: ectm_cliente_ectc_promocion_enviada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_promocion_enviada
    ADD CONSTRAINT ectm_cliente_ectc_promocion_enviada_fk FOREIGN KEY (id_cliente) REFERENCES ectm_cliente(id_cliente);


--
-- Name: ectm_colaborador_ectm_atencion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_atencion
    ADD CONSTRAINT ectm_colaborador_ectm_atencion_fk FOREIGN KEY (id_colaborador) REFERENCES ectm_colaborador(id_colaborador);


--
-- Name: ectm_empresa_ectc_plantilla_encuesta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_plantilla_encuesta
    ADD CONSTRAINT ectm_empresa_ectc_plantilla_encuesta_fk FOREIGN KEY (id_empresa) REFERENCES ectm_empresa(id_empresa);


--
-- Name: ectm_empresa_ectm_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_cliente
    ADD CONSTRAINT ectm_empresa_ectm_cliente_fk FOREIGN KEY (id_empresa) REFERENCES ectm_empresa(id_empresa);


--
-- Name: ectm_empresa_ectm_local_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_local
    ADD CONSTRAINT ectm_empresa_ectm_local_fk FOREIGN KEY (id_empresa) REFERENCES ectm_empresa(id_empresa);


--
-- Name: ectm_empresa_ectm_parametro_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_parametro
    ADD CONSTRAINT ectm_empresa_ectm_parametro_fk FOREIGN KEY (id_empresa) REFERENCES ectm_empresa(id_empresa);


--
-- Name: ectm_empresa_ectm_promocion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_promocion
    ADD CONSTRAINT ectm_empresa_ectm_promocion_fk FOREIGN KEY (id_empresa) REFERENCES ectm_empresa(id_empresa);


--
-- Name: ectm_local_ectm_area_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_area
    ADD CONSTRAINT ectm_local_ectm_area_fk FOREIGN KEY (id_local) REFERENCES ectm_local(id_local);


--
-- Name: ectm_motivo_promocion_ectm_promocion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_promocion
    ADD CONSTRAINT ectm_motivo_promocion_ectm_promocion_fk FOREIGN KEY (id_motivo_promocion) REFERENCES ectm_motivo_promocion(id_motivo_promocion);


--
-- Name: ectm_persona_ectm_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_cliente
    ADD CONSTRAINT ectm_persona_ectm_cliente_fk FOREIGN KEY (id_persona) REFERENCES ectm_persona(id_persona);


--
-- Name: ectm_persona_ectm_colaborador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_colaborador
    ADD CONSTRAINT ectm_persona_ectm_colaborador_fk FOREIGN KEY (id_persona) REFERENCES ectm_persona(id_persona);


--
-- Name: ectm_promocion_ectc_promocion_enviada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectc_promocion_enviada
    ADD CONSTRAINT ectm_promocion_ectc_promocion_enviada_fk FOREIGN KEY (id_promocion) REFERENCES ectm_promocion(id_promocion);


--
-- Name: ectm_tipo_documento_ectm_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_persona
    ADD CONSTRAINT ectm_tipo_documento_ectm_persona_fk FOREIGN KEY (co_tipo_documento) REFERENCES ectm_tipo_documento(co_tipo_documento);


--
-- Name: ectm_tipo_promocion_ectm_promocion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ectm_promocion
    ADD CONSTRAINT ectm_tipo_promocion_ectm_promocion_fk FOREIGN KEY (id_tipo_promocion) REFERENCES ectm_tipo_promocion(id_tipo_promocion);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

--REVOKE ALL ON SCHEMA public FROM PUBLIC;
--REVOKE ALL ON SCHEMA public FROM postgres;
--GRANT ALL ON SCHEMA public TO postgres;
--GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

