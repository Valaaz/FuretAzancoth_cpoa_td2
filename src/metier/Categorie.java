package metier;

public class Categorie {
	private int id;
	private String titre;
	private String visuel;
	
	public Categorie(int id, String titre, String visuel) {
		this.setId(id);
		this.setTitre(titre);
		this.setVisuel(visuel);
	}
	
	public int getId() { 
		return this.id; 
	}
	
	public void setId(int id) {
		this.id = id;
		}
	
	public String getTitre() {
		return this.titre;
	}
	
	public void setTitre(String titre) {
		if (titre==null || titre.trim().length()==0) {
			throw new IllegalArgumentException("Titre de la categorie vide !");
		}
		this.titre = titre;
	}
	
	public String getVisuel() {
		return this.visuel;
	}
	
	public void setVisuel(String visuel) {
		if (visuel==null || visuel.trim().length()==0) {
			throw new IllegalArgumentException("Visuel de la categorie vide !");
		}
		this.visuel = visuel;
	}
		
	public String toString() {
		return "(" + (this.id>=0?this.id:"iduveau") + ") " + this.titre + this.visuel;
	}
	
}
