INSERT INTO users (id, email, name, password, role)
VALUES (1, 'admin@gmail.com', 'admin', 'admin', 'ROLE_ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;