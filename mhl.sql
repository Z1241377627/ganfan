/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724 (5.7.24)
 Source Host           : localhost:3306
 Source Schema         : mhl

 Target Server Type    : MySQL
 Target Server Version : 50724 (5.7.24)
 File Encoding         : 65001

 Date: 04/05/2023 17:41:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `menuId` int(11) NOT NULL DEFAULT 0,
  `nums` int(11) NOT NULL DEFAULT 0,
  `money` double NOT NULL DEFAULT 0,
  `dingTableId` int(11) NOT NULL DEFAULT 0,
  `billDate` datetime NOT NULL,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, '27b8264e-665e-473b-a51c-449e91e23831', 1, 1, 10, 1, '2023-05-04 11:39:33', '支付宝');
INSERT INTO `bill` VALUES (2, 'f0a89347-c9b2-4b9c-b033-ed5a847e0346', 2, 10, 200, 2, '2023-05-04 16:10:02', '现金');
INSERT INTO `bill` VALUES (3, 'bf4a78b1-e2a3-4b1d-b3c6-dd8658541dc2', 2, 100, 2000, 2, '2023-05-04 16:11:37', '微信');
INSERT INTO `bill` VALUES (4, '2a7ed5d4-b8c1-464a-bde8-5866ce6ea349', 2, 10, 200, 1, '2023-05-04 16:16:08', '支付宝');
INSERT INTO `bill` VALUES (5, '1208a889-d0d6-4baf-9a29-748ea6196d72', 2, 5, 100, 2, '2023-05-04 17:17:48', '微信');

-- ----------------------------
-- Table structure for dingtable
-- ----------------------------
DROP TABLE IF EXISTS `dingtable`;
CREATE TABLE `dingtable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `orderName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `orderTel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dingtable
-- ----------------------------
INSERT INTO `dingtable` VALUES (1, '已经预定', '凉凉', '10086');
INSERT INTO `dingtable` VALUES (2, '空', '', '');
INSERT INTO `dingtable` VALUES (3, '空', '', '');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `pwd` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `job` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '66661', 'e10adc3949ba59abbe56e057f20f883e', '凉凉', '经理');
INSERT INTO `employee` VALUES (2, '66662', 'e10adc3949ba59abbe56e057f20f883e', '火火', '服务员');
INSERT INTO `employee` VALUES (3, '66663', 'e10adc3949ba59abbe56e057f20f883e', '军军', '收银员');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `price` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '八宝粥', '主食', 10);
INSERT INTO `menu` VALUES (2, '叉烧包', '主食', 20);
INSERT INTO `menu` VALUES (3, '宫保鸡丁', '热菜', 30);
INSERT INTO `menu` VALUES (4, '山药鲅鱼', '凉菜', 14);
INSERT INTO `menu` VALUES (5, '银丝卷', '甜品', 9);
INSERT INTO `menu` VALUES (6, '水煮鱼', '热菜', 26);
INSERT INTO `menu` VALUES (7, '甲鱼汤', '汤类', 100);
INSERT INTO `menu` VALUES (8, '鸡蛋汤', '汤类', 16);

SET FOREIGN_KEY_CHECKS = 1;
