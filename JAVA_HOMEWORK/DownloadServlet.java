

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ÿͻ����ύ�Ĳ������ݣ�ͨ����ѯ�ַ�����QueryString�������
		String filename = request.getParameter("file");
		// ȡ��������������ļ��Ļ��湦��
		if (request.getProtocol().equals("HTTP/1.0")) {
			// HTTP 1.0
			response.setHeader("Pragma", "no-cache");
		} else {
			// HTTP 1.1 or later
			response.setHeader("Cache-Control", "no-cache");
		}
		response.setContentType("application/x-download");
		String filename2 = java.net.URLEncoder.encode(filename,"UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename2  + "\"");
		
		HttpSession session = request.getSession();
		File current = (File) session.getAttribute("current");
		if (current == null) {
			current = new File(ListServlet.SHARE_DIR);
			session.setAttribute("current", current);
		}
		File f = new File(current, filename);
		response.setContentLength((int) f.length());
		System.out.println("download" + f);
		/*�����������������Ϻ���������ļ�������
		//response.setHeader("Content-Disposition", "attachment;filename=\"" + filename
				//+ "\"");
		// �õ������ļ����ڵ�Ŀ¼��ͨ�������������Ϣ�����
		//String basePath = getInitParameter("software");
		// ��WebӦ�õ�����·��ת��Ϊ�ļ�ϵͳ������·��
		//filename = getServletContext().getRealPath(basePath + "/" + filename);
		// ��������ļ�����
		File f1 = new File(filename);
		response.setContentLength((int) f.length());
		// ׼������������������ļ���������ʽ���뵽������У�
		// Ȼ�����������ݵ���ʽ�����response������*/
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
