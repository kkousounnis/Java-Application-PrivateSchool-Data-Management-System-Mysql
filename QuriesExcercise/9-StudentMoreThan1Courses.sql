-- A list of students that belong to more than one courses

use `privateschool`;

SELECT 
    `students`.`Sid` AS `Student_ID`,
    `students`.`firstname` AS `First_Name`,
    `students`.`lastname` AS `Last_Name`,
    COUNT(`studentspercourses`.`id_student`) AS `HowManyCourses`
FROM
    `studentspercourses`
        INNER JOIN
    `students` ON `students`.`Sid` = `studentspercourses`.`id_student`
GROUP BY `studentspercourses`.`id_student`
HAVING `HowManyCourses` > 1;
