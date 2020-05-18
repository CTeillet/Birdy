package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import tools.JSONTools;

public class Friend extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3819762547129870065L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep;
		if(param==null) {
			sep = null;
		}else {
			sep = param.split("/");
		}
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
		String id1 = req.getParameter("id1");
		String id2 = req.getParameter("id2");
		JSONObject retour = null;
		if(id1 == null) { 
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}else {
			if(id2!=null) {
				retour = services.Friend.removeFriend(id1,id2);
			}else {
				retour = services.Friend.removeAllFriend(id1);
			}	
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 = req.getParameter("id1");
		String id2 = req.getParameter("id2");
		JSONObject retour = null;
		if(id1 != null && id2 != null) { 
			retour = services.Friend.addFriend(id1, id2);
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
}
