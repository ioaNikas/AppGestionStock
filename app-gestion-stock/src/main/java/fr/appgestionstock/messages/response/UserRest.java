package fr.appgestionstock.messages.response;

import java.util.List;

public class UserRest {

	private String userId;
	private String username;
	private String email;
	private List<BonCommandeRest> listeCommandes;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BonCommandeRest> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<BonCommandeRest> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

}
