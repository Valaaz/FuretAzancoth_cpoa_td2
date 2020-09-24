package dao.vue;

import java.util.ArrayList;

import metier.Categorie;

public interface CategorieDAO {

	boolean create(Categorie objet);

	boolean update(Categorie objet);

	boolean delete(Categorie objet);

	Categorie getById(int id);

	ArrayList<Categorie> findAll();

}
