package login.action;

import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.model.LoginDAO;
import login.model.LoginDTO;

public class LoginAction implements Action {
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글 처리
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String save = request.getParameter("save");
		// 쿠키
		if(save==null) {
			Cookie cookie = new Cookie("userId", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("userId", userId);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		}
		int result = dao.find(userId, userPassword);
		if(result==-1) {
			request.setAttribute("fail", "-1");
			forward.setRedirect(true);
			forward.setNextPath("Login.do");
		} else if(result==-2) {
			request.setAttribute("fail", "-2");
			forward.setRedirect(true);
			forward.setNextPath("Login.do");
		} else {
			Set<String> imgPath = dao.getFav(userId);
			session.setAttribute("userId", userId);
			session.setAttribute("imgPath", imgPath);
			session.setMaxInactiveInterval(10*60);
			forward.setRedirect(true);
			forward.setNextPath("Result.do");
			request.getSession().setAttribute("msg", "1");
		}
		return forward;
	}

}
