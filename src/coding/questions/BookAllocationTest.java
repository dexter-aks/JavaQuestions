package coding.questions;

import java.util.HashSet;

public class BookAllocationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BookAllocation implements Runnable{

	@Override
	public void run() {
		System.out.println("");
		
	}
	
}

class Book{
	private String bookId;
	private String bookName;
	private String authorName;
	private boolean isAvailable;
	
	public Book(String bookId, String bookName, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}

class Library{
	
	public void addBook(Book book,HashSet<Book> bookList) {
		if(book !=null) {
			book.setAvailable(true);
			bookList.add(book);
		}
	}
	
	public boolean isAvailable(Book book,HashSet<Book> bookList) {
		if(bookList.contains(book))
			return true;
		
		return false;
	}
	
	public synchronized Book loanBook(Book book,HashSet<Book> bookList) {
		if(isAvailable(book,bookList)) {
			book.setAvailable(false);
			bookList.remove(book);
			return book;
		}
		return null;
	}
}


