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
FROM `assignmentspercourse`
inner join `assignments`
on  `assignments`.`Aid` = `assignmentspercourse`.`id_assignment`
inner join `courses`
on `courses`.`Cid` = `assignmentspercourse`.`id_course`
order by `courses`.`Cid`;