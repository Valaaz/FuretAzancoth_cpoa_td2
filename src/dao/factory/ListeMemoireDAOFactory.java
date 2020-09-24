package dao.factory;

import dao.listememoire.ListeMemoireCategorieDAO;
import dao.vue.CategorieDAO;
import dao.vue.ClientDAO;
import dao.vue.CommandeDAO;
import dao.vue.LigneCommandeDAO;
import dao.vue.ProduitDAO;

public class ListeMemoireDAOFactory extends DAOFactory {
	
	@Override
	public CategorieDAO getCategorieDAO() {
		return ListeMemoireCategorieDAO.getInstance();
	}
	
	@Override
	public ClientDAO getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}
	
	@Override
	public ProduitDAO getProduitDAO() {
		return ListeMemoireProduitDAO.getInstance();
	}
	
	@Override
	public CommandeDAO getCommandeDAO() {
		return ListeMemoireCommandeDAO.getInstance();
	}
	
	@Override
	public LigneCommandeDAO getLigneCommandeDAO() {
		return ListeMemoireLigneCommandeDAO.getInstance();
	}
}