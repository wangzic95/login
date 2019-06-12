package com.wzc.login.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.login.utils.VerifyCode;

/**
 * @description 验证码请求生成处理类
 * @author WANGZIC
 */
public class VerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage(90,35);
		request.getSession().setAttribute("sessionverify", vc.getText());
		VerifyCode.output(image, response.getOutputStream());

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
