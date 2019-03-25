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
INSERT INTO `zsi_test_case` VALUES (72,'testUpdateTestcase23','PUT','/update','{\"Content-Type\":\"application/json\"}','{\"id\": 139,\"suite\": \"testcase\",\"testModule\": \"query\",\"descs\": \"GET接口请求测试\",\"testname\": \"test\",\"method\": \"GET\"}','2019-02-08 17:54:56','2019-03-10 16:59:05','',NULL,NULL,'testcase','update','PUT接口请求测试',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]','[\"插入一条数据测试\"]',NULL),(73,'GivenNonExistedIdThenNoTestcase','GET','/testcase/id/','{\"Content-Type\":\"application/json\",\"Accept\":\"application/json\"}','{\"id\":\"73\"}','2019-02-08 18:01:35','2019-02-08 18:01:35','',NULL,NULL,'TestCase','QueryById','根据不存在的Id查询不到任何测试用例',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(74,'getAllTestCases','POST','/testcase/all','{\"c\":\"er\"}','{\"c\":\"er\"}','2019-02-09 18:39:35','2019-02-09 19:22:21','',NULL,NULL,'POC_Info','ederew','用户名密码错误登录失败1234',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(75,'WhenUsernamePasswordFalseThenLoginFail','GET','/user/login','{\"hello\":\"1\"}','{\"hello\":\"1\"}','2019-02-09 19:22:21','2019-02-09 19:22:21','',NULL,NULL,'TestCase','ederew','用户名密码错误登录失败1234',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(76,'dsfdsf','POST','/testcase/all','{\"hello\":\"123\"}','{\"hello\":\"123\"}','2019-02-09 19:22:21','2019-02-09 19:39:24','',NULL,NULL,'POC_User','ederew','dsfsf',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(77,'dsfdsf232','POST','/user/login','{\"hello\":\"123\"}','{\"hello\":\"123\"}','2019-02-09 19:22:21','2019-02-09 19:22:21','',NULL,NULL,'POC_Use','ederew','用户名密码错误登录失败1234',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(79,'TestGivenExistedIdThenGetTestCase','GET','/testcase/id/','{\"hello\":\"1\"}','{\"id\":\"${testCaseId}\"}','2019-02-18 11:21:35','2019-02-18 11:21:35','',NULL,NULL,'POC_User','QueryById','根据存在的Id获取测试用例',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(80,'WhenUsernamePasswordFalseThenLoginFails','POST','/user/login','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 16:53:52','2019-02-19 16:53:52','',NULL,NULL,'POC_User',NULL,'用户名密码错误登录失败',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(81,'WhenUsernamePasswordFalseThenLoginSuccess','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:08:10','2019-02-19 17:08:10','',NULL,NULL,'POC_User',NULL,'根据存在的id查询数据',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(82,'WhenUsernamePasswordFalseThenLoginSuccess23','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:09:38','2019-02-19 17:09:38','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(83,'WhenUsernamePasswordFalseThenLoginSuccess236','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:17:32','2019-02-19 17:17:32','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,'[\"插入一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(84,'WhenUsernamePasswordFalseThenLoginSuccess2367','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${id}\"}','2019-02-19 17:29:26','2019-02-19 17:29:26','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(85,'WhenUsernamePasswordFalseThenLo4444','GET','/user/id','{\"Content-Type\":\"application/json\"}','{\"id\":\"${testCaseId}\"}','2019-02-19 17:31:10','2019-02-19 17:31:10','',NULL,NULL,'POC_User','query','根据存在的id查询数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(90,'WhenIdExistsThenReturnTestCaseData','GET','/testcase/id/','{\"Content-Type\":\"application/json\"}','{\"id\":\"${testCaseId}\"}','2019-02-20 16:55:15','2019-02-20 16:55:15','',NULL,NULL,'testcase','query','根据存在的id查询数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(92,'testtest','GET','/testcase/id/','{\"Content-Type\":\"application/json\"}','{\"id\":\"${testCaseId}\"}','2019-02-27 14:05:55','2019-02-27 14:05:55','',NULL,NULL,'testcase','query','测试插入验证数据',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]',NULL,NULL),(139,'test','GET','/testcases/','{\"Content-Type\":\"application/json\"}','${testCaseId}','2019-03-06 14:09:10','2019-03-06 14:09:10','',2,'2019-03-18 16:48:11','testcase','query','GET接口请求测试',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"data.testName\",\"expected\":\"test\"}]','[\"插入一条数据测试\",\"获取插入数据的id\"]','[\"功能测试\"]'),(140,'testPostPreAction','POST','/prepostaction/create','{\"Content-Type\":\"application/json\"}','{\"name\": \"测试插入数据的id\",\"descs\": \"测试在上一步骤中，插入到数据表中的数据的id值,为了能在后置动作中，根据id值清除这条数据，保持测试数据库干净\",\"actionType\": \"SQL\",\"action\": {\"type\": \"SqlPrePostAction\",\"host\": \"localhost\",\"port\": \"3306\",\"database\": \"tplatform_pro\",\"user\": \"root\",\"password\": \"tx123456\",\"sql\": \"SELECT id FROM tplatform_pro.zsi_test_case WHERE testname=\'test\'\"}}','2019-03-06 14:33:42','2019-03-06 14:33:42','',NULL,NULL,'prepostaction','create','POST接口请求测试:测试新增前置动作',NULL,'[\"删除插入的新增前置动作数据\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"data.testName\",\"expected\":\"test\"}]',NULL,NULL),(144,'testDeleteTestCase','GET','/testcase/delete/','{\"Content-Type\":\"application/json\"}','${testCaseId}','2019-03-06 16:36:14','2019-03-06 16:36:14','',NULL,NULL,'testcase','delete','DELETE接口请求测试',NULL,NULL,'[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]','[\"插入一条数据测试\",\"获取插入数据的id\"]',NULL),(145,'testUpdateTestcase','PUT','/update','{\"Content-Type\":\"application/json\"}','{\"id\": 139,\"suite\": \"testcase\",\"testModule\": \"query\",\"descs\": \"GET接口请求测试\",\"testname\": \"test\",\"method\": \"GET\"}','2019-03-06 17:27:10','2019-03-06 17:27:10','',NULL,NULL,'testcase','update','PUT接口请求测试',NULL,'[\"删除一条数据测试\"]','[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"testname\",\"expected\":\"test\"}]','[\"插入一条数据测试\"]',NULL);
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

-- Dump completed on 2019-03-25 16:46:59
