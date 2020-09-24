package dao.factory;

import dao.vue.*;

public class MySQLDAOFactory extends DAOFactory {
	
	@Override
	public CategorieDAO getCategorieDAO() {
		return MySQLCategorieDAO.getInstance();
	}
	
	@Override
	public ClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}
	
	@Override
	public ProduitDAO getProduitDAO() {
		return MySQLProduitDAO.getInstance();
	}
	
	@Override
	public CommandeDAO getCommandeDAO() {
		return MySQLCommandeDAO.getInstance();
	}
	
	@Override
	public LigneCommandeDAO getLigneCommandeDAO() {
		return MySQLLigneCommandeDAO.getInstance();
	}
}
