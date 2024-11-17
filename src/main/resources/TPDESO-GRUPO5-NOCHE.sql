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
-- Table structure for table `bebidas`
--

DROP TABLE IF EXISTS `bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas` (
  `graduacion_alcoholica` double DEFAULT NULL,
  `id` int NOT NULL,
  `tamano` double NOT NULL,
  `volumen` double NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK33nickisglywfoy1qykspiaxu` FOREIGN KEY (`id`) REFERENCES `item_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebidas`
--

LOCK TABLES `bebidas` WRITE;
/*!40000 ALTER TABLE `bebidas` DISABLE KEYS */;
INSERT INTO `bebidas` VALUES (0,1,500,500);
/*!40000 ALTER TABLE `bebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `tipo_categoria` enum('COMIDA','BEBIDA') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Bebida refrescante','Refresco','BEBIDA');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
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
  UNIQUE KEY `UK_gyd3a0j31wia5uooyjtn1tx2n` (`cuit`),
  UNIQUE KEY `UK_1c96wv36rk2hwui7qhjks3mvg` (`email`),
  UNIQUE KEY `UK_n33lbswy2hbgaflgfjr0er4ev` (`coordenada_Id`),
  CONSTRAINT `FKnwcx792tywe7x7scc6j1ahrct` FOREIGN KEY (`coordenada_Id`) REFERENCES `coordenadas` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (_binary '',1,NULL,'2024-11-16',1,'20-12345678-9','Calle Ficticia 123','cliente@example.com','Juan Pérez');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenadas`
--

DROP TABLE IF EXISTS `coordenadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordenadas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenadas`
--

LOCK TABLES `coordenadas` WRITE;
/*!40000 ALTER TABLE `coordenadas` DISABLE KEYS */;
INSERT INTO `coordenadas` VALUES (1,40.7128,-74.006);
/*!40000 ALTER TABLE `coordenadas` ENABLE KEYS */;
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
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7j1h9sa5m8msueq9nd932iglq` (`categoria_id`),
  CONSTRAINT `FKon5dabempi8x30c6bvbt4gf5` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_menu`
--

LOCK TABLES `item_menu` WRITE;
/*!40000 ALTER TABLE `item_menu` DISABLE KEYS */;
INSERT INTO `item_menu` VALUES (_binary '',1,NULL,1,150.00,'Refresco de cola','Coca Cola');
/*!40000 ALTER TABLE `item_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedidos`
--

DROP TABLE IF EXISTS `item_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_pedidos` (
  `cantidad` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `itemMenu_id` int DEFAULT NULL,
  `pedido_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t6k8ytkxxlipugmuw6tc2f2ts` (`itemMenu_id`),
  UNIQUE KEY `UK_sr6dxf67cv9quvi1yayj88t6u` (`pedido_id`),
  CONSTRAINT `FK2jkjrhp9cilk5takus14v07my` FOREIGN KEY (`itemMenu_id`) REFERENCES `item_menu` (`id`),
  CONSTRAINT `FK7ylgn3j6ex8abgl3mg8bgw7bv` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedidos`
--

LOCK TABLES `item_pedidos` WRITE;
/*!40000 ALTER TABLE `item_pedidos` DISABLE KEYS */;
INSERT INTO `item_pedidos` VALUES (2,1,1,1);
/*!40000 ALTER TABLE `item_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_vendedor`
--

DROP TABLE IF EXISTS `item_vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_vendedor` (
  `activo` bit(1) NOT NULL,
  `fecha_eliminacion` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `item_menu_id` int NOT NULL,
  `vendedor_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8d8o2qwqewtd9yu3xerjfbpey` (`item_menu_id`),
  KEY `FKeymy3e1awyktakkisrnpiqlhp` (`vendedor_id`),
  CONSTRAINT `FK8d8o2qwqewtd9yu3xerjfbpey` FOREIGN KEY (`item_menu_id`) REFERENCES `item_menu` (`id`),
  CONSTRAINT `FKeymy3e1awyktakkisrnpiqlhp` FOREIGN KEY (`vendedor_id`) REFERENCES `vendedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_vendedor`
--

LOCK TABLES `item_vendedor` WRITE;
/*!40000 ALTER TABLE `item_vendedor` DISABLE KEYS */;
INSERT INTO `item_vendedor` VALUES (_binary '',NULL,1,1,1);
/*!40000 ALTER TABLE `item_vendedor` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES ('2024-11-16',1,300.00,'Transferencia','Alias1','1234567890','20-12345678-9');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
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
  KEY `FK7oriqqq6jj9ealnhcgexkoinc` (`item_pedido_id`),
  KEY `FKb0k043isdhnivq1sf71p31vl3` (`pedido_id`),
  CONSTRAINT `FK7oriqqq6jj9ealnhcgexkoinc` FOREIGN KEY (`item_pedido_id`) REFERENCES `item_pedidos` (`id`),
  CONSTRAINT `FKb0k043isdhnivq1sf71p31vl3` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_item_pedido`
--

LOCK TABLES `pedido_item_pedido` WRITE;
/*!40000 ALTER TABLE `pedido_item_pedido` DISABLE KEYS */;
INSERT INTO `pedido_item_pedido` VALUES (1,1,1);
/*!40000 ALTER TABLE `pedido_item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `cliente_id` int DEFAULT NULL,
  `formaPago_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` enum('RECIBIDO','ACEPTADO','PREPARADO','ENVIADO','ENTREGADO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q9n4v56r7nh9dyfdgplfidxfv` (`cliente_id`),
  UNIQUE KEY `UK_hmr8y6x4ckxnis77ap989abiy` (`formaPago_id`),
  CONSTRAINT `FKg7202lk0hwxn04bmdl2thth5b` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FKqb13b57iym7k9o7ungjxafgu1` FOREIGN KEY (`formaPago_id`) REFERENCES `pago` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,1,'RECIBIDO');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platos`
--

DROP TABLE IF EXISTS `platos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platos` (
  `aptoCeliaco` bit(1) NOT NULL,
  `aptoVegano` bit(1) NOT NULL,
  `aptoVegetariano` bit(1) NOT NULL,
  `calorias` double NOT NULL,
  `id` int NOT NULL,
  `peso` double NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKostps9ikhybach46yp9pt5h2j` FOREIGN KEY (`id`) REFERENCES `item_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platos`
--

LOCK TABLES `platos` WRITE;
/*!40000 ALTER TABLE `platos` DISABLE KEYS */;
INSERT INTO `platos` VALUES (_binary '',_binary '',_binary '',250,1,150);
/*!40000 ALTER TABLE `platos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `activo` bit(1) DEFAULT NULL,
  `coordenada_Id` int DEFAULT NULL,
  `fecha_eliminacion` date DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3susmms8afurbti1oijgfdna` (`direccion`),
  UNIQUE KEY `UK_iss65x7pnd72f6xe7j9g67rvh` (`coordenada_Id`),
  CONSTRAINT `FK2ksh1oww1ct1gjnuwupvofmhf` FOREIGN KEY (`coordenada_Id`) REFERENCES `coordenadas` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (_binary '',1,NULL,'2024-11-16',1,'Avenida Siempre Viva 742','Pedro Vendedor');
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-16 21:21:21
