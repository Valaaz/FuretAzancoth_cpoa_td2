package metier;
import java.time.*;
import java.util.HashMap;

public class Commande {
	private int idCommande;
	private int idClient;
	private LocalDate date;
	
	HashMap<Produit, LigneCommande> listeCommande = new HashMap<Produit, LigneCommande>();
	
	public Commande(int idCommande, LocalDate date, int idClient) {
		super();
		this.idCommande = idCommande;
		this.date = date;
		this.idClient = idClient;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public HashMap<Produit, LigneCommande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(HashMap<Produit, LigneCommande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", idClient=" + idClient + ", date=" + date + "]";
	}
	
	/*
	- conversion d'une date MySQL (java.sql.Date) vers LocalDate :
		maDateSQL.toLocalDate()

	- conversion d'une LocalDate en date MySQL
    	java.sql.Date.valueOf(maLocalDate)

    - saisie d'une date : sous forme de chaine, puis utilisation d'un formateur de date
    	DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    	LocalDate dateDebut = LocalDate.parse(maStringDate, formatage);

    - affichage d'une date LocalDate :
    	formatage.format(maLocalDate)
    */
	
}
