/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : cloud-admin-data

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2019-10-24 19:03:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hc_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `hc_admin_user`;
CREATE TABLE `hc_admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(300) DEFAULT NULL COMMENT '加密密码',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '状态:0可用,1禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理用户表';

-- ----------------------------
-- Records of hc_admin_user
-- ----------------------------
INSERT INTO `hc_admin_user` VALUES ('1', 'cicada', '$2a$10$XcigeMfToGQ2bqRToFtUi.sG1V.HhrJV6RBjji1yncXReSNNIPl1K', '13267891314', '13267891314@qq.com', '2019-09-21 14:32:09', '2019-09-21 14:32:12', '0');

-- ----------------------------
-- Table structure for hc_role_info
-- ----------------------------
DROP TABLE IF EXISTS `hc_role_info`;
CREATE TABLE `hc_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_auth` varchar(64) DEFAULT NULL COMMENT '角色权限',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of hc_role_info
-- ----------------------------
INSERT INTO `hc_role_info` VALUES ('1', '超级管理员', 'ROLE_ADMIN', '2019-10-22 10:48:32');

-- ----------------------------
-- Table structure for hc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `hc_user_role`;
CREATE TABLE `hc_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户关联角色表';

-- ----------------------------
-- Records of hc_user_role
-- ----------------------------
INSERT INTO `hc_user_role` VALUES ('1', '1', '1', '2019-10-22 10:47:55');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('CicadaScheduler', 'CICADA_1', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------
INSERT INTO `qrtz_fired_triggers` VALUES ('CicadaScheduler', 'DESKTOP-TTD2E0N15718236767351571823676711', 'CICADA_1', 'DEFAULT', 'DESKTOP-TTD2E0N1571823676735', '1571823720027', '1571823735000', '5', 'ACQUIRED', null, null, '0', '0');

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('CicadaScheduler', 'CICADA_1', 'DEFAULT', null, 'com.husky.cloud.config.TaskJobLog', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720022636F6D2E6875736B792E636C6F75642E656E746974792E5363686564756C654A6F6200000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C000269647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400104C6A6176612F6C616E672F427974653B787074000C5072696E7454696D654A6F627372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016D05E26C607874000E302F3330202A202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000568656C6C6F74000CE697B6E997B4E68993E58DB07372000E6A6176612E6C616E672E427974659C4E6084EE50F51C02000142000576616C75657871007E0013017800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('CicadaScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('CicadaScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('CicadaScheduler', 'DESKTOP-TTD2E0N1571823676735', '1571823724847', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('CicadaScheduler', 'CICADA_1', 'DEFAULT', 'CICADA_1', 'DEFAULT', null, '1571823735000', '1571823720000', '5', 'ACQUIRED', 'CRON', '1568704469000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720022636F6D2E6875736B792E636C6F75642E656E746974792E5363686564756C654A6F6200000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C000269647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400104C6A6176612F6C616E672F427974653B787074000A53656E644D73674A6F627372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016D05E26C607874000E302F3135202A202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000568656C6C6F740012E982AEE4BBB6E5AE9AE697B6E9809AE79FA57372000E6A6176612E6C616E672E427974659C4E6084EE50F51C02000142000576616C75657871007E0013007800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'SendMsgJob', 'hello', '0/15 * * * * ?', '0', '邮件定时通知', '2019-09-06 17:23:08');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('1', '1', 'PrintTimeJob', 'hello', '0', null, '67', '2019-09-17 15:21:00');
INSERT INTO `schedule_job_log` VALUES ('2', '1', 'PrintTimeJob', 'hello', '0', null, '1', '2019-09-17 15:21:30');
INSERT INTO `schedule_job_log` VALUES ('3', '1', 'PrintTimeJob', 'hello', '0', null, '1', '2019-09-17 15:23:00');
INSERT INTO `schedule_job_log` VALUES ('4', '1', 'PrintTimeJob', 'hello', '0', null, '1', '2019-09-17 15:23:10');
INSERT INTO `schedule_job_log` VALUES ('5', '1', 'PrintTimeJob', 'hello', '0', null, '1', '2019-09-17 15:23:13');
INSERT INTO `schedule_job_log` VALUES ('6', '1', 'PrintTimeJob', 'hello', '0', null, '1', '2019-09-17 15:23:30');
INSERT INTO `schedule_job_log` VALUES ('7', '1', 'PrintTimeJob', 'hello', '0', null, '69', '2019-10-17 11:42:30');
INSERT INTO `schedule_job_log` VALUES ('8', '1', 'PrintTimeJob', 'hello', '0', null, '1', '2019-10-17 11:43:00');
INSERT INTO `schedule_job_log` VALUES ('9', '1', 'SendMsgJob', 'hello', '1', null, '739', '2019-10-23 16:47:00');
INSERT INTO `schedule_job_log` VALUES ('10', '1', 'SendMsgJob', 'hello', '1', null, '16', '2019-10-23 16:47:30');
INSERT INTO `schedule_job_log` VALUES ('11', '1', 'SendMsgJob', 'hello', '1', null, '19', '2019-10-23 16:48:00');
INSERT INTO `schedule_job_log` VALUES ('12', '1', 'SendMsgJob', 'hello', '1', null, '518', '2019-10-23 16:52:00');
INSERT INTO `schedule_job_log` VALUES ('13', '1', 'SendMsgJob', 'hello', '1', null, '17', '2019-10-23 16:52:30');
INSERT INTO `schedule_job_log` VALUES ('14', '1', 'SendMsgJob', 'hello', '1', null, '13', '2019-10-23 16:53:00');
INSERT INTO `schedule_job_log` VALUES ('15', '1', 'SendMsgJob', 'hello', '1', null, '505', '2019-10-23 16:55:30');
INSERT INTO `schedule_job_log` VALUES ('16', '1', 'SendMsgJob', 'hello', '1', null, '8', '2019-10-23 16:56:00');
INSERT INTO `schedule_job_log` VALUES ('17', '1', 'SendMsgJob', 'hello', '1', null, '17', '2019-10-23 16:56:30');
INSERT INTO `schedule_job_log` VALUES ('18', '1', 'SendMsgJob', 'hello', '1', null, '18', '2019-10-23 16:57:00');
INSERT INTO `schedule_job_log` VALUES ('19', '1', 'SendMsgJob', 'hello', '1', null, '14', '2019-10-23 16:57:30');
INSERT INTO `schedule_job_log` VALUES ('20', '1', 'SendMsgJob', 'hello', '1', null, '13', '2019-10-23 16:58:00');
INSERT INTO `schedule_job_log` VALUES ('21', '1', 'SendMsgJob', 'hello', '1', null, '14', '2019-10-23 16:58:30');
INSERT INTO `schedule_job_log` VALUES ('22', '1', 'SendMsgJob', 'hello', '1', null, '8', '2019-10-23 16:59:00');
INSERT INTO `schedule_job_log` VALUES ('23', '1', 'SendMsgJob', 'hello', '1', null, '9', '2019-10-23 16:59:30');
INSERT INTO `schedule_job_log` VALUES ('24', '1', 'SendMsgJob', 'hello', '1', null, '12152', '2019-10-23 17:00:00');
INSERT INTO `schedule_job_log` VALUES ('25', '1', 'SendMsgJob', 'hello', '1', null, '10443', '2019-10-23 17:00:30');
INSERT INTO `schedule_job_log` VALUES ('26', '1', 'SendMsgJob', 'hello', '1', null, '19', '2019-10-23 17:01:00');
INSERT INTO `schedule_job_log` VALUES ('27', '1', 'SendMsgJob', 'hello', '1', null, '483', '2019-10-23 17:10:00');
INSERT INTO `schedule_job_log` VALUES ('28', '1', 'SendMsgJob', 'hello', '1', null, '19', '2019-10-23 17:10:15');
INSERT INTO `schedule_job_log` VALUES ('29', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:10:30');
INSERT INTO `schedule_job_log` VALUES ('30', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:10:45');
INSERT INTO `schedule_job_log` VALUES ('31', '1', 'SendMsgJob', 'hello', '1', null, '14', '2019-10-23 17:11:00');
INSERT INTO `schedule_job_log` VALUES ('32', '1', 'SendMsgJob', 'hello', '1', null, '66', '2019-10-23 17:11:15');
INSERT INTO `schedule_job_log` VALUES ('33', '1', 'SendMsgJob', 'hello', '1', null, '15', '2019-10-23 17:11:30');
INSERT INTO `schedule_job_log` VALUES ('34', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:11:45');
INSERT INTO `schedule_job_log` VALUES ('35', '1', 'SendMsgJob', 'hello', '1', null, '20', '2019-10-23 17:12:00');
INSERT INTO `schedule_job_log` VALUES ('36', '1', 'SendMsgJob', 'hello', '1', null, '9', '2019-10-23 17:12:15');
INSERT INTO `schedule_job_log` VALUES ('37', '1', 'SendMsgJob', 'hello', '1', null, '9', '2019-10-23 17:12:30');
INSERT INTO `schedule_job_log` VALUES ('38', '1', 'SendMsgJob', 'hello', '1', null, '12', '2019-10-23 17:12:45');
INSERT INTO `schedule_job_log` VALUES ('39', '1', 'SendMsgJob', 'hello', '1', null, '14', '2019-10-23 17:13:00');
INSERT INTO `schedule_job_log` VALUES ('40', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:13:15');
INSERT INTO `schedule_job_log` VALUES ('41', '1', 'SendMsgJob', 'hello', '1', null, '608', '2019-10-23 17:15:15');
INSERT INTO `schedule_job_log` VALUES ('42', '1', 'SendMsgJob', 'hello', '1', null, '12', '2019-10-23 17:15:30');
INSERT INTO `schedule_job_log` VALUES ('43', '1', 'SendMsgJob', 'hello', '1', null, '16', '2019-10-23 17:15:45');
INSERT INTO `schedule_job_log` VALUES ('44', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:16:00');
INSERT INTO `schedule_job_log` VALUES ('45', '1', 'SendMsgJob', 'hello', '1', null, '332', '2019-10-23 17:18:00');
INSERT INTO `schedule_job_log` VALUES ('46', '1', 'SendMsgJob', 'hello', '1', null, '15', '2019-10-23 17:18:15');
INSERT INTO `schedule_job_log` VALUES ('47', '1', 'SendMsgJob', 'hello', '1', null, '13', '2019-10-23 17:18:30');
INSERT INTO `schedule_job_log` VALUES ('48', '1', 'SendMsgJob', 'hello', '1', null, '19', '2019-10-23 17:18:45');
INSERT INTO `schedule_job_log` VALUES ('49', '1', 'SendMsgJob', 'hello', '1', null, '7', '2019-10-23 17:19:00');
INSERT INTO `schedule_job_log` VALUES ('50', '1', 'SendMsgJob', 'hello', '1', null, '13', '2019-10-23 17:19:15');
INSERT INTO `schedule_job_log` VALUES ('51', '1', 'SendMsgJob', 'hello', '1', null, '7', '2019-10-23 17:19:30');
INSERT INTO `schedule_job_log` VALUES ('52', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:19:45');
INSERT INTO `schedule_job_log` VALUES ('53', '1', 'SendMsgJob', 'hello', '1', null, '17', '2019-10-23 17:20:00');
INSERT INTO `schedule_job_log` VALUES ('54', '1', 'SendMsgJob', 'hello', '1', null, '549', '2019-10-23 17:22:30');
INSERT INTO `schedule_job_log` VALUES ('55', '1', 'SendMsgJob', 'hello', '1', null, '17', '2019-10-23 17:22:45');
INSERT INTO `schedule_job_log` VALUES ('56', '1', 'SendMsgJob', 'hello', '1', null, '13', '2019-10-23 17:23:00');
INSERT INTO `schedule_job_log` VALUES ('57', '1', 'SendMsgJob', 'hello', '1', null, '18', '2019-10-23 17:23:15');
INSERT INTO `schedule_job_log` VALUES ('58', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:23:30');
INSERT INTO `schedule_job_log` VALUES ('59', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:23:45');
INSERT INTO `schedule_job_log` VALUES ('60', '1', 'SendMsgJob', 'hello', '1', null, '18', '2019-10-23 17:24:00');
INSERT INTO `schedule_job_log` VALUES ('61', '1', 'SendMsgJob', 'hello', '1', null, '15', '2019-10-23 17:24:15');
INSERT INTO `schedule_job_log` VALUES ('62', '1', 'SendMsgJob', 'hello', '1', null, '13', '2019-10-23 17:24:30');
INSERT INTO `schedule_job_log` VALUES ('63', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:24:45');
INSERT INTO `schedule_job_log` VALUES ('64', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:25:00');
INSERT INTO `schedule_job_log` VALUES ('65', '1', 'SendMsgJob', 'hello', '1', null, '16', '2019-10-23 17:25:15');
INSERT INTO `schedule_job_log` VALUES ('66', '1', 'SendMsgJob', 'hello', '1', null, '18', '2019-10-23 17:25:30');
INSERT INTO `schedule_job_log` VALUES ('67', '1', 'SendMsgJob', 'hello', '1', null, '11', '2019-10-23 17:25:45');
INSERT INTO `schedule_job_log` VALUES ('68', '1', 'SendMsgJob', 'hello', '1', null, '20', '2019-10-23 17:26:00');
INSERT INTO `schedule_job_log` VALUES ('69', '1', 'SendMsgJob', 'hello', '1', null, '15', '2019-10-23 17:26:15');
INSERT INTO `schedule_job_log` VALUES ('70', '1', 'SendMsgJob', 'hello', '1', null, '7', '2019-10-23 17:26:30');
INSERT INTO `schedule_job_log` VALUES ('71', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:26:45');
INSERT INTO `schedule_job_log` VALUES ('72', '1', 'SendMsgJob', 'hello', '1', null, '5', '2019-10-23 17:27:00');
INSERT INTO `schedule_job_log` VALUES ('73', '1', 'SendMsgJob', 'hello', '1', null, '16', '2019-10-23 17:27:15');
INSERT INTO `schedule_job_log` VALUES ('74', '1', 'SendMsgJob', 'hello', '1', null, '12', '2019-10-23 17:27:30');
INSERT INTO `schedule_job_log` VALUES ('75', '1', 'SendMsgJob', 'hello', '1', null, '8', '2019-10-23 17:27:45');
INSERT INTO `schedule_job_log` VALUES ('76', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:28:00');
INSERT INTO `schedule_job_log` VALUES ('77', '1', 'SendMsgJob', 'hello', '1', null, '18', '2019-10-23 17:28:15');
INSERT INTO `schedule_job_log` VALUES ('78', '1', 'SendMsgJob', 'hello', '1', null, '17', '2019-10-23 17:28:30');
INSERT INTO `schedule_job_log` VALUES ('79', '1', 'SendMsgJob', 'hello', '1', null, '12', '2019-10-23 17:28:45');
INSERT INTO `schedule_job_log` VALUES ('80', '1', 'SendMsgJob', 'hello', '1', null, '624', '2019-10-23 17:32:00');
INSERT INTO `schedule_job_log` VALUES ('81', '1', 'SendMsgJob', 'hello', '1', null, '10', '2019-10-23 17:32:15');
INSERT INTO `schedule_job_log` VALUES ('82', '1', 'SendMsgJob', 'hello', '1', null, '7', '2019-10-23 17:32:30');
INSERT INTO `schedule_job_log` VALUES ('83', '1', 'SendMsgJob', 'hello', '1', null, '30', '2019-10-23 17:32:45');
INSERT INTO `schedule_job_log` VALUES ('84', '1', 'SendMsgJob', 'hello', '1', null, '31', '2019-10-23 17:33:00');
INSERT INTO `schedule_job_log` VALUES ('85', '1', 'SendMsgJob', 'hello', '1', null, '14', '2019-10-23 17:33:15');
INSERT INTO `schedule_job_log` VALUES ('86', '1', 'SendMsgJob', 'hello', '1', null, '16', '2019-10-23 17:33:30');
INSERT INTO `schedule_job_log` VALUES ('87', '1', 'SendMsgJob', 'hello', '1', null, '14', '2019-10-23 17:33:45');
INSERT INTO `schedule_job_log` VALUES ('88', '1', 'SendMsgJob', 'hello', '1', null, '11', '2019-10-23 17:34:00');
INSERT INTO `schedule_job_log` VALUES ('89', '1', 'SendMsgJob', 'hello', '0', null, '1007', '2019-10-23 17:38:00');
INSERT INTO `schedule_job_log` VALUES ('90', '1', 'SendMsgJob', 'hello', '0', null, '259', '2019-10-23 17:38:15');
INSERT INTO `schedule_job_log` VALUES ('91', '1', 'SendMsgJob', 'hello', '0', null, '809', '2019-10-23 17:42:00');
