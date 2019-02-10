package fr.appgestionstock.messages.response;

import java.util.List;

import fr.appgestionstock.models.Fourniture;

public class BonCommandeRest {

	private String bonCommandeId;
	private List<Fourniture> listeFournitures;
	private String dateCreation;
	private String client;

	public String getBonCommandeId() {
		return bonCommandeId;
	}

	public void setBonCommandeId(String bonCommandeId) {
		this.bonCommandeId = bonCommandeId;
	}

	public List<Fourniture> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(List<Fourniture> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
