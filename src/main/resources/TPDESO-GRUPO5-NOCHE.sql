-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: tpdeso
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebida` (
  `graduacion_alcoholica` double DEFAULT NULL,
  `id` int NOT NULL,
  `tamano` double NOT NULL,
  `volumen` double NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKddnsfn5fuym1dtcy5clwsjmmn` FOREIGN KEY (`id`) REFERENCES `item_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (0,1,500,500),(0,2,500,500),(0,3,500,500),(0,4,1500,1500),(30,5,500,500),(15,6,500,500),(20,7,500,500),(0,8,500,500),(0,9,473,473),(0,10,473,473),(0,11,473,473),(0,12,300,300),(0,13,300,300),(0,14,300,300),(0,15,500,500),(0,16,1000,1000),(0,17,1000,1000),(0,18,1000,1000);
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `tipo_categoria` enum('COMIDA','BEBIDA') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bebida Con Alcohol','Esta bebida es con alcohol, prohibido su consumo en menores','BEBIDA'),(2,'Bebida Sin Alcohol','Esta bebida es sin alcohol','BEBIDA'),(3,'Comida Vegana','Esta comida es vegana','COMIDA'),(4,'Comida Vegetariana','Esta comida es vegetariana, no apta para veganos','COMIDA'),(5,'Comida Clasica','Esta comida no es apta para vegetarianos, ni apta para veganos','COMIDA');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `activo` bit(1) DEFAULT NULL,
  `coordenada_Id` int DEFAULT NULL,
  `fecha_eliminacion` date DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `cuit` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_as537scmvws7al2fgsv91u4aj` (`cuit`),
  UNIQUE KEY `UK_cmxo70m08n43599l3h0h07cc6` (`email`),
  UNIQUE KEY `UK_ivki0r9ovptaggmy0a5whlwrk` (`coordenada_Id`),
  CONSTRAINT `FKljn9nq2n1qeemt4va8ui14fro` FOREIGN KEY (`coordenada_Id`) REFERENCES `coordenada` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (_binary '',6,NULL,'2024-12-13',1,'20-12345678-9','Calle Ficticia 123','cliente@example.com','Juan Pérez'),(_binary '',7,NULL,'2024-12-13',2,'20-23456789-0','Calle Imaginaria 456','cliente2@example.com','Maria Lopez'),(_binary '',8,NULL,'2024-12-13',3,'20-34567890-1','Calle Ejemplo 789','cliente3@example.com','Carlos Martinez'),(_binary '',9,NULL,'2024-12-13',4,'20-45678901-2','Avenida Falsa 321','cliente4@example.com','Ana Gomez'),(_binary '',10,NULL,'2024-12-13',5,'20-56789012-3','Boulevard Real 654','cliente5@example.com','Jose Fernandez'),(_binary '',11,NULL,'2024-12-13',6,'20-67890123-4','Calle Nueva 789','cliente6@example.com','Sofia Ramirez');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenada`
--

DROP TABLE IF EXISTS `coordenada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordenada` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenada`
--

LOCK TABLES `coordenada` WRITE;
/*!40000 ALTER TABLE `coordenada` DISABLE KEYS */;
INSERT INTO `coordenada` VALUES (1,40.7128,-74.006),(2,34.0522,-118.2437),(3,41.8781,-87.6298),(4,29.7604,-95.3698),(5,39.7392,-104.9903),(6,33.4484,-112.074),(7,47.6062,-122.3321),(8,32.7157,-117.1611),(9,25.7617,-80.1918),(10,37.7749,-122.4194),(11,36.1627,-86.7816);
/*!40000 ALTER TABLE `coordenada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_menu`
--

DROP TABLE IF EXISTS `item_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_menu` (
  `activo` bit(1) DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `fecha_eliminacion` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `precio` decimal(38,2) NOT NULL,
  `vendedor_id` int DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpbnpjo9l39h63eqw6xw1ce44h` (`categoria_id`),
  KEY `FK894qmcfjjvmfl9u98c4pr8xgg` (`vendedor_id`),
  CONSTRAINT `FK894qmcfjjvmfl9u98c4pr8xgg` FOREIGN KEY (`vendedor_id`) REFERENCES `vendedor` (`id`),
  CONSTRAINT `FKpbnpjo9l39h63eqw6xw1ce44h` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_menu`
--

LOCK TABLES `item_menu` WRITE;
/*!40000 ALTER TABLE `item_menu` DISABLE KEYS */;
INSERT INTO `item_menu` VALUES (_binary '',2,NULL,1,150.00,1,'Refresco de cola','Coca Cola'),(_binary '',2,NULL,2,150.00,1,'Refresco sabor lima','Sprite'),(_binary '',2,NULL,3,150.00,1,'Refresco sabor naranja','Fanta'),(_binary '',2,NULL,4,25.00,1,'Refresco sabor uva','Manaos de Uva'),(_binary '',1,NULL,5,300.00,2,'Fernet con Coca-Cola','Fernet con Coca'),(_binary '',1,NULL,6,210.00,2,'Campari','Camari'),(_binary '',1,NULL,7,220.00,2,'VodKa con bebida energizante','Vodka con Speed'),(_binary '',2,NULL,8,150.00,3,'Bebida energizante','Speed'),(_binary '',2,NULL,9,180.00,3,'Bebida energizante Monster sabor comun','Monster'),(_binary '',2,NULL,10,180.00,3,'Bebida energizante Monster sin azucar','Monster Blanca'),(_binary '',2,NULL,11,200.00,3,'Bebida energizante Monster sabor mango','Monster Mango'),(_binary '',2,NULL,12,140.00,4,'Cafe negro','Cafe Cortado'),(_binary '',2,NULL,13,160.00,4,'Cafe Latte','Latte'),(_binary '',2,NULL,14,200.00,4,'Cafe de especialidad','Cafe Especial'),(_binary '',2,NULL,15,110.00,4,'Jugo de naranja exprimido a mano','Jugo de naranja'),(_binary '',2,NULL,16,150.00,5,'Refresco de cola','Pepsi'),(_binary '',2,NULL,17,150.00,5,'Refresco sabor lima','Seven-Up'),(_binary '',2,NULL,18,150.00,5,'Refresco sabor naranja','Mirinda'),(_binary '',5,NULL,19,300.00,1,'Empanadas de carne de res','Empanadasd de carne'),(_binary '',5,NULL,20,300.00,1,'Empanadas de jamon y queso','Empanadasd de jamon y queso'),(_binary '',5,NULL,21,300.00,1,'Sanguche de milanesa con tomate, lechuga y huevo','Sanguche de milanesa'),(_binary '',4,NULL,22,400.00,2,'Pizza Muzzarella','Pizza Muzzarella'),(_binary '',4,NULL,23,450.00,2,'Pizza con tomate y albahaca','Pizza Napolitana'),(_binary '',5,NULL,24,500.00,2,'Pizza jamon, queso y morron','Pizza Especial'),(_binary '',5,NULL,25,400.00,2,'Hamburguesa simple','Hamburguesa Simple'),(_binary '',5,NULL,26,600.00,2,'Hamburguesa con tomate, lechuga, cebolla crispy, huevo y panceta','Hamburguesa Completa'),(_binary '',4,NULL,27,80.00,3,'Alfajor triple de la marca oreo','Alfajor Oreo triple'),(_binary '',4,NULL,28,80.00,3,'Alfajor triple de la marca terrabusi','Alfajor Terrabusi triple'),(_binary '',5,NULL,29,70.00,3,'Alfajor simple de la marca Rasta','Alfajor Rasta'),(_binary '',4,NULL,30,110.00,4,'Tostado de jamon y queso','Tostado Simple'),(_binary '',4,NULL,31,100.00,4,'Alfajor triple de la marca Havana','Alfajor Havana'),(_binary '',4,NULL,32,50.00,4,'Medialuna','Medialuna Salada'),(_binary '',3,NULL,33,300.00,4,'Cookies sin ningun alimento origen animal','Cookies Veganas'),(_binary '',4,NULL,34,300.00,5,'Empanadas de queso y choclo','Empanad de humita'),(_binary '',5,NULL,35,400.00,5,'Sanguche de lomo','Sanguche de lomo'),(_binary '',3,NULL,36,600.00,5,'Hamburguesa de lenteja','Hamburguesa Vegana'),(_binary '',5,NULL,37,350.00,5,'Papas fritas con cheddar y panceta','Papas con cheddar y panceta'),(_binary '',3,NULL,38,200.00,5,'Ensalada de quinoa, lentejas, tomate, pepino, pimiento, apio, cebolla morada y vinagreta','Ensalada Especial'),(_binary '',4,NULL,39,300.00,5,'Papas fritas con cheddar','Papas con cheddar');
/*!40000 ALTER TABLE `item_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_pedido` (
  `cantidad` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `itemMenu_id` int DEFAULT NULL,
  `pedido_item_pedido_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsbj3gxyhoauvauivis7u6llh3` (`itemMenu_id`),
  KEY `FKkmlu6k50xg49596c81f99ccc3` (`pedido_item_pedido_id`),
  CONSTRAINT `FKkmlu6k50xg49596c81f99ccc3` FOREIGN KEY (`pedido_item_pedido_id`) REFERENCES `pedido_item_pedido` (`id`),
  CONSTRAINT `FKsbj3gxyhoauvauivis7u6llh3` FOREIGN KEY (`itemMenu_id`) REFERENCES `item_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
INSERT INTO `item_pedido` VALUES (2,1,1,1),(1,2,5,2),(2,3,23,3),(6,4,28,4),(2,5,14,5),(2,6,31,6),(1,7,34,7),(1,8,39,8),(1,9,36,9),(2,10,5,10);
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `fecha` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `monto` decimal(38,2) NOT NULL,
  `tipo_pago` varchar(31) NOT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `cbu` varchar(255) DEFAULT NULL,
  `cuit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES ('2024-12-13',1,300.00,'Transferencia','Alias1','1234567890','20-12345678-9'),('2024-12-13',2,700.00,'MercadoPago','Alias2',NULL,NULL),('2024-12-13',3,480.00,'Transferencia','Alias3','1234567789','20-34567890-1'),('2024-12-13',4,840.00,'MercadoPago','Alias4',NULL,NULL),('2024-12-13',5,200.00,'MercadoPago','Alias5',NULL,NULL),('2024-12-13',6,700.00,'Transferencia','Alias6','1234567789','20-67890123-4');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `cliente_id` int DEFAULT NULL,
  `formaPago_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` enum('RECIBIDO','ACEPTADO','PREPARADO','ENVIADO','ENTREGADO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l752chqwanjowrjtlatpf4m6h` (`formaPago_id`),
  KEY `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id`),
  CONSTRAINT `FK30s8j2ktpay6of18lbyqn3632` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FK8ngb05xhkwek709x73yrclieu` FOREIGN KEY (`formaPago_id`) REFERENCES `pago` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1,1,'RECIBIDO'),(2,2,2,'RECIBIDO'),(3,3,3,'ENVIADO'),(4,4,4,'PREPARADO'),(5,5,5,'ENTREGADO'),(6,6,6,'ENTREGADO');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_item_pedido`
--

DROP TABLE IF EXISTS `pedido_item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_item_pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_pedido_id` int DEFAULT NULL,
  `pedido_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK42f51fj53l92vu2h9dl71nlmr` (`item_pedido_id`),
  KEY `FKchgyfxkh0mqinxtk2s71j81vs` (`pedido_id`),
  CONSTRAINT `FK42f51fj53l92vu2h9dl71nlmr` FOREIGN KEY (`item_pedido_id`) REFERENCES `item_pedido` (`id`),
  CONSTRAINT `FKchgyfxkh0mqinxtk2s71j81vs` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_item_pedido`
--

LOCK TABLES `pedido_item_pedido` WRITE;
/*!40000 ALTER TABLE `pedido_item_pedido` DISABLE KEYS */;
INSERT INTO `pedido_item_pedido` VALUES (1,1,1),(2,2,2),(3,3,2),(4,4,3),(5,5,4),(6,6,4),(7,7,4),(8,8,5),(9,9,6),(10,10,6);
/*!40000 ALTER TABLE `pedido_item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `aptoCeliaco` bit(1) NOT NULL,
  `aptoVegano` bit(1) NOT NULL,
  `aptoVegetariano` bit(1) NOT NULL,
  `calorias` double NOT NULL,
  `id` int NOT NULL,
  `peso` double NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK1ptfgl94ejfdtjsdokef2ijja` FOREIGN KEY (`id`) REFERENCES `item_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (_binary '\0',_binary '\0',_binary '\0',250,19,200),(_binary '\0',_binary '\0',_binary '\0',200,20,200),(_binary '\0',_binary '\0',_binary '\0',300,21,500),(_binary '\0',_binary '\0',_binary '',300,22,300),(_binary '\0',_binary '\0',_binary '',300,23,300),(_binary '\0',_binary '\0',_binary '\0',370,24,350),(_binary '\0',_binary '\0',_binary '\0',350,25,250),(_binary '\0',_binary '\0',_binary '\0',360,26,260),(_binary '\0',_binary '\0',_binary '',100,27,100),(_binary '\0',_binary '\0',_binary '',100,28,100),(_binary '\0',_binary '\0',_binary '',80,29,80),(_binary '\0',_binary '\0',_binary '\0',100,30,200),(_binary '\0',_binary '\0',_binary '',100,31,80),(_binary '\0',_binary '',_binary '\0',80,32,50),(_binary '\0',_binary '',_binary '\0',350,33,250),(_binary '\0',_binary '\0',_binary '',200,34,200),(_binary '\0',_binary '\0',_binary '',300,35,290),(_binary '\0',_binary '',_binary '\0',120,36,250),(_binary '',_binary '\0',_binary '\0',250,37,200),(_binary '',_binary '',_binary '\0',80,38,200),(_binary '',_binary '\0',_binary '',230,39,200);
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `activo` bit(1) DEFAULT NULL,
  `coordenada_Id` int DEFAULT NULL,
  `fecha_eliminacion` date DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_supmeyc4xs1rvuplpeo24ankw` (`direccion`),
  UNIQUE KEY `UK_1euuc8rbtpu8g4tq50ukyrwyf` (`coordenada_Id`),
  CONSTRAINT `FKqtf4ioukai7k93afl0mr7gfiy` FOREIGN KEY (`coordenada_Id`) REFERENCES `coordenada` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (_binary '',1,NULL,'2024-12-13',1,'Avenida Siempre Viva 742','Pedro Vendedor'),(_binary '',2,NULL,'2024-12-13',2,'Calle Principal 123','Laura Vendedora'),(_binary '',3,NULL,'2024-12-13',3,'Boulevard Central 456','Carlos Comerciante'),(_binary '',4,NULL,'2024-12-13',4,'Avenida del Sol 789','Ana Vendedora'),(_binary '',5,NULL,'2024-12-13',5,'Plaza Mayor 101','Jorge Empresario');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tpdeso'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-13 20:51:09
