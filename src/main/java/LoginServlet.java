import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
				//RequestDispatcher rd=request.getRequestDispatcher("loginsuccess.jsp");
                RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
                rd.forward(request, response);
                //listUser(request, response);
            } else {
            	RequestDispatcher rd=request.getRequestDispatcher("loginUnsucessful.jsp");
                rd.forward(request, response);
            }
		}
		catch (Exception exception) {
		System.out.println(exception);
		System.out.close();
		}
		doGet(request, response);
	}
	
//	private String jdbcURL = "jdbc:mysql://localhost:3306/userdetails";
//	private String jdbcUsername = "root";
//	private String jdbcPassword = "password";
//	private static final String SELECT_USER_BY_ID = "select name,password,email,contact from UserDetail where name =?";
//		protected Connection getConnection() {
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
//	
//	private void listUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException
//	{
//		List <Login> login = new ArrayList <>();
//		
//		try (Connection connection = getConnection();
//				PreparedStatement preparedStatement =
//						connection.prepareStatement(SELECT_USER_BY_ID);) {
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				String name = rs.getString("name");
//				String password = rs.getString("password");
//				String email = rs.getString("email");
//				String contact = rs.getString("contact");
//				login.add(new Login(name, password, email, contact));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		request.setAttribute("listUser", login);
//		request.getRequestDispatcher("/profile.jsp").forward(request, response);
//	}	

}	

