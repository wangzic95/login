package com.wzc.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wzc.login.domain.User;
/**
 * @description 数据库连接与操作类用于增删改查数据并返回给servlet使用
 * @author WANGZIC
 *
 */
public class UserDao {
	/*
	 * 数据表
	  CREATE TABLE `user` (
	  `id` int(11) NOT NULL AUTO_INCREMENT,
	  `username` varchar(255) DEFAULT NULL,
	  `password` varchar(255) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
	*/
	
	//根据用户名查找用户密码
	public User findUser(String username){
		String sql = "select * from user where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return user;
	}
	//添加用户
	public boolean addUser(String username,String psw){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO user(username,password) VALUES(?,?)";
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, psw);
			res = (pstmt.executeUpdate()==1);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		return res;
	}
	//获得连接
	public static Connection getConnection(){
		String driver ="com.mysql.jdbc.Driver";//记得依赖mysql-jdbc驱动包
		String url ="jdbc:mysql://localhost:3306/mytest";//修改为自己的数据库
		String user ="root";//修改未自己数据库的用户名密码
		String password ="root";//修改未自己数据库的名密码
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		//测试方法
//		System.out.println(new UserDao().findUser("123"));
//		new UserDao().addUser("1345", "1345");
	}


	
}
