/*
SQLyog Community Edition- MySQL GUI v7.12 
MySQL - 5.6.31 : Database - USER
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`USER` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `USER`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '員工姓名',
  `gender` varchar(8) DEFAULT NULL COMMENT '員工性別',
  `telephone` varchar(16) DEFAULT NULL COMMENT '員工電話',
  `job` varchar(16) DEFAULT NULL COMMENT '職稱：約聘( hiring )、正職( staff )',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`gender`,`telephone`,`job`) values (1,'employee1','male','0123456789','staff'),(2,'employee2','female','0123456789','hiring'),(3,'employee3','male','0123456789','hiring'),(5,'employee4','female','0123456789','staff');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) DEFAULT NULL COMMENT '帳號',
  `password` varchar(255) DEFAULT NULL COMMENT '密碼',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`account`,`password`) values (1,'admin','admin'),(4,'admin3','admin3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
