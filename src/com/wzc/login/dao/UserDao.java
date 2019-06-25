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
	 * 数据库中运行下面的语句
	  	CREATE TABLE `user` (
		  `username` varchar(255) NOT NULL,
		  `password` varchar(255) DEFAULT NULL,
		  PRIMARY KEY (`username`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	*/

	/**
	 * 根据用户名查找用户密码
	 * @param username 用户名参数
	 * @return
	 */
	public User findUser(String username){
		String sql = "select * from user where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs;
		User user = new User();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeCon(con,pstmt);
		}
		return user;
	}
	/**
	 * 添加用户
	 * @param username 用户名
	 * @param psw 密码
	 * @return
	 */
	public boolean addUser(String username,String password){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO user(username,password) VALUES(?,?)";
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			res = (pstmt.executeUpdate()==1);
		}catch (SQLException e) {
			if(!e.getMessage().contains("PRIMARY")){
				e.printStackTrace();
			}else {
				System.out.println("该用户名已存在");
				return false;
			}
		}finally {
			closeCon(con,pstmt);
		}
		return res;
	}
	/**
	 * 获取连接
	 */
	private static Connection getConnection(){
		//记得依赖mysql-jdbc驱动包
		String driver ="com.mysql.jdbc.Driver";
		//修改为自己的数据库
		String url ="jdbc:mysql://localhost:3306/mytest";
		//修改未自己数据库的用户名密码
		String user ="root";
		//修改未自己数据库的名密码
		String password ="root";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭连接
	 * @param con 连接实例
	 * @param pstmt PreparedStatement实例
	 */
	private static void closeCon(Connection con, PreparedStatement pstmt){
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//测试方法
//		System.out.println(new UserDao().findUser("123"));
//		new UserDao().addUser("1345", "1345");
	}


	
}
