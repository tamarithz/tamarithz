CREATE DATABASE  IF NOT EXISTS `tamarithz` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tamarithz`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tamarithz
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activos_empresa`
--

DROP TABLE IF EXISTS `activos_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activos_empresa` (
  `id_activos_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) NOT NULL,
  `id_activos` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_activos_empresa`),
  CONSTRAINT `fk_activos_empresa_empresa1` FOREIGN KEY (`id_activos_empresa`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos_empresa`
--

LOCK TABLES `activos_empresa` WRITE;
/*!40000 ALTER TABLE `activos_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `activos_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activos_subtipos`
--

DROP TABLE IF EXISTS `activos_subtipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activos_subtipos` (
  `id_activos_subtipos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `id_activo_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id_activos_subtipos`),
  KEY `fk_activos_subtipos_activos_tipos1_idx` (`id_activo_tipo`),
  CONSTRAINT `fk_activos_subtipos_activos_tipos1` FOREIGN KEY (`id_activo_tipo`) REFERENCES `activos_tipos` (`id_activos_tipos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos_subtipos`
--

LOCK TABLES `activos_subtipos` WRITE;
/*!40000 ALTER TABLE `activos_subtipos` DISABLE KEYS */;
INSERT INTO `activos_subtipos` VALUES (1,'[source]','codigo fuente',1),(2,'[exe]','codigo ejecutable',1),(3,'[test]','datos de prueba',1),(4,'[info]','proteccion de la informacion',2),(5,'[encrypt]','claves de cifra',2),(6,'[shared_secret]','secreto compartido',2),(7,'[public_descryption]','clave privada de descifrado',2),(8,'[public_encryption]','clave publica de cifra',2),(9,'[sign]','claves de firma',2),(10,'[sign_ahared_secret]]','secreto compartido[clave simetrica]',2),(11,'[sign_public_signature]','clave privada de firma',2),(12,'[sign_public_verification]','clave publica de verificacion de firma',2),(13,'[com]','proteccion de las comunicaciones',2),(14,'[channel]','claves de cifrado de canal',2),(15,'[authentication]','claves de autenticacion',2),(16,'[verification]','claves de verificacion de autenticacion',2),(17,'[disk]','cifrado de soportes de informacion',2),(18,'[disk_encrypt]','claves de cifra',2),(19,'[x509]','certificados de clave publica',2),(42,'[anom]','anonimo(sin requerir identificacion del usuario)',3),(43,'[pub]','al publico en general (sin relacion contraactual)',3),(44,'[ext]','a usuarios externos(bajo una relacion contractual)',3),(45,'[int]','interno (a usuarios de la propia organizacion)',3),(46,'[www]','world wide web',3),(47,'[telnet]','acceso remoto a cuenta local',3),(48,'[email]','correo electronico',3),(49,'[file]','almacenamiento de ficheros',3),(50,'[ftp]','transferencia de ficheros',3),(51,'[edi]','intercambio electronico de datos',3),(52,'[dir]','servicio de directorio',3),(53,'[idm]','gestion de identidades',3),(54,'[ipm]','gestion de privilegios',3),(55,'[pki]','infrastuctura de clave publica',3),(56,'[prp]','desarrollo propio(in house)',4),(57,'[sub]','desarrollo a medida(subcontratado)',4),(58,'[std]','estandar (off the shelf)',4),(59,'[browser]','navegador web',4),(60,'[www]','servidor de presentacion',4),(61,'[app]','servidor de aplicaciones',4),(62,'[email_client]','cliente de correo electronico',4),(63,'[email_server]','servidor de correo electronico',4),(64,'[file]','servidor de ficheros',4),(65,'[dbns]','sistema de gestion de base de datos',4),(66,'[tm]','monitor transaccional',4),(67,'[office]','ofimatica',4),(68,'[av]','antivirus',4),(69,'[os]','sistema operativo',4),(70,'[hypervisor]','gestor de maquinas virtuales',4),(71,'[ts]','servidor de terminales',4),(72,'[backup]','sistema de backup',4),(73,'[host]','grandes equipos',5),(74,'[mid]','equipos medios',5),(75,'[pc]','informatica personal',5),(76,'[mobile]','informatica movil',5),(77,'[pda]','agendas electronicas',5),(78,'[vhost]','equipo virtual',5),(79,'[backup]','equipamento de respaldo',5),(80,'[peripheral]','perifericos',5),(81,'[print]','medios de la impresion',5),(82,'[scan]','escaneres',5),(83,'[crypto]','dispositivos cryptograficos',5),(84,'[bp]','dispositivos de frontera',5),(85,'[network]','soporte de red',5),(86,'[modem]','modems',5),(87,'[nub]','concentradores',5),(88,'[switch]','conmutadores',5),(89,'[router]','encaminadores',5),(90,'[bridge]','pasarelas',5),(91,'[firewall]','cortafuegos',5),(92,'[wap]','punto de acceso inalambrico',5),(93,'[pabx]','centralita telefonica',5),(94,'[ipphone]','telefono ip',5),(95,'[PSTN]','red telefonica',6),(96,'[ISDN]','rdsi(red digital)',6),(97,'[X25]','x25 (red de datos)',6),(98,'[ADSL]','adsl',6),(99,'[pp]','punto a punto ',6),(100,'[radio]','comunicaciones radio',6),(101,'[wifi]','red inalambrica',6),(102,'[mobile]','telefonia movil',6),(103,'[sat]','por satelite',6),(104,'[LAN]','red local',6),(105,'[MAN]','red metropolitana',6),(106,'[Internet]','internet',6),(107,'[electronic]','electronicos',7),(108,'[disk]','discos',7),(109,'[vdisk]','discos virtuales',7),(110,'[san]','almacenamiento de red',7),(111,'[disquette]','disquetes',7),(112,'[cd]','cd-rom',7),(113,'[usb]','memorias usb',7),(114,'[dvd]','DVD',7),(115,'[tape]','cinta magnetica',7),(116,'[mc]','tarjetas de memoria',7),(117,'[ic]','tarjetas inteligentes',7),(118,'[non_electronics]','no electronicos',7),(119,'[printed]','material impreso',7),(120,'[tape]','cinta de papel',7),(121,'[film]','microfilm',7),(122,'[cards]','tarjetas perforadas',7),(123,'[power]','fuentes de alimentacion',8),(124,'[ups]','sistemas de alimentacion ininterrumpida',8),(125,'[gen]','generadores electricos',8),(126,'[ac]','equipos de climatizacion',8),(127,'[cabling]','cableado',8),(128,'[wire]','cable electrico',8),(129,'[fiber]','fibra optica',8),(130,'[robot]','robots',8),(131,'[tape]','.... de cintas',8),(132,'[disk]','.... de discos',8),(133,'[supply]','suministros esenciales',8),(134,'[destroy]','equipos de destruccion de soportes de informacion',8),(135,'[furniture]','mobiliario:armarios,etc...',8),(136,'[safe]','cajas fuertes',8),(137,'[site]','recinto',9),(138,'[building]','edificio',9),(139,'[local]','cuarto',9),(140,'[mobile]','plataformas moviles',9),(141,'[car]','vehiculo terrestre:coche ,camion ,etc...',9),(142,'[plane]','vehiculo aereo:avion,etc...',9),(143,'[ship]','vehiculo maritimo:buque,lancha, etc...',9),(144,'[shelter]','contenedores',9),(145,'[channel]','canalizacion',9),(146,'[backup]','instalaciones de respaldo',9),(147,'[ue]','usuarios externos',10),(148,'[ui]','usuarios internos',10),(149,'[op]','operadores',10),(150,'[adm]','administradores de sistemas',10),(151,'[com]','administradores de comunicaciones',10),(152,'[dba]','administradores de BBDD',10),(153,'[sec]','administradores de seguridad',10),(154,'[des]','desarrolladores/programadores',10),(155,'[sub]','subcontratas',10),(156,'[prov]','provedores',10);
/*!40000 ALTER TABLE `activos_subtipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activos_tipos`
--

DROP TABLE IF EXISTS `activos_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activos_tipos` (
  `id_activos_tipos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_activos_tipos`),
  CONSTRAINT `fk_activos_tipos_activos_empresa1` FOREIGN KEY (`id_activos_tipos`) REFERENCES `activos_empresa` (`id_activos_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos_tipos`
--

LOCK TABLES `activos_tipos` WRITE;
/*!40000 ALTER TABLE `activos_tipos` DISABLE KEYS */;
INSERT INTO `activos_tipos` VALUES (1,'[d]','datos/informacion'),(2,'[k]','claves criptograficas'),(3,'[s]','servicios'),(4,'[sw]','software'),(5,'[hw]','hardware'),(6,'[com]','redes de comunicaciones'),(7,'[media]','soportes de informacion'),(8,'[aux]','equipqmiento auxiliar'),(9,'[l]','instalaciones'),(10,'[p]','personal');
/*!40000 ALTER TABLE `activos_tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activos_tipos_has_amenazas_subtipo`
--

DROP TABLE IF EXISTS `activos_tipos_has_amenazas_subtipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activos_tipos_has_amenazas_subtipo` (
  `activos_tipos_id_activos_tipos` int(11) NOT NULL,
  `amenazas_subtipo_id_amenazas_subtipo` int(11) NOT NULL,
  PRIMARY KEY (`activos_tipos_id_activos_tipos`,`amenazas_subtipo_id_amenazas_subtipo`),
  KEY `fk_activos_tipos_has_amenazas_subtipo_amenazas_subtipo1_idx` (`amenazas_subtipo_id_amenazas_subtipo`),
  KEY `fk_activos_tipos_has_amenazas_subtipo_activos_tipos1_idx` (`activos_tipos_id_activos_tipos`),
  CONSTRAINT `fk_activos_tipos_has_amenazas_subtipo_activos_tipos1` FOREIGN KEY (`activos_tipos_id_activos_tipos`) REFERENCES `activos_tipos` (`id_activos_tipos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activos_tipos_has_amenazas_subtipo_amenazas_subtipo1` FOREIGN KEY (`amenazas_subtipo_id_amenazas_subtipo`) REFERENCES `amenazas_subtipo` (`id_amenazas_subtipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos_tipos_has_amenazas_subtipo`
--

LOCK TABLES `activos_tipos_has_amenazas_subtipo` WRITE;
/*!40000 ALTER TABLE `activos_tipos_has_amenazas_subtipo` DISABLE KEYS */;
INSERT INTO `activos_tipos_has_amenazas_subtipo` VALUES (5,1),(7,1),(8,1),(9,1),(5,2),(7,2),(8,2),(9,2),(5,3),(7,3),(8,3),(9,3),(5,4),(7,4),(8,4),(9,4),(5,5),(7,5),(8,5),(9,5),(5,6),(7,6),(8,6),(9,6),(5,7),(7,7),(8,7),(5,8),(7,8),(8,8),(4,9),(5,9),(7,9),(8,9),(5,10),(7,10),(8,10),(5,11),(7,11),(8,11),(6,12),(8,13),(7,14),(5,15),(7,15),(8,15),(9,15),(1,16),(2,16),(3,16),(4,16),(7,16),(1,17),(2,17),(3,17),(4,17),(5,17),(6,17),(7,17),(1,18),(1,19),(10,20),(4,21),(3,22),(4,22),(6,22),(3,23),(4,23),(6,23),(1,24),(2,24),(3,24),(4,24),(6,24),(7,24),(9,24),(10,24),(1,25),(2,25),(3,25),(4,25),(6,25),(7,25),(9,25),(1,26),(2,26),(3,26),(4,26),(6,26),(7,26),(9,26),(1,27),(2,27),(3,27),(4,27),(6,27),(7,27),(9,27),(10,27),(4,28),(4,29),(5,30),(7,30),(8,30),(3,31),(5,31),(6,31),(5,32),(7,32),(8,32),(10,33),(1,34),(1,35),(1,36),(2,36),(3,36),(4,36),(6,36),(1,37),(2,37),(3,37),(4,37),(5,37),(6,37),(3,38),(4,38),(5,38),(6,38),(7,38),(8,38),(9,38),(4,39),(3,40),(4,40),(6,40),(3,41),(4,41),(6,41),(1,42),(2,42),(3,42),(4,42),(5,42),(6,42),(7,42),(8,42),(9,42),(6,43),(1,44),(3,44),(6,45),(1,46),(2,46),(3,46),(4,46),(6,46),(7,46),(9,46),(1,47),(2,47),(3,47),(4,47),(7,47),(9,47),(1,48),(2,48),(3,48),(4,48),(6,48),(7,48),(9,48),(4,49),(5,50),(7,50),(8,50),(3,51),(5,51),(6,51),(5,52),(7,52),(8,52),(5,53),(7,53),(8,53),(9,53),(9,54),(10,55),(10,56),(10,57);
/*!40000 ALTER TABLE `activos_tipos_has_amenazas_subtipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenazas_subtipo`
--

DROP TABLE IF EXISTS `amenazas_subtipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amenazas_subtipo` (
  `id_amenazas_subtipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `id_amenaza_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id_amenazas_subtipo`),
  KEY `fk_amenazas_subtipo_amenaza tipo1_idx` (`id_amenaza_tipo`),
  CONSTRAINT `fk_amenazas_subtipo_amenaza tipo1` FOREIGN KEY (`id_amenaza_tipo`) REFERENCES `amenazas_tipo` (`id_amenaza tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenazas_subtipo`
--

LOCK TABLES `amenazas_subtipo` WRITE;
/*!40000 ALTER TABLE `amenazas_subtipo` DISABLE KEYS */;
INSERT INTO `amenazas_subtipo` VALUES (1,'[N.1]','fuego',1),(2,'[N.2]','daños por agua',1),(3,'[N.*]','desastres naturales',1),(4,'[l.1]','fuego',2),(5,'[l.2]','daños por agua',2),(6,'[l.*]','desastres industriales',2),(7,'[l.3]','contaminacion mecanica',2),(8,'[l.4]','contaminacion electromagnetica',2),(9,'[l.5]','averia de origen fisico o logico',2),(10,'[l.6]','corte del suministro electrico',2),(11,'[l.7]','condiciones inadecuadas de temperatura o humedad',2),(12,'[l.8]','fallo de servicios de comunicaciones',2),(13,'[l.9]','interrupcion de otros servicios y suministros esenciales',2),(14,'[l.10]','degradacion de los soportes de almacenamiento de la informacion',2),(15,'[l.11]','emanaciones electromagneticas',2),(16,'[E.1]','errores de los usuarios',3),(17,'[E.2]','errores del administrador',3),(18,'[E.3]','errores de monitorizacion (log)',3),(19,'[E.4]','errores de configuracion',3),(20,'[E.7]','deficiencia en la organizacion',3),(21,'[E.8]','difusion de software dañino',3),(22,'[E.9]','errores de [re-]encaminamiento',3),(23,'[E.10]','errores de secuencia',3),(24,'[E.14]','escapes de informacion',3),(25,'[E.15]','alteracion accidental de la informacion',3),(26,'[E.18]','destruccion de informacion',3),(27,'[E.19]','fugas de informacion',3),(28,'[E.20]','vulnerabilidades de los programas(software)',3),(29,'[E.21]','errores de mantenimiento/actualizacion de programas(software)',3),(30,'[E.23]','errores de mantenimiento/actualizacion de equipos(hardware)',3),(31,'[E.24]','caida del sistema por agotamiento de recursos',3),(32,'[E.25]','perdida de equipos',3),(33,'[E.28]','indisponibilidad del personal',3),(34,'[A.3]','manipulacion de los registros de actividad(log)',4),(35,'[A.4]','manipulacion de la configuracion',4),(36,'[A.5]','suplantacion de la identidad del usuario',4),(37,'[A.6]','abuso de privilegios de acceso',4),(38,'[A.7]','uso no previsto',4),(39,'[A.8]','difusion de software dañino',4),(40,'[A.9]','[re-]encaminacion de mensajes',4),(41,'[A.10]','alteracion de secuencia',4),(42,'[A.11]','acceso no autorizado',4),(43,'[A.12]','analisis de trafico',4),(44,'[A.13]','repudio',4),(45,'[A.14]','Interceptación de información (escucha)',4),(46,'[A.15]','Modificación deliberada de la información',4),(47,'[A.18]','Destrucción de información',4),(48,'[A.19]','Divulgación de información',4),(49,'[A.22]','Manipulación de programas',4),(50,'[A.23]','Manipulación de los equipos',4),(51,'[A.24]','Denegación de servicio',4),(52,'[A.25]','Robo',4),(53,'[A.26]','Ataque destructivo',4),(54,'[A.27]','Ocupación enemiga',4),(55,'[A.28]','Indisponibilidad del personal',4),(56,'[A.29]','Extorsión',4),(57,'[A.30]','Ingeniería social (picaresca)',4);
/*!40000 ALTER TABLE `amenazas_subtipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenazas_tipo`
--

DROP TABLE IF EXISTS `amenazas_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amenazas_tipo` (
  `id_amenaza tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id_amenaza tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenazas_tipo`
--

LOCK TABLES `amenazas_tipo` WRITE;
/*!40000 ALTER TABLE `amenazas_tipo` DISABLE KEYS */;
INSERT INTO `amenazas_tipo` VALUES (1,'[N]','Desastres naturales'),(2,'[I]','De origen industrial'),(3,'[E]','Errores y fallos no intencionados'),(4,'[A]','Ataques intencionados');
/*!40000 ALTER TABLE `amenazas_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `descripccion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento_has_empleado`
--

DROP TABLE IF EXISTS `departamento_has_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento_has_empleado` (
  `departamento_id_departamento` int(11) NOT NULL,
  `empleado_id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`departamento_id_departamento`,`empleado_id_empleado`),
  KEY `fk_departamento_has_empleado_empleado1_idx` (`empleado_id_empleado`),
  KEY `fk_departamento_has_empleado_departamento1_idx` (`departamento_id_departamento`),
  CONSTRAINT `fk_departamento_has_empleado_departamento1` FOREIGN KEY (`departamento_id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_departamento_has_empleado_empleado1` FOREIGN KEY (`empleado_id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento_has_empleado`
--

LOCK TABLES `departamento_has_empleado` WRITE;
/*!40000 ALTER TABLE `departamento_has_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento_has_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  CONSTRAINT `fk_empleado_empresa1` FOREIGN KEY (`id_empleado`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cif` varchar(9) NOT NULL,
  `riesgo_asumido` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salvaguardas_subtipo`
--

DROP TABLE IF EXISTS `salvaguardas_subtipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salvaguardas_subtipo` (
  `id_salvaguardas_subtipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `id_salvaguarda_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id_salvaguardas_subtipo`),
  KEY `fk_salvaguardas_subtipo_salvaguardas_tipo1_idx` (`id_salvaguarda_tipo`),
  CONSTRAINT `fk_salvaguardas_subtipo_salvaguardas_tipo1` FOREIGN KEY (`id_salvaguarda_tipo`) REFERENCES `salvaguardas_tipo` (`id_salvaguardas_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salvaguardas_subtipo`
--

LOCK TABLES `salvaguardas_subtipo` WRITE;
/*!40000 ALTER TABLE `salvaguardas_subtipo` DISABLE KEYS */;
INSERT INTO `salvaguardas_subtipo` VALUES (1,'H','Protecciones Generales',1),(2,'H.IA','Identificación y autenticación',1),(3,'H.AC','Control de acceso lógico',1),(4,'H.ST','Segregación de tareas',1),(5,'H.IR','Gestión de incidencias',1),(6,'H.tools','Herramientas de seguridad',1),(7,'H.tools.AV','Herramienta contra código dañino',1),(8,'H.tools.IDS','IDS/IPS: Herramienta de detección / prevención de intrusión',1),(9,'H.tools.CC','Herramienta de chequeo de configuración',1),(10,'H.tools.VA','Herramienta de análisis de vulnerabilidades',1),(11,'H.tools.TM','Herramienta de monitorización de tráfico',1),(12,'H.tools.DLP','DLP: Herramienta de monitorización de contenidos',1),(13,'H.tools.LA','Herramienta para análisis de logs',1),(14,'H.tools.HP','Honey net / honey pot',1),(15,'H.tools.SFV','Verificación de las funciones de seguridad',1),(16,'H.VM','Gestión de vulnerabilidades',1),(17,'H.AU','Registro y auditoría',1),(18,'D','Protección de la Información',2),(19,'D.A','Copias de seguridad de los datos (backup)',2),(20,'D.I','Aseguramiento de la integridad',2),(21,'D.C','Cifrado de la información',2),(22,'D.DS','Uso de firmas electrónicas',2),(23,'D.TS','Uso de servicios de fechado electrónico (time stamping)',2),(24,'K','Gestión de claves criptográficas',3),(25,'K.IC','Gestión de claves de cifra de información',3),(26,'K.DS','Gestión de claves de firma de información',3),(27,'K.disk','Gestión de claves para contenedores criptográficos',3),(28,'K.comms','Gestión de claves de comunicaciones',3),(29,'K.509','Gestión de certificados',3),(30,'S','Protección de los Servicios',4),(31,'S.A','Aseguramiento de la disponibilidad',4),(32,'S.start','Aceptación y puesta en operación',4),(33,'S.SC','Se aplican perfiles de seguridad',4),(34,'S.op','Explotación',4),(35,'S.CM','Gestión de cambios (mejoras y sustituciones)',4),(36,'S.end','Terminación',4),(37,'S.www','Protección de servicios y aplicaciones web',4),(38,'S.email','Protección del correo electrónico',4),(39,'S.dir','Protección del directorio',4),(40,'S.dns','Protección del servidor de nombres de dominio (DNS)',4),(41,'S.TW','Teletrabajo',4),(42,'S.voip','Voz sobre IP',4),(43,'SW','Protección de las Aplicaciones Informáticas',5),(44,'SW.A','Copias de seguridad (backup)',5),(45,'SW.start','Puesta en producción',5),(46,'SW.SC','Se aplican perfiles de seguridad',5),(47,'SW.op','Explotación / Producción',5),(48,'SW.CM','Cambios (actualizaciones y mantenimiento)',5),(49,'SW.end','Terminación',5),(50,'HW','Protección de los Equipos Informáticos',6),(51,'HW.start','Puesta en producción',6),(52,'HW.SC','Se aplican perfiles de seguridad',6),(53,'HW.A','Aseguramiento de la disponibilidad',6),(54,'HW.op','Operación',6),(55,'HW.CM','Cambios (actualizaciones y mantenimiento)',6),(56,'HW.end','Terminación',6),(57,'HW.PCD','Informática móvil',6),(58,'HW.print','Reproducción de documentos',6),(59,'HW.pabx','Protección de la centralita telefónica (PABX)',6),(60,'COM','Protección de las Comunicaciones',7),(61,'COM.start','Entrada en servicio',7),(62,'COM.SC','Se aplican perfiles de seguridad',7),(63,'COM.A','Aseguramiento de la disponibilidad',7),(64,'COM.aut','Autenticación del canal',7),(65,'COM.I','Protección de la integridad de los datos intercambiados',7),(66,'COM.C','Protección criptográfica de la confidencialidad de los datos intercambiados',7),(67,'COM.op','Operación',7),(68,'COM.CM','Cambios (actualizaciones y mantenimiento)',7),(69,'COM.end','Terminación',7),(70,'COM.internet','Internet: uso de ? acceso a',7),(71,'COM.wifi','Seguridad Wireless (WiFi)',7),(72,'COM.mobile','Telefonía móvil',7),(73,'COM.DS','Segregación de las redes en dominios',7),(74,'IP','Puntos de interconexión: conexiones entre zonas de confianza',8),(75,'IP.SPP','Sistema de protección perimetral',8),(76,'IP.BS','Protección de los equipos de frontera',8),(77,'MP','Protección de los Soportes de Información',9),(78,'MP.A','Aseguramiento de la disponibilidad',9),(79,'MP.IC','Protección criptográfica del contenido',9),(80,'MP.clean','Limpieza de contenidos',9),(81,'MP.end','Destrucción de soportes',9),(82,'AUX','Elementos Auxiliares',10),(83,'AUX.A','Aseguramiento de la disponibilidad',10),(84,'AUX.start','Instalación',10),(85,'AUX.power','Suministro eléctrico',10),(86,'AUX.AC','Climatización',10),(87,'AUX.wires','Protección del cableado',10),(88,'L','Protección de las Instalaciones',11),(89,'L.design','Diseño',11),(90,'L.depth','Defensa en profundidad',11),(91,'L.AC','Control de los accesos físicos',11),(92,'L.A','Aseguramiento de la disponibilidad',11),(93,'L.end','Terminación',11),(94,'PS','Gestión del Personal',12),(95,'PS.AT','Formación y concienciación',12),(96,'PS.A','Aseguramiento de la disponibilidad',12),(97,'G','Organización',13),(98,'G.RM','Gestión de riesgos',13),(99,'G.plan','Planificación de la seguridad',13),(100,'G.exam','Inspecciones de seguridad',13),(101,'BC','Continuidad del negocio',14),(102,'BC.BIA','Análisis de impacto (BIA)',14),(103,'BC.DRP','Plan de Recuperación de Desastres (DRP)',14),(104,'E','Relaciones Externas',15),(105,'E.1','Acuerdos para intercambio de información y software',15),(106,'E.2','Acceso externo',15),(107,'E.3','Servicios proporcionados por otras organizaciones',15),(108,'E.4','Personal subcontratado',15),(109,'NEW','Adquisición / desarrollo',16),(110,'NEW.S','Servicios: Adquisición o desarrollo',16),(111,'NEW.SW','Aplicaciones: Adquisición o desarrollo',16),(112,'NEW.HW','Equipos: Adquisición o desarrollo',16),(113,'NEW.COM','Comunicaciones: Adquisición o contratación',16),(114,'NEW.MP','Soportes de Información: Adquisición',16),(115,'NEW.C','Productos certificados o acreditados',16),(116,'BSI','Federal Office for Information Security (BSI). “IT Baseline Protection Manual”, October 2003. Germany. http://www.bsi.de/gshb/english/etc/index.htm',17),(117,'CC','Comon Criteria. Ver [ISO 15408].',17),(118,'Guías CCN-STIC','https://www.ccn-cert.cni.es/',17),(119,'ISO JTC 71/SC 27','Numerosas guías producidas por ISO concretan medidas de seguridad. Consulte el catálogo del comité 71 \"TECNOLOGÍA DE LA INFORMACIÓN\", subcomité SC 27 \"TÉCNICAS DE SEGURIDAD\".',17),(120,'ISO 15408','ISO/IEC 15408:2009, “Information technology — Security techniques — Evaluation criteria for IT security”.',17),(121,'ISO 27002','ISO/IEC 27002:2005, “Information technology — Security techniques — Code of practice for information security management”. UNE-ISO/IEC 27002:2009, “Tecnología de la Información. Código de Buenas Prácticas de la Gestión de la Seguridad de la Información”.',17),(122,'NIST 800-53','NIST, “Recommended Security Controls for Federal Information Systems”, National Institute of Standards and Technology, special publication SP 800-53 Rev.3, Aug. 2009.',17),(123,'RD 3/2010','Real Decreto 3/2010, de 8 de enero, por el que se regula el Esquema Nacional de Seguridad en el ámbito de la Administración Electrónica.',17),(124,'RD 1720/2007','Real Decreto 1720/2007, de 21 de diciembre, por el que se aprueba el Reglamento de desarrollo de la Ley Orgánica 15/1999, de 13 de diciembre, de protección de datos de carácter personal.',17);
/*!40000 ALTER TABLE `salvaguardas_subtipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salvaguardas_subtipo_has_activos_tipos`
--

DROP TABLE IF EXISTS `salvaguardas_subtipo_has_activos_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salvaguardas_subtipo_has_activos_tipos` (
  `salvaguardas_subtipo_id_salvaguardas_subtipo` int(11) NOT NULL,
  `activos_tipos_id_activos_tipos` int(11) NOT NULL,
  PRIMARY KEY (`salvaguardas_subtipo_id_salvaguardas_subtipo`,`activos_tipos_id_activos_tipos`),
  KEY `fk_salvaguardas_subtipo_has_activos_tipos_activos_tipos1_idx` (`activos_tipos_id_activos_tipos`),
  KEY `fk_salvaguardas_subtipo_has_activos_tipos_salvaguardas_subt_idx` (`salvaguardas_subtipo_id_salvaguardas_subtipo`),
  CONSTRAINT `fk_salvaguardas_subtipo_has_activos_tipos_activos_tipos1` FOREIGN KEY (`activos_tipos_id_activos_tipos`) REFERENCES `activos_tipos` (`id_activos_tipos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_salvaguardas_subtipo_has_activos_tipos_salvaguardas_subtipo1` FOREIGN KEY (`salvaguardas_subtipo_id_salvaguardas_subtipo`) REFERENCES `salvaguardas_subtipo` (`id_salvaguardas_subtipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salvaguardas_subtipo_has_activos_tipos`
--

LOCK TABLES `salvaguardas_subtipo_has_activos_tipos` WRITE;
/*!40000 ALTER TABLE `salvaguardas_subtipo_has_activos_tipos` DISABLE KEYS */;
INSERT INTO `salvaguardas_subtipo_has_activos_tipos` VALUES (18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,2),(25,2),(26,2),(27,2),(28,2),(29,2),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(41,3),(42,3),(43,4),(44,4),(45,4),(46,4),(47,4),(48,4),(49,4),(50,5),(51,5),(52,5),(53,5),(54,5),(55,5),(56,5),(57,5),(58,5),(59,5),(60,6),(61,6),(62,6),(63,6),(64,6),(65,6),(66,6),(67,6),(68,6),(69,6),(70,6),(71,6),(72,6),(73,6),(77,7),(78,7),(79,7),(80,7),(81,7),(82,8),(83,8),(84,8),(85,8),(86,8),(87,8),(88,9),(89,9),(90,9),(91,9),(92,9),(93,9),(94,10),(95,10),(96,10);
/*!40000 ALTER TABLE `salvaguardas_subtipo_has_activos_tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salvaguardas_tipo`
--

DROP TABLE IF EXISTS `salvaguardas_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salvaguardas_tipo` (
  `id_salvaguardas_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id_salvaguardas_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salvaguardas_tipo`
--

LOCK TABLES `salvaguardas_tipo` WRITE;
/*!40000 ALTER TABLE `salvaguardas_tipo` DISABLE KEYS */;
INSERT INTO `salvaguardas_tipo` VALUES (1,'H','Protecciones generales u horizontales'),(2,'D','Protección de los datos / información'),(3,'K','Protección de las claves criptográficas'),(4,'S','Protección de los servicios'),(5,'SW','Protección de las aplicaciones (software)'),(6,'HW','Protección de los equipos (hardware)'),(7,'COM','Protección de las comunicaciones'),(8,'IP','Protección en los puntos de interconexión con otros sistemas'),(9,'MP','Protección de los soportes de información'),(10,'AUX','Protección de los elementos auxiliares'),(11,'L','Seguridad física – Protección de las instalaciones'),(12,'PS','Salvaguardas relativas al personal'),(13,'G','Salvaguardas de tipo organizativo'),(14,'BC','Continuidad de operaciones'),(15,'E','Externalización'),(16,'NEW','Adquisición y desarrollo'),(17,'REF','Referencias');
/*!40000 ALTER TABLE `salvaguardas_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-19 11:48:46
