package tools;

public class UserTools {

	public static String createUsers(String id, String mdp, String mail, String nom, String prenom, String dateNaissance) {
		StringBuilder res = new StringBuilder();
		StringBuilder fin = new StringBuilder().append("('").append(id).append("','");
		fin.append(mdp).append("','").append(mail).append("'");
		res.append("Insert into Utilisateur(Identifiant, Password, Mail");
		if(nom!=null) { 
			res.append(", Nom"); 
			fin.append(",'").append(nom).append("'");
		}
		if(prenom!=null) { 
			res.append(", Prenom"); 
			fin.append(", '").append(prenom).append("'");
		}
		if(dateNaissance!=null) { 
			res.append(", DateNaissance"); 
			fin.append(", '").append(prenom).append("'");
		}res.append(") values ").append(fin.toString()).append(");");
		return res.toString();
	}
	
	public static String getUser(String id) {
		StringBuilder res = new StringBuilder();
		res.append("Select * From Utilisateur Where Utilisateur.identifiant='").append("id").append("';");
		return res.toString();
	}

	public static String getUsers() {
		StringBuilder res = new StringBuilder();
		res.append("Select * From Utilisateur;");
		return res.toString();
	}

	public static String deleteUser(String id) {
		StringBuilder res = new StringBuilder();
		res.append("Delete From Utilisateur Where Utilisateur.id='").append(id).append("';");
		return res.toString();
	}

}
