CREATE SCHEMA `showmecoo` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

--user 用户信息表
CREATE TABLE `showmecoo`.`user` (
  `userid` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `rolename` VARCHAR(45) NULL,
  `createdate` DATETIME NOT NULL,
  `modifydate` DATETIME NOT NULL,
  `lastlogindate` DATETIME NOT NULL,
  `openid` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));
  
--role 角色表
CREATE TABLE `showmecoo`.`role` (
  `roleid` INT NOT NULL AUTO_INCREMENT,
  `rolename` VARCHAR(45) NOT NULL,
  `roledesc` VARCHAR(45) NULL,
  `createuserid` VARCHAR(45) NOT NULL,
  `createdate` DATETIME NOT NULL,
  `modifyuserid` VARCHAR(45) NOT NULL,
  `modifydate` DATETIME NOT NULL,
  PRIMARY KEY (`roleid`));

--user_wechat_info 微信用户信息表
CREATE TABLE `showmecoo`.`user_wechat_info` (
  `openid` VARCHAR(45) NOT NULL,
  `userid` VARCHAR(45) NULL,
  `nickname` VARCHAR(45) NULL,
  `sex` CHAR(1) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `province` VARCHAR(45) NULL,
  `language` VARCHAR(45) NULL,
  `headimgurl` VARCHAR(45) NULL,
  `subscribe_time` DATETIME NULL,
  `unionid` VARCHAR(45) NULL,
  `remark` VARCHAR(45) NULL,
  `groupid` VARCHAR(45) NULL,
  PRIMARY KEY (`openid`));


微信用户表
用户ID（UUID）
subscribe	用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
openid	用户的标识，对当前公众号唯一
nickname	用户的昵称
sex	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
city	用户所在城市
country	用户所在国家
province	用户所在省份
language	用户的语言，简体中文为zh_CN
headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
subscribe_time	用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
unionid	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
remark	公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
groupid	用户所在的分组ID

{
    "subscribe": 1, 
    "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M", 
    "nickname": "Band", 
    "sex": 1, 
    "language": "zh_CN", 
    "city": "广州", 
    "province": "广东", 
    "country": "中国", 
    "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0", 
   "subscribe_time": 1382694957,
   "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
   "remark": "",
   "groupid": 0
}

--订单表 order
drop table order if exists;
CREATE TABLE `showmecoo`.`order` (
  `orderid` VARCHAR(32) NOT NULL,
  `linkman_name` VARCHAR(32) NOT NULL,
  `phone` VARCHAR(32) NOT NULL,
  `show_addr` VARCHAR(128) NOT NULL,
  `show_date` DATETIME NOT NULL,
  `show_fee` INT NULL,
  `userid` VARCHAR(32) NULL,
  `openid` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `modify_date` DATETIME NULL,
  `modify_userid` VARCHAR(32) NULL,
  `request_mark` TEXT(1024) NOT NULL,
  PRIMARY KEY (`orderid`),
  UNIQUE INDEX `orderid_UNIQUE` (`orderid` ASC));


