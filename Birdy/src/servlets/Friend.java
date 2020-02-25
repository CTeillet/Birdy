package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Friend extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3819762547129870065L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = param.split("/");
		JSONObject retour = null;
		if(sep.length == 1) { 
			retour = services.Friend.getFriendList(sep[0]);
		}else {
			if(sep.length == 2) {
				retour = services.Friend.getFriend(sep[0], sep[1]);
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = param.split("/");
		JSONObject retour = null;
		if(sep.length == 1) { 
			retour = services.Friend.removeAllFriend(sep[0]);
		}else {
			if(sep.length == 2) {
				retour = services.Friend.removeFriend(sep[0], sep[1]);
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = param.split("/");
		JSONObject retour = null;
		if(sep.length == 2) { 
			retour = services.Friend.addFriend(sep[0], sep[1]);
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
}
