package sample11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO{
	@Autowired
	private DbUtil dbUtil;
	
	@Override
	public void save(EmailSender email, MessageSender message, BookDTO book1, BookDTO book2) {
		System.out.println("emailSender = " + email);
		System.out.println("messageSender = " + message);
		System.out.println("book1 = " + book1);
		System.out.println("book2 = " + book2);
		System.out.println("dbUtil = " + dbUtil);
	}
}
