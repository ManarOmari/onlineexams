package Std;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class appliedExam
 */
@WebServlet("/appliedExam")
public class appliedExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appliedExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// id exam 
		// id user 
	Integer idUser=Integer.parseInt(session.getAttribute("idLog").toString()) ;
	Integer idExam=Integer.parseInt(request.getParameter("examId").toString()) ;
	
	// open connection 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");
		PreparedStatement PS = con.prepareStatement("update exam_applied set flag = 0, answers=? where userID =? and ExamID  =?");
		String AnswersStr = "";
		
		if (session.getAttribute("studentanswers") != null) {
			AnswersStr += session.getAttribute("studentanswers").toString();
		}
		PS.setString(1, AnswersStr);
		PS.setInt(2, idUser);
		PS.setInt(3, idExam);
		PS.executeUpdate();
		response.sendRedirect("HTML/loginS.jsp");
		//request.getRequestDispatcher("HTML/result.jsp").forward(request, response);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

}
