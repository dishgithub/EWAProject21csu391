package candidate.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResumeBuild
 */
public class ResumeBuild extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResumeBuild() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// Personal Information
		String name = request.getParameter("Name");
		String gender = request.getParameter("gender");
		String mail = request.getParameter("email");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");

		// Educational Information

		// Retrieve the value of the query parameter "qualification" (from check boxes).
		// Multiple entries possible.
		// Use getParameterValues() which returns an array of String.

		String q[] = request.getParameterValues("qualification");
		String qualification = " ";
		for (int i = 0; i < q.length; i++) {
			qualification = qualification + q[i];
		}

		// Secondary School Information
		String schoolname = request.getParameter("schoolname");
		String percentage = request.getParameter("percentage");
		String yearofpassing = request.getParameter("yearofpassing");

		// Graduation Information
		String collegename = request.getParameter("collegename");
		String percent = request.getParameter("percent");
		String grade = request.getParameter("grade");
		String yearpassing = request.getParameter("yearpassing");

		// Post Graduation Information
		String universityname = request.getParameter("universityname");
		String percentages = request.getParameter("percentages");
		String grades = request.getParameter("grades");
		String passingyear = request.getParameter("passingyear");

		// Projects Made
		String projectname = request.getParameter("NameOfProject");
		String programminglanguage = request.getParameter("ProgrammingLanguage");

		// Other Information
		String skills = request.getParameter("skill");
		String lang[] = request.getParameterValues("language");
		String languages = " ";
		for (int i = 0; i < lang.length; i++) {
			languages = languages + lang[i];
		}
		String hobbies = request.getParameter("hobby");

		// *********HTML******

		// step1: set the content type:
		response.setContentType("text/html");

		// step2: invoke the getWriter() method:
		PrintWriter out = response.getWriter();

		out.write("<html> <body> <h3> Your resume has been successfully built !!! </h3> </body> </html>");
		out.close();

		// **********JDBC CODE******

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume_db", "root", "admin@123");

			String insert_query = "insert into resume_information values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			// send the query
			PreparedStatement pstmt = con.prepareStatement(insert_query);

			// set the values
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, mail);
			pstmt.setString(4, address);
			pstmt.setString(5, dob);
			pstmt.setString(6, qualification);
			pstmt.setString(7, schoolname);
			pstmt.setString(8, percentage);
			pstmt.setString(9, yearofpassing);
			pstmt.setString(10, collegename);
			pstmt.setString(11, percent);
			pstmt.setString(12, grade);
			pstmt.setString(13, yearpassing);
			pstmt.setString(14, universityname);
			pstmt.setString(15, percentages);
			pstmt.setString(16, grades);
			pstmt.setString(17, passingyear);
			pstmt.setString(18, projectname);
			pstmt.setString(19, programminglanguage);
			pstmt.setString(20, skills);
			pstmt.setString(21, languages);
			pstmt.setString(22, hobbies);

			// execute query
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
