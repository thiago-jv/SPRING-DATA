--liquibase formatted sql

--changeset thiago.henrique:1

-- Table: usuariospringdata
-- DROP TABLE usuario

CREATE TABLE usuario(
    id bigint NOT NULL,
    login character varying(10),
    senha character varying(10),
    nome character varying(90),
    email character varying(90),
    idade bigint,
    CONSTRAINT usuario_pkey PRIMARY KEY (id));

CREATE SEQUENCE usuario_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
