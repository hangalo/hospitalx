CREATE DATABASE  IF NOT EXISTS `hospitalx` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hospitalx`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitalx
-- ------------------------------------------------------
-- Server version	8.0.20

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
  `id_agenda_consulta` int NOT NULL AUTO_INCREMENT,
  `id_especialidade` int NOT NULL,
  `id_medico` int NOT NULL,
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
  `id_cama` int NOT NULL AUTO_INCREMENT,
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
  `id_categoria_medicamento` int NOT NULL,
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
  `id_consulta` int NOT NULL AUTO_INCREMENT,
  `data_consulta` date DEFAULT NULL,
  `id_funcionario` int NOT NULL,
  `id_paciente` int NOT NULL,
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
  `id_detalhes_internamento_enfermeiro` int NOT NULL AUTO_INCREMENT,
  `data_visita` date DEFAULT NULL,
  `cura_feita` varchar(45) DEFAULT NULL,
  `id_internamento` int NOT NULL,
  `id_enfermeiro` int NOT NULL,
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
  `iddetalhes_internamento_medico` int NOT NULL AUTO_INCREMENT,
  `data_visita` date DEFAULT NULL,
  `observacao_feita` varchar(45) DEFAULT NULL,
  `id_internamento` int NOT NULL,
  `id_medico` int NOT NULL,
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
  `id_detalhes_receita` int NOT NULL AUTO_INCREMENT,
  `id_receita` int NOT NULL,
  `id_medicamento` int NOT NULL,
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
  `id_enfermeiro` int NOT NULL AUTO_INCREMENT,
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
  `id_municipio` int NOT NULL,
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
  `id_especialidade` int NOT NULL AUTO_INCREMENT,
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
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
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
  `id_municipio` int NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_funcionario_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_funcionario_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internamento`
--

DROP TABLE IF EXISTS `internamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `internamento` (
  `id_internamento` int NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `id_quarto` int NOT NULL,
  `id_cama` int NOT NULL,
  `id_paciente` int NOT NULL,
  `id_medico` int NOT NULL,
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
  `id_medicamento` int NOT NULL,
  `nome_medicamento` varchar(45) DEFAULT NULL,
  `data_expira_medicamento` varchar(45) DEFAULT NULL,
  `preco_medicamento` double DEFAULT NULL,
  `id_categoria_medicamento` int NOT NULL,
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
  `id_medico` int NOT NULL AUTO_INCREMENT,
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
  `id_municipio` int NOT NULL,
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
  `id_municipio` int NOT NULL AUTO_INCREMENT,
  `nome_municipio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id_paciente` int NOT NULL AUTO_INCREMENT,
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
  `id_municipio` int NOT NULL,
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
-- Table structure for table `quarto`
--

DROP TABLE IF EXISTS `quarto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quarto` (
  `id_quarto` int NOT NULL AUTO_INCREMENT,
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
  `id_receita` int NOT NULL AUTO_INCREMENT,
  `data_receita` varchar(45) DEFAULT NULL,
  `id_medico` int NOT NULL,
  `id_paciente` int NOT NULL,
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-11 15:10:30
