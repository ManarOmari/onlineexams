package Std;

import java.io.*;

import java.sql.*;
import java.util.ArrayList;

import uploadFile.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StdShowExams
 */
@WebServlet("/StdShowExams")
public class StdShowExams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExamDao e;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StdShowExams() {

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			e = new ExamDao();
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
		HttpSession session = request.getSession();
		if (session.getAttribute("idLog") == null) {
			response.sendRedirect("HTML/login.jsp");
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("idLog") == null) {
			response.sendRedirect("HTML/login.jsp");
			return;
		}

		String[] x = new String[2];////

		Integer userID = Integer.parseInt(session.getAttribute("idLog").toString());

		Integer examID = Integer.parseInt(request.getParameter("eID").toString());

		ArrayList<String[]> answers = new ArrayList<String[]>();

		request.setAttribute("examId", examID.toString());
		request.setAttribute("questionName", "System Error Please try again");

		int size = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con;

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");
			PreparedStatement ExamPS = con.prepareStatement(
					"select e.*,s.* from exams e INNER JOIN subject s ON(e.SubId=s.idsubject) INNER JOIN exam_applied ea ON(e.idexams=ea.ExamID) WHERE ea.flag=1  AND ea.userID=? AND e.idexams=? LIMIT 1");
			PreparedStatement QuestionPS = con.prepareStatement(
					"select count(*) total from questions q INNER JOIN exams e ON(q.ExamID=e.idexams) INNER JOIN exam_applied ea ON(e.idexams=ea.ExamID) WHERE ea.flag=1  AND ea.userID=? AND e.idexams=? ");
			QuestionPS.setInt(1, userID);
			QuestionPS.setInt(2, examID);
			ResultSet QuestionsResultSet = QuestionPS.executeQuery();
			int NoALLQuestion = 0;
			while (QuestionsResultSet.next()) {
				NoALLQuestion = Integer.parseInt(QuestionsResultSet.getString("total").toString());
			}

			int NoQuestion = 0;
			double TotalMark = 0;

			ExamPS.setInt(1, userID);
			ExamPS.setInt(2, examID);
			ResultSet ExamResultSet = ExamPS.executeQuery();
			while (ExamResultSet.next()) {
				NoQuestion = Integer.parseInt(ExamResultSet.getString("NoOfQuestion").toString());
				TotalMark = Double.parseDouble(ExamResultSet.getString("totalMark").toString());
			}
			session.setAttribute("TotalMark", TotalMark);
			if (NoQuestion <= 0) {
				throw new Exception("Error Exam Setup");
			}

			String AnswersStr = "";
			String finalres = "";

			if (session.getAttribute("studentanswers") != null) {
				AnswersStr += session.getAttribute("studentanswers").toString();
			}
			
			if (request.getParameter("myanswer") != null) {
				AnswersStr += (request.getParameter("qid").toString() + ","
						+ request.getParameter("myanswer").toString());
			}
			
			if (!AnswersStr.equals("") && !AnswersStr.equals("null")) {

				String[] q_w_m = AnswersStr.split("-");
				int[] Questions = new int[q_w_m.length];
				int[] Answers = new int[q_w_m.length];

				for (int i = 0; i < Questions.length; i++) {
					Questions[i] = 0;
				}

				int QuestionID = 0;
				int AnswerID = 0;
				int Counter = 0;
				
				for (int i = 0; i < q_w_m.length; i++) {
					
					String[] marks = (q_w_m[i]).split(",");
					
					if (marks.length == 2) {
						QuestionID = Integer.parseInt(marks[0].toString());
						AnswerID = Integer.parseInt(marks[1].toString());
						
						int addtoarray = 1;
						int foundIndex=-1;
						for (int j = 0; j <= i; j++) {
							if (Questions[j] == QuestionID) {
								addtoarray = 0;
								foundIndex= j;
							}
						}
						
						if (addtoarray == 1) {
							Questions[Counter] = QuestionID;
							Answers[Counter] = AnswerID;
							Counter++;
						} else {
							Questions[foundIndex] = QuestionID;
							Answers[foundIndex] = AnswerID;
						}

					}
				}

				for (int i = 0; i < Questions.length; i++) {
					if (Questions[i] > 0) {
						finalres += "" + Questions[i] + "," + Answers[i] + "-";
					}
				}
			}

			session.setAttribute("studentanswers", finalres);// why do you use the same variable
			request.setAttribute("answersStr", finalres);

			Integer Qidx = 0;

			if (request.getParameter("qidx") != null && !request.getParameter("qidx").toString().equals("")) {
				Qidx = Integer.parseInt(request.getParameter("qidx").toString());
			}

			if (request.getParameter("action") != null && request.getParameter("action").toString().equals("finish")) {
				request.setAttribute("mark", 72);
				request.getRequestDispatcher("HTML/result.jsp").forward(request, response);
			} else {

				if (request.getParameter("action") != null
						&& request.getParameter("action").toString().equals("next")) {
					Qidx++;

				}

				if (request.getParameter("action") != null
						&& request.getParameter("action").toString().equals("prev")) {
					Qidx--;
				}

				if (Qidx < 0) {
					Qidx = 0;
				}
				if (Qidx >= NoQuestion) {
					Qidx = NoQuestion - 1;
				}

				String[] QuestionsApplied;
				String questions = "";

				if (request.getParameter("questions") != null
						&& !request.getParameter("questions").toString().equals("")) {
					questions = request.getParameter("questions").toString();
					QuestionsApplied = questions.substring(0, questions.length() - 1).split(",");
				} else {
					questions = "";
					QuestionsApplied = null;
					Qidx = 0;
				}

				String xx_AND_SQL = "";
				if (QuestionsApplied != null) {
					if ((Qidx) < QuestionsApplied.length) {
						xx_AND_SQL = " AND q.idquestions=" + QuestionsApplied[Qidx].toString();
					} else if (QuestionsApplied.length > 0) {
						xx_AND_SQL = " AND q.idquestions NOT IN (";
						for (String string : QuestionsApplied) {
							xx_AND_SQL += string + ",";
						}
						xx_AND_SQL += "0)";
					}
				}

				int len = 0;
				if (QuestionsApplied != null) {
					len = QuestionsApplied.length;
				}
				int xRandom = NoALLQuestion - len;
				if (xRandom < 0) {
					xRandom = 0;
				}

				double randomDouble = Math.random();
				randomDouble = randomDouble * xRandom + 0;
				xRandom = (int) randomDouble;

				int Limit = 1;
				if (len >= NoQuestion) {
					// Limit = 0;
					Limit = 1;
				}

				String xSQL = "SELECT q.* FROM questions q " + "INNER JOIN exams e ON(q.ExamID=e.idexams) "
						+ "INNER JOIN subject s ON(e.SubId=s.idsubject) "
						+ "INNER JOIN exam_applied ea ON(e.idexams=ea.ExamID) "
						+ "WHERE ea.flag=1  AND ea.userID=? AND e.idexams=? ";

				xSQL += xx_AND_SQL;

				xSQL += " LIMIT " + xRandom + "," + Limit;

				PreparedStatement ps = con.prepareStatement(xSQL);
				ps.setInt(1, userID);
				ps.setInt(2, examID);

				ResultSet resultSet = ps.executeQuery();

				try {
					resultSet.last();
					size = resultSet.getRow();
					resultSet.beforeFirst();

				} catch (Exception ex) {
					size = 0;
				}

				if (size > 0) {
					while (resultSet.next()) {
						if (Qidx < 0) {
							Qidx = 0;
						}

						if (len < (Qidx + 1)) {
							questions += resultSet.getString("idquestions").toString() + ",";
						}

						if (Qidx <= 0) {
							request.setAttribute("bnext",
									"<button type=\"submit\" class='btn btn-primary' name=\"action\" value=\"next\"> Answer </button>");
							request.setAttribute("bprev", "");
							request.setAttribute("qidx", "0");
						} else if (Qidx >= NoQuestion - 1) {
							request.setAttribute("bnext",
									"<button type=\"submit\" class='btn btn-secondary' name=\"action\" value=\"finish\"> Finish </button>");
							request.setAttribute("bprev",
									"<button type=\"submit\" class='btn btn-primary' name=\"action\" value=\"prev\"> Previous </button>");
							request.setAttribute("qidx", NoQuestion - 1);
						} else {
							request.setAttribute("bnext",
									"<button type=\"submit\" class='btn btn-primary' name=\"action\" value=\"next\"> Answer </button>");
							request.setAttribute("bprev",
									"<button type=\"submit\" class='btn btn-primary' name=\"action\" value=\"prev\"> Previous </button>");
							request.setAttribute("qidx", Qidx);
						}

						request.setAttribute("examId", examID.toString());
						request.setAttribute("questionName", resultSet.getString("questionBody").toString());
						request.setAttribute("questions", questions);
						request.setAttribute("question_id", resultSet.getString("idquestions").toString());
						request.setAttribute("question_body", resultSet.getString("questionBody").toString());

						// get answers
						PreparedStatement psAns = con
								.prepareStatement("SELECT a.* FROM answers a WHERE a.questionID=? ORDER BY Rand");
						psAns.setInt(1, Integer.parseInt(resultSet.getString("idquestions").toString()));

						ResultSet resultSetAns = psAns.executeQuery();
						Integer answers_size = 0;

						try {
							resultSetAns.last();
							answers_size = resultSetAns.getRow();
							resultSetAns.beforeFirst();
						} catch (Exception ex) {
							answers_size = 0;
						}

						if (answers_size > 0) {
							while (resultSetAns.next()) {

								x = new String[2];
								x[0] = resultSetAns.getString("idanswers").toString();
								x[1] = resultSetAns.getString("answerBody").toString();
								answers.add(x);
							}
						} else {
							throw new Exception(" NO answers , Exam settings error ");
						}

						request.setAttribute("answers", answers);
						// int ca = e.getNoOfCorrectAnswer(AnswersStr);
						// session.setAttribute("ca", ca);

					}
				}
				request.getRequestDispatcher("HTML/questions.jsp").forward(request, response);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
