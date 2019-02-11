package fr.appgestionstock.messages.response;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import fr.appgestionstock.models.FournitureCommande;

public class BonCommandeRest extends ResourceSupport {

	private String bonCommandeId;
	private List<FournitureCommande> listeFournitures;
	private String dateCreation;
	private String auteur;

	public String getBonCommandeId() {
		return bonCommandeId;
	}

	public void setBonCommandeId(String bonCommandeId) {
		this.bonCommandeId = bonCommandeId;
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
