package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connexion.Connexion;
import dao.modele.ClientDAO;
import metier.Client;

public class MySQLClientDAO implements ClientDAO {

	private static MySQLClientDAO instance;
	
	private MySQLClientDAO() {}
	
	//V�rifie si il existe une instance sinon en cr�e une
	public static MySQLClientDAO getInstance() {
		if (instance==null) {
			instance = new MySQLClientDAO();
		}
		return instance;
	}

	public boolean create(Client object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `Client`(`nom`, `prenom`) VALUES(?, ?)");
		
		//Pas besoin de g�rer les id car cl� primaire
		requete.setString(1, object.getNom());
		requete.setString(2, object.getPrenom());
		
		nbLignes = requete.executeUpdate();
		
		return nbLignes==1;
	}

	public boolean update(Client object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("UPDATE `Client` SET nom=?, prenom=? WHERE id_client=" + object.getId());
		
		requete.setString(1, object.getNom());
		requete.setString(2, object.getPrenom());
		
		nbLignes = requete.executeUpdate();
		
		return nbLignes==1;
	}

	public boolean delete(Client object) throws SQLException {
		int nbLignes = 0;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Client where id_client=" + object.getId());
		
		nbLignes = requete.executeUpdate();
			
		return nbLignes==1;
	}

	public Client getById(int id) throws SQLException {
		Client client = null;
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Client where id_client=" + id);
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			client = new Client(res.getInt(1), res.getString(2), res.getString(3));
		}
		return client;
	}

	public ArrayList<Client> findAll() throws SQLException {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Client");
		ResultSet res = requete.executeQuery();
		if (res.next()) {
			listeClient.add(new Client(res.getInt(1), res.getString(2), res.getString(3)));
		}
		return listeClient;
	}

}
