/*
Navicat MySQL Data Transfer

Source Server         : local-connection
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : jfreechartdb

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-08-08 15:39:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for categorydata1
-- ----------------------------
DROP TABLE IF EXISTS `categorydata1`;
CREATE TABLE `categorydata1` (
  `category` varchar(32) DEFAULT NULL,
  `series1` float DEFAULT NULL,
  `series2` float DEFAULT NULL,
  `series3` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorydata1
-- ----------------------------
INSERT INTO `categorydata1` VALUES ('London', '54.3', '32.1', '53.4');
INSERT INTO `categorydata1` VALUES ('New York', '43.4', '54.3', '75.21');
INSERT INTO `categorydata1` VALUES ('Paris', '17.9', '34.8', '37.1');

-- ----------------------------
-- Table structure for piedata1
-- ----------------------------
DROP TABLE IF EXISTS `piedata1`;
CREATE TABLE `piedata1` (
  `category` varchar(32) DEFAULT NULL,
  `value` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of piedata1
-- ----------------------------
INSERT INTO `piedata1` VALUES ('London', '54.3');
INSERT INTO `piedata1` VALUES ('New York', '43.4');
INSERT INTO `piedata1` VALUES ('Paris', '17.9');
