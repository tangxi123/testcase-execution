-- MySQL dump 10.13  Distrib 5.6.14, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tplatform
-- ------------------------------------------------------
-- Server version	5.6.14-log

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
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `test` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'tests');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_case`
--

DROP TABLE IF EXISTS `test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testname` varchar(100) NOT NULL,
  `method` varchar(50) NOT NULL,
  `url` varchar(100) NOT NULL DEFAULT '',
  `headers` varchar(255) DEFAULT '',
  `parameters` text,
  `expected` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `actual` varchar(255) DEFAULT '',
  `is_passed` tinyint(1) DEFAULT NULL,
  `test_at` datetime DEFAULT NULL,
  `suite` varchar(100) DEFAULT NULL,
  `test_module` varchar(100) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `status_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `test_case_id_uindex` (`id`),
  UNIQUE KEY `test_case_testname_uindex` (`testname`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_case`
--

LOCK TABLES `test_case` WRITE;
/*!40000 ALTER TABLE `test_case` DISABLE KEYS */;
INSERT INTO `test_case` VALUES (14,'WhenUsernamePasswordFalseThenLoginFails','POST','/user/login','{\"Content-Type\":\"application/json\"}','{\"username\":\"admin1\",\"password\":\"0192023a7bbd73250516f069df18b500\"}','{\"code\":400,\"error\":{\"code\":\"USER_SERVER_10002\",\"reason\":\"账号或密码错误\"},\"status\":\"error\"}','2018-12-06 16:36:39','2019-02-05 18:00:53','',NULL,NULL,'POC_User','login','用户名密码错误登录失败','200'),(17,'WhenUsernamePasswordFalseThenLoginFail','POST','/user/login','{\"Content-Type\":\"application/json\"}','{\"username\":\"admin1\",\"password\":\"0192023a7bbd73250516f069df18b500\"}','{\"error\":{\"code\":\"USER_SERVER_10002\",\"reason\":\"账号或密码错误\"},\"status\":\"error\"}','2018-12-06 16:41:47','2019-02-05 18:15:05','',NULL,NULL,'POC_User',NULL,'用户名密码错误登录失败哈哈哈','400'),(18,'WhenUsernameNullThenLoginFail','POST','/user/login','{\"Content-Type\":\"application/json\"}','{\"username\":\"\",\"password\":\"0192023a7bbd73250516f069df18b500\"}','{\"error\":{\"code\":\"USER_SERVER_10002\",\"reason\":\"账号或密码错误\"},\"status\":\"error\"}','2018-12-06 16:44:14','2018-12-06 16:44:14','',NULL,NULL,'POC_User','login','用户名为空密码不为空登录失败','400'),(19,'WhenPasswordNullThenLoginFail','POST','/user/login','{\"Content-Type\":\"application/json\"}','{\"username\":\"admin\",\"password\":\"\"}','{\"error\":{\"code\":\"USER_SERVER_10002\",\"reason\":\"账号或密码错误\"},\"status\":\"error\"}','2018-12-06 16:45:07','2018-12-06 16:45:07','',NULL,NULL,'POC_User','login','密码为空用户名不为空登录失败','400'),(21,'WheninfoidThengetNullInfo','GET','/info/newDetail','{\"Content-Type\":\"application/json\"}','{\"id\":\"ff91ec2d977eafe8823413f3c0805700\"}','{\"result\":{\"id\":\"\",\"title\":\"\"},\"status\":\"success\"}','2018-12-18 10:39:07','2018-12-18 10:39:07','',NULL,NULL,'POC_Info','newDetail','查询不存在的infoId','400'),(22,'ThenGetCodes','GET','/pageSyscode/getCodes','{\"Content-Type\":\"application/json\"}','{}','{\"result\":{\"collectUnitType\":[{\"value\":0,\"text\":\"国保\",\"key\":\"PROTECTION\"},{\"value\":1,\"text\":\"技侦\",\"key\":\"INVESTIGATION\"},{\"value\":2,\"text\":\"网安\",\"key\":\"NETWORK_SAFE\"},{\"value\":3,\"text\":\"其他警种\",\"key\":\"OTHER_POLICE\"},{\"value\":4,\"text\":\"国安\",\"key\":\"COUNTRY_SAFE\"},{\"value\":5,\"text\":\"部通报\",\"key\":\"REPORT\"},{\"value\":6,\"text\":\"平台开源采集\",\"key\":\"OPEN\"}],\"infoSourceType\":[{\"value\":0,\"text\":\"开源情报\",\"key\":\"OPEN\"},{\"value\":1,\"text\":\"秘密情报\",\"key\":\"SECRET\"},{\"value\":2,\"text\":\"平台情报\",\"key\":\"PLATFORM\"}],\"dealStatus\":[{\"value\":0,\"text\":\"已处理\",\"key\":\"DONE\"},{\"value\":1,\"text\":\"未处理\",\"key\":\"UNDONE\"},{\"value\":2,\"text\":\"忽略\",\"key\":\"IGNORE\"}],\"infoSourceSonType\":[{\"value\":0,\"text\":\"境内网站\",\"key\":\"OPEN_CHINA\"},{\"value\":1,\"text\":\"境外网站\",\"key\":\"OPEN_FOREIGN\"},{\"value\":2,\"text\":\"OCR识别\",\"key\":\"OPEN_OCR\"},{\"value\":3,\"text\":\"技术情报\",\"key\":\"SECRET_TECH\"},{\"value\":4,\"text\":\"人力情报\",\"key\":\"SECRET_HUMAN\"},{\"value\":5,\"text\":\"513动态数据\",\"key\":\"PLATFORM_ZPLAN\"},{\"value\":6,\"text\":\"涉稳平台数据\",\"key\":\"PLATFORM_STABLE\"}],\"carryType\":[{\"value\":0,\"text\":\"文字\",\"key\":\"CHARACTER\"},{\"value\":1,\"text\":\"图片\",\"key\":\"PIC\"},{\"value\":2,\"text\":\"图表\",\"key\":\"TABLE\"},{\"value\":3,\"text\":\"音频\",\"key\":\"AUDIO\"},{\"value\":4,\"text\":\"视频\",\"key\":\"VEDIO\"},{\"value\":5,\"text\":\"地图\",\"key\":\"MAP\"}],\"element\":[{\"value\":0,\"text\":\"时间\",\"key\":\"Time\"},{\"value\":1,\"text\":\"人物\",\"key\":\"Person\"},{\"value\":2,\"text\":\"组织\",\"key\":\"Organization\"},{\"value\":3,\"text\":\"职位\",\"key\":\"Job\"},{\"value\":4,\"text\":\"地点\",\"key\":\"Location\"},{\"value\":5,\"text\":\"来源\",\"key\":\"Source\"},{\"value\":6,\"text\":\"物品\",\"key\":\"Object\"},{\"value\":7,\"text\":\"采集单位\",\"key\":\"Collector\"},{\"value\":8,\"text\":\"活动对象\",\"key\":\"Subject\"},{\"value\":9,\"text\":\"事件\",\"key\":\"Event\"}]},\"status\":\"success\"}','2018-12-18 18:06:22','2018-12-18 18:06:22','',NULL,NULL,'PageSyscode','getCodes','获取码表','200'),(25,'GivenNoInfoArticleIdWhenGetThenFindArticle','GET','/info/findArticle','{\"Content-Type\":\"application/json\"}','{\"id\":\"e1949fa466f445b1ac975ebbb212d508\"}','{\"status\":\"success\"}','2018-12-19 11:01:14','2018-12-19 11:01:14','',NULL,NULL,'POC_Info','findArticle','查询不存在基础信息的物品','200'),(26,'GivenInfosArticleIdWhenGetThenFindArticle','GET','/info/findArticle','{\"Content-Type\":\"application/json\"}','{\"id\":\"1628a48921f7e6f25376d37c4296ce23\"}','{\"result\":{\"niBelonger\":\"的沙发斯蒂芬\",\"niCreator\":\"东方闪电\",\"niNumber\":\"1628a48921f7e6f25376d37c4296ce23\",\"niPicList\":[{\"nipId\":\"40\",\"nipDesc\":\"2b尼尔机械纪元简约3440x1440壁纸_彼岸图网.jpg\"},{\"nipId\":\"41\",\"nipDesc\":\"2B小姐尼尔3440x1440壁纸_彼岸图网.jpg\"}]},\"status\":\"success\"}','2018-12-19 11:11:26','2018-12-19 11:11:26','',NULL,NULL,'POC_Info','findArticle','查询存在基础信息的物品','200'),(27,'GivenNotExistsArticleIdWhenGetThenFindArticle','GET','/info/findArticle','{\"Content-Type\":\"application/json\"}','{\"id\":\"1628a48921f7e6f25376d37c42900000\"}','{\"status\":\"success\"}','2018-12-19 11:15:34','2018-12-19 11:15:34','',NULL,NULL,'POC_Info','findArticle','查询不存在的物品','200'),(28,'GivenAllDateWhenGetThenCountAllDateCarryType','GET','/info/groupByCarryType','{\"Content-Type\":\"application/json\"}','{\"startDay\":\"${allDateBegin}\",\"endDay\":\"${allDateEnd}\"}','{\"result\":[{\"day\":null,\"count\":20,\"sourceId\":null,\"source\":\"文字\"}],\"status\":\"success\"}','2018-12-20 09:45:04','2018-12-20 09:45:04','',NULL,NULL,'POC_Info','groupByCarryType','查询所有时间范围的信息载体','200'),(30,'GivenYesterdayWhenGetThenCountYesterdayCarryType','GET','/info/groupByCarryType','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"yesterday\"}','{\"result\":[],\"status\":\"success\"}','2018-12-20 09:58:22','2018-12-20 09:58:22','',NULL,NULL,'POC_Info','groupByCarryType','查询昨天的信息载体数据统计','200'),(31,'GivenWeekWhenGetThenCountWeekCarryType','GET','/info/groupByCarryType','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"week\"}','{\"result\":[{\"day\":null,\"count\":1,\"sourceId\":null,\"source\":\"文字\"}],\"status\":\"success\"}','2018-12-20 10:02:32','2018-12-20 10:02:32','',NULL,NULL,'POC_Info','groupByCarryType','查询本周的信息载体数据统计','200'),(36,'GivenAllDateWhenGetThenCountAllDateInfoSourceType','GET','/info/groupByInfoSourceType','{\"Content-Type\":\"application/json\"}','{\"startDay\":\"${allDateBegin}\",\"endDay\":\"${allDateEnd}\"}','{\"result\":{\"{\\\"day\\\":null,\\\"count\\\":20,\\\"sourceId\\\":null,\\\"source\\\":\\\"OPEN\\\"}\":[{\"day\":null,\"count\":20,\"sourceId\":null,\"source\":\"OPEN_CHINA\"}]},\"status\":\"success\"}','2018-12-20 10:08:32','2018-12-20 10:08:32','',NULL,NULL,'POC_Info','groupByInfoSourceType','查询所有时间范围内的一级来源下面的二级来源分组统计数据','200'),(37,'GivenTodayWhenGetThenCountTodayInfoSourceType','GET','/info/groupByInfoSourceType','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"today\"}','{\"result\":{},\"status\":\"success\"}','2018-12-20 10:08:32','2018-12-20 10:08:32','',NULL,NULL,'POC_Info','groupByInfoSourceType','查询今天的一级来源下面的二级来源分组统计数据','200'),(38,'GivenYesterdayWhenGetThenCountYesterdayInfoSourceType','GET','/info/groupByInfoSourceType','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"yesterday\"}','{\"result\":{},\"status\":\"success\"}','2018-12-20 10:08:32','2018-12-20 10:08:32','',NULL,NULL,'POC_Info','groupByInfoSourceType','查询昨天的一级来源下面的二级来源分组统计数据','200'),(39,'GivenWeekWhenGetThenCountWeekInfoSourceType','GET','/info/groupByInfoSourceType','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"week\"}','{\"result\":{\"{\\\"day\\\":null,\\\"count\\\":1,\\\"sourceId\\\":null,\\\"source\\\":\\\"OPEN\\\"}\":[{\"day\":null,\"count\":1,\"sourceId\":null,\"source\":\"OPEN_CHINA\"}]},\"status\":\"success\"}','2018-12-20 10:08:32','2018-12-20 10:08:32','',NULL,NULL,'POC_Info','groupByInfoSourceType','查询本周的一级来源下面的二级来源分组统计数据','200'),(40,'GivenAllDateWhenGetThenCountAllDateRootEvent','GET','/info/groupByRootEvent','{\"Content-Type\":\"application/json\"}','{\"startDay\":\"${allDateBegin}\",\"endDay\":\"${allDateEnd}\"}','{\"result\":[{\"day\":null,\"count\":137,\"sourceId\":null,\"source\":\"境内涉藏活动\"},{\"day\":null,\"count\":22,\"sourceId\":null,\"source\":\"达赖集团活动\"},{\"day\":null,\"count\":11,\"sourceId\":null,\"source\":\"藏区政务信息\"}],\"status\":\"success\"}','2018-12-20 10:22:14','2018-12-20 10:22:14','',NULL,NULL,'POC_Info','groupByRootEvent','查询所有时间范围内的数据集市统计数据','200'),(41,'GivenTodayWhenGetThenCountTodayRootEvent','GET','/info/groupByRootEvent','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"today\"}','{\"result\":[],\"status\":\"success\"}','2018-12-20 10:22:14','2018-12-20 10:22:14','',NULL,NULL,'POC_Info','groupByRootEvent','查询今天的数据集市统计数据','200'),(42,'GivenYesterdayThenGetThenCountYesterdayRootEvent','GET','/info/groupByRootEvent','{\"Content-Type\":\"application/json\"}','{\"dateType\":\"yesterday\"}','{\"result\":[],\"status\":\"success\"}','2018-12-20 10:22:14','2018-12-20 10:22:14','',NULL,NULL,'POC_Info','groupByRootEvent','查询昨天的数据集市统计数据','200'),(50,'GivenNotExistedNiNameWhenPostThenFindANoArticle','POST','/info/queryArticleList','{\"Content-Type\":\"application/json\"}','{\"niName\":\"巧克力\",\"dealStatus\":\"DONE\"}','{\"result\":[],\"status\":\"success\"}','2018-12-20 11:07:31','2018-12-20 11:07:31','',NULL,NULL,'POC_Info','queryArticleList','查询不存在的物品list','200'),(51,'GivenExistedLocationWhenGetThenFindLocationInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Location\",\"id\":\"a70f867c412c82049f5ef1ca5b4f83ec\"}','{\"result\":{\"infoId\":null,\"elementId\":\"a70f867c412c82049f5ef1ca5b4f83ec\",\"type\":null,\"text\":\"壤塘县\",\"cleandText\":null,\"frequency\":0,\"codeLevel1\":156,\"codeLevel2\":510000,\"codeLevel3\":513200,\"codeLevel4\":513230,\"codeLevel5\":null,\"positions\":null,\"dealStatus\":\"DONE\",\"country\":null,\"province\":null,\"city\":null,\"area\":null,\"street\":null,\"docx\":null,\"id\":null,\"name\":null,\"status\":null,\"firstFound\":false},\"status\":\"success\"}','2018-12-20 11:20:45','2018-12-20 11:20:45','',NULL,NULL,'POC_Info','queryElementInfo','查询存在的Location详情','200'),(52,'GivenNotExistedLocationWhenGetThenFindNoLocationInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Location\",\"id\":\"a70f867c412c82049f5ef1ca5b4f0000\"}','{\"result\":{\"infoId\":null,\"elementId\":null,\"type\":null,\"text\":null,\"cleandText\":null,\"frequency\":0,\"codeLevel1\":null,\"codeLevel2\":null,\"codeLevel3\":null,\"codeLevel4\":null,\"codeLevel5\":null,\"positions\":null,\"dealStatus\":null,\"country\":null,\"province\":null,\"city\":null,\"area\":null,\"street\":null,\"docx\":null,\"id\":null,\"name\":null,\"status\":null,\"firstFound\":false},\"status\":\"success\"}','2018-12-20 11:20:45','2018-12-20 11:20:45','',NULL,NULL,'POC_Info','queryElementInfo','查询不存在的Location详情','200'),(53,'GivenExistedOrganizationWhenGetThenFindOrganizationInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Organization\",\"id\":\"7b73c669bce2e797ebb40cfd12fd23e2\"}','{\"result\":{\"infoId\":null,\"elementId\":null,\"type\":null,\"text\":null,\"cleandText\":null,\"frequency\":0,\"codeLevel1\":null,\"codeLevel2\":null,\"codeLevel3\":null,\"codeLevel4\":null,\"codeLevel5\":null,\"positions\":null,\"dealStatus\":null,\"id\":\"7b73c669bce2e797ebb40cfd12fd23e2\",\"chinaName\":\"藏人行政中央歌剧学院\",\"englishName\":null,\"tbtName\":null,\"shortName\":null,\"props\":null,\"orgType\":null,\"partner\":null,\"foundDate\":null,\"foundAddress\":null,\"nowAddress\":null,\"founder\":null,\"sponsor\":null,\"chargerJob\":null,\"session\":null,\"suborgNums\":0,\"purpose\":null,\"website\":null,\"virtualNum\":null,\"telno\":null,\"email\":null,\"relationOrg\":null,\"bankNum\":null,\"authOrg\":null,\"innerDept\":null,\"addressDesc\":null,\"logo\":null,\"upOrg\":null,\"firstFound\":false},\"status\":\"success\"}','2018-12-20 11:28:26','2018-12-20 11:28:26','',NULL,NULL,'POC_Info','queryElementInfo','查询存在的Organization详情','200'),(54,'GivenNotExistedOrganizationWhenGetThenFindNoOrganizationInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Organization\",\"id\":\"7b73c669bce2e797ebb40cfd12fd2300\"}','{\"status\": \"success\"}','2018-12-20 11:28:26','2018-12-20 11:28:26','',NULL,NULL,'POC_Info','queryElementInfo','查询不存在的Organization详情','200'),(55,'GivenExistedPersonWhenGetThenFindPersonInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Person\",\"id\":\"0f622fa9137fd4cefcb2b942da9d7f83\"}','{\"result\":{\"infoId\":null,\"elementId\":null,\"type\":null,\"text\":null,\"cleandText\":null,\"frequency\":0,\"codeLevel1\":null,\"codeLevel2\":null,\"codeLevel3\":null,\"codeLevel4\":null,\"codeLevel5\":null,\"positions\":null,\"dealStatus\":null,\"userId\":\"0f622fa9137fd4cefcb2b942da9d7f83\",\"chinaName\":\"洛桑森格\",\"tbtName\":null,\"englishName\":null,\"aliasName\":null,\"dharmaName\":null,\"secularName\":null,\"gender\":null,\"identityCard\":null,\"country\":null,\"ethnic\":null,\"birthday\":null,\"brithAddr\":null,\"identity\":null,\"job\":null,\"nativeAddress\":null,\"censusAddress\":null,\"livingAddress\":null,\"telno\":null,\"extraInfo\":null,\"looks\":null,\"edu\":null,\"languageAbility\":null,\"height\":0,\"organization\":null,\"gang\":null,\"serviceAddress\":null,\"headIcon\":null,\"desc\":null,\"passport\":null,\"overseas\":0,\"jobDuty\":null,\"firstFound\":false},\"status\":\"success\"}','2018-12-20 11:35:15','2018-12-20 11:35:15','',NULL,NULL,'POC_Info','queryElementInfo','查询存在的Person详情','200'),(56,'GivenNotExistedPersonWhenGetThenFindNoPersonInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Person\",\"id\":\"0f622fa9137fd4cefcb2b942da9d7f00\"}','{\"status\": \"success\"}','2018-12-20 11:35:15','2018-12-20 11:35:15','',NULL,NULL,'POC_Info','queryElementInfo','查询不存在的Person详情','200'),(57,'GivenExistedObjectWhenGetThenFindObjectInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Objet\",\"id\":\"a2a9913140257c2afa7a86bafca8f924\"}','{\"result\":{\"infoId\":null,\"elementId\":null,\"type\":null,\"text\":null,\"cleandText\":null,\"frequency\":0,\"codeLevel1\":null,\"codeLevel2\":null,\"codeLevel3\":null,\"codeLevel4\":null,\"codeLevel5\":null,\"positions\":null,\"dealStatus\":null,\"niNumber\":\"a2a9913140257c2afa7a86bafca8f924\",\"niType\":\"skzz\",\"niProperty\":\"ryp\",\"niSource\":\"网站\",\"niName\":\"仁波切金奖\",\"niNums\":10,\"niDesc\":\"仁波切金奖杯\",\"niCreator\":\"淘宝\",\"niRelator\":\"西藏青年会\",\"niHoldStatus\":\"cy\",\"niHolder\":\"达赖喇嘛\",\"niBelonger\":\"达赖\",\"niDelStatus\":\"持有\",\"niPicList\":[{\"nipId\":45,\"niNumber\":\"a2a9913140257c2afa7a86bafca8f924\",\"nipPath\":\"http://192.168.31.100:8888/group1/M00/10/7E/wKgfZFwF8d2APeT7AAIFaEYu78k641.jpg\",\"nipDesc\":\"微信图片_20180121182509.jpg\",\"nipType\":null}],\"firstFound\":false},\"status\":\"success\"}','2018-12-20 11:41:52','2018-12-20 11:41:52','',NULL,NULL,'POC_Info','queryElementInfo','查询存在的Object详情','200'),(58,'GivenNotExistedObjectWhenGetThenFindNoObjectInfo','GET','/info/queryElementInfo','{\"Content-Type\":\"application/json\"}','{\"type\":\"Objet\",\"id\":\"a2a9913140257c2afa7a86bafca8f900\"}','{\"status\": \"success\"}','2018-12-20 11:41:52','2018-12-20 11:41:52','',NULL,NULL,'POC_Info','queryElementInfo','查询不存在的Object详情','200'),(59,'GivenNotExistedOrgRecordWhenGetThenFindNoOrgRecord','GET','info/queryElementOrgRecord','{\"Content-Type\":\"application/json\"}','{\"id\":\"1f316ae9ee28d69fbb0af0cb063b2195\"}','{\"result\":[],\"status\":\"success\"}','2018-12-21 12:32:21','2018-12-21 12:32:21','',NULL,NULL,'POC_Info','queryElementOrgRecord','查询不存在的历史组织沿革','200'),(60,'GivenOneExistedOrgRecordWhenGetThenFindOneOrgRecord','GET','info/queryElementOrgRecord','{\"Content-Type\":\"application/json\"}','{\"\"}','{\"\"}',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL),(69,'dfd','POST','/user/login','{\"a\":\"1\"}','{\"a\":\"1\"}','{\"a\":1}','2019-02-07 16:03:00','2019-02-07 16:03:00','',NULL,NULL,'dsfs','dsfdsdsfsda','eww',NULL),(70,'whenApisNormalThenInsertTestCaseSuccess','POST','http://localhost:8080','{\"Accept\":\"Application/json\",\"Content-Type\":\"Application/json\"}','{\"password\":\"123456\",\"username\":\"tangxi\"}','{\"success\":true,\"message\":\"登录成功\"}','2019-02-08 14:27:04','2019-02-08 14:27:04','',NULL,NULL,'authTestSuite','login',NULL,NULL),(71,'WhenUsernameAndPasswordTrueThenLogin','POST','http://localhost:8080','{\"Accept\":\"Application/json\",\"Content-Type\":\"Application/json\"}','{\"password\":\"123456\",\"username\":\"tangxi\"}','{\"success\":true,\"message\":\"登录成功\"}','2019-02-08 14:27:04','2019-02-08 14:27:04','',NULL,NULL,'authTestSuite','login',NULL,NULL);
/*!40000 ALTER TABLE `test_case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,2),(3,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(27,2),(28,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(27,2),(28,2),(29,2),(30,2),(31,2),(32,2),(33,2),(34,2),(35,2),(36,2),(37,2),(38,2),(39,2),(40,2),(41,2),(42,2),(43,2),(44,2),(45,2),(46,2),(47,2),(48,2),(49,2),(50,2),(51,2),(52,2),(53,2),(54,2),(55,2),(56,2),(57,2),(58,2),(59,2),(60,2),(61,2),(62,2),(63,2),(64,2),(65,2),(66,2),(67,2),(68,2),(69,2),(70,2),(71,2),(72,2),(73,2),(74,2),(75,2),(76,2),(77,2),(78,2),(79,2),(80,2),(4,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_id_uindex` (`id`),
  UNIQUE KEY `users_username_uindex` (`username`),
  UNIQUE KEY `users_email_uindex` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'tester','tester','123456','tester@163.com','2018-10-24 11:09:45','2018-10-24 11:09:45'),(3,'admin','amin','123456','admin@163.com','2018-10-24 11:10:05','2018-10-24 11:10:05'),(4,'tangxi','tangxi','123456','tangxi669@163.com','2019-02-08 14:27:04','2019-02-08 14:27:04');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zsi_parameter`
--

DROP TABLE IF EXISTS `zsi_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zsi_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `descs` text,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `zsi_parameter_id_uindex` (`id`),
  UNIQUE KEY `zsi_parameter_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zsi_parameter`
--

LOCK TABLES `zsi_parameter` WRITE;
/*!40000 ALTER TABLE `zsi_parameter` DISABLE KEYS */;
INSERT INTO `zsi_parameter` VALUES (17,'${testCaseId}','从数据库中获取第一条测试用例Id','SQL'),(19,'testCaseIds','从数据库中获取第一条测试用例Id','SQL'),(21,'testCaseId3','从数据库中获取第一条测试用例Id','SQL'),(24,'testCaseId4','从数据库中获取第一条测试用例Id','SQL'),(27,'testCaseId5','从数据库中获取第一条测试用例Id','SQL'),(29,'${testCaseId5}','从数据库中获取第一条测试用例Id','SQL'),(30,'testCaseId','从数据库中获取第一条测试用例Id','SQL');
/*!40000 ALTER TABLE `zsi_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zsi_parameter_type`
--

DROP TABLE IF EXISTS `zsi_parameter_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zsi_parameter_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `zsi_parameter_type_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zsi_parameter_type`
--

LOCK TABLES `zsi_parameter_type` WRITE;
/*!40000 ALTER TABLE `zsi_parameter_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `zsi_parameter_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zsi_parameter_type_sql`
--

DROP TABLE IF EXISTS `zsi_parameter_type_sql`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zsi_parameter_type_sql` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` varchar(100) NOT NULL,
  `port` int(11) NOT NULL,
  `database` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sql` text NOT NULL,
  `param` text,
  `param_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `zsi_parameter_type_sql_id_uindex` (`id`),
  KEY `zsi_parameter_type_sql_zsi_parameter__fk` (`param_id`),
  CONSTRAINT `zsi_parameter_type_sql_zsi_parameter__fk` FOREIGN KEY (`param_id`) REFERENCES `zsi_parameter` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zsi_parameter_type_sql`
--

LOCK TABLES `zsi_parameter_type_sql` WRITE;
/*!40000 ALTER TABLE `zsi_parameter_type_sql` DISABLE KEYS */;
INSERT INTO `zsi_parameter_type_sql` VALUES (5,'localhost',3306,'tplatform','root','tx123456','SELECT id FROM tplatform_pro.zsi_test_case LIMIT 1','id',17),(6,'localhost',3306,'tplatform','root','tx123456','SELECT id FROM zsi_test_case LIMIT 1','id',19),(7,'localhost',3306,'tplatform','root','tx123456','SELECT id FROM zsi_test_case LIMIT 1','id',21),(8,'localhost',3306,'tplatform','root','tx123456','SELECT id FROM zsi_test_case LIMIT 1','id',24),(9,'localhost',3306,'tplatform','root','tx123456','SELECT id FROM zsi_test_case LIMIT 1','id',27),(10,'localhost',3306,'tplatform','root','tx123456','SELECT id FROM zsi_test_case LIMIT 1','id',29),(11,'localhost',3306,'tplatform_pro','root','tx123456','SELECT id FROM tplatform_pro.zsi_test_case LIMIT 1','id',30);
/*!40000 ALTER TABLE `zsi_parameter_type_sql` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zsi_prepostaction`
--

DROP TABLE IF EXISTS `zsi_prepostaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zsi_prepostaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `descs` varchar(500) NOT NULL,
  `action_type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `zsi_prepostaction_id_uindex` (`id`),
  UNIQUE KEY `zsi_prepostaction_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zsi_prepostaction`
--

LOCK TABLES `zsi_prepostaction` WRITE;
/*!40000 ALTER TABLE `zsi_prepostaction` DISABLE KEYS */;
INSERT INTO `zsi_prepostaction` VALUES (3,'插入一条数据测试','在执行查询前需要插入一条数据','SQL'),(4,'删除一条数据测试','在测试执行后需要删除插入的数据','SQL'),(5,'获取插入数据的id','获取在上一步骤中，插入到数据表中的数据的id值,为了能在后置动作中，根据id值清除这条数据，保持测试数据库干净','SQL'),(11,'删除插入的新增前置动作数据','在测试时插入的前置动作测试数据删除掉','SQL');
/*!40000 ALTER TABLE `zsi_prepostaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zsi_prepostaction_type_sql`
--

DROP TABLE IF EXISTS `zsi_prepostaction_type_sql`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zsi_prepostaction_type_sql` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` varchar(100) NOT NULL,
  `port` int(11) NOT NULL,
  `database` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sql` text NOT NULL,
  `action_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `zsi_prepostaction_type_sql_id_uindex` (`id`),
  KEY `zsi_prepostaction_type_sql_zsi_prepostaction__fk` (`action_id`),
  CONSTRAINT `zsi_prepostaction_type_sql_zsi_prepostaction__fk` FOREIGN KEY (`action_id`) REFERENCES `zsi_prepostaction` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zsi_prepostaction_type_sql`
--

LOCK TABLES `zsi_prepostaction_type_sql` WRITE;
/*!40000 ALTER TABLE `zsi_prepostaction_type_sql` DISABLE KEYS */;
INSERT INTO `zsi_prepostaction_type_sql` VALUES (2,'localhost',3306,'tplatform_pro','root','tx123456','INSERT INTO tplatform_pro.zsi_test_case (test_name, method, url, headers, parameters, created_at, updated_at, actual, is_passed, test_at, suite, test_module, descs, status_code, post_action_names, check_points, pre_action_names) VALUES ( \'test\', \'GET\', \'/testcase/id/\', \'{\"Content-Type\":\"application/json\"}\', \'15\',  \'2019-03-06 12:33:01\', \'2019-03-06 12:33:01\', \'\', null, null, \'testcase\', \'query\', \'完整测试\', null, \'[\"删除一条数据测试\"]\', \'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"},{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STRNOTEQUAL\",\"checkKey\":\"descs\",\"expected\":\"完整测试\"},{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STRINCLUDE\",\"checkKey\":\"testModule\",\"expected\":\"ll\"},{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STRNOTINCLUDE\",\"checkKey\":\"method\",\"expected\":\"GET\"},{\"type\":\"NumCheckPoint\",\"numCheckPointType\":\"NUM_EQ\",\"checkKey\":\"number\",\"expected\":\"123.56\"},{\"type\":\"NumCheckPoint\",\"numCheckPointType\":\"NUM_GT\",\"checkKey\":\"number\",\"expected\":\"1.2\"},{\"type\":\"NumCheckPoint\",\"numCheckPointType\":\"NUM_LT\",\"checkKey\":\"number\",\"expected\":\"1\"},{\"type\":\"NumCheckPoint\",\"numCheckPointType\":\"NUM_GT_EQ\",\"checkKey\":\"number\",\"expected\":\"56.7\"},{\"type\":\"NumCheckPoint\",\"numCheckPointType\":\"NUM_LT_EQ\",\"checkKey\":\"number\",\"expected\":\"300.90\"},{\"type\":\"ListCheckPoint\",\"listCheckPointType\":\"LIST_SIZE\",\"checkKey\":\"checkPoints\",\"expected\":\"10\"},{\"type\":\"ListCheckPoint\",\"listCheckPointType\":\"LIST_CONTAINS\",\"checkKey\":\"checkPoints.type\",\"expected\":\"ListCheckPoint\"},{\"type\":\"ListCheckPoint\",\"listCheckPointType\":\"LIST_GET\",\"checkKey\":\"checkPoints\",\"expected\":\"{expected=test, type=StrCheckPoint, strCheckPointType=STREQUAL, checkKey=testname}\"}]\', \'[\"插入一条数据测试\",\"获取插入数据的id\"]\');',3),(3,'localhost',3306,'tplatform_pro','root','tx123456','DELETE FROM tplatform_pro.zsi_test_case WHERE id=${pre.id[0]} AND test_name=\'${pre.test_name[0]}\'',4),(4,'localhost',3306,'tplatform_pro','root','tx123456','SELECT id,test_name FROM tplatform_pro.zsi_test_case WHERE test_name=\'test\'',5),(7,'localhost',3306,'tplatform_pro','root','tx123456','DELETE FROM tplatform_pro.zsi_prepostaction WHERE name=\'测试插入数据的id\';',11);
/*!40000 ALTER TABLE `zsi_prepostaction_type_sql` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zsi_test_case`
--

DROP TABLE IF EXISTS `zsi_test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zsi_test_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(100) NOT NULL,
  `method` varchar(50) NOT NULL,
  `url` varchar(100) NOT NULL DEFAULT '',
  `headers` varchar(255) DEFAULT '',
  `parameters` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `actual` varchar(255) DEFAULT '',
  `is_passed` tinyint(1) DEFAULT NULL,
  `test_at` datetime DEFAULT NULL,
  `suite` varchar(100) DEFAULT NULL,
  `test_module` varchar(100) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `status_code` varchar(255) DEFAULT NULL,
  `post_action_names` text,
  `check_points` text,
  `pre_action_names` text,
  `groups` text,
  `base_url` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `test_case_id_uindex` (`id`),
  UNIQUE KEY `test_case_testname_uindex` (`test_name`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zsi_test_case`
--

LOCK TABLES `zsi_test_case` WRITE;
/*!40000 ALTER TABLE `zsi_test_case` DISABLE KEYS */;
INSERT INTO `zsi_test_case` VALUES (72,'testUpdateTestcase23','PUT','/update','{\"Content-Type\":\"application/json\"}','{\"id\": 139,\"suite\": \"testcase\",\"testModule\": \"query\",\"descs\": \"GET接口请求测试\",\"testname\": \"test\",\"method\": \"GET\"}','2019-02-08 17:54:56','2019-03-10 16:59:05','',NULL,NULL,'testcase','update','PUT接口请求测试',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]','[\"插入一条数据测试\"]',NULL,NULL),(73,'GivenNonExistedIdThenNoTestcase','GET','/testcase/id/','{\"Content-Type\":\"application/json\",\"Accept\":\"application/json\"}','{\"id\":\"73\"}','2019-02-08 18:01:35','2019-02-08 18:01:35','',NULL,NULL,'TestCase','QueryById','根据不存在的Id查询不到任何测试用例',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(74,'getAllTestCases','POST','/testcase/all','{\"c\":\"er\"}','{\"c\":\"er\"}','2019-02-09 18:39:35','2019-02-09 19:22:21','',NULL,NULL,'POC_Info','ederew','用户名密码错误登录失败1234',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(75,'WhenUsernamePasswordFalseThenLoginFail','GET','/user/login','{\"hello\":\"1\"}','{\"hello\":\"1\"}','2019-02-09 19:22:21','2019-02-09 19:22:21','',NULL,NULL,'TestCase','ederew','用户名密码错误登录失败1234',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(76,'dsfdsf','POST','/testcase/all','{\"hello\":\"123\"}','{\"hello\":\"123\"}','2019-02-09 19:22:21','2019-02-09 19:39:24','',NULL,NULL,'POC_User','ederew','dsfsf',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(77,'dsfdsf232','POST','/user/login','{\"hello\":\"123\"}','{\"hello\":\"123\"}','2019-02-09 19:22:21','2019-02-09 19:22:21','',NULL,NULL,'POC_Use','ederew','用户名密码错误登录失败1234',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(79,'TestGivenExistedIdThenGetTestCase','GET','/testcase/id/','{\"hello\":\"1\"}','{\"id\":\"${testCaseId}\"}','2019-02-18 11:21:35','2019-02-18 11:21:35','',NULL,NULL,'POC_User','QueryById','根据存在的Id获取测试用例',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(80,'WhenUsernamePasswordFalseThenLoginFails','POST','/user/login','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 16:53:52','2019-02-19 16:53:52','',NULL,NULL,'POC_User',NULL,'用户名密码错误登录失败',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(81,'WhenUsernamePasswordFalseThenLoginSuccess','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:08:10','2019-02-19 17:08:10','',NULL,NULL,'POC_User',NULL,'根据存在的id查询数据',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(82,'WhenUsernamePasswordFalseThenLoginSuccess23','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:09:38','2019-02-19 17:09:38','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(83,'WhenUsernamePasswordFalseThenLoginSuccess236','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:17:32','2019-02-19 17:17:32','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,'[\"插入一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(84,'WhenUsernamePasswordFalseThenLoginSuccess2367','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:29:26','2019-02-19 17:29:26','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(85,'WhenUsernamePasswordFalseThenLo4444','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${testCaseId}\"}','2019-02-19 17:31:10','2019-02-19 17:31:10','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(90,'WhenIdExistsThenReturnTestCaseData','GET','/testcase/id/','{\"Content-Type\":\"application/json\"}','{\"id\":\"${testCaseId}\"}','2019-02-20 16:55:15','2019-02-20 16:55:15','',NULL,NULL,'testcase','query','根据存在的id查询数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(92,'testtest','GET','/testcase/id/','{\"Content-Type\":\"application/json\"}','{\"id\":\"${testCaseId}\"}','2019-02-27 14:05:55','2019-02-27 14:05:55','',NULL,NULL,'testcase','query','测试插入验证数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL,NULL),(139,'test','GET','/testcases/','{\"Content-Type\":\"application/json\"}','${testCaseId}','2019-03-06 14:09:10','2019-03-06 14:09:10','',2,'2019-03-18 16:48:11','testcase','query','GET接口请求测试',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"data.testName\",\"expected\":\"test\"}]','[\"插入一条数据测试\",\"获取插入数据的id\"]','[\"功能测试\"]',NULL),(140,'testPostPreAction','POST','/prepostaction/create','{\"Content-Type\":\"application/json\"}','{\"name\": \"测试插入数据的id\",\"descs\": \"测试在上一步骤中，插入到数据表中的数据的id值,为了能在后置动作中，根据id值清除这条数据，保持测试数据库干净\",\"actionType\": \"SQL\",\"action\": {\"type\": \"SqlPrePostAction\",\"host\": \"localhost\",\"port\": \"3306\",\"database\": \"tplatform_pro\",\"user\": \"root\",\"password\": \"tx123456\",\"sql\": \"SELECT id FROM tplatform_pro.zsi_test_case WHERE testname=\'test\'\"}}','2019-03-06 14:33:42','2019-03-06 14:33:42','',NULL,NULL,'prepostaction','create','POST接口请求测试:测试新增前置动作',NULL,'[\"删除插入的新增前置动作数据\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"data.testName\",\"expected\":\"test\"}]',NULL,NULL,NULL),(144,'testDeleteTestCase','GET','/testcase/delete/','{\"Content-Type\":\"application/json\"}','${testCaseId}','2019-03-06 16:36:14','2019-03-06 16:36:14','',NULL,NULL,'testcase','delete','DELETE接口请求测试',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]','[\"插入一条数据测试\",\"获取插入数据的id\"]',NULL,NULL),(145,'testUpdateTestcase','PUT','/update','{\"Content-Type\":\"application/json\"}','{\"id\": 139,\"suite\": \"testcase\",\"testModule\": \"query\",\"descs\": \"GET接口请求测试\",\"testname\": \"test\",\"method\": \"GET\"}','2019-03-06 17:27:10','2019-03-06 17:27:10','',NULL,NULL,'testcase','update','PUT接口请求测试',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]','[\"插入一条数据测试\"]',NULL,'http://localhost:8081');
/*!40000 ALTER TABLE `zsi_test_case` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-25 16:56:36
