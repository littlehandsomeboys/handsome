
--CREATE TABLE `t_SiteUser` (
--  `id` VARCHAR(32) NOT NULL COMMENT 'id',
--  `userName` VARCHAR(32) NOT NULL COMMENT '账号',
--  `name` VARCHAR(32) COMMENT '姓名',
--  `password` VARCHAR(32) NOT NULL COMMENT '密码',
--  `authorities` VARCHAR(32) NOT NULL COMMENT '权限类型：1 超级管理员 2 企业管理员',
--  `enabled` VARCHAR(1) NOT NULL default 1 COMMENT '使能：1 启用 2 禁用',
--  `age` VARCHAR(3) COMMENT '年龄',
--  `sex` VARCHAR(1) NOT NULL default 0 COMMENT '性别，0：男，1：女',
--  PRIMARY KEY (`id`)
--);


CREATE TABLE `t_SiteUser` (
  `siteUserId` VARCHAR(32) NOT NULL COMMENT '管理员id',
  `Account` VARCHAR(32) NOT NULL COMMENT '账号',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `authorities` VARCHAR(2) NOT NULL COMMENT '权限类型：1 超级管理员 2 企业管理员',
  `enabled` VARCHAR(1) NOT NULL COMMENT '使能：1 启用 2 禁用',
  `ecName` VARCHAR(32) COMMENT '归属企业名称，超级管理员为空',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`siteUserId`)
);
CREATE UNIQUE INDEX i_SiteUserAccount ON t_SiteUser(Account);

CREATE TABLE `t_ec` (
  `ecId` VARCHAR(32) NOT NULL COMMENT '企业id',
  `ecName` VARCHAR(32) NOT NULL COMMENT '企业名称',
  `desc` VARCHAR(200) COMMENT '企业描述',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`ecId`)
);
CREATE UNIQUE INDEX i_ecName ON t_ec(ecName);

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

CREATE TABLE `t_product` (
  `productId` VARCHAR(32) NOT NULL COMMENT '产品id',
  `productName` VARCHAR(32) NOT NULL COMMENT '产品名称',
  `productType` VARCHAR(200) NOT NULL COMMENT '产品类型名',
  `desc` VARCHAR(200) COMMENT '产品描述',
  `Price` VARCHAR(32) NOT NULL COMMENT '价格',
  `picSmall` VARCHAR(200) COMMENT '小图相对地址',
  `picBig` VARCHAR(200) COMMENT '大图相对地址',
  `Status` VARCHAR(2) NOT NULL COMMENT '产品状态，0：上线，1：下线，默认下线状态',
  `ecName` VARCHAR(32) NOT NULL COMMENT '归属企业名称',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`productId`)
);
CREATE UNIQUE INDEX i_productName ON t_product(productName,ecName);

CREATE TABLE `t_productType` (
  `productTypeId` VARCHAR(32) NOT NULL COMMENT '产品类型id',
  `productTypeName` VARCHAR(32) NOT NULL COMMENT '产品类型名称',
  `parentTypeId` VARCHAR(32) NOT NULL COMMENT '父产品类型名，对应父类型的productTypeId',
  `isRoot` VARCHAR(1) NOT NULL COMMENT '是否是根类型，0：是，1否',
  `ecName` VARCHAR(32) NOT NULL COMMENT '归属企业名称',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`productTypeId`)
);
CREATE UNIQUE INDEX i_productTypeName ON t_productType(productTypeName,ecName);

CREATE TABLE `t_order` (
  `OrderId` VARCHAR(32) NOT NULL COMMENT '订单id',
  `status` VARCHAR(2) NOT NULL COMMENT '订单状态，0：待卖家确认，1：待买家收货，2：已确认收货，3：撤销',
  `products` VARCHAR(2000) COMMENT '订单包含产品名，list中的产品按顺序继承，靠前的是父产品。',
  `UserAccount` VARCHAR(32) NOT NULL COMMENT '下单用户账号',
  `sendType` VARCHAR(2) COMMENT '送货方式，0：指定地点自取，1：送货上门',
  `PayType` VARCHAR(2) COMMENT '支付方式，0：线下支付',
  `Address` VARCHAR(200) COMMENT '送货地点',
  `History` VARCHAR(2000) COMMENT '历史纪录，list中的历史纪录按顺序发生，靠前的是先发生的。',
  `ecName` VARCHAR(32) NOT NULL COMMENT '归属企业名称',
  `createDate` date COMMENT '创建时间',
  `updateDate` date COMMENT '更新时间',
  PRIMARY KEY (`OrderId`)
);
 CREATE INDEX i_orderUserAccount ON t_order(UserAccount);
 CREATE INDEX i_orderecName ON t_order(ecName);
