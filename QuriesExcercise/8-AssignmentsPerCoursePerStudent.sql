-- All the assignments per course per student

use `privateschool`;

SELECT 
    `assignmentspercourse`.`id_assignment` AS `Assignment_ID`,
    `assignments`.`title` AS `Title`,
    `assignments`.`description` AS `Description`,
    `assignments`.`subdatetime` AS `Subdatetime`,
    `courses`.`Cid` AS `Courses_Id`,
    `courses`.`title` AS `Title`,
    `courses`.`stream` AS `Stream`,
    `courses`.`type` AS `Type`,
    `students`.`Sid` AS `Student_ID`,
    `students`.`firstname` AS `First_Name`,
    `students`.`lastname` AS `Last_Name`,
    `students`.`dateofbirth` AS `Date_Of_Birth`,
    `students`.`tuitionfees` AS `TuitionFees`
FROM
    `assignmentspercourse`
        INNER JOIN
    `assignments` ON `assignments`.`Aid` = `assignmentspercourse`.`id_assignment`
        INNER JOIN
    `courses` ON `courses`.`Cid` = `assignmentspercourse`.`id_course`
        INNER JOIN
    `studentspercourse` ON `studentspercourse`.`id_course` = `courses`.`Cid`
        INNER JOIN
    `students` ON `students`.`Sid` = `studentspercourse`.`id_student`
ORDER BY `courses`.`Cid` , `students`.`Sid` , `assignments`.`Aid`;