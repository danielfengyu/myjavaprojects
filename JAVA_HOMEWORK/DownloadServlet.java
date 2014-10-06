

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得客户端提交的参数数据，通过查询字符串（QueryString）来完成
		String filename = request.getParameter("file");
		// 取消浏览器对下载文件的缓存功能
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
		/*输出内容类型设置完毕后，设置输出文件的名称
		//response.setHeader("Content-Disposition", "attachment;filename=\"" + filename
				//+ "\"");
		// 得到下载文件所在的目录，通过组件的配置信息来获得
		//String basePath = getInitParameter("software");
		// 将Web应用的虚拟路径转换为文件系统的物理路径
		//filename = getServletContext().getRealPath(basePath + "/" + filename);
		// 设置输出文件长度
		File f1 = new File(filename);
		response.setContentLength((int) f.length());
		// 准备输出，将服务器上文件以流的形式读入到虚拟机中，
		// 然后再以流数据的形式输出到response对象中*/
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
