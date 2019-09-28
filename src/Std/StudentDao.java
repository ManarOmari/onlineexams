package Std;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import uploadFile.AnswesBean;
import uploadFile.QuestionBean;

public class StudentDao {

	ResultSet rs;
	Connection connection;
	PreparedStatement preparedStatement;
	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub

	}

	public ArrayList<QuestionBean> getQuestion(int ExamId) {
		ArrayList<QuestionBean> qList = new ArrayList<QuestionBean>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams",
					"onlineexams");

			// Step 2:Create a statement using connection object
			 preparedStatement = connection.prepareStatement("select * from questions where ExamID= ?" );		
			preparedStatement.setInt(1, ExamId);
			 rs = preparedStatement.executeQuery();

			while (rs.next()) {
				QuestionBean question = new QuestionBean();
				question.setQuestionId(rs.getInt("idquestions"));
				question.setQuestionBody(rs.getString("questionBody"));
				qList.add(question);
				
		}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
	
		
				try 
	        	{
	        		rs.close();
	        		preparedStatement.close();
	        		connection.close();
	        	}
			   	catch (SQLException e) {e.printStackTrace();}
	          	        
	        
		}
		

		return qList;
	}
}

