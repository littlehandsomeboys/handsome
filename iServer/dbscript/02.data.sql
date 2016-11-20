
--INSERT INTO `t_siteuser` (`id`, `userName`, `name`, `password`, `authorities`, `enabled`, `age`, `sex`) VALUES
--  ('siteuser001','chencheng','陈澄','Huawei123','2','1','27','0');


INSERT INTO `t_siteuser` (`siteUserId`, `Account`, `password`, `authorities`, `enabled`, `ecName`,`reserve0`,`reserve1`,`reserve2`,`reserve3`,`reserve4`,`reserve5`,`reserve6`,`reserve7`,`reserve8`,`reserve9`, `createDate`, `updateDate`) VALUES
  ('siteuser001','chencheng','Huawei123','1','1','','','','','','','','','','','',SYSDATE(),SYSDATE());

INSERT INTO `t_siteuser` (`siteUserId`, `Account`, `password`, `authorities`, `enabled`, `ecName`,`reserve0`,`reserve1`,`reserve2`,`reserve3`,`reserve4`,`reserve5`,`reserve6`,`reserve7`,`reserve8`,`reserve9`, `createDate`, `updateDate`) VALUES
  ('siteuser002','fulu','Huawei123','2','1','大蓝鲸','','','','','','','','','','',SYSDATE(),SYSDATE());
  
INSERT INTO `t_siteuser` (`siteUserId`, `Account`, `password`, `authorities`, `enabled`, `ecName`,`reserve0`,`reserve1`,`reserve2`,`reserve3`,`reserve4`,`reserve5`,`reserve6`,`reserve7`,`reserve8`,`reserve9`, `createDate`, `updateDate`) VALUES
  ('siteuser003','youliangdong','Huawei123','3','1','大蓝鲸','简介...','https://www.baidu.com/img/baidu_jgylogo3.gif','https://www.baidu.com/img/bd_logo1.png','CET4、数据库工程师','没有执教过','有两洞','0','本科','','',SYSDATE(),SYSDATE());

INSERT INTO `t_siteuser` (`siteUserId`, `Account`, `password`, `authorities`, `enabled`, `ecName`,`reserve0`,`reserve1`,`reserve2`,`reserve3`,`reserve4`,`reserve5`,`reserve6`,`reserve7`,`reserve8`,`reserve9`, `createDate`, `updateDate`) VALUES
  ('siteuser004','zhangyong','Huawei123','3','1','大蓝鲸','简介...','https://www.baidu.com/img/baidu_jgylogo3.gif','https://www.baidu.com/img/bd_logo1.png','CET4、高级工程师','没有执教过','勇哥','1','本科','','',SYSDATE(),SYSDATE());
  
INSERT INTO `t_ec` (`ecId`, `ecName`, `desc`, `createDate`, `updateDate`) VALUES
  ('ec001','大蓝鲸','这是企业',SYSDATE(),SYSDATE());
  
INSERT INTO t_pic VALUE('default','head/default.png','head/default.png',NOW(),NOW(),'0');

INSERT INTO `t_user` (`UserId`, `Account`, `name`, `password`, `enabled`, `age`, `sex`, `phone`, `email`, `createDate`, `updateDate`) VALUES
  ('user001','chencheng','cc','Huawei123','1','22','0','13515119251','cc411360770@sina.com',SYSDATE(),SYSDATE());


INSERT INTO `t_product` (`productId`, `productName`, `productType`, `desc`, `Price`, `picSmall`, `picBig`, `Status`, `ecName`, `createDate`, `updateDate`) VALUES
  ('product001','产品a','产品类型A','是他产品A','10','small.png','big.png','1','大蓝鲸',SYSDATE(),SYSDATE());
INSERT INTO `t_product` (`productId`, `productName`, `productType`, `desc`, `Price`, `picSmall`, `picBig`, `Status`, `ecName`, `createDate`, `updateDate`) VALUES
  ('product002','产品b','产品类型B','是他产品B','10','small.png','big.png','1','大蓝鲸',SYSDATE(),SYSDATE());
  

INSERT INTO `t_productType` (`productTypeId`, `productTypeName`, `parentTypeId`, `isRoot`, `ecName`, `createDate`, `updateDate`) VALUES
  ('productType001','产品类型A','root','0','大蓝鲸',SYSDATE(),SYSDATE());
INSERT INTO `t_productType` (`productTypeId`, `productTypeName`, `parentTypeId`, `isRoot`, `ecName`, `createDate`, `updateDate`) VALUES
  ('productType002','产品类型B','productType001','1','大蓝鲸',SYSDATE(),SYSDATE());
  

INSERT INTO `t_order` (`OrderId`, `status`, `products`, `UserAccount`, `sendType`, `PayType`,  `Address`, `History`, `ecName`, `createDate`, `updateDate`) VALUES
  ('order001','0','','chencheng','0','0','华为南门','','大蓝鲸',SYSDATE(),SYSDATE());
  
COMMIT;
