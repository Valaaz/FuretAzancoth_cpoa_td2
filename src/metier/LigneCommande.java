package metier;

public class LigneCommande {
	private int idCommande;
	private int idProduit;
	private int quantite;
	private double tarifUnitaire;

	public LigneCommande(int idCommande, int idProduit, int quantite, double tarifUnitaire) {
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

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
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
