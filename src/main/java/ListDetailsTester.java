import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.OwnerHelper;
import model.BookItem;
import model.ListDetails;
import model.Owner;

/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */

/**
 * @author winte
 *
 */
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Owner lillian = new Owner("Lillian");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails lillianList = new ListDetails("Lillian's List",  lillian);
		
		BookItem dune = new BookItem("Dune", "Herbert", "1");
		BookItem gardensOfTheMoon = new BookItem("Gardens of The Moon", "Erikson", "2");
		
		List<BookItem> lilliansItems = new ArrayList<BookItem>();
				lilliansItems.add(dune);
				lilliansItems.add(gardensOfTheMoon);
				ListDetails lilliansList = new ListDetails("Lillian's BookList", lillian);
				lilliansList.setListOfItems(lilliansItems);
				ldh.insertNewListDetails(lillianList);
				
				List<ListDetails> allLists = ldh.getLists();
				
		
				for (ListDetails a : allLists) {
					System.out.println(a.toString());
				}
		
	}

}
