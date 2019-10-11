-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 11-Out-2019 às 08:59
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `quizz`
--
CREATE DATABASE IF NOT EXISTS `quizz` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `quizz`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cat`
--

CREATE TABLE `cat` (
  `id` int(11) NOT NULL,
  `category` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cat`
--

INSERT INTO `cat` (`id`, `category`) VALUES
(1, 'Colors'),
(2, 'Animals'),
(3, 'bodyParts');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dici`
--

CREATE TABLE `dici` (
  `id` int(11) NOT NULL,
  `esperanto` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL,
  `ingles` varchar(255) NOT NULL,
  `categoryId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `dici`
--

INSERT INTO `dici` (`id`, `esperanto`, `ingles`, `categoryId`) VALUES
(3, 'hundo', 'dog', 2),
(4, 'kato', 'cat', 2),
(5, 'muŝo', 'fly', 2),
(6, 'bovino', 'cow', 2),
(7, 'vulpo', 'fox', 2),
(8, 'birdo', 'bird', 2),
(9, 'ĉevalo', 'horse', 2),
(10, 'kuniklo', 'rabbit', 2),
(11, 'leono', 'lion', 2),
(12, 'aglo', 'eagle', 2),
(13, 'elefanto', 'elephant', 2),
(14, 'simio', 'monkey', 2),
(15, 'ĝirafo', 'giraffe', 2),
(16, 'porko', 'pig', 2),
(17, 'ŝafo', 'sheep', 2),
(18, 'testudo', 'turtle', 2),
(19, 'papilio', 'butterfly', 2),
(20, 'formiko', 'ant', 2),
(21, 'abelo', 'bee', 2),
(22, 'baleno', 'whale', 2),
(23, 'ŝarko', 'shark', 2),
(24, 'krokodilo', 'crocodile', 2),
(25, 'fiŝo', 'fish', 2),
(26, 'blanka', 'white', 1),
(27, 'nigra', 'black', 1),
(28, 'bruna', 'brown', 1),
(29, 'verda', 'green', 1),
(30, 'blua', 'blue', 1),
(31, 'ruĝa', 'red', 1),
(32, 'rozkolora', 'pink', 1),
(33, 'flava', 'yellow', 1),
(34, 'griza', 'grey', 1),
(35, 'oranĝkolora', 'orange', 1),
(36, 'purpura', 'purple', 1),
(37, 'brako', 'arm', 3),
(52, 'dorso', 'back', 3),
(53, 'ventro', 'belly', 3),
(54, 'brusto', 'chest', 3),
(55, 'piedo', 'foot', 3),
(56, 'haro', 'hair', 3),
(57, 'mano', 'hand', 3),
(58, 'kapo', 'head', 3),
(59, 'kokso', 'hip', 3),
(60, 'genuo', 'knee', 3),
(61, 'kruro', 'leg', 3),
(62, 'ungo', 'nail', 3),
(63, 'kolo', 'neck', 3),
(64, 'ŝultro', 'shoulder', 3),
(65, 'brovo', 'eyebrow', 3),
(66, 'frunto', 'forehead', 3),
(67, 'okulo', 'eye', 3),
(68, 'nazo', 'nose', 3),
(69, 'buŝo', 'mouth', 3),
(70, 'lipo', 'lip', 3),
(71, 'vango', 'cheek', 3),
(72, 'mentono', 'chin', 3),
(73, 'orelo', 'ear', 3),
(74, 'lango', 'tongue', 3),
(75, 'dento', 'tooth', 3),
(76, 'lipharo', 'moustache', 3),
(77, 'barbo', 'beard', 3),
(78, 'okulharo', 'eyelash', 3),
(79, 'vizaĝo', 'face', 3),
(80, 'manradiko', 'wrist', 3),
(81, 'mamoj', 'breast', 3),
(82, 'kubuto', 'elbow', 3),
(83, 'fingro', 'finger', 3),
(84, 'vulvo', 'vulva', 3),
(85, 'peniso', 'penis', 3),
(86, 'ingveno', 'groin', 3),
(87, 'piedfingro', 'toe', 3),
(88, 'postaĵo', 'bottom', 3),
(89, 'talio', 'waist', 3),
(90, 'maleolo', 'ankle', 3),
(91, 'kalkano', 'heel', 3),
(92, 'akselo', 'armpit', 3),
(93, 'suro', 'calf', 3),
(94, 'sidvango', 'buttock', 3),
(95, 'nuko', 'nape', 3),
(96, 'naztruo', 'nostril', 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cat`
--
ALTER TABLE `cat`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `dici`
--
ALTER TABLE `dici`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `english` (`ingles`),
  ADD UNIQUE KEY `esperanto` (`esperanto`),
  ADD KEY `category` (`categoryId`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cat`
--
ALTER TABLE `cat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `dici`
--
ALTER TABLE `dici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `dici`
--
ALTER TABLE `dici`
  ADD CONSTRAINT `category` FOREIGN KEY (`categoryId`) REFERENCES `cat` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
