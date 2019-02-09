package fr.appgestionstock.messages.request;

import java.util.Set;

import fr.appgestionstock.models.Fourniture;

public class BonCommandeForm {
	private Set<Fourniture> listeFournitures;
	private String client;

	public Set<Fourniture> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(Set<Fourniture> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
