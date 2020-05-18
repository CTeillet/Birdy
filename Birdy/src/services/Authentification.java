package services;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import bd.InteractionBD;
import tools.AuthentificationTools;
import tools.JSONTools;

public class Authentification {
	
	public static JSONObject login(String login, String password) {
		if(login==null || password==null) 
			return JSONTools.serviceRefused("Wrong Arguments", 0);
		
		try {
			//Verifie que l'utilisateur existe
			String reqUT = AuthentificationTools.userExists(login);
			JSONObject resReqUt = InteractionBD.executeQuery(reqUT);
			boolean is_user = resReqUt.length()==1;
			
			if(!is_user) return (JSONTools.serviceRefused("Utilisateur inconnue",  -1));
			
			//Verifie que le password et l'utilisateur sont OK
			String reqPass = AuthentificationTools.passwordOfUser(login, password);
			JSONObject resReqPass = InteractionBD.executeQuery(reqPass);
			boolean password_ok = resReqPass.length()==1;
					
			if(!password_ok) return (JSONTools.serviceRefused("Mauvais Mot de passe", -1));
			
			//Genere la cle de l'utilisateur
			String key_user = AuthentificationTools.generateKey();
			
			JSONObject retour = new JSONObject();
			//Insere une nouvelle session dans la base de données
			String reqInsertSession = AuthentificationTools.insertSession(key_user, login);
			int resInsSess = InteractionBD.executeUpdate(reqInsertSession);
			
			retour.put("key", key_user);
			System.out.println(resInsSess);
			if(resInsSess==1) {
				return JSONTools.serviceAccepted("res", retour);
			}else {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}
		}catch(JSONException e) {
			return JSONTools.serviceRefused("JSON Problem" + e.getMessage(), 100);
		}catch(Exception e) {
			return ( JSONTools.serviceRefused("Problem ...",10000));
		}
	}
	
	public static JSONObject logout(String id, String key) {
		if(id==null || key==null) {
			return JSONTools.serviceRefused("Identifiant ou cle non defini", -1);
		}else {
			String req = AuthentificationTools.removeSession(id, key);
			int res = InteractionBD.executeUpdate(req);
			if (res == 0) {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}else {
				return JSONTools.serviceAccepted();
			}
		}
	}
	
	public static JSONObject isLogged(String id, String key) {
		if(id==null || key==null) {
			return JSONTools.serviceRefused("Identifiant ou cle non defini", -1);
		}else {
			String req = AuthentificationTools.userLogged(id, key);
			JSONObject res = InteractionBD.executeQuery(req);
			if(res.length()==1) {
				try {
					JSONObject ttReq = res.getJSONObject("0");
					String resH = (String) ttReq.get("Heure");
					Timestamp heure = Timestamp.valueOf(resH);
					long heureActu = System.currentTimeMillis();
					long diffEnMin = TimeUnit.MILLISECONDS.toMinutes(heureActu - heure.getTime());
					if(diffEnMin <= 30) {
						Timestamp currentDate = new Timestamp(System.currentTimeMillis());
						String reqUpTime = AuthentificationTools.updateTime(id, key, currentDate.toString());
						int resOfUpdate = InteractionBD.executeUpdate(reqUpTime);
						if (resOfUpdate == 0) {
							return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
						}else {
							return JSONTools.serviceAccepted();
						}
					}else {
						JSONObject resLogout = new JSONObject();
						resLogout.put("logout", logout(id, key));
						return JSONTools.serviceAccepted("res", resLogout);
					}
				}catch(JSONException e) {
						return JSONTools.serviceRefused("Probleme de JSON", 100);
				}
			}else {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}
		}
	}
}
