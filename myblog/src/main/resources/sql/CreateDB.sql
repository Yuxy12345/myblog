/*
 * CreateDB.sql myblog项目建库文件
 * 2019/5/1
 */

/*
 * 2019/5/1 编辑
 *
 * 2019/5/2 修改：
 *     1. 删除Type表中SuperTypeID和Comment表中ReplyCommentID不合理的NOT NULL约束。
 * 2019/5/7 修改：
 *     1. resource表添加"ENGINE=INNODB DEFAULT CHARSET=utf8"。
 */

CREATE DATABASE IF NOT EXISTS myblog;

USE myblog;

CREATE TABLE IF NOT EXISTS `User` (
    `UserID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `UserName` VARCHAR(64) NOT NULL,
    `Email` VARCHAR(100) NOT NULL,
    `PassWord` VARCHAR(255) NOT NULL,
    `UserType` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`UserID`),
    UNIQUE `UserLoginKey` (`UserName`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Type` (
    `TypeID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `TypeName` VARCHAR(100) NOT NULL,
    `SuperTypeID` BIGINT(20) UNSIGNED,
    `Abbr` VARCHAR(32) NOT NULL,
    PRIMARY KEY (`TypeID`),
    FOREIGN KEY (`SuperTypeID`) REFERENCES `Type` (TypeID),
    KEY `SuperTypeIDKey` (`SuperTypeID`),
    KEY `TypeNameKey` (`TypeName`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Article` (
    `ArticleID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `Title` VARCHAR(100) NOT NULL,
    `UserID` BIGINT(20) UNSIGNED NOT NULL,
    `UpdateTime` DATETIME NOT NULL DEFAULT NOW(),
    `Status` VARCHAR(10) NOT NULL DEFAULT 'edit',
    `Content` LONGTEXT,
    `TypeID` BIGINT(20) UNSIGNED NOT NULL,
    `Abbr` VARCHAR(32) NOT NULL,
    PRIMARY KEY (`ArticleID`),
    FOREIGN KEY (`UserID`) REFERENCES `User`(`UserID`),
    FOREIGN KEY (`TypeID`) REFERENCES `Type`(`TypeID`),
    KEY `TitleKey` (`Title`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Comment` (
    `CommentID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `ArticleID` BIGINT(20) UNSIGNED NOT NULL,
    `UserID` BIGINT(20) UNSIGNED NOT NULL,
    `ReplyCommentID` BIGINT(20) UNSIGNED,
    `UpdateTime` DATETIME NOT NULL DEFAULT NOW(),
    `Content` LONGTEXT NOT NULL,
    PRIMARY KEY (`CommentID`),
    FOREIGN KEY (`ArticleID`) REFERENCES `Article`(`ArticleID`),
    FOREIGN KEY (`UserID`) REFERENCES `User`(`UserID`),
    FOREIGN KEY (`ReplyCommentID`) REFERENCES `Comment`(`CommentID`)
 ) ENGINE=INNODB DEFAULT CHARSET=utf8;
 
CREATE TABLE IF NOT EXISTS `Resource` (
    `ResourceID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `Type` VARCHAR(10) NOT NULL,
    `Address` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`ResourceID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
 
/*
 * 2019/5/2 创建
 */

INSERT INTO `user` (`UserName`, `Email`, `PassWord`, `UserType`)
VALUES ('Yuxy', 'yuxy_12345@qq.com', '0418', 'admin');

INSERT INTO `type` (`TypeName`, `Abbr`)
VALUES ('test', 'test');

INSERT INTO `article` (`Title`, `UserID`, `Status`, `Content`, `TypeID`, `Abbr`)
VALUES ('test1', 1, 'publish', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.', 2, 'test');

INSERT INTO `article` (`Title`, `UserID`, `Status`, `Content`, `TypeID`, `Abbr`)
VALUES ('test2', 1, 'publish', '视频提供了功能强大的方法帮助您证明您的观点。当您单击联机视频时，可以在想要添加的视频的嵌入代码中进行粘贴。您也可以键入一个关键字以联机搜索最适合您的文档的视频。', 2, 'test');
INSERT INTO `article` (`Title`, `UserID`, `Status`, `Content`, `TypeID`, `Abbr`)
VALUES ('test3', 1, 'publish', '当应用样式时，您的标题会进行更改以匹配新的主题。使用在需要位置出现的新按钮在 Word 中保存时间。若要更改图片适应文档的方式，请单击该图片，图片旁边将会显示布局选项按钮。', 2, 'test');
INSERT INTO `article` (`Title`, `UserID`, `Status`, `Content`, `TypeID`, `Abbr`)
VALUES ('test4', 1, 'publish', '为使您的文档具有专业外观，Word 提供了页眉、页脚、封面和文本框设计，这些设计可互为补充。例如，您可以添加匹配的封面、页眉和提要栏。单击“插入”，然后从不同库中选择所需元素。主题和样式也有助于文档保持协调。', 2, 'test');
INSERT INTO `article` (`Title`, `UserID`, `Status`, `Content`, `TypeID`, `Abbr`)
VALUES ('test5', 1, 'publish', '当您单击设计并选择新的主题时，图片、图表或 SmartArt 图形将会更改以匹配新的主题。当应用样式时，您的标题会进行更改以匹配新的主题。使用在需要位置出现的新按钮在 Word 中保存时间。', 2, 'test');
INSERT INTO `article` (`Title`, `UserID`, `Status`, `Content`, `TypeID`, `Abbr`)
VALUES ('test6', 1, 'publish', '为使您的文档具有专业外观，Word 提供了页眉、页脚、封面和文本框设计，这些设计可互为补充。例如，您可以添加匹配的封面、页眉和提要栏。单击“插入”，然后从不同库中选择所需元素。主题和样式也有助于文档保持协调。', 2, 'test');

/*
 * 2019/5/7 创建
 */
 CREATE TABLE IF NOT EXISTS `Setting` (
    `Item` VARCHAR(20) PRIMARY KEY,
    `Value` VARCHAR(50)
 ) ENGINE=INNODB DEFAULT CHARSET=utf8;