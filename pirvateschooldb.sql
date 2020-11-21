DROP DATABASE `privateschool`;
CREATE DATABASE `privateschool`;
USE `privateschool` ;

-- Table `privateschool`.`assignments`

CREATE TABLE IF NOT EXISTS `assignments` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(20) NULL DEFAULT NULL,
    `subdatetime` DATE NULL DEFAULT NULL,
    `oralmark` DECIMAL(3 , 2 ) UNSIGNED NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- Table `privateschool`.`courses`

CREATE TABLE IF NOT EXISTS `courses` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(20) NULL DEFAULT NULL,
    `stream` VARCHAR(20) NULL DEFAULT NULL,
    `type` TINYINT NOT NULL,
    `startdate` DATE NULL DEFAULT NULL,
    `enddate` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);


-- Table `privateschool`.`students`

CREATE TABLE IF NOT EXISTS `students` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(20) NULL DEFAULT NULL,
    `lastname` VARCHAR(30) NULL DEFAULT NULL,
    `dateofbirth` DATE NULL DEFAULT NULL,
    `tuitionfees` DECIMAL(7 , 1 ) UNSIGNED NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- Table `privateschool`.`trainers`
CREATE TABLE IF NOT EXISTS `privateschool`.`trainers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(20) NULL DEFAULT NULL,
    `lastname` VARCHAR(30) NULL DEFAULT NULL,
    `subject` VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- Table `privateschool`.`assignments`

CREATE TABLE IF NOT EXISTS `assignments` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(20) NULL DEFAULT NULL,
    `subdatetime` DATE NULL DEFAULT NULL,
    `oralmark` DECIMAL(3 , 2 ) UNSIGNED NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);
