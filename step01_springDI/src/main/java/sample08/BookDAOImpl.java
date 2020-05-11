package sample08;

public class BookDAOImpl implements BookDAO {
	private DbUtil dbUtil;
	
	public BookDAOImpl() {
	}
	
	
	public BookDAOImpl(DbUtil dbUtil) {
		this.dbUtil = dbUtil;
	}


	@Override
	public void save(EmailSender email, MessageSender message, BookDTO book1, BookDTO book2) {
		System.out.println("emailSender = " + email);
		System.out.println("messageSender = " + message);
		System.out.println("book1 = " + book1);
		System.out.println("book2 = " + book2);
		System.out.println("dbUtil = " + dbUtil);
	}

}
