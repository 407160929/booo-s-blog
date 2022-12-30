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

 Date: 30/12/2022 21:37:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '用户类型：0代表普通用户，1代表管理员',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phonenumber` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人的用户id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` int NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14787164048668 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'xuan', 'booo', '$2a$10$Jnq31rRkNV3RNzXe0REsEOSKaYK8UgVZZqlNlNXqn.JeVcj2NdeZy', '1', '0', '407160929@qq.com', '15997405796', '0', 'http://rnemav2df.hn-bkt.clouddn.com/2022/12/25/4def4da589814edfb81a48c36f3d436b.jpeg', NULL, '2022-01-05 09:01:56', NULL, '2022-12-29 19:16:29', 0);
INSERT INTO `sys_user` VALUES (3, 'sg3', 'weqe', '$2a$10$ydv3rLkteFnRx9xelQ7elOiVhFvXOooA98xCqk/omh7G94R.K/E3O', '1', '0', NULL, NULL, '0', NULL, NULL, '2022-01-05 13:28:43', NULL, '2022-01-05 13:28:43', 1);
INSERT INTO `sys_user` VALUES (4, 'sg2', 'dsadd', '$2a$10$kY4T3SN7i4muBccZppd2OOkhxMN6yt8tND1sF89hXOaFylhY2T3he', '1', '0', '23412332@qq.com', '19098790742', '0', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (5, 'sg2233', 'tteqe', '', '1', '0', NULL, '18246845873', '1', NULL, NULL, '2022-01-06 03:51:13', NULL, '2022-01-06 07:00:50', 0);
INSERT INTO `sys_user` VALUES (6, 'sangeng', 'sangeng', '$2a$10$Jnq31rRkNV3RNzXe0REsEOSKaYK8UgVZZqlNlNXqn.JeVcj2NdeZy', '1', '0', '2312321', '17777777777', '0', NULL, NULL, '2022-01-16 06:54:26', NULL, '2022-01-16 07:06:34', 0);
INSERT INTO `sys_user` VALUES (14787164048662, 'weixin', 'weixin', '$2a$10$y3k3fnMZsBNihsVLXWfI8uMNueVXBI08k.LzWYaKsW8CW7xXy18wC', '0', '0', 'weixin@qq.com', NULL, NULL, NULL, -1, '2022-01-30 17:18:44', -1, '2022-01-30 17:18:44', 1);
INSERT INTO `sys_user` VALUES (14787164048663, '407160929', 'boooooo', '$2a$10$umsBq0G3mk7roV6PtHpXmOgo3tMoDTKJzPfER/WrYPEpS8GwzdMw2', '0', '0', '407160929@qq.com', NULL, '1', 'http://rnemav2df.hn-bkt.clouddn.com/2022/12/25/78929d820052444fa14b593ad2491ef7.png', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (14787164048664, 'booo', 'wangyangxuan', '$2a$10$TMJ.KYPVA/lDZRvx4mINoOIZLKeYD58.uMAPTwG5h9EfRyuDX.MiK', '0', '0', '372547693@qq.com', '15997405796', '0', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (14787164048665, 'boooooo', 'booo0', '$2a$10$cbjB8SNxWmz/vVF0A26PvenAw8bvuJ4oEff3JpCfEUq5ZMRvA3cyG', '0', '0', '37254769@qq.com', '15997405797', '0', 'http://rnemav2df.hn-bkt.clouddn.com/2022/12/29/cb3425397a6f46aab2b5b3c95c05f908.JPG', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (14787164048667, 'bowww', '1234', '$2a$10$A5rrQe/xf2blmTEGCX8MY.CoNWHBTbtejcDM4xv78qTs.tDHBTl/a', '0', '0', '8273878@qq.com', '15009786574', '0', NULL, 1, '2022-12-29 19:30:48', NULL, '2022-12-29 19:47:31', 0);

SET FOREIGN_KEY_CHECKS = 1;
