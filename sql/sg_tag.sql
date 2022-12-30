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

 Date: 30/12/2022 21:37:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sg_tag
-- ----------------------------
DROP TABLE IF EXISTS `sg_tag`;
CREATE TABLE `sg_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签名',
  `create_by` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` int NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sg_tag
-- ----------------------------
INSERT INTO `sg_tag` VALUES (1, 'Mybatis', NULL, NULL, NULL, '2022-12-27 00:35:03', 0, '可以很秀');
INSERT INTO `sg_tag` VALUES (2, 'asdas', NULL, '2022-01-11 09:20:55', NULL, '2022-01-11 09:20:55', 1, 'weqw');
INSERT INTO `sg_tag` VALUES (3, 'weqw', NULL, '2022-01-11 09:21:07', NULL, '2022-01-11 09:21:07', 1, 'qweqwe');
INSERT INTO `sg_tag` VALUES (4, 'Java', NULL, '2022-01-13 15:22:43', NULL, '2022-01-13 15:22:43', 0, 'sdad');
INSERT INTO `sg_tag` VALUES (5, 'WAD', NULL, '2022-01-13 15:22:47', NULL, '2022-12-29 22:10:21', 0, '222');
INSERT INTO `sg_tag` VALUES (6, 'c++', 1, '2022-12-27 00:15:29', 1, '2022-12-27 00:15:29', 1, 'c++文章');

SET FOREIGN_KEY_CHECKS = 1;
