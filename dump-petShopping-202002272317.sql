-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: cis175.cetfhxntkuqz.us-east-2.rds.amazonaws.com    Database: petShopping
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
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pets` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(20) NOT NULL,
  `NAME` varchar(35) NOT NULL,
  `OWNER` varchar(35) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (3,'Bird','Tweety','Paigne'),(4,'Horse','George','Lee'),(9,'Cat','Lucky','Jung'),(10,'Dog','Rover','Smith'),(11,'Hamster','Pokey','King'),(12,'Monkey','Curios','YellowHat');
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets_on_list`
--

DROP TABLE IF EXISTS `pets_on_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pets_on_list` (
  `PETS_ID` int(11) NOT NULL,
  `OWNER_ID` int(11) NOT NULL,
  KEY `OWNER_ID` (`OWNER_ID`),
  KEY `PETS_ID` (`PETS_ID`),
  CONSTRAINT `pets_on_list_ibfk_1` FOREIGN KEY (`OWNER_ID`) REFERENCES `pets_owner` (`OWNER_ID`),
  CONSTRAINT `pets_on_list_ibfk_2` FOREIGN KEY (`PETS_ID`) REFERENCES `pets` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets_on_list`
--

LOCK TABLES `pets_on_list` WRITE;
/*!40000 ALTER TABLE `pets_on_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `pets_on_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets_owner`
--

DROP TABLE IF EXISTS `pets_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pets_owner` (
  `OWNER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OWNER_NAME` varchar(30) DEFAULT NULL,
  `OWNER_PHONE` varchar(11) DEFAULT NULL,
  `TRIP_DATE` date DEFAULT NULL,
  `PETS_SITTER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`OWNER_ID`),
  KEY `PETS_SITTER_ID` (`PETS_SITTER_ID`),
  CONSTRAINT `pets_owner_ibfk_1` FOREIGN KEY (`PETS_SITTER_ID`) REFERENCES `pets_sitter` (`PETS_SITTER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets_owner`
--

LOCK TABLES `pets_owner` WRITE;
/*!40000 ALTER TABLE `pets_owner` DISABLE KEYS */;
INSERT INTO `pets_owner` VALUES (9,'Ali','15152237868','2019-09-12',12);
/*!40000 ALTER TABLE `pets_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets_sitter`
--

DROP TABLE IF EXISTS `pets_sitter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pets_sitter` (
  `PETS_SITTER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PETS_SITTER_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`PETS_SITTER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets_sitter`
--

LOCK TABLES `pets_sitter` WRITE;
/*!40000 ALTER TABLE `pets_sitter` DISABLE KEYS */;
INSERT INTO `pets_sitter` VALUES (1,'Mary'),(2,'Mary'),(3,'James'),(4,'James'),(5,'John'),(6,'Jose'),(7,'Jose'),(8,''),(9,'Steven'),(10,'Don'),(11,'Peggy'),(12,'Josh');
/*!40000 ALTER TABLE `pets_sitter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'petShopping'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 23:17:57
