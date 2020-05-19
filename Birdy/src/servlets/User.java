package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.util.JSON;

import services.Authentification;
import tools.JSONTools;

public class User extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1662029623929018509L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = (param==null)?null: param.substring(1).split("/");
		sep = (sep.length==1 || sep.length==2)?sep:null;
		String key = (sep!=null && sep.length==1)?sep[0]:(sep!=null && sep.length==2)?sep[1]:null;
		String id = (sep!=null && sep.length==2)?sep[0]:null;
		JSONObject retour = null;
		JSONObject resLog = null;
		
		if(sep!=null && (sep.length==1 || sep.length==2)) {
			try {
				resLog = Authentification.isLogged(id, key);
				if(resLog.getString("etat") == "log") {
					if(sep.length == 1) { 
						retour = services.User.getUserList();
					}else {
						if(sep.length == 2) {
							retour = services.User.getUser(id);
						}else {
							retour = JSONTools.serviceRefused("Probleme argument", -1);
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
		String id = req.getParameter("id");
		String key = req.getParameter("key");
		JSONObject retour;
		if (id == null) {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}else {
			try {
				if(Authentification.isLogged(id, key).getString("etat") == "log"){
					retour = services.User.deleteUser(id);
					//Fait par la BD
//					if (retour.getString("etat") == "reussi") {
//						retour = services.Authentification.logout(id, key);
//					}
				}else {
					retour = JSONTools.serviceRefused("Utilisateur déconnecté", -1);
				}
			} catch (JSONException e) {
				retour = JSONTools.serviceRefused("JSON Probleme", 100);
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=null, mdp=null, mail=null, nom=null, prenom=null, dateNaissance=null, temp=null;
		if((temp=req.getParameter("id")) !=null) id=temp;
		if((temp=req.getParameter("mdp")) !=null) mdp=temp;
		if((temp=req.getParameter("mail")) !=null) mail=temp;
		if((temp=req.getParameter("nom")) !=null) nom=temp;
		if((temp=req.getParameter("prenom")) !=null) prenom=temp;
		if((temp=req.getParameter("dateNaissance")) !=null) dateNaissance=temp;
		JSONObject retour = services.User.createUser(id, mdp, mail, nom, prenom, dateNaissance);
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
}
