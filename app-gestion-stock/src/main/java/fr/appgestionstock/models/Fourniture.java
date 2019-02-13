package fr.appgestionstock.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "fournitures")
public class Fourniture {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 50)
	private String nom;

	@Column(nullable = false)
	private int quantite;

	@Column
	private double prix;

	@Column(length = 70)
	private String fournisseur;

	@Column
	private int seuilCritique;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "listeFournitures")
	@JsonIgnore
	private List<BonCommande> commandes;

	public Fourniture() {
	}

	public Fourniture(String nom, int quantite, double prix, String fournisseur, int seuilCritique) {
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.fournisseur = fournisseur;
		this.seuilCritique = seuilCritique;
	}

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

	@Override
	public String toString() {
		return "Fourniture [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + ", fournisseur="
				+ fournisseur + ", seuilCritique=" + seuilCritique + "]";
	}

}
