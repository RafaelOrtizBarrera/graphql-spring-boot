CREATE SCHEMA usuario;

--set schema usuario;

-- SEQUENCIA ROL
CREATE SEQUENCE rol_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 2147483647
CACHE 1;


-- SEQUENCIA PERFIL
CREATE SEQUENCE perfil_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 2147483647
CACHE 1;

-- TABLA USUARIO
CREATE TABLE USUARIO
(
  RUT integer NOT NULL,
  APELLIDO character varying(150) COLLATE pg_catalog.default NOT NULL,
  DV character(1) COLLATE pg_catalog.default NOT NULL,
  EMAIL character varying(150) COLLATE pg_catalog.default NOT NULL,
  NOMBRE character varying(150) COLLATE pg_catalog.default NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (rut)
) TABLESPACE pg_default;


-- Table: rol

CREATE TABLE ROL
(
  ID integer NOT NULL DEFAULT nextval('rol_id_seq'::regclass),
  NOMBRE character varying(100) COLLATE pg_catalog.default NOT NULL,
  CONSTRAINT rol_pkey PRIMARY KEY (ID)
) TABLESPACE pg_default;

-- Table: perfil

CREATE TABLE PERFIL
(
  ID integer NOT NULL DEFAULT nextval('perfil_id_seq'::regclass),
  NOMBRE character varying(100) COLLATE pg_catalog.default NOT NULL,
  CONSTRAINT perfil_pkey PRIMARY KEY (ID)
) TABLESPACE pg_default;

-- Table: USUARIO_ROL

CREATE TABLE USUARIO_ROL
(
  RUT integer NOT NULL,
  ID_ROL integer NOT NULL,
  CONSTRAINT PK_USUARIO_ROL PRIMARY KEY (RUT, ID_ROL),
  FOREIGN KEY (RUT) REFERENCES USUARIO (RUT),
  FOREIGN KEY (ID_ROL) REFERENCES ROL (ID)
) TABLESPACE pg_default;

-- Table: ROL_PERFIL

CREATE TABLE ROL_PERFIL
(
  ID_ROL integer NOT NULL,
  ID_PERFIL integer NOT NULL,
  CONSTRAINT PK_ROL_PERFIL PRIMARY KEY (ID_ROL, ID_PERFIL),
  FOREIGN KEY (ID_ROL) REFERENCES ROL (ID),
  FOREIGN KEY (ID_PERFIL) REFERENCES PERFIL (ID)
) TABLESPACE pg_default;

ALTER TABLE USUARIO
OWNER to apiusuario;

ALTER TABLE ROL
OWNER to apiusuario;

ALTER TABLE PERFIL
OWNER to apiusuario;

ALTER TABLE USUARIO_ROL
OWNER to apiusuario;

ALTER TABLE ROL_PERFIL
OWNER to apiusuario;

ALTER SEQUENCE PERFIL_ID_SEQ
OWNER TO apiusuario;

ALTER SEQUENCE ROL_ID_SEQ
OWNER TO apiusuario;

