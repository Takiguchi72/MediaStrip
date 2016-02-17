package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the contact database table.
 * 
 */
@Embeddable
public class ContactPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer utilisateur1;

	@Column(insertable=false, updatable=false)
	private Integer utilisateur2;

	public ContactPK() {
	}
	public Integer getUtilisateur1() {
		return this.utilisateur1;
	}
	public void setUtilisateur1(Integer utilisateur1) {
		this.utilisateur1 = utilisateur1;
	}
	public Integer getUtilisateur2() {
		return this.utilisateur2;
	}
	public void setUtilisateur2(Integer utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContactPK)) {
			return false;
		}
		ContactPK castOther = (ContactPK)other;
		return 
			this.utilisateur1.equals(castOther.utilisateur1)
			&& this.utilisateur2.equals(castOther.utilisateur2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.utilisateur1.hashCode();
		hash = hash * prime + this.utilisateur2.hashCode();
		
		return hash;
	}
}