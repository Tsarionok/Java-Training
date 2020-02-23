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
