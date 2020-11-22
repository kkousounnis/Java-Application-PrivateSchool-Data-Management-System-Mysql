-- All the Assignments per course

use `privateschool`;

SELECT 
    `courses`.`Cid` AS `Course_ID`,
    `courses`.`title` AS `Title`,
    `courses`.`stream` AS `Sream`,
    `courses`.`type` AS `Type`,
    `assignments`.`title` AS `Title`,
    `assignments`.`description` AS `Description`,
    `assignments`.`subdatetime` AS `Subdatetime`
FROM
    `assignmentspercourse`
        INNER JOIN
    `assignments` ON `assignments`.`Aid` = `assignmentspercourse`.`id_assignment`
        INNER JOIN
    `courses` ON `courses`.`Cid` = `assignmentspercourse`.`id_course`
ORDER BY `courses`.`Cid`;