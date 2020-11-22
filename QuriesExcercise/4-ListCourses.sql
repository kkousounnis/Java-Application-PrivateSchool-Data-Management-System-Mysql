-- A list of all the courses

USE `privateschool`;

SELECT 
	`title` AS `Title`,
    `stream` AS `Stream`,
    `type` AS `Type`,
    `startdate` AS `StartDate`,
    `enddate` AS `EndDate`
FROM `courses`