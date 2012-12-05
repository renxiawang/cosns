-- phpMyAdmin SQL Dump
-- version 3.4.0-rc2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2011 年 05 月 22 日 10:59
-- 服务器版本: 5.1.54
-- PHP 版本: 5.3.5-1ubuntu7.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `cosns`
--

-- --------------------------------------------------------

--
-- 表的结构 `announcement`
--

CREATE TABLE IF NOT EXISTS `announcement` (
  `AnnouncementID` int(11) NOT NULL AUTO_INCREMENT,
  `AnnouncerUID` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Content` varchar(200) NOT NULL,
  `PID` int(11) NOT NULL,
  PRIMARY KEY (`AnnouncementID`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `announcement`
--

INSERT INTO `announcement` (`AnnouncementID`, `AnnouncerUID`, `Date`, `Content`, `PID`) VALUES
(1, 3, '2011-05-11 16:00:32', '腾讯微博发布“微群”功能，目前第一阶段内测，4级以上每人可创建两个群，可邀请自己的听众和QQ群用户加入加入，加入没有限制，直接就能加人，瞬间成员就超过300，恐怖啊。', 1),
(2, 2, '2011-05-16 03:46:38', '人啊，得意一天是一天。总归都是人，总归都是命。总是要死，那么心急干嘛？ 【最爱】是一部很压抑的电影，从开头压抑到结局，看的时候，一直感觉好冷好冷。。。明知道，爱情那么让人绝望，为什么，还要？', 2),
(3, 2, '2011-05-16 03:46:51', '告诉你一个真实的三峡：14个专项论证报告，有五个报告专家组不签字，都挡不住政治工程的强硬上马。可能没有哪个国家敢于在地质情况如此不明，超过1／3工程论证报告专家组不签字的情况下，还能强行上马。论证时，反对者排挤出去，赞成者拉请进来…强烈推荐此文http://t.cn/htcfKS ', 3),
(4, 34, '2011-05-18 04:43:43', 'testetststettsttststststts', 34),
(5, 1, '2011-05-18 04:45:18', 'test', 1),
(6, 3, '2011-05-22 02:58:08', 'test = pid =2', 2),
(7, 3, '2011-05-22 02:58:35', 'testetstetsetstetstetstetsteste', 3);

-- --------------------------------------------------------

--
-- 表的结构 `documentation`
--

CREATE TABLE IF NOT EXISTS `documentation` (
  `DocID` int(11) NOT NULL AUTO_INCREMENT,
  `PublisherUID` int(11) NOT NULL,
  `Content` text NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Title` varchar(45) NOT NULL,
  `PID` int(11) NOT NULL,
  PRIMARY KEY (`DocID`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `documentation`
--

INSERT INTO `documentation` (`DocID`, `PublisherUID`, `Content`, `Date`, `Title`, `PID`) VALUES
(1, 3, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '2011-05-11 16:02:47', 'this is title', 1),
(2, 22, 'testetstetstetstetstestetstetststetste', '2011-05-18 04:40:30', 'cao cacao', 23),
(3, 3, 'content', '2011-05-18 04:42:24', 'title', 1);

-- --------------------------------------------------------

--
-- 表的结构 `msgboard`
--

CREATE TABLE IF NOT EXISTS `msgboard` (
  `MBID` int(11) NOT NULL,
  `MsgID` int(11) NOT NULL AUTO_INCREMENT,
  `InserUID` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Content` varchar(200) NOT NULL,
  PRIMARY KEY (`MsgID`),
  UNIQUE KEY `MBID` (`MBID`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=25 ;

--
-- 转存表中的数据 `msgboard`
--

INSERT INTO `msgboard` (`MBID`, `MsgID`, `InserUID`, `Date`, `Content`) VALUES
(1001, 1, 3, '2011-05-11 15:07:49', 'the msg from uid= 3 to messagebordid= 1001'),
(12, 2, 12, '2011-05-17 17:50:25', '12'),
(394, 3, 0, '2011-05-17 18:16:11', 'Welcome to Cosns'),
(49, 4, 0, '2011-05-17 18:16:41', 'Welcome to Cosns'),
(69, 5, 0, '2011-05-17 18:18:06', 'Welcome to Cosns'),
(434, 6, 0, '2011-05-17 18:19:02', 'Welcome to Cosns'),
(915, 7, 0, '2011-05-17 18:24:38', 'Welcome to Cosns'),
(479, 8, 0, '2011-05-17 18:25:27', 'Welcome to Cosns'),
(968, 9, 0, '2011-05-17 18:29:34', 'Welcome to Cosns'),
(171, 10, 0, '2011-05-17 18:37:04', 'Welcome to Cosns'),
(355, 11, 0, '2011-05-17 18:44:50', 'Welcome to Cosns'),
(403, 12, 0, '2011-05-17 18:46:10', 'Welcome to Cosns'),
(382, 13, 0, '2011-05-17 18:52:17', 'Welcome to Cosns'),
(883, 14, 0, '2011-05-17 18:54:18', 'Welcome to Cosns'),
(276, 15, 0, '2011-05-17 18:57:34', 'Welcome to Cosns'),
(843, 16, 0, '2011-05-17 18:59:12', 'Welcome to Cosns'),
(172, 17, 0, '2011-05-17 19:02:34', 'Welcome to Cosns'),
(805, 18, 0, '2011-05-17 19:04:19', 'Welcome to Cosns'),
(719, 19, 0, '2011-05-17 19:05:15', 'Welcome to Cosns'),
(694, 20, 0, '2011-05-18 04:21:22', 'Welcome to Cosns'),
(123, 21, 123, '2011-05-18 04:33:02', '1231231321313131231313131313'),
(100, 22, 67, '2011-05-18 04:38:17', 'test content'),
(819, 23, 0, '2011-05-18 04:38:17', 'Welcome to Cosns'),
(896, 24, 0, '2011-05-21 07:23:38', 'Welcome to Cosns');

-- --------------------------------------------------------

--
-- 表的结构 `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `PID` int(11) NOT NULL AUTO_INCREMENT,
  `creatorUID` int(11) NOT NULL,
  `ProjectName` varchar(30) NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `FavCount` int(11) NOT NULL DEFAULT '0',
  `MemberCount` int(11) NOT NULL DEFAULT '0',
  `MBID` int(11) NOT NULL,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `PUrl` varchar(50) NOT NULL DEFAULT './images/c.jpg',
  PRIMARY KEY (`PID`),
  UNIQUE KEY `ProjectName` (`ProjectName`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1214 ;

--
-- 转存表中的数据 `project`
--

INSERT INTO `project` (`PID`, `creatorUID`, `ProjectName`, `Description`, `FavCount`, `MemberCount`, `MBID`, `UpdateTime`, `PUrl`) VALUES
(1, 0, 'project1', 'this is project description', 3, 0, 1003, '2011-05-11 15:02:39', './images/c.jpg'),
(2, 0, '2', '2', 0, 0, 123, '2011-05-16 06:40:08', './images/c.jpg'),
(3, 0, '333333333333333333333333333333', '3', 0, 0, 122, '2011-05-16 06:40:22', './images/c.jpg'),
(4, 0, 'testProjetc', 'testtest', 0, 0, 0, '2011-05-18 03:36:42', './images/c.jpg'),
(5, 3, 'test - -- Projetc', 'sfsdsfsdfsdfsdsfsf', 0, 0, 12, '2011-05-18 03:40:56', './images/c.jpg'),
(6, 12, 'project1111111111', 'test', 0, 0, 694, '2011-05-18 04:21:22', './images/c.jpg'),
(1212, 3, '1212', '1212', 0, 0, 1212, '2011-05-20 18:57:15', './images/c.jpg'),
(1213, 3, '1213', '1213', 0, 0, 1213, '2011-05-20 18:57:34', './images/c.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `resharing`
--

CREATE TABLE IF NOT EXISTS `resharing` (
  `UID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `SharingID` int(11) NOT NULL,
  PRIMARY KEY (`UID`,`PID`,`SharingID`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;

--
-- 转存表中的数据 `resharing`
--

INSERT INTO `resharing` (`UID`, `PID`, `SharingID`) VALUES
(2, 3, 4),
(3, 1, 1),
(3, 3, 3);

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `UID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `IsManager` tinyint(1) NOT NULL,
  `ParticipateWay` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`RoleID`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`RoleID`, `UID`, `PID`, `IsManager`, `ParticipateWay`, `Date`) VALUES
(1, 3, 2, 1, 1, '2011-05-11 15:03:17'),
(2, 3, 1, 1, 2, '2011-05-11 15:03:58'),
(3, 3, 3, 1, 2, '2011-05-18 05:04:54'),
(4, 23, 12, 0, 2, '2011-05-18 05:08:07');

-- --------------------------------------------------------

--
-- 表的结构 `sharing`
--

CREATE TABLE IF NOT EXISTS `sharing` (
  `SharingID` int(11) NOT NULL AUTO_INCREMENT,
  `SharerUID` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Content` varchar(200) NOT NULL,
  `PID` int(11) NOT NULL,
  PRIMARY KEY (`SharingID`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `sharing`
--

INSERT INTO `sharing` (`SharingID`, `SharerUID`, `Type`, `Date`, `Content`, `PID`) VALUES
(1, 3, 1, '2011-05-11 16:04:47', '（this should be the content + url )', 1),
(2, 4, 2, '2011-05-18 03:25:07', 'test post sharing', 7),
(3, 3, 0, '2011-05-18 03:28:08', 'Test Content', 1);

-- --------------------------------------------------------

--
-- 表的结构 `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `TaskID` int(11) NOT NULL AUTO_INCREMENT,
  `CreatorUID` int(11) NOT NULL,
  `ExecutorUID` varchar(100) DEFAULT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Content` varchar(200) NOT NULL,
  `PID` int(11) NOT NULL,
  PRIMARY KEY (`TaskID`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `task`
--

INSERT INTO `task` (`TaskID`, `CreatorUID`, `ExecutorUID`, `Date`, `Content`, `PID`) VALUES
(2, 3, '4,3', '2011-05-11 16:05:32', 'ccccccccccccccccccccccccccccccccccccccccccccccccccccc', 1),
(3, 3, '2,3', '2011-05-18 03:14:31', 'testtesttesttesttesttesttesttesttest', 1),
(4, 3, '3,4', '2011-05-18 03:21:48', 'test contest', 1),
(5, 3, '3,4', '2011-05-18 03:23:02', 'test contest', 1);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Fullname` varchar(10) NOT NULL,
  `AvatarURL` varchar(50) NOT NULL DEFAULT './images/b.jpg',
  `MBID` int(11) NOT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`UID`, `Email`, `Password`, `Fullname`, `AvatarURL`, `MBID`) VALUES
(3, 'admin@admin.com', 'admin', 'admin', './images/b.jpg', 1001),
(4, 'user1@user.com', 'user', 'user1', './images/b.jpg', 1002),
(5, 'test@test.com', 'root', 'test', './images/b.jpg', 0),
(6, 'testtest@test.com', 'root', 'testtest', './images/b.jpg', 3),
(7, 'testadmin@admin.com', '345454', 'testadmin', './images/b.jpg', 968),
(11, 'wco@admin.', '345454', 'testad', './images/b.jpg', 382),
(12, 'wc@admin.com', '345454', 'testadmin', './images/b.jpg', 883),
(13, 'wc1111@admin.com', '345454', 'testadmin', './images/b.jpg', 276),
(14, 'wc2222@admin.com', '1234567890', 'testadmin', './images/b.jpg', 719),
(15, 'cdcdcd', 'cd', 'cdcdcdc', './images/b.jpg', 896);

-- --------------------------------------------------------

--
-- 表的结构 `userrelation`
--

CREATE TABLE IF NOT EXISTS `userrelation` (
  `UID1` int(11) NOT NULL,
  `UID2` int(11) NOT NULL,
  PRIMARY KEY (`UID1`,`UID2`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;

--
-- 转存表中的数据 `userrelation`
--

INSERT INTO `userrelation` (`UID1`, `UID2`) VALUES
(3, 4),
(4, 3),
(5, 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
