package candidate.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfile() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getQueryString();
		String ids[] = id.split("=");
		String selected_name = ids[1];

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume_db", "root", "admin@123");

			String query = "select * from resume_information where name = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, selected_name);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				out.print("<form action='UpdateProfile?id=" + selected_name + "' method='post'>");
				out.print("<table>");

				//out.print("<tr><td>User name:</td><td><input type='text' name='user name' value='" + selected_name
				//		+ "' disabled/></td></tr>");

				out.print("<tr><td>Name:</td><td><input type='text' name='Name' value='" + rs.getString(1)
						+ "'disabled/></td></tr>");
				out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='" + rs.getString(2)
						+ "'/></td></tr>");
				out.print("<tr><td>E-mail:</td><td><input type='text' name='email' value='" + rs.getString(3)
						+ "'/></td></tr>");
				out.print("<tr><td>Address:</td><td><input type='text' name='address' value='" + rs.getString(4)
						+ "'/></td></tr>");
				out.print("<tr><td>Date Of Birth:</td><td><input type='text' name='dob' value='" + rs.getString(5)
						+ "'/></td></tr>");
				out.print("<tr><td>Qualification:</td><td><input type='text' name='qualification' value='"
						+ rs.getString(6) + "'/></td></tr>");

				out.print("<tr><td>Name of School:</td><td><input type='text' name='schoolname' value='"
						+ rs.getString(7) + "'/></td></tr>");
				out.print("<tr><td>Percentage:</td><td><input type='text' name='percentage' value='" + rs.getString(8)
						+ "'/></td></tr>");
				out.print("<tr><td>Year Of Passing:</td><td><input type='text' name='yearofpassing' value='"
						+ rs.getString(9) + "'/></td></tr>");

				out.print("<tr><td>Name of University/college:</td><td><input type='text' name='college' value='"
						+ rs.getString(10) + "'/></td></tr>");
				out.print("<tr><td>Percentage:</td><td><input type='text' name='percent' value='" + rs.getString(11)
						+ "'/></td></tr>");
				out.print("<tr><td>Grade:</td><td><input type='text' name='grade' value='" + rs.getString(12)
						+ "'/></td></tr>");
				out.print("<tr><td>Year Of Passing:</td><td><input type='text' name='yearpassing' value='"
						+ rs.getString(13) + "'/></td></tr>");

				out.print("<tr><td>Name of College/University:</td><td><input type='text' name='universityname' value='"
						+ rs.getString(14) + "'/></td></tr>");
				out.print("<tr><td>Percentage:</td><td><input type='text' name='percentages' value='" + rs.getString(15)
						+ "'/></td></tr>");
				out.print("<tr><td>Grade:</td><td><input type='text' name='grades' value='" + rs.getString(16)
						+ "'/></td></tr>");
				out.print("<tr><td>Year Of Passing:</td><td><input type='text' name='passingyear' value='"
						+ rs.getString(17) + "'/></td></tr>");

				out.print("<tr><td>Name of Project:</td><td><input type='text' name='NameOfProject' value='"
						+ rs.getString(18) + "'/></td></tr>");
				out.print("<tr><td>Programming Language:</td><td><input type='text' name='ProgrammingLanguage' value='"
						+ rs.getString(19) + "'/></td></tr>");

				out.print("<tr><td>Technical Skills:</td><td><input type='text' name='skill' value='" + rs.getString(20)
						+ "'/></td></tr>");
				out.print("<tr><td> Languages known:</td><td><input type='text' name='language' value='"
						+ rs.getString(21) + "'/></td></tr>");
				out.print("<tr><td> Hobbies:</td><td><input type='text' name='hobby' value='" + rs.getString(22)
						+ "'/></td></tr>");

				out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
				out.print("</table>");
				out.print("</form>");
			}

		} catch (ClassNotFoundException | SQLException e) {
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
