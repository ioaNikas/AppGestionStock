package fr.appgestionstock.shared;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 817848179513888399L;
	private long id;
	private String userId;
	private String username;
	private String email;
	private String password;
	private String encryptedPassword;
	private List<BonCommandeDto> commandes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public List<BonCommandeDto> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<BonCommandeDto> commandes) {
		this.commandes = commandes;
	}

}
