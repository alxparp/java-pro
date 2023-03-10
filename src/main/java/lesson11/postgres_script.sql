DROP TABLE IF EXISTS public."user" CASCADE;
DROP TABLE IF EXISTS public.wallet;

CREATE TABLE IF NOT EXISTS public."user"
(
    user_id integer NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    date_of_registration date NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

ALTER TABLE IF EXISTS public."user"
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.wallet
(
    wallet_id integer NOT NULL,
    currency character varying(16) NOT NULL,
    amount double precision NOT NULL,
    user_id integer NOT NULL,
    created date NOT NULL,
    CONSTRAINT wallet_pk PRIMARY KEY (wallet_id),
    CONSTRAINT wallet_user_fk FOREIGN KEY (user_id)
    REFERENCES public."user" (user_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

ALTER TABLE IF EXISTS public.wallet
    OWNER to postgres;


INSERT INTO public.user(user_id, name, surname , date_of_registration)
VALUES (1, 'Alex', 'Parpalak', now()),
       (2, 'Alex', 'Shaitan', now()),
       (3, 'Viktor', 'Gevod', now());

INSERT INTO public.wallet(wallet_id, currency, amount, user_id, created)
VALUES (1, 'EUR', 3000, 1, now()),
       (2, 'USD', 4000, 2, now()),
       (3, 'USD', 4000, 3, now());

SELECT u.name || ' ' || u.surname AS full_name, w.amount, w.currency
FROM public.user AS u
         FULL JOIN public.wallet AS w
                   ON u.user_id = w.user_id;