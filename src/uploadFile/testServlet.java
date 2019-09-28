package uploadFile;

import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.RepositoryIdHelper;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("uesrnameLog");
		String id = (String) session.getAttribute("idLog");
		String subjectid = request.getParameter("subjectid");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		// get the values of checkBox
		int idSub = Integer.parseInt(subjectid);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams",
					"onlineexams");

			PreparedStatement ps = con.prepareStatement("select * from doctors where subjectID =" + idSub);

			ResultSet rs = ps.executeQuery();

			/* Printing column names */

	;
			out.print("<body style='background:linear-gradient(to bottom, #0b97ea, #f1f1f1);font-weigth:600;'> ");  
			out.print("<div class='container'> ");
			out.print("<div class='row'> ");
			out.print("<div class='col-md-4'></div>"); 
			out.print("<div class='col-md-6'> ");
			out.print("<form method=\"post\" action='HTML/InstructorsName.jsp'> ");
			
			out.print("<input type=\"hidden\" name=\"subjectid\" value=\"" + subjectid + "\" />");
			out.print("<h1 style= 'color: white; margin-left: 217px;\r\n margin-top: 81px;'>Insructors are </h1>");
			out.print("<ul style='color:#042548; font-weight:bolder; font-size:x-large;\r\n padding-left: 181px;\r\n padding-bottom:20px;'>");
			  
			while (rs.next())

			{
				
				out.print("<input type=\"radio\" name=\"doctor_id\" value=\"" + rs.getInt("iddoctors") + "\"> <label>"
						+ rs.getString("doctorName") + "</label><br/>" );
				
			}
			out.print("</ul>");
			out.print("<input type=\"submit\" style='background-color:#03a9f4;font-size:20px;color:white;margin-left: 88px;'/>");
			out.print("</form>");
			out.print("</div> ");
			out.print("</div> ");
			out.print("</div> ");
			out.print("</body");
			out.close();
	

		} catch (Exception e2)

		{

			e2.printStackTrace();

		}

		finally {
			out.close();

		}
		out.close();

	}

}
