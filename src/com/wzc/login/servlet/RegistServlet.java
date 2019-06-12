package com.wzc.login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.login.dao.UserDao;

/**
 * @description 注册请求处理类
 * @author WANGZIC
 */
public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rpsw = request.getParameter("rpsw");
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("msg", "用户名不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(!password.equals(rpsw)){
			request.setAttribute("msg", "密码不一致");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		UserDao u = new UserDao();
		boolean res = u.addUser(username,password);
		if(res){
			request.setAttribute("msg", "用户："+username+"注册成功，欢迎登录！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
