
/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : ssxx_shiro

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-03-12 17:27:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions` VALUES ('1', 'user:create', '用户模块新增', '1');
INSERT INTO `sys_permissions` VALUES ('2', 'user:update', '用户模块修改', '1');
INSERT INTO `sys_permissions` VALUES ('3', 'menu:create', '菜单模块新增', '1');
INSERT INTO `sys_permissions` VALUES ('4', 'user:hello111', '测试1', '1');
INSERT INTO `sys_permissions` VALUES ('5', 'user:hello2', '测试2', '1');

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', 'admin', '管理员', '1');
INSERT INTO `sys_roles` VALUES ('2', 'user', '用户管理员', '1');

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------
INSERT INTO `sys_roles_permissions` VALUES ('1', '1');
INSERT INTO `sys_roles_permissions` VALUES ('1', '2');
INSERT INTO `sys_roles_permissions` VALUES ('1', '3');
INSERT INTO `sys_roles_permissions` VALUES ('1', '4');
INSERT INTO `sys_roles_permissions` VALUES ('2', '1');
INSERT INTO `sys_roles_permissions` VALUES ('2', '2');
INSERT INTO `sys_roles_permissions` VALUES ('2', '5');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'zhang', '6f144917dfa6af5828c8562e9d8e8ddf', 'ba3fbd9116e68fc32ffd8a912349d63a', '0');
INSERT INTO `sys_users` VALUES ('2', 'li', 'b045e8292bbdfe9db899a6b56b3bc461', '612767570e8068b6fa974b575bf77e4a', '0');
INSERT INTO `sys_users` VALUES ('3', 'wu', '63e42e05e780600f6bcf809a469749db', 'ccf4d8403e5743f4b11812c7f2299761', '0');
INSERT INTO `sys_users` VALUES ('4', 'wang', '3284cdcc1a4f2fec93c03af127df8ad7', 'fc8a17ec4652f0ebd888d3de000e0aa6', '1');

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('1', '1');
INSERT INTO `sys_users_roles` VALUES ('2', '2');