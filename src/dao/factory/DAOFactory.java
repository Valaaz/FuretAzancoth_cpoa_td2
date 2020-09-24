package dao.factory;

import dao.Persistance;
import dao.vue.*;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		
		DAOFactory daoF = null;
		switch (cible) {
		case MYSQL:
			daoF = new MySQLDAOFactory();
			break;
		case ListeMemoire:
			daoF = new ListeMemoireDAOFactory();
			break;
		}
		return daoF;
	}
	
	public abstract CategorieDAO getCategorieDAO();
	public abstract ClientDAO getClientDAO();
	public abstract ProduitDAO getProduitDAO();
	public abstract CommandeDAO getCommandeDAO();
	public abstract LigneCommandeDAO getLigneCommande();

}
