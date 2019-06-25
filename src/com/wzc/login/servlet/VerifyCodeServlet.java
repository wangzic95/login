package com.wzc.login.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 验证码请求生成处理类
 * @author WANGZIC
 */
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String verifyCode = getVerifyCode(90,35,response.getOutputStream());
		request.getSession().setAttribute("sessionverify",verifyCode);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}


	/**
	 * 验证码生成工具
	 * @param width 图片高度
	 * @param height 图片宽度
	 * @param out 输出流
	 * @return 验证码文本
	 * @throws IOException
	 */
	public static String getVerifyCode(int width,int height,OutputStream out) throws IOException{
		char[] chars = { '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
				'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		Random random = new Random();
		StringBuilder codeText = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			codeText.append(chars[random.nextInt(chars.length)]);
		}
		Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		Color reverse = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
		BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(codeText.toString(), 10, 26);
		for (int i = 0, n = random.nextInt(80); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		ImageIO.write(bi, "JPEG", out);
		return codeText.toString();
	}
}
