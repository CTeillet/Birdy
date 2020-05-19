package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.Authentification;
import tools.JSONTools;

public class Friend extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3819762547129870065L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = (param==null)?null: param.substring(1).split("/");
		
		JSONObject log;
		if (sep!=null && sep.length == 2) {
			log = services.Authentification.isLogged(sep[0], sep[1]);
		}else {
			if(sep!=null && sep.length == 3) {
				log = services.Authentification.isLogged(sep[0], sep[2]);
			}else {
				resp.setContentType("application/json");
				resp.getWriter().print(tools.JSONTools.serviceRefused("Pas d'argument ", -1));
				return;
			}		
		}
		JSONObject retour = null;
		try {
			String res = log.getString("etat");
			if (res == "log") {
				if(sep.length == 2) {
					retour = services.Friend.getFriendList(sep[0]);
				}else {
					if(sep.length == 3) {
						retour = services.Friend.getFriend(sep[0], sep[1]);
					}else {
						retour = tools.JSONTools.serviceRefused("Pas d'argument", -1);
					}
				}
			}else {
				retour = tools.JSONTools.serviceRefused("Pas d'argument", -1);
			}
		}catch(JSONException e) {
			retour = tools.JSONTools.serviceRefused("Erreur JSON", 100);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 = req.getParameter("id1");
		String id2 = req.getParameter("id2");
		String key = req.getParameter("key");
		
		JSONObject retour = null;
		if(id1 == null) { 
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}else {
			try {
				if (Authentification.isLogged(id1, key).getString("etat") == "log") {
					
					if(id2!=null) {
						retour = services.Friend.removeFriend(id1,id2);
					}else {
						retour = services.Friend.removeAllFriend(id1);
					}	
					
				}else {
					retour = JSONTools.serviceRefused("Utilisateur déconnecté", -1);
				}
			}catch(JSONException e) {
				retour = JSONTools.serviceRefused("JSON Probleme", 100);
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 = req.getParameter("id1");
		String id2 = req.getParameter("id2");
		String key = req.getParameter("key");
		JSONObject retour = null;
		
		if(id1!=id2) {
			try {
				if (Authentification.isLogged(id1, key).getString("etat") == "log") {
					if(id1 != null && id2 != null) { 
						retour = services.Friend.addFriend(id1, id2);
					}else {
						retour = JSONTools.serviceRefused("Pas d'argument", -1);
					}
				}else {
					retour = JSONTools.serviceRefused("Utilisateur déconnecté", -1);
				}
				
			}catch(JSONException e) {
				retour = JSONTools.serviceRefused("JSON Probleme", 100);
			}
		}else {
			retour = JSONTools.serviceRefused("Argument Identique", -1);
		}
		
		
		
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
}
