-- MySQL dump 10.13  Distrib 5.6.28, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: schoolmate
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.15.10.1

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
-- Current Database: `schoolmate`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `schoolmate` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `schoolmate`;

--
-- Table structure for table `adminstaff`
--

DROP TABLE IF EXISTS `adminstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminstaff` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(20) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`adminid`),
  UNIQUE KEY `UserID` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminstaff`
--

LOCK TABLES `adminstaff` WRITE;
/*!40000 ALTER TABLE `adminstaff` DISABLE KEYS */;
/*!40000 ALTER TABLE `adminstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignments` (
  `assignmentid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `title` varchar(15) NOT NULL DEFAULT '',
  `totalpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `assigneddate` date NOT NULL DEFAULT '0000-00-00',
  `duedate` date NOT NULL DEFAULT '0000-00-00',
  `assignmentinformation` text,
  PRIMARY KEY (`assignmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,1,1,1,'One',10.00,'2016-04-07','0000-00-00','Slides'),(2,1,1,1,'Two',10.00,'2016-05-07','0000-00-00','Malicious Assignment');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `coursename` varchar(20) NOT NULL DEFAULT '',
  `teacherid` int(11) NOT NULL DEFAULT '0',
  `sectionnum` varchar(15) NOT NULL DEFAULT '0',
  `roomnum` varchar(5) NOT NULL DEFAULT '',
  `periodnum` char(3) NOT NULL DEFAULT '',
  `q1points` double(6,2) NOT NULL DEFAULT '0.00',
  `q2points` double(6,2) NOT NULL DEFAULT '0.00',
  `totalpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `aperc` double(6,3) NOT NULL DEFAULT '0.000',
  `bperc` double(6,3) NOT NULL DEFAULT '0.000',
  `cperc` double(6,3) NOT NULL DEFAULT '0.000',
  `dperc` double(6,3) NOT NULL DEFAULT '0.000',
  `fperc` double(6,3) NOT NULL DEFAULT '0.000',
  `dotw` varchar(5) DEFAULT NULL,
  `substituteid` int(11) DEFAULT NULL,
  `secondcourseid` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,1,1,'Presentation Skills',1,'1','A224','1',0.00,20.00,20.00,0.000,0.000,0.000,0.000,0.000,'MWF',2,0);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grades` (
  `gradeid` int(11) NOT NULL AUTO_INCREMENT,
  `assignmentid` int(11) NOT NULL DEFAULT '0',
  `courseid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  `points` double(6,2) DEFAULT '0.00',
  `comment` text,
  `submitdate` date DEFAULT '0000-00-00',
  `islate` int(1) DEFAULT '0',
  PRIMARY KEY (`gradeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_student_match`
--

DROP TABLE IF EXISTS `parent_student_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent_student_match` (
  `matchid` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`matchid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_student_match`
--

LOCK TABLES `parent_student_match` WRITE;
/*!40000 ALTER TABLE `parent_student_match` DISABLE KEYS */;
INSERT INTO `parent_student_match` VALUES (1,1,1);
/*!40000 ALTER TABLE `parent_student_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parents`
--

DROP TABLE IF EXISTS `parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parents` (
  `parentid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) DEFAULT NULL,
  `lname` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`parentid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parents`
--

LOCK TABLES `parents` WRITE;
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` VALUES (1,6,'Bob','Gupta');
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrations`
--

DROP TABLE IF EXISTS `registrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrations` (
  `regid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `q1currpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `q2currpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `currentpoints` double(6,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`regid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrations`
--

LOCK TABLES `registrations` WRITE;
/*!40000 ALTER TABLE `registrations` DISABLE KEYS */;
INSERT INTO `registrations` VALUES (1,1,1,1,1,0.00,0.00,0.00);
/*!40000 ALTER TABLE `registrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolattendance`
--

DROP TABLE IF EXISTS `schoolattendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolattendance` (
  `sattendid` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL DEFAULT '0',
  `sattenddate` date NOT NULL DEFAULT '0000-00-00',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `type` enum('tardy','absent') DEFAULT NULL,
  PRIMARY KEY (`sattendid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolattendance`
--

LOCK TABLES `schoolattendance` WRITE;
/*!40000 ALTER TABLE `schoolattendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `schoolattendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolbulletins`
--

DROP TABLE IF EXISTS `schoolbulletins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolbulletins` (
  `sbulletinid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(15) NOT NULL DEFAULT '',
  `message` text NOT NULL,
  `bulletindate` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`sbulletinid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolbulletins`
--

LOCK TABLES `schoolbulletins` WRITE;
/*!40000 ALTER TABLE `schoolbulletins` DISABLE KEYS */;
INSERT INTO `schoolbulletins` VALUES (1,'One','Morning Announcement','2016-05-26'),(2,'Two','Afternoon Assignment','2016-05-26');
/*!40000 ALTER TABLE `schoolbulletins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolinfo`
--

DROP TABLE IF EXISTS `schoolinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolinfo` (
  `schoolname` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(14) DEFAULT NULL,
  `sitetext` text,
  `sitemessage` text,
  `currenttermid` int(11) DEFAULT NULL,
  `numsemesters` int(3) NOT NULL DEFAULT '0',
  `numperiods` int(3) NOT NULL DEFAULT '0',
  `apoint` double(6,3) NOT NULL DEFAULT '0.000',
  `bpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `cpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `dpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `fpoint` double(6,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`schoolname`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolinfo`
--

LOCK TABLES `schoolinfo` WRITE;
/*!40000 ALTER TABLE `schoolinfo` DISABLE KEYS */;
INSERT INTO `schoolinfo` VALUES ('UNITN','1,Street','52365895','Welcome to UNITN','This is the Message of the day:- We think our fathers fools, so wise do we grow, no doubt our wisest sons would think us so.',NULL,0,0,0.000,0.000,0.000,0.000,0.000);
/*!40000 ALTER TABLE `schoolinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semesters`
--

DROP TABLE IF EXISTS `semesters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semesters` (
  `semesterid` int(11) NOT NULL AUTO_INCREMENT,
  `termid` varchar(15) NOT NULL DEFAULT '',
  `title` varchar(15) NOT NULL DEFAULT '',
  `startdate` date NOT NULL DEFAULT '0000-00-00',
  `midtermdate` date NOT NULL DEFAULT '0000-00-00',
  `enddate` date NOT NULL DEFAULT '0000-00-00',
  `type` enum('1','2') DEFAULT NULL,
  PRIMARY KEY (`semesterid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semesters`
--

LOCK TABLES `semesters` WRITE;
/*!40000 ALTER TABLE `semesters` DISABLE KEYS */;
INSERT INTO `semesters` VALUES (1,'1','Summer','2016-02-07','0000-00-00','2016-02-09','1'),(2,'1','summer2','2016-02-09','2016-02-10','2016-02-11','2');
/*!40000 ALTER TABLE `semesters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) NOT NULL DEFAULT '',
  `mi` char(1) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`studentid`),
  UNIQUE KEY `UserID` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,4,'Alice','A','Gupta');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`teacherid`),
  UNIQUE KEY `UserID` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,3,'Steve','Jobs'),(2,5,'Narendra','Modi');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terms`
--

DROP TABLE IF EXISTS `terms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terms` (
  `termid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(15) NOT NULL DEFAULT '',
  `startdate` date NOT NULL DEFAULT '0000-00-00',
  `enddate` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`termid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terms`
--

LOCK TABLES `terms` WRITE;
/*!40000 ALTER TABLE `terms` DISABLE KEYS */;
INSERT INTO `terms` VALUES (1,'Summer','2016-01-07','2016-01-11'),(2,'Winter','2016-02-11','2017-02-03'),(3,'Autumn','2017-03-03','0000-00-00');
/*!40000 ALTER TABLE `terms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `type` enum('Admin','Teacher','Substitute','Student','Parent') NOT NULL DEFAULT 'Admin',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test','098f6bcd4621d373cade4e832627b4f6','Admin'),(2,'schoolmate','e92490babb18f75d40a3f35b75d52b87','Admin'),(3,'professor','3f9cd3c7b11eb1bae99dddb3d05da3c5','Teacher'),(4,'student','cd73502828457d15655bbd7a63fb0bc8','Student'),(5,'substitute','30baf0837b1972f86bc7492024cef370','Substitute'),(6,'parent','d0e45878043844ffc41aac437e86b602','Parent');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-28 19:41:18