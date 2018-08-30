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
-- Table structure for table `wsi`
--

DROP TABLE IF EXISTS `wsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wsi` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `begin` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `numberofparticipants` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wsi`
--

LOCK TABLES `wsi` WRITE;
/*!40000 ALTER TABLE `wsi` DISABLE KEYS */;
INSERT INTO `wsi` VALUES (1,'Региональные профессиональные соревнования','2016-09-01 09:00:00','2016-10-31 00:00:00','www.worldskills-france.org','Региональные Чемпионаты проводятся с января по октябрь 2016 года в разных городах страны. Пожалуйста, для получения более подробной информации о мероприятиях и датах их проведения  смотрите официальный сайт',999),(2,'Национальный чемпионат Австралии','2016-10-06 09:00:00','2016-10-08 00:00:00','http://www.worldskills.org.au/media-release-melbourne-to-host-the-nations-largest-trades-and-skills-challenge/','Melbourne Showgrounds, Australia',110),(3,'Национальный чемпионат Норвегии','2016-10-17 09:00:00','2016-10-20 00:00:00','http://www.worldskills.no/','',985),(4,'Национальный чемпионат Японии','2016-10-21 09:00:00','2016-10-24 00:00:00','http://www.javada.or.jp/','Yamagata City, Tendo City, Sagae City, Yamanobe  Town.',771),(5,'Национальный Чемпионат Японии Абилимпикс','2016-10-28 09:00:00','2016-10-30 00:00:00','www.javada.or.jp','Yamagata City (Yamagata General Sports Center, Yamagata Big Wing, Tendo City (Yamagata Prefectural General Sports Park)',181),(6,'Национальный Чемпионат Бразилии 2016','2016-11-10 09:00:00','2016-11-13 00:00:00','portaldaindustria.com.br','Г. Бразилиа, Бразилия.',383),(7,'The Skills Show UK – национальный чемпионат Великобритании','2016-11-17 09:00:00','2016-11-19 00:00:00','www.theskillsshow.com','NEC, North Ave, Marston Green, Birmingham B40 1NT, Verenigd Koninkrijk,',842),(8,'Национальный Чемпионат Австрии','2016-11-20 09:00:00','2016-11-23 00:00:00','https://www.wko.at/Content.Node/SkillsAustria/Berufe-Termine-Orte.html','Messezentrum Salzburg GmbH, Am Messezentrum 1, 5020 Salzburg, Oostenrijk',430),(9,'Чемпионат EuroSkills 2016','2016-11-30 09:00:00','2016-12-04 00:00:00','euroskills2016.com','M?ssans Gata/Korsv?gen, 412 94 G?teborg',962),(10,'Национальный Чемпионат Ирландии','2016-12-07 09:00:00','2016-12-10 00:00:00','www.facebook.com','Institute of Technology, Dublin and Cork, Ireland',878),(11,'Национальный Чемпионат Южной Африки','2017-01-25 09:00:00','2017-01-29 00:00:00',' www.worldskillssa.dhet.gov.za',' ICC Centre, Durban, South Africa',473),(12,'Национальный Чемпионат Дании','2017-01-30 09:00:00','2017-02-01 00:00:00','http://skillsdenmark.dev2.companyoung.com/skillsdenmark/','Gigantium (Einsteins Boulevard / Aalborg), Denmark',525),(13,'Неделя подготовки к Чемпионату','2017-02-02 09:00:00','2017-02-07 00:00:00','www.emiratesskills.ae','Abu Dhabi, United Arab Emirates',261),(14,'День профессиональной подготовки и образования Австрии','2017-02-07 09:00:00','2017-02-08 00:00:00','','BERNEXPO AG, Mingerstrasse 6, 3014 Bern, Zwitserland',416),(15,'Финал Национального Чемпионата Франции 2017','2017-03-09 09:00:00','2017-03-11 00:00:00','www.worldskills-france.org','Parc des Expositions de Bordeaux, Cours Charles Bricaud, 33300 Bordeaux, Frankrijk',233),(16,'Чемпионат Skills Heroes 2017','2017-03-16 09:00:00','2017-03-18 00:00:00','http://www.skillsheroes.nl','RAI, Europaplein 22, 1078 GZ Amsterdam, Nederland',856),(17,'Финал Национального Чемпионата Латвии 2017','2017-04-20 09:00:00','2017-04-22 00:00:00','http://www.viaa.gov.lv/lat/','BT 1, ??psalas iela 8, Kurzemes rajons, R?ga, LV-1048, Letland',991),(18,'Чемпионат Skill Star 2017','2017-04-24 09:00:00','2017-04-26 00:00:00','','HUNGEXPO Budapest Fair Center, Budapest, Albertirsai ?t 10, 1101 Hongarije',753),(19,'Национальный  Чемпионат Финляндии Taitaja 2017','2017-05-15 09:00:00','2017-05-18 00:00:00','http://taitaja2017.fi','Messukeskus, 00101 Helsinki, Finland',359),(20,'Генеральная Ассамблея WorldSkills Europe 2017','2017-05-19 09:00:00','2017-05-22 00:00:00','',' Namen, Belgi?',897),(21,'Национальный Чемпионат Гонконга 2017','2017-06-16 09:00:00','2017-06-17 00:00:00','www.worldskillshongkong.org','Hong Kong Convention and Exhibition Centre, Hong Kong, Hong Kong SAR China',263),(22,'International World Youth Skills Day –  Международный День Рабочих профессий для молодежи','2017-07-15 09:00:00','2017-07-16 00:00:00','','',808),(23,'Международный  Профессиональный Чемпионат «Chair 2017»','2017-10-05 09:00:00','2017-10-06 00:00:00','','Riga, Letland',127),(24,'Международный Чемпионат Абу-Даби 2017','2017-10-14 09:00:00','2017-10-19 00:00:00','www.worldskillsabudhabi2017.com','Abu Dhabi National Exhibition Centre (ADNEC), Abu Dhabi, United Arab Emirates',207),(25,' Чемпионат ССЗ, Катар','2018-03-01 09:00:00','2018-03-02 00:00:00','','',352),(26,'Чемпионат EuroSkills 2018','2018-09-16 09:00:00','2018-09-30 00:00:00','euroskills2018.com','HUNGEXPO Budapest Fair Center',473),(27,'45-ый Мировой Чемпионат WorldSkills Казань 2019','2019-08-18 09:00:00','2019-08-23 00:00:00','http://worldskillskazan2019.org','Казань-Экспо, г., Казань, Россия',230),(28,'Чемпионат ССЗ, Кувейт','2020-03-01 09:00:00','2020-03-02 00:00:00','www.emiratesskills.ae','',119),(29,'Чемпионат EuroSkills 2020','2020-09-16 09:00:00','2020-09-20 00:00:00','euroskills2020.com','',233);
/*!40000 ALTER TABLE `wsi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-31  7:23:29
