package fr.appgestionstock.messages.request;

import java.util.List;

public class UserDetailsForm {

	private String username;
	private String email;
	private String password;
	private List<BonCommandeForm> commandes;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BonCommandeForm> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<BonCommandeForm> commandes) {
		this.commandes = commandes;
	}

}
