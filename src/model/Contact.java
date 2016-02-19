package model;

import java.io.Serializable;
import javax.persistence.*;

 
/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContactPK id;

	private String status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user1")
	private User user1Bean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user2")
	private User user2Bean;

	public Contact() {
	}

	public ContactPK getId() {
		return this.id;
	}

	public void setId(ContactPK id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser1Bean() {
		return this.user1Bean;
	}

	public void setUser1Bean(User user1Bean) {
		this.user1Bean = user1Bean;
	}

	public User getUser2Bean() {
		return this.user2Bean;
	}

	public void setUser2Bean(User user2Bean) {
		this.user2Bean = user2Bean;
	}

}