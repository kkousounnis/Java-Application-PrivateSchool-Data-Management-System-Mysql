-- A list of all the students

USE `privateschool`;

SELECT 
    `firstname` AS `First_Name`,
    `lastname` AS `Last_Name`,
    `dateofbirth` AS `Date_Of_Birth`,
    `tuitionfees` AS `TuitionFees`
FROM
    `students`