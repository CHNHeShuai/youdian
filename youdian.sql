/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.49-community : Database - youdian
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`youdian` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `youdian`;

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

insert  into `banner`(`id`,`image`) values (12,'FjFLYwp3mf6KmX3-BwQRnYpEI9bN'),(14,'Fuw26TykfLPXcS-dvgS163gwt_6F'),(15,'FsRkmsRgN79MDrQ_05rA8bQxieVU'),(19,'Fk2wTg_6BU8YYsxd5ceNEiZy1804'),(20,'Fu49vNkuTArcMTENrOtuSWXEFLZe');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`cname`) values (1,'医疗口腔'),(2,'医疗美容');

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `jianjie` varchar(500) DEFAULT NULL,
  `linian` varchar(500) DEFAULT NULL,
  `jiazhiguan` varchar(500) DEFAULT NULL,
  `kouhao` varchar(500) DEFAULT NULL,
  `historyimage` varchar(500) DEFAULT NULL,
  `history` varchar(500) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `company` */

insert  into `company`(`id`,`jianjie`,`linian`,`jiazhiguan`,`kouhao`,`historyimage`,`history`,`telephone`,`email`,`address`) values (1,'致力打造医美空间第一品牌（我们一直再做的事儿） 悠点设计是一家专注于医养（医疗、口腔、美容）领域空间设计的集团公司：旗下拥有一支高度专业化的医养装饰施工队伍，施工质量交口称赞，致力打造医美空间第一品牌。','悠点精于对口腔医美空间布局设计、装饰设计、品牌VI设计以及整体软装设计等，拥有一支经验丰富、创意非凡的设计大咖；','牛逼牛逼再牛逼','致力打造医美空间第一品牌','FlFYQuxKL9Zb5abc_uf3HJmdgMjG','悠点自2010年以来，已累计完成国内数百家口腔医疗院所、美容疗养院所，以及综合医院手术室改造在内的设计及施工项目，悠点将口腔医美空间当做一个全新的产品来诠释，赋予无限的艺术空间设计能力，打造前沿时尚的空间装饰设计。\r\n   \r\n 悠点设计以“致力打造医美空间第一品牌”为目标，以“贴近医美，匠心设计”为理念，为口腔医美行业解决空间设计、空间环境等问题；根据牙科医疗和美容医疗的专业不同，再次细分牙科医疗和美容医疗两大专职服务团队，为全国牙科医疗和美容医疗机构提供一对一落地服务。','15266669999','2323232323@qq.com','杭州悠点装饰设计有限公司');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `linktime` varchar(50) DEFAULT NULL,
  `gbook` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`username`,`telephone`,`linktime`,`gbook`) values (5,'\"heshuai\"','\"11111\"','\"2018\"','\"1111\"'),(7,'haha','haah','ahahhah','ahhaha'),(8,'个人的双方各得 ','如果对方改变','大润发个人发帖的','如风达办公费'),(12,'admin','admin','admin','admin'),(14,'第三方地方','12345678998','周一','沃尔夫更惹人'),(15,'阿瓦让痛风和','12345678998','周一','区位图'),(16,'第三方地方','12345678998','周一','发过火你'),(17,'发过火','12345678998','周一','认为我'),(18,'反倒是','12345678998','周一','王企鹅的付出'),(19,'第三方地方','12345678998','周一','大范甘迪');

/*Table structure for table `example` */

DROP TABLE IF EXISTS `example`;

CREATE TABLE `example` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `introduct` varchar(500) DEFAULT NULL,
  `mianji` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `pageview` int(20) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  `cid` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_fk` (`cid`),
  CONSTRAINT `pk_fk` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `example` */

insert  into `example`(`id`,`title`,`image`,`introduct`,`mianji`,`address`,`pageview`,`createtime`,`cid`) values (16,'DEBEI','Foi4vWCHAZCK8TbqT-QZzxJh4x0w,FltBs7EIar_wpyhjqvCo0fOkv8HQ,FltBs7EIar_wpyhjqvCo0fOkv8HQ','  xxx','111','杭州市',44,'2019-03-17 10:44:26',2),(17,'JOYDENTAL','FiSiL3fXU0v1VET--kTdjWfdh1fe,FpTKO1TKKOBhiAukvBbA5Bi80UgH,FsTHL1mWCjOgZFFYUbD8H8oroB_G,FoCiy1HUdO7msvZWm9TIK5oRtO1V','牛逼啊','xxx','杭州市',18,'2019-03-17 12:21:32',1),(18,'倍齿康口腔','Fn2NuJuPZQtlSus8cuffdNidDVg-,FrJlnqCZqA3DQCV-fo3rslfbcQTD,FlnZSZE4ykVdV5kpUHYXPtazbeS6,FshBKgCEI8jn2R1gUSTwyVDpWyxf','牛','111','杭州市',3,'2019-03-17 15:56:45',1),(19,'程碧焕口腔','FpPRL1olSQvvqcBdPxP93cgcP0eA,FkHv7wjvT5TZfT4gLPMF5iVtiHXV,Fggxn3193HcsXTer14izltBsLfor','xxx','222','杭州市',6,'2019-03-17 16:00:56',2),(20,'德贝丁桥店','FppIhMDtMtN1NhPdBe_RlkiE0CCs,Fgps8tedYv6lgP3mOj1DV8BTrnw5,Fm_R53hxfRGPjgmETFPoj52tXOGR,FrwVVYN9Ks7J5gnGjiL_uFClEilh','la','3333','杭州市',9,'2019-03-17 16:10:08',1),(21,'德贝飞虹路店','lkzZxWsUuiRISH6l6ry6iRN5psnI,FqmLt97ok12GaWNvbI18awHZpVvd,Fhz4i3CaZM2sTjp9682U1CjT1Wg0,FlFYQuxKL9Zb5abc_uf3HJmdgMjG','1','99','杭州市',4,'2019-03-17 16:17:53',1),(22,'梁志任口腔','Fuw26TykfLPXcS-dvgS163gwt_6F,Fhfpnl1Thhnvr7hgD3ePDbnMq0cl,Fgz5z3CC2APS6Avm9TU3jO4IChla','222','125','杭州市',0,'2019-03-19 10:46:24',2),(23,'品凯口腔','Fi_uH_ovXw1kNMZCkVjPvXXuDdBw,FlO5gKO1XswwgID-94A7A7tJ62QO,Fn2iJhYwEP87TK_DK4e2Ci5iLcVy,FnkyOWjBYWArjPSSSyf3RJ9DzQN9','11','120','杭州市',2,'2019-03-19 10:47:29',1),(24,'瑞创口腔','FoQvbYOs6osI-2ZG-3umqik8X4fP,FhKbhVXmawqfVU1edFMhJK_k6vGu,Fu49vNkuTArcMTENrOtuSWXEFLZe','11','200','杭州市',5,'2019-03-19 10:48:08',2),(25,'尚品口腔','Fswz4BNC9oiZa07us3h5_Pz51d35,Fo-smB3YadZUxEYJyP5XpSHKQGGZ,FsU8nVoocF6L_2dehp1AQEjSqx1H','999','120','杭州市',0,'2019-03-26 19:41:45',1),(26,'英普朗口腔','Fk2wTg_6BU8YYsxd5ceNEiZy1804,FoFYUQfczM81Yc_eEfeQ2eo9_J5l,FtF41QwrnJ9inChcn0s8GDN-xnFK','77777','120','杭州市',0,'2019-04-01 19:15:44',1);

/*Table structure for table `friend` */

DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(50) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `friend` */

insert  into `friend`(`id`,`companyname`,`image`) values (7,'腾讯','Fm_R53hxfRGPjgmETFPoj52tXOGR'),(8,'阿里','Fs6X8RC4KIaJjpdGGllOP_WUzvxY'),(9,'京东','FjAzLjAs45fTrmBevrJy5fHXfbZd');

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `miaoshu` varchar(500) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `pageview` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `state` */

insert  into `state`(`id`,`title`,`image`,`miaoshu`,`updatetime`,`pageview`) values (4,'拜博口腔医疗集团突飞猛进','FrwVVYN9Ks7J5gnGjiL_uFClEilh','对不起，马泷齿科来晚啦！\r\n业界著名的马泷齿科委托康品全新设计完成的口腔门诊，设计简洁科技，传承马泷博士一生追求的至高境界，感谢马泷齿科团队的大力支持与信赖！各位口腔界同仁敬请期待！','2019-04-01 18:19:42',9),(5,'南通市口腔医院新征程','FmAncFL4bq12GserHoGwOWu8JhrZ','康品设计全程参与了南通市口腔医院的内部设计改造工程，全新布局设计的现代化口腔医院即将呈现在南通城！','2019-04-01 18:19:26',12),(6,'对不起，马泷齿科来晚啦！','Fgz5z3CC2APS6Avm9TU3jO4IChla','业界著名的马泷齿科委托康品全新设计完成的口腔门诊，设计简洁科技，传承马泷博士一生追求的至高境界，感谢马泷齿科团队的大力支持与信赖！各位口腔界同仁敬请期待！','2019-04-01 18:19:13',22),(7,'欢乐口腔，聚一帮口腔精英，做一件口腔实事！','Fswz4BNC9oiZa07us3h5_Pz51d35','感谢西诺德牙科学院的鼎力支持，在成功合作举办了北京站讲座课程后，我们再次受邀参加杭州站的讲座。我们团队届时将为杭州地区的牙科朋友们奉献更精彩的内容，本次开讲主题：口腔诊所设计装修经典案例解析！','2019-04-01 18:18:56',32);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`image`,`telephone`,`email`) values (1,'朱总','8ddcff3a80f4189ca1c9d4d902c3c909','Fjfpsh276r5NTOYpqwY8LqbXyfK7','152XXXXXXXX','wangsenhao520@qq.com'),(2,'贺帅','f379eaf3c831b04de153469d1bec345e','Fn97dfMsyanmS25S0qL_TDP77aot','15255164685','2489818272@qq.com'),(4,'hs','f379eaf3c831b04de153469d1bec345e','FrMS5TrhqCG-KOVNAejPXMJm9fs8','15255164685','2323232323@qq.com');

/*Table structure for table `welfare` */

DROP TABLE IF EXISTS `welfare`;

CREATE TABLE `welfare` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `miaoshu` varchar(500) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `welfare` */

insert  into `welfare`(`id`,`miaoshu`,`image`) values (1,'超级好的福利','FrCt-wfb3ww3_HueZKYuMrDOeeJm');

/*Table structure for table `zhaopin` */

DROP TABLE IF EXISTS `zhaopin`;

CREATE TABLE `zhaopin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `createtime` varchar(30) DEFAULT NULL,
  `task` varchar(500) DEFAULT NULL,
  `must` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `zhaopin` */

insert  into `zhaopin`(`id`,`title`,`job`,`createtime`,`task`,`must`) values (9,' 招聘一：','设计总监','2019-03-19 10:49:54','1、负责设计团队设计方案构思及品质的审核，主导设计方案，擅长办公或样板房设计。 \r\n2、精通AUTOCAD、PS、PPT软件，并同时熟练使用其它相关软件。 \r\n3、熟悉掌握施工图绘制规范和要求。 \r\n4、对各种细部处理、节点、收口做法非常熟练，能独立完成整套施工图。 \r\n5、工地经验丰富，了解材料及设计概算方面的知识。 ','1、5年以上工作经验，其中3年以上同岗位工作经验及投标讲标经验； \r\n2、掌握室内设计相关理论知识，精通室内外设计及装饰工程相关规范标准，熟悉建筑设计行业知识体系，熟悉装饰材料、精通施工工艺及流程； \r\n3、具备优良的沟通协调、商业谈判及语言表达能力，具备手绘能力、精通设计专业软件、独立完成设计方案能力强； \r\n4、责任心强、具有室内设计行业资质证书优先。 \r\n5、有境外或者港澳台公司工作经验优先。'),(10,'招聘二：','行政人事经理','2019-03-19 10:50:39','1、主持人力资源部管理工作；\r\n\r\n2、建制人力资源管理相关制度，主导制定人力资源战略规划；\r\n\r\n3、制定并完善薪酬体系、绩效考核体系并监督实施；\r\n\r\n4、负责组织实施招聘、培训及人员入离职、档案管理','1、工商管理、行政管理及人力资源管理相关专业；\r\n\r\n2、人力资源管理岗位5年以上工作经验；\r\n\r\n3、具备全面的行政管理、人力资源管理、企业战略规划、企业文化及团队建设、劳动法律法规知识；'),(11,'招聘三：','施工图绘图员','2019-03-19 10:51:13','1、协助配合主案设计师做好深化设计工作，完成全套施工图绘制；\r\n\r\n2、充分了解设计并转换成施工图之各项细节图纸；\r\n\r\n3、参与项目施工现场的配合与交涉；\r\n\r\n4、负责工程项目的施工现场变更及竣工图制作','1、建筑、环艺、室内设计等相关专业专科以上学历；\r\n\r\n2、1年以上正规设计事务所或设计公司建筑设计、装饰施工图制作经验；\r\n\r\n3、精通AUTOCAD软件，并同时熟练使用其它相关软件；');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
