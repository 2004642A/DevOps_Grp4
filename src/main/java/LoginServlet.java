import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/LoginServlet": loginUser(request, response);
			break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}  
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String LOGIN_USER_BY_NAME = "select * from UserDetail where name = ? and password = ?";

    protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

		private void loginUser (HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		List <Login> login = new ArrayList <>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =
						connection.prepareStatement(LOGIN_USER_BY_NAME );) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {            
				String name = request.getParameter("name");
            	String password = request.getParameter("password");
				preparedStatement.setString(1, name);
            	preparedStatement.setString(2, password);
				// String name = rs.getString("name");
				// String password = rs.getString("password");
				// login.add(new login(name, password));
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("loginUser", login);
		request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
	}
}


