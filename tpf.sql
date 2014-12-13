# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : tpf


SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `tpf`;

CREATE DATABASE `tpf`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `tpf`;

#
# Structure for the `productos` table : 
#

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `nombre` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  `precio` float(9,3) NOT NULL,
  `capHD` varchar(20) default NULL,
  `interfazHD` varchar(20) default NULL,
  `rpmHD` varchar(20) default NULL,
  `buffeHD` int(11) default NULL,
  `wattsF` int(11) default NULL,
  `amperajeF` float(9,3) default NULL,
  `frecM` int(11) default NULL,
  `cacheM` int(11) default NULL,
  `socketM` varchar(20) default NULL,
  `jacksS` int(11) default NULL,
  `tamañoG` int(11) default NULL,
  `velocidadPR` varchar(20) default NULL,
  `cantusbMO` int(11) default NULL,
  `cantpcieMO` int(11) default NULL,
  `vonboardMO` varchar(20) default NULL,
  `sonboardMO` varchar(20) default NULL,
  `chipsetMO` varchar(20) default NULL,
  `usb3.0MO` int(11) default NULL,
  `cantmaxmemMO` int(11) default NULL,
  `frecMEM` int(11) default NULL,
  `latenciaMEM` int(11) default NULL,
  `cantmemMEM` varchar(20) default NULL,
  `frecVGA` int(11) default NULL,
  `abusVGA` int(11) default NULL,
  `cantmemVGA` int(11) default NULL,
  `pipelsVGA` int(11) default NULL,
  `shadersVGA` int(11) default NULL,
  `socket` varchar(20) default NULL,
  `tipo` varchar(20) NOT NULL,
  `seguridad` varchar(20) default NULL,
  `foto` varchar(20) default NULL,
  `socketMO` varchar(20) default NULL,
  `codigo` int(11) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `usuarios` table : 
#

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `dni` int(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `direnvio` varchar(50) NOT NULL,
  `edad` int(2) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `localidad` varchar(40) NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `usuarios` table  (LIMIT 0,500)
#

INSERT INTO `usuarios` (`dni`, `password`, `nombre`, `apellido`, `direccion`, `direnvio`, `edad`, `mail`, `localidad`) VALUES 
  (36004788,'1234567','esteban','lamanna','lavalle 111','lavalle 111',23,'estebanlamanna@h.com','Capitan bermudez');

COMMIT;

#
# Structure for the `carritos` table : 
#

DROP TABLE IF EXISTS `carritos`;

CREATE TABLE `carritos` (
  `dni` int(7) NOT NULL,
  `codigo` int(11) NOT NULL,
  PRIMARY KEY  (`dni`,`codigo`),
  KEY `dni` (`dni`),
  KEY `codigo` (`codigo`),
  CONSTRAINT `carritos_fk` FOREIGN KEY (`codigo`) REFERENCES `productos` (`codigo`),
  CONSTRAINT `Usuarios_fk` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `compras` table : 
#

DROP TABLE IF EXISTS `compras`;

CREATE TABLE `compras` (
  `codcompra` int(11) NOT NULL auto_increment,
  `total` float(9,3) default NULL,
  `dni` int(7) NOT NULL,
  `fecha` datetime default NULL,
  `estado` varchar(20) default NULL,
  PRIMARY KEY  (`codcompra`),
  KEY `dni` (`dni`),
  CONSTRAINT `compras_fk` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `lineacomp` table : 
#

DROP TABLE IF EXISTS `lineacomp`;

CREATE TABLE `lineacomp` (
  `subtotal` float(9,3) default NULL,
  `cantidad` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `codcompra` int(11) NOT NULL,
  `fecha_compra` datetime NOT NULL,
  PRIMARY KEY  (`codcompra`,`codigo`,`cantidad`),
  KEY `codigo` (`codigo`),
  KEY `codcompra` (`codcompra`),
  CONSTRAINT `lineacomp_fk` FOREIGN KEY (`codcompra`) REFERENCES `compras` (`codcompra`),
  CONSTRAINT `lineacomp_fk1` FOREIGN KEY (`codigo`) REFERENCES `productos` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

