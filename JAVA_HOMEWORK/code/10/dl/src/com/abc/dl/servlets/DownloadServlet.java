package com.abc.dl.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ÿͻ����ύ�Ĳ������ݣ�ͨ����ѯ�ַ�����QueryString�������
		String op = request.getParameter("fileid");
		// ȡ��������������ļ��Ļ��湦��
		if (request.getProtocol().equals("HTTP/1.0")) {
			// HTTP 1.0
			response.setHeader("Pragma", "no-cache");
		} else {
			// HTTP 1.1 or later
			response.setHeader("Cache-Control", "no-cache");
		}
		if (op == null) {
			op = "";
		}
		if (op.equals("1")) { // ����ļ����صı��Ϊ1��������a.rar
			// �������������������ͣ�Ϊ�����ļ���Ҳ�����޸�Ϊ��
			// response.setContentType("application/octet-stream");
			response.setContentType("application/x-download");
			op = "a.rar";
		} else if (op.equals("2")) {
			response.setContentType("application/x-download");
			op = "gj.pdf";
		} else if (op.equals("3")) {
			response.setContentType("application/x-download");
			op = "b.doc";
		} else { // ������ṩ���ص��ļ���ţ���ôת���������ļ��б�ҳ��
			request.getRequestDispatcher("/servlet/main.html").forward(request,
					response);
			return;
		}
		// �����������������Ϻ���������ļ�������
		response.setHeader("Content-Disposition", "attachment;filename=\"" + op
				+ "\"");
		// �õ������ļ����ڵ�Ŀ¼��ͨ�������������Ϣ�����
		String basePath = getInitParameter("software");
		// ��WebӦ�õ�����·��ת��Ϊ�ļ�ϵͳ������·��
		op = getServletContext().getRealPath(basePath + "/" + op);
		// ��������ļ�����
		File f = new File(op);
		response.setContentLength((int) f.length());
		// ׼������������������ļ���������ʽ���뵽������У�
		// Ȼ�����������ݵ���ʽ�����response������
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(f);

		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(os);

		byte[] buff = new byte[8192];
		int r = 0;
		while ((r = bis.read(buff)) != -1) {
			bos.write(buff, 0, r);
			bos.flush();
		}
		bis.close();
		fis.close();
		bos.close();
		os.close();
	}
}
