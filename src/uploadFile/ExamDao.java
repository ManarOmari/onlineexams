package uploadFile;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ExamDao {

	QuestionBean[] question;
	AnswesBean[] answers;
	CorrectAnswer[] cAnswers;
	// CorrectAnswer[] cAnswers1;
	List<String> S;
	int eID, qID, AnsID;

	public ExamDao() throws IOException {
		eID = 0;
	}

	// method to insert data to table Exam which contains idExam a, subjectID ,Date
	// of exam starting time and
	// ending time ,ability of doing exam and number of questions
	public void InsertToExam(int[] id, int SubId, int doctor_id, QuestionBean[] q, AnswesBean[] answer, String start,
			String end, int QNo, double total) throws ClassNotFoundException, ParseException {

		String s = "", s1 = "", s2 = "";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String INSERT_Exam_SQL = "INSERT INTO exams"
					+ "  (SubId,doctor_id, start,end,NoOfQuestion,totalMark) VALUES " + " (?,?,?,?,?,? ) ";

			String INSERT_exam_applied_SQL = "INSERT INTO exam_applied" + "  (userID,ExamID,flag,answers) VALUES "
					+ " (?,?,? ,'') ";
			String INSERT_questions_SQL = "INSERT INTO questions" + "  (ExamID,questionBody) VALUES " + " (?,? ) ";

			String INSERT_answers_SQL = "INSERT INTO answers" + "  (questionID,answerBody,ISCorrect, Rand) VALUES "
					+ " (?,?,?,?) ";

			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams",
					"onlineexams");

			// Exams table insert
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Exam_SQL);

			preparedStatement.setInt(1, SubId);
			preparedStatement.setInt(2, doctor_id);
			preparedStatement.setString(3, start);
			preparedStatement.setString(4, end);
			preparedStatement.setInt(5, QNo);
			preparedStatement.setDouble(6, total);
			preparedStatement.executeUpdate();

			// get the max id of table exam
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("SELECT max(idexams) as last_id from exams");
			ResultSet rs = preparedStatement2.executeQuery();
			if (rs.next()) {
				s = rs.getString("last_id");
			}

			eID = Integer.parseInt(s);

			// Ability Inserts
			PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_exam_applied_SQL);

			for (int i = 0; i < id.length; i++) {
				preparedStatement1.setInt(1, id[i]);
				preparedStatement1.setInt(2, eID);
				preparedStatement1.setInt(3, 1);
				preparedStatement1.executeUpdate();

			}
			// Quesions Inserts

			PreparedStatement preparedStatement3 = connection.prepareStatement(INSERT_questions_SQL,
					Statement.RETURN_GENERATED_KEYS);

			for (int i = 0; i < q.length; i++) {
				preparedStatement3.setInt(1, eID);
				preparedStatement3.setString(2, q[i].getQuestionBody());
				preparedStatement3.executeUpdate();

				ResultSet keys = preparedStatement3.getGeneratedKeys();
				keys.next();
				int QuestionID = keys.getInt(1);

				PreparedStatement preparedStatement4 = connection.prepareStatement(INSERT_answers_SQL);

				for (int j = 4 * i; j < 4 * i + 4; j++) {
					preparedStatement4.setInt(1, QuestionID);
					preparedStatement4.setString(2, answer[j].getAnswerBody());
					preparedStatement4.setInt(3, answers[j].getIsCorrect());
					
					double randomDouble = Math.random();
					randomDouble = randomDouble * 100 + 0;
					preparedStatement4.setInt(4, (int) randomDouble);
					preparedStatement4.executeUpdate();

				}

			}

			connection.close();

		} catch (

		SQLException e) {
			// process sql exception
			printSQLException(e);
		}

		// return result;
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub

	}

	// Method to read the file and split it
	public List<String> SplitFile(String filePath) throws IOException {
		String s = filePath;
		List<String> strarr = new ArrayList<String>();
		String[] arr = s.split(",");
		strarr = Arrays.asList(arr);

		return strarr;
	}

	// function to get the questions body from uploaded file

	public QuestionBean[] getQuestions(List<String> arr) {
		int count = 0;

		int numberOfQuestions = Integer.parseInt(arr.get(0));
		question = new QuestionBean[arr.size()];//

		// number of question * 5 , after that the number of student how should do the
		// exam
		int NoOfQueAns = numberOfQuestions * 5;

		for (int i = 0; i < NoOfQueAns; i++) {
			if ((i % 5) == 0) {
				question[count] = new QuestionBean();
				question[count].setQuestionBody(arr.get(i + 1));
				question[count].setQuestionId(count);
				count++;

			}

		}
		QuestionBean[] questionN = Arrays.copyOf(question, count); // resize the array

		return questionN;
	}

	// function to get answers from uploaded file

	public AnswesBean[] getAnswers(List<String> arr) {
		int count = 0;

		// arr[0] number of qusetions

		int numberOfQuestions = Integer.parseInt(arr.get(0));
		answers = new AnswesBean[arr.size()];//
		
		// number for answers = number of question *4
		int NoOfQueAns = numberOfQuestions * 5;

		for (int i = 0; i < NoOfQueAns; i++) {
			if ((i % 5) != 0) {
				answers[count] = new AnswesBean();
				answers[count].setAnswerBody(arr.get(i + 1));
				answers[count].setAnswerId(i + 1);
				if (i % 5 == 1) {
					answers[count].setIsCorrect(1);

				}
				count++;

			}
		}
		AnswesBean[] AnswerN = Arrays.copyOf(answers, count); // resize the array

		return AnswerN;
	}

	// method to get number of std and their ID's

	public int[] GetStdId(List<String> arr) {

		int numberOfQuestions = Integer.parseInt(arr.get(0));
		int count = 0;

		// number of question * 5 , after that the number of student how should do the
		// exam
		// number for answers = number of question *4
		int NoOfQueAns = numberOfQuestions * 5; // 25
		int numberOfStd = arr.size() - NoOfQueAns - 2; // -2 is the number of Q and the number of std
		List<String> x = arr.subList(NoOfQueAns + 2, arr.size());

		int[] IdStd = new int[x.size()];

		for (int i = 0; i < x.size(); i++) {
			IdStd[i] = Integer.parseInt(x.get(i));

		}
		return IdStd;
	}

	// get the correct answes
	public CorrectAnswer[] getCorrectAnswers(List<String> arr) {

		int count = 0;

		int numberOfQuestions = Integer.parseInt(arr.get(0));

		int NoOfQueAns = numberOfQuestions * 5;

		for (int i = 2; i < NoOfQueAns; i += 5) {

			cAnswers[count] = new CorrectAnswer();
			cAnswers[count].setBody(arr.get(i));
			cAnswers[count].setId(i);
			answers[count].setIsCorrect(1);
			count++;

			System.out.print(cAnswers[count]);
		}
		CorrectAnswer[] CA = Arrays.copyOf(cAnswers, count); // resize the array

		return CA;
	}
	
	
	
	//method to calculate the number of correct answer 
	public int getNoOfCorrectAnswer(String str)
	{
		
		int noOfCorrectAns=0;
		int QuestionID=0;
		int AnswerID=0;
		int x=0;
		if (!str.equals("") && !str.equals("null")) {
			
			String[] qmarks = str.split("|");
		
			for (int i = 0; i < qmarks.length; i++) {
				
				String[] marks = qmarks[i].split(",");
				
	//			System.out.println(marks[i]+"m");
				if (marks.length == 2) {
				QuestionID = Integer.parseInt(marks[0].toString());
				 AnswerID = Integer.parseInt(marks[1].toString());
				
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams",
								"onlineexams");
						PreparedStatement preparedStatement = connection.prepareStatement("select * from answers where idanswers = ? and questionID = ?");

						preparedStatement.setInt(1, AnswerID);
						preparedStatement.setInt(2, QuestionID);
						ResultSet rs = preparedStatement.executeQuery();
						if(rs.next())
						{
							x=rs.getInt("ISCorrect");
							if(x==1)
								noOfCorrectAns++;
							System.out.println("qqq");
						}
						else {
							System.out.println("fff");
						}
						


					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
	}
        return noOfCorrectAns;
}
}
