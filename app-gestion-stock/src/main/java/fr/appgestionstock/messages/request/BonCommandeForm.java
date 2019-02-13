package fr.appgestionstock.messages.request;

import java.util.List;

import fr.appgestionstock.models.FournitureCommande;

public class BonCommandeForm {
	private List<FournitureCommande> listeFournitures;
	private String auteur;

	public List<FournitureCommande> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(List<FournitureCommande> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
