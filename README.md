**部署运行说明**

1.项目导入到Eclipse
    
    下载完项目后解压，然后打开eclipse，
        >右键eclipse右侧项目目录空白处，点击import
        >选择 General>Existing projects into Workspace
        >点击Next>点击Browse..选择刚下载的项目
        >勾选下面Options中的Copy projects into workspace 然后点击Finish(项目导入后会有小红叉，先不用管)
        >右键导入的项目选择Build path>configure build path
        >选择Libraries
        >选中JRE System Library 然后点击右边的 Remove 
        >然后点击Add Library..>选择JRE System Library >点击Next >点击 Finish
        >选中Apache Tomcat 然后点击右边的 Remove
        >然后点击Add Library..>选择Server Runtime >点击Next >选中你自己的tomcat >点击 Finish
    好了，这时候正常的话项目上的小红叉应该已经没有了，项目已经成功导入了。

2.更改UserDao.java文件中JDBC连接信息

    将数据库驱动名更改位自己所用的数据库的驱动名，本项目只提供Mysql的驱动包。
    （若连接其他数据库请自行下载数据库驱动jar包）
    更改数据库连接的用户和密码为自己数据库的用户和密码
    
3.新建用户表 

    建表语句：
        CREATE TABLE `user` (
          `USERID` int(11) NOT NULL AUTO_INCREMENT,
          `USERNAME` varchar(255) NOT NULL,
          `PASSWORD` varchar(255) DEFAULT NULL,
          `NICKNAME` varchar(255) DEFAULT NULL,
          `GENDER` varchar(255) DEFAULT NULL,
          `PHONE` varchar(255) DEFAULT NULL,
          `EMAIL` varchar(255) DEFAULT NULL,
          `ADDRESS` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`USERID`,`USERNAME`)
        ) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
        
到此，项目已可以尝试运行了！



    