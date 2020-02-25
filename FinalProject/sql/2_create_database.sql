CREATE DATABASE `series_catalog_db` DEFAULT CHARACTER SET utf8;

CREATE USER IF NOT EXISTS  'series_catalog_user' @ 'localhost' IDENTIFIED BY  'root'; GRANT
SELECT ,
INSERT ,
UPDATE ,
DELETE ON `series_catalog_db`.* TO  'series_catalog_user' @ 'localhost';
