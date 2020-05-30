package login.action;

public class ActionForward { // 페이지 이동 처리
	private boolean isRedirect = false;
	private String nextPath = null;
	
	// Redirect 사용여부, false이면 Forward 사용
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
	
}
