package tools;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONTools {

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
	
	public static JSONObject serviceAccepted(String cle, int s) {
		try {	
			JSONObject res = new JSONObject().put("etat","reussi").put(cle, s);
			return res;
		} catch (JSONException e) {
			return null;
		}
	}
	
	public static JSONObject resulSet2JSON(ResultSet rs) throws SQLException, JSONException {
		JSONObject js = new JSONObject();
		ResultSetMetaData md = rs.getMetaData();
		int nbCol = md.getColumnCount();
		List<String> column = new ArrayList<>();
		for(int i=1; i<=nbCol; i++) {
			column.add(md.getColumnLabel(i));
		}
		int k=0;
		while(rs.next()) {
			JSONObject tab = new JSONObject();
			for (int j = 0; j < nbCol; j++) {
				tab.put(column.get(j), rs.getString(column.get(j)));
			}
			js.put(k+"", tab);
			k++;
		}
		return js;
	}
}
