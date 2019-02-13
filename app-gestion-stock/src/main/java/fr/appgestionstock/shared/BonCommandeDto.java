package fr.appgestionstock.shared;

import java.util.List;

import fr.appgestionstock.models.FournitureCommande;

public class BonCommandeDto {

	private long id;
	private String bonCommandeId;
	private List<FournitureCommande> listeFournitures;
	private String dateCreation;
	private String auteur;
	private UserDto userDetails;

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

	public List<FournitureCommande> getListeFournitures() {
		return listeFournitures;
	}

	public void setListFournitures(List<FournitureCommande> listeFournitures) {
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

	public UserDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}

}
