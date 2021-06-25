SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop database if exists question;
create database question;
use question;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `uid` varchar(50),
                         `profile`varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci null default null comment '头像的地址',
                         `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci null default null,
                         `password` varchar(60),
                         `gender` varchar(10),
                         `bill` int(20) not null default 0,
                         `level` int(2)  not null default 0,
                         `backgroundImg` varchar(225)comment '用户背景图片的地址',
                         `email` varchar(30),
                         `birth` date ,
                         `city` varchar(20),
                         primary key (`uid`) USING BTREE,
                         unique (email)
)ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

drop table if exists `problem`;
create table `problem`(
                          `uid` varchar (50)comment'发布者',
                          `pid` varchar (50),
                          `status` int(1) comment'0代表未解决，1代表已解决' not null default 0,
                          `time` datetime not null,
                          `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci not null,
                          `tag` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci not null comment'用“；”来分隔',
                          `bill` int(20) not null default 0,
                          `ans_num` int(5) not null default 0,
                          `title` varchar(50)comment'问题的标题',
                          primary key (`pid`) using btree,
                          foreign key (`uid`)references `user`(`uid`)on update cascade
)ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `answer`;
create table `answer`(
                         `aid` varchar(50),
                         `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci not null,
                         `pid` varchar(50)not null default 0,
                         `uid` varchar (50) not null default 0,
                         `like` int(8) not null default 0,
                         `time` datetime not null ,
                         primary key(`aid`) using btree,
                         foreign key(`pid`)references problem(`pid`) on update cascade
) AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ;

DROP TABLE IF EXISTS `comment`;
create table `comment`(
                          `pid` varchar(50) not null comment'问题的评论',
                          `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci not null,
                          `uid` varchar(50) not null,
                          `cid` varchar (50),
                          `cid_p` varchar(50) comment'父评论的id'default '_',
                          `time` datetime not null ,
                          primary key(`cid`) using btree,
                          foreign key (`uid`) references question.`user`(`uid`) on update cascade
)AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `p_pic` ;#problem picture
create table `p_pic`(
                        `id` varchar(20),
                        `pid`varchar(50),
                        `url`varchar(255),
                        primary key (`id`),
                        foreign key (`pid`)references `problem`(`pid`)on update cascade
                            on delete cascade
)ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
DROP TABLE IF EXISTS `a_pic` ;#answer picture
create table `a_pic`(
                        `id` varchar(20),
                        `aid`varchar(50),
                        `url`varchar(255),
                        primary key (id)using btree,
                        foreign key (`aid`)references `answer`(`aid`)
                            on delete cascade on update cascade
)ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `follow`;
create table `follow`(
                         `uid` varchar(50) comment '关注的用户',
                         `pid` varchar(50) comment '被关注的问题',
                         `time`datetime not null,
                         primary key(`uid`,`pid`)using btree,
                         CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                         CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE = InnoDB  AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ;

DROP TABLE IF EXISTS `like`;
create table `like`
(
    `uid`  varchar(50) comment '点赞用户',
    `pid`  varchar(50) comment '这个问题',
    `time` datetime not null,
    primary key (`uid`, `pid`) using btree,
    CONSTRAINT `like_fk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `like_fk_2` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE = InnoDB  AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ;
#有点麻烦
DROP TABLE IF EXISTS `related`;
create table `related`(
                          `pid` varchar (50) comment '这个问题',
                          `r_pid` varchar(50) comment '相关问题',
                          primary key(`pid`,`r_pid`)using btree,
                          CONSTRAINT `related_fk_1` FOREIGN KEY (`r_pid`) REFERENCES `problem` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                          CONSTRAINT `related_fk_2` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE = InnoDB  AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ;

SET FOREIGN_KEY_CHECKS = 1;