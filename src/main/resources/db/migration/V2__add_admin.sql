INSERT INTO users (id, email, name, password, role, bucket_id)
VALUES (1, 'admin@gmail.com', 'admin', 'admin', 'ADMIN', null);

ALTER SEQUENCE user_seq RESTART WITH 2;