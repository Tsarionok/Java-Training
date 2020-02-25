# Прочитать всех пользователей
SELECT
`users`.ID,
`users`.LOGIN,
`users`.ROLE,
`user_info`.EMAIL,
`user_info`.SEX,
`user_info`.BIRTH_DATE,
`countries`.NAME AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.ID = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.COUNTRY_ID = `countries`.ID;

        # Прочитать пользователя по логину
SELECT
`users`.ID,
`users`.LOGIN,
`users`.ROLE,
`user_info`.EMAIL,
`user_info`.SEX,
`user_info`.BIRTH_DATE,
`countries`.NAME AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.ID = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.COUNTRY_ID = `countries`.ID
WHERE `users`.LOGIN =  'admin';

        # Прочитать пользователя по email
SELECT
`users`.ID,
`users`.LOGIN,
`users`.ROLE,
`user_info`.EMAIL,
`user_info`.SEX,
`user_info`.BIRTH_DATE,
`countries`.NAME AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.ID = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.COUNTRY_ID = `countries`.ID
WHERE `user_info`.EMAIL =  'admin_serega@mail.ru';

        # Удалить пользователя по логину
        -- DELETE FROM `users` WHERE `users`.login = 'editor';

        # Добавить информацию о пользователе (email)
        -- INSERT INTO `user_info` (user_id, email) VALUES (2, 'user@gmail.com');

        # Прочитать название страны по ID пользователя
SELECT `countries`.ID AS `counry_id` FROM `countries` WHERE `countries`.NAME =  'Беларусь';

        # Обноить информацию о пользователе
        -- UPDATE `user_info` SET country_id = 4, email = 'new@mail.ru', sex = 'м', birth_date = '1980-01-04' WHERE user_id = 2;

        # Прочитать пароль по логину
SELECT `users`.PASSWORD FROM `users` WHERE `users`.LOGIN =  'admin';

        # Найти количество пользователей
SELECT COUNT (ID) AS `count_users` FROM `users`;
