import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "password");
		String n= request.getParameter("name");
        String p = request.getParameter("password");
		PreparedStatement ps = con.prepareStatement("select * from UserDetail where name = ? and password = ?");
		ps.setString(1, n);
		ps.setString(2, p);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
            {
                RequestDispatcher rd=request.getRequestDispatcher("loginsuccess.jsp");
                rd.forward(request, response);
            } else {
//            	System.out.println("<font color=red size=18> Login failed!<br>");
//            	System.out.println("<a/href=login.jsp>Try again!</a>");
            	RequestDispatcher rd=request.getRequestDispatcher("loginunsuccessful.jsp");
                rd.forward(request, response);
            }
		}
		catch (Exception exception) {
		System.out.println(exception);
		System.out.close();
		}
		doGet(request, response);
	}	
}	

