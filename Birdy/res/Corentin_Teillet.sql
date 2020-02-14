-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 14 Février 2020 à 17:43
-- Version du serveur :  5.7.22
-- Version de PHP :  7.0.33-0+deb9u6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `Corentin_Teillet`
--

-- --------------------------------------------------------

--
-- Structure de la table `EnLigne`
--

CREATE TABLE `EnLigne` (
  `Id` varchar(15) NOT NULL,
  `Cle` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Friend`
--

CREATE TABLE `Friend` (
  `Utilisateur1` varchar(25) NOT NULL,
  `Utilisateur2` varchar(25) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Friend`
--

INSERT INTO `Friend` (`Utilisateur1`, `Utilisateur2`, `Date`) VALUES
('nono', 'pp', '2020-02-13 13:12:21');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `Nom` varchar(25) DEFAULT NULL,
  `Prenom` varchar(25) DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `Mail` varchar(30) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Identifiant` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`Nom`, `Prenom`, `DateNaissance`, `Mail`, `Password`, `Identifiant`) VALUES
(NULL, NULL, NULL, 'azertyu@sdfgh.fr', 'bonjour', 'Co'),
('Teillet', 'Corentin', NULL, 'teillet.corentin@neuf.fr', 'coco', 'nono'),
('Co', NULL, NULL, 'azertyuio', 'bonjour', 'Nono9196'),
('Jean', 'Pierre', NULL, 'jean.pierre@gmail.com', 'jj', 'pp');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `EnLigne`
--
ALTER TABLE `EnLigne`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `Friend`
--
ALTER TABLE `Friend`
  ADD PRIMARY KEY (`Utilisateur1`,`Utilisateur2`),
  ADD KEY `FK_Utilisateur2` (`Utilisateur2`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`Identifiant`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `EnLigne`
--
ALTER TABLE `EnLigne`
  ADD CONSTRAINT `FK_ID` FOREIGN KEY (`Id`) REFERENCES `Utilisateur` (`Identifiant`);

--
-- Contraintes pour la table `Friend`
--
ALTER TABLE `Friend`
  ADD CONSTRAINT `FK_Utilisateur1` FOREIGN KEY (`Utilisateur1`) REFERENCES `Utilisateur` (`Identifiant`),
  ADD CONSTRAINT `FK_Utilisateur2` FOREIGN KEY (`Utilisateur2`) REFERENCES `Utilisateur` (`Identifiant`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
