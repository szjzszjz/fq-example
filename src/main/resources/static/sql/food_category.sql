/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50718

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 16/11/2019 13:21:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for food_category
-- ----------------------------
DROP TABLE IF EXISTS `food_category`;
CREATE TABLE `food_category`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已删除',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `sort` int(10) NOT NULL COMMENT '排序',
  `create_by` bigint(20) NOT NULL COMMENT '操作者ID',
  `status` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'enabled' COMMENT '状态 {enum: enabled(正常), disabled(禁用)}',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1169 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '熟食分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food_category
-- ----------------------------
INSERT INTO `food_category` VALUES (1163, '2019-10-27 22:07:18', '2019-11-11 09:30:48', b'0', '糕点', 1, 56, 'enabled', NULL);
INSERT INTO `food_category` VALUES (1164, '2019-10-27 22:08:17', '2019-11-11 09:45:19', b'0', '卤味', 2, 56, 'enabled', NULL);
INSERT INTO `food_category` VALUES (1165, '2019-10-27 22:09:01', '2019-11-11 09:30:52', b'0', '油炸', 3, 56, 'enabled', NULL);
INSERT INTO `food_category` VALUES (1166, '2019-11-06 19:26:16', '2019-11-11 09:30:55', b'0', '小吃美食', 4, 1, 'enabled', NULL);
INSERT INTO `food_category` VALUES (1168, '2019-11-10 21:38:45', '2019-11-10 21:38:45', b'0', '测试', 5, 1, 'enabled', NULL);

SET FOREIGN_KEY_CHECKS = 1;
