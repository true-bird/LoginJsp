package login.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.model.LoginDAO;

public class CheckAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		LoginDAO dao = LoginDAO.getInstance();
		String userId = request.getParameter("userId");
		if(dao.find(userId)) out.print(1);
		else out.print(0);
		out.close();
		return null;
	}

}
