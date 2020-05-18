package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import tools.JSONTools;

public class Authentification extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -676521283879010677L;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = param.split("/");
		JSONObject retour = null;
		
		if(sep.length == 2) {
			retour = services.Authentification.logout(sep[0], sep[1]);
		}else {
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
