package login.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.model.LoginDAO;

public class DelFavAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글 처리
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		LoginDAO dao = LoginDAO.getInstance();
		String userId = (String) session.getAttribute("userId");
		String[] favorite = request.getParameterValues("favorite");
		System.out.println(favorite[0]);
		dao.delFav(userId, favorite);
		Set<String> imgPath = dao.getFav(userId);
		session.setAttribute("imgPath", imgPath);
		
		forward.setRedirect(true);
		forward.setNextPath("Favorites.do");
		return forward;
	}
}
