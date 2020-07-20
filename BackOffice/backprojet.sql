-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 07 Mai 2020 à 20:19
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `backprojet`
--

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `idDocument` int(11) NOT NULL,
  `nomDocument` varchar(20) DEFAULT NULL,
  `idProcedure` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDocument`),
  UNIQUE KEY `idDocument_UNIQUE` (`idDocument`),
  KEY `idProcedure_idx` (`idProcedure`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `document`
--

INSERT INTO `document` (`idDocument`, `nomDocument`, `idProcedure`) VALUES
(1, 'doc1modif', 1),
(2, 'DOC2', 2),
(4, 'doc1modif', 1),
(6, 'document4', 1),
(7, 'document4', 2);

-- --------------------------------------------------------

--
-- Structure de la table `etape`
--

CREATE TABLE IF NOT EXISTS `etape` (
  `idEtape` int(11) NOT NULL,
  `idProcedure` int(11) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEtape`),
  UNIQUE KEY `idEtape_UNIQUE` (`idEtape`),
  KEY `idProcedure_idx` (`idProcedure`),
  KEY `idPersonne_idx` (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `etape`
--

INSERT INTO `etape` (`idEtape`, `idProcedure`, `id_personne`) VALUES
(2, 2, NULL),
(3, 2, NULL),
(4, 2, NULL),
(6, 4, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` int(11) NOT NULL,
  `CIN` int(11) DEFAULT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `service` varchar(20) DEFAULT NULL,
  `role` enum('employe','chefDivision','admin') DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_personne`),
  UNIQUE KEY `id_personne` (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `CIN`, `nom`, `prenom`, `email`, `service`, `role`, `password`) VALUES
(1, 1, 'imane', 'fannane', 'imane@gmail.com', 'RH', 'chefDivision', 'NAVIRE'),
(2, 2, 'hamza', 'mejdoub', 'hamza@gmail.com', 'RH', 'chefDivision', NULL),
(3, 3, 'ajout1', 'ajout1', 'ajou1@gmail.com', 'RH', 'chefDivision', '8'),
(4, 4, 'admin', 'admin', 'admin@gmail.com', 'administration', 'admin', '123'),
(5, 5, 'hajar', 'hahah', 'hajar@gmail.com', 'RH', 'chefDivision', 'gegryu'),
(6, 3455728, 'MINA', 'BOUSSABI', 'AMINA@GMAIL.COM', 'informatique', 'employe', 'EGY'),
(14, 14, 'amina', 'mina', 'mina@gmai.com', 'RH', 'chefDivision', '1234567'),
(32, 23, '', '', 'yierf@dig.ma', 'RH', 'chefDivision', '122'),
(34, 2164, 'moo', 'naima', 'naima@gmail.com', 'administration', 'employe', ''),
(123, 212, '', '', 'UIZER@JDF.UER', 'RH', 'chefDivision', '12Z'),
(134, 34, '', '', 'URU@gm.com', 'RH', 'chefDivision', ''),
(326, 235, '', '', 'yierf@dig.ma', 'RH', 'chefDivision', ''),
(455, 34245, 'MINA', 'boo', 'amina@gmail.com', 'RH', 'employe', 'miiina'),
(1232, 2121, '', '', 'UIZER@JDF.UER', 'RH', 'chefDivision', 'z');

-- --------------------------------------------------------

--
-- Structure de la table `procedure_`
--

CREATE TABLE IF NOT EXISTS `procedure_` (
  `idProcedure` int(11) NOT NULL,
  `nomProcedure` varchar(20) DEFAULT NULL,
  `idPersonne` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProcedure`),
  UNIQUE KEY `idProcedure_UNIQUE` (`idProcedure`),
  KEY `idPersonne_idx` (`idPersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `procedure_`
--

INSERT INTO `procedure_` (`idProcedure`, `nomProcedure`, `idPersonne`) VALUES
(1, 'procedure1', 1),
(2, 'procedure2', 3),
(4, 'proc4', NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `idProcedure2` FOREIGN KEY (`idProcedure`) REFERENCES `procedure_` (`idProcedure`);

--
-- Contraintes pour la table `etape`
--
ALTER TABLE `etape`
  ADD CONSTRAINT `idPersonne` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`),
  ADD CONSTRAINT `idProcedure` FOREIGN KEY (`idProcedure`) REFERENCES `procedure_` (`idProcedure`);

--
-- Contraintes pour la table `procedure_`
--
ALTER TABLE `procedure_`
  ADD CONSTRAINT `idPersonne2` FOREIGN KEY (`idPersonne`) REFERENCES `personne` (`id_personne`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
