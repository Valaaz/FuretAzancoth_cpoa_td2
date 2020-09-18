package metier;

public class Categorie {
	private int id;
	private String nom;
	private String visuel;
	
	public Categorie(int id, String nom, String visuel) {
		this.setId(id);
		this.setnom(nom);
		this.setVisuel(visuel);
	}
	
	public int getId() { 
		return this.id; 
	}
	
	public void setId(int id) {
		this.id = id;
		}
	
	public String getnom() {
		return this.nom;
	}
	
	public void setnom(String nom) {
		if (nom==null || nom.trim().length()==0) {
			throw new IllegalArgumentException("nom de la categorie vide !");
		}
		this.nom = nom;
	}
	
	public String getVisuel() {
		return this.visuel;
	}
	
	public void setVisuel(String visuel) {
		if (visuel==null || visuel.trim().length()==0) {
			throw new IllegalArgumentException("nom de la categorie vide !");
		}
		this.visuel = visuel;
	}
		
	public String toString() {
		return "(" + (this.id>=0?this.id:"iduveau") + ") " + this.nom + this.visuel;
	}
	
}
