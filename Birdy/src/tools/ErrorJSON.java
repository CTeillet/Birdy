package tools;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorJSON {

	public static JSONObject serviceRefused(String message, int codeErreur) {
		try {	
			JSONObject res = new JSONObject().put("codeErreur", codeErreur).put("message", message);
			return res;
		} catch (JSONException e) {
			return null;
		}
		
	}
	
	public static JSONObject serviceAccepted() {
		try {	
			JSONObject res = new JSONObject().put("etat","reussi");
			return res;
		} catch (JSONException e) {
			return null;
		}
	}
	
	public static JSONObject serviceAccepted(String cle) {
		
		return null;
	}

}
