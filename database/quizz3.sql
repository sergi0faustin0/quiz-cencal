-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 13-Out-2019 às 22:44
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.2.11

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
(26, 'blanka', 'white', 1),
(30, 'blua', 'blue', 1),
(28, 'bruna', 'brown', 1),
(33, 'flava', 'yellow', 1),
(34, 'griza', 'grey', 1),
(27, 'nigra', 'black', 1),
(35, 'oranĝkolora', 'orange', 1),
(36, 'purpura', 'purple', 1),
(32, 'rozkolora', 'pink', 1),
(31, 'ruĝa', 'red', 1),
(29, 'verda', 'green', 1),
(21, 'abelo', 'bee', 2),
(12, 'aglo', 'eagle', 2),
(163, 'anaso', 'duck', 2),
(164, 'ansero', 'goose', 2),
(202, 'apro', 'boar', 2),
(170, 'araneo', 'spider', 2),
(190, 'azeno', 'donkey', 2),
(22, 'baleno', 'whale', 2),
(8, 'birdo', 'bird', 2),
(6, 'bovino', 'cow', 2),
(196, 'bufo', 'toad', 2),
(181, 'cervo', 'deer', 2),
(9, 'ĉevalo', 'horse', 2),
(186, 'delfeno', 'dolphin', 2),
(13, 'elefanto', 'elephant', 2),
(180, 'erinaco', 'hedgehog', 2),
(25, 'fiŝo', 'fish', 2),
(169, 'foko', 'seal', 2),
(20, 'formiko', 'ant', 2),
(15, 'ĝirafo', 'giraffe', 2),
(204, 'heliko', 'snail', 2),
(193, 'hieno', 'hyena', 2),
(179, 'hipopotamo', 'hippopotamus', 2),
(3, 'hundo', 'dog', 2),
(197, 'insekto', 'insect', 2),
(194, 'kanguruo', 'kangaroo', 2),
(189, 'kapro', 'goat', 2),
(199, 'kastoro', 'beaver', 2),
(4, 'kato', 'cat', 2),
(177, 'koalo', 'koala', 2),
(201, 'kokcinelo', 'ladybug', 2),
(191, 'koko', 'chicken', 2),
(198, 'krabo', 'crab', 2),
(24, 'krokodilo', 'crocodile', 2),
(10, 'kuniklo', 'rabbit', 2),
(172, 'lavurso', 'raccoon', 2),
(11, 'leono', 'lion', 2),
(185, 'leopardo', 'leopard', 2),
(167, 'lupo', 'wolf', 2),
(176, 'lutro', 'otter', 2),
(188, 'meleagro', 'turkey', 2),
(5, 'musho', 'fly', 2),
(165, 'muso', 'mouse', 2),
(174, 'pando', 'panda', 2),
(19, 'papilio', 'butterfly', 2),
(187, 'polpo', 'octopus', 2),
(16, 'porko', 'pig', 2),
(195, 'rano', 'frog', 2),
(183, 'rinocero', 'rhinoceros', 2),
(175, 'rosmaro', 'walrus', 2),
(171, 'sciuro', 'squirrel', 2),
(168, 'serpento', 'snake', 2),
(14, 'simio', 'monkey', 2),
(200, 'strigo', 'owl', 2),
(17, 'ŝafo', 'sheep', 2),
(23, 'ŝarko', 'shark', 2),
(178, 'talpo', 'mole', 2),
(173, 'taŭro', 'bull', 2),
(18, 'testudo', 'turtle', 2),
(184, 'tigro', 'tiger', 2),
(166, 'urso', 'bear', 2),
(182, 'vesperto', 'bat', 2),
(7, 'vulpo', 'fox', 2),
(203, 'vulturo', 'vulture', 2),
(192, 'zebro', 'zebra', 2),
(92, 'akselo', 'armpit', 3),
(77, 'barbo', 'beard', 3),
(37, 'brako', 'arm', 3),
(65, 'brovo', 'eyebrow', 3),
(54, 'brusto', 'chest', 3),
(69, 'buŝo', 'mouth', 3),
(75, 'dento', 'tooth', 3),
(52, 'dorso', 'back', 3),
(83, 'fingro', 'finger', 3),
(66, 'frunto', 'forehead', 3),
(60, 'genuo', 'knee', 3),
(56, 'haro', 'hair', 3),
(86, 'ingveno', 'groin', 3),
(91, 'kalkano', 'heel', 3),
(58, 'kapo', 'head', 3),
(59, 'kokso', 'hip', 3),
(63, 'kolo', 'neck', 3),
(61, 'kruro', 'leg', 3),
(82, 'kubuto', 'elbow', 3),
(74, 'lango', 'tongue', 3),
(76, 'lipharo', 'moustache', 3),
(70, 'lipo', 'lip', 3),
(90, 'maleolo', 'ankle', 3),
(81, 'mamoj', 'breast', 3),
(57, 'mano', 'hand', 3),
(80, 'manradiko', 'wrist', 3),
(72, 'mentono', 'chin', 3),
(68, 'nazo', 'nose', 3),
(96, 'naztruo', 'nostril', 3),
(95, 'nuko', 'nape', 3),
(78, 'okulharo', 'eyelash', 3),
(67, 'okulo', 'eye', 3),
(73, 'orelo', 'ear', 3),
(85, 'peniso', 'penis', 3),
(87, 'piedfingro', 'toe', 3),
(55, 'piedo', 'foot', 3),
(88, 'postaĵo', 'bottom', 3),
(94, 'sidvango', 'buttock', 3),
(93, 'suro', 'calf', 3),
(64, 'ŝultro', 'shoulder', 3),
(89, 'talio', 'waist', 3),
(62, 'ungo', 'nail', 3),
(71, 'vango', 'cheek', 3),
(53, 'ventro', 'belly', 3),
(79, 'vizaĝo', 'face', 3),
(84, 'vulvo', 'vulva', 3),
(152, 'abrikoto', 'apricot', 4),
(142, 'akvomelono', 'watermelon', 4),
(156, 'anakardio', 'cashew', 4),
(131, 'ananaso', 'pineapple', 4),
(155, 'arakido', 'peanut', 4),
(150, 'avokado', 'avocado', 4),
(132, 'banano', 'banana', 4),
(138, 'citrono', 'lemon', 4),
(134, 'ĉerizo', 'cherry', 4),
(151, 'figo', 'fig', 4),
(133, 'frago', 'strawberry', 4),
(146, 'frambo', 'raspberry', 4),
(158, 'granato', 'pomegranate', 4),
(154, 'juglando', 'walnut', 4),
(141, 'kivo', 'kiwi', 4),
(144, 'kokoso', 'coconut', 4),
(160, 'liĉio', 'litchi', 4),
(145, 'mandarino', 'tangerine', 4),
(157, 'mango', 'mango', 4),
(161, 'melono', 'melon', 4),
(159, 'mespilo', 'medlar', 4),
(153, 'migdalo', 'almond', 4),
(148, 'mirtelo', 'blueberry', 4),
(139, 'oranĝo', 'orange', 4),
(143, 'pampelmuso', 'grapefruit', 4),
(136, 'persiko', 'peach', 4),
(135, 'piro', 'pear', 4),
(130, 'Pomo', 'Apple', 4),
(140, 'pruno', 'plum', 4),
(162, 'retmelono', 'cantaloupe', 4),
(149, 'ribo', 'currant', 4),
(147, 'rubusbero', 'blackberry', 4),
(137, 'vinbero', 'grape', 4);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `dici`
--
ALTER TABLE `dici`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UniqueThreeKey` (`categoryId`,`esperanto`,`ingles`),
  ADD KEY `category` (`categoryId`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `dici`
--
ALTER TABLE `dici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

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
