-- All the trainers per course

use `privateschool`;

SELECT `courses`.`Cid` AS Course_ID,
`courses`.`title` AS Title,
 `courses`.`stream` AS Sream,
 `courses`.`type` AS Type,
 `trainers`.`firstname` AS First_Name,
 `trainers`.`lastname` AS Last_Name,
 `trainers`.`subject` AS Subject
FROM `trainerspercourse`
inner join `trainers`
on  `trainers`.`Tid` = `trainerspercourse`.`id_trainer`
inner join `courses`
on `courses`.`Cid` = `trainerspercourse`.`id_course`
order by `courses`.`Cid`;