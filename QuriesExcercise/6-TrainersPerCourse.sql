-- All the trainers per course

use `privateschool`;

SELECT 
    `courses`.`Cid` AS `Course_ID`,
    `courses`.`title` AS `Title`,
    `courses`.`stream` AS `Stream`,
    `courses`.`type` AS `Type`,
    `trainers`.`firstname` AS `Trainers_First_Name`,
    `trainers`.`lastname` AS `Trainers_Last_Name`,
    `trainers`.`subject` AS `Subject`
FROM
    `trainerspercourse`
        INNER JOIN
    `trainers` ON `trainers`.`Tid` = `trainerspercourse`.`id_trainer`
        INNER JOIN
    `courses` ON `courses`.`Cid` = `trainerspercourse`.`id_course`
ORDER BY `courses`.`Cid`;