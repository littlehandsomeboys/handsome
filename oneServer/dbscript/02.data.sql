
INSERT INTO t_pic VALUE('defaulthead','head/default.png','head/default.png',NOW(),NOW(),'0');

INSERT INTO `t_user` (`UserId`, `Account`, `name`, `password`, `enabled`, `age`, `sex`, `phone`, `email`, `createDate`, `updateDate`) VALUES
  ('user001','chencheng','cc','Huawei123','1','22','0','13515119251','cc411360770@sina.com',SYSDATE(),SYSDATE());


COMMIT;
