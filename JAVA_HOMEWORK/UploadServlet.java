

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gbk");
		try {
			//判断request对象中是否有提交的文件？
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
			if (!isMultipart) {
				request.getRequestDispatcher("/list").forward(request, response);
				return;
			}
			
			HttpSession session = request.getSession();
			File current = (File) session.getAttribute("current");
			if (current == null) {
				current = new File(ListServlet.SHARE_DIR);
				session.setAttribute("current", current);
			}
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置提交的文件的大小限制，单位是字节，30M，
			//如果不设置文件大小限制，默认值是10K。
			//设置临时工作目录，如果提交的文件比较小，则缓存在内存中。
			//如果提交的文件比较大，那么存入在指定的目录下，
			//文件名称是一个比较长的临时文件名称。
			factory.setRepository(current);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置请求对象的内容大小限制，这个限制真正起作用。
			//论文30M字节大小限制。
			upload.setSizeMax(30000000);
			
			// Parse the request
			List /* FileItem */items = upload.parseRequest(request);

			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					String fieldName = item.getFieldName();//返回tfile
					String fileName = item.getName();	//返回提交的文件名
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					//如果不选择文件，而直接提交的话，那么直接返回。
					if(fileName.length()==0 && sizeInBytes == 0) {
						request.getRequestDispatcher("/list").forward(request, response);
						return;
					}
					DiskFileItem dfi = (DiskFileItem) item;
					//请注意不同的浏览器版本。
					File toFile = new File(current, fileName);
					
					dfi.write(toFile);	//存入文件，删除临时文件
				}
			}
			request.getRequestDispatcher("/list").forward(request, response);
			return;
		} catch (Exception e) {
			response.getWriter().print(e.getMessage());
			return;
		}
	}

}
