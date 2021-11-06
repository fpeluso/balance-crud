CREATE TABLE IF NOT EXISTS public.transactions
(
    id SERIAL PRIMARY KEY,
    transactionType transaction_type NOT NULL,
    amount integer NOT NULL,
    category character(255)[] COLLATE pg_catalog."default" NOT NULL,
    "transactionDate" date NOT NULL,
    description character(255)[] COLLATE pg_catalog."default"
);

--TABLESPACE pg_default;

ALTER TABLE public.transactions
    OWNER to postgres;