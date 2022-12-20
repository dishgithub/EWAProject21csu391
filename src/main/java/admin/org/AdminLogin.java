package admin.org;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// set content type
		response.setContentType("text/html");

		// invoke getWriter() method
		PrintWriter out = response.getWriter();

		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		if (pass.equals("admin@123")) {
			out.write("You have successfully logged in !!!");
			out.write("<br />  <br />");
			out.write("<a href='ViewResume'>Click here to view the profiles of candidates</a>");

		} else {
			out.write("Incorrect credentials !!!!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
