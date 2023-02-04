import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "password");
		String name= request.getParameter("name");
        String password = request.getParameter("password");
		PreparedStatement ps = con.prepareStatement("select * from UserDetail where name = ? and password = ?");
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
            {
                RequestDispatcher dispatcher=request.getRequestDispatcher("ProfileServlet");
                dispatcher.forward(request, response);
            } else {
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