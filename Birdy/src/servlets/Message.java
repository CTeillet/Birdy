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

public class Message extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1998917404712743270L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = (param==null)?null: param.substring(1).split("/");
		System.out.printf("%d %s %s %s", sep.length, sep[0], sep[1], sep[2]);
		JSONObject retour = null;
		
		if((sep!=null) && (sep.length==3)){
			String type = sep[0];
			String key = sep[2];
			String arg = sep[1];
			try {
				if (Authentification.isLogged(null, key).getString("etat") == "log") {
					if(type.equals("author")) {
						retour = services.Message.getMessageFromAuthor(arg);
					}else {
						if(type.equals("word")) {
							retour = services.Message.getMessageWithWord(arg);
						}else {
							retour = JSONTools.serviceRefused("Mauvais argument", -1);
						}
					}
				}else {
					retour = JSONTools.serviceRefused("Utilisateur déconnecté", -1);
				}
			}catch(JSONException e) {
				retour = JSONTools.serviceRefused("JSON Probleme", 100);
			}
		}else {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idU = req.getParameter("idU");
		String idM = req.getParameter("idM");
		String key = req.getParameter("key");
		
		JSONObject retour = null;
		
		if(idU==null || key==null) {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}else {
			try {
				if (Authentification.isLogged(idU, key).getString("etat") == "log") {
					if (idM==null) {
						retour = services.Message.removeAllMessageAuthor(idU);
					}else {
						retour = services.Message.removeOneMessage(idU, idM);
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
		String id = req.getParameter("id");
		String msg = req.getParameter("msg");
		String key = req.getParameter("key");
		
		JSONObject retour = null;
		if(id==null || msg==null || key==null) {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}else {
			try {
				if (Authentification.isLogged(id, key).getString("etat") == "log") {
					retour = services.Message.createMessage(id, msg);
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
}
