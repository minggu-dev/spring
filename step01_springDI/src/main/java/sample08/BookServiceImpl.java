package sample08;

import sample08.BookDAO;

public class BookServiceImpl implements BookService {
	private MessageSender message;
	private EmailSender email;
	private BookDAO bookDao;
	
	

	public BookServiceImpl(BookDAO bookDao) {
		super();
		this.bookDao = bookDao;
	}


	public BookServiceImpl() {
		super();
	}

	
	public void setMessage(MessageSender message) {
		this.message = message;
	}


	public void setEmail(EmailSender email) {
		this.email = email;
	}


	@Override
	public void save(BookDTO book1, BookDTO book2) {
		bookDao.save(email, message, book1, book2);
		
	}

}
