USE ` series_catalog_db ` ;

INSERT INTO ` users ` (login, password, role) VALUES ('user', 'pass', 2),
('editor', 'editor', 1) ;

INSERT INTO ` countries ` (name) VALUES ('США'),
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

INSERT INTO ` categories ` (name) VALUES ('Детективы'),
('Триллер'),
('Драмы'),
('Комедия'),
('Ужасы'),
('Фэнтези'),
('Боевик'),
('Семейные') ;

INSERT INTO ` user_info ` (user_id, country_id, email, sex, birth_date) VALUES (1, 10, 'admin_serega@mail.ru', 'м', '1999-11-11'),
(3, 3, 'maria@gmail.com', 'ж', NULL) ;

INSERT INTO ` serials ` (id, name, premier_date, image_path, country_id, category_id, description) VALUES (1, 'Шерлок', '2010-07-22', NULL, 2, 1, NULL),
(2, 'Во все тяжкие', '2008-01-20', NULL, 1, 2, NULL),
(3, 'Друзья', '1994-09-22', NULL, 1, 4, NULL) ;

INSERT INTO ` see_later ` (user_id, serial_id) VALUES (2, 1),
(2, 2),
(2, 3) ;

INSERT INTO ` watched_serials ` (user_id, serial_id) VALUES (2, 1) ;
