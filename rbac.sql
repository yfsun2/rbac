/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 28/07/2020 13:50:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(20) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `action` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(1) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1287588426936934402, '增加用户', '/addUser', 1, 0, '2020-07-27 11:19:38', '2020-07-27 11:19:38');
INSERT INTO `permission` VALUES (1287592426985930753, '查询所有用户', '/getAllUser', 1, 0, '2020-07-27 11:35:32', '2020-07-27 11:35:32');
INSERT INTO `permission` VALUES (1287594123971969026, '更新用户', '/updateUser', 1, 0, '2020-07-27 11:42:16', '2020-07-27 11:42:16');
INSERT INTO `permission` VALUES (1287594281354838018, '删除用户', '/deleteUser', 1, 0, '2020-07-27 11:42:54', '2020-07-27 11:42:54');
INSERT INTO `permission` VALUES (1287594371100360705, '给用户设置角色', '/setRole', 1, 0, '2020-07-27 11:43:15', '2020-07-27 11:43:15');
INSERT INTO `permission` VALUES (1287594610054053889, '添加角色', '/addRole', 1, 0, '2020-07-27 11:44:12', '2020-07-27 11:44:12');
INSERT INTO `permission` VALUES (1287594729872736258, '查询所有角色', '/getAllRole', 1, 0, '2020-07-27 11:44:41', '2020-07-27 11:44:41');
INSERT INTO `permission` VALUES (1287594795094163457, '更新角色', '/updateRole', 1, 0, '2020-07-27 11:44:56', '2020-07-27 11:44:56');
INSERT INTO `permission` VALUES (1287594852816175106, '删除角色', '/deleteRole', 1, 0, '2020-07-27 11:45:10', '2020-07-27 11:45:10');
INSERT INTO `permission` VALUES (1287594967366811650, '给角色设置权限', '/setPermission', 1, 0, '2020-07-27 11:45:37', '2020-07-27 11:45:37');
INSERT INTO `permission` VALUES (1287595040167346178, '添加权限', '/addPermission', 1, 0, '2020-07-27 11:45:55', '2020-07-27 11:45:55');
INSERT INTO `permission` VALUES (1287595325761699841, '查询所有权限', '/getAllPermission', 1, 0, '2020-07-27 11:47:03', '2020-07-27 11:47:03');
INSERT INTO `permission` VALUES (1287595402232250370, '更新权限', '/updatePermission', 1, 0, '2020-07-27 11:47:21', '2020-07-27 11:47:21');
INSERT INTO `permission` VALUES (1287595455231475713, '删除权限', '/deletePermission', 1, 0, '2020-07-27 11:47:34', '2020-07-27 11:47:34');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(1) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1287586291771969538, 'ROLE_ADMIN', 1, 0, '2020-07-27 11:11:09', '2020-07-27 11:11:09');
INSERT INTO `role` VALUES (1287586312328253441, 'ROLE_USER', 1, 0, '2020-07-27 11:11:14', '2020-07-27 11:11:14');
INSERT INTO `role` VALUES (1287586331663994882, 'ROLE_VIP', 1, 0, '2020-07-27 11:11:18', '2020-07-27 11:11:18');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE,
  INDEX `permission_id`(`permission_id`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287588426936934402, '2020-07-27 13:20:25');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287592426985930753, '2020-07-27 13:20:42');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594123971969026, '2020-07-27 13:20:58');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594281354838018, '2020-07-27 13:21:12');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594371100360705, '2020-07-28 12:33:45');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594610054053889, '2020-07-28 12:34:17');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594729872736258, '2020-07-28 12:34:28');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594795094163457, '2020-07-28 12:34:39');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594852816175106, '2020-07-28 12:34:47');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287594967366811650, '2020-07-28 12:34:58');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287595040167346178, '2020-07-28 12:35:18');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287595325761699841, '2020-07-28 12:35:31');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287595402232250370, '2020-07-28 12:35:41');
INSERT INTO `role_permission` VALUES (1287586291771969538, 1287595455231475713, '2020-07-28 12:35:50');
INSERT INTO `role_permission` VALUES (1287586312328253441, 1287592426985930753, '2020-07-27 13:21:48');
INSERT INTO `role_permission` VALUES (1287586312328253441, 1287594729872736258, '2020-07-28 12:36:56');
INSERT INTO `role_permission` VALUES (1287586312328253441, 1287595325761699841, '2020-07-28 12:37:06');
INSERT INTO `role_permission` VALUES (1287586331663994882, 1287592426985930753, '2020-07-27 13:22:01');
INSERT INTO `role_permission` VALUES (1287586331663994882, 1287594123971969026, '2020-07-27 13:22:19');
INSERT INTO `role_permission` VALUES (1287586331663994882, 1287594729872736258, '2020-07-28 12:37:57');
INSERT INTO `role_permission` VALUES (1287586331663994882, 1287594795094163457, '2020-07-28 12:38:09');
INSERT INTO `role_permission` VALUES (1287586331663994882, 1287595325761699841, '2020-07-28 12:38:30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(1) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1287357628996579329, '张三', '123', 1, 0, '2020-07-26 20:02:31', '2020-07-26 20:02:31');
INSERT INTO `user` VALUES (1287435299818516482, '李四', '123', 1, 0, '2020-07-27 01:11:10', '2020-07-27 01:11:10');
INSERT INTO `user` VALUES (1287585851177111554, '小明', '123', 1, 0, '2020-07-27 11:09:24', '2020-07-27 11:09:24');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1287357628996579329, 1287586291771969538, '2020-07-27 12:45:44');
INSERT INTO `user_role` VALUES (1287435299818516482, 1287586312328253441, '2020-07-27 12:46:54');
INSERT INTO `user_role` VALUES (1287585851177111554, 1287586331663994882, '2020-07-27 12:47:46');

SET FOREIGN_KEY_CHECKS = 1;
