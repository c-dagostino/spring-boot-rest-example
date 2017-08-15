CREATE TABLE articles (article_id int primary key not null, category text, title text);

CREATE TABLE public.course
(
    course_id BIGSERIAL NOT NULL,
    author_id integer NOT NULL,
    category character varying(30) COLLATE pg_catalog."default" NOT NULL,
    course_length character varying(255) COLLATE pg_catalog."default",
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    watch_href character varying(300) COLLATE pg_catalog."default",
    CONSTRAINT course_pkey PRIMARY KEY (course_id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE public.author
(
    author_id BIGSERIAL NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(150) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT author_pkey PRIMARY KEY (author_id)
)
WITH (
    OIDS = FALSE
);