-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Temps de generació: 09-11-2022 a les 15:56:25
-- Versió del servidor: 10.4.24-MariaDB
-- Versió de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `employeedb`
--

DELIMITER $$
--
-- Procediments
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADDEMPLOYEE` (IN `newDate` DATE, IN `newFirstName` VARCHAR(40), IN `newId` INT, IN `newLastName` VARCHAR(40), IN `newSalary` FLOAT)   BEGIN

INSERT INTO employee (BIRTHDATE, FIRSTNAME, ID, LASTNAME, SALARY)
VALUES (newDate, newFirstName, newId, newLastName, newSalary);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FINDALLEMPLOYEES` ()   BEGIN

SELECT ID, FIRSTNAME, LASTNAME, BIRTHDATE, SALARY
FROM employee;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `REMOVEEMPLOYEE` (IN `newId` INT)   BEGIN

DELETE FROM employee 
WHERE ID = newId;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATEEMPLOYEE` (IN `newDate` DATE, IN `newFirstName` VARCHAR(40), IN `newId` INT, IN `newLastName` VARCHAR(40), IN `newSalary` FLOAT)   BEGIN

UPDATE employee
SET ID = newId, BIRTHDATE = newDate, FIRSTNAME = newFirstName, LASTNAME = newLastName, SALARY = newSalary
WHERE ID = newId;


END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de la taula `employee`
--

CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `FIRSTNAME` varchar(40) NOT NULL,
  `LASTNAME` varchar(40) NOT NULL,
  `BIRTHDATE` date DEFAULT NULL,
  `SALARY` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcament de dades per a la taula `employee`
--

INSERT INTO `employee` (`ID`, `FIRSTNAME`, `LASTNAME`, `BIRTHDATE`, `SALARY`) VALUES
(101, 'Abhijit', 'Gopali', '1956-06-01', 89345),
(102, 'Peter', 'Forrester', '1965-11-01', 99345),
(110, 'Troy', 'Hammer', '1965-03-31', 102109.15),
(111, 'Matthieu', 'Williams', '1966-05-31', 100345.15),
(120, 'Rajiv', 'Sudahari', '1969-12-22', 68400.22),
(121, 'Kenny', 'Arlington', '1959-10-22', 78405.22),
(123, 'Michael', 'Walton', '1986-08-25', 93400.2),
(124, 'Michael', 'McGinn', '1979-01-25', 99400.2),
(129, 'Cindy', 'Colchester', '1965-03-24', 902109.15),
(130, 'David', 'OReilly', '1969-12-25', 88400.22),
(133, 'Clarence', 'Dupree', '1986-08-11', 103400.2),
(151, 'Arfat', 'Poland', '1956-06-11', 99345),
(190, 'Patrice', 'Bergeron', '1970-09-18', 109345),
(191, 'Jill', 'Molinair', '1968-08-18', 119345),
(200, 'Patricia', 'Arnant', '1970-10-31', 79345),
(201, 'Thomas', 'Fitzpatrick', '1961-09-22', 75123.45),
(202, 'Thomas', 'Heimer', '1967-07-22', 79123.45),
(211, 'Paromita', 'Sumesh', '1961-09-13', 105123.45),
(212, 'Joan', 'Joanet', '1999-12-22', 5058.647);

-- --------------------------------------------------------

--
-- Estructura de la taula `vendes`
--

CREATE TABLE `vendes` (
  `EMPID` int(11) NOT NULL,
  `DATA` date NOT NULL,
  `IMPORT` float NOT NULL,
  `PERC_COMISSIO` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcament de dades per a la taula `vendes`
--

INSERT INTO `vendes` (`EMPID`, `DATA`, `IMPORT`, `PERC_COMISSIO`) VALUES
(212, '2020-12-12', 60000, 0.01);

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`);

--
-- Índexs per a la taula `vendes`
--
ALTER TABLE `vendes`
  ADD PRIMARY KEY (`EMPID`,`DATA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
