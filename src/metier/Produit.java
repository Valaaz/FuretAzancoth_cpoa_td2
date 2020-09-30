package metier;

public class Produit {
	private int id;
	private String nom;
	private String description;
	private double tarif;
	private String visuel;
	private int idCateg;
	
	//Constructeur pour la methode delete de MySQLProduitDAO
	public Produit(int id) {
		super();
		this.id = id;
	}
		
	//Constructeur pour la methode create de MySQLProduitDAO
	public Produit(String nom, String description, double tarif, String visuel, int idCateg) {
		super();
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.idCateg = idCateg;
	}
	
	public Produit(int id, String nom, String description, double tarif, String visuel, int idCateg) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.idCateg = idCateg;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getTarif() {
		return tarif;
	}
	
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public String getVisuel() {
		return visuel;
	}
	
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	
	public int getIdCateg() {
		return idCateg;
	}
	
	public void setIdCateg(int idCateg) {
		this.idCateg = idCateg;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", description=" + description + ", tarif=" + tarif + ", visuel="
				+ visuel + ", idCateg=" + idCateg + "]";
	}
	
}
