package dao;

import java.util.ArrayList;

import metier.Client;

public interface ClientDAO {
	
	boolean create(Client objet);

	boolean update(Client objet);

	boolean delete(Client objet);

	Client getById(int id);

	ArrayList<Client> findAll();

}
