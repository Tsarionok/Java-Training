USE `series_catalog_db` ;

CREATE TABLE `users` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `login` VARCHAR ( 32 ) NOT NULL UNIQUE , `password` VARCHAR ( 255 ) NOT NULL ,
               /*
   * 0 - администратор 	(Role.ADMIN)
   * 1 - редактор 		(Role.EDITOR)
   * 2 - пользователь 	(Role.USER)
   */
       `role` TINYINT NOT NULL CHECK ( `role` IN ( 0 , 1 , 2 ) ) , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `countries` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `name` VARCHAR ( 255 ) NOT NULL , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `categories` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `name` VARCHAR ( 255 ) NOT NULL , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `user_info` ( `user_id` INTEGER NOT NULL UNIQUE , `country_id` INTEGER , `birth_date` DATE , `gender` VARCHAR ( 40 ) , FOREIGN KEY ( `user_id` ) REFERENCES `users` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `country_id` ) REFERENCES `countries` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `serials` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `name` VARCHAR ( 255 ) NOT NULL , `premiere_date` DATE NOT NULL , `image_path` VARCHAR ( 255 ) , `description` TEXT , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `series` ( `serial_id` INTEGER NOT NULL , `name` VARCHAR ( 255 ) NOT NULL , `serie_num` INTEGER NOT NULL , `season_num` INTEGER , `description` TEXT , FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `serials_categories` ( `category_id` INTEGER NOT NULL , `serial_id` INTEGER NOT NULL , FOREIGN KEY ( `category_id` ) REFERENCES `categories` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `serials_countries` ( `country_id` INTEGER NOT NULL , `serial_id` INTEGER NOT NULL , FOREIGN KEY ( `country_id` ) REFERENCES `countries` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `see_later_serials` ( `user_id` INTEGER NOT NULL , `serial_id` INTEGER NOT NULL , FOREIGN KEY ( `user_id` ) REFERENCES `users` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `watched_serials` ( `user_id` INTEGER NOT NULL , `serial_id` INTEGER NOT NULL , FOREIGN KEY ( `user_id` ) REFERENCES `users` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;
