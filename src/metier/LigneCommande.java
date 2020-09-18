package metier;

import java.util.HashMap;

public class LigneCommande {
	private int idCommande;
	private Produit idProduit;
	private double tarifUnitaire;

	public LigneCommande(int idCommande, Produit idProduit, double tarifUnitaire) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.tarifUnitaire = tarifUnitaire;
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

	@Override
	public String toString() {
		return "LigneCommande [idCommande=" + idCommande + ", idProduit=" + idProduit + ", tarifUnitaire="
				+ tarifUnitaire + "]";
	}
	
	
	
}
