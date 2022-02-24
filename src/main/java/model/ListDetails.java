/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */
package model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<BookItem> listOfItems;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the shopper
	 */
	public Owner getOwner() {
		return owner;
	}
	/**
	 * @param shopper the shopper to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	/**
	 * @return the listOfItems
	 */
	public List<BookItem> getListOfItems() {
		return listOfItems;
	}
	/**
	 * @param listOfItems the listOfItems to set
	 */
	public void setListOfItems(List<BookItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName,Owner owner, List<BookItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		
		this.owner = owner;
		this.listOfItems = listOfItems;

	}
	public ListDetails(String listName,Owner owner, List<BookItem> listOfItems) {
			super();
			this.listName = listName;
			
			this.owner = owner;
			this.listOfItems = listOfItems; 
			}
	public ListDetails(String listName,Owner owner) {
			super();
			
			this.listName = listName;
			
			this.owner = owner;
			
			}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", owner=" + owner + ", listOfItems="
				+ listOfItems + "]";
	}
	
	
}
