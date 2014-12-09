# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : TPF


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `TPF`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

#
# Structure for the `usuarios` table : 
#

CREATE TABLE `usuarios` (
  `dni` int(7) NOT NULL,
  `password` varchar(20) default NULL,
  `nombre` varchar(20) default NULL,
  `apellido` varchar(20) default NULL,
  `direccion` varchar(20) default NULL,
  `direnvio` varchar(20) default NULL,
  `edad` int(2) default NULL,
  `mail` varchar(20) default NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `carritos` table : 
#

CREATE TABLE `carritos` (
  `subtotal` float(9,3) default NULL,
  `dni` int(7) NOT NULL,
  PRIMARY KEY  (`dni`),
  KEY `dni` (`dni`),
  CONSTRAINT `Usuarios_fk` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `compras` table : 
#

CREATE TABLE `compras` (
  `codcompra` varchar(20) NOT NULL,
  `total` int(11) default NULL,
  `dni` int(7) NOT NULL,
  `fecha` datetime default NULL,
  PRIMARY KEY  (`codcompra`),
  KEY `dni` (`dni`),
  CONSTRAINT `compras_fk` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `productos` table : 
#

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
# Structure for the `lineaprod` table : 
#

CREATE TABLE `lineaprod` (
  `dni` int(11) NOT NULL,
  `fecha` datetime default NULL,
  `subtotlinea` float(9,3) default NULL,
  `cantidad` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  PRIMARY KEY  (`dni`,`cantidad`,`codigo`),
  KEY `codigo` (`codigo`),
  KEY `dni` (`dni`),
  CONSTRAINT `lineaprod_fk` FOREIGN KEY (`codigo`) REFERENCES `productos` (`codigo`),
  CONSTRAINT `lineaprod_fk1` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `usuarios` table  (LIMIT 0,500)
#

INSERT INTO `usuarios` (`dni`, `password`, `nombre`, `apellido`, `direccion`, `direnvio`, `edad`, `mail`) VALUES 
  (1,'123456',NULL,NULL,NULL,NULL,NULL,NULL);

COMMIT;

#
# Data for the `carritos` table  (LIMIT 0,500)
#

INSERT INTO `carritos` (`subtotal`, `dni`) VALUES 
  (52766.203,1);

COMMIT;

#
# Data for the `productos` table  (LIMIT 0,500)
#

INSERT INTO `productos` (`nombre`, `modelo`, `descripcion`, `precio`, `capHD`, `interfazHD`, `rpmHD`, `buffeHD`, `wattsF`, `amperajeF`, `frecM`, `cacheM`, `socketM`, `jacksS`, `tamañoG`, `velocidadPR`, `cantusbMO`, `cantpcieMO`, `vonboardMO`, `sonboardMO`, `chipsetMO`, `usb3.0MO`, `cantmaxmemMO`, `frecMEM`, `latenciaMEM`, `cantmemMEM`, `frecVGA`, `abusVGA`, `cantmemVGA`, `pipelsVGA`, `shadersVGA`, `socket`, `tipo`, `seguridad`, `foto`, `socketMO`, `codigo`) VALUES 
  ('B1','MoB1','desB1',1500,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,2,'No','SoundBlaster','Chipset1',1,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Placamadre',NULL,'foB1',NULL,0),
  ('B2','moB2','descB2',100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,2,'Nvidia','sigic','Chipset2',2,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'placamadre',NULL,'foB2',NULL,1),
  ('Fuente1','moFuente1','desFuente1',1000,NULL,NULL,NULL,NULL,500,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente',NULL,'foFuente1',NULL,2),
  ('Fuente2','moFuente2','descFuente2',2000,NULL,NULL,NULL,NULL,1000,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fuente',NULL,'foFuente2',NULL,3),
  ('Gabinete1','modGabinete1','descGabinete1',1550,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete',NULL,'foGabinete1',NULL,4),
  ('Gabinete2','moGabinete2','descGabinete2',1001,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gabinete',NULL,'foGabinete2',NULL,5),
  ('Mem1','ModMem1','descMem1',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,15,1143,'25',NULL,NULL,NULL,NULL,NULL,NULL,'memoria',NULL,'fomem1',NULL,6),
  ('Mem2','ModMem2','descMem2',123,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,12,2345,'15',NULL,NULL,NULL,NULL,NULL,NULL,'memoria',NULL,'fomem2',NULL,7),
  ('Mem3','Modmem3','deacmem3',54,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,14,124,'15',NULL,NULL,NULL,NULL,NULL,NULL,'memoria',NULL,'fomem3',NULL,8),
  ('micro1','Modmicro1','desmicro1',1,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'Intel',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'micro',NULL,'fo1',NULL,9),
  ('micro2','Modmicro2','desmicro2',2,NULL,NULL,NULL,NULL,NULL,NULL,2,2,'AMD',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'micro',NULL,'fo2',NULL,10),
  ('micro3','Modmicro3','desmicro3',3,NULL,NULL,NULL,NULL,NULL,NULL,3,3,'AMD',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'micro',NULL,'fo3',NULL,11),
  ('Plataforma1','moPlataforma1','descPlataforma1',2000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'plataforma',NULL,'foPlataforma1',NULL,12),
  ('HD1','MOHD1','desHD1',4,'250GB','SATAII','7200',32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HD',NULL,NULL,NULL,13),
  ('HD2','moHD2','desHD2',20,'1TB','SATAIII','11500',64,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HD',NULL,NULL,NULL,14),
  ('Pred1','moPred1','desPred1',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10/100',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PRED',NULL,NULL,NULL,15),
  ('Pred2','moPred2','desPred2',25.4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'100/1000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PRED',NULL,NULL,NULL,16),
  ('Psonido1','moPsonido1','desPsonido1',15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PSonido',NULL,NULL,NULL,17),
  ('Psonido2','moPsonido2','desPsonido2',25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Psonido',NULL,NULL,NULL,18),
  ('PWIRELESS1','MOPWIRELESS1','DESPWIRELESS1',254,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10/100',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PWIRELESS','TSK',NULL,NULL,19),
  ('PWIRELESS2','MOPWIRELESS2','DESPWIRELESS2',123,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'100/1000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PWIRELESS','WPA2',NULL,NULL,20),
  ('RCABLE1','MORCABLE1','DESRCABLE1',25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'RCABLE',NULL,NULL,NULL,21),
  ('RCABLE2','RCABLE2','RCABLE2',25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'RCABLE',NULL,NULL,NULL,22),
  ('RCABLE3','3','3',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'RCABLE',NULL,NULL,NULL,23);

COMMIT;

#
# Data for the `lineaprod` table  (LIMIT 0,500)
#

INSERT INTO `lineaprod` (`dni`, `fecha`, `subtotlinea`, `cantidad`, `codigo`) VALUES 
  (1,NULL,1550,1,4),
  (1,NULL,5,1,6),
  (1,NULL,54,1,8),
  (1,NULL,1,1,9),
  (1,NULL,254,1,19),
  (1,NULL,123,1,20),
  (1,NULL,4,2,10),
  (1,NULL,40,2,14),
  (1,NULL,369,3,7),
  (1,NULL,4004,4,5),
  (1,NULL,12,4,11),
  (1,NULL,16,4,13),
  (1,NULL,20,5,15),
  (1,NULL,275,11,21),
  (1,NULL,304.8,12,16),
  (1,NULL,300,12,22),
  (1,NULL,42,14,23),
  (1,NULL,225,15,17),
  (1,NULL,375,15,18),
  (1,NULL,120,24,6);

COMMIT;

