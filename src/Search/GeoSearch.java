package Search;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntryDAO;
import databeans.Entry;


@WebServlet("/geosearch")
public class GeoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private EntryDAO dao = new EntryDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

	/*
	 * Input field accepts the ID of an existing cities in databean and returns
	 * the time zone in ZIP file (zip file contains txt file with time zone)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		
		
		if (numStr == null) {
			request.setAttribute("error", "Invalid parameter: id == null");
            RequestDispatcher d = request
                    .getRequestDispatcher("Error.jsp");
            d.forward(request, response);
            return;
		}
		try {
			int num = Integer.parseInt(numStr);
			Entry e = dao.read(num);
			try {
			 StringBuilder sb = new StringBuilder();
			 sb.append(e.getTimeZone());

			 File f = new File("F:\\test.zip");
			 ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
			 ZipEntry ent = new ZipEntry("test.txt");
			 out.putNextEntry(ent);

			 byte[] data = sb.toString().getBytes();
			 out.write(data, 0, data.length);
			 out.closeEntry();

			 out.close();
			}catch (IOException ex) {
			      ex.printStackTrace();
			    }

		} catch (NumberFormatException e) {
			request.setAttribute("error", "Invalid parameter: id is not a number");
            RequestDispatcher d = request
                    .getRequestDispatcher("Error.jsp");
            d.forward(request, response);
		}
		
		
		doGet(request, response);
	}

}
