package metier;

import java.util.HashMap;

public class LigneCommande {
	private int idCommande;
	private Produit idProduit;
	private double tarifUnitaire;
	
	HashMap<Integer, Produit> listeCommande = new HashMap<Integer, Produit>();

	public LigneCommande(int idCommande, Produit idProduit, double tarifUnitaire, HashMap<Integer, Produit> listeCommande) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.tarifUnitaire = tarifUnitaire;
		this.listeCommande = listeCommande;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Produit getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Produit idProduit) {
		this.idProduit = idProduit;
	}

	public double getTarifUnitaire() {
		return tarifUnitaire;
	}

	public void setTarifUnitaire(double tarifUnitaire) {
		this.tarifUnitaire = tarifUnitaire;
	}

	public HashMap<Integer, Produit> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(HashMap<Integer, Produit> listeCommande) {
		this.listeCommande = listeCommande;
	}

	@Override
	public String toString() {
		return "LigneCommande [idCommande=" + idCommande + ", idProduit=" + idProduit + ", tarifUnitaire="
				+ tarifUnitaire + ", listeCommande=" + listeCommande + "]";
	}
	
	
	
}
