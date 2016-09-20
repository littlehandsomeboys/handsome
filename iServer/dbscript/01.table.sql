

CREATE TABLE `t_SiteUser` (
  `id` VARCHAR(32) NOT NULL COMMENT 'id',
  `userName` VARCHAR(32) NOT NULL COMMENT '账号',
  `name` VARCHAR(32) COMMENT '姓名',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `authorities` VARCHAR(32) NOT NULL COMMENT '权限类型：1 超级管理员 2 企业管理员',
  `enabled` VARCHAR(1) NOT NULL default 1 COMMENT '使能：1 启用 2 禁用',
  `age` VARCHAR(3) COMMENT '年龄',
  `sex` VARCHAR(1) NOT NULL default 0 COMMENT '性别，0：男，1：女',
  PRIMARY KEY (`id`)
) ;