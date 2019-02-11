package fr.appgestionstock.messages.request;

import java.util.List;

public class BonCommandeForm {
	private List<FournitureForm> listeFournitures;
	private String auteur;

	public List<FournitureForm> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(List<FournitureForm> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
