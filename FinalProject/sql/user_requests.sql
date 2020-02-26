# Прочитать всех пользователей
SELECT
`users`.id,
`users`.login,
`users`.role,
`user_info`.email,
`user_info`.birth_date,
`countries`.name AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.id = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id;

        # Прочитать пользователя по логину
SELECT
`users`.id,
`users`.login,
`users`.role,
`user_info`.email,
`user_info`.birth_date,
`countries`.name AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.id = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id
WHERE `users`.login =  'admin';

        # Прочитать пользователя по email
SELECT
`users`.id,
`users`.login,
`users`.role,
`user_info`.email,
`user_info`.birth_date,
`countries`.name AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.id = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id
WHERE `user_info`.email =  'admin_serega@mail.ru';

        # Удалить пользователя по логину
        -- DELETE FROM `users` WHERE `users`.login = 'editor';

        # Добавить информацию о пользователе (email)
        -- INSERT INTO `user_info` (user_id, email) VALUES (2, 'user@gmail.com');

        # Прочитать название страны по ID пользователя
SELECT `countries`.id AS `counry_id` FROM `countries` WHERE `countries`.name =  'Беларусь';

        # Обноить информацию о пользователе
        -- UPDATE `user_info` SET country_id = 4, email = 'new@mail.ru', sex = 'м', birth_date = '1980-01-04' WHERE user_id = 2;

        # Прочитать пароль по логину
SELECT `users`.password FROM `users` WHERE `users`.login =  'admin';

        # Найти количество пользователей
SELECT COUNT (id) AS `count_users` FROM `users`;

        # Найти пользователя по ID
SELECT
`users`.id,
`users`.login,
`users`.role,
`user_info`.email,
`user_info`.birth_date,
`countries`.name AS `country` FROM `users`
                                   LEFT OUTER JOIN `user_info` ON `users`.id = `user_id`
                                   LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id
WHERE `users`.id = 1;

        # Добавить пользователя
        -- INSERT INTO `users`(login, password, role) VALUES ('test', 'testpass', 2);

        # Обновить пользователя (логин, роль)
        -- UPDATE `users` SET login = 'upTest', role = 1 WHERE id = 5;

        # Удалить пользователя (по ID)
        -- DELETE FROM `users` WHERE id = 2;
