package login.action;

import java.sql.Date;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.model.LoginDAO;
import login.model.LoginDTO;

public class SignupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8"); // 한글 처리
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto.setId(request.getParameter("userId"));
		dto.setName(request.getParameter("userName"));
		dto.setPassword(request.getParameter("userPassword"));
		dto.setGender((request.getParameter("gender").equals("male"))?1:0);
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(request.getParameter("year")),Integer.parseInt(request.getParameter("month"))-1,Integer.parseInt(request.getParameter("day")));
		dto.setBirth(new Date(cal.getTimeInMillis()));
		
		dao.signUp(dto);
		session.setAttribute("userId", dto.getId());
		session.setMaxInactiveInterval(10*60);
		forward.setRedirect(true);
		forward.setNextPath("Result.do");
		request.getSession().setAttribute("msg", "2");
		return forward;
	}
	
}
