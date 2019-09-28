package uploadFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NameOfInst
 */
@WebServlet("/NameOfInst")
public class NameOfInst extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectBean sub;
	ExamDao examDao;
	ExamBean examBean;
	List<String> filePath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NameOfInst() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {

			examDao = new ExamDao();
			examBean = new ExamBean();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("uesrnameLog");
		String id = (String) session.getAttribute("idLog");

		String subjectid = request.getParameter("subjectid");
		String doctor_id = request.getParameter("doctor_id");
		String NoQ = request.getParameter("QNo");
		
		LocalDateTime start = LocalDateTime.parse(request.getParameter("start"));
		LocalDateTime end = LocalDateTime.parse(request.getParameter("end"));
		

		String mark = request.getParameter("mark");

		// String[] contentFile=(String[]) session.getAttribute("SplitFile");

		request.setAttribute("subjectid", subjectid);
		request.setAttribute("NoQ", NoQ);
		request.setAttribute("doctor_id", doctor_id);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		
		request.setAttribute("markk", mark);
		request.getRequestDispatcher("HTML/uploadFile.jsp").forward(request, response);

	}

}
