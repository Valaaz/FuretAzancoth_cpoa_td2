package dao.vue;

import java.util.ArrayList;

import metier.Produit;

public interface ProduitDAO {

	boolean create(Produit objet);

	boolean update(Produit objet);

	boolean delete(Produit objet);

	Produit getById(int id);

	ArrayList<Produit> findAll();
	
}
