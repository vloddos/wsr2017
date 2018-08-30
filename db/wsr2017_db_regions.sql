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
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `regions` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `capital` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `county` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (1,'Республика Адыгея','Майкоп','Южный'),(2,'Республика Башкортостан','Уфа','Приволжский'),(3,'Республика Бурятия','Улан-Удэ','Сибирский'),(4,'Республика Алтай','Горно-Алтайск','Сибирский'),(5,'Республика Дагестан','Махачкала','Северо-Кавказский'),(6,'Республика Ингушетия','Магас','Северо-Кавказский'),(7,'Кабардино-Балкарская Республика','Нальчик','Северо-Кавказский'),(8,'Республика Калмыкия','Элиста','Южный'),(9,'Республика Карачаево-Черкесия','Черкесск','Северо-Кавказский'),(10,'Республика Карелия','Петрозаводск','Северо-Западный'),(11,'Республика Коми','Сыктывкар','Северо-Западный'),(12,'Республика Марий Эл','Йошкар-Ола','Приволжский'),(13,'Республика Мордовия','Саранск','Приволжский'),(14,'Республика Саха (Якутия)','Якутск','Дальневосточный'),(15,'Республика Северная Осетия-Алания','Владикавказ','Северо-Кавказский'),(16,'Республика Татарстан','Казань','Приволжский'),(17,'Республика Тыва','Кызыл','Сибирский'),(18,'Удмуртская Республика','Ижевск','Приволжский'),(19,'Республика Хакасия','Абакан','Сибирский'),(20,'Чеченская республика','Грозный','Северо-Кавказский'),(21,'Чувашская Республика','Чебоксары','Приволжский'),(22,'Алтайский край','Барнаул','Сибирский'),(23,'Краснодарский край','Краснодар','Южный'),(24,'Красноярский край','Красноярск','Сибирский'),(25,'Приморский край','Владивосток','Дальневосточный'),(26,'Ставропольский край','Ставрополь','Северо-Кавказский'),(27,'Хабаровский край','Хабаровск','Дальневосточный'),(28,'Амурская область','Благовещенск','Дальневосточный'),(29,'Архангельская область','Архангельск','Северо-Западный'),(30,'Астраханская область','Астрахань','Южный'),(31,'Белгородская область','Белгород','Центральный'),(32,'Брянская область','Брянск','Центральный'),(33,'Владимирская область','Владимир','Центральный'),(34,'Волгоградская область','Волгоград','Южный'),(35,'Вологодская область','Вологда','Северо-Западный'),(36,'Воронежская область','Воронеж','Центральный'),(37,'Ивановская область','Иваново','Центральный'),(38,'Иркутская область','Иркутск','Сибирский'),(39,'Калининградская область','Калининград','Северо-Западный'),(40,'Калужская область','Калуга','Центральный'),(41,'Камчатский край','Петропавловск-Камчатский','Дальневосточный'),(42,'Кемеровская область','Кемерово','Сибирский'),(43,'Кировская область','Киров','Приволжский'),(44,'Костромская область','Кострома','Центральный'),(45,'Курганская область','Курган','Уральский'),(46,'Курская область','Курск','Центральный'),(47,'Ленинградская область','Санкт-Петербург','Северо-Западный'),(48,'Липецкая область','Липецк','Центральный'),(49,'Магаданская область','Магадан','Дальневосточный'),(50,'Московская область','Москва','Центральный'),(51,'Мурманская область','Мурманск','Северо-Западный'),(52,'Нижегородская область','Нижний Новгород','Приволжский'),(53,'Новгородская область','Великий Новгород','Северо-Западный'),(54,'Новосибирская область','Новосибирск','Сибирский'),(55,'Омская область','Омск','Сибирский'),(56,'Оренбургская область','Оренбург','Приволжский'),(57,'Орловская область','Орел','Центральный'),(58,'Пензенская область','Пенза','Приволжский'),(59,'Пермский край','Пермь','Приволжский'),(60,'Псковская область','Псков','Северо-Западный'),(61,'Ростовская область','Ростов-на-Дону','Южный'),(62,'Рязанская область','Рязань','Центральный'),(63,'Самарская область','Самара','Приволжский'),(64,'Саратовская область','Саратов','Приволжский'),(65,'Сахалинская область','Южно-Сахалинск','Дальневосточный'),(66,'Свердловская область','Екатеринбург','Уральский'),(67,'Смоленская область','Смоленск','Центральный'),(68,'Тамбовская область','Тамбов','Центральный'),(69,'Тверская область','Тверь','Центральный'),(70,'Томская область','Томск','Сибирский'),(71,'Тульская область','Тула','Центральный'),(72,'Тюменская область','Тюмень','Уральский'),(73,'Ульяновская область','Ульяновск','Приволжский'),(74,'Челябинская область','Челябинск','Уральский'),(75,'Читинская область','Чита','Сибирский'),(76,'Ярославская область','Ярославль','Центральный'),(77,'г. Москва','Москва','Центральный'),(78,'г. Санкт-Петербург','Санкт-Петербург','Северо-Западный'),(79,'Еврейская автономная область','Биробиджан','Дальневосточный'),(80,'Агинский Бурятский автономный округ','пгт Агинское','Сибирский'),(81,'Коми-Пермяцкий автономный округ','Кудымкар','Приволжский'),(82,'Корякский автономный округ','пгт Палана','Дальневосточный'),(83,'Ненецкий автономный округ','Нарьян-Мар','Северо-Западный'),(84,'Таймырский (Долгано-Ненецкий) автономный округ','Дудинка','Сибирский'),(85,'Таймырский (Долгано-Ненецкий) автономный округ','пгт Усть-Ордынский','Сибирский'),(86,'Ханты-Мансийский автономный округ - Югра','Ханты-Мансийск','Уральский'),(87,'Чукотский автономный округ','Анадырь','Дальневосточный'),(88,'Эвенкийский автономный округ','пгт Тура','Сибирский'),(89,'Ямало-Ненецкий автономный округ','Салехард','Уральский'),(91,'Республика Крым','Симферополь','Южный'),(92,'г.Севастополь','Севастополь','Южный');
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
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
