-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2022 a las 09:47:34
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hermandades`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hermandades`
--

CREATE TABLE `hermandades` (
  `codigo` int(2) NOT NULL,
  `nombre` varchar(400) NOT NULL,
  `vulgo` varchar(50) NOT NULL,
  `casahermandad` varchar(100) NOT NULL,
  `hermanomayor` varchar(9) NOT NULL,
  `cuotahermano` int(2) NOT NULL,
  `fundacion` int(4) NOT NULL,
  `diaprocesion` varchar(50) NOT NULL,
  `sedecanonica` int(2) NOT NULL,
  `barrio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hermandades`
--

INSERT INTO `hermandades` (`codigo`, `nombre`, `vulgo`, `casahermandad`, `hermanomayor`, `cuotahermano`, `fundacion`, `diaprocesion`, `sedecanonica`, `barrio`) VALUES
(1, 'Real y Excma. Hdad. de Ntro. Padres Jesús del Santo Suplicio, Stmo. Cristo de los Milagros y María Stma. de la Amargura Coronada', 'Zamarrilla', 'Calle Marmoles', '11111111A', 12, 1922, 'Jueves Santo', 2, 'Trinidad'),
(2, 'Excelentísima, Muy Ilustre y Venerable Hermandad y Cofradía de Nazarenos de Nuestro Padre Jesús de la Columna y María Santísima de la O', 'Gitanos', 'Calle Frailes', '22222222B', 11, 1939, 'Lunes Santo', 3, 'Centro'),
(3, 'Real, Muy Ilustre y Venerable Archicofradía de Nazarenos del Santísimo Sacramento, Nuestro Padre Jesús de la Pasión y María Santísima del Amor Doloroso', 'Pasion', 'Calle Convalecientes', '33333333C', 10, 1934, 'Lunes Santo', 3, 'Centro'),
(4, 'Real Ilustre y Venerable Cofradía de Nuestro Padre Jesús de la Misericordia, Santo Cristo de Animas, Nuestra Señora del Gran Poder y San Juan de Dios', 'Chiquito', 'Calle La Serna', '44444444D', 15, 1940, 'Jueves Santo', 4, 'Perchel'),
(5, 'Hermandad del Santo Cristo Coronado de Espinas y Nuestra Senora de Gracia y Esperanza', 'Estudiantes', 'Calle Alcazabilla', '55555555E', 20, 1943, 'Lunes Santo', 5, 'Centro'),
(6, 'Real, Piadosa y Venerable Hermandad de Culto y Procesión de Nuestro Padre Jesús del Rescate y María Santísima de Gracia', 'Rescate', 'Calle Aguas', '66666666F', 13, 1949, 'Martes Santo', 6, 'Victoria'),
(7, 'Real Cofradía de Nuestro Padre Jesús a su Entrada en Jerusalén y María Santísima del Amparo', 'Pollinica', 'Calle Parras', '77777777G', 9, 1911, 'Domingo de Ramos', 7, 'Capuchinos'),
(8, 'Fervorosa y Muy Ilustre Hermandad de Nuestro Padre Jesús del Prendimiento y María Santísima del Gran Perdón', 'Prendimiento', 'Calle San Millan', '88888888H', 10, 1948, 'Domingo de Ramos', 8, 'Capuchinos'),
(9, 'Real Cofradía del Stmo. Cristo del Amor y Ntra. Senora de la Caridad', 'Amor y Caridad', 'Calle Fernando el Catolico', '99999999I', 10, 1923, 'Viernes Santo', 9, 'Victoria'),
(10, 'Real Hermandad de Nuestra Senora de la Piedad', 'Piedad', 'Plaza del Molinillo', '00000000J', 12, 1929, 'Viernes Santo', 10, 'Molinillo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hermanos`
--

CREATE TABLE `hermanos` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `antiguedad` int(4) NOT NULL,
  `hermandad` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hermanos`
--

INSERT INTO `hermanos` (`dni`, `nombre`, `apellidos`, `direccion`, `antiguedad`, `hermandad`) VALUES
('00000000J', 'Francisco de Asís', 'Ibánez Carrión', 'JOAN MIRÓ , 10', 1970, 10),
('00000000K', 'Cristina', 'ALINS GONZÁLEZ', 'ART?S , 1, 1R, 1A.', 2015, 6),
('00000000U', 'Gema', 'PORTELLA GISPETS', 'JAUME GALOBART , 11', 2013, 1),
('11111111A', 'Salvador', 'Valderrama', 'PADRÓ , 109', 1975, 1),
('11111111B', 'Jorge', 'BELMONTE SÁNCHEZ', 'JAUME GALOBART , 12', 1936, 10),
('11111111L', 'Carlos', 'ACUA TORT', 'GENERAL PRIM , 11, 2N.', 2015, 9),
('22222222B', 'Eloy', 'Losada', 'CASA CORDELLAS , ', 1984, 2),
('22222222C', 'Marcos', 'BAJONA GARCIA', 'PINTOR SERT , 12, 1R., 1A.', 1965, 2),
('22222222M', 'David', 'ALGUÉ TRANCHO', 'CAU DE LA GUINEU , 4', 2009, 10),
('33333333C', 'Antonio Miguel', 'Sanchez Herrera', 'DOCTOR FLEMING , 11', 1999, 3),
('33333333D', 'Juana', 'AGUILAR RODRIGUEZ', 'BELLAVISTA , 30', 1920, 6),
('33333333N', 'Cristian', 'BADIA CASTILLO', 'JOAN SANMARTÍ , 12, 2N., 2A.', 2005, 3),
('44444444D', 'Agustín', 'Soler', 'BERTRAND I SERRA , 11, 3R.', 2000, 4),
('44444444E', 'María José', 'BARRIGA SOTO', 'MONTURIOL , 10, 1R.', 1920, 1),
('44444444O', 'Julio Alberto', 'BENITEZ FLORES', 'PROL. PADRÓ , 1, 3R. 1A.', 2018, 5),
('55555555E', 'Jorge', 'Alcántara', 'CARRIÓ , 12, 5? A', 2001, 5),
('55555555F', 'Raquel', 'AVILA MASJUAN', 'JACINT VERDAGUER , 52, 2N., 4A.', 1999, 4),
('55555555P', 'Sergio', 'TORRUELLA GARCIA', 'SALLENT , 22, 2N.', 2019, 2),
('66666666F', 'Joaquín', 'González', 'PIRINEUS , 10', 2003, 6),
('66666666G', 'Enrique', 'PARRAMON FLORES', 'CASA NOVA , ', 2000, 3),
('66666666Q', 'Alexis', 'ALBERICH RODRIGUEZ', 'JOAN MIRÓ , 3', 2019, 7),
('77777777G', 'Juan José', 'Granados Jiménez', 'JACINT VERDAGUER , 43', 2014, 7),
('77777777H', 'Marta', 'AGUILAR RAMOS', 'DE LA CA?A , 12, 1R., C', 2015, 7),
('77777777R', 'Verónica', 'ARMENCOT PUIG', 'LLUÍS CASTELLS , 12, 2N.', 2018, 4),
('88888888H', 'Salvador', 'Pozo Sánchez', 'NOU , 9, 2N.', 2015, 8),
('88888888I', 'Carlota', 'AYALA ALSINA', 'PINTOR SERT , 12, 2N., 1A.', 2015, 4),
('88888888S', 'María', 'ALIGUÉ RIVERA', 'SANT VALENTÍ , 12, 1R.', 2000, 5),
('99999999I', 'Álvaro', 'Guardiola Guerrero-Strachan', 'JACINT VERDAGUER , 52, 3R, 1A.', 2015, 9),
('99999999J', 'María Noelia', 'ALVAREZ TROYANO', 'CASA SARA , ', 2000, 4),
('99999999T', 'Marcos', 'BARRIGA RIU', '?NGEL GUIMER? , 43, 2N', 2017, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sedescanonicas`
--

CREATE TABLE `sedescanonicas` (
  `codigo` int(2) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `parroco` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sedescanonicas`
--

INSERT INTO `sedescanonicas` (`codigo`, `nombre`, `direccion`, `parroco`) VALUES
(1, 'Iglesia de San Felipe Neri', 'Calle Gaona', 'Alejandro Pérez Verdugo'),
(2, 'Ermita de Zamarrilla', 'Calle Marmoles', 'Salvador Gil Cantos'),
(3, 'Iglesia de los Santos Martires', 'Plaza de los Martires', 'Felipe Reina Hurtado'),
(4, 'Iglesia del Carmen', 'Calle La Serna', 'José Manuel Caselles'),
(5, 'Iglesia del Santo Cristo', 'Calle Compañía', '-'),
(6, 'Parroquia de San Lázaro', 'Plaza de la Victoria', 'Alejandro Escobar Morcillo'),
(7, 'Iglesia de San Agustín', 'Calle San Agustin', 'Justo Ramiro Díaz Villarreal'),
(8, 'Parroquia de la Divina Pastora', 'Plaza de Capuchinos', 'Francisco del Pozo Ávila'),
(9, 'Santuario de la Victoria', 'Plaza del Santuario', 'Alejandro Escobar Morcillo'),
(10, 'Parroquia Virgen Milagrosa y San Dámaso Papa', 'Calle Almona', 'Don Manuel Ramos Carrasco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titulares`
--

CREATE TABLE `titulares` (
  `codigo` int(2) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `antiguedad` varchar(50) NOT NULL,
  `hermandad` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `titulares`
--

INSERT INTO `titulares` (`codigo`, `nombre`, `autor`, `antiguedad`, `hermandad`) VALUES
(1, 'Nuestro Padre Jesús de la Columna', 'Juan Vargas Cortés ', '1942', 2),
(2, 'María Santísima de la O', 'Francisco Buiza', '1970', 2),
(3, 'Ntro. Padre Jesús del Santo Suplicio', 'Francisco Palma Burgos', '1985', 1),
(4, 'María Santísima de la Amargura Coronada', 'Antonio Gutierrez de Leon', 'Siglo XVIII', 1),
(5, 'Stmo. Cristo de los Milagros', 'Francisco Palma Burgos', '1939', 1),
(6, 'Ntro. Padre Jesús de la Pasión', 'Ortega Bru', '1976', 3),
(7, 'María Santísima del Amor Doloroso', 'Antonio Asensio de la Cerda', '1771', 3),
(8, 'Nuestro Padre Jesús de la Misericordia', 'Jose Navas Parejo', '1944', 4),
(9, 'Nuestra Senora del Gran Poder', 'Anonimo', 'siglo XVIII', 4),
(10, 'Santo Cristo Coronado de Espinas', 'Pedro Moreira', '1946', 5),
(11, 'Nuestra Senora de Gracia y Esperanza', 'Anticuario Caderot', '1948', 5),
(12, 'Nuestro Padre Jesús del Rescate', 'Antonio Castillo Lastrucci', '1954', 6),
(13, 'María Santísima de Gracia', 'Antonio Castillo Lastrucci', '1956', 6),
(14, 'Nuestro Padre Jesús a su Entrada en Jerusalén', 'Juan Martínez Cerrillo', '1943', 7),
(15, 'María Santisima del Amparo', 'Antonio Castillo Ariza', '1947', 7),
(16, 'Nuestro Padre Jesús del Prendimiento', 'Antonio Castillo Lastrucci', '1961', 8),
(17, 'María Santísima del Gran Perdón', 'Andrés Cabello Requena', '1957', 8),
(18, 'Stmo. Cristo del Amor', 'Fernando Ortiz', 'Siglo XVIII', 9),
(19, 'Ntra. Senora de la Caridad', 'Francisco Buiza', '1947', 9),
(20, 'Ntra. Senora de la Piedad', 'Francisco Palma Burgos', '1942', 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `hermandades`
--
ALTER TABLE `hermandades`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `hermanos`
--
ALTER TABLE `hermanos`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `sedescanonicas`
--
ALTER TABLE `sedescanonicas`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `titulares`
--
ALTER TABLE `titulares`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `hermandades`
--
ALTER TABLE `hermandades`
  MODIFY `codigo` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `sedescanonicas`
--
ALTER TABLE `sedescanonicas`
  MODIFY `codigo` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `titulares`
--
ALTER TABLE `titulares`
  MODIFY `codigo` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
