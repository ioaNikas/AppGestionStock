package fr.appgestionstock.shared;

public class FournitureDto {

	private long id;
	private String nom;
	private int quantite;
	private double prix;
	private String fournisseur;
	private int seuilCritique;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public int getSeuilCritique() {
		return seuilCritique;
	}

	public void setSeuilCritique(int seuilCritique) {
		this.seuilCritique = seuilCritique;
	}

}
