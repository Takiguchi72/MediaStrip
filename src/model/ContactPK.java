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
	private Integer user1;

	@Column(insertable=false, updatable=false)
	private Integer user2;

	public ContactPK() {
	}
	public Integer getUser1() {
		return this.user1;
	}
	public void setUser1(Integer user1) {
		this.user1 = user1;
	}
	public Integer getUser2() {
		return this.user2;
	}
	public void setUser2(Integer user2) {
		this.user2 = user2;
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
			this.user1.equals(castOther.user1)
			&& this.user2.equals(castOther.user2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.user1.hashCode();
		hash = hash * prime + this.user2.hashCode();
		
		return hash;
	}
}