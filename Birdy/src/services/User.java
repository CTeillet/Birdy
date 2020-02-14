package services;

import org.json.JSONObject;

import tools.UserTools;

public class User{
	
	public static JSONObject createUser(String id, String mdp, String mail, String nom, String prenom, String dateNaissance) {
		if(id==null) {
			return tools.ErrorJSON.serviceRefused("Identifiant non defini", -1);
		}
		if(mdp==null) {
			return tools.ErrorJSON.serviceRefused("Mot de passe  non defini", -1);
		}
		if(mail==null) {
			return tools.ErrorJSON.serviceRefused("Mail non defini", -1);
		}
		String req = tools.UserTools.createUsers(id, mdp, mail, nom, prenom, dateNaissance);
		if(bd.InteractionBD.executeUpdate(req)!=0) {
			return tools.ErrorJSON.serviceAccepted();
		}else {
			return tools.ErrorJSON.serviceRefused("Probleme de SQL", 1000);
		}
	}
	
	public static JSONObject getUser(String id) {
		if (id!=null) {
			String req = UserTools.getUser(id);
			bd.InteractionBD.executeQuery(req);
			return tools.ErrorJSON.serviceAccepted();
		}
		return tools.ErrorJSON.serviceRefused("Probleme de SQL", 1000);
	}
	
	public static JSONObject getUserList() {
		String req = UserTools.getUsers();
		bd.InteractionBD.executeQuery(req);
		return null;
	}
	
	public static JSONObject deleteUser(String id) {
		
		if (id!=null) {
			String req = UserTools.deleteUser(id);
			int res = bd.InteractionBD.executeUpdate(req);
			if(res!=0) {
				return tools.ErrorJSON.serviceAccepted();
			}
			
		}
		return tools.ErrorJSON.serviceRefused("Probleme de SQL", 1000);
	}
}