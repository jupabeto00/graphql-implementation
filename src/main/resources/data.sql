INSERT INTO accounts (product_id, balance) VALUES (1, 5000.0);
INSERT INTO accounts (product_id, balance) VALUES (2, 1500.0);
INSERT INTO accounts (product_id, balance) VALUES (3, 300.0);
INSERT INTO accounts (product_id, balance) VALUES (4, 7800.5);
INSERT INTO accounts (product_id, balance) VALUES (5, 12000.0);

INSERT INTO credits (amount, status, client_name, date) VALUES (15000.0, 'Pendiente', 'Juan Pérez', '2023-11-01');
INSERT INTO credits (amount, status, client_name, date) VALUES (21000.0, 'Pagado', 'Carlos Gómez', '2023-08-03');
INSERT INTO credits (amount, status, client_name, date) VALUES (7250.0, 'Pendiente', 'María López', '2023-10-18');
INSERT INTO credits (amount, status, client_name, date) VALUES (12500.0, 'Pendiente', 'Luis Martínez', '2023-09-27');
INSERT INTO credits (amount, status, client_name, date) VALUES (48000.0, 'Pagado', 'Ana Ramírez', '2023-07-15');

INSERT INTO credit_cards (product_id, balance) VALUES (1, 10000.0);
INSERT INTO credit_cards (product_id, balance) VALUES (2, 2500.0);
INSERT INTO credit_cards (product_id, balance) VALUES (3, 7200.0);
INSERT INTO credit_cards (product_id, balance) VALUES (4, 4800.0);
INSERT INTO credit_cards (product_id, balance) VALUES (5, 16000.0);

INSERT INTO products (name, type) VALUES ('Cuenta Corriente', 'Ahorro');
INSERT INTO products (name, type) VALUES ('Cuenta Personal', 'Ahorro');
INSERT INTO products (name, type) VALUES ('Tarjeta Visa', 'Crédito');
INSERT INTO products (name, type) VALUES ('Tarjeta MasterCard', 'Crédito');
INSERT INTO products (name, type) VALUES ('Cuenta Premium', 'Ahorro');

INSERT INTO movements (amount, type, date, account_id) VALUES (150.0, 'Ingreso', '2023-11-01', 1);
INSERT INTO movements (amount, type, date, account_id) VALUES (-20.0, 'Egreso', '2023-11-02', 2);
INSERT INTO movements (amount, type, date, credit_card_id) VALUES (-300.0, 'Egreso', '2023-11-02', 1);
INSERT INTO movements (amount, type, date, account_id) VALUES (2200.0, 'Ingreso', '2023-11-03', 3);
INSERT INTO movements (amount, type, date, credit_card_id) VALUES (-500.0, 'Egreso', '2023-11-03', 2);