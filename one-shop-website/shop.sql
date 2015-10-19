/*
Navicat MySQL Data Transfer

Source Server         : MyNative
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-10-19 10:37:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for one_shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_goods`;
CREATE TABLE `one_shop_goods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(32) DEFAULT NULL,
  `DESCRIPTION` varchar(225) DEFAULT NULL,
  `OUTLINE_URL` varchar(32) DEFAULT NULL,
  `TYPE` char(1) DEFAULT NULL,
  `PRICE` decimal(12,2) DEFAULT NULL,
  `TOTAL_AMOUNT` int(11) DEFAULT NULL,
  `CUR_AMOUNT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_goods
-- ----------------------------
INSERT INTO `one_shop_goods` VALUES ('1', 'iphone6', '苹果6s 正版 官网进货', null, '1', '6899.00', '6899', '4500');
INSERT INTO `one_shop_goods` VALUES ('2', '小米4', '小米4 低价进货，真品', null, '1', '2500.00', '2500', '1000');

-- ----------------------------
-- Table structure for one_shop_hottest
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_hottest`;
CREATE TABLE `one_shop_hottest` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GOODS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_hottest
-- ----------------------------
INSERT INTO `one_shop_hottest` VALUES ('1', '1');
INSERT INTO `one_shop_hottest` VALUES ('2', '2');

-- ----------------------------
-- Table structure for one_shop_newest
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_newest`;
CREATE TABLE `one_shop_newest` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GOODS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_newest
-- ----------------------------
INSERT INTO `one_shop_newest` VALUES ('1', '1');
INSERT INTO `one_shop_newest` VALUES ('2', '2');

-- ----------------------------
-- Table structure for one_shop_revealed
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_revealed`;
CREATE TABLE `one_shop_revealed` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GOODS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_revealed
-- ----------------------------
INSERT INTO `one_shop_revealed` VALUES ('1', '1');
INSERT INTO `one_shop_revealed` VALUES ('2', '2');

-- ----------------------------
-- Table structure for one_shop_type
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_type`;
CREATE TABLE `one_shop_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(32) DEFAULT NULL,
  `URL` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_type
-- ----------------------------
INSERT INTO `one_shop_type` VALUES ('1', '手机数码', 'type/kk-immersive-n5.jpg');
INSERT INTO `one_shop_type` VALUES ('2', '时尚生活', 'type/kk-print-land-n5.jpg');
INSERT INTO `one_shop_type` VALUES ('3', '代金券', 'type/kk-proc-device-detail-n5.jpg');
INSERT INTO `one_shop_type` VALUES ('4', '精品电器', 'type/kk-proc-device-overview-n5.jpg');
INSERT INTO `one_shop_type` VALUES ('5', '母婴产品', 'type/kk-saf1-n5.jpg');
INSERT INTO `one_shop_type` VALUES ('6', '汽车周边', 'type/kk-saf2-n5.jpg');
INSERT INTO `one_shop_type` VALUES ('7', '特卖商品', 'type/kk-sensors-moves-n5.jpg');

-- ----------------------------
-- Table structure for one_shop_user
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_user`;
CREATE TABLE `one_shop_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) DEFAULT NULL,
  `SIGN` varchar(225) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `PHONE` varchar(64) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `PHOTO_URL` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `POINT_ID` int(11) DEFAULT NULL,
  `CASH_ACCOUNT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_user
-- ----------------------------
INSERT INTO `one_shop_user` VALUES ('1', 'qiuwei', null, '123456', '1223123443', null, null, null, null, null);
INSERT INTO `one_shop_user` VALUES ('2', 'zhangyan', null, '123456', '1235542345', null, null, null, null, null);
INSERT INTO `one_shop_user` VALUES ('3', '清风终结者', null, '123123', '1234423423', null, null, null, null, null);
INSERT INTO `one_shop_user` VALUES ('4', '清风终结者', null, '1242332', '1234423423', null, null, null, null, null);
INSERT INTO `one_shop_user` VALUES ('5', '清风终结者', '一纸清风，一生寂寞', '12324253', '1234423423', 'vesalqiu_000@163.com', null, '陆家嘴天涯妓院', null, null);

-- ----------------------------
-- Table structure for picture_goods_url
-- ----------------------------
DROP TABLE IF EXISTS `picture_goods_url`;
CREATE TABLE `picture_goods_url` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GOODS_ID` int(11) DEFAULT NULL,
  `URL` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture_goods_url
-- ----------------------------
INSERT INTO `picture_goods_url` VALUES ('1', '1', 'detail/1.jpg');
INSERT INTO `picture_goods_url` VALUES ('2', '1', 'detail/2.jpg');
INSERT INTO `picture_goods_url` VALUES ('3', '1', 'detail/3.jpg');
INSERT INTO `picture_goods_url` VALUES ('4', '1', 'detail/4.jpg');
INSERT INTO `picture_goods_url` VALUES ('5', '2', 'detail/1.jpg');
INSERT INTO `picture_goods_url` VALUES ('6', '2', 'detail/2.jpg');
INSERT INTO `picture_goods_url` VALUES ('7', '2', 'detail/3.jpg');
INSERT INTO `picture_goods_url` VALUES ('8', '2', 'detail/4.jpg');
