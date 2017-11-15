-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Nov 15, 2017 alle 12:08
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Appello`
--

INSERT INTO `Appello` (`id`, `fk_materia`, `data_esame`, `descrizione`, `aula`, `oraInizio`, `oraFine`) VALUES
(1, 'ing-03', '2018-01-05', 'test', 'a01', '09:00:00', '13:00:00'),
(2, 'fff', '2018-01-12', 'test', 'a02', '10:00:00', '14:00:00');

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
('a01', '0'),
('a02', '0'),
('aula12', 'z9'),
('baracca', 'c1');

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
('a123', 236425),
('ing-03', 236425);

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
('1', 'informatica', 'java ,javaEE, javascript ecc...'),
('2', 'ingegneria', 'cose da ingegneri ');

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
('a123', 236425, 11, 1);

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
('aaa', 10),
('ing-03', 10),
('f01', 11),
('fff', 12),
('ing-03', 12),
('ing-03', 13);

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
(236425, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `id` int(255) NOT NULL,
  `Descrizione` text COLLATE utf8_bin NOT NULL,
  `Data` datetime NOT NULL,
  `fk_user` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Log`
--

INSERT INTO `Log` (`id`, `Descrizione`, `Data`, `fk_user`) VALUES
(1, 'qualsiasicosa', '2017-10-03 17:03:30', 'cris'),
(2, 'Login effettuato, modificato il token', '2017-10-03 17:07:32', 'cris'),
(3, 'Login effettuato, modificato il token', '2017-10-06 13:31:37', 'cris'),
(4, 'Login effettuato, modificato il token', '2017-10-06 13:31:42', 'cris'),
(5, 'Login effettuato, modificato il token', '2017-10-06 13:33:06', 'cris'),
(6, 'Login effettuato, modificato il token', '2017-10-06 13:49:29', 'cris'),
(7, 'Login effettuato, modificato il token', '2017-10-06 13:50:21', 'cris'),
(8, 'Login effettuato, modificato il token', '2017-10-06 13:50:49', 'cris'),
(9, 'Login effettuato, modificato il token', '2017-10-09 16:15:57', 'cris'),
(10, 'Login effettuato, modificato il token', '2017-10-09 17:36:03', 'cris'),
(11, 'Login effettuato, modificato il token', '2017-10-09 20:20:13', 'cris'),
(12, 'Login effettuato, modificato il token', '2017-10-10 11:33:36', 'cris'),
(13, 'Login effettuato, modificato il token', '2017-10-10 17:12:54', 'cris'),
(14, 'Login effettuato, modificato il token', '2017-10-18 16:30:19', 'cris'),
(15, 'logout effettuato', '2017-10-18 17:07:20', 'cris'),
(16, 'logout effettuato', '2017-10-18 17:11:01', 'cris'),
(17, 'Login effettuato, modificato il token', '2017-10-18 17:11:19', 'cris'),
(18, 'logout effettuato', '2017-10-18 17:12:26', 'cris'),
(19, 'logout effettuato', '2017-10-18 17:14:18', 'cris'),
(20, 'logout effettuato', '2017-10-18 17:14:40', 'cris'),
(21, 'Login effettuato, modificato il token', '2017-10-18 17:19:56', 'cris'),
(22, 'Login effettuato, modificato il token', '2017-11-01 11:23:04', 'cris'),
(23, 'Login effettuato, modificato il token', '2017-11-01 11:25:35', 'cris'),
(24, 'Login effettuato, modificato il token', '2017-11-01 12:00:39', 'cris'),
(25, 'Login effettuato, modificato il token', '2017-11-01 12:04:54', 'cris'),
(26, 'Login effettuato, modificato il token', '2017-11-01 17:57:53', 'cris'),
(27, 'Login effettuato, modificato il token', '2017-11-01 18:00:48', 'cris'),
(28, 'Login effettuato, modificato il token', '2017-11-01 18:50:20', 'cris');

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
('cris', 'qwerty', 'cris:158f3481ce9d74cd', 'asd@asd.asd ', 236425);

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
('a123', 'prova123', 20170508, 99, 'a12', 2),
('aaa', 'asdfghjkl', 20170101, 2, 'mario', 3),
('f01', 'APP mobile', 20170101, 6, 'tutti ', 2),
('fff', 'qwertyuiop', 20170703, 1, 'ok', 1),
('ing-03', 'inglese ', 1, 80, 'bo', 1);

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
('1', 'aaa'),
('1', 'f01'),
('1', 'fff'),
('2', 'fff'),
('2', 'ing-03');

-- --------------------------------------------------------

--
-- Struttura della tabella `Orario`
--

CREATE TABLE IF NOT EXISTS `Orario` (
  `id` int(255) NOT NULL,
  `fk_materia` varchar(255) COLLATE utf8_bin NOT NULL,
  `fk_aula` varchar(255) COLLATE utf8_bin NOT NULL,
  `giorno` varchar(255) COLLATE utf8_bin NOT NULL,
  `oraInizio` varchar(255) COLLATE utf8_bin NOT NULL,
  `oraFine` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Orario`
--

INSERT INTO `Orario` (`id`, `fk_materia`, `fk_aula`, `giorno`, `oraInizio`, `oraFine`) VALUES
(1, 'a123', 'a01', 'lunedì', '08:00:00', '09:00:00'),
(2, 'a123', 'a02', 'martedì', '09:00:00', '10:00:00'),
(3, 'f01', 'baracca', 'lunedì', '11:00:00', '13:00:00'),
(4, 'a123', 'baracca', 'lunedì', '8:00:00', '18:00:00');

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
(10, 'PROF abc', 'zvu', '2017-09-01'),
(11, 'PROFF', 'CON DUE F', '0000-00-00'),
(12, 'Prof ', 'con una f', '1980-02-02'),
(13, 'proff', 'con due f', '1980-03-03');

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
('MYUNIVAQ3questionari1234_aaa_11.json', 1234, 'aaa', 11),
('MYUNIVAQ3questionari236422_aaa_11.json', 236422, 'aaa', 11),
('qwe', 236422, 'qwert', 123);

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
(111111, 'prova1', 'prova1', '2017-10-03', '2'),
(222222, 'pinco', 'pallino', '1995-10-10', '2'),
(236425, 'Cristiano', 'Orsetti', '1995-08-29', '1');

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
('1', 'paga', '2017-09-09', 'paga o mandiamo i sicari a casa', 9999, 0, 236425),
('2', 'i sicari sono sotto casa', '2017-09-07', 'dacci i soldi ', 1, 1, 222222),
('4', 'prova', '2017-09-08', 'ops', 2, 1, 236425);

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
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `Log`
--
ALTER TABLE `Log`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT per la tabella `Orario`
--
ALTER TABLE `Orario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Appello`
--
ALTER TABLE `Appello`
  ADD CONSTRAINT `fk_aula` FOREIGN KEY (`aula`) REFERENCES `Aula` (`id`),
  ADD CONSTRAINT `fk_materiaaaa` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`);

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
