package org.tojo.orders.controllers.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tojo.orders.models.Product;
import org.tojo.orders.services.Database;

/**
 * Servlet implementation class EditController
 */
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
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
		int id = (request.getParameter("id") != null? Integer.parseInt(request.getParameter("id")):0);
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float price = (request.getParameter("price") != null? Float.parseFloat(request.getParameter("price")):0);
		
		Product product = new Product(id, title, description, price);
		
		//save to database
				for (int i = 0; i < Database.PRODUCTS.size(); i++) {
					if (Database.PRODUCTS.get(i).getId().equals(id)) {
						Database.PRODUCTS.get(i).setId(id);
						Database.PRODUCTS.get(i).setDescription(description);
						Database.PRODUCTS.get(i).setPrice(price);
						Database.PRODUCTS.get(i).setTitle(title);
						break;
					}
				}
				response.sendRedirect(request.getContextPath() + "/products/IndexController");
	}

}
