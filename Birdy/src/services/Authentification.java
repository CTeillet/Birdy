package services;

import org.json.JSONException;
import org.json.JSONObject;

import bd.BDException;
import tools.AuthentificationTools;
import tools.ErrorJSON;

public class Authentification {
	
	public static JSONObject login(String login, String password) {
		if(login==null || password==null) 
			return ErrorJSON.serviceRefused("Wrong Arguments", 0);
		
		try {
			//Verifie que l'utilisateur existe sinon ERROR 1
			boolean is_user = AuthentificationTools.userExists(login);
			if(!is_user) return (ErrorJSON.serviceRefused("Utilisateur inconnue",  1));
			
			//Verifie que le password et l'utilisateur sont OK sinon ERROR 2
			boolean password_ok = AuthentificationTools.checkPassword(login, password);
			if(!password_ok) return (ErrorJSON.serviceRefused("Mauvais Mot de passe", 2));
			
			//Recupere l'id de l'utilisateur
			int id_user = AuthentificationTools.getIdUser(login);
			
			JSONObject retour = new JSONObject();
			//Insere une nouvelle session dans la base de données
			String key = AuthentificationTools.insertSession(id_user, false);
			retour .put("key", key);
			
		}catch(JSONException e) {
			return ErrorJSON.serviceRefused("JSON Problem" + e.getMessage(), 100);
		}catch(BDException e) {
			return ( ErrorJSON.serviceRefused("Problem while generating session key",1000)); 
		}catch(Exception e) {
			return ( ErrorJSON.serviceRefused("Problem ...",10000));
		}
		
		return null;
	}
	
public static JSONObject logout(String id, String mdp) {
		
		return null;
	}
}
