package kosta.mvc.controller;

/**
 * 요청된 정보가 어떤 Controller를 실행해야 하는지 찾아서 리턴한다.
 * @author kosta
 *
 */
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	public Controller createController(String key) {
		Controller controller = null;
		if(key.equals("insert")) {
			controller = new InsertController();
		}else if(key.equals("select")) {
			controller = new SelectController();
		}else if(key.equals("delete")) {
			controller = new DeleteController();
		}
		return controller;	
	}
}
