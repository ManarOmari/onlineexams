package login;

import java.io.PrintWriter;
import java.sql.*;



public class loginDao {
	public boolean ValidateIsAdmin(LoginBean log) throws ClassNotFoundException{
		 boolean status1 = false;
		 boolean isAdmin=false;
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from user where UserName = ? and Password = ? ");
	            preparedStatement.setString(1, log.getUsername());
	            preparedStatement.setString(2, log.getPassword());
	            
	            ResultSet rs = preparedStatement.executeQuery();
	           
	            status1 = rs.next();
	          
	          if(status1)
	          {
	        	  log.setIsAdmin(rs.getInt("user.IsAdmin"));
	        	  
	        	 if(log.getIsAdmin()==1)
	        	 {
	        		 System.out.println("Std");
	        		 isAdmin=false;
	        	 }
	        	 
	        	  
	        	 else 
	        	 {
	        		 System.out.println("Admin");
	        		 isAdmin=true;
	        	 }
	        		  
	          }
	          connection.close();
	            
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
		 
	        return isAdmin;
		
	}

	  public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
	        boolean status = false;
	       
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from user where UserName = ? and Password = ? ");
	            preparedStatement.setString(1, loginBean.getUsername());
	            preparedStatement.setString(2, loginBean.getPassword());
	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	                status = rs.next();
	                ValidateIsAdmin(loginBean);
	                System.out.print(ValidateIsAdmin(loginBean));
	            
	                connection.close();
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return status;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    
	    
	    // to register new user admin or student 
	    
	    public int registerEmployee(LoginBean employee) throws ClassNotFoundException {
	    	//int count=0;
	    	int result =0;
	    	
	    	// first check if the user already exist or not 
	    	// if not exist , then he will register as new user 
	    	if(CheckUsernameExists(employee.getUsername(),employee.getLName(),employee.getFName(),employee.getIsAdmin()))
        	{
        		result=-1;
        	}
	    	else 
	    		
	    	{
	        try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	        	// to know number of rows and to know what is the  user id ;
	        //	String numberOfCol="select count(*) from user";
	    	
	        	 String INSERT_USERS_SQL = "INSERT INTO user" +
	 	            "  (FName,LName, UserName, Password,IsAdmin) VALUES " +
	 	            " ( ?, ?, ?,?,?)";
	        		
	        		Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");
	        	//	PreparedStatement stm=connection.prepareStatement(numberOfCol);
	        	//	ResultSet  result1=stm.executeQuery(numberOfCol);
	        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
	        		
	        		
	        	
	        
	        		//preparedStatement.setString(1, employee.getFName());
		            preparedStatement.setString(1, employee.getFName());
		            preparedStatement.setString(2, employee.getLName());
		            preparedStatement.setString(3, employee.getUsername());
		            preparedStatement.setString(4, employee.getPassword());
		           preparedStatement.setInt(5, employee.getIsAdmin());

		            
		            // Step 3: Execute the query or update query
		            result = preparedStatement.executeUpdate();
	        	
	        	//System.out.println(result);
		            connection.close();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	    	}
	    		 return result;
	    	}
	  
	       
	  
	    
	    
	    // Check if the user already exist or not 
	    
	    public static boolean CheckUsernameExists(String username ,String LastName,String FName,int IsAdmin)
	    {
	        boolean usernameExists = false;

	        try
	        {

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");

	            PreparedStatement st = connection.prepareStatement("select * from user ");
	            
	            ResultSet r1=st.executeQuery();
	           
	            String usernameCounter;
	            String Fname;
	            String Lname;
	            int isAdmin;
	             if(r1.next()) 
	             {
	               usernameCounter =  r1.getString("UserName");
	               Fname =  r1.getString("FName");
	               Lname =  r1.getString("LName");
	              isAdmin =  r1.getInt("IsAdmin");
	               if(usernameCounter.equals(username)&&Fname.equals(FName)&&Lname.equals(LastName)&&(isAdmin==IsAdmin)) //this part does not happen even if it should
	               {
	            	   
	                  usernameExists = true;
	                
	                
	               }
	            
	             } connection.close();


	         }

	         catch (SQLException e) 
	         {
	            System.out.println("SQL Exception: "+ e.toString());
	         } 
	         catch (ClassNotFoundException cE) 
	         {
	            System.out.println("Class Not Found Exception: "+ cE.toString());
	         }

	       
	     return usernameExists;
	     }
	  
	  
	
	
	 // method to get all the the info about the user
	   public LoginBean log(LoginBean b) throws ClassNotFoundException
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");

	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from user where UserName = ? and Password = ? ");
	            preparedStatement.setString(1, b.getUsername());
	            preparedStatement.setString(2, b.getPassword());
	            
	            ResultSet rs = preparedStatement.executeQuery();
	          
	           
	           
	            boolean status1 = rs.next();
	          
	          if(status1)
	          {
	        	  b.setIsAdmin(rs.getInt("user.IsAdmin"));
	        	  b.setFName(rs.getString("FName"));
	        	  b.setLName(rs.getString("LName"));
	        	  b.setUsername(rs.getString("UserName"));
	        	  b.setPassword(rs.getString("Password"));
	        	  b.setUserId(rs.getInt("idUser"));
	        	
	        		  
	          }
	          connection.close();
	            
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
		 
		   return b;
	   }
	   
}
