

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.BookItem;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a title: ");
			String title = in.nextLine();
			System.out.print("Enter an author: ");
			String author = in.nextLine();
			System.out.print("Enter a 10 digit ISBN: ");
			int ISBN = in.nextInt();
			
			BookItem toAdd = new BookItem(title, author, ISBN);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the title to delete: ");
			String title = in.nextLine();
			System.out.print("Enter the author to delete: ");
			String author = in.nextLine();
			System.out.print("Enter the ISBN to delete: ");
			int ISBN = in.nextInt();
			
			BookItem toDelete = new BookItem(title, author, ISBN);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Title");
			System.out.println("2 : Search by Author");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<BookItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the title: ");
				String title = in.nextLine();
				foundItems = lih.searchForBookByTitle(title);
				
			} else {
				System.out.print("Enter the author: ");
				String author = in.nextLine();
				foundItems = lih.searchForBookByAuthor(author);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (BookItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				BookItem toEdit = lih.searchForBookById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getAuthor());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Author");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New Author: ");
					String newAuthor = in.nextLine();
					toEdit.setAuthor(newAuthor);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("---Moldering Book Collection ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a book");
				System.out.println("*  2 -- Edit an entry");
				System.out.println("*  3 -- Delete an entry");
				System.out.println("*  4 -- View the book list");
				System.out.println("*  5 -- Exit the Digital Library");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<BookItem> allItems = lih.showAllItems();
			
			for(BookItem singleItem : allItems){
			System.out.println(singleItem.returnBookDetails());
			}

	}
}
