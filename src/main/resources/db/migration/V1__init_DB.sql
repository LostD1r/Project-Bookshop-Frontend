create sequence author_seq start 1 increment 50;
create sequence book_seq start 1 increment 50;
create sequence bucket_seq start 1 increment 50;
create sequence comment_seq start 1 increment 50;
create sequence genre_seq start 1 increment 50;
create sequence order_details_seq start 1 increment 50;
create sequence order_seq start 1 increment 50;
create sequence post_seq start 1 increment 50;
create sequence publishing_seq start 1 increment 50;
create sequence user_seq start 1 increment 50;
create sequence event_seq start 1 increment 50;
create table authors (id int8 not null, description varchar(600), image varchar(255), name varchar(50), primary key (id));
create table books (id int8 not null, characteristic varchar(500), created_date timestamp, description varchar(600), english_name varchar(60), image varchar(255), name varchar(60), price float8, sales_amount int8, shop_amount int8, author_id int8, publishing_id int8, primary key (id));
create table books_genres (genre_id int8 not null, book_id int8 not null);
create table bucket_books (bucket_id int8 not null, book_id int8 not null);
create table buckets (id int8 not null, user_id int8, primary key (id));
create table comments (id int8 not null, created timestamp, message varchar(500), book_id int8, user_id int8, primary key (id));
create table genres (id int8 not null, name varchar(255), primary key (id));
create table news (id int8 not null, created timestamp, image varchar(255), message varchar(600), title varchar(255), primary key (id));
create table orders (id int8 not null, address varchar(255), created timestamp, full_name varchar(255), order_status varchar(255), phone_number varchar(255), sum numeric(19, 2), updated timestamp, user_id int8, primary key (id));
create table orders_details (id int8 not null, amount numeric(19, 2), price numeric(19, 2), book_id int8, order_id int8, primary key (id));
create table publishing (id int8 not null, description varchar(600), image varchar(255), name varchar(255), primary key (id));
create table events (id int8 not null, created timestamp, message varchar(600), title varchar(255), primary key (id));
create table users (id int8 not null, about varchar(500), created_date timestamp, email varchar(255), name varchar(255), password varchar(255), role varchar(255), primary key (id));
create table users_books (user_id int8 not null, book_id int8 not null);
alter table if exists users add constraint uniq_email unique (email);
alter table if exists users add constraint uniq_name unique (name);
alter table if exists books add constraint books_fk_author foreign key (author_id) references authors;
alter table if exists books add constraint books_gk_publishing foreign key (publishing_id) references publishing;
alter table if exists books_genres add constraint book_genres_fk_genres foreign key (book_id) references genres;
alter table if exists books_genres add constraint book_genres_fk_books foreign key (genre_id) references books;
alter table if exists bucket_books add constraint bucket_books_fk_books foreign key (book_id) references books;
alter table if exists bucket_books add constraint bucket_books_fk_buckets foreign key (bucket_id) references buckets;
alter table if exists buckets add constraint buckets_fk_users foreign key (user_id) references users;
alter table if exists comments add constraint comments_fk_books foreign key (book_id) references books;
alter table if exists comments add constraint comments_fk_users foreign key (user_id) references users;
alter table if exists orders add constraint orders_fk_users foreign key (user_id) references users;
alter table if exists orders_details add constraint order_detail_fk_books foreign key (book_id) references books;
alter table if exists orders_details add constraint order_detail_fk_orders foreign key (order_id) references orders;
alter table if exists users_books add constraint users_books_fk_books foreign key (book_id) references books;
alter table if exists users_books add constraint users_books_fk_users foreign key (user_id) references users;