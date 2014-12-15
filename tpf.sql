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
  `frecM` float(9,3) default NULL,
  `cacheM` int(11) default NULL,
  `socketM` varchar(20) default NULL,
  `jacksS` float(9,3) default NULL,
  `tamañoG` varchar(20) default NULL,
  `velocidadPR` varchar(20) default NULL,
  `cantusbMO` int(11) default NULL,
  `cantpcieMO` int(11) default NULL,
  `vonboardMO` varchar(20) default NULL,
  `sonboardMO` varchar(20) default NULL,
  `chipsetMO` varchar(20) default NULL,
  `usb30MO` int(11) default NULL,
  `cantmaxmemMO` int(11) default NULL,
  `frecMEM` float(9,3) default NULL,
  `latenciaMEM` varchar(20) default NULL,
  `cantmemMEM` int(11) default NULL,
  `frecVGA` float(9,3) default NULL,
  `abusVGA` int(11) default NULL,
  `cantmemVGA` int(11) default NULL,
  `pipelsVGA` int(11) default NULL,
  `shadersVGA` int(11) default NULL,
  `socket` varchar(20) default NULL,
  `tipo` varchar(20) NOT NULL,
  `foto` varchar(20) default NULL,
  `codigo` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `productos` table  (LIMIT 0,500)
#

INSERT INTO `productos` (`nombre`, `modelo`, `descripcion`, `precio`, `capHD`, `interfazHD`, `rpmHD`, `buffeHD`, `wattsF`, `amperajeF`, `frecM`, `cacheM`, `socketM`, `jacksS`, `tamañoG`, `velocidadPR`, `cantusbMO`, `cantpcieMO`, `vonboardMO`, `sonboardMO`, `chipsetMO`, `usb30MO`, `cantmaxmemMO`, `frecMEM`, `latenciaMEM`, `cantmemMEM`, `frecVGA`, `abusVGA`, `cantmemVGA`, `pipelsVGA`, `shadersVGA`, `socket`, `tipo`, `foto`, `codigo`) VALUES 
  ('Fuente2','DescFuente2','DescFuente',25,NULL,NULL,NULL,NULL,220,4.2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','Fuente2',4),
  ('buffer','buffer','ModifDescbuffer',25,'buffer','buffer','buffer',15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hd','buffer',6),
  ('Mem1','Mem1','Mem1',25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1.77,'7/7/9/9',2,NULL,NULL,NULL,NULL,NULL,NULL,'memoria','Mem1',7),
  ('Mem2','Mem2','Mem2',35,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1.88,'asdqw',4,NULL,NULL,NULL,NULL,NULL,NULL,'memoria','Mem2',8),
  ('Micro1','Micro1','Micro1',35,NULL,NULL,NULL,NULL,NULL,NULL,1.77,15,'AMD',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Null','micro','Micro1',9),
  ('Micro2','Micro2','Micro2',35,NULL,NULL,NULL,NULL,NULL,NULL,1.1,64,'Intel',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'null','micro','Micro2',10),
  ('Mo1','Mo1','Mo1',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,4,'','usb30MO','usb30MO',4,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Intel','placamadre','Mo1',11),
  ('Mo2','Mo2','Mo2',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'','Sonidonew','chip',1,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'AMD','placamadre','Mo2',12),
  ('Pv1','Pv1','Pv1',14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,14,14,14,2,2,NULL,'pvideo','pipelines',13),
  ('Pv2','Pv2','Pv2',17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1.88,32,32,0,0,NULL,'pvideo','Pv2',14),
  ('Ps1','Ps1','Ps1',17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7.1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'psonido','Ps1',15),
  ('Ps2','Ps2','Ps2',17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5.7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'psonido','Ps2',16),
  ('Fue','Fue','FuenteModificada',14,NULL,NULL,NULL,NULL,14,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','Fue',17),
  ('dwqdwqdwqdwqd','dwqdwqdwqdwqd','dwqdwqdwqdwqd',1,NULL,NULL,NULL,NULL,14,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','dwqdwqdwqdwqd',18),
  ('aaaaaaaaaa','a','a',14,NULL,NULL,NULL,NULL,15,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','a',19),
  ('zzzzzzzzzzz','zzzzzzzzzzz','zzzzzzzzzzz',4,NULL,NULL,NULL,NULL,NULL,NULL,1.7,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ewqewq','micro','zzzzzzzzzzz',20),
  ('wwwwwww','wwwwww','wwwwww',100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,'2',2,NULL,NULL,NULL,NULL,NULL,NULL,'memoria','wwwwww',21),
  ('ffffffffff','ffffffffff','ffffffffff',15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,15,'ffffffffff',15,NULL,NULL,NULL,NULL,NULL,NULL,'memoria','ffffffffff',22),
  ('ffffffffff2','ffffffffff2','ffffffffff',15,NULL,NULL,NULL,NULL,15,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','ffffffffff',23),
  ('saaaaaa','saaaaaa','saaaaaa',2,NULL,NULL,NULL,NULL,NULL,NULL,15,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'saaa','micro','saaaaaa',24),
  ('TUNTUN','TUNTUN','TUNTUN',15,NULL,NULL,NULL,NULL,NULL,NULL,15,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'INTEL','micro','TUNTUN',25),
  ('qweqewq','qweqewq','qweqewq',15,NULL,NULL,NULL,NULL,15,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','qweqewq',26),
  ('tttttttttt','tttttttttt','tttttttttt',14,NULL,NULL,NULL,NULL,NULL,NULL,14,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'AMD','micro','tttttttttt',27),
  ('iiiiiiii','iiiiiiii','iiiiiiii',15,NULL,NULL,NULL,NULL,15,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente','iiiiiiii',29),
  ('hhhhhhhhh','hhhhhhhhh','aaaaaaaaaaaaa',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete','hhhh',30),
  ('Modificandoiii','iiiiiiiiiiiiiiiiii','iiiiiiiiiiiiiiiiii',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'iiiiiiiiiiiiiiiiii',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete','iiiiiiiiiiiiiiiiii',31),
  ('dwqdwqzz','dwqdwqzz','dwqdwqzz',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'15',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete','dwqdwqzz',32),
  ('zzzzzzzzzzzzzzzzzz','zzzzzzzzzzzzzzzzzz','zzzzzzzzzzzzzzzzzz',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete','zzzzzzzzzzzzzzzzzz',33),
  ('zzzzzzzzzzzzzzzzzzz','zzzzzzzzzzzzzzzzzzz','zzzzzzzzzzzzzzzzzzz',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete','zzzzzzzzzzzzzzzzzzz',34),
  ('Novacio','Novacio','Novacio',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,2,'Novacio','Novacio','Novacio',2,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Novacio','placamadre','Novacio',35),
  ('MICRROOOO','MICRROOOO','MICRROOOO',12,NULL,NULL,NULL,NULL,NULL,NULL,1.67,32,'MICRROOOO2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'micro','MICRROOOO',36);

COMMIT;

#
# Structure for the `usuarios` table : 
#

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `dni` int(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `direnvio` varchar(20) NOT NULL,
  `edad` int(2) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `localidad` varchar(20) NOT NULL,
  `esAdmin` tinyint(1) NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `usuarios` table  (LIMIT 0,500)
#

INSERT INTO `usuarios` (`dni`, `password`, `nombre`, `apellido`, `direccion`, `direnvio`, `edad`, `mail`, `localidad`, `esAdmin`) VALUES 
  (1,'12345678','Admin','Admin','Dire','Direnv',21,'admin@admin.com','Adminis',0),
  (34412002,'12345678','Juancito','Groad','Pepe','Mediqw',20,'juan@juan.com','Ddeq',0),
  (36004788,'1234567','Esteban','Lamanna','lavalle 111','lavalle 111',23,'estebanlamanna@hotmail.com','Capitan Bermudez',1);

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
# Data for the `carritos` table  (LIMIT 0,500)
#

INSERT INTO `carritos` (`dni`, `codigo`) VALUES 
  (1,4);

COMMIT;

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
# Data for the `compras` table  (LIMIT 0,500)
#

INSERT INTO `compras` (`codcompra`, `total`, `dni`, `fecha`, `estado`) VALUES 
  (1,1,1,'1899-12-23 12:00:00','pendiente');

COMMIT;

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
  PRIMARY KEY  (`codcompra`,`codigo`,`fecha_compra`),
  KEY `codigo` (`codigo`),
  KEY `codcompra` (`codcompra`),
  CONSTRAINT `lineacomp_fk` FOREIGN KEY (`codcompra`) REFERENCES `compras` (`codcompra`),
  CONSTRAINT `lineacomp_fk1` FOREIGN KEY (`codigo`) REFERENCES `productos` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `lineacomp` table  (LIMIT 0,500)
#

INSERT INTO `lineacomp` (`subtotal`, `cantidad`, `codigo`, `codcompra`, `fecha_compra`) VALUES 
  (25,4,4,1,'2014-12-13');

COMMIT;

