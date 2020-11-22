-- A list of all the assignments

USE `privateschool`;

SELECT 
    `title` AS `Title`,
    `description` AS `Description`,
    `subdatetime` AS `SubDateTime`,
    `oralmark` AS `OralMark`,
    `totalmark` AS `TotalMark`
FROM
    `assignments`