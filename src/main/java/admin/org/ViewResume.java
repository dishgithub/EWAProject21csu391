package admin.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class ViewResume
 */
public class ViewResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewResume() {
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
		
		out.println("<h1>Resume Details</h1>");
		
		out.println("<a href='resume.jsp'>Click here to add the profile of a candidate</a>");
		
		out.println("<h3>Kindly select the profile and click on the delete button to delete the profile</h3>");
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
         
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume_db", "root", "admin@123");

    		Statement stmt = con.createStatement();
    		
    		String query = "select * from resume_information";
    		ResultSet rs = stmt.executeQuery(query);
    		out.print("<table border='1' width='100%'"); 
    		
    		out.print("<tr><th>Name</th>"
        			+ "<th>Gender</th>"
        			+ "<th>E-mail</th>"
        			+ "<th>Address</th>"
        			+ "<th>Date of Birth</th>"
        			+ "<th>Qualification</th>"
        			+ "<th>School Name</th>"
        			+ "<th>Percentage</th>"
        			+ "<th>Year Of Passing</th>"
        			+ "<th>College Name(Graduation)</th>"
        			+ "<th>Percentage</th>"
        			+ "<th>Grade</th>"
        			+ "<th>Year Of Passing</th>"
        			+ "<th>College Name(Post Graduation)</th>"
        			+ "<th>Percentage</th>"
        			+ "<th>Grade</th>"
        			+ "<th>Year Of Passing</th>"
        			+ "<th>Project Name</th>"
        			+ "<th>Programming Language</th>"
        			+ "<th>Technical Skills</th>"
        			+ "<th>Languages</th>"
        			+ "<th>Hobbies</th>"
        			
        		+ "</tr>");
    		
    		while(rs.next()) {
   			 out.print("<tr>"
   			 				+"<td>"+rs.getString(1)+"</td>"
   			 				+"<td>"+rs.getString(2)+"</td>"
   			 				+"<td>"+rs.getString(3)+"</td>"
   			 				+"<td>"+rs.getString(4)+"</td>"
   			 				+"<td>"+rs.getString(5)+"</td>"
   			 				+"<td>"+rs.getString(6)+"</td>"
   			 				+"<td>"+rs.getString(7)+"</td>"
   			 				+"<td>"+rs.getString(8)+"</td>"
   			 			    +"<td>"+rs.getString(9)+"</td>"
   			 			    +"<td>"+rs.getString(10)+"</td>"
   			 				+"<td>"+rs.getString(11)+"</td>"
   			 				+"<td>"+rs.getString(12)+"</td>"
   			 				+"<td>"+rs.getString(13)+"</td>"
   			 				+"<td>"+rs.getString(14)+"</td>"
   			 			    +"<td>"+rs.getString(15)+"</td>"
   			 			    +"<td>"+rs.getString(16)+"</td>"
   			 			    +"<td>"+rs.getString(17)+"</td>"
   			 			    +"<td>"+rs.getString(18)+"</td>"
   			 			    +"<td>"+rs.getString(19)+"</td>"
   			 			    +"<td>"+rs.getString(20)+"</td>"
   			 			    +"<td>"+rs.getString(21)+"</td>"
   			 			    +"<td>"+rs.getString(22)+"</td>"

+"<td><a href='DeleteProfile?id="+rs.getString(1)+"'>delete</a></td>"		   
   			 			+"</tr>");      	        
   		}

	}
		catch(ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
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
