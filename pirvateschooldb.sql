DROP DATABASE `privateschool`;
CREATE DATABASE `privateschool`;
USE `privateschool` ;

-- Create Table `courses`

CREATE TABLE IF NOT EXISTS `courses` (
    `Cid` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(20) NULL DEFAULT NULL,
    `stream` VARCHAR(20) NULL DEFAULT NULL,
    `type` CHAR(8) NOT NULL, 
    `startdate` DATE NULL DEFAULT NULL,
    `enddate` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`Cid`)
);

-- Create Table `students`

CREATE TABLE IF NOT EXISTS `students` (
    `Sid` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(20) NULL DEFAULT NULL,
    `lastname` VARCHAR(30) NULL DEFAULT NULL,
    `dateofbirth` DATE NULL DEFAULT NULL,
    `tuitionfees` DECIMAL(7 , 1 ) UNSIGNED NULL DEFAULT NULL,
    PRIMARY KEY (`Sid`)
);

-- Create Table `trainers`

CREATE TABLE IF NOT EXISTS `trainers` (
    `Tid` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(20) NULL DEFAULT NULL,
    `lastname` VARCHAR(30) NULL DEFAULT NULL,
    `subject` VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (`Tid`)
);

-- Create Table `assignments`

CREATE TABLE IF NOT EXISTS `assignments` (
    `Aid` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(20) NULL DEFAULT NULL,
    `description` VARCHAR(50) NULL DEFAULT NULL,
    `subdatetime` DATE NULL DEFAULT NULL,
    `oralmark` DECIMAL(3 , 2 ) UNSIGNED NULL DEFAULT NULL,
    `totalmark` DECIMAL(3 , 2 ) UNSIGNED NULL DEFAULT NULL,
    PRIMARY KEY (`Aid`)
);



-- Create Table `studentspercourses`

CREATE TABLE IF NOT EXISTS `studentspercourses` (
    `id_course` INT NOT NULL,
    `id_student` INT NOT NULL,
    PRIMARY KEY (`id_course`,`id_student`),
    KEY `fk_Cid` (`id_course`),
    KEY `fk_Sid` (`id_student`),
    CONSTRAINT `fk_Cid` FOREIGN KEY (`id_course`)
        REFERENCES `courses` (`Cid`),
    CONSTRAINT `fk_Sid` FOREIGN KEY (`id_student`)
        REFERENCES `students` (`Sid`)
);
 
 -- Create Table `assignmentspercourses`
 
CREATE TABLE IF NOT EXISTS `assignmentspercourse` (
    `id_course` INT NOT NULL,
    `id_assignment` INT NOT NULL,
    PRIMARY KEY(`id_course`,`id_assignment`),
    KEY `fk_Cid1` (`id_course`),
    KEY `fk_Aid` (`id_assignment`),
    CONSTRAINT `fk_Cid1` FOREIGN KEY (`id_course`)
        REFERENCES `courses` (`Cid`),
    CONSTRAINT `fk_Aid` FOREIGN KEY (`id_assignment`)
        REFERENCES `assignments` (`Aid`)
);

-- Create Table `trainerspercourse`

CREATE TABLE IF NOT EXISTS `trainerspercourse` (
    `id_course` INT NOT NULL,
    `id_trainer` INT NOT NULL,
    PRIMARY KEY (`id_course`,`id_trainer`),
    KEY `fk_Cid2` (`id_course`),
    KEY `fk_Tid` (`id_trainer`),
    CONSTRAINT `fk_Cid2` FOREIGN KEY (`id_course`)
        REFERENCES `courses` (`Cid`),
    CONSTRAINT `fk_Tid` FOREIGN KEY (`id_trainer`)
        REFERENCES `trainers` (`Tid`)
);

/*Insert Values To tables*/

-- Insert values to courses

INSERT INTO `courses`(`title`,`stream`,`type`,`startdate`,`enddate`) 
VALUES ('course1','Javascript','Fulltime','2021/01/01','2021/03/31'),
('course1','Javascript','Parttime','2021/01/01','2021/05/31'),
('course2','Go','Fulltime','2021/01/01','2021/03/31'),
('course2','Go','Parttime','2021/01/01','2021/05/31'),
('course3','Postgresql','Fulltime','2021/01/01','2021/03/31'),
('course3','Postgresql','Parttime','2021/01/01','2021/05/31'),
('course4','Mysql','Fulltime','2021/01/01','2021/03/31'),
('course4','Mysql','Parttime','2021/01/01','2021/05/31');

-- Insert values to students

INSERT INTO `students`(`firstname`,`lastname`,`dateofbirth`,`tuitionfees`)
VALUES ('Klemens','Habgood','1994/05/12',5000),
('Rina','Vasilchenko','1994/06/06',5000),
('Tabina','Steinhammer','1992/02/08',5000),
('Johanna','Stanislaw','1994/03/07',5000),
('Leila','Pierce','1993/04/10',5000),
('Marten','Kowalski','1995/05/09',5000),
('Elladine','Shorrock','1996/02/08',5000),
('Sanderson','Tankard','1992/07/04',5000),
('Lindsy','Matches','1995/10/02',5000),
('Teador','Middup','1995/07/11',5000);

-- Insert values to trainers

INSERT INTO `trainers` (`firstname`,`lastname`,`subject`) 
VALUES ('Corissa','Abrahim','Backend'),
('Judith','Howatt','Database'),
('Merry','Kenewell','Backend'),
('Isahella','Gockelen','Database'),
('Judith','Howatt','Backend'),
('Merry','Kenewell','Database'),
('Denys','Lambden','Backend'),
('Neal','Hairsnape','Database');

-- Insert values to assignments

INSERT INTO `assignments` (`title`,`description`,`subdatetime`)
VALUES('Assignment1','Create a hello world app','2021/01/08'),
('Assignment2','Create an Array List of animals','2021/01/16'),
('Assignment3','Create an Sorting Algorithm','2021/01/24'),
('Assignment4','Create an java consola Application','2021/02/02'),
('Assignment5','Create a Select From qeury','2021/01/08'),
('Assignment6','Create a quyrt with aggregation','2021/01/16'),
('Assignment7','Create a nested query','2021/01/24'),
('Assignment8','Create an inner join query','2021/02/02');

-- Insert values to studentspercourses

INSERT INTO `studentspercourses`(`id_course`,`id_student`) VALUES (1,1),(2,1),(3,1)
,(1,2),(3,2),
(4,3),(2,3),
(5,4),
(6,5),
(7,6),(8,6),
(3,7),(8,7),
(4,8),
(5,9),
(7,10);

-- Insert values to trainerspercourse

INSERT INTO `trainerspercourse`(`id_course`,`id_trainer`) VALUES(4,7),
(3,7),
(2,1),
(1,3),
(7,4),
(8,2),
(5,8),
(6,6);

-- Insert values to assignmentspercourse
INSERT INTO `assignmentspercourse`(`id_course`,`id_assignment`) 
VALUES(1,1),(1,2),(1,3),(1,4),
(2,1),(2,2),(2,3),(2,4),
(3,1),(3,2),(3,3),(3,4),
(4,1),(4,2),(4,3),(4,4),
(5,5),(5,6),(5,7),(5,8),
(6,5),(6,6),(6,7),(6,8),
(7,5),(7,6),(7,7),(7,8),
(8,5),(8,6),(8,7),(8,8);



