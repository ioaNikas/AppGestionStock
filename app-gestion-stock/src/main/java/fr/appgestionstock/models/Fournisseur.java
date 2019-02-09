package fr.appgestionstock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "fournisseurs")
public class Fournisseur {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 50)
	private String raisonSociale;

	@Column(nullable = false, length = 50)
	private String adresse;

	@Column(length = 10)
	private String tel;

	@Column(nullable = false, length = 70)
	private String email;

	public Fournisseur() {
	}

	public Fournisseur(String raisonSociale, String adresse, String tel, String email) {
		super();
		this.raisonSociale = raisonSociale;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", raisonSociale=" + raisonSociale + ", adresse=" + adresse + ", tel=" + tel
				+ ", mail=" + email + "]";
	}

}
