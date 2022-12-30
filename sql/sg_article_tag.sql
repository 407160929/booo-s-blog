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

 Date: 30/12/2022 21:36:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sg_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `sg_article_tag`;
CREATE TABLE `sg_article_tag`  (
  `article_id` bigint NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `tag_id` bigint NOT NULL DEFAULT 0 COMMENT '标签id',
  PRIMARY KEY (`article_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sg_article_tag
-- ----------------------------
INSERT INTO `sg_article_tag` VALUES (1, 4);
INSERT INTO `sg_article_tag` VALUES (2, 1);
INSERT INTO `sg_article_tag` VALUES (2, 4);
INSERT INTO `sg_article_tag` VALUES (3, 4);
INSERT INTO `sg_article_tag` VALUES (3, 5);
INSERT INTO `sg_article_tag` VALUES (8, 4);
INSERT INTO `sg_article_tag` VALUES (9, 1);
INSERT INTO `sg_article_tag` VALUES (9, 4);

SET FOREIGN_KEY_CHECKS = 1;
