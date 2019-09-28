package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  private loginDao log;

	
	public void init(ServletConfig config) throws ServletException {
		
		log=new loginDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		
		  String FName = request.getParameter("FName");
		  String LName = request.getParameter("LName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isAdminSelect = request.getParameter("isAdminSelect");
        
        LoginBean employee = new LoginBean();
        
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setFName(FName);
        employee.setLName(LName);
        if(isAdminSelect.equalsIgnoreCase("admin"))
        {
        	employee.setIsAdmin(0);
        }
        else 
        {
        	employee.setIsAdmin(1);
        }

        try
        {
            log.registerEmployee(employee);
            
            response.sendRedirect("HTML/success.jsp");
 

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

   
    }

}
