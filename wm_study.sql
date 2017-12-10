/*
Navicat MySQL Data Transfer

Source Server         : Sqlconnect
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : wm_study

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-12-10 12:36:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wm_apply
-- ----------------------------
DROP TABLE IF EXISTS `wm_apply`;
CREATE TABLE `wm_apply` (
  `app_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(8) unsigned NOT NULL,
  `job_id` int(8) unsigned NOT NULL,
  `app_date` datetime DEFAULT NULL,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_apply
-- ----------------------------
INSERT INTO `wm_apply` VALUES ('1', '3', '1', '2017-12-09 14:19:22');
INSERT INTO `wm_apply` VALUES ('2', '3', '2', '2017-12-09 14:23:44');
INSERT INTO `wm_apply` VALUES ('3', '6', '4', '2017-12-09 14:26:39');
INSERT INTO `wm_apply` VALUES ('5', '6', '5', '2017-12-09 16:03:06');
INSERT INTO `wm_apply` VALUES ('6', '6', '2', '2017-12-09 16:35:26');
INSERT INTO `wm_apply` VALUES ('7', '6', '1', '2017-12-09 20:52:41');
INSERT INTO `wm_apply` VALUES ('8', '6', '6', '2017-12-10 10:48:47');

-- ----------------------------
-- Table structure for wm_job
-- ----------------------------
DROP TABLE IF EXISTS `wm_job`;
CREATE TABLE `wm_job` (
  `job_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) DEFAULT NULL,
  `job_bewrite` varchar(255) DEFAULT NULL,
  `user_id` int(8) unsigned DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_job
-- ----------------------------
INSERT INTO `wm_job` VALUES ('1', 'Java程序员1', '想要一个做Java的程序员1', '1');
INSERT INTO `wm_job` VALUES ('2', 'PHP程序员2', '想要一个做PHP的程序员2', '1');
INSERT INTO `wm_job` VALUES ('4', '卖床单', '想找一个卖床单的', '2');
INSERT INTO `wm_job` VALUES ('5', '卖西服', '想找一个卖西服的', '2');
INSERT INTO `wm_job` VALUES ('6', '洗衣服', '我想找个人给我洗衣服', '2');
INSERT INTO `wm_job` VALUES ('7', '洗衣服', '我也想有个人给我洗衣服', '1');

-- ----------------------------
-- Table structure for wm_permission
-- ----------------------------
DROP TABLE IF EXISTS `wm_permission`;
CREATE TABLE `wm_permission` (
  `per_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `per_name` varchar(255) DEFAULT NULL,
  `per_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_permission
-- ----------------------------
INSERT INTO `wm_permission` VALUES ('1', '查看自己简历', 'resume:select');
INSERT INTO `wm_permission` VALUES ('2', '修改自己简历', 'resume:update');
INSERT INTO `wm_permission` VALUES ('3', '提交自己简历', 'apply:insert');
INSERT INTO `wm_permission` VALUES ('4', '自己申请列表', 'apply:userlist');
INSERT INTO `wm_permission` VALUES ('5', '本公司已发布职位', 'comJob:select');
INSERT INTO `wm_permission` VALUES ('6', '修改本公司职位', 'comJob:update');
INSERT INTO `wm_permission` VALUES ('7', '添加职位页面', 'comJob:addPage');
INSERT INTO `wm_permission` VALUES ('8', '本公司添加职位', 'comJob:insert');
INSERT INTO `wm_permission` VALUES ('9', '删除本公司职位', 'comJob:delete');
INSERT INTO `wm_permission` VALUES ('10', '查看申请本公司职位的人', 'apply:comlist');
INSERT INTO `wm_permission` VALUES ('11', '查看申请人简历', 'resume:byapply');

-- ----------------------------
-- Table structure for wm_resume
-- ----------------------------
DROP TABLE IF EXISTS `wm_resume`;
CREATE TABLE `wm_resume` (
  `res_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `res_gender` enum('男','女') DEFAULT NULL,
  `res_phone` varchar(255) DEFAULT NULL,
  `user_id` int(8) unsigned NOT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_resume
-- ----------------------------
INSERT INTO `wm_resume` VALUES ('1', '女', '13214944384', '3');
INSERT INTO `wm_resume` VALUES ('2', '男', '17604890365', '6');

-- ----------------------------
-- Table structure for wm_role
-- ----------------------------
DROP TABLE IF EXISTS `wm_role`;
CREATE TABLE `wm_role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_role
-- ----------------------------
INSERT INTO `wm_role` VALUES ('1', 'com');
INSERT INTO `wm_role` VALUES ('2', 'can');

-- ----------------------------
-- Table structure for wm_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `wm_role_permission`;
CREATE TABLE `wm_role_permission` (
  `role_id` int(8) unsigned NOT NULL,
  `per_id` int(8) unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_role_permission
-- ----------------------------
INSERT INTO `wm_role_permission` VALUES ('1', '5');
INSERT INTO `wm_role_permission` VALUES ('1', '6');
INSERT INTO `wm_role_permission` VALUES ('1', '7');
INSERT INTO `wm_role_permission` VALUES ('1', '8');
INSERT INTO `wm_role_permission` VALUES ('1', '9');
INSERT INTO `wm_role_permission` VALUES ('1', '10');
INSERT INTO `wm_role_permission` VALUES ('1', '11');
INSERT INTO `wm_role_permission` VALUES ('2', '1');
INSERT INTO `wm_role_permission` VALUES ('2', '2');
INSERT INTO `wm_role_permission` VALUES ('2', '3');
INSERT INTO `wm_role_permission` VALUES ('2', '4');

-- ----------------------------
-- Table structure for wm_user
-- ----------------------------
DROP TABLE IF EXISTS `wm_user`;
CREATE TABLE `wm_user` (
  `uid` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_user
-- ----------------------------
INSERT INTO `wm_user` VALUES ('1', 'root', '123456');
INSERT INTO `wm_user` VALUES ('2', 'admin', '123456');
INSERT INTO `wm_user` VALUES ('3', '高婷', '123456');
INSERT INTO `wm_user` VALUES ('6', '刘容雨', '123456');

-- ----------------------------
-- Table structure for wm_user_role
-- ----------------------------
DROP TABLE IF EXISTS `wm_user_role`;
CREATE TABLE `wm_user_role` (
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wm_user_role
-- ----------------------------
INSERT INTO `wm_user_role` VALUES ('1', '1');
INSERT INTO `wm_user_role` VALUES ('2', '1');
INSERT INTO `wm_user_role` VALUES ('3', '2');
INSERT INTO `wm_user_role` VALUES ('6', '2');
SET FOREIGN_KEY_CHECKS=1;
