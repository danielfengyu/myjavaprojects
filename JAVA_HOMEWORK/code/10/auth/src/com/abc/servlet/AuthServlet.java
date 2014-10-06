package com.abc.servlet;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//�����URL·��Ϊauth.jpg
@WebServlet("/auth.jpg")
public class AuthServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����һ��1000��9999�����������
		String s = String.valueOf(new Random().nextInt(9000) + 1000);
		HttpSession session = request.getSession();
		session.setAttribute("authcode", s); // ���浽session��
		// Servlet��������������ͻ��˵���������ΪͼƬ
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache"); // �رտͻ��˻���ͼƬ����
		response.setHeader("Cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
		// ����һ��ͼƬ��������������֣���ת��Ϊ���������response����
		OutputStream os = response.getOutputStream();
		BufferedImage image = new BufferedImage(38, 20,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 38, 20);
		g.setColor(Color.BLUE);
		g.drawString(s, 6, 14);
		ImageIO.write(image, "JPEG", os);
		os.close();
	}
}
