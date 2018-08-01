# Host: localhost  (Version 5.6.26-log)
# Date: 2018-07-30 15:36:41
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "m_order"
#

DROP TABLE IF EXISTS `m_order`;
CREATE TABLE `m_order` (
  `id` varchar(100) NOT NULL COMMENT '订单标识',
  `user_id` varchar(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `start_time` datetime DEFAULT NULL COMMENT '出发时间',
  `create_time` datetime DEFAULT NULL COMMENT '订单生产时间',
  `expect_time` datetime DEFAULT NULL COMMENT '期望时间',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态：0：未支付，1：支付，2：取消',
  `order_type` int(11) DEFAULT NULL COMMENT '订单种类：0：人，1：货物',
  `weight` int(11) DEFAULT NULL COMMENT '货物重量',
  `quantity` int(11) DEFAULT NULL COMMENT '人数',
  `scheme` int(11) DEFAULT NULL COMMENT '出行方案：0：时间最少，1：步行最少，2：价格最优，3：换乘最少，4：停靠站点最少',
  `total_price` int(11) DEFAULT NULL COMMENT '总价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "m_order"
#

INSERT INTO `m_order` VALUES ('20180730','1001','2018-07-30 15:32:05','2018-07-30 17:32:05','2018-07-30 17:32:05',1,1,90,2,1,90);
