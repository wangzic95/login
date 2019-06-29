package com.wzc.login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.login.dao.UserDao;
import com.wzc.login.domain.User;

/**
 * @description 注册请求处理类
 * @author WANGZIC
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rpsw = request.getParameter("rpsw");
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("registError", "用户名不能为空");
			request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("registError", "密码不能为空");
			request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request, response);
			return;
		}
		if(!password.equals(rpsw)){
			request.setAttribute("registError", "密码不一致");
			request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request, response);
			return;
		}
		UserDao dao = new UserDao();
		User user =new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean res = dao.insert(user);
		if(res){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("registError", "注册失败，该用户名已存在");
			request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
