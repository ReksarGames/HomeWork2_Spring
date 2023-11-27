INSERT INTO public.customers (name, email, age) VALUES
    ('Ivan Petrenko', 'ivanpetrenko@mail.com', 22),
    ('Oksana Petrenko', 'oksanapetrenko@mail.com', 21),
    ('Sergiy Stepanenko', 'sergiystepanenko@mail.com', 24),
    ('Galyna Stepanenko', 'galynastepanenko@mail.com', 23),
    ('Petro Ivanenko', 'petroivanenko@mail.com', 23),
    ('Natalya Ivanenko', 'natalyaivanenko@mail.com', 22);

INSERT INTO accounts
    (number, currency, balance, customer_id)
    VALUES
    ('6295e6db-667e-4d1b-adc1-dce573b01942', 'UAH', 0,1),
    ('477b0882-84a5-41c3-87d8-a3b26cb7278f', 'EUR', 0,2),
    ('45d91b68-a4dd-4de3-88dd-13e106b12a0c', 'EUR', 0,3),
    ('4e204fcd-d296-483c-964c-74d0be4130bb', 'CHF', 0,3),
    ('9db430b11-6b5c-4d63-9663-4f59974ea04', 'USD', 0,4),
    ('6e49c4c9-c93a-48af-a37c-0af6d1db9d7d', 'UAH', 0,4),
    ('4f3d9294-a79e-48b5-8109-c934727f8edf', 'UAH', 0,2);

INSERT INTO employers
    (name, address)
    VALUES
    ('Google', 'us'),
    ('Microsoft', 'us'),
    ('Boston Dynamics', 'us');

INSERT INTO customerEmployment
    (customer_id, employer_id)
    VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (3, 2),
    (3, 3),
    (4, 3),
    (4, 1);
