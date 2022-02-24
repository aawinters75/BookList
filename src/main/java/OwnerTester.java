import java.util.List;

import controller.OwnerHelper;
import model.Owner;

/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */


public class OwnerTester {
	
	public static void main(String[] args) {
		Owner aaron = new Owner("Aaron");
		Owner miranda = new Owner("Miranda");
		OwnerHelper sh = new OwnerHelper();
		sh.insertOwner(aaron);
		sh.insertOwner(miranda);
		List<Owner> allOwners = sh.showAllOwners();
		
		for(Owner a: allOwners) {
			System.out.println(a.toString());
			}
		}

}
