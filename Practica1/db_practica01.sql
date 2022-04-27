-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-02-2022 a las 00:58:16
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_practica01`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_swedish_ci DEFAULT NULL,
  `surname` varchar(45) COLLATE utf8mb4_swedish_ci DEFAULT NULL,
  `rfc` varchar(45) COLLATE utf8mb4_swedish_ci DEFAULT NULL,
  `mail` varchar(45) COLLATE utf8mb4_swedish_ci DEFAULT NULL,
  `region` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `region` (`region`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_swedish_ci;

--
-- Volcado de datos para la tabla `customer`
--

INSERT INTO `customer` (`customer_id`, `name`, `surname`, `rfc`, `mail`, `region`) VALUES
(5, 'Luis Angel', 'Rojas Espinoza', 'ROEL32VV343', 'angelrojas@gmail.com', 34),
(6, 'Itzel Azucena', 'Delgado Diaz', 'IRB33GV345', 'itzeldelgado@gmail.com', 44),
(7, 'Gabriel ', 'Orta zarco', 'GEG3435G3', 'gabriel@gmail.com', 38),
(8, 'Ricardo ', 'Moreno Sanchez', 'RIC234GF9M', 'ricardomoreno@gmail.com', 46),
(11, 'Roberto', 'Orta', '02238MMC0', 'Roberto@ciencias.unam.mx', 46),
(13, 'Susan', 'Díaz', 'Barrera', 'SN020384MML', 39),
(14, 'Alberto', 'Delgado', 'Zaragoza', '173838JFJEJ', 38),
(18, 'Marianita Lupe', 'Rodriguez Carvajal', 'FNEF214', 'mari@gmai.com', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE IF NOT EXISTS `region` (
  `region_id` int(11) NOT NULL AUTO_INCREMENT,
  `region` varchar(45) COLLATE utf8mb4_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_swedish_ci;

--
-- Volcado de datos para la tabla `region`
--

INSERT INTO `region` (`region_id`, `region`) VALUES
(31, 'Alvaro Obregon'),
(32, 'Azcapotzalco'),
(33, 'Banito Juarez'),
(34, 'Coyoacan'),
(35, 'Cuajimalpa'),
(36, 'Cuauhtemoc'),
(37, 'Gustavo A Madero'),
(38, 'Iztacalco'),
(39, 'Iztapalapa'),
(40, 'Magdalena Contreras'),
(41, 'Miguel Hidalgo'),
(42, 'Milpa Alta'),
(43, 'Tlahuac'),
(44, 'Tlalpan'),
(45, 'Venuztiano Carranza'),
(46, 'Xochimilco');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`region`) REFERENCES `region` (`region_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
