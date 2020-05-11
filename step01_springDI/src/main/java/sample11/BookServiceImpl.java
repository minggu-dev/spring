package sample11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDAO bookDao;
	
	@Autowired
	private EmailSender email;
	
	@Autowired
	private MessageSender message;
	
	@Override
	public void save(BookDTO book1, BookDTO book2) {
		bookDao.save(email, message, book1, book2);
	}

}
