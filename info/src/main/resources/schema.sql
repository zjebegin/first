-- ----------------------------
-- Table structure for music_info
-- ----------------------------
DROP TABLE IF EXISTS `music_info`;
CREATE TABLE `music_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `singer_name` varchar(100) NOT NULL COMMENT '歌手名',
  `music_size` varchar(100) NOT NULL COMMENT '歌曲大小',
  `music_name` varchar(100) NOT NULL COMMENT '歌曲名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music_info
-- ----------------------------
INSERT INTO `music_info` VALUES ('1', '小三', '3.2M', '起风了');
INSERT INTO `music_info` VALUES ('2', '刘德华', '3.0M', '忘情水');
INSERT INTO `music_info` VALUES ('3', '猪点点', '5.0M', '会写程序的小猪');