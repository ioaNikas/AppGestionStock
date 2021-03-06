package fr.appgestionstock.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -6740437739309187725L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 50)
	private String username;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false)
	private String encryptedPassword;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
	@JsonIgnore
	private List<BonCommande> commandes;

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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public List<BonCommande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<BonCommande> commandes) {
		this.commandes = commandes;
	}

	public void setBonCommande(BonCommande bonCommande) {
		this.commandes.add(bonCommande);
	}

}
