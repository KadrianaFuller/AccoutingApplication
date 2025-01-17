CREATE DATABASE  IF NOT EXISTS `ledger` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ledger`;
-- MySQL dump 10.13  Distrib 8.4.2, for Win64 (x86_64)
--
-- Host: localhost    Database: ledger
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `amount` double NOT NULL,
  `date` date NOT NULL,
  `time` time(6) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `vendor` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (9500,'2025-01-17','11:37:59.000000',1,'Cheque','Work'),(-75,'2024-10-17','20:32:48.000000',2,'IPen','Apple'),(-30,'2024-10-17','21:19:47.000000',3,'Keyboard','Apple'),(-1200,'2024-10-17','21:45:48.000000',4,'Iphone','Apple'),(-50,'2024-10-17','21:55:01.000000',5,'usb','hp'),(-200,'2024-10-29','09:10:05.000000',6,'Invoice','Apple'),(20,'2024-10-18','11:30:07.000000',7,'l','l'),(30,'2024-10-18','11:30:16.000000',8,'l','l'),(-500,'2024-10-18','12:54:08.000000',9,'Iphone','Apple'),(5000,'2024-10-18','12:55:06.000000',10,'Lights','TXU'),(60000,'2024-10-18','12:59:22.000000',11,'Paycheck','Google'),(-600,'2024-10-18','13:00:44.000000',12,'Tithes','SocialDallas'),(-12,'2025-01-17','11:11:40.000000',13,'Coffee','Coffee shop'),(-70,'2025-01-17','11:19:21.000000',14,'Video game','Steam'),(-24,'2025-01-17','11:23:34.000000',15,'Lunch','Chipotle'),(-13,'2025-01-17','11:29:57.000000',16,'Candy ','7-Eleven'),(10000,'2025-01-17','11:34:35.000000',17,'Paycheque','Workplace'),(-1700,'2025-01-17','11:36:13.000000',18,'Rent','Landlord'),(9000,'2025-01-17','11:37:09.000000',19,'Pay cheque','Work'),(9500,'2025-01-17','11:37:59.000000',20,'Cheque','Work');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 12:22:03
