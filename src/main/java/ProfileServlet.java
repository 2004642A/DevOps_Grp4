import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		session.setAttribute("name", name);
		session.setAttribute("password", password);
		Connection conn = null;
		
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "password");
			 PreparedStatement ps = con.prepareStatement("select * from UserDetail where name = ? and password = ?");
			 ps.setString(1, name);
			 ps.setString(2, password);
			 ResultSet rs = ps.executeQuery();
			 
			 if (rs.next()) {
				    String name1 = rs.getString("name");
				    String password1 = rs.getString("password");
					String email = rs.getString("email");
					String contact = rs.getString("contact");
				    request.setAttribute("name", name1);
				    request.setAttribute("password", password1);
				    request.setAttribute("email", email);
				    request.setAttribute("contact", contact);
			 
				    request.getRequestDispatcher("profile.jsp").forward(request, response);
			 } else {
				 response.sendRedirect("loginUnsuccessful.jsp");
			 } 
		}	 catch (Exception exception) {
			  exception.printStackTrace();
		} finally {
		  try {
		    if (conn != null) {
		      conn.close();
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		}
	}
}

