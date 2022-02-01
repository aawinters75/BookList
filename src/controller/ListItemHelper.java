/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Jan 31, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookItem;





public class ListItemHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookList");
	
	public void insertItem(BookItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BookItem>showAllItems(){
		EntityManager	em	=	emfactory.createEntityManager();
		List<BookItem> allItems	= em.createQuery("SELECT i FROM BookItem i").getResultList();
		return allItems;
		}
	
	public	void	deleteItem(BookItem	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<BookItem>typedQuery = em.createQuery("select	li from BookItem li	where li.title = :selectedTitle	and	li.author = :selectedAuthor", BookItem.class);
		
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedAuthor",	toDelete.getAuthor());
		
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		
		//get	the	result	and	save	it	into	a	new	list	item
		
		BookItem result	= typedQuery.getSingleResult();
		//remove	it
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	
	/**
	 * @param title
	 * @return
	 */
	public List<BookItem> searchForBookByTitle(String title) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<BookItem>typedQuery = em.createQuery("select li from BookItem li where li.title = :selectedTitle",BookItem.class);
		typedQuery.setParameter("selectedTitle", title);
		List<BookItem> foundItems =	typedQuery.getResultList();
		em.close();
		
		return	foundItems;
		
	}

	/**
	 * @param author
	 * @return
	 */
	public List<BookItem> searchForBookByAuthor(String author) {
		EntityManager	em	=	emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<BookItem>typedQuery = em.createQuery("select li from BookItem	li where li.author = :selectedAuthor",	BookItem.class);
		typedQuery.setParameter("selectedAuthor", author);
		List<BookItem>	foundItems	=	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public BookItem	searchForBookById(int idToEdit)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookItem found = em.find(BookItem.class, idToEdit);
		em.close();
		return	found;
	}
	
	public void	updateItem(BookItem	toEdit)	{
		EntityManager	em	=	emfactory.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void	cleanUp(){
		
		emfactory.close();
		}
}
