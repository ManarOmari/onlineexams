package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet({ "/login" })
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private loginDao loginDao1;

	public void init() {
		loginDao1 = new loginDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		// doPost(req,resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginBean loginBean = new LoginBean();
		LoginBean b1 = new LoginBean();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (loginDao1.validate(loginBean)) {
				HttpSession session = request.getSession();
				if (loginDao1.ValidateIsAdmin(loginBean)) {
					b1 = loginDao1.log(loginBean);
					session.setAttribute("uesrnameLog", loginBean.getUsername());
					session.setAttribute("idLog", String.valueOf(loginBean.getUserId()));

					response.sendRedirect("HTML/loginA.jsp");

				} else {

					b1 = loginDao1.log(loginBean);
					session.setAttribute("uesrnameLog", b1.getUsername());
					session.setAttribute("idLog", String.valueOf(b1.getUserId()));

					response.sendRedirect("HTML/loginS.jsp");
				}

			} else {

				response.sendRedirect("HTML/login.jsp");

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
