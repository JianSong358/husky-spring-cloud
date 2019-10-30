/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : cloud-report-data

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2019-10-24 19:03:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hc_search_book
-- ----------------------------
DROP TABLE IF EXISTS `hc_search_book`;
CREATE TABLE `hc_search_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `book_id` int(11) DEFAULT NULL COMMENT '书籍ID',
  `book_name` varchar(100) DEFAULT NULL COMMENT '书籍名称',
  `search_time` datetime DEFAULT NULL COMMENT '搜索时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='书籍被搜索记录';

-- ----------------------------
-- Records of hc_search_book
-- ----------------------------
INSERT INTO `hc_search_book` VALUES ('1', '1', '1', 'Java编程思想', '2019-10-21 16:10:26');
INSERT INTO `hc_search_book` VALUES ('2', '1', '1', 'Java编程思想', '2019-10-21 16:10:36');
INSERT INTO `hc_search_book` VALUES ('3', '1', '2', '高性能MySQL', '2019-10-21 16:11:19');
INSERT INTO `hc_search_book` VALUES ('4', '1', '1', 'Java编程思想', '2019-10-21 16:11:19');

-- ----------------------------
-- Table structure for hc_search_key_word
-- ----------------------------
DROP TABLE IF EXISTS `hc_search_key_word`;
CREATE TABLE `hc_search_key_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `key_word` varchar(50) DEFAULT NULL COMMENT '关键词',
  `search_num` int(11) DEFAULT NULL COMMENT '搜索次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='关键词搜索记录';

-- ----------------------------
-- Records of hc_search_key_word
-- ----------------------------
INSERT INTO `hc_search_key_word` VALUES ('1', '1', '编程思想', '2');
INSERT INTO `hc_search_key_word` VALUES ('2', '1', '工业出版社', '1');

-- ----------------------------
-- Table structure for hc_search_match_degree
-- ----------------------------
DROP TABLE IF EXISTS `hc_search_match_degree`;
CREATE TABLE `hc_search_match_degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `key_word` varchar(50) DEFAULT NULL COMMENT '关键词',
  `book_id` int(11) DEFAULT NULL COMMENT '匹配的首个书籍ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='搜索匹配记录表';

-- ----------------------------
-- Records of hc_search_match_degree
-- ----------------------------
INSERT INTO `hc_search_match_degree` VALUES ('1', '1', '编程思想', '1', '2019-10-21 16:10:25');
INSERT INTO `hc_search_match_degree` VALUES ('2', '1', '编程思想', '1', '2019-10-21 16:10:36');
INSERT INTO `hc_search_match_degree` VALUES ('3', '1', '工业出版社', '2', '2019-10-21 16:11:19');
