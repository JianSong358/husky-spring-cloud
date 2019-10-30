/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : cloud-user-data

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2019-10-24 19:03:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hc_book_info
-- ----------------------------
DROP TABLE IF EXISTS `hc_book_info`;
CREATE TABLE `hc_book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `book_name` varchar(100) DEFAULT NULL COMMENT '书籍名称',
  `book_author` varchar(100) NOT NULL DEFAULT '0' COMMENT '作者',
  `book_desc` varchar(200) DEFAULT NULL COMMENT '简介',
  `book_press` varchar(100) NOT NULL DEFAULT '0' COMMENT '出版社',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '状态：0可用,1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='书籍信息表';

-- ----------------------------
-- Records of hc_book_info
-- ----------------------------
INSERT INTO `hc_book_info` VALUES ('1', 'Java编程思想', 'Bruce Eckel', '恕我直言，这是一本学习Java的理想书籍', '机械工业出版社', '2019-10-12 10:58:21', '2019-10-12 10:58:21', '0');
INSERT INTO `hc_book_info` VALUES ('2', '高性能MySQL', 'Baron 王小东', '每一章的内容自成体系，适合各领域技术人员作选择性的阅读。', '电子工业出版社', '2019-10-12 10:58:21', '2019-10-12 10:58:21', '0');

-- ----------------------------
-- Table structure for hc_user_base
-- ----------------------------
DROP TABLE IF EXISTS `hc_user_base`;
CREATE TABLE `hc_user_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(300) DEFAULT NULL COMMENT '加密密码',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '状态:0可用,1禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of hc_user_base
-- ----------------------------
INSERT INTO `hc_user_base` VALUES ('1', 'spring', '123', '13267891314', '13267891314@qq.com', '2019-09-21 14:33:41', '2019-09-21 14:33:44', '0');
INSERT INTO `hc_user_base` VALUES ('2', 'smile', '111', '13267891315', '13267891315@qq.com', '2019-09-24 10:56:57', '2019-09-24 10:56:59', '0');
INSERT INTO `hc_user_base` VALUES ('3', 'cicada1', 'password1', '18223456781', 'cicada1@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('4', 'cicada2', 'password2', '18223456782', 'cicada2@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('5', 'cicada3', 'password3', '18223456783', 'cicada3@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('6', 'cicada4', 'password4', '18223456784', 'cicada4@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('7', 'cicada5', 'password5', '18223456785', 'cicada5@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('8', 'cicada6', 'password6', '18223456786', 'cicada6@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('9', 'cicada7', 'password7', '18223456787', 'cicada7@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('10', 'cicada8', 'password8', '18223456788', 'cicada8@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('11', 'cicada9', 'password9', '18223456789', 'cicada9@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');
INSERT INTO `hc_user_base` VALUES ('12', 'cicada10', 'password10', '182234567810', 'cicada10@qq.com', '2019-10-12 10:51:27', '2019-10-12 10:51:27', '0');

-- ----------------------------
-- Table structure for hc_user_token
-- ----------------------------
DROP TABLE IF EXISTS `hc_user_token`;
CREATE TABLE `hc_user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `token` varchar(300) DEFAULT NULL COMMENT 'Token令牌',
  `over_time` datetime DEFAULT NULL COMMENT 'Token结束时间',
  `expire_time` int(11) DEFAULT '0' COMMENT 'Token有效期',
  `ip_site` varchar(50) DEFAULT NULL COMMENT '登录IP地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token表';

-- ----------------------------
-- Records of hc_user_token
-- ----------------------------
