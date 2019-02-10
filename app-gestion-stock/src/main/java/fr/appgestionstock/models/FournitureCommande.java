package fr.appgestionstock.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fournitures_commandes")
public class FournitureCommande {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bonCommande_id")
	private Fourniture fourniture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fourniture getFourniture() {
		return fourniture;
	}

	public void setFourniture(Fourniture fourniture) {
		this.fourniture = fourniture;
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
