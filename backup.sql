--
-- PostgreSQL database dump
--

-- Dumped from database version 10.7 (Ubuntu 10.7-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.7 (Ubuntu 10.7-1.pgdg16.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: mumo
--

CREATE TABLE public.animals (
    name character varying,
    type character varying,
    id integer
);


ALTER TABLE public.animals OWNER TO mumo;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: mumo
--

CREATE SEQUENCE public.animals_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animals_id_seq OWNER TO mumo;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mumo
--

ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: mumo
--

CREATE TABLE public.sightings (
    ranger_name character varying,
    location character varying,
    "timestamp" timestamp without time zone,
    animal_id integer
);


ALTER TABLE public.sightings OWNER TO mumo;

--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: mumo
--

COPY public.animals (name, type, id) FROM stdin;
\.


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: mumo
--

COPY public.sightings (ranger_name, location, "timestamp", animal_id) FROM stdin;
tosh	mks	2016-06-22 19:10:25	23
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mumo
--

SELECT pg_catalog.setval('public.animals_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

