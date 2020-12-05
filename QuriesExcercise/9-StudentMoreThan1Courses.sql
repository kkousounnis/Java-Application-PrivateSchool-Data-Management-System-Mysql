-- A list of students that belong to more than one courses

use `privateschool`;

SELECT 
    `students`.`Sid` AS `Student_ID`,
    `students`.`firstname` AS `First_Name`,
    `students`.`lastname` AS `Last_Name`,
    COUNT(`studentspercourse`.`id_student`) AS `HowManyCourses`
FROM
    `studentspercourse`
        INNER JOIN
    `students` ON `students`.`Sid` = `studentspercourse`.`id_student`
GROUP BY `studentspercourse`.`id_student`
HAVING `HowManyCourses` > 1;
