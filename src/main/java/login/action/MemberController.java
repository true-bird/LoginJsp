package login.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private HashMap<String,Action> commandMap;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	public void init(ServletConfig config) throws ServletException {
		loadProperties("login/properties/login");
	}
	private void loadProperties(String filePath) {
		commandMap = new HashMap<String, Action>();
		ResourceBundle rb = ResourceBundle.getBundle(filePath);
		Enumeration<String> actionEnum = rb.getKeys();
		while(actionEnum.hasMoreElements()) {
			String command = actionEnum.nextElement();
			String className= rb.getString(command);
			try {
				Class actionClass = Class.forName(className);
				Action actionInstance = (Action)actionClass.newInstance();
				if(className.equals("login.action.FormChangeAction")) {
					FormChangeAction fc = (FormChangeAction)actionInstance;
					fc.setCommand(command);
				}
				commandMap.put(command,actionInstance);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 넘어온 커맨드 추출
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/")+1;
		String command = requestURI.substring(cmdIdx);
		
		// 처리 액션
		ActionForward forward = null;
		Action action = null;
		
		try {
			action = commandMap.get(command);
			if(action==null) return;
			forward = action.execute(request, response);
			
			// redirect와 forward 구분
			if(forward != null) {
				if(forward.isRedirect()) response.sendRedirect(forward.getNextPath());
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}	
}
