package candidate.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Exception;

/**
 * Servlet implementation class CandidateRegister
 */
public class CandidateRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidateRegister() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String n = request.getParameter("username");
		String p = request.getParameter("password");

		// HTML
		// step1: set the content type:
		response.setContentType("text/html");

		// step2: invoke the getWriter() method:
		PrintWriter out = response.getWriter();

		out.write("<html> <body> <h3> " + n + "  You have successfully registered !!! </h3> </body> </html>");
		out.write("<br />");
		
		out.write("<a href='resume.jsp'>Click here to build resume</a>");
		//out.write("<br />");
		
		//out.write("<a href='EditProfile?id="+n+"'>Click here to add/update/delete profile details</a>");

		out.close();

		// JDBC CODE******
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/candidate_db", "root",
					"admin@123");

			String insert = "insert into candidate_info values(?,?)";
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setString(1, n);
			pstm.setString(2, p);

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
