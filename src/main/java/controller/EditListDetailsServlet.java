package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookItem;
import model.ListDetails;
import model.Owner;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			// TODO Auto-generated method stub
			ListDetailsHelper dao = new ListDetailsHelper();
			ListItemHelper lih = new ListItemHelper();
			OwnerHelper sh = new OwnerHelper();
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
			String newListName = request.getParameter("listName");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String ISBN = request.getParameter("ISBN");
			String ownerName = request.getParameter("ownerName");
			//find our add the new shopper
			Owner newOwner = sh.findOwner(ownerName);
			
			try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<BookItem> selectedItemsInList = new ArrayList<BookItem>();
				for (int i = 0; i < selectedItems.length; i++) {
					System.out.println(selectedItems[i]);
					BookItem c = lih.searchForBookById(Integer.parseInt(selectedItems[i]));
					selectedItemsInList.add(c);
					}
				listToUpdate.setListOfItems(selectedItemsInList);
			
		
				} 
			catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<BookItem> selectedItemsInList = new ArrayList<BookItem>();
			listToUpdate.setListOfItems(selectedItemsInList);
			}
			listToUpdate.setListName(newListName);
			
			listToUpdate.setOwner(newOwner);
			dao.updateList(listToUpdate);
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

}
