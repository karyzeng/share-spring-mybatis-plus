/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : test_slave1

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/08/2020 21:43:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_consume_message
-- ----------------------------
DROP TABLE IF EXISTS `t_consume_message`;
CREATE TABLE `t_consume_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `msg_id` char(32) NOT NULL COMMENT '消息id',
  `type` varchar(20) NOT NULL COMMENT '消息类型',
  `content` text COMMENT '消息内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='已经消费的消息';

-- ----------------------------
-- Table structure for t_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_name` varchar(50) DEFAULT NULL COMMENT '优惠券名称',
  `coupon_price` decimal(16,4) DEFAULT NULL COMMENT '优惠券金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
