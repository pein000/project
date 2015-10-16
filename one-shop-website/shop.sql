/*
Navicat MySQL Data Transfer

Source Server         : MyNative
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-10-16 14:16:42
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
INSERT INTO `one_shop_goods` VALUES ('1', 'iphone6', '苹果6s 正版 官网进货', null, '1', '6899.00', '6899', '0');
INSERT INTO `one_shop_goods` VALUES ('2', '小米4', '小米4 低价进货，真品', null, '1', '2500.00', '2500', '0');

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
  `URL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_type
-- ----------------------------
INSERT INTO `one_shop_type` VALUES ('1', '手机数码', 'life.jpg');
INSERT INTO `one_shop_type` VALUES ('2', '时尚生活', 'phone.jpg');
INSERT INTO `one_shop_type` VALUES ('3', '代金券', 'ticket.jpg');
INSERT INTO `one_shop_type` VALUES ('4', '精品电器', null);
INSERT INTO `one_shop_type` VALUES ('5', '母婴产品', null);
INSERT INTO `one_shop_type` VALUES ('6', '汽车周边', null);
INSERT INTO `one_shop_type` VALUES ('7', '特卖商品', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `PHONE` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'qiuwei', '123456', '1223123443');
INSERT INTO `user` VALUES ('2', 'zhangyan', '123456', '1235542345');
