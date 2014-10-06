

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
			//�ж�request�������Ƿ����ύ���ļ���
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
			//�����ύ���ļ��Ĵ�С���ƣ���λ���ֽڣ�30M��
			//����������ļ���С���ƣ�Ĭ��ֵ��10K��
			//������ʱ����Ŀ¼������ύ���ļ��Ƚ�С���򻺴����ڴ��С�
			//����ύ���ļ��Ƚϴ���ô������ָ����Ŀ¼�£�
			//�ļ�������һ���Ƚϳ�����ʱ�ļ����ơ�
			factory.setRepository(current);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			//���������������ݴ�С���ƣ�����������������á�
			//����30M�ֽڴ�С���ơ�
			upload.setSizeMax(30000000);
			
			// Parse the request
			List /* FileItem */items = upload.parseRequest(request);

			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					String fieldName = item.getFieldName();//����tfile
					String fileName = item.getName();	//�����ύ���ļ���
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					//�����ѡ���ļ�����ֱ���ύ�Ļ�����ôֱ�ӷ��ء�
					if(fileName.length()==0 && sizeInBytes == 0) {
						request.getRequestDispatcher("/list").forward(request, response);
						return;
					}
					DiskFileItem dfi = (DiskFileItem) item;
					//��ע�ⲻͬ��������汾��
					File toFile = new File(current, fileName);
					
					dfi.write(toFile);	//�����ļ���ɾ����ʱ�ļ�
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
