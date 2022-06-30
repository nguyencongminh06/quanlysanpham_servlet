package org.tojo.orders.controllers.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tojo.orders.models.Product;
import org.tojo.orders.services.Database;

/**
 * Servlet implementation class ActionController
 */
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Validate
		
		if (request.getParameter("id") != null) {
			int id = (request.getParameter("id") != null? Integer.parseInt(request.getParameter("id")):0);
			//delete
			if ("delete".equals(request.getParameter("action"))) {
					
				for (int i = Database.PRODUCTS.size() - 1; i >= 0 ; i--) {
					if (Database.PRODUCTS.get(i).getId().equals(id)) {
						Database.PRODUCTS.remove(i);
						break;
					}
				}
				
				response.sendRedirect(request.getContextPath() + "/products/IndexController");
				return;
			}else {
				Product product = new Product();
				
				for (Product item : Database.PRODUCTS) {
					if (item.getId().equals(id)) {
						product = item;
						break;
					}
				}
				
				request.setAttribute("product", product);
			}
		} 
		
			RequestDispatcher views = request.getRequestDispatcher("action.jsp");
			views.forward(request, response);
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
		
		//insert to database
		Database.PRODUCTS.add(product);
		
		response.sendRedirect(request.getContextPath() + "/products/IndexController");
		
	}
	
	@Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//Validate

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
    }
	
	@Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
