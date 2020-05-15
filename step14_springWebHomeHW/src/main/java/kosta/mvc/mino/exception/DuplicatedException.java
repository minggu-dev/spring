package kosta.mvc.mino.exception;

public class DuplicatedException extends Exception{
	public DuplicatedException() {
		super();
	}
	
	public DuplicatedException(String msg) {
		super(msg);
	}
}
