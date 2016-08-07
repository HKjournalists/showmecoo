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
  `orderid` VARCHAR(45) NOT NULL,
  `link_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `show_addr` VARCHAR(128) NOT NULL,
  `show_date` DATETIME NOT NULL,
  `show_fee` INT NULL,
  `userid` VARCHAR(45) NULL,
  `openid` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `modify_date` DATETIME NULL,
  `modify_userid` VARCHAR(45) NULL,
  `request_mark` TEXT(1024) NOT NULL,
  PRIMARY KEY (`orderid`),
  UNIQUE INDEX `orderid_UNIQUE` (`orderid` ASC));
  
  
  
 --演员表  actor, 艺人主表，纪录艺人通用基本信息，主要用于一级页面展示 
  CREATE TABLE `showmecoo`.`actor` (
  `actorid` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `nick_name` VARCHAR(45) NOT NULL,
  `height` INT NULL,
  `age` INT NULL,
  `sex` INT NOT NULL,
  `type` INT NOT NULL,
  `style` VARCHAR(45) NULL,
  `displayed_num` INT NULL,
  `visit_num` INT NULL,
  `fans_num` INT NULL,
  `create_time` DATETIME NULL,
  `image_name` VARCHAR(45) NULL,
  PRIMARY KEY (`actorid`),
  UNIQUE INDEX `actorid_UNIQUE` (`actorid` ASC),
  UNIQUE INDEX `nick_name_UNIQUE` (`nick_name` ASC));
  
  
  --演员表之舞蹈演员  actor_dancer  用于纪录舞者的简介信息，主要用于二级页面的展示
  CREATE TABLE `showmecoo`.`actor_dancer` (
  `actorid` VARCHAR(45) NOT NULL,
  `skilled_style` VARCHAR(128) NULL,
  `display_addr` VARCHAR(64) NULL,
  `display_price` INT NULL,
  `display_standard` VARCHAR(512) NULL,
  `main_image_name` VARCHAR(45) NULL,
  `second_image_name` VARCHAR(256) NULL,
  `brief_introduction` VARCHAR(512) NULL,
  `level_score` INT NULL,
  PRIMARY KEY (`actorid`),
  UNIQUE INDEX `actorid_UNIQUE` (`actorid` ASC));
  
  
  --演员子表之歌手表  actor_singer  用于纪录歌手的简介信息，主要用与歌手二级页面
  CREATE TABLE `showmecoo`.`actor_singer` (
  `actorid` INT NOT NULL,
  `skilled_style` VARCHAR(128) NULL,
  `display_addr` VARCHAR(64) NULL,
  `display_price` INT NULL,
  `represantive_work` VARCHAR(256) NULL,
  `display_standard` VARCHAR(512) NULL,
  `main_image_name` VARCHAR(45) NULL,
  `second_image_name` VARCHAR(256) NULL,
  `brief_introduction` VARCHAR(512) NULL,
  `level_score` INT NULL,
  PRIMARY KEY (`actorid`),
  UNIQUE INDEX `actorid_UNIQUE` (`actorid` ASC));
  
  
  --演员子表－模特表  actor_model 用于纪录歌手的简介信息，主要用于模特二级页面
  CREATE TABLE `showmecoo`.`actor_model` (
  `actorid` VARCHAR(45) NOT NULL,
  `skilled_style` VARCHAR(128) NULL,
  `display_addr` VARCHAR(64) NULL,
  `display_price` INT NULL,
  `display_standard` VARCHAR(512) NULL,
  `main_image_name` VARCHAR(45) NULL,
  `second_image_name` VARCHAR(256) NULL,
  `brief_introduction` VARCHAR(512) NULL,
  `level_score` INT NULL,
  PRIMARY KEY (`actorid`),
  UNIQUE INDEX `actorid_UNIQUE` (`actorid` ASC));
  
  
  --演员子表－主持人表  actor_compere 用于纪录主持人的简介信息，主要用于主持人二级页面
  CREATE TABLE `showmecoo`.`actor_compere` (
  `actorid` VARCHAR(45) NOT NULL,
  `skilled_style` VARCHAR(128) NULL,
  `display_addr` VARCHAR(64) NULL,
  `display_price` INT NULL,
  `display_standard` VARCHAR(512) NULL,
  `main_image_name` VARCHAR(45) NULL,
  `second_image_name` VARCHAR(256) NULL,
  `brief_introduction` VARCHAR(512) NULL,
  `level_score` INT NULL,
  PRIMARY KEY (`actorid`),
  UNIQUE INDEX `actorid_UNIQUE` (`actorid` ASC));

--艺人作品图片表 work_picture
  CREATE TABLE `showmecoo`.`work_picture` (
  `pictureid` VARCHAR(45) NOT NULL,
  `actorid` VARCHAR(45) NULL,
  `work_name` VARCHAR(20) NULL,
  `recommend_level` INT NULL,
  `picture_name` VARCHAR(45) NULL,
  `visit_num` INT NULL,
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  `brief_introduction` VARCHAR(256) NULL,
  PRIMARY KEY (`picture_id`),
  UNIQUE INDEX `picture_id_UNIQUE` (`picture_id` ASC),
  UNIQUE INDEX `work_name_UNIQUE` (`work_name` ASC));

  --艺人作品视频表  work_video
  CREATE TABLE `showmecoo`.`work_video` (
  `videoid` VARCHAR(45) NOT NULL,
  `actorid` VARCHAR(45) NOT NULL,
  `work_name` VARCHAR(45) NULL,
  `recommend_level` INT NULL,
  `video_name` VARCHAR(45) NULL,
  `visit_num` INT NULL,
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  `brief_introduction` VARCHAR(256) NULL,
  PRIMARY KEY (`video_id`),
  UNIQUE INDEX `video_id_UNIQUE` (`video_id` ASC),
  UNIQUE INDEX `work_name_UNIQUE` (`work_name` ASC));



