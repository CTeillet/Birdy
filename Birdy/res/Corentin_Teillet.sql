-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 17 mai 2020 à 20:52
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
	
--
-- Base de données :  `corentin_teillet`
--

-- --------------------------------------------------------

--
-- Structure de la table `enligne`
--

DROP TABLE IF EXISTS `enligne`;
CREATE TABLE IF NOT EXISTS `enligne` (
  `Id` varchar(15) NOT NULL,
  `Cle` varchar(32) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `friend`
--

DROP TABLE IF EXISTS `friend`;
CREATE TABLE IF NOT EXISTS `friend` (
  `Utilisateur1` varchar(25) NOT NULL,
  `Utilisateur2` varchar(25) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Utilisateur1`,`Utilisateur2`),
  KEY `UTILISATEUR2_FK` (`Utilisateur2`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `Nom` varchar(25) DEFAULT NULL,
  `Prenom` varchar(25) DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `Mail` varchar(30) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Identifiant` varchar(15) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enligne`
--
ALTER TABLE `enligne`
  ADD CONSTRAINT `FK_ID` FOREIGN KEY (`Id`) REFERENCES `utilisateur` (`Identifiant`);

--
-- Contraintes pour la table `friend`
--
ALTER TABLE `friend`
  ADD CONSTRAINT `UTILISATEUR1_FK` FOREIGN KEY (`Utilisateur1`) REFERENCES `utilisateur` (`Identifiant`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `UTILISATEUR2_FK` FOREIGN KEY (`Utilisateur2`) REFERENCES `utilisateur` (`Identifiant`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
