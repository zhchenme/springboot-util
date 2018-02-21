DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `area_id` int(2) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(20) NOT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
