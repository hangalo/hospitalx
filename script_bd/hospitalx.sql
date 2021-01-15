-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitalx
-- ------------------------------------------------------
-- Server version	5.5.62-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda_consulta`
--

DROP TABLE IF EXISTS `agenda_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenda_consulta` (
  `id_agenda_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `id_especialidade` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `data_agenda` date DEFAULT NULL,
  PRIMARY KEY (`id_agenda_consulta`),
  KEY `fk_agenda_consulta_especialidade1_idx` (`id_especialidade`),
  KEY `fk_agenda_consulta_medico1_idx` (`id_medico`),
  CONSTRAINT `fk_agenda_consulta_especialidade1` FOREIGN KEY (`id_especialidade`) REFERENCES `especialidade` (`id_especialidade`),
  CONSTRAINT `fk_agenda_consulta_medico1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_consulta`
--

LOCK TABLES `agenda_consulta` WRITE;
/*!40000 ALTER TABLE `agenda_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cama`
--

DROP TABLE IF EXISTS `cama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cama` (
  `id_cama` int(11) NOT NULL AUTO_INCREMENT,
  `numero_cama` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cama`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cama`
--

LOCK TABLES `cama` WRITE;
/*!40000 ALTER TABLE `cama` DISABLE KEYS */;
/*!40000 ALTER TABLE `cama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_medicamento`
--

DROP TABLE IF EXISTS `categoria_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria_medicamento` (
  `id_categoria_medicamento` int(11) NOT NULL,
  `categoria_medicamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_medicamento`
--

LOCK TABLES `categoria_medicamento` WRITE;
/*!40000 ALTER TABLE `categoria_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta` (
  `id_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `data_consulta` date DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_consulta`),
  KEY `fk_consulta_funcionario1_idx` (`id_funcionario`),
  KEY `fk_consulta_paciente1_idx` (`id_paciente`),
  CONSTRAINT `fk_consulta_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`),
  CONSTRAINT `fk_consulta_paciente1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalhes_internamento_enfermeiro`
--

DROP TABLE IF EXISTS `detalhes_internamento_enfermeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalhes_internamento_enfermeiro` (
  `id_detalhes_internamento_enfermeiro` int(11) NOT NULL AUTO_INCREMENT,
  `data_visita` date DEFAULT NULL,
  `cura_feita` varchar(45) DEFAULT NULL,
  `id_internamento` int(11) NOT NULL,
  `id_enfermeiro` int(11) NOT NULL,
  PRIMARY KEY (`id_detalhes_internamento_enfermeiro`),
  KEY `fk_detalhes_internamento_internamento1_idx` (`id_internamento`),
  KEY `fk_detalhes_internamento_enfermeiro_enfermeiro1_idx` (`id_enfermeiro`),
  CONSTRAINT `fk_detalhes_internamento_enfermeiro_enfermeiro1` FOREIGN KEY (`id_enfermeiro`) REFERENCES `enfermeiro` (`id_enfermeiro`),
  CONSTRAINT `fk_detalhes_internamento_internamento1` FOREIGN KEY (`id_internamento`) REFERENCES `internamento` (`id_internamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalhes_internamento_enfermeiro`
--

LOCK TABLES `detalhes_internamento_enfermeiro` WRITE;
/*!40000 ALTER TABLE `detalhes_internamento_enfermeiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalhes_internamento_enfermeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalhes_internamento_medico`
--

DROP TABLE IF EXISTS `detalhes_internamento_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalhes_internamento_medico` (
  `iddetalhes_internamento_medico` int(11) NOT NULL AUTO_INCREMENT,
  `data_visita` date DEFAULT NULL,
  `observacao_feita` varchar(45) DEFAULT NULL,
  `id_internamento` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  PRIMARY KEY (`iddetalhes_internamento_medico`),
  KEY `fk_detalhes_internamento_medico_internamento1_idx` (`id_internamento`),
  KEY `fk_detalhes_internamento_medico_medico1_idx` (`id_medico`),
  CONSTRAINT `fk_detalhes_internamento_medico_internamento1` FOREIGN KEY (`id_internamento`) REFERENCES `internamento` (`id_internamento`),
  CONSTRAINT `fk_detalhes_internamento_medico_medico1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalhes_internamento_medico`
--

LOCK TABLES `detalhes_internamento_medico` WRITE;
/*!40000 ALTER TABLE `detalhes_internamento_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalhes_internamento_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalhes_receita`
--

DROP TABLE IF EXISTS `detalhes_receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalhes_receita` (
  `id_detalhes_receita` int(11) NOT NULL AUTO_INCREMENT,
  `id_receita` int(11) NOT NULL,
  `id_medicamento` int(11) NOT NULL,
  `preco_medicamento` double DEFAULT NULL,
  `indicacoes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_detalhes_receita`),
  KEY `fk_detalhes_receita_receita1_idx` (`id_receita`),
  KEY `fk_detalhes_receita_medicamento1_idx` (`id_medicamento`),
  CONSTRAINT `fk_detalhes_receita_medicamento1` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`),
  CONSTRAINT `fk_detalhes_receita_receita1` FOREIGN KEY (`id_receita`) REFERENCES `receita` (`id_receita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalhes_receita`
--

LOCK TABLES `detalhes_receita` WRITE;
/*!40000 ALTER TABLE `detalhes_receita` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalhes_receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermeiro`
--

DROP TABLE IF EXISTS `enfermeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enfermeiro` (
  `id_enfermeiro` int(11) NOT NULL AUTO_INCREMENT,
  `nome_enfermeiro` varchar(45) DEFAULT NULL,
  `sobrenom_enfermeiro` varchar(45) DEFAULT NULL,
  `data_nascimento_enfermeiro` date DEFAULT NULL,
  `sexo_enfermeiro` char(20) DEFAULT NULL,
  `email_enfermeiro` varchar(45) DEFAULT NULL,
  `telefone_enfermeiro` varchar(45) DEFAULT NULL,
  `rua_enfermeiro` varchar(45) DEFAULT NULL,
  `casa_enfermeiro` varchar(45) DEFAULT NULL,
  `bairro_enfermeiro` varchar(45) DEFAULT NULL,
  `distritito_enfermeiro` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  PRIMARY KEY (`id_enfermeiro`),
  KEY `fk_enfermeiro_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_enfermeiro_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermeiro`
--

LOCK TABLES `enfermeiro` WRITE;
/*!40000 ALTER TABLE `enfermeiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfermeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidade` (
  `id_especialidade` int(11) NOT NULL AUTO_INCREMENT,
  `especialidade` varchar(45) DEFAULT NULL,
  `custo` double DEFAULT NULL,
  PRIMARY KEY (`id_especialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidade`
--

LOCK TABLES `especialidade` WRITE;
/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(45) DEFAULT NULL,
  `sobrenom_funcionario` varchar(45) DEFAULT NULL,
  `data_nascimento_funcionario` date DEFAULT NULL,
  `sexo_funcionario` char(20) DEFAULT NULL,
  `email_funcionario` varchar(45) DEFAULT NULL,
  `telefone_funcionario` varchar(45) DEFAULT NULL,
  `rua_funcionario` varchar(45) DEFAULT NULL,
  `casa_funcionario` varchar(45) DEFAULT NULL,
  `bairro_funcionario` varchar(45) DEFAULT NULL,
  `distritito_funcionario` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_funcionario_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_funcionario_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Joaquim','Hangalo','2021-01-12','M','joajoshang@gmail.com','3383402632','12212','1212','1212','1212',3),(2,'HANGALO','JOSE','2021-01-12','M','joajoshang@gmail.com','3351641820','12212','1212','1212','1212',4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internamento`
--

DROP TABLE IF EXISTS `internamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `internamento` (
  `id_internamento` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `id_quarto` int(11) NOT NULL,
  `id_cama` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  PRIMARY KEY (`id_internamento`),
  KEY `fk_internamento_quarto1_idx` (`id_quarto`),
  KEY `fk_internamento_cama1_idx` (`id_cama`),
  KEY `fk_internamento_paciente1_idx` (`id_paciente`),
  KEY `fk_internamento_medico1_idx` (`id_medico`),
  CONSTRAINT `fk_internamento_cama1` FOREIGN KEY (`id_cama`) REFERENCES `cama` (`id_cama`),
  CONSTRAINT `fk_internamento_medico1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`),
  CONSTRAINT `fk_internamento_paciente1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `fk_internamento_quarto1` FOREIGN KEY (`id_quarto`) REFERENCES `quarto` (`id_quarto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internamento`
--

LOCK TABLES `internamento` WRITE;
/*!40000 ALTER TABLE `internamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `internamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `id_medicamento` int(11) NOT NULL,
  `nome_medicamento` varchar(45) DEFAULT NULL,
  `data_expira_medicamento` varchar(45) DEFAULT NULL,
  `preco_medicamento` double DEFAULT NULL,
  `id_categoria_medicamento` int(11) NOT NULL,
  PRIMARY KEY (`id_medicamento`),
  KEY `fk_medicamento_categoria_medicamento_idx` (`id_categoria_medicamento`),
  CONSTRAINT `fk_medicamento_categoria_medicamento` FOREIGN KEY (`id_categoria_medicamento`) REFERENCES `categoria_medicamento` (`id_categoria_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `id_medico` int(11) NOT NULL AUTO_INCREMENT,
  `nome_medico` varchar(45) DEFAULT NULL,
  `sobrenom_medico` varchar(45) DEFAULT NULL,
  `data_nascimento_medico` date DEFAULT NULL,
  `sexo_medico` char(20) DEFAULT NULL,
  `email_medico` varchar(45) DEFAULT NULL,
  `telefone_medico` varchar(45) DEFAULT NULL,
  `rua_medico` varchar(45) DEFAULT NULL,
  `casa_medico` varchar(45) DEFAULT NULL,
  `bairro_medico` varchar(45) DEFAULT NULL,
  `distritito_medico` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  PRIMARY KEY (`id_medico`),
  KEY `fk_medico_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_medico_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_municipio` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `fk_municipio_provincia_idx` (`id_provincia`),
  CONSTRAINT `fk_municipio_provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'Ambriz',1),(2,'Bula Atumba',1),(3,'Dande',1),(4,'Dembos',1),(5,'Nambuangongo',1),(6,'Pango Aluquém',1),(7,'Balombo',2),(8,'Baia Farta',2),(9,'Benguela',2),(10,'Bocoio',2),(11,'Caimbambo',2),(12,'Catumbela',2),(13,'Chongoroi',2),(14,'Cubal',2),(15,'Ganda',2),(16,'Lobito',2),(17,'Andulo',3),(18,'Camacupa',3),(19,'Catabola',3),(20,'Chinguar',3),(21,'Chitembo',3),(22,'Cuemba',3),(23,'Cunhinga',3),(24,'Kuito',3),(25,'Nharea',3),(26,'Belize',4),(27,'Buco-Zau',4),(28,'Cabinda',4),(29,'Cacongo',4),(30,'Calai',5),(31,'Cuangar',5),(32,'Cuchi',5),(33,'Cuito Cuanavale',5),(34,'Dirico',5),(35,'Mavinga',5),(36,'Menongue',5),(37,'Nancova',5),(38,'Rivungo',5),(39,'Cahama',8),(40,'Cuanhama',8),(41,'Curoca',8),(42,'Cuvelai',8),(43,'Namacunde',8),(44,'Ombadja',8),(45,'Bailundo',9),(46,'Catchiungo',9),(47,'Caala',9),(48,'Ekuma',9),(49,'Huambo',9),(50,'Londuimbale',9),(51,'Longonjo',9),(52,'Mungo',9),(53,'Tchicala-Tchiloanga',9),(54,'Tchindjenje',9),(55,'Ucuma',9),(56,'Caconda',10),(57,'Cacula',10),(58,'Caluquembe',10),(59,'Gambos',10),(60,'Chibia',10),(61,'Chicomba',10),(62,'Chipindo',10),(63,'Cuvango',10),(64,'Humpata',10),(65,'Jamba',10),(66,'Lubango',10),(67,'Matala',10),(68,'Quilengues',10),(69,'Quipungo',10),(70,'Ambaca',6),(71,'Banga',6),(72,'Bolongongo',6),(73,'Cambambe',6),(74,'Cazengo',6),(75,'Golungo Alto',6),(76,'Gonguembo',6),(77,'Lucala',6),(78,'Quiculungo',6),(79,'Samba Caju',6),(80,'Cassongue',7),(81,'Conda',7),(82,'Ebo',7),(83,'Libolo',7),(84,'Mussende',7),(85,'Porto Amboin',7),(86,'Quibala',7),(87,'Quilenda',7),(88,'Seles',7),(89,'Sumbe',7),(90,'Waku Kungo',7),(91,'Belas',11),(92,'Cacuaco',11),(93,'Cazenga',11),(94,'Icolo e Bengo',11),(95,'Luanda',11),(96,'Quiçama',11),(97,'Viana',11),(98,'Cambulo',12),(99,'Capenda-Camulemba',12),(100,'Caungula',12),(101,'Chitato',12),(102,'Cuango',12),(103,'Cuilo',12),(104,'Lubalo',12),(105,'Lukapa',12),(106,'Xá-Muteba',12),(107,'Cacolo',13),(108,'Dala',13),(109,'Muconda',13),(110,'Saurimo',13),(111,'Cacuso',14),(112,'Calandula',14),(113,'Cambundi-Catembo',14),(114,'Cangandala',14),(115,'Caombo',14),(116,'Cuaba Nzogo',14),(117,'Cunda-Dia-Baze',14),(118,'Luquembo',14),(119,'Malange',14),(120,'Marimba',14),(121,'Massango',14),(122,'Mucari',14),(123,'Quela',14),(124,'Quirima',14),(125,'Alto Zambeze',15),(126,'Bundas',15),(127,'Camanongue',15),(128,'Léua',15),(129,'Luau',15),(130,'Luacano',15),(131,'Luchazes',15),(132,'Lumeje',15),(133,'Moxico',15),(134,'Bibala',16),(135,'Camucuio',16),(136,'Namibe',16),(137,'Tômbua',16),(138,'Virei',16),(139,'Alto Cauale',17),(140,'Ambuila',17),(141,'Bembe',17),(142,'Buengas',17),(143,'Bungo',17),(144,'Damba',17),(145,'Macocola',17),(146,'Mucaba',17),(147,'Negage',17),(148,'Puri',17),(149,'Quimbele',17),(150,'Quitexe',17),(151,'Sanza Pombo',17),(152,'Songo',17),(153,'Uige',17),(154,'Zombo',17),(155,'Cuimba',18),(156,'M\'Banza Kongo',18),(157,'Noqui',18),(158,'N\'Zeto',18),(159,'Soyo',18),(160,'Tomboco',18);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_paciente` varchar(45) DEFAULT NULL,
  `sobrenom_paciente` varchar(45) DEFAULT NULL,
  `data_nascimento_paciente` date DEFAULT NULL,
  `sexo_paciente` char(20) DEFAULT NULL,
  `email_paciente` varchar(45) DEFAULT NULL,
  `telefone_paciente` varchar(45) DEFAULT NULL,
  `rua_paciente` varchar(45) DEFAULT NULL,
  `casa_medico` varchar(45) DEFAULT NULL,
  `bairro_paciente` varchar(45) DEFAULT NULL,
  `distritito_paciente` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `fk_paciente_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_paciente_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `id_pais` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nome_pais` varchar(50) NOT NULL,
  `name_pais` varchar(50) NOT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'AFEGANISTÃO','AFGHANISTAN'),(2,'ACROTÍRI E DECELIA','AKROTIRI E DEKÉLIA'),(3,'ÁFRICA DO SUL','SOUTH AFRICA'),(4,'ALBÂNIA','ALBANIA'),(5,'ALEMANHA','GERMANY'),(6,'AMERICAN SAMOA','AMERICAN SAMOA'),(7,'ANDORRA','ANDORRA'),(8,'ANGOLA','ANGOLA'),(9,'ANGUILLA','ANGUILLA'),(10,'ANTÍGUA E BARBUDA','ANTIGUA AND BARBUDA'),(11,'ANTILHAS NEERLANDESAS','NETHERLANDS ANTILLES'),(12,'ARÁBIA SAUDITA','SAUDI ARABIA'),(13,'ARGÉLIA','ALGERIA'),(14,'ARGENTINA','ARGENTINA'),(15,'ARMÉNIA','ARMENIA'),(16,'ARUBA','ARUBA'),(17,'AUSTRÁLIA','AUSTRALIA'),(18,'ÁUSTRIA','AUSTRIA'),(19,'AZERBAIJÃO','AZERBAIJAN'),(20,'BAHAMAS','BAHAMAS, THE'),(21,'BANGLADECHE','BANGLADESH'),(22,'BARBADOS','BARBADOS'),(23,'BARÉM','BAHRAIN'),(24,'BASSAS DA ÍNDIA','BASSAS DA INDIA'),(25,'BÉLGICA','BELGIUM'),(26,'BELIZE','BELIZE'),(27,'BENIM','BENIN'),(28,'BERMUDAS','BERMUDA'),(29,'BIELORRÚSSIA','BELARUS'),(30,'BOLÍVIA','BOLIVIA'),(31,'BÓSNIA E HERZEGOVINA','BOSNIA AND HERZEGOVINA'),(32,'BOTSUANA','BOTSWANA'),(33,'BRASIL','BRAZIL'),(34,'BRUNEI DARUSSALAM','BRUNEI DARUSSALAM'),(35,'BULGÁRIA','BULGARIA'),(36,'BURQUINA FASO','BURKINA FASO'),(37,'BURUNDI','BURUNDI'),(38,'BUTÃO','BHUTAN'),(39,'CABO VERDE','CAPE VERDE'),(40,'CAMARÕES','CAMEROON'),(41,'CAMBOJA','CAMBODIA'),(42,'CANADÁ','CANADA'),(43,'CATAR','QATAR'),(44,'CAZAQUISTÃO','KAZAKHSTAN'),(45,'CENTRO-AFRICANA REPÚBLICA','CENTRAL AFRICAN REPUBLIC'),(46,'CHADE','CHAD'),(47,'CHILE','CHILE'),(48,'CHINA','CHINA'),(49,'CHIPRE','CYPRUS'),(50,'COLÔMBIA','COLOMBIA'),(51,'COMORES','COMOROS'),(52,'CONGO','CONGO'),(53,'CONGO REPÚBLICA DEMOCRÁTICA','CONGO DEMOCRATIC REPUBLIC'),(54,'COREIA DO NORTE','KOREA NORTH'),(55,'COREIA DO SUL','KOREA SOUTH'),(56,'COSTA DO MARFIM','IVORY COAST'),(57,'COSTA RICA','COSTA RICA'),(58,'CROÁCIA','CROATIA'),(59,'CUBA','CUBA'),(60,'DINAMARCA','DENMARK'),(61,'DOMÍNICA','DOMINICA'),(62,'EGIPTO','EGYPT'),(63,'EMIRADOS ÁRABES UNIDOS','UNITED ARAB EMIRATES'),(64,'EQUADOR','ECUADOR'),(65,'ERITREIA','ERITREA'),(66,'ESLOVÁQUIA','SLOVAKIA'),(67,'ESLOVÉNIA','SLOVENIA'),(68,'ESPANHA','SPAIN'),(69,'ESTADOS UNIDOS','UNITED STATES'),(70,'ESTÓNIA','ESTONIA'),(71,'ETIÓPIA','ETHIOPIA'),(72,'FAIXA DE GAZA','GAZA STRIP'),(73,'FIJI','FIJI'),(74,'FILIPINAS','PHILIPPINES'),(75,'FINLÂNDIA','FINLAND'),(76,'FRANÇA','FRANCE'),(77,'GABÃO','GABON'),(78,'GÂMBIA','GAMBIA'),(79,'GANA','GHANA'),(80,'GEÓRGIA','GEORGIA'),(81,'GIBRALTAR','GIBRALTAR'),(82,'GRANADA','GRENADA'),(83,'GRÉCIA','GREECE'),(84,'GRONELÂNDIA','GREENLAND'),(85,'GUADALUPE','GUADELOUPE'),(86,'GUAM','GUAM'),(87,'GUATEMALA','GUATEMALA'),(88,'GUERNSEY','GUERNSEY'),(89,'GUIANA','GUYANA'),(90,'GUIANA FRANCESA','FRENCH GUIANA'),(91,'GUINÉ','GUINEA'),(92,'GUINÉ EQUATORIAL','EQUATORIAL GUINEA'),(93,'GUINÉ-BISSAU','GUINEA-BISSAU'),(94,'HAITI','HAITI'),(95,'HONDURAS','HONDURAS'),(96,'HONG KONG','HONG KONG'),(97,'HUNGRIA','HUNGARY'),(98,'IÉMEN','YEMEN'),(99,'ILHA BOUVET','BOUVET ISLAND'),(100,'ILHA CHRISTMAS','CHRISTMAS ISLAND'),(101,'ILHA DE CLIPPERTON','CLIPPERTON ISLAND'),(102,'ILHA DE JOÃO DA NOVA','JUAN DE NOVA ISLAND'),(103,'ILHA DE MAN','ISLE OF MAN'),(104,'ILHA DE NAVASSA','NAVASSA ISLAND'),(105,'ILHA EUROPA','EUROPA ISLAND'),(106,'ILHA NORFOLK','NORFOLK ISLAND'),(107,'ILHA TROMELIN','TROMELIN ISLAND'),(108,'ILHAS ASHMORE E CARTIER','ASHMORE AND CARTIER ISLANDS'),(109,'ILHAS CAIMAN','CAYMAN ISLANDS'),(110,'ILHAS COCOS (KEELING)','COCOS (KEELING) ISLANDS'),(111,'ILHAS COOK','COOK ISLANDS'),(112,'ILHAS DO MAR DE CORAL','CORAL SEA ISLANDS'),(113,'ILHAS FALKLANDS (ILHAS MALVINAS)','FALKLAND ISLANDS (ISLAS MALVINAS)'),(114,'ILHAS FEROE','FAROE ISLANDS'),(115,'ILHAS GEÓRGIA DO SUL E SANDWICH DO SUL','SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS'),(116,'ILHAS MARIANAS DO NORTE','NORTHERN MARIANA ISLANDS'),(117,'ILHAS MARSHALL','MARSHALL ISLANDS'),(118,'ILHAS PARACEL','PARACEL ISLANDS'),(119,'ILHAS PITCAIRN','PITCAIRN ISLANDS'),(120,'ILHAS SALOMÃO','SOLOMON ISLANDS'),(121,'ILHAS SPRATLY','SPRATLY ISLANDS'),(122,'ILHAS VIRGENS AMERICANAS','UNITED STATES VIRGIN ISLANDS'),(123,'ILHAS VIRGENS BRITÂNICAS','BRITISH VIRGIN ISLANDS'),(124,'ÍNDIA','INDIA'),(125,'INDONÉSIA','INDONESIA'),(126,'IRÃO','IRAN'),(127,'IRAQUE','IRAQ'),(128,'IRLANDA','IRELAND'),(129,'ISLÂNDIA','ICELAND'),(130,'ISRAEL','ISRAEL'),(131,'ITÁLIA','ITALY'),(132,'JAMAICA','JAMAICA'),(133,'JAN MAYEN','JAN MAYEN'),(134,'JAPÃO','JAPAN'),(135,'JERSEY','JERSEY'),(136,'JIBUTI','DJIBOUTI'),(137,'JORDÂNIA','JORDAN'),(138,'KIRIBATI','KIRIBATI'),(139,'KOWEIT','KUWAIT'),(140,'LAOS','LAOS'),(141,'LESOTO','LESOTHO'),(142,'LETÓNIA','LATVIA'),(143,'LÍBANO','LEBANON'),(144,'LIBÉRIA','LIBERIA'),(145,'LÍBIA','LIBYAN ARAB JAMAHIRIYA'),(146,'LISTENSTAINE','LIECHTENSTEIN'),(147,'LITUÂNIA','LITHUANIA'),(148,'LUXEMBURGO','LUXEMBOURG'),(149,'MACAU','MACAO'),(150,'MACEDÓNIA','MACEDONIA'),(151,'MADAGÁSCAR','MADAGASCAR'),(152,'MALÁSIA','MALAYSIA'),(153,'MALAVI','MALAWI'),(154,'MALDIVAS','MALDIVES'),(155,'MALI','MALI'),(156,'MALTA','MALTA'),(157,'MARROCOS','MOROCCO'),(158,'MARTINICA','MARTINIQUE'),(159,'MAURÍCIA','MAURITIUS'),(160,'MAURITÂNIA','MAURITANIA'),(161,'MAYOTTE','MAYOTTE'),(162,'MÉXICO','MEXICO'),(163,'MIANMAR','MYANMAR BURMA'),(164,'MICRONÉSIA','MICRONESIA'),(165,'MOÇAMBIQUE','MOZAMBIQUE'),(166,'MOLDÁVIA','MOLDOVA'),(167,'MÓNACO','MONACO'),(168,'MONGÓLIA','MONGOLIA'),(169,'MONTENEGRO','MONTENEGRO'),(170,'MONTSERRAT','MONTSERRAT'),(171,'NAMÍBIA','NAMIBIA'),(172,'NAURU','NAURU'),(173,'NEPAL','NEPAL'),(174,'NICARÁGUA','NICARAGUA'),(175,'NÍGER','NIGER'),(176,'NIGÉRIA','NIGERIA'),(177,'NIUE','NIUE'),(178,'NORUEGA','NORWAY'),(179,'NOVA CALEDÓNIA','NEW CALEDONIA'),(180,'NOVA ZELÂNDIA','NEW ZEALAND'),(181,'OMÃ','OMAN'),(182,'PAÍSES BAIXOS','NETHERLANDS'),(183,'PALAU','PALAU'),(184,'PALESTINA','PALESTINE'),(185,'PANAMÁ','PANAMA'),(186,'PAPUÁSIA-NOVA GUINÉ','PAPUA NEW GUINEA'),(187,'PAQUISTÃO','PAKISTAN'),(188,'PARAGUAI','PARAGUAY'),(189,'PERU','PERU'),(190,'POLINÉSIA FRANCESA','FRENCH POLYNESIA'),(191,'POLÓNIA','POLAND'),(192,'PORTO RICO','PUERTO RICO'),(193,'PORTUGAL','PORTUGAL'),(194,'QUÉNIA','KENYA'),(195,'QUIRGUIZISTÃO','KYRGYZSTAN'),(196,'REINO UNIDO','UNITED KINGDOM'),(197,'REPÚBLICA CHECA','CZECH REPUBLIC'),(198,'REPÚBLICA DOMINICANA','DOMINICAN REPUBLIC'),(199,'ROMÉNIA','ROMANIA'),(200,'RUANDA','RWANDA'),(201,'RÚSSIA','RUSSIAN FEDERATION'),(202,'SAHARA OCCIDENTAL','WESTERN SAHARA'),(203,'SALVADOR','EL SALVADOR'),(204,'SAMOA','SAMOA'),(205,'SANTA HELENA','SAINT HELENA'),(206,'SANTA LÚCIA','SAINT LUCIA'),(207,'SANTA SÉ','HOLY SEE'),(208,'SÃO CRISTÓVÃO E NEVES','SAINT KITTS AND NEVIS'),(209,'SÃO MARINO','SAN MARINO'),(210,'SÃO PEDRO E MIQUELÃO','SAINT PIERRE AND MIQUELON'),(211,'SÃO TOMÉ E PRÍNCIPE','SAO TOME AND PRINCIPE'),(212,'SÃO VICENTE E GRANADINAS','SAINT VINCENT AND THE GRENADINES'),(213,'SEICHELES','SEYCHELLES'),(214,'SENEGAL','SENEGAL'),(215,'SERRA LEOA','SIERRA LEONE'),(216,'SÉRVIA','SERBIA'),(217,'SINGAPURA','SINGAPORE'),(218,'SÍRIA','SYRIA'),(219,'SOMÁLIA','SOMALIA'),(220,'SRI LANCA','SRI LANKA'),(221,'SUAZILÂNDIA','SWAZILAND'),(222,'SUDÃO','SUDAN'),(223,'SUÉCIA','SWEDEN'),(224,'SUÍÇA','SWITZERLAND'),(225,'SURINAME','SURINAME'),(226,'SVALBARD','SVALBARD'),(227,'TAILÂNDIA','THAILAND'),(228,'TAIWAN','TAIWAN'),(229,'TAJIQUISTÃO','TAJIKISTAN'),(230,'TANZÂNIA','TANZANIA'),(231,'TERRITÓRIO BRITÂNICO DO OCEANO ÍNDICO','BRITISH INDIAN OCEAN TERRITORY'),(232,'TERRITÓRIO DAS ILHAS HEARD E MCDONALD','HEARD ISLAND AND MCDONALD ISLANDS'),(233,'TIMOR-LESTE','TIMOR-LESTE'),(234,'TOGO','TOGO'),(235,'TOKELAU','TOKELAU'),(236,'TONGA','TONGA'),(237,'TRINDADE E TOBAGO','TRINIDAD AND TOBAGO'),(238,'TUNÍSIA','TUNISIA'),(239,'TURKS E CAICOS','TURKS AND CAICOS ISLANDS'),(240,'TURQUEMENISTÃO','TURKMENISTAN'),(241,'TURQUIA','TURKEY'),(242,'TUVALU','TUVALU'),(243,'UCRÂNIA','UKRAINE'),(244,'UGANDA','UGANDA'),(245,'URUGUAI','URUGUAY'),(246,'USBEQUISTÃO','UZBEKISTAN'),(247,'VANUATU','VANUATU'),(248,'VENEZUELA','VENEZUELA'),(249,'VIETNAME','VIETNAM'),(250,'WALLIS E FUTUNA','WALLIS AND FUTUNA'),(251,'ZÂMBIA','ZAMBIA'),(252,'ZIMBABUÉ','ZIMBABWE');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Bengo'),(2,'Benguela'),(3,'Bié'),(4,'Cabinda'),(5,'Cuando Cubango'),(6,'Cuanza Norte'),(7,'Cuanza Sul'),(8,'Cunene'),(9,'Huambo'),(10,'Huila'),(11,'Luanda'),(12,'Lunda Norte'),(13,'Lunda Sul'),(14,'Malange'),(15,'Moxico'),(16,'Namibe'),(17,'Uige'),(18,'Zaire');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quarto`
--

DROP TABLE IF EXISTS `quarto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quarto` (
  `id_quarto` int(11) NOT NULL AUTO_INCREMENT,
  `sigla_quarto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_quarto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quarto`
--

LOCK TABLES `quarto` WRITE;
/*!40000 ALTER TABLE `quarto` DISABLE KEYS */;
/*!40000 ALTER TABLE `quarto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita`
--

DROP TABLE IF EXISTS `receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receita` (
  `id_receita` int(11) NOT NULL AUTO_INCREMENT,
  `data_receita` varchar(45) DEFAULT NULL,
  `id_medico` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  PRIMARY KEY (`id_receita`),
  KEY `fk_receita_medico1_idx` (`id_medico`),
  KEY `fk_receita_paciente1_idx` (`id_paciente`),
  CONSTRAINT `fk_receita_medico1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`),
  CONSTRAINT `fk_receita_paciente1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita`
--

LOCK TABLES `receita` WRITE;
/*!40000 ALTER TABLE `receita` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hospitalx'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-10  1:38:46
