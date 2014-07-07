/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : goodlife

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-05-27 18:36:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_t1`
-- ----------------------------
DROP TABLE IF EXISTS `admin_t1`;
CREATE TABLE `admin_t1` (
  `id` bigint(20) unsigned NOT NULL,
  `a_username` varchar(255) CHARACTER SET latin1 DEFAULT '' COMMENT '后端管理员用户名',
  `a_password` varchar(255) CHARACTER SET latin1 DEFAULT '' COMMENT '后端管理员密码',
  `salt` varchar(100) CHARACTER SET latin1 DEFAULT '' COMMENT '盐值',
  `is_locked` tinyint(1) unsigned DEFAULT '0' COMMENT '是否锁定(0-未锁定，1-锁定)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后端管理员用户表';

-- ----------------------------
-- Records of admin_t1
-- ----------------------------

-- ----------------------------
-- Table structure for `id_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `id_sequence`;
CREATE TABLE `id_sequence` (
  `table_name` varchar(45) NOT NULL COMMENT '对应的表名，确认是为哪个表生成主键。',
  `version` char(3) NOT NULL COMMENT '版本号，3位的英数字符串。用来区分是哪个数据库的哪个表生成的主键。',
  `next_val` bigint(20) unsigned NOT NULL COMMENT '自增开始的值，没取一次主键就会增加一个步长。',
  `increment` tinyint(3) unsigned NOT NULL COMMENT '主键生成表的，主键自增步长。',
  PRIMARY KEY (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='ID序列表。用来生成各个表的主键。';

-- ----------------------------
-- Records of id_sequence
-- ----------------------------
INSERT INTO `id_sequence` VALUES ('admin', '001', '4', '1');

-- ----------------------------
-- Table structure for `shiro_permissions_t1`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permissions_t1`;
CREATE TABLE `shiro_permissions_t1` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'ID，主键',
  `permission` varchar(100) DEFAULT NULL COMMENT '资源',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `is_available` tinyint(1) unsigned DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Shiro权限管理，资源表。';

-- ----------------------------
-- Records of shiro_permissions_t1
-- ----------------------------

-- ----------------------------
-- Table structure for `shiro_roles_permissions_t1`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_roles_permissions_t1`;
CREATE TABLE `shiro_roles_permissions_t1` (
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色ID',
  `permission_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '资源ID',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Shiro权限管理，角色-资源对应关系表';

-- ----------------------------
-- Records of shiro_roles_permissions_t1
-- ----------------------------

-- ----------------------------
-- Table structure for `shiro_roles_t1`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_roles_t1`;
CREATE TABLE `shiro_roles_t1` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'ID，主键',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `is_available` tinyint(1) unsigned DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Shiro权限管理，角色表';

-- ----------------------------
-- Records of shiro_roles_t1
-- ----------------------------

-- ----------------------------
-- Table structure for `shiro_users_roles_t1`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_users_roles_t1`;
CREATE TABLE `shiro_users_roles_t1` (
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色ID',
  `user_type` tinyint(3) unsigned NOT NULL COMMENT '用户类型，不同用户类型分属不同的表',
  `user_from` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户所属表名',
  PRIMARY KEY (`user_id`,`role_id`,`user_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Shiro权限管理，用户-角色关系表。用户分为前台用户、后台管理员用户两种（分属不同的表），通过标识符区分不同的表，用户类型可能增加';

-- ----------------------------
-- Records of shiro_users_roles_t1
-- ----------------------------

-- ----------------------------
-- Table structure for `users_t1`
-- ----------------------------
DROP TABLE IF EXISTS `users_t1`;
CREATE TABLE `users_t1` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'ID，主键',
  `username` varchar(100) NOT NULL DEFAULT '' COMMENT '网站前端用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '网站前端用户密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `locked` tinyint(1) unsigned DEFAULT '0' COMMENT '用户是否被锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站前端用户表';

-- ----------------------------
-- Records of users_t1
-- ----------------------------
