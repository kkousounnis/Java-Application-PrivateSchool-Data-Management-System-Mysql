-- All the students per course

use `privateschool`;

SELECT `courses`.`Cid` AS Course_ID,
`courses`.`title` AS Title,
 `courses`.`stream` AS Sream,
 `courses`.`type` AS Type,
 `students`.`firstname` AS First_Name,
 `students`.`lastname` AS Last_Name
FROM `studentspercourses`
inner join `students`
on  `students`.`Sid` = `studentspercourses`.`id_student`
inner join `courses`
on `courses`.`Cid` = `studentspercourses`.`id_course`
order by `courses`.`Cid`;