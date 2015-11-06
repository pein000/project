/*
Navicat MySQL Data Transfer

Source Server         : MyNative
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-10-28 12:04:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for one_account_cash
-- ----------------------------
DROP TABLE IF EXISTS `one_account_cash`;
CREATE TABLE `one_account_cash` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `AMOUNT` decimal(32,4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_account_cash
-- ----------------------------
INSERT INTO `one_account_cash` VALUES ('1', '100001', '0.0000');
INSERT INTO `one_account_cash` VALUES ('5', '100002', '0.0000');
INSERT INTO `one_account_cash` VALUES ('6', '100006', '0.0000');

-- ----------------------------
-- Table structure for one_account_point
-- ----------------------------
DROP TABLE IF EXISTS `one_account_point`;
CREATE TABLE `one_account_point` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `AMOUNT` decimal(32,4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_account_point
-- ----------------------------
INSERT INTO `one_account_point` VALUES ('1', '100001', '0.0000');
INSERT INTO `one_account_point` VALUES ('2', '100002', '0.0000');
INSERT INTO `one_account_point` VALUES ('6', '100006', '0.0000');

-- ----------------------------
-- Table structure for one_cash_flow
-- ----------------------------
DROP TABLE IF EXISTS `one_cash_flow`;
CREATE TABLE `one_cash_flow` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CASH_ID` int(11) DEFAULT NULL COMMENT 'one_account_cash的主键id',
  `AMOUNT` decimal(32,4) DEFAULT NULL COMMENT '金额',
  `TRADE_TYPE` varchar(12) DEFAULT NULL COMMENT '交易类型\r\nCHARGE:充值\r\nCONSUME:消费\r\nWITHDRAW:提现\r\n OTHERS:其他',
  `TRADE_PATH` varchar(12) DEFAULT NULL COMMENT '交易途径\r\nALIPAY:支付宝\r\n WECHATPAY:微信支付\r\n SYSCONSUM:系统消费\r\n  OTHERS:其他途径',
  `TRADE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_cash_flow
-- ----------------------------
INSERT INTO `one_cash_flow` VALUES ('1', '1', '0.3000', 'CHARGE', 'ALIPAY', '2015-10-21 15:28:37');
INSERT INTO `one_cash_flow` VALUES ('2', '1', '0.7000', 'CHARGE', 'WECHATPAY', '2015-10-22 15:29:21');
INSERT INTO `one_cash_flow` VALUES ('3', '1', '1.0000', 'CONSUME', 'CASHPAY', '2015-10-24 16:15:55');
INSERT INTO `one_cash_flow` VALUES ('4', '1', '8.0000', 'CONSUME', 'CASHPAY', '2015-10-24 17:10:26');
INSERT INTO `one_cash_flow` VALUES ('5', '1', '-6.0000', 'CONSUME', 'CASHPAY', '2015-10-24 22:38:30');
INSERT INTO `one_cash_flow` VALUES ('6', '1', '0.0000', 'CONSUME', 'CASHPAY', '2015-10-24 22:43:57');
INSERT INTO `one_cash_flow` VALUES ('7', '1', '0.0000', 'CONSUME', 'CASHPAY', '2015-10-24 22:48:39');
INSERT INTO `one_cash_flow` VALUES ('8', '1', '52.0000', 'CONSUME', 'ALIPAY', '2015-10-25 09:00:51');
INSERT INTO `one_cash_flow` VALUES ('9', '1', '7.0000', 'CONSUME', 'ALIPAY', '2015-10-25 10:43:36');
INSERT INTO `one_cash_flow` VALUES ('10', '1', '7.0000', 'CONSUME', 'ALIPAY', '2015-10-25 10:46:16');
INSERT INTO `one_cash_flow` VALUES ('11', '6', '10.0000', 'CONSUME', 'ALIPAY', '2015-10-25 14:38:44');
INSERT INTO `one_cash_flow` VALUES ('12', '5', '10400.0000', 'CONSUME', 'ALIPAY', '2015-10-25 21:38:06');
INSERT INTO `one_cash_flow` VALUES ('13', '1', '1300.0000', 'CONSUME', 'ALIPAY', '2015-10-25 21:48:54');
INSERT INTO `one_cash_flow` VALUES ('14', '1', '100.0000', 'CONSUME', 'ALIPAY', '2015-10-25 21:49:59');

-- ----------------------------
-- Table structure for one_goods_flow
-- ----------------------------
DROP TABLE IF EXISTS `one_goods_flow`;
CREATE TABLE `one_goods_flow` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `GOODS_ID` int(11) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `GOODS_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_goods_flow
-- ----------------------------
INSERT INTO `one_goods_flow` VALUES ('1', '100001', '1', '14', '2015-10-25 09:00:51');
INSERT INTO `one_goods_flow` VALUES ('2', '100001', '1', '13', '2015-10-25 09:00:51');
INSERT INTO `one_goods_flow` VALUES ('3', '100001', '2', '25', '2015-10-25 09:00:51');
INSERT INTO `one_goods_flow` VALUES ('4', '100001', '2', '7', '2015-10-25 10:43:37');
INSERT INTO `one_goods_flow` VALUES ('5', '100001', '2', '7', '2015-10-25 10:46:16');
INSERT INTO `one_goods_flow` VALUES ('6', '100006', '2', '10', '2015-10-25 14:38:44');
INSERT INTO `one_goods_flow` VALUES ('7', '100002', '2', '1600', '2015-10-25 21:38:06');
INSERT INTO `one_goods_flow` VALUES ('8', '100002', '1', '8800', '2015-10-25 21:38:06');
INSERT INTO `one_goods_flow` VALUES ('9', '100001', '2', '100', '2015-10-25 21:48:55');
INSERT INTO `one_goods_flow` VALUES ('10', '100001', '1', '1200', '2015-10-25 21:48:55');
INSERT INTO `one_goods_flow` VALUES ('11', '100001', '1', '100', '2015-10-25 21:49:59');

-- ----------------------------
-- Table structure for one_point_flow
-- ----------------------------
DROP TABLE IF EXISTS `one_point_flow`;
CREATE TABLE `one_point_flow` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POINT_ID` int(11) DEFAULT NULL COMMENT 'one_account_point的ID',
  `AMOUNT` decimal(32,4) DEFAULT NULL,
  `INCOME_PATH` varchar(32) DEFAULT NULL COMMENT '收入来源SHOPPINGAWARD:购物奖赏\r\n FRIENDAWARD:邀请好友奖赏\r\n GAMEAWARD:游戏奖赏\r\n SHOPPINGOFFSET:购物冲抵\r\n GAMEOFFSET:游戏消费\r\n OTHERS:其他途径',
  `POINT_TYPE` varchar(32) DEFAULT NULL COMMENT '积分类型\r\nADD:获得积分\r\n SUB:扣减积分',
  `POINT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_point_flow
-- ----------------------------
INSERT INTO `one_point_flow` VALUES ('1', '1', '3.0000', 'SHOPPINGAWARD', 'ADD', '2015-10-21 17:40:26');
INSERT INTO `one_point_flow` VALUES ('2', '1', '4.0000', 'FRIENDAWARD', 'ADD', '2015-10-22 17:40:57');
INSERT INTO `one_point_flow` VALUES ('3', '1', '7.0000', 'SHOPPINGAWARD', 'SUB', '2015-10-24 16:15:55');
INSERT INTO `one_point_flow` VALUES ('4', '1', '14.0000', 'SHOPPINGAWARD', 'SUB', '2015-10-24 17:10:26');
INSERT INTO `one_point_flow` VALUES ('5', '1', '0.0000', 'SHOPPINGAWARD', 'SUB', '2015-10-24 22:38:13');
INSERT INTO `one_point_flow` VALUES ('6', '1', '0.0000', 'SHOPPINGAWARD', 'SUB', '2015-10-24 22:43:54');
INSERT INTO `one_point_flow` VALUES ('7', '1', '0.0000', 'SHOPPINGOFFSET', 'SUB', '2015-10-24 22:48:31');

-- ----------------------------
-- Table structure for one_shop_car
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_car`;
CREATE TABLE `one_shop_car` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `GOODS_ID` int(11) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `ACTIVE` varchar(12) DEFAULT NULL COMMENT 'TRUE:活动的 FALSE:关闭的',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_car
-- ----------------------------
INSERT INTO `one_shop_car` VALUES ('8', '100006', '1', '42', '1');
INSERT INTO `one_shop_car` VALUES ('9', '100006', '2', '16', '1');

-- ----------------------------
-- Table structure for one_shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `one_shop_goods`;
CREATE TABLE `one_shop_goods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(32) DEFAULT NULL,
  `DESCRIPTION` varchar(225) DEFAULT NULL,
  `OUTLINE_URL` varchar(225) DEFAULT NULL,
  `TYPE` char(1) DEFAULT NULL,
  `PRICE` decimal(12,2) DEFAULT NULL,
  `TOTAL_AMOUNT` int(11) DEFAULT NULL,
  `CUR_AMOUNT` int(11) DEFAULT NULL,
  `STATUS` varchar(12) DEFAULT '0' COMMENT '0:初始化 1:正在揭晓 2:已经揭晓',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_goods
-- ----------------------------
INSERT INTO `one_shop_goods` VALUES ('1', 'iphone6', '苹果6s 正版 官网进货', '/static/image/outline/kk-saf2-n5.jpg', '1', '6899.00', '6899', '12602', '1');
INSERT INTO `one_shop_goods` VALUES ('2', '小米4', '小米4 低价进货，真品', '/static/image/outline/kk-sensors-moves-n5.jpg', '1', '2500.00', '2500', '2700', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=100007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_shop_user
-- ----------------------------
INSERT INTO `one_shop_user` VALUES ('100001', '清风终结者', '一纸清风，一生寂寞', '12324253', '1234423423', 'vesalqiu_000@163.com', '/static/image/user/清风终结者_1234423423.JPG', '陆家嘴天涯妓院', null, null);
INSERT INTO `one_shop_user` VALUES ('100002', '菊花开发者', '有了菊花，财源滚滚来。菊花开发，让生活更美好', '111111', '110120130', '112312@ad.com', '/static/image/user/菊花开发者_110120130.JPG', '陆家嘴菊花工作室', null, null);
INSERT INTO `one_shop_user` VALUES ('100006', '3p大师', '各种3p技巧教授，一共10元，只要10元', '111111', '110110110', '11111110@153.com', null, '陆家嘴技术培训中心', null, null);

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
