package fr.appgestionstock.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "bons_commande")
public class BonCommande implements Serializable {

	private static final long serialVersionUID = -5371090135364355834L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 30)
	private String bonCommandeId;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private UserEntity userDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bon_commande_id")
	private List<FournitureCommande> listeFournitures;

	@Column(nullable = false)
	private String dateCreation;

	@Column(nullable = false, length = 80)
	private String auteur;

	public BonCommande() {
	}

	public BonCommande(UserEntity userDetails, String bonCommandeId, List<FournitureCommande> listeFournitures,
			String dateCreation, String auteur) {
		this.userDetails = userDetails;
		this.bonCommandeId = bonCommandeId;
		this.listeFournitures = listeFournitures;
		this.dateCreation = dateCreation;
		this.auteur = auteur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBonCommandeId() {
		return bonCommandeId;
	}

	public void setBonCommandeId(String bonCommandeId) {
		this.bonCommandeId = bonCommandeId;
	}

	public UserEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

	public List<FournitureCommande> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(List<FournitureCommande> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
