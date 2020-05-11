package sample03;

public class BookController {
	private BookDAO bookDAO;
	private BookVo book;
	public BookController() {
		super();
	}
	public BookController(BookDAO bookDAO, BookVo book) {
		super();
		this.bookDAO = bookDAO;
		this.book = book;
	}
	public void bookInsert() {
		bookDAO.insert(book);
	}
}
