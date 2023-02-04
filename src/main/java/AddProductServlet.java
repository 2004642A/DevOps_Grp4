

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("productname");
		String category = request.getParameter("category");
		Double price = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/userdetails", "root", "password");
			
			PreparedStatement ps = con.prepareStatement("insert into Producttable values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setString(4, image);
			int i = ps.executeUpdate();
			if (i > 0){
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully added a new product!" +
						"</h1>");
				writer.close();
			}
		}catch (Exception exception) {
			System.out.println(exception);
			out.close();
			}
			doGet(request, response);
		
		}
		
	}








