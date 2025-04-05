INSERT INTO users (name, created_date)
VALUES ( 'Juan', '2023-01-01' ),
( 'Pedro', '2023-01-01' ),
( 'Tomas', '2023-01-01' );

INSERT INTO products (user_id, number, type, created_date)
VALUES ('1', '12345', 'Ahorro', '2023-01-01'),
       ('2', '4567', 'Ahorro', '2023-01-01'),
       ('3', '098123','Ahorro', '2023-01-01'),
       ('1', '6785', 'Crédito', '2023-01-01'),
       ('3', '123789', 'Tarjeta Crédito', '2023-01-01');

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
       (1, '2023-11-02', 'Pago Netflix', 32000.00, '2023-11-02'),
       (1, '2023-11-03', 'Compra Amazon', 87000.50, '2023-11-03'),
       (1, '2023-11-04', 'Pago Spotify', 15000.75, '2023-11-04'),
       (1, '2023-11-05', 'Transferencia recibida', 500000.00, '2023-11-05'),
       (1, '2023-11-06', 'Retiro Cajero', 200000.00, '2023-11-06'),
       (1, '2023-11-07', 'Compra Éxito', 105000.30, '2023-11-07'),
       (1, '2023-11-08', 'Pago tarjeta crédito', 220000.00, '2023-11-08'),
       (1, '2023-11-09', 'Consignación', 350000.00, '2023-11-09'),
       (1, '2023-11-10', 'Compra MercadoLibre', 99900.99, '2023-11-10'),
       (1, '2023-11-02', 'Compra PSE', 10500.02, '2023-11-01'),
       (1, '2023-12-01', 'Nomina', 100500.02, '2023-11-01'),
       (2, '2023-11-01', 'Compra PSE', 14500.02, '2023-11-01'),
       (3, '2023-11-02', 'Compra PSE', 10500.02, '2023-11-01'),
       (4, '2023-10-01', 'Nomina', 200500.02, '2023-11-01'),
       (4, '2023-10-01', 'Egreso', 200500.02, '2023-11-01'),
       (5, '2023-11-11', 'Compra Helados', 200500.02, '2023-11-01');
