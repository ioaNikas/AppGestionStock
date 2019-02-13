package fr.appgestionstock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournitures_commandes")
public class FournitureCommande {

	@Id
	@GeneratedValue
	private Long id;

	private int quantite;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FournitureCommande))
			return false;
		return id != null && id.equals(((FournitureCommande) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
