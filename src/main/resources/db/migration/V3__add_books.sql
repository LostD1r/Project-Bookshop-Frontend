INSERT INTO books (id, characteristic, description, image, name, price, author_id, publishing_id)
VALUES (1, 'sadfrwas', 'asdfgsadf', '/Photos/Latin_dictionary.jpg', 'Aboba', 156, null, null),
       (2, 'sadfrwas', 'asdfgsadf', '/Photos/Latin_dictionary.jpg', 'Aboba', 156, null, null),
       (3, 'sadfrwas', 'asdfgsadf', '/Photos/Latin_dictionary.jpg', 'Aboba', 156, null, null),
       (4, 'sadfrwas', 'asdfgsadf', '/Photos/Latin_dictionary.jpg', 'Aboba', 156, null, null),
       (5, 'sadfrwas', 'asdfgsadf', '/Photos/Latin_dictionary.jpg', 'Aboba', 156, null, null);

ALTER SEQUENCE book_seq RESTART WITH 6;