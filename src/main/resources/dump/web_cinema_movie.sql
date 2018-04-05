-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: web_cinema
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `startRelease` date DEFAULT NULL,
  `finishRelease` date DEFAULT NULL,
  `posterUrl` varchar(200) DEFAULT NULL,
  `trailerUrl` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Тор','боевик, приключения, фэнтези','Тору предстоит сразиться за спасение Земли и Девяти Миров от таинственного врага из времен, предшествовавших возникновению вселенной. После событий «Тора» и «Мстителей» главный герой борется за восстановление порядка в космосе, но древняя раса во главе с мстительным Малекитом возвращается, чтобы погрузить вселенную обратно во тьму. Столкнувшись с врагом, которому не способен противостоять ни Один, ни весь Асгард, Тор отправляется в самое рискованное путешествие, которое воссоединит его с Джейн Фостер с Земли и заставит пожертвовать всем ради спасения вселенной.',120,'1994-03-25','2018-01-31','thor','<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/y00d5f5qmIs\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>'),(2,'Невероятный Халк','боевик, приключения, фэнтези','После неудачного эксперимента с гамма-лучами учёный Брюс Беннер мутирует, превращаясь при гневе в зелёного монстра — Халка. Брюс скрывается от армии США, которая считает его своей собственностью. Он прячется в бразильских фавелах, постоянно проверяя свой пульс, чтобы он не достиг критического. Однажды он совершает ошибку, и генерал Росс выходит на его след, посылая отряд майора Блонски.',120,'1994-03-25','2018-01-31','hulk','<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/P6zUFiyXnIg\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>'),(3,'Одаренная','семейная драма','Фрэнк Адлер живет в прибрежном городке во Флориде и воспитывает в одиночку свою необычайно одаренную племянницу Мэри. Но планы парня о спокойной школьной жизни для девочки рушатся, когда о математических способностях ребенка узнает грозная мать Фрэнка Эвелин. У бабушки свои представления о будущем внучки, и ради этого она готова даже разлучить Мэри с Фрэнком.',120,'1994-03-25','2018-01-31','gifted','<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/Xu-VOKDUMe8\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>'),(4,'Остров проклятых','триллер, драмма, детектив','Два американских судебных пристава отправляются на один из островов в штате Массачусетс, чтобы расследовать исчезновение пациентки клиники для умалишенных преступников. При проведении расследования им придется столкнуться с паутиной лжи, обрушившимся ураганом и смертельным бунтом обитателей клиники.',120,'1994-03-25','2018-01-31','shutterIsland','<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/hZXgJVChNQc\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-01 18:14:23
