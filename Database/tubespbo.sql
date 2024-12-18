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
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `monster`
--

CREATE TABLE `monster` (
  `id_monster` int(11) NOT NULL,
  `nama_monster` varchar(255) NOT NULL,
  `id_weapon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `monster`
--

INSERT INTO `monster` (`id_monster`, `nama_monster`, `id_weapon`) VALUES
(1, 'Babi Hutan', 4),
(2, 'Skeleton', 5),
(3, 'Goblin', 3),
(4, 'Ogre', 4),
(5, 'Dullahan', 4),
(6, 'Demon King', 6);

-- --------------------------------------------------------

--
-- Table structure for table `npc`
--

CREATE TABLE `npc` (
  `id_npc` int(11) NOT NULL,
  `nama_npc` varchar(255) DEFAULT NULL,
  `id_weapon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `npc`
--

INSERT INTO `npc` (`id_npc`, `nama_npc`, `id_weapon`) VALUES
(1, 'Penjaga', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `id_player` int(11) NOT NULL,
  `nama_player` varchar(255) NOT NULL,
  `id_weapon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id_player`, `nama_player`, `id_weapon`) VALUES
(4, 'Dora', 1),
(8, 'Link', NULL),
(12, 'Akmal', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `weapon`
--

CREATE TABLE `weapon` (
  `id_weapon` int(11) NOT NULL,
  `nama_weapon` varchar(100) NOT NULL,
  `Damage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `weapon`
--

INSERT INTO `weapon` (`id_weapon`, `nama_weapon`, `Damage`) VALUES
(1, 'Bare Hands', 1),
(2, 'Knife', 3),
(3, 'Long Sword', 12),
(4, 'War Hammer', 8),
(5, 'Spear', 6),
(6, 'Hero Sword', 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monster`
--
ALTER TABLE `monster`
  ADD PRIMARY KEY (`id_monster`),
  ADD KEY `fk_weapon_monster` (`id_weapon`);

--
-- Indexes for table `npc`
--
ALTER TABLE `npc`
  ADD PRIMARY KEY (`id_npc`),
  ADD KEY `fk_weapon_npc` (`id_weapon`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id_player`),
  ADD KEY `fk_weapon_player` (`id_weapon`);

--
-- Indexes for table `weapon`
--
ALTER TABLE `weapon`
  ADD PRIMARY KEY (`id_weapon`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `monster`
--
ALTER TABLE `monster`
  MODIFY `id_monster` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `npc`
--
ALTER TABLE `npc`
  MODIFY `id_npc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `id_player` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `weapon`
--
ALTER TABLE `weapon`
  MODIFY `id_weapon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `monster`
--
ALTER TABLE `monster`
  ADD CONSTRAINT `fk_weapon_monster` FOREIGN KEY (`id_weapon`) REFERENCES `weapon` (`id_weapon`);

--
-- Constraints for table `npc`
--
ALTER TABLE `npc`
  ADD CONSTRAINT `fk_weapon_npc` FOREIGN KEY (`id_weapon`) REFERENCES `weapon` (`id_weapon`);

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `fk_weapon_player` FOREIGN KEY (`id_weapon`) REFERENCES `weapon` (`id_weapon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
