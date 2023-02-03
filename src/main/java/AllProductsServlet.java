import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/AllProductsServlet")
public class AllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				String action = request.getServletPath();
				try {
					switch (action) {
					
					
					
					default:
						listProduct(request, response);
						break;
					}
				} catch (SQLException ex) {
					throw new ServletException(ex);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private static final String SELECT_ALL_PRODUCTS = "select * from Producttable ";
	
	
	
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
	




	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		List <AllProduct> allproducts = new ArrayList <>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =
						connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				allproducts.add(new AllProduct(name, category, price, image));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		request.setAttribute("listProducts", allproducts);
		request.getRequestDispatcher("/allproducts.jsp").forward(request, response);
	}
	
	

	

	
}