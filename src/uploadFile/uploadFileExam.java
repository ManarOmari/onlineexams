package uploadFile;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.DeferredFileOutputStream;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
*/
/**
 * Servlet implementation class uploadFileExam
 */
@WebServlet("/uploadFileExam")
public class uploadFileExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// objects
	ExamDao exam;
	List<String> SplitingFile;
	AnswesBean[] answers;
	QuestionBean[] questions;
	CorrectAnswer[] ca;
	int[] UsersID;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		SplitingFile = new ArrayList<String>();
		try {
			exam = new ExamDao();
			answers = new AnswesBean[100];
			questions = new QuestionBean[100];
			UsersID = new int[100];
			ca = new CorrectAnswer[100];
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubjectBean sub = new SubjectBean();
		HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("uesrnameLog");
		String id = (String) session.getAttribute("idLog");
		String subjectid = (String) request.getParameter("subjectid");
		String doctor_id = (String) request.getParameter("doctor_id");
		String startDate = (String) request.getParameter("startDate");
		String endDate = (String) request.getParameter("endDate");
		String qNo = (String) request.getParameter("numberOfQ");
		String mark = (String) request.getParameter("mark");

		// String[] doctors = (String[]) request.getParameterValues("doctors");
		int QNo = Integer.parseInt(qNo);
		int subjectid1 = Integer.parseInt(subjectid);
    	int doctor_id1 = Integer.parseInt(doctor_id);
		double mark1 = Double.parseDouble(mark);
		String str = request.getParameter("readf");

		sub.setIdSubj(Integer.parseInt(subjectid)); // store id of selected subject
		SplitingFile = exam.SplitFile(str);// split file by comma
		questions = exam.getQuestions(SplitingFile); // get the questions from split File
		answers = exam.getAnswers(SplitingFile);// get the answers from split File
		UsersID = exam.GetStdId(SplitingFile);// get the student id from split File
		
		
		
		request.setAttribute("username", Name);
		request.setAttribute("userID", id);
		request.setAttribute("subjectId",subjectid);
		request.setAttribute("docId", doctor_id);
		request.setAttribute("start", startDate);
		request.setAttribute("end", endDate);
		request.setAttribute("qNo", qNo);
		request.setAttribute("mark", mark);
		
		try {
			exam.InsertToExam(UsersID, subjectid1, doctor_id1, questions, answers, startDate, endDate, QNo, mark1);
			request.getRequestDispatcher("HTML/AdminResult.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
