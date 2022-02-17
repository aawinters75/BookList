package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
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
		ListItemHelper dao = new ListItemHelper();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String ISBN = request.getParameter("ISBN");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		BookItem itemToUpdate = dao.searchForBookById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setAuthor(author);
		itemToUpdate.setISBN(ISBN);
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
