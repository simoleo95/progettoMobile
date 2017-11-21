-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Nov 21, 2017 alle 20:53
-- Versione del server: 5.6.31
-- Versione PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `MYUNIVAQ`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Appello`
--

CREATE TABLE IF NOT EXISTS `Appello` (
  `id` int(255) NOT NULL,
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `data_esame` date NOT NULL,
  `descrizione` text COLLATE utf8_bin NOT NULL,
  `aula` varchar(255) COLLATE utf8_bin NOT NULL,
  `oraInizio` varchar(255) COLLATE utf8_bin NOT NULL,
  `oraFine` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Appello`
--

INSERT INTO `Appello` (`id`, `fk_materia`, `data_esame`, `descrizione`, `aula`, `oraInizio`, `oraFine`) VALUES
(1, 'ing-03', '2018-01-05', 'test', 'a01', '09:00:00', '13:00:00'),
(2, 'fff', '2018-01-12', 'test', 'a02', '10:00:00', '14:00:00'),
(3, 'algor01', '2018-02-01', 'primo appello 2018', 'a-01', '12:15', '16:15'),
(4, 'algor01', '2017-05-09', 'appello a caso', 'a-02', '12:30', '15:40'),
(5, 'anali01', '2018-02-03', 'primo appello 2018', 'a-02', '9:00', '12:00'),
(6, 'anali01', '2017-07-17', 'appello estivo', 'c-01', '10:00', '12:00'),
(7, 'anali02', '2018-02-05', 'primo appello ', 'a-05', '14:00', '16:00'),
(8, 'anali02', '2017-05-16', 'appello estivo', 'b-04', '13:00', '17:00'),
(9, 'fisic01', '2018-02-12', 'primo appello', 'a-04', '09:00', '13:00'),
(10, 'fisic01', '2017-06-13', 'seconda sessione di esame', 'b-04', '12:00', '15:00'),
(11, 'fisic02', '2018-02-11', 'primo esame', 'c-04', '9:00', '11:00'),
(12, 'fisic02', '2017-06-12', 'terzo esame', 'c-04', '9:50', '13:00'),
(13, 'infb01', '2018-02-05', 'primo esame', 'b-02', '14:00', '16:00'),
(14, 'infb01', '2017-06-12', 'terzo esame ', 'a-04', '12:00', '15:00'),
(15, 'ingl02', '2018-02-19', 'first exam', 'a-07', '09:00', '12:00'),
(16, 'ingl02', '2017-06-05', 'first summer exam ', 'a-08', '09:50', '12:50'),
(17, 'ingleb', '2018-02-05', 'primo esame', 'a-05', '13:00', '15:00'),
(18, 'ingleb', '2017-07-18', 'esame estivo', 'b-07', '13:00', '14:00'),
(19, 'mobile2', '2017-11-22', 'rivisione esame', 'c-06', '15:00', '16:00'),
(20, 'prob01', '2018-02-11', 'primo esame', 'b-09', '12:00', '14:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `Aula`
--

CREATE TABLE IF NOT EXISTS `Aula` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `blocco` varchar(16) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Aula`
--

INSERT INTO `Aula` (`id`, `blocco`) VALUES
('a-01', '0'),
('a-02', '0'),
('a-03', '0'),
('a-04', '0'),
('a-05', '0'),
('a-06', '0'),
('a-07', '0'),
('a-08', '0'),
('a-99', '0'),
('b-01', '1'),
('b-02', '1'),
('b-03', '1'),
('b-04', '1'),
('b-05', '1'),
('b-07', '1'),
('b-09', '1'),
('c-01', '2'),
('c-02', '2'),
('c-03', '2'),
('c-04', '2'),
('c-06', '2');

-- --------------------------------------------------------

--
-- Struttura della tabella `CorsiScelti`
--

CREATE TABLE IF NOT EXISTS `CorsiScelti` (
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_studente` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `CorsiScelti`
--

INSERT INTO `CorsiScelti` (`fk_materia`, `fk_studente`) VALUES
('mobile2', 111111),
('fisic02', 236425);

-- --------------------------------------------------------

--
-- Struttura della tabella `CorsoDiLaurea`
--

CREATE TABLE IF NOT EXISTS `CorsoDiLaurea` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `descrizione` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `CorsoDiLaurea`
--

INSERT INTO `CorsoDiLaurea` (`id`, `nome`, `descrizione`) VALUES
('fisica-01', 'fisica', 'corso di fisca-01'),
('informatica-001', 'informatica', 'corso di informatica 1'),
('ing-inf001', 'ingegneria', 'corso di ingegneria informatica 1'),
('matematica-01', 'matematica', 'corso di matematica-01');

-- --------------------------------------------------------

--
-- Struttura della tabella `EsamiSvolti`
--

CREATE TABLE IF NOT EXISTS `EsamiSvolti` (
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_studente` int(255) NOT NULL,
  `voto` int(255) NOT NULL,
  `fk_appello` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `EsamiSvolti`
--

INSERT INTO `EsamiSvolti` (`fk_materia`, `fk_studente`, `voto`, `fk_appello`) VALUES
('anali01', 222222, 28, 6),
('anali02', 111111, 28, 7),
('ingleb', 111111, 30, 18),
('ingleb', 222222, 22, 18),
('ingleb', 236425, 26, 18),
('mobile2', 236425, 30, 19);

-- --------------------------------------------------------

--
-- Struttura della tabella `insegnamento`
--

CREATE TABLE IF NOT EXISTS `insegnamento` (
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_professore` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `insegnamento`
--

INSERT INTO `insegnamento` (`fk_materia`, `fk_professore`) VALUES
('ingl02', 0),
('ingleb', 0),
('fisic01', 1),
('fisic02', 1),
('anali02', 2),
('infb01', 2),
('prob01', 2),
('algor01', 3),
('anali01', 3),
('mobile2', 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `iscrizione`
--

CREATE TABLE IF NOT EXISTS `iscrizione` (
  `fk_studente` int(255) NOT NULL,
  `fk_appello` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `iscrizione`
--

INSERT INTO `iscrizione` (`fk_studente`, `fk_appello`) VALUES
(236425, 12);

-- --------------------------------------------------------

--
-- Struttura della tabella `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `id` int(255) NOT NULL,
  `Descrizione` text COLLATE utf8_bin NOT NULL,
  `Data` datetime NOT NULL,
  `fk_user` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Log`
--

INSERT INTO `Log` (`id`, `Descrizione`, `Data`, `fk_user`) VALUES
(36, 'Login effettuato, modificato il token', '2017-11-21 15:34:37', 'cris'),
(37, 'Login effettuato, modificato il token', '2017-11-21 15:35:03', 'cris'),
(38, 'Login effettuato, modificato il token', '2017-11-21 15:35:59', 'cris'),
(39, 'Login effettuato, modificato il token', '2017-11-21 15:39:52', 'MUSE'),
(40, 'Login effettuato, modificato il token', '2017-11-21 16:03:13', 'MUSE'),
(41, 'Login effettuato, modificato il token', '2017-11-21 16:06:38', 'cris'),
(43, 'Login effettuato, modificato il token', '2017-11-21 21:29:28', 'cris'),
(44, 'Login effettuato, modificato il token', '2017-11-21 21:30:59', 'cris'),
(45, 'Login effettuato, modificato il token', '2017-11-21 21:40:01', 'cris'),
(46, 'Login effettuato, modificato il token', '2017-11-21 21:49:09', 'cris');

-- --------------------------------------------------------

--
-- Struttura della tabella `Login`
--

CREATE TABLE IF NOT EXISTS `Login` (
  `user` varchar(255) COLLATE utf8_bin NOT NULL,
  `psw` varchar(255) COLLATE utf8_bin NOT NULL,
  `token` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `matricola` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Login`
--

INSERT INTO `Login` (`user`, `psw`, `token`, `email`, `matricola`) VALUES
('CarloSantana', 'rootroot', '', 'carlo.santana@host.org', 111111),
('MUSE', 'rootroot', 'MUSE:54e6e7e28cbb4527', 'm.use@host.org', 333333),
('OzzyOsb', 'rootroot', '', 'ozzy@host.org', 222222),
('PabloIlBuono', 'rootroot', '', 'plata.o.plombo@host.org', 444444),
('cris', 'qwerty', 'cris:44c65aa4f7294812', 'cristiano.orsetti@hotmail.it', 236425);

-- --------------------------------------------------------

--
-- Struttura della tabella `Materia`
--

CREATE TABLE IF NOT EXISTS `Materia` (
  `codice` varchar(255) COLLATE utf8_bin NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `anno` int(11) NOT NULL,
  `cfu` int(32) NOT NULL,
  `tipoCfu` varchar(255) COLLATE utf8_bin NOT NULL,
  `semestre` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Materia`
--

INSERT INTO `Materia` (`codice`, `nome`, `anno`, `cfu`, `tipoCfu`, `semestre`) VALUES
('algor01', 'algoritmi', 2, 12, 'inf01', 1),
('anali01', 'Analisi 1', 1, 12, 'mat01', 1),
('anali02', 'analisi 2', 2, 9, 'mat01', 1),
('fisic01', 'fisica 1', 1, 6, 'mat01', 2),
('fisic02', 'fisica 2', 2, 6, 'mat02', 2),
('infb01', 'informatica base', 1, 12, 'inf01', 1),
('ingl02', 'inglese avanzato', 2, 3, 'bo02', 2),
('ingleb', 'inglese base', 1, 3, 'bo01', 1),
('mobile2', 'dispositivi mobili', 3, 9, 'inf02', 2),
('prob01', 'calcolo e probabilità ', 2, 6, 'mat01', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `MaterieCorso`
--

CREATE TABLE IF NOT EXISTS `MaterieCorso` (
  `id_corso` varchar(255) COLLATE utf8_bin NOT NULL,
  `id_materia` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `MaterieCorso`
--

INSERT INTO `MaterieCorso` (`id_corso`, `id_materia`) VALUES
('fisica-01', 'anali01'),
('fisica-01', 'fisic01'),
('fisica-01', 'fisic02'),
('fisica-01', 'ingleb'),
('informatica-001', 'algor01'),
('informatica-001', 'anali01'),
('informatica-001', 'ingleb'),
('informatica-001', 'mobile2'),
('ing-inf001', 'anali01'),
('ing-inf001', 'anali02'),
('ing-inf001', 'ingleb'),
('ing-inf001', 'mobile2'),
('matematica-01', 'anali01'),
('matematica-01', 'anali02'),
('matematica-01', 'fisic01'),
('matematica-01', 'ingleb');

-- --------------------------------------------------------

--
-- Struttura della tabella `Orario`
--

CREATE TABLE IF NOT EXISTS `Orario` (
  `id` int(255) NOT NULL,
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_aula` varchar(255) COLLATE utf8_bin NOT NULL,
  `giorno` varchar(255) COLLATE utf8_bin NOT NULL,
  `oraInizio` time NOT NULL,
  `oraFine` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Orario`
--

INSERT INTO `Orario` (`id`, `fk_materia`, `fk_aula`, `giorno`, `oraInizio`, `oraFine`) VALUES
(5, 'algor01', 'a-01', 'lunedì', '09:00:00', '11:00:00'),
(6, 'algor01', 'a-01', 'mercoledì', '13:00:00', '14:00:00'),
(7, 'anali01', 'a-08', 'lunedì', '09:00:00', '13:00:00'),
(8, 'anali01', 'a-08', 'venerdì', '14:00:00', '16:00:00'),
(9, 'anali02', 'b-01', 'martedì', '09:00:00', '10:00:00'),
(10, 'anali02', 'b-02', 'giovedì', '09:00:00', '10:00:00'),
(11, 'fisic01', 'c-03', 'lunedì', '12:00:00', '13:00:00'),
(12, 'fisic01', 'c-03', 'martedì', '13:00:00', '14:00:00'),
(13, 'infb01', 'b-04', 'martedì', '14:00:00', '15:00:00'),
(14, 'infb01', 'b-04', 'giovedì', '14:00:00', '15:00:00'),
(15, 'ingl02', 'a-05', 'lunedì', '13:00:00', '14:00:00'),
(16, 'ingleb', 'a-06', 'martedì', '13:00:00', '14:00:00'),
(17, 'mobile2', 'a-03', 'lunedì', '14:00:00', '15:00:00'),
(18, 'mobile2', 'a-03', 'mercoledì', '14:00:00', '15:00:00'),
(19, 'prob01', 'c-03', 'venerdi', '09:00:00', '10:00:00'),
(20, 'mobile2', 'a-99', 'martedì', '09:00:00', '23:00:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `Professore`
--

CREATE TABLE IF NOT EXISTS `Professore` (
  `id` int(255) NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `cognome` varchar(255) COLLATE utf8_bin NOT NULL,
  `dataDiNascita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Professore`
--

INSERT INTO `Professore` (`id`, `nome`, `cognome`, `dataDiNascita`) VALUES
(0, 'William', 'Shakespeare', '1939-09-08'),
(1, 'Albert', 'Einstein', '1955-04-18'),
(2, 'John', 'Nash', '1969-07-07'),
(3, 'leonardo', 'fibonacci', '1940-01-01'),
(4, 'Amleto', 'di Salle', '1971-09-09');

-- --------------------------------------------------------

--
-- Struttura della tabella `Questionario`
--

CREATE TABLE IF NOT EXISTS `Questionario` (
  `path` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_studente` int(255) NOT NULL,
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_pro` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Questionario`
--

INSERT INTO `Questionario` (`path`, `fk_studente`, `fk_materia`, `fk_pro`) VALUES
('MYUNIVAQ3questionari236425_fisic02_1.json', 236425, 'fisic02', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `Studente`
--

CREATE TABLE IF NOT EXISTS `Studente` (
  `matricola` int(255) NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `cognome` varchar(255) COLLATE utf8_bin NOT NULL,
  `dataDiNascita` date NOT NULL,
  `corso` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Studente`
--

INSERT INTO `Studente` (`matricola`, `nome`, `cognome`, `dataDiNascita`, `corso`) VALUES
(111111, 'Carlo', 'Santana', '1995-11-01', 'fisica-01'),
(222222, 'Ozzy', 'Osbourne', '1993-11-02', 'matematica-01'),
(236425, 'Cristiano', 'Orsetti', '1995-08-29', 'informatica-001'),
(333333, 'Matthew', 'Bellamy', '1997-11-08', 'ing-inf001'),
(444444, 'Pablo', 'Escobar', '1990-11-17', 'informatica-001');

-- --------------------------------------------------------

--
-- Struttura della tabella `TABLE 17`
--

CREATE TABLE IF NOT EXISTS `TABLE 17` (
  `COL 1` varchar(15) DEFAULT NULL,
  `COL 2` varchar(22) DEFAULT NULL,
  `COL 3` varchar(33) DEFAULT NULL,
  `COL 4` varchar(43) DEFAULT NULL,
  `COL 5` varchar(15) DEFAULT NULL,
  `COL 6` varchar(5) DEFAULT NULL,
  `COL 7` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `TABLE 17`
--

INSERT INTO `TABLE 17` (`COL 1`, `COL 2`, `COL 3`, `COL 4`, `COL 5`, `COL 6`, `COL 7`) VALUES
('3', 'algor01', '2018-02-01', 'primo appello 2018', 'a-01', '12:15', '16:15'),
('4', 'algor01', '2017-05-09', 'appello a caso', 'a-02', '12:30', '15:40'),
('5', 'anali01', '2018-02-03', 'primo appello 2018', 'a-02', '9:00', '12:00'),
('6', 'anali01', '2017-07-17', 'appello estivo', 'c-01', '10:00', '12:00'),
('7', 'anali02', '2018-02-05', 'primo appello ', 'a-05', '14:00', '16:00'),
('8', 'anali02', '2017-05-16', 'appello estivo', 'b-04', '13:00', '17:00'),
('9', 'fisic01', '2018-02-12', 'primo appello', 'a-04', '09:00', '13:00'),
('10', 'fisic01', '2017-06-13', 'seconda sessione di esame', 'b-04', '12:00', '15:00'),
('11', 'fisic02', '2018-02-11', 'primo esame', 'c-04', '9:00', '11:00'),
('12', 'fisic02', '2017-06-12', 'terzo esame', 'c-04', '9:50', '13:00'),
('13', 'infb01', '2018-02-05', 'primo esame', 'b-02', '14:00', '16:00'),
('14', 'infb01', '2017-06-12', 'terzo esame ', 'a-04', '12:00', '15:00'),
('15', 'ingl02', '2018-02-19', 'first exam', 'a-07', '09:00', '12:00'),
('16', 'ingl02', '2017-06-05', 'first summer exam ', 'a-08', '09:50', '12:50'),
('17', 'ingleb', '2018-02-05', 'primo esame', 'a-05', '13:00', '15:00'),
('18', 'ingleb', '2017-07-18', 'esame estivo', 'b-07', '13:00', '14:00'),
('19', 'mobile2', '2017-11-22', 'rivisione esame', 'c-06', '15:00', '16:00'),
('20', 'prob01', '2018-02-11', 'primo esame', 'b-09', '12:00', '14:00'),
('a-01', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-02', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-03', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-04', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-05', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-06', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-07', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('a-08', 'coppito0', NULL, NULL, NULL, NULL, NULL),
('b-01', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('b-02', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('b-03', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('b-04', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('b-05', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('b-07', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('b-09', 'coppito1', NULL, NULL, NULL, NULL, NULL),
('c-01', 'coppito2', NULL, NULL, NULL, NULL, NULL),
('c-02', 'coppito2', NULL, NULL, NULL, NULL, NULL),
('c-03', 'coppito2', NULL, NULL, NULL, NULL, NULL),
('c-04', 'coppito2', NULL, NULL, NULL, NULL, NULL),
('c-06', 'coppito2', NULL, NULL, NULL, NULL, NULL),
('mobile2', '111111', NULL, NULL, NULL, NULL, NULL),
('fisic02', '236425', NULL, NULL, NULL, NULL, NULL),
('fisica-01', 'fisica', 'corso di fisca-01', NULL, NULL, NULL, NULL),
('informatica-001', 'informatica', 'corso di informatica 1', NULL, NULL, NULL, NULL),
('ing-inf001', 'ingegneria', 'corso di ingegneria informatica 1', NULL, NULL, NULL, NULL),
('matematica-01', 'matematica', 'corso di matematica-01', NULL, NULL, NULL, NULL),
('anali01', '222222', '28', '6', NULL, NULL, NULL),
('anali02', '111111', '28', '7', NULL, NULL, NULL),
('ingleb', '111111', '30', '18', NULL, NULL, NULL),
('ingleb', '222222', '22', '18', NULL, NULL, NULL),
('ingleb', '236425', '26', '18', NULL, NULL, NULL),
('mobile2', '236425', '30', '19', NULL, NULL, NULL),
('ingl02', '0', NULL, NULL, NULL, NULL, NULL),
('ingleb', '0', NULL, NULL, NULL, NULL, NULL),
('fisic01', '1', NULL, NULL, NULL, NULL, NULL),
('fisic02', '1', NULL, NULL, NULL, NULL, NULL),
('anali02', '2', NULL, NULL, NULL, NULL, NULL),
('infb01', '2', NULL, NULL, NULL, NULL, NULL),
('prob01', '2', NULL, NULL, NULL, NULL, NULL),
('algor01', '3', NULL, NULL, NULL, NULL, NULL),
('anali01', '3', NULL, NULL, NULL, NULL, NULL),
('mobile2', '4', NULL, NULL, NULL, NULL, NULL),
('CarloSantana', 'rootroot', '', 'carlo.santana@host.org', '111111', NULL, NULL),
('MUSE', 'rootroot', '', 'm.use@host.org', '333333', NULL, NULL),
('OzzyOsb', 'rootroot', '', 'ozzy@host.org', '222222', NULL, NULL),
('PabloIlBuono', 'rootroot', '', 'plata.o.plombo@host.org', '444444', NULL, NULL),
('cris', 'qwerty', '', 'cristiano.orsetti@hotmail.it', '236425', NULL, NULL),
('algor01', 'algoritmi', '2', '12', 'inf01', '1', NULL),
('anali01', 'Analisi 1', '1', '12', 'mat01', '1', NULL),
('anali02', 'analisi 2', '2', '9', 'mat01', '1', NULL),
('fisic01', 'fisica 1', '1', '6', 'mat01', '2', NULL),
('fisic02', 'fisica 2', '2', '6', 'mat02', '2', NULL),
('infb01', 'informatica base', '1', '12', 'inf01', '1', NULL),
('ingl02', 'inglese avanzato', '2', '3', 'bo02', '2', NULL),
('ingleb', 'inglese base', '1', '3', 'bo01', '1', NULL),
('mobile2', 'dispositivi mobili', '3', '9', 'inf02', '2', NULL),
('prob01', 'calcolo e probabilità ', '2', '6', 'mat01', '2', NULL),
('fisica-01', 'anali01', NULL, NULL, NULL, NULL, NULL),
('fisica-01', 'fisic01', NULL, NULL, NULL, NULL, NULL),
('fisica-01', 'fisic02', NULL, NULL, NULL, NULL, NULL),
('fisica-01', 'ingleb', NULL, NULL, NULL, NULL, NULL),
('informatica-001', 'algor01', NULL, NULL, NULL, NULL, NULL),
('informatica-001', 'anali01', NULL, NULL, NULL, NULL, NULL),
('informatica-001', 'ingleb', NULL, NULL, NULL, NULL, NULL),
('informatica-001', 'mobile2', NULL, NULL, NULL, NULL, NULL),
('ing-inf001', 'anali01', NULL, NULL, NULL, NULL, NULL),
('ing-inf001', 'anali02', NULL, NULL, NULL, NULL, NULL),
('ing-inf001', 'ingleb', NULL, NULL, NULL, NULL, NULL),
('ing-inf001', 'mobile2', NULL, NULL, NULL, NULL, NULL),
('matematica-01', 'anali01', NULL, NULL, NULL, NULL, NULL),
('matematica-01', 'anali02', NULL, NULL, NULL, NULL, NULL),
('matematica-01', 'fisic01', NULL, NULL, NULL, NULL, NULL),
('matematica-01', 'ingleb', NULL, NULL, NULL, NULL, NULL),
('5', 'algor01', 'a-01', 'lunedì', '9:00', '11:00', NULL),
('6', 'algor01', 'a-01', 'mercoledì', '13:00', '14:00', NULL),
('7', 'anali01', 'a-08', 'lunedì', '9:00', '13:00', NULL),
('8', 'anali01', 'a-08', 'venerdì', '14:00', '16:00', NULL),
('9', 'anali02', 'b-01', 'martedì', '9:00', '10:00', NULL),
('10', 'anali02', 'b-02', 'giovedì', '9:00', '10:00', NULL),
('11', 'fisic01', 'c-03', 'lunedì', '12:00', '13:00', NULL),
('12', 'fisic01', 'c-03', 'martedì', '13:00', '14:00', NULL),
('13', 'infb01', 'b-04', 'martedì', '14:00', '15:00', NULL),
('14', 'infb01', 'b-04', 'giovedì', '14:00', '15:00', NULL),
('15', 'ingl02', 'a-05', 'lunedì', '13:00', '14:00', NULL),
('16', 'ingleb', 'a-06', 'martedì', '13:00', '14:00', NULL),
('17', 'mobile2', 'a-03', 'lunedì', '14:00', '15:00', NULL),
('18', 'mobile2', 'a-03', 'mercoledì', '14:00', '15:00', NULL),
('19', 'prob01', 'c-03', 'venerdi', '9:00', '10:00', NULL),
('0', 'William', 'Shakespeare', '1939-09-08', NULL, NULL, NULL),
('1', 'Albert', 'Einstein', '1955-04-18', NULL, NULL, NULL),
('2', 'John', 'Nash', '1969-07-07', NULL, NULL, NULL),
('3', 'leonardo', 'fibonacci', '1940-01-01', NULL, NULL, NULL),
('4', 'Amleto', 'di Salle', '1971-09-09', NULL, NULL, NULL),
('111111', 'Carlo', 'Santana', '1995-11-01', 'fisica-01', NULL, NULL),
('222222', 'Ozzy', 'Osbourne', '1993-11-02', 'matematica-01', NULL, NULL),
('236425', 'Cristiano', 'Orsetti', '1995-08-29', 'informatica-001', NULL, NULL),
('333333', 'Matthew', 'Bellamy', '1997-11-08', 'ing-inf001', NULL, NULL),
('444444', 'Pablo', 'Escobar', '1990-11-17', 'informatica-001', NULL, NULL),
('t01', 'iscrizione primo anno', '2017-10-31', 'imatricolazione al primo anno universitario', '156', '1', '111111'),
('t40', 'prima tassa 2018', '2017-10-31', 'tassa re-iscrizione', '156', '1', '222222'),
('t50', 'seconda rata', '2018-10-11', 'seconda rata universitaria', '89', '0', '222222'),
('t52', 'seconda rata 2018', '2018-08-22', '', '156', '0', '111111'),
('t88', 'tassa imatricolazione', '2017-10-31', '2017 prima tassa', '156', '1', '236425'),
('t90', 'seconda rata 1028', '2018-04-12', 'seconda rata', '156', '0', '236425');

-- --------------------------------------------------------

--
-- Struttura della tabella `Tassa`
--

CREATE TABLE IF NOT EXISTS `Tassa` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `datascadenza` date NOT NULL,
  `descrizione` text COLLATE utf8_bin NOT NULL,
  `costo` int(11) NOT NULL,
  `pagata` tinyint(1) NOT NULL,
  `studente_fk` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Tassa`
--

INSERT INTO `Tassa` (`id`, `Nome`, `datascadenza`, `descrizione`, `costo`, `pagata`, `studente_fk`) VALUES
('t01', 'iscrizione primo anno', '2017-10-31', 'imatricolazione al primo anno universitario', 156, 1, 111111),
('t40', 'prima tassa 2018', '2017-10-31', 'tassa re-iscrizione', 156, 1, 222222),
('t50', 'seconda rata', '2018-10-11', 'seconda rata universitaria', 89, 0, 222222),
('t52', 'seconda rata 2018', '2018-08-22', '', 156, 0, 111111),
('t88', 'tassa imatricolazione', '2017-10-31', '2017 prima tassa', 156, 1, 236425),
('t90', 'seconda rata 1028', '2018-04-12', 'seconda rata', 156, 0, 236425);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Appello`
--
ALTER TABLE `Appello`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_materia` (`fk_materia`),
  ADD KEY `data esame` (`data_esame`),
  ADD KEY `aula` (`aula`);

--
-- Indici per le tabelle `Aula`
--
ALTER TABLE `Aula`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `CorsiScelti`
--
ALTER TABLE `CorsiScelti`
  ADD PRIMARY KEY (`fk_materia`,`fk_studente`),
  ADD KEY `fk_materia` (`fk_materia`),
  ADD KEY `fk_studente` (`fk_studente`);

--
-- Indici per le tabelle `CorsoDiLaurea`
--
ALTER TABLE `CorsoDiLaurea`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `EsamiSvolti`
--
ALTER TABLE `EsamiSvolti`
  ADD PRIMARY KEY (`fk_materia`,`fk_studente`),
  ADD KEY `fk_materia` (`fk_materia`),
  ADD KEY `fk_studente` (`fk_studente`),
  ADD KEY `fk_appello` (`fk_appello`);

--
-- Indici per le tabelle `insegnamento`
--
ALTER TABLE `insegnamento`
  ADD PRIMARY KEY (`fk_materia`,`fk_professore`),
  ADD KEY `fk_prof` (`fk_professore`);

--
-- Indici per le tabelle `iscrizione`
--
ALTER TABLE `iscrizione`
  ADD PRIMARY KEY (`fk_appello`,`fk_studente`),
  ADD KEY `fk_studente` (`fk_studente`),
  ADD KEY `fk_appello` (`fk_appello`);

--
-- Indici per le tabelle `Log`
--
ALTER TABLE `Log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`fk_user`);

--
-- Indici per le tabelle `Login`
--
ALTER TABLE `Login`
  ADD PRIMARY KEY (`user`),
  ADD UNIQUE KEY `user` (`user`),
  ADD UNIQUE KEY `matricola_2` (`matricola`),
  ADD UNIQUE KEY `email_2` (`email`),
  ADD KEY `email` (`email`),
  ADD KEY `fkmatricola` (`matricola`),
  ADD KEY `matricola` (`matricola`);

--
-- Indici per le tabelle `Materia`
--
ALTER TABLE `Materia`
  ADD PRIMARY KEY (`codice`);

--
-- Indici per le tabelle `MaterieCorso`
--
ALTER TABLE `MaterieCorso`
  ADD PRIMARY KEY (`id_corso`,`id_materia`),
  ADD KEY `id_corso` (`id_corso`),
  ADD KEY `id_materia` (`id_materia`);

--
-- Indici per le tabelle `Orario`
--
ALTER TABLE `Orario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_materia` (`fk_materia`),
  ADD KEY `fk_aula` (`fk_aula`);

--
-- Indici per le tabelle `Professore`
--
ALTER TABLE `Professore`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `Questionario`
--
ALTER TABLE `Questionario`
  ADD PRIMARY KEY (`fk_materia`,`fk_studente`,`fk_pro`),
  ADD KEY `fk_studente` (`fk_studente`),
  ADD KEY `fk_materia` (`fk_materia`),
  ADD KEY `fk_pro` (`fk_pro`);

--
-- Indici per le tabelle `Studente`
--
ALTER TABLE `Studente`
  ADD PRIMARY KEY (`matricola`),
  ADD UNIQUE KEY `matricola` (`matricola`),
  ADD KEY `corso` (`corso`);

--
-- Indici per le tabelle `Tassa`
--
ALTER TABLE `Tassa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `studente_fk` (`studente_fk`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Appello`
--
ALTER TABLE `Appello`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT per la tabella `Log`
--
ALTER TABLE `Log`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT per la tabella `Orario`
--
ALTER TABLE `Orario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `CorsiScelti`
--
ALTER TABLE `CorsiScelti`
  ADD CONSTRAINT `Asceltacorso` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`),
  ADD CONSTRAINT `Asceltamatricola` FOREIGN KEY (`fk_studente`) REFERENCES `Studente` (`matricola`);

--
-- Limiti per la tabella `EsamiSvolti`
--
ALTER TABLE `EsamiSvolti`
  ADD CONSTRAINT `esamisvolti_ibfk_1` FOREIGN KEY (`fk_appello`) REFERENCES `Appello` (`id`),
  ADD CONSTRAINT `fk_materiaa` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`),
  ADD CONSTRAINT `fk_studente` FOREIGN KEY (`fk_studente`) REFERENCES `Studente` (`matricola`);

--
-- Limiti per la tabella `insegnamento`
--
ALTER TABLE `insegnamento`
  ADD CONSTRAINT `fk_materiaaa` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`),
  ADD CONSTRAINT `fk_prof` FOREIGN KEY (`fk_professore`) REFERENCES `Professore` (`id`);

--
-- Limiti per la tabella `iscrizione`
--
ALTER TABLE `iscrizione`
  ADD CONSTRAINT `iscrizione_ibfk_1` FOREIGN KEY (`fk_studente`) REFERENCES `Studente` (`matricola`),
  ADD CONSTRAINT `iscrizione_ibfk_2` FOREIGN KEY (`fk_appello`) REFERENCES `Appello` (`id`);

--
-- Limiti per la tabella `Log`
--
ALTER TABLE `Log`
  ADD CONSTRAINT `userLog` FOREIGN KEY (`fk_user`) REFERENCES `Login` (`user`);

--
-- Limiti per la tabella `Login`
--
ALTER TABLE `Login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`matricola`) REFERENCES `Studente` (`matricola`);

--
-- Limiti per la tabella `MaterieCorso`
--
ALTER TABLE `MaterieCorso`
  ADD CONSTRAINT `fk_corso` FOREIGN KEY (`id_corso`) REFERENCES `CorsoDiLaurea` (`id`),
  ADD CONSTRAINT `fk_materia` FOREIGN KEY (`id_materia`) REFERENCES `Materia` (`codice`);

--
-- Limiti per la tabella `Orario`
--
ALTER TABLE `Orario`
  ADD CONSTRAINT `orario_ibfk_1` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`),
  ADD CONSTRAINT `orario_ibfk_2` FOREIGN KEY (`fk_aula`) REFERENCES `Aula` (`id`);

--
-- Limiti per la tabella `Studente`
--
ALTER TABLE `Studente`
  ADD CONSTRAINT `inscrittoad` FOREIGN KEY (`corso`) REFERENCES `CorsoDiLaurea` (`id`);

--
-- Limiti per la tabella `Tassa`
--
ALTER TABLE `Tassa`
  ADD CONSTRAINT `fk_studenteee` FOREIGN KEY (`studente_fk`) REFERENCES `Studente` (`matricola`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
