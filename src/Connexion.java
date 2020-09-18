import java.sql.*;
import java.util.ArrayList;

public class Connexion {
	
	public static Connection creeConnexion() 
	{
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/azancoth1u_cpoaTD1?serverTimezone=Europe/Paris";
		String login = "azancoth1u_appli";
		String pwd = "31901886";
		
		Connection maConnexion = null;
		try { 
			maConnexion = DriverManager.getConnection(url, login, pwd);
			} catch (SQLException sqle) 
		{
			System.out.println("Erreur connexion " + sqle.getMessage());
		}
		return maConnexion;
		}
	
	
	//Cat�gorie
	public static void AjouterCategorie(int id, String titre, String visuel) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("INSERT INTO `Categorie`(`id_categorie`, `titre`, `visuel`) VALUES (" + id + "," + "'" + titre + "'" + "," + "'" + visuel + "'" + ")");
		} catch (SQLException sqle)
		{
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void SupprimerCategorie(int id) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM `Categorie` WHERE id_categorie=" + id);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}	
	}
	
	public static void ModifierCategorie(int idModif, int id, String titre, String visuel) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("UPDATE `Categorie` SET `id_categorie`=" + id + ",`titre`=" + "'" + titre + "'" + ",`visuel`=" + "'" + visuel + "'" + " WHERE id_categorie=" + idModif);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}	
	}
	
	public static void listeCategorie() {
		try {
			ArrayList<String> listeCateg = new ArrayList<String>();
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet rs = requete.executeQuery("SELECT titre FROM categorie");
			while (rs.next()) {
				  String titre = rs.getString("titre");
				  listeCateg.add(titre);
				}
			System.out.println(listeCateg);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
		
	}
	
	
	//Client
	public static void AjouterClient(int id, String nom, String prenom) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("INSERT INTO `Client` VALUES (" + id + "," + "'" + nom + "'" + "," + "'" + prenom + "'" + ", 'test', 'test', 0, 'test', 0, 'test', 'test'" + ")");
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void SupprimerClient(int id) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM `Client` WHERE id_client=" + id);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void ModifierClient(int idModif, int id, String nom, String prenom) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("UPDATE `Client` SET `id_client`=" + id + ",`nom`=" + "'" + nom + "'" + ",`prenom`=" + "'" + prenom + "'" + " WHERE id_client=" + idModif);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void listeClient() {
		try {
			ArrayList<String> listeClient = new ArrayList<String>();
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet rs = requete.executeQuery("SELECT nom, prenom FROM client");
			while (rs.next()) {
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  String cl = nom.concat(" " + prenom);		//Concatenation du nom et du pr�nom
				  listeClient.add(cl);
				}
			System.out.println(listeClient);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	
	//Produit
	public static void AjouterProduit(int id, String nom, String desc, double tarif, String visuel, int idCateg) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("INSERT INTO `Produit` VALUES (" + id + ",'" + nom + "'" + ", '" + desc + "'" + ", " + tarif + ", '" + visuel + "'" + ", " + idCateg + ")");
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void SupprimerProduit(int id) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM `Produit` WHERE id_produit=" + id);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void ModifierProduit(int idModif, int id, String nom, String desc, double tarif, String visuel, int idCateg) {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("UPDATE `Produit` SET `id_produit`=" + id + ",`nom`=" + "'" + nom + "'" + ",`description`=" + "'" + desc + "'"  + ",`tarif`=" + tarif + ",`visuel`=" + "'" + visuel + "'" + ",`id_categorie`=" + idCateg + " WHERE id_produit=" + idModif);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}
	
	public static void listeProduit() {
		try {
			ArrayList<String> listeProduit = new ArrayList<String>();
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet rs = requete.executeQuery("SELECT nom FROM produit");
			while (rs.next()) {
				  String prod = rs.getString("nom");
				  listeProduit.add(prod);
				}
			System.out.println(listeProduit);
		} catch(SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			System.out.println("Veuillez r�essayer ou quitter");
		}
	}

}
