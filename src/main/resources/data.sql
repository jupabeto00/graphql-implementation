INSERT INTO products (number, type, created_date)
VALUES ('12345', 'Ahorro', '2023-01-01'),
       ('4567', 'Ahorro', '2023-01-01'),
       ('098123','Ahorro', '2023-01-01'),
       ('6785', 'Crédito', '2023-01-01'),
       ('123789', 'Tarjeta Crédito', '2023-01-01');

INSERT INTO accounts (product_id, balance)
VALUES (1, 5000.0),
       (2, 1500.0),
       (3, 12000.0);

INSERT INTO credits (product_id, balance)
VALUES (4, 15000.0);

INSERT INTO credit_cards (product_id, balance)
VALUES (5, 10000.0);

INSERT INTO movements (product_id, transaction_date, description, amount, created_at)
VALUES (1, '2023-11-01', 'Compra PSE', 14500.02, '2023-11-01'),
       (1, '2023-11-02', 'Compra PSE', 10500.02, '2023-11-01'),
       (1, '2023-12-01', 'Nomina', 100500.02, '2023-11-01'),
       (2, '2023-11-01', 'Compra PSE', 14500.02, '2023-11-01'),
       (3, '2023-11-02', 'Compra PSE', 10500.02, '2023-11-01'),
       (4, '2023-10-01', 'Nomina', 200500.02, '2023-11-01'),
       (4, '2023-10-01', 'Egreso', 200500.02, '2023-11-01'),
       (5, '2023-11-11', 'Compra Helados', 200500.02, '2023-11-01');
