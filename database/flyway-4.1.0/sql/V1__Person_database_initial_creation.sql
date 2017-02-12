CREATE SEQUENCE public.person_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE public.person
(
  id integer NOT NULL DEFAULT nextval('person_id_seq'::regclass),
  name character varying(255),
  surname character varying(255),
  email character varying(255),
  gender character varying(2),
  birth_day date,
  address character varying(255),
  active boolean,
  CONSTRAINT person_pkey PRIMARY KEY (id)
)