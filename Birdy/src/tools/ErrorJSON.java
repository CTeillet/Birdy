package tools;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;

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
	
	public static JSONObject serviceAccepted(String cle, JSONObject js) {
		try {	
			JSONObject res = new JSONObject().put("etat","reussi").put(cle, js);
			return res;
		} catch (JSONException e) {
			return null;
		}
	}
	
	public static JSONObject resulSet2JSON(ResultSet rs) throws SQLException, JSONException {
		JSONObject js = new JSONObject();
		ResultSetMetaData md = rs.getMetaData();
		int nbCol = md.getColumnCount();
		int i=0;
		while(rs.next()) {
			JSONObject tab = new JSONObject();
			for (int j = 0; j < nbCol; j++) {
				tab.put(md.getColumnLabel(j), rs.getString(j));
			}
			js.put(i+"", tab);
			i++;
		}
		return js;
	}

}
