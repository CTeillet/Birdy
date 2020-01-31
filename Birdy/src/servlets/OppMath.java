package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Operation;

public class OppMath extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			double a = Double.parseDouble(req.getParameter("a"));
			double b = Double.parseDouble(req.getParameter("b"));
			String operation = req.getParameter("operation");
			Operation o = new Operation();
			double res = o.calcul(a, b, operation);
			
			resp.setContentType("plain/text");
			PrintWriter out = resp.getWriter();
			out.println("Le résultat de "+ operation+ " de " + a + " et " + b + " = " + res);
			
		}catch(NumberFormatException | NullPointerException e) {
			resp.setContentType("plain/text");
			PrintWriter out = resp.getWriter();
			out.println("");
		}
		
	}
}
