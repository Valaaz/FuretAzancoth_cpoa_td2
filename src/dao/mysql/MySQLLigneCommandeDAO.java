package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connexion.Connexion;
import dao.modele.LigneCommandeDAO;
import metier.LigneCommande;

public class MySQLLigneCommandeDAO implements LigneCommandeDAO {

private static MySQLLigneCommandeDAO instance;
	
	private MySQLLigneCommandeDAO() {}
	
	//Vérifie si il existe une instance sinon en crée une
	public static MySQLLigneCommandeDAO getInstance() {
		if (instance==null) {
			instance = new MySQLLigneCommandeDAO();
		}
		return instance;
	}

	public boolean create(LigneCommande object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `LigneCommande`(`id_produit`, `quantite`, `tarif_unitaire`) VALUES(?, ?, ?)");
		
		//Pas besoin de gérer les id car clé primaire
		requete.setInt(1, object.getIdProduit());
		requete.setInt(2, object.getQuantite());
		requete.setDouble(3, object.getTarifUnitaire());
		
		return nbLignes==1;
	}

	public boolean update(LigneCommande object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("UPDATE `LigneCommande` SET id_produit=?, quantite=?, tarif_unitaire=? WHERE id_LigneCommande=" + object.getIdCommande());
		
		requete.setInt(1, object.getIdProduit());
		requete.setInt(2, object.getQuantite());
		requete.setDouble(3, object.getTarifUnitaire());
		
		return nbLignes==1;
	}

	public boolean delete(LigneCommande object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM LigneCommande where id_LigneCommande=" + object.getIdCommande());
		
		nbLignes = requete.executeUpdate();
			
		return nbLignes==1;
	}

	public LigneCommande getById(int id) throws SQLException {
		LigneCommande LigneCommande = null;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM LigneCommande where id_LigneCommande=" + id);
		requete.setInt(1, id);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			LigneCommande = new LigneCommande(res.getInt(1), res.getInt(2), res.getInt(3), res.getDouble(4));
		}
		return LigneCommande;
	}

	public ArrayList<LigneCommande> findAll() throws SQLException {
		ArrayList<LigneCommande> listeLigneCommande = new ArrayList<LigneCommande>();
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM LigneCommande");
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			listeLigneCommande.add(new LigneCommande(res.getInt(1), res.getInt(2), res.getInt(3), res.getDouble(4)));
		}
		return listeLigneCommande;
	}
	
}
