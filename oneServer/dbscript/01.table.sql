
CREATE TABLE `t_pic` (
  `picId` VARCHAR(32) NOT NULL COMMENT '图片id',
  `dir` VARCHAR(100) COMMENT '相对路径',
  `url` VARCHAR(200) COMMENT '访问地址',
  `type` VARCHAR(2) COMMENT '图片类型 0 头像 1 图片',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`picId`)
);
CREATE UNIQUE INDEX i_picId ON t_pic(picId);

CREATE TABLE `t_user` (
  `UserId` VARCHAR(32) NOT NULL COMMENT '用户id',
  `Account` VARCHAR(32) NOT NULL COMMENT '账号',
  `name` VARCHAR(32) COMMENT '用户名(昵称)',
  `password` VARCHAR(32) NOT NULL COMMENT '密码，默认12345',
  `enabled` VARCHAR(1) COMMENT '使能：1 启用 2 禁用，默认启用',
  `age` VARCHAR(3) NOT NULL COMMENT '年龄',
  `sex` VARCHAR(1) COMMENT '性别，0：男，1：女，默认0',
  `phone` VARCHAR(32) NOT NULL COMMENT '联系电话',
  `email` VARCHAR(32) COMMENT '邮箱',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`UserId`)
);
CREATE UNIQUE INDEX i_userAccount ON t_user(Account);
