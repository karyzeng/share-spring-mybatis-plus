/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : provider

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/08/2020 21:44:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_successful_business
-- ----------------------------
DROP TABLE IF EXISTS `t_successful_business`;
CREATE TABLE `t_successful_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `msg_id` varchar(32) DEFAULT NULL COMMENT '消息id',
  `msg_type` varchar(50) DEFAULT NULL COMMENT '消息类型',
  `msg_content` text COMMENT '消息内容',
  `queue_type` varchar(50) DEFAULT NULL COMMENT '队列类型',
  `queue_name` varchar(100) DEFAULT NULL COMMENT '队列名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='成功的业务';

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
