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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    		// TODO Auto-generated method stub
    		ListItemHelper lih = new ListItemHelper();
    		String listName = request.getParameter("listName");
    		System.out.println("List Name: "+ listName);
    		
    		String ownerName = request.getParameter("ownerName");
    		
    		String[] selectedItems = request.getParameterValues("allItemsToAdd");
    		List<BookItem> selectedItemsInList = new ArrayList<BookItem>();
    		//make sure something was selected – otherwise we get a null pointer exception
    		
    		if (selectedItems != null && selectedItems.length > 0){
    			
    			for(int i = 0; i<selectedItems.length; i++) {
    					System.out.println(selectedItems[i]);
    					BookItem c = lih.searchForBookById(Integer.parseInt(selectedItems[i]));
    					selectedItemsInList.add(c);
    				}
    		}
    		
    		Owner shopper = new Owner(ownerName);
    		ListDetails sld = new ListDetails(listName, shopper);
    		
    		sld.setListOfItems(selectedItemsInList);
    		ListDetailsHelper slh = new ListDetailsHelper();
    		slh.insertNewListDetails(sld);
    		System.out.println("Success!");
    		System.out.println(sld.toString());
    		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
