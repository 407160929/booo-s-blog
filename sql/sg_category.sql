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

 Date: 30/12/2022 21:36:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sg_category
-- ----------------------------
DROP TABLE IF EXISTS `sg_category`;
CREATE TABLE `sg_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名',
  `pid` bigint NULL DEFAULT -1 COMMENT '父分类id，如果没有父分类为-1',
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '状态0:正常,1禁用',
  `create_by` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` int NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sg_category
-- ----------------------------
INSERT INTO `sg_category` VALUES (1, 'java', -1, 'wsd', '0', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sg_category` VALUES (2, 'PHP', -1, 'wsd', '0', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sg_category` VALUES (15, 'c#', -1, 'c#文章11', '0', 1, '2022-12-29 00:31:34', 1, '2022-12-29 00:35:44', 1);
INSERT INTO `sg_category` VALUES (16, 'c#', -1, 'test', '0', 1, '2022-12-29 19:18:43', 1, '2022-12-29 19:18:43', 0);

SET FOREIGN_KEY_CHECKS = 1;
