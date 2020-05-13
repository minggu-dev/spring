package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		Controller controller = HandlerMapping.getFactory().createController(key);

		ModelAndView mv = controller.handlerRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}
}
