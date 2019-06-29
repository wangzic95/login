package com.wzc.login.servlet;

import com.wzc.login.dao.UserDao;
import com.wzc.login.domain.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 * @author WANGZIC
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao dao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String act =request.getParameter("act");
		if(act!=null){
			//根据传输的act调用不同的方法进行处理
			switch (act) {
				case "toUpdatePage":
					toUpdatePage(request,response);
					break;
				case "select":
					selectAllUsers(request,response);
					break;
				case "insert":
					insertUser(request,response);
					break;
				case "update":
					updateUser(request, response);
					break;
				case "delete":
					deleteUser(request, response);
					break;
				default:selectAllUsers(request,response);
					break;
			}
		}else {
			response.getWriter().print("act参数不能位空，请检查是否传输了该参数！");
		}

	}

	private void toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Integer userid =Integer.valueOf(request.getParameter("userid"));
		User user = dao.selectByUserId(userid);
		request.setAttribute("updateUser", user);
		request.getRequestDispatcher(request.getContextPath()+"/modules/usermgr/update.jsp").forward(request, response);
	}

	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = dao.selectByMap(new HashMap<>(0));
		request.setAttribute("userList", list);
		request.getRequestDispatcher(request.getContextPath()+"/modules/usermgr/index.jsp").forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		User user = new User();
		if(username!=null){
			user.setUsername(username);
		}
		if(nickname!=null){
			user.setNickname(nickname);
		}
		if(password!=null){
			user.setPassword(password);
		}
		if(phone!=null){
			user.setPhone(phone);
		}
		if(gender!=null){
			user.setGender(gender);
		}
		if(email!=null){
			user.setEmail(email);
		}
		if(address!=null){
			user.setAddress(address);
		}
		if(dao.insert(user)){
			request.getSession().setAttribute("resultMSG", "新增成功");
			response.sendRedirect(request.getContextPath()+"/modules/usermgr/index.jsp");
		}else {
			request.getSession().setAttribute("resultMSG", "新增失败");
			request.getRequestDispatcher(request.getContextPath()+"/modules/usermgr/insert.jsp").forward(request, response);
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Integer userid =Integer.valueOf(request.getParameter("userid"));
		if(dao.delete(userid)){
			request.getSession().setAttribute("resultMSG", "删除成功");
		}else {
			request.getSession().setAttribute("resultMSG", "删除失败");
		}
		response.sendRedirect(request.getContextPath()+"/modules/usermgr/index.jsp");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String userid =request.getParameter("userid");
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		User user = new User();
		if(userid!=null){
			user.setUserid(Integer.valueOf(userid));
		}
		if(username!=null){
			user.setUsername(username);
		}
		if(nickname!=null){
			user.setNickname(nickname);
		}
		if(password!=null){
			user.setPassword(password);
		}
		if(phone!=null){
			user.setPhone(phone);
		}
		if(gender!=null){
			user.setGender(gender);
		}
		if(email!=null){
			user.setEmail(email);
		}
		if(address!=null){
			user.setAddress(address);
		}
		if(dao.update(user)){
			request.getSession().setAttribute("resultMSG", "修改成功");
			response.sendRedirect(request.getContextPath()+"/modules/usermgr/index.jsp");
		}else {
			request.setAttribute("updateUser", user);
			request.getSession().setAttribute("resultMSG","修改失败");
			request.getRequestDispatcher(request.getContextPath()+"/modules/usermgr/update.jsp").forward(request, response);
		}
	}
}
