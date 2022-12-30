/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : mydatabase

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 30/12/2022 21:38:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (5, 2);
INSERT INTO `sys_user_role` VALUES (6, 12);
INSERT INTO `sys_user_role` VALUES (14787164048664, 2);
INSERT INTO `sys_user_role` VALUES (14787164048665, 2);
INSERT INTO `sys_user_role` VALUES (14787164048665, 12);
INSERT INTO `sys_user_role` VALUES (14787164048666, 1);
INSERT INTO `sys_user_role` VALUES (14787164048666, 2);
INSERT INTO `sys_user_role` VALUES (14787164048666, 12);
INSERT INTO `sys_user_role` VALUES (14787164048667, 1);
INSERT INTO `sys_user_role` VALUES (14787164048667, 2);

SET FOREIGN_KEY_CHECKS = 1;
