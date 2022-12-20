package candidate.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidateLogin
 */
public class CandidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidateLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String n = request.getParameter("username");
		String p = request.getParameter("password");

		// HTML
		// step1: set the content type:
		response.setContentType("text/html");

		// step2: invoke the getWriter() method:
		PrintWriter out = response.getWriter();

		// JDBC CODE******
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/candidate_db", "root",
					"admin@123");
			Statement stm = con.createStatement();
			String read = "select * from candidate_info";
			ResultSet res = stm.executeQuery(read);
			boolean flag = false;
			while (res.next()) {
				if (res.getString(1).equals(n) && res.getString(2).equals(p)) {

					out.write("<html> <body> <h3> " + n + "  You have successfully logged in!! </h3> </body> </html>");
					out.write("<br />");
					out.write("<a href='resume.jsp'>Click here to build resume</a>");
					out.write("<br /> <br />");
					out.write("<a href='EditProfile?id=" + n + "'>Click here to add/update/delete profile details</a>");

					flag = true;
					break;
				}

			}
			if (!flag) {
				out.println("<html> <body> <h3> invalid username or password!! </h3> </body> </html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
