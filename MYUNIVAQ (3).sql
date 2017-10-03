-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Ott 03, 2017 alle 17:47
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
  `aula` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Appello`
--

INSERT INTO `Appello` (`id`, `fk_materia`, `data_esame`, `descrizione`, `aula`) VALUES
(4, 'a123', '2017-10-20', 'prova lista appelli ', 'a01'),
(100, 'aaa', '2017-07-09', '30 politico', 'a01'),
(102, 'f01', '2017-07-04', 'boccio a tutti', 'a02');

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
('a02', '0');

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
('aaa', 222222, 23, 100),
('aaa', 236425, 23, 100),
('f01', 236425, 23, 102);

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
-- Struttura della tabella `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `id` int(255) NOT NULL,
  `Descrizione` text COLLATE utf8_bin NOT NULL,
  `Data` datetime NOT NULL,
  `fk_user` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Log`
--

INSERT INTO `Log` (`id`, `Descrizione`, `Data`, `fk_user`) VALUES
(1, 'qualsiasicosa', '2017-10-03 17:03:30', 'cris'),
(2, 'Login effettuato, modificato il token', '2017-10-03 17:07:32', 'cris');

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
('cris', 'qwerty', 'cris:42d4f17d7b7f0e7', 'asd@asd.asd ', 236425),
('qwe', 'qwert', '', 'zxc@zxc.zxc', 222222);

-- --------------------------------------------------------

--
-- Struttura della tabella `Materia`
--

CREATE TABLE IF NOT EXISTS `Materia` (
  `codice` varchar(255) COLLATE utf8_bin NOT NULL,
  `nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `anno` date NOT NULL,
  `cfu` int(32) NOT NULL,
  `tipoCfu` varchar(255) COLLATE utf8_bin NOT NULL,
  `semestre` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `Materia`
--

INSERT INTO `Materia` (`codice`, `nome`, `anno`, `cfu`, `tipoCfu`, `semestre`) VALUES
('a123', 'prova123', '2017-05-08', 99, 'a12', 2),
('aaa', 'asdfghjkl', '2017-01-01', 2, 'mario', 3),
('f01', 'APP mobile', '2017-01-01', 6, 'tutti ', 2),
('fff', 'qwertyuiop', '2017-07-03', 1, 'ok', 1),
('ing-03', 'inglese ', '2017-01-01', 80, 'bo', 1);

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
-- Indici per le tabelle `Professore`
--
ALTER TABLE `Professore`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT per la tabella `Log`
--
ALTER TABLE `Log`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
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
  ADD CONSTRAINT `fk_materiaa` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`),
  ADD CONSTRAINT `fk_studente` FOREIGN KEY (`fk_studente`) REFERENCES `Studente` (`matricola`),
  ADD CONSTRAINT `qwe` FOREIGN KEY (`fk_appello`) REFERENCES `Appello` (`id`);

--
-- Limiti per la tabella `insegnamento`
--
ALTER TABLE `insegnamento`
  ADD CONSTRAINT `fk_materiaaa` FOREIGN KEY (`fk_materia`) REFERENCES `Materia` (`codice`),
  ADD CONSTRAINT `fk_prof` FOREIGN KEY (`fk_professore`) REFERENCES `Professore` (`id`);

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
