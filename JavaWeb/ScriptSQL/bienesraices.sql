-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2023 a las 00:46:51
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bienesraices`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_acceso`
--

CREATE TABLE `tb_acceso` (
  `login` varchar(60) NOT NULL,
  `clave` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_acceso`
--

INSERT INTO `tb_acceso` (`login`, `clave`) VALUES
('julio', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_boleta`
--

CREATE TABLE `tb_boleta` (
  `numBoleta` int(11) NOT NULL,
  `cod_cli` int(11) DEFAULT NULL,
  `fechaVenta` date DEFAULT NULL,
  `monto` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_boleta`
--

INSERT INTO `tb_boleta` (`numBoleta`, `cod_cli`, `fechaVenta`, `monto`) VALUES
(1, 2, '2018-11-29', NULL),
(2, 2, '2023-11-15', 1500),
(3, 5, '2023-11-15', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `cod_cli` int(11) NOT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `nombres` varchar(70) DEFAULT NULL,
  `apellidos` varchar(70) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_cliente`
--

INSERT INTO `tb_cliente` (`cod_cli`, `correo`, `nombres`, `apellidos`, `celular`) VALUES
(2, 'Paco@gmail.com', 'Paco', 'SanPedro', '12445'),
(4, 'slz', 'Gera', 'Sal', '998877221'),
(5, 'salvador@gmail.com', 'Julio', 'Salvador', '987456321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_detalleboleta`
--

CREATE TABLE `tb_detalleboleta` (
  `numBoleta` int(11) NOT NULL,
  `nventa` int(11) NOT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_detalleboleta`
--

INSERT INTO `tb_detalleboleta` (`numBoleta`, `nventa`, `precio`) VALUES
(1, 4, 1000),
(2, 2, 1500),
(3, 8, 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `email` varchar(60) NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  `apepat` varchar(60) DEFAULT NULL,
  `apemat` char(60) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`email`, `nombre`, `apepat`, `apemat`, `telefono`) VALUES
('julio', 'Julio Cesar', 'Ordoñez', 'Salvador', '963196277');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_vendedor`
--

CREATE TABLE `tb_vendedor` (
  `ven_codigo` int(11) NOT NULL,
  `nombre` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `celular` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tb_vendedor`
--

INSERT INTO `tb_vendedor` (`ven_codigo`, `nombre`, `celular`, `telefono`, `correo`) VALUES
(1, 'Cesar', '999988777', '165163', 'cesar@gmail.com'),
(2, 'aaaa', 'dsadas', 'dsadsa', '12445'),
(4, 'Paco', '987987987', '156', 'aaaa@gmail.com'),
(5, 'Roy Savedra', '987987456', '15254689', 'profesor@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_venta`
--

CREATE TABLE `tb_venta` (
  `nventa` int(11) NOT NULL,
  `departamento` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `distProv` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `plantas` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mtsTerreno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `recamaras` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mtsConstruccion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `banios` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `precio` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cochera` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `patio` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `amueblado` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `bardeado` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `enrejado` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `vendedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tb_venta`
--

INSERT INTO `tb_venta` (`nventa`, `departamento`, `tipo`, `distProv`, `plantas`, `mtsTerreno`, `recamaras`, `mtsConstruccion`, `banios`, `precio`, `cochera`, `patio`, `amueblado`, `bardeado`, `enrejado`, `vendedor`) VALUES
(2, '3', 'Venta', 'Lima', '3', '700', '2', '600', '3', '1500', '3', 'Si', 'Si', 'Si', 'Si', 1),
(3, '1', 'Venta', 'aa', '2', '214', '1', '125', '1', '12412', '1', 'Si', 'Si', 'Si', 'Si', 1),
(4, '1', 'Venta', 'aa', '2', '214', '1', '125', '1', '12412', '1', 'Si', 'Si', 'Si', 'Si', 1),
(5, '1', 'Venta', 'aa', '2', '214', '1', '125', '1', '12412', '1', 'Si', 'Si', 'Si', 'Si', 1),
(6, '1', 'Venta', '21', '1', '321', '321', '321', '321', '321', '321', 'Si', 'Si', 'Si', 'Si', 1),
(8, '2', 'Venta', 'Huamanga', '1', '1500', '1', '1500', '1', '5000', '1', 'No', 'Si', 'No', 'Si', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_acceso`
--
ALTER TABLE `tb_acceso`
  ADD PRIMARY KEY (`login`),
  ADD KEY `login` (`login`);

--
-- Indices de la tabla `tb_boleta`
--
ALTER TABLE `tb_boleta`
  ADD PRIMARY KEY (`numBoleta`),
  ADD KEY `cod_cli` (`cod_cli`);

--
-- Indices de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`cod_cli`);

--
-- Indices de la tabla `tb_detalleboleta`
--
ALTER TABLE `tb_detalleboleta`
  ADD KEY `numBoleta` (`numBoleta`),
  ADD KEY `codventa` (`nventa`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `tb_vendedor`
--
ALTER TABLE `tb_vendedor`
  ADD PRIMARY KEY (`ven_codigo`);

--
-- Indices de la tabla `tb_venta`
--
ALTER TABLE `tb_venta`
  ADD PRIMARY KEY (`nventa`),
  ADD KEY `vendedor` (`vendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_boleta`
--
ALTER TABLE `tb_boleta`
  MODIFY `numBoleta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `cod_cli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tb_vendedor`
--
ALTER TABLE `tb_vendedor`
  MODIFY `ven_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tb_venta`
--
ALTER TABLE `tb_venta`
  MODIFY `nventa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_boleta`
--
ALTER TABLE `tb_boleta`
  ADD CONSTRAINT `tb_boleta_ibfk_2` FOREIGN KEY (`cod_cli`) REFERENCES `tb_cliente` (`cod_cli`);

--
-- Filtros para la tabla `tb_detalleboleta`
--
ALTER TABLE `tb_detalleboleta`
  ADD CONSTRAINT `tb_detalleboleta_ibfk_1` FOREIGN KEY (`nventa`) REFERENCES `tb_venta` (`nventa`),
  ADD CONSTRAINT `tb_detalleboleta_ibfk_2` FOREIGN KEY (`numBoleta`) REFERENCES `tb_boleta` (`numBoleta`);

--
-- Filtros para la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`email`) REFERENCES `tb_acceso` (`login`);

--
-- Filtros para la tabla `tb_venta`
--
ALTER TABLE `tb_venta`
  ADD CONSTRAINT `tb_venta_ibfk_1` FOREIGN KEY (`vendedor`) REFERENCES `tb_vendedor` (`ven_codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
