USE `series_catalog_db`;

INSERT INTO `users` (login, password, role)
VALUES ('user', 'pass', 2),
       ('editor', 'editor', 1);

INSERT INTO `countries` (name)
VALUES ('США'),
       ('Великобритания'),
       ('Россия'),
       ('Новая Зеландия'),
       ('Австралия'),
       ('Испания'),
       ('Франция'),
       ('Германия'),
       ('Китай'),
       ('Беларусь'),
       ('Украина'),
('Польша') ;

INSERT INTO `categories` (name)
VALUES ('Детективы'),
       ('Триллер'),
       ('Драмы'),
       ('Комедия'),
       ('Ужасы'),
       ('Фэнтези'),
       ('Боевик'),
       ('Семейные') ;

INSERT INTO `user_info` (user_id, country_id, gender, birth_date)
VALUES (1, 10, 'man', '1999-11-11'),
       (3, 3, 'woman', NULL) ;

INSERT INTO `serials` (id, name, premiere_date, image_path, description)
VALUES (1, 'Шерлок', '2010-07-22', 'sher.png', 'sher'),
       (2, 'Во все тяжкие', '2008-01-20', 'vovse.png', 'description vo vse'),
       (3, 'Друзья', '1994-09-22', 'friends.png', 'friends serial');

INSERT INTO `series` (serial_id, name, serie_num, season_num, description)
VALUES (1, 'first sher', 1, 1, 'decription 1'),
       (1, 'second sher', 2, 1, 'decription 2'),
       (1, 'next season sher', 1, 2, 'decription next');

INSERT INTO `see_later_serials` (user_id, serial_id)
VALUES (2, 1),
       (2, 2),
       (2, 3);

INSERT INTO `watched_serials` (user_id, serial_id)
VALUES (2, 1);

INSERT INTO `serials_categories` (category_id, serial_id)
VALUES (2, 1),
       (2, 2);

INSERT INTO `serials_countries` (country_id, serial_id)
VALUES (1, 1),
       (3, 1),
       (4, 1),
       (4, 3) ;

