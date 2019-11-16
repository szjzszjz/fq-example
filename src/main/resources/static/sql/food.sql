/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50718

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 16/11/2019 13:21:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已删除',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '食品名称',
  `is_size` bit(1) NOT NULL COMMENT '是否存在规格',
  `sort` int(10) NOT NULL COMMENT '序號',
  `no` int(10) NOT NULL DEFAULT 0 COMMENT '编号',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类ID',
  `current_price` decimal(8, 2) NOT NULL COMMENT '单价/现价',
  `original_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '原价',
  `size` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `stock` int(11) NOT NULL COMMENT '库存',
  `praise_count` int(20) NOT NULL DEFAULT 0 COMMENT '点赞数量',
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '食品图片链接',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'selling' COMMENT '{enum: selling(\"上架\"), unsell(\"下架\")}',
  `create_by` bigint(20) NOT NULL COMMENT '操作者ID',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1166 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '食品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (1160, '2019-10-13 23:01:08', '2019-11-15 16:18:57', b'0', '手撕面包', b'0', 1, 0, 1163, 12.00, 13.00, NULL, 93, 0, '可爱的面包 好吃还实惠', 'https://img14.360buyimg.com/n5/jfs/t17191/147/952721637/122205/ab54aee5/5ab3238dN46de731b.jpg', 'selling', 56, NULL);
INSERT INTO `food` VALUES (1161, '2019-10-13 23:11:44', '2019-11-15 16:18:48', b'0', '红糖麻花', b'0', 2, 0, 1163, 8.00, 7.00, NULL, 118, 0, '百草味 香酥传统糕点义乌特产 童年网红休闲零食小吃点心 红糖麻花120g/袋', 'https://img11.360buyimg.com/n5/jfs/t17683/149/1996651805/368071/b345ce0d/5ae17ed2N4b77f289.jpg', 'selling', 56, NULL);
INSERT INTO `food` VALUES (1162, '2019-10-13 23:13:52', '2019-11-15 16:19:05', b'0', '椰蓉球手撕面包', b'0', 3, 0, 1163, 19.00, 22.00, NULL, 253, 0, '百草味 椰丝球210g/袋 休闲零食小吃饼干糕点甜点小吃点心椰蓉球手撕面包', 'https://img14.360buyimg.com/n5/jfs/t17440/216/1484532558/143856/1c86e8e5/5acd8010N19a88cfd.jpg', 'selling', 56, NULL);
INSERT INTO `food` VALUES (1163, '2019-10-27 22:20:02', '2019-11-11 10:08:49', b'0', '炸鸡腿', b'0', 4, 0, 1165, 33.80, 38.90, NULL, 96, 0, NULL, 'https://img10.360buyimg.com/n7/jfs/t1/59145/34/14034/492744/5dae7dfaE77539175/79922b4dd5ec7f61.jpg', 'selling', 56, NULL);
INSERT INTO `food` VALUES (1164, '2019-10-27 22:22:23', '2019-11-11 10:08:51', b'0', '美味卤鸭', b'0', 5, 0, 1164, 98.00, 130.00, NULL, 96, 0, '杏花楼 中华老字号 盒装八宝鸭750g酱鸭真空包装卤鸭上海传统食品全鸭熟食年货礼盒装开袋即食', 'https://img13.360buyimg.com/n7/jfs/t13069/327/782942604/261042/2292017e/5a13fa25Nb5f25122.jpg', 'selling', 56, NULL);
INSERT INTO `food` VALUES (1165, '2019-11-06 19:27:01', '2019-11-11 10:08:54', b'0', '无穷 熟食卤味鸭小腿', b'0', 6, 0, 1166, 47.90, 51.80, NULL, 95, 0, '480g酱卤鸭翅根 麻辣小吃 真空包装', 'https://img11.360buyimg.com/n1/jfs/t30226/8/591965578/212829/1cf2453b/5bf7c98eN73eef620.jpg', 'selling', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
