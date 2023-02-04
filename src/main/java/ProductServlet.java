

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
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
					case "/ProductServlet/delete": deleteProduct(request, response);
					break;
					case "/ProductServlet/edit": showProductForm(request, response);
					break;
					case "/ProductServlet/update": updateProduct(request, response);
					break;
					case "/ProductServlet/insert": insertProduct(request, response);
					break;
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
	private static final String INSERT_USERS_SQL = "insert into Producttable values(?,?,?,?)";
	private static final String SELECT_USER_BY_ID = "select name,category,price,image from Producttable where name =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from Producttable ";
	private static final String DELETE_USERS_SQL = "delete from Producttable where name = ?;";
	private static final String UPDATE_USERS_SQL = "update Producttable set name = ?,category= ?, price =?,image =? where name = ?;";
	
	
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
	
	
	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("productname");
		String category = request.getParameter("category");
		Double price = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");



		try (Connection connection = getConnection(); 
				PreparedStatement statement =
						connection.prepareStatement(INSERT_USERS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, category);
			statement.setDouble(3, price);
			statement.setString(4, image);
			int i = statement.executeUpdate();

			if (i > 0){
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully added a new product!" +
						"</h1>");
				writer.close();
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
				response.sendRedirect("http://localhost:8090/DevOps_eCommerce/ProductServlet");
	}




	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		List <Product> products = new ArrayList <>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =
						connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				products.add(new Product(name, category, price, image));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		request.setAttribute("listProducts", products);
		request.getRequestDispatcher("/productManagement.jsp").forward(request, response);
	}
	
	
	

	private void showProductForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		String name = request.getParameter("name");
		Product existingProduct = new Product("", "", null, "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =
						connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				existingProduct = new Product(name, category, price, image);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("product", existingProduct);
		request.getRequestDispatcher("/editProductForm.jsp").forward(request, response);
	}
	
	

	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String oriName = request.getParameter("oriName");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		Double price = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, category);
			statement.setDouble(3, price);
			statement.setString(4, image);
			statement.setString(5, oriName);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/DevOps_eCommerce/ProductServlet");
	}

	
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/DevOps_eCommerce/ProductServlet");
	}	
}






	






