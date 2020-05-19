package services;

import org.json.JSONObject;

import bd.InteractionBD;
import tools.UserTools;

public class User{
	
	public static JSONObject createUser(String id, String mdp, String mail, String nom, String prenom, String dateNaissance) {
		if(id==null) {
			return tools.JSONTools.serviceRefused("Identifiant non defini", -1);
		}
		if(mdp==null) {
			return tools.JSONTools.serviceRefused("Mot de passe  non defini", -1);
		}
		if(mail==null) {
			return tools.JSONTools.serviceRefused("Mail non defini", -1);
		}
		String req = tools.UserTools.createUsers(id, mdp, mail, nom, prenom, dateNaissance);
		//System.out.println(req);
		if(bd.InteractionBD.executeUpdate(req)!=0) {
			return tools.JSONTools.serviceAccepted();
		}else {
			return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
		}
	}
	
	public static JSONObject getUser(String id) {
		if (id!=null) {
			String req = UserTools.getUser(id);
			JSONObject res = InteractionBD.executeQuery(req);
			if (res.length()==0) {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}else {
				return tools.JSONTools.serviceAccepted("res", res);
			}
			
		}
		return tools.JSONTools.serviceRefused("Pas d'identifiant", -1);
	}
	
	public static JSONObject getUserList() {
		String req = UserTools.getUsers();
		JSONObject res = InteractionBD.executeQuery(req);
		if (res.length()==0) {
			return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
		}else {
			return tools.JSONTools.serviceAccepted("res", res);
		}
	}
	
	public static JSONObject deleteUser(String id) {
		if (id!=null) {
			String req = UserTools.deleteUser(id);
			int res = InteractionBD.executeUpdate(req);
			if(res!=0) {
				return tools.JSONTools.serviceAccepted();
			}else {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}
			
		}
		return tools.JSONTools.serviceRefused("Pas d'identifiant", -1);
	}
}