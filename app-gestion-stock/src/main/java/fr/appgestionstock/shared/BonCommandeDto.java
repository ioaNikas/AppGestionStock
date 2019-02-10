package fr.appgestionstock.shared;

import java.util.List;

import fr.appgestionstock.models.Fourniture;

public class BonCommandeDto {

	private long id;
	private String bonCommandeId;
	private String site;
	private List<Fourniture> listFournitures;
	private String dateCreation;
	private String client;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Fourniture> getListFournitures() {
		return listFournitures;
	}

	public void setListFournitures(List<Fourniture> listFournitures) {
		this.listFournitures = listFournitures;
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

	public UserDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}

}
