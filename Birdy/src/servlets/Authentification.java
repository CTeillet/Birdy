package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import tools.JSONTools;

public class Authentification extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -676521283879010677L;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String key = req.getParameter("key");
		JSONObject retour = null;
		
		if(id != null && key != null) {
			retour = services.Authentification.logout(id, key);
		}else {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String mdp = req.getParameter("mdp");
		JSONObject retour = null;
		
		if(id != null && mdp != null) {
			retour = services.Authentification.login(id, mdp);
		}else {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
}
