package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connexion.Connexion;
import dao.modele.CommandeDAO;
import metier.Commande;

public class MySQLCommandeDAO implements CommandeDAO {

private static MySQLCommandeDAO instance;
	
	private MySQLCommandeDAO() {}
	
	//Vérifie si il existe une instance sinon en crée une
	public static MySQLCommandeDAO getInstance() {
		if (instance==null) {
			instance = new MySQLCommandeDAO();
		}
		return instance;
	}

	public boolean create(Commande object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `Commande`(`date_commande`, `id_client`) VALUES(?, ?)");
		
		//Pas besoin de gérer les id car clé primaire
		requete.setDate(1, java.sql.Date.valueOf(object.getDate()));
		requete.setInt(2, object.getIdClient());
		
		return nbLignes==1;
	}

	public boolean update(Commande object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("UPDATE `Commande` SET date_commande=?, id_client=? WHERE id_Commande=" + object.getIdCommande());
		
		requete.setDate(1, java.sql.Date.valueOf(object.getDate()));
		requete.setInt(2, object.getIdClient());
		
		return nbLignes==1;
	}

	public boolean delete(Commande object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Commande where id_commande=" + object.getIdCommande());
	
		nbLignes = requete.executeUpdate();
			
		return nbLignes==1;
	}

	public Commande getById(int id) throws SQLException {
		Commande Commande = null;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Commande where id_commande=" + id);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			Commande = new Commande(res.getInt(1), res.getDate(2).toLocalDate(), res.getInt(3));
		}
		return Commande;
	}

	public ArrayList<Commande> findAll() throws SQLException {
		ArrayList<Commande> listeCommande = new ArrayList<Commande>();
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Commande");
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			listeCommande.add(new Commande(res.getInt(1), res.getDate(2).toLocalDate(), res.getInt(3)));
		}
		return listeCommande;
	}
	
}
