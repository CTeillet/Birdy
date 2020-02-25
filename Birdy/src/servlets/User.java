package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import tools.JSONTools;

public class User extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1662029623929018509L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep;
		if(param==null) {
			sep = null;
		}else {
			sep = param.split("/");
		}
		
		JSONObject retour = null;
		if(sep.length == 0 || sep==null) { 
			retour = services.User.getUserList();
		}else {
			if(sep.length == 2) {
				retour = services.User.getUser(sep[1]);
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().print(retour);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] sep = param.split("/");
		JSONObject retour = null;
		if(sep.length == 0 || sep==null) { 
			retour = JSONTools.serviceRefused("Pas d'argument", -1);
		}else {
			if(sep.length == 2) {
				retour = services.User.deleteUser(sep[1]);
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
