/*
SQLyog Enterprise - MySQL GUI v7.15 
MySQL - 5.0.22-community-nt-log : Database - jokerbase
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`jokerbase` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jokerbase`;

/*Table structure for table `tb_affix` */

DROP TABLE IF EXISTS `tb_affix`;

CREATE TABLE `tb_affix` (
  `affix_id` varchar(32) NOT NULL COMMENT '附件id',
  `affix_name` varchar(32) default NULL COMMENT '附件名称',
  `affix_path` varchar(100) default NULL COMMENT '附件存放路径',
  `create_id` varchar(32) default NULL COMMENT '创建人id',
  `create_time` varchar(36) default NULL COMMENT '创建时间',
  `is_delete` int(5) default '0' COMMENT '是否删除',
  `delete_time` varchar(36) default NULL COMMENT '删除时间',
  `delete_id` varchar(32) default NULL COMMENT '删除人id',
  `affix_status` int(5) default '0' COMMENT '附件状态',
  PRIMARY KEY  (`affix_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_affix` */

DROP TABLE IF EXISTS `tb_media`;
CREATE TABLE `tb_media` (
  `media_id` VARCHAR(32) NOT NULL COMMENT '媒体id',
  `media_name` VARCHAR(32) DEFAULT NULL COMMENT '媒体名称',
  `media_path` VARCHAR(100) DEFAULT NULL COMMENT '媒体存放路径',
  `media_desc` VARCHAR(100) DEFAULT NULL COMMENT '媒体描述',
  `channel_id` VARCHAR(32) DEFAULT NULL COMMENT '栏目id',
  `channel_type` INT(5) DEFAULT '0' COMMENT '栏目类型',
  `create_id` VARCHAR(32) DEFAULT NULL COMMENT '创建人id',
  `create_time` VARCHAR(36) DEFAULT NULL COMMENT '创建时间',
  `is_delete` INT(5) DEFAULT '0' COMMENT '是否删除',
  `delete_time` VARCHAR(36) DEFAULT NULL COMMENT '删除时间',
  `delete_id` VARCHAR(32) DEFAULT NULL COMMENT '删除id',
  `media_status` INT(5) DEFAULT '0' COMMENT '媒体状态'
) ENGINE=INNODB DEFAULT CHARSET=utf8


/*Table structure for table `tb_channel` */

DROP TABLE IF EXISTS `tb_channel`;

CREATE TABLE `tb_channel` (
  `channel_id` varchar(32) NOT NULL COMMENT '分类id',
  `channel_name` varchar(36) default NULL COMMENT '分类名称',
  `channel_level` int(5) default '0' COMMENT '分类级别',
  `channel_parent_id` varchar(32) default NULL COMMENT '父分类id',
  `channel_status` int(5) default '0' COMMENT '分类状态',
  `is_delete` int(5) default '0' COMMENT '是否删除（0：否；1：是）',
  `create_time` varchar(36) default NULL COMMENT '创建时间',
  `create_id` varchar(32) default NULL COMMENT '创建人id',
  `update_time` varchar(36) default NULL COMMENT '更新时间',
  `update_id` varchar(32) default NULL COMMENT '更新人id',
  `delete_time` varchar(36) default NULL COMMENT '删除时间',
  `delete_id` varchar(32) default NULL COMMENT '删除人id',
  `channel_type` int(5) default '0' COMMENT '分类类型（0：图文；1：媒体；2:内容型栏目）',
  `channel_css` varchar(32) default NULL COMMENT '分类样式',
  PRIMARY KEY  (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_channel` */

/*Table structure for table `tb_comment` */

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `comment_id` varchar(32) NOT NULL COMMENT '评论id',
  `comment_title` varchar(32) default NULL COMMENT '评论标题',
  `comment_content` varchar(500) default NULL COMMENT '评论内容',
  `comment_content_id` varchar(32) default NULL COMMENT '被评论内容id',
  `create_id` varchar(32) default NULL COMMENT '创建人id',
  `create_time` varchar(36) default NULL COMMENT '创建时间',
  `update_time` varchar(36) default NULL COMMENT '更新时间',
  `update_id` varchar(32) default NULL COMMENT '更新人id',
  `is_delete` int(5) default '0' COMMENT '是否删除（0：否；1：是）',
  `comment_status` int(5) default '0' COMMENT '评论状态（0：正常；）',
  `delete_time` varchar(36) default NULL COMMENT '删除人时间',
  `delete_id` varchar(32) default NULL COMMENT '删除人id',
  PRIMARY KEY  (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_comment` */

/*Table structure for table `tb_content` */

DROP TABLE IF EXISTS `tb_content`;

CREATE TABLE `tb_content` (
  `content_id` varchar(32) NOT NULL COMMENT '内容id',
  `content_channel_id` varchar(32) default NULL COMMENT '所属分类id',
  `content_title` varchar(200) default NULL COMMENT '内容标题',
  `content_main` varchar(2000) default NULL COMMENT '内容主体',
  `create_id` varchar(32) default NULL COMMENT '创建人id',
  `create_time` varchar(36) default NULL COMMENT '创建时间',
  `is_delete` int(5) default '0' COMMENT '是否删除（0：否；1：是）',
  `content_status` int(5) default '0' COMMENT '内容状态',
  `delete_time` varchar(36) default NULL COMMENT '删除时间',
  `delete_id` varchar(32) default NULL COMMENT '删除人id',
  `update_id` varchar(32) default NULL COMMENT '修改人id',
  `update_time` varchar(36) default NULL COMMENT '修改时间',
  `content_sort` int(5) default '0' COMMENT '内容排序',
  PRIMARY KEY  (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_content` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `user_name` varchar(24) default NULL COMMENT '用户名',
  `user_password` varchar(36) default NULL COMMENT '用户密码',
  `user_email` varchar(36) default NULL COMMENT '用户电子邮箱',
  `create_time` varchar(36) default NULL COMMENT '创建时间',
  `update_time` varchar(36) default NULL COMMENT '修改时间',
  `update_id` varchar(32) default NULL COMMENT '修改人id',
  `is_delete` int(5) default '0' COMMENT '是否删除（0：否；1：是）',
  `delete_time` varchar(36) default NULL COMMENT '删除时间',
  `delete_id` varchar(36) default NULL COMMENT '删除人',
  `user_is_val` int(5) default '0' COMMENT '用户验证状态(0：未验证；1：通过验证)',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;