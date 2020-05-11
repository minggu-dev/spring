package sample08;

public interface BookDAO {
	void save(EmailSender email, MessageSender message, BookDTO book1, BookDTO book2);
}
