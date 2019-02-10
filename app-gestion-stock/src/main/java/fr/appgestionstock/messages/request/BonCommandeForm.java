package fr.appgestionstock.messages.request;

import java.util.Set;

public class BonCommandeForm {
	private Set<FournitureForm> listeFournitures;
	private String client;

	public Set<FournitureForm> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(Set<FournitureForm> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
