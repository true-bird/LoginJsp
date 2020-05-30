package login.action;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.model.LoginDAO;

public class FavoritesAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글 처리
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		LoginDAO dao = LoginDAO.getInstance();
		String userId = (String) session.getAttribute("userId");
		String[] player = request.getParameterValues("player");
		dao.addFav(userId, player);
		
		Set<String> imgPath = dao.getFav(userId);
		session.setAttribute("imgPath", imgPath);
		
		forward.setRedirect(true);
		forward.setNextPath("Favorites.do");
		return forward;
	}

}
