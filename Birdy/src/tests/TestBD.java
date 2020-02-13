package tests;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestBD {
	String url = "jdbc:localhost:Corentin_Teillet";
	String user = "root"; // login
	String password = "root"; // mot de passe
	Connection connexion = null;
	PrintStream out = System.out;
	
	public static void main(String in[]) {
	TestBD c = new TestBD();
	String sql = in[0];
	c.traiteRequete(sql);
	}
	public TestBD(){
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			gestionDesErreurs(e);
		}
	}
	
	public void traiteRequete(String requete) {
		out.println(requete);
		try {
			connexion = DriverManager.getConnection(url, user, password);
			Statement lecture = connexion.createStatement();
			ResultSet curseur = lecture.executeQuery(requete);
			ResultSetMetaData infoResultat = curseur.getMetaData();
			int nbChamp =infoResultat.getColumnCount();
			out.println("le resultat de la requete est:");
			String entete = "";
			for(int i=1; i<= nbChamp; i++) {
				String nomChamp = infoResultat.getColumnName(i);
				entete = entete + nomChamp + "\t";
			}
			out.println(entete);
			out.println("-----------------------------");
			/* affichage des tuples */
			while (curseur.next()) {
				String tuple = "";
				for(int i=1; i<= nbChamp; i++) {
					String valeurChamp = curseur.getString(i);
					tuple = tuple + valeurChamp + "\t";
				}
				out.println(tuple);
			}
			curseur.close();
			lecture.close();
			connexion.close();
		}catch(Exception e) {
			gestionDesErreurs(e);
		}
	} /* fin traiteRequete */
	
	protected void gestionDesErreurs(Exception e) {
		out.println("Exception: " + e);
		e.printStackTrace();
		try {
		if (connexion != null)
		connexion.close();
		}catch(Exception se) {
		out.println("Tout autre probleme: " + se);
		} throw new RuntimeException("Arret immediat");
		}


}
