package fr.appgestionstock.messages.request;

import java.util.List;

public class BonCommandeForm {
	private List<FournitureForm> listeFournitures;
	private String client;

	public List<FournitureForm> getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(List<FournitureForm> listeFournitures) {
		this.listeFournitures = listeFournitures;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
