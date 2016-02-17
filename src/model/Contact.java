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

	private String statut;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur1")
	private Utilisateur utilisateur1Bean;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur2")
	private Utilisateur utilisateur2Bean;

	public Contact() {
	}

	public ContactPK getId() {
		return this.id;
	}

	public void setId(ContactPK id) {
		this.id = id;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Utilisateur getUtilisateur1Bean() {
		return this.utilisateur1Bean;
	}

	public void setUtilisateur1Bean(Utilisateur utilisateur1Bean) {
		this.utilisateur1Bean = utilisateur1Bean;
	}

	public Utilisateur getUtilisateur2Bean() {
		return this.utilisateur2Bean;
	}

	public void setUtilisateur2Bean(Utilisateur utilisateur2Bean) {
		this.utilisateur2Bean = utilisateur2Bean;
	}

}