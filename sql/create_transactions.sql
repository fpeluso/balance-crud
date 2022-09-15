-- Table: public.transactions

-- DROP TABLE public.transactions;

CREATE TABLE IF NOT EXISTS public.transactions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "transactionType" transaction_type NOT NULL,
    amount integer NOT NULL,
    "transactionDate" date NOT NULL,
    description character(255)[] COLLATE pg_catalog."default",
    category_id integer,
    CONSTRAINT transactions_pkey PRIMARY KEY (id),
    CONSTRAINT fk_category FOREIGN KEY (category_id)
        REFERENCES public.category (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.transactions
    OWNER to postgres;