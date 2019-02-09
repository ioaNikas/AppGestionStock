package fr.appgestionstock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "bons_commande")
public class BonCommande {

	@Id
	@GeneratedValue
	private long id;

//	@ManyToOne
//	@JoinColumn(name = "id_site")
	private UserEntity site;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bonCommande")
	@JsonIgnore
	@Column
	private String listeFournitures;

	@Column(nullable = false)
	private String dateCreation;

	@Column(nullable = false, length = 80)
	private String client;

	public BonCommande() {
	}

	public BonCommande(UserEntity site, String dateCreation, String client) {
		super();
		this.site = site;
		this.listeFournitures = "test";
		this.dateCreation = dateCreation;
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getSite() {
		return site;
	}

	public void setSite(UserEntity site) {
		this.site = site;
	}

	public String getListeFournitures() {
		return listeFournitures;
	}

	public void setListeFournitures(String listeFournitures) {
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

	@Override
	public String toString() {
		return "BonCommande [id=" + id + ", site=" + site + ", listeFournitures=" + listeFournitures + ", dateCreation="
				+ dateCreation + ", client=" + client + "]";
	}

}
