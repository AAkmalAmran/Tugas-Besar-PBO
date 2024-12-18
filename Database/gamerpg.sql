-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2024 at 08:50 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamerpg`
--

-- --------------------------------------------------------

--
-- Table structure for table `death`
--

CREATE TABLE `death` (
  `ID_death` int(11) NOT NULL,
  `ID_NPC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `npc`
--

CREATE TABLE `npc` (
  `ID_NPC` int(11) NOT NULL,
  `Nama_NPC` varchar(300) NOT NULL,
  `HP` int(11) NOT NULL,
  `ID_Weapon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `npc`
--

INSERT INTO `npc` (`ID_NPC`, `Nama_NPC`, `HP`, `ID_Weapon`) VALUES
(1, 'Penjaga', 30, 3),
(3, 'Kepala Desa', 5, 5),
(4, 'Warga Desa A', 10, 5),
(5, 'Warga Desa B', 10, 5),
(6, 'Warga Desa C', 10, 5),
(7, 'Goblin', 25, 1),
(9, 'Dullahan', 200, 3);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `ID_Player` int(11) NOT NULL,
  `Nama_Player` varchar(300) NOT NULL,
  `HP` int(11) NOT NULL,
  `ID_Weapon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`ID_Player`, `Nama_Player`, `HP`, `ID_Weapon`) VALUES
(20, 'Akmal', 20, 2);

-- --------------------------------------------------------

--
-- Table structure for table `weapon`
--

CREATE TABLE `weapon` (
  `ID_Weapon` int(11) NOT NULL,
  `weapon_name` varchar(100) NOT NULL,
  `damage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `weapon`
--

INSERT INTO `weapon` (`ID_Weapon`, `weapon_name`, `damage`) VALUES
(1, 'Sword', 10),
(2, 'Longsword', 12),
(3, 'Hammer', 15),
(4, 'Bow', 9),
(5, 'Bare Hands', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `death`
--
ALTER TABLE `death`
  ADD PRIMARY KEY (`ID_death`),
  ADD KEY `fk_npc_death` (`ID_NPC`);

--
-- Indexes for table `npc`
--
ALTER TABLE `npc`
  ADD PRIMARY KEY (`ID_NPC`),
  ADD KEY `fk_weapon_npc` (`ID_Weapon`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`ID_Player`),
  ADD KEY `fk_weapon_player` (`ID_Weapon`);

--
-- Indexes for table `weapon`
--
ALTER TABLE `weapon`
  ADD PRIMARY KEY (`ID_Weapon`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `death`
--
ALTER TABLE `death`
  MODIFY `ID_death` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `npc`
--
ALTER TABLE `npc`
  MODIFY `ID_NPC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `ID_Player` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `weapon`
--
ALTER TABLE `weapon`
  MODIFY `ID_Weapon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `death`
--
ALTER TABLE `death`
  ADD CONSTRAINT `fk_npc_death` FOREIGN KEY (`ID_NPC`) REFERENCES `npc` (`ID_NPC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `npc`
--
ALTER TABLE `npc`
  ADD CONSTRAINT `fk_weapon_npc` FOREIGN KEY (`ID_Weapon`) REFERENCES `weapon` (`ID_Weapon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `fk_weapon_player` FOREIGN KEY (`ID_Weapon`) REFERENCES `weapon` (`ID_Weapon`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
