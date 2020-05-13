package kosta.mvc.controller;

public class ModelAndView {
	private String viewName;
	private boolean isRedirect;	//true이면 redirect방식, false이면 forward방식
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
