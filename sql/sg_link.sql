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

 Date: 30/12/2022 21:37:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sg_link
-- ----------------------------
DROP TABLE IF EXISTS `sg_link`;
CREATE TABLE `sg_link`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `logo` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网站地址',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '2' COMMENT '审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)',
  `create_by` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` int NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '友链' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sg_link
-- ----------------------------
INSERT INTO `sg_link` VALUES (1, 'sda', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F05%2F10%2F146286696706220328.PNG&refer=http%3A%2F%2Fn1.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646205529&t=f942665181eb9b0685db7a6f59d59975', 'sda', 'https://www.baidu.com', '0', NULL, '2022-01-13 08:25:47', NULL, '2022-01-13 08:36:14', 0);
INSERT INTO `sg_link` VALUES (2, 'sda', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F05%2F10%2F146286696706220328.PNG&refer=http%3A%2F%2Fn1.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646205529&t=f942665181eb9b0685db7a6f59d59975', 'dada', 'https://www.qq.com', '0', NULL, '2022-01-13 09:06:10', NULL, '2022-01-13 09:07:09', 1);
INSERT INTO `sg_link` VALUES (3, 'sa', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F05%2F10%2F146286696706220328.PNG&refer=http%3A%2F%2Fn1.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646205529&t=f942665181eb9b0685db7a6f59d59975', 'da', 'https://www.taobao.com', '0', NULL, '2022-01-13 09:23:01', NULL, '2022-01-13 09:23:01', 1);
INSERT INTO `sg_link` VALUES (4, '主页', '', '我的主页', 'https://www.jianfast.com/', '2', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sg_link` VALUES (5, 'test', 'test', 'testtest', 'https://www.jianfast.com/', '1', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sg_link` VALUES (6, 'test', 'test', 'testtest', 'testtest', '1', 14787164048667, '2022-12-29 23:23:53', NULL, '2022-12-29 23:23:56', 0);

SET FOREIGN_KEY_CHECKS = 1;
