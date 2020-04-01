# Прочитать сериал по id
SELECT ` serials ` . id , ` serials ` . name , ` serials ` . premier_date , ` serials ` . image_path , ` serials ` . description , ` countries ` . name AS ` country ` , ` categories ` . name AS ` category ` FROM ` serials ` LEFT OUTER JOIN ` countries ` ON ` countries ` . id = ` country_id ` LEFT OUTER JOIN ` categories ` ON ` categories ` . id = ` category_id `
ORDER BY ` serials `.id LIMIT 3 OFFSET 0 ; # Прочитать сериал по названию
SELECT ` serials ` . id , ` serials ` . name , ` serials ` . premier_date , ` serials ` . image_path , ` serials ` . description , ` countries ` . name AS ` country ` , ` categories ` . name AS ` category ` FROM ` serials ` LEFT OUTER JOIN ` countries ` ON ` countries ` . id = ` country_id ` LEFT OUTER JOIN ` categories ` ON ` categories ` . id = ` category_id `
WHERE ` serials `.name = 'Шерлок' ;
