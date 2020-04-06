/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.22-log : Database - bookmanagedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmanagedb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookmanagedb`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `Name` varchar(100) NOT NULL COMMENT '图书名',
  `Author` varchar(100) NOT NULL COMMENT '图书作者',
  `publish` varchar(100) NOT NULL COMMENT '出版社',
  `publishdate` date NOT NULL COMMENT '出版日期',
  `Page` int(11) DEFAULT NULL COMMENT '页数',
  `Price` double DEFAULT NULL COMMENT '价格',
  `Content` varchar(500) DEFAULT NULL COMMENT '内容摘要',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`Name`,`Author`,`publish`,`publishdate`,`Page`,`Price`,`Content`) values (1,'JSP编程','张三','电力出版社','2011-12-02',15,17,'<p>JSP编程开发&nbsp;&nbsp;<br></p>'),(2,'Head Fist设计模式','Bert Bates磊','中国电力出版社','2020-04-04',300,1000,'设计模式ddd'),(3,'Head Firs设计模式','Bert Bates','中国电力出版社','2020-04-04',300,100,'设计模式'),(4,'Spring ia Action','Creig Wlls','人民邮电出版社','2020-04-04',348,100,'<p>哈哈哈哈哈</p>'),(5,'大话设计模式','北大青鸟','科学技术文献','2020-04-04',300,1000,'第四版'),(6,'Jena编程思想','Bruece Eckel','机械工业出版社','2020-04-04',300,100,'使用Hibemate'),(7,'中华儿女','中华','长青出版社','2020-04-01',20,17,'<p>个咕咕咕咕</p>');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) NOT NULL COMMENT '性别',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `usertype` int(11) NOT NULL COMMENT '0:普通用户  1:图书系统管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`age`,`sex`,`nickname`,`usertype`) values (1,'admin','admin',20,1,'管理员',1),(2,'朱一龙','0416',30,1,'龙哥',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
