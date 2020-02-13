package services;

import org.json.JSONObject;

public class User{
	
	public static JSONObject createUser(String id, String mdp, String mail, String nom, String prenom, String dateNaissance) {
		if(id==null) {
			return tools.ErrorJSON.serviceRefused("Identifiant non défini", -1);
		}
		if(mdp==null) {
			return tools.ErrorJSON.serviceRefused("Mot de passe  non défini", -1);
		}
		if(mail==null) {
			return tools.ErrorJSON.serviceRefused("Mail non défini", -1);
		}
		if(bd.InteractionBD.createUser(id, mdp, mail, dateNaissance, dateNaissance, dateNaissance)) {
			return tools.ErrorJSON.serviceAccepted();
		}else {
			return tools.ErrorJSON.serviceRefused("Probleme de SQL", 1000);
		}
	}
	
	public static JSONObject getUser(String id) {
		
		return null;
	}
	
	public static JSONObject getUserList() {
		
		return null;
	}
	
	public static JSONObject deleteUser(String id) {
		
		return null;
	}
}