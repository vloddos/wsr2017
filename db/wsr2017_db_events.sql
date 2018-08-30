-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: wsr2017_db
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `events` (
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES ('Avtotech Krasnodar','22-я Выставка автозапчастей, оборудования, инструментов, автокомпонентов, грузового и пассажирского транспорта','12 –14 октября 2016','www.avtotech-krasnodar.ru\r'),('Beauty Show Krasnodar','16-я Выставка оборудования и материалов для эстетической косметологии, парикмахерского и ногтевого сервиса','01 –04 июня 2016','www.beautyshow.su\r'),('CleanExpo Krasnodar','Международная выставка оборудования и материалов для профессиональной уборки, санитарии, гигиены, химической чистки и стирки','25 –27 апреля 2016','cleanexpo-krasnodar.ru\r'),('FoodTech Krasnodar','19-я Выставка оборудования, материалов и ингредиентов для производства продуктов питания и напитков','25 –27 апреля 2016','foodtech-krasnodar.ru\r'),('Indecor Krasnodar','2-я Выставка предметов интерьера и декора','29 марта –01 апреля 2016','www.indecor-krasnodar.ru\r'),('InterFood Krasnodar','6-я Выставка продуктов питания и напитков','25 –27 апреля 2016','www.inter-food.su\r'),('Securika Krasnodar','9-я Выставка технических средств охраны и оборудования для обеспечения безопасности и противопожарной защиты','27 февраля –02 марта 2017','www.securika-krasnodar.ru\r'),('UMIDS','20-я Международная выставка мебели, материалов, комплектующих и оборудования для деревообрабатывающего и мебельного производства','29 марта –01 апреля 2016','www.umids.ru\r'),('Vinorus','20-я Выставка вин и алкогольных напитков','25 –27 апреля 2016','www.vinorus.ru\r'),('WorldBuild Krasnodar/YugBuild','28-я Международная выставка строительных и отделочных материалов, инженерного оборудования и архитектурных проектов','27 февраля –02 марта 2017','www.worldbuild-krasnodar.ru\r'),('Дентима Краснодар','17-я Стоматологическая выставка','24 –26 мая 2016','www.dentima.su\r'),('Кубаньпродэкспо','10-я Выставка продуктов питания и напитков производителей Краснодарского края','25 –27 апреля 2016','www.kubanprodexpo.ru\r'),('Медима Краснодар','16-я Медицинская выставка','24 –26 мая 2016','www.medima.su\r'),('ФермаЭкспо Краснодар','1-я Выставка оборудования, кормов и ветеринарной продукции для животноводства и птицеводства','25 –27 октября 2016','farming-expo.ru\r'),('Ювелирный салон','7-я Выставка ювелирных изделий, драгоценных и полудрагоценных камней','01 –04 июня 2016','www.juwel-expo.ru\r'),('ЮГАГРО','24-я Международная выставка сельскохозяйственной техники, оборудования и материалов для производства и переработки растениеводческой сельхозпродукции','28 ноября –01 декабря 2016','www.yugagro.org\r');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-31  7:23:30
