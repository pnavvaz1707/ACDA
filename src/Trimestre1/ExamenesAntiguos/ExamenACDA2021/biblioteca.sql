-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2020 a las 18:51:14
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
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `CodigoLibro` int(1) NOT NULL,
  `NombreLibro` varchar(26) DEFAULT NULL,
  `Editorial` varchar(13) DEFAULT NULL,
  `Autor` varchar(21) DEFAULT NULL,
  `Genero` varchar(14) DEFAULT NULL,
  `PaisAutor` varchar(14) DEFAULT NULL,
  `NumeroPaginas` int(3) DEFAULT NULL,
  `AnyoEdicion` int(4) DEFAULT NULL,
  `PrecioLibro` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`CodigoLibro`, `NombreLibro`, `Editorial`, `Autor`, `Genero`, `PaisAutor`, `NumeroPaginas`, `AnyoEdicion`, `PrecioLibro`) VALUES
(1, 'Don Quijote de La Mancha I', 'Anaya', 'Miguel de Cervantes', 'Caballeresco', 'España', 517, 1991, '2.750,00'),
(2, 'Don Quijote deLa Mancha II', 'Anaya', 'Miguel de Cervantes', 'Caballeresco', 'España', 611, 1991, '3.125,00'),
(3, 'Historias de Nueva Orleans', 'Alfaguara', 'William Faulkner', 'Novela', 'Estados Unidos', 186, 1991, '675,00'),
(4, 'El principito', 'Andina', 'Antoine Saint-Exupery', 'Aventura', 'Francia', 120, 1996, '750,00'),
(5, 'El príncipe', 'S.M.', 'Maquiavelo', 'Político', 'Italia', 210, 1995, '1.125,00'),
(6, 'Diplomacia', 'S.M.', 'Henry Kissinger', 'Político', 'Alemania', 825, 1997, '1.750,00'),
(7, 'Los Windsor', 'Plaza & Janes', 'Kitty Kelley', 'Biografías', 'Gran Bretaña', 620, 1998, '1.130,00'),
(8, 'El Último Emperador', 'Caralt', 'Pu-Yi', 'Autobiografías', 'China', 353, 1989, '995,00'),
(9, 'Fornata y Jacinta', 'Plaza & Janes', 'Pérez Galdós', 'Novela', 'España', 625, 1984, '725,00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `NumeroPedido` int(2) NOT NULL,
  `CodigoLibro` int(1) DEFAULT NULL,
  `CodigoUsuario` int(1) DEFAULT NULL,
  `FechaSalida` varchar(10) DEFAULT NULL,
  `FechaMaxDevolucion` varchar(10) DEFAULT NULL,
  `FechaDevolucion` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`NumeroPedido`, `CodigoLibro`, `CodigoUsuario`, `FechaSalida`, `FechaMaxDevolucion`, `FechaDevolucion`) VALUES
(1, 1, 3, '01/11/1999', '15/11/1999', '13/11/1999'),
(2, 3, 2, '03/11/1999', '20/11/1999', '22/11/1999'),
(3, 2, 5, '18/11/1999', '30/11/1999', '25/11/1999'),
(4, 5, 6, '21/11/1999', '03/12/1999', '05/12/1999'),
(5, 9, 2, '21/11/1999', '05/12/1999', '30/11/1999'),
(6, 2, 4, '21/11/1999', '07/12/1999', '01/12/1999'),
(7, 4, 3, '26/11/1999', '07/12/1999', '08/12/1999'),
(8, 1, 1, '30/11/1999', '09/12/1999', '11/12/1999'),
(9, 3, 6, '01/12/1999', '09/12/1999', '09/12/1999'),
(10, 7, 3, '03/12/1999', '18/12/1999', '15/12/1999'),
(11, 3, 2, '03/12/1999', '22/12/1999', '20/12/1999');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `CodigoUsuario` int(1) NOT NULL,
  `Nombre` varchar(9) DEFAULT NULL,
  `Apellidos` varchar(13) DEFAULT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `Domicilio` varchar(18) DEFAULT NULL,
  `Poblacion` varchar(15) DEFAULT NULL,
  `Provincia` varchar(10) DEFAULT NULL,
  `FechaNacimiento` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`CodigoUsuario`, `Nombre`, `Apellidos`, `DNI`, `Domicilio`, `Poblacion`, `Provincia`, `FechaNacimiento`) VALUES
(1, 'Lucía', 'Posadas Gil', '42117892S', 'Av. Escaleritas 12', 'Las Palmas G.C.', 'Las Palmas', '04/07/1971'),
(2, 'José', 'Sánchez Pons', '31765348D', 'Mesa y López 51', 'Las Palmas G.C.', 'Las Palmas', '07/09/1966'),
(3, 'Miguel', 'Gómez Sáez', '11542981G', 'Gran Vía 71', 'Madrid', 'Madrid', '09/12/1976'),
(4, 'Eva', 'Santana Páez', '78542450L', 'Pío Baroja 23', 'Bilbao', 'Vizcaya', '23/05/1980'),
(5, 'Yolanda', 'Betancor Díaz', '44312870Z', 'El Cid 45', 'Miranda de Ebro', 'Burgos', '17/09/1976'),
(6, 'Juan Luis', 'Blasco Pita', '47234471P', 'Jaime I, 65', 'Alcira', 'Valencia', '01/03/1982');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`CodigoLibro`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`NumeroPedido`),
  ADD KEY `prestamos_ibfk_1` (`CodigoLibro`),
  ADD KEY `prestamos_ibfk_2` (`CodigoUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CodigoUsuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`CodigoLibro`) REFERENCES `libros` (`CodigoLibro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`CodigoUsuario`) REFERENCES `usuario` (`CodigoUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
