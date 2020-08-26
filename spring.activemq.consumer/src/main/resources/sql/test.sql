/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/08/2020 21:43:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_name
-- ----------------------------
DROP TABLE IF EXISTS `t_name`;
CREATE TABLE `t_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_send_message
-- ----------------------------
DROP TABLE IF EXISTS `t_send_message`;
CREATE TABLE `t_send_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `msg_id` char(32) DEFAULT NULL COMMENT '消息id',
  `type` varchar(20) DEFAULT NULL COMMENT '消息类型',
  `content` text COMMENT '消息内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `send_flag` int(11) DEFAULT '0' COMMENT '是否已发送，1表示已发送，0表示未发送，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发送的消息';

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
