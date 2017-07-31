-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Lug 31, 2017 alle 10:38
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
('1', 'informatica', 'easy peasy'),
('2', 'ingegneria', 'for fun !');

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
('aaa', 'asdfghjkl', '2017-01-01', 2, 'mario', 3),
('f01', 'APP mobile', '2017-01-01', 6, 'tutti ', 2),
('fff', 'qwertyuiop', '2017-07-03', 1, 'ok', 1),
('ing-03', 'APP NON MOBILE', '2017-01-01', 80, 'non contano un cazzo ', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `MaterieCorso`
--

CREATE TABLE IF NOT EXISTS `MaterieCorso` (
  `id_corso` varchar(255) COLLATE utf8_bin NOT NULL,
  `id_materia` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
(10, 'PROF', 'CON UNA F', '0000-00-00'),
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
(222222, 'pinco', 'pallino', '1995-10-10', '2'),
(236425, 'Cristiano', 'Orsetti', '1995-08-29', '1');

-- --------------------------------------------------------

--
-- Struttura della tabella `Tassa`
--

CREATE TABLE IF NOT EXISTS `Tassa` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `data scadenza` date NOT NULL,
  `descrizione` text COLLATE utf8_bin NOT NULL,
  `costo` int(11) NOT NULL,
  `pagata` tinyint(1) NOT NULL,
  `studente_fk` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
