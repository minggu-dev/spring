package sample03;

public class BookDAOImpl implements BookDAO {
	public BookDAOImpl() {
		
	}
	@Override
	public void insert(BookVo book) {
		System.out.println("BookDAOImpl insert 호출됨!!");
		System.out.println("과목 : " + book.getSubject());
		System.out.println("작성자 : " + book.getWriter());
		System.out.println("가격 : " + book.getPrice());
		System.out.println("날짜 : " + book.getDate());
	}

}
