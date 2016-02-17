package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean administrateur;

	@Temporal(TemporalType.DATE)
	private Date dateinscription;

	private Timestamp derniereconnexion;

	private String mail;

	private String motdepasse;

	private String nom;

	private String prenom;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany
	@JoinTable(
		name="abonnement"
		, joinColumns={
			@JoinColumn(name="publieur")
			}
		, inverseJoinColumns={
			@JoinColumn(name="abonne")
			}
		)
	private List<Utilisateur> utilisateurs1;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="utilisateurs1")
	private List<Utilisateur> utilisateurs2;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="utilisateur1Bean")
	private List<Contact> contacts1;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="utilisateur2Bean")
	private List<Contact> contacts2;

	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="utilisateur")
	private List<Media> medias;

	//bi-directional many-to-one association to Salle
	@OneToMany(mappedBy="utilisateur")
	private List<Salle> salles;

	public Utilisateur() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	public Date getDateinscription() {
		return this.dateinscription;
	}

	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}

	public Timestamp getDerniereconnexion() {
		return this.derniereconnexion;
	}

	public void setDerniereconnexion(Timestamp derniereconnexion) {
		this.derniereconnexion = derniereconnexion;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Utilisateur> getUtilisateurs1() {
		return this.utilisateurs1;
	}

	public void setUtilisateurs1(List<Utilisateur> utilisateurs1) {
		this.utilisateurs1 = utilisateurs1;
	}

	public List<Utilisateur> getUtilisateurs2() {
		return this.utilisateurs2;
	}

	public void setUtilisateurs2(List<Utilisateur> utilisateurs2) {
		this.utilisateurs2 = utilisateurs2;
	}

	public List<Contact> getContacts1() {
		return this.contacts1;
	}

	public void setContacts1(List<Contact> contacts1) {
		this.contacts1 = contacts1;
	}

	public Contact addContacts1(Contact contacts1) {
		getContacts1().add(contacts1);
		contacts1.setUtilisateur1Bean(this);

		return contacts1;
	}

	public Contact removeContacts1(Contact contacts1) {
		getContacts1().remove(contacts1);
		contacts1.setUtilisateur1Bean(null);

		return contacts1;
	}

	public List<Contact> getContacts2() {
		return this.contacts2;
	}

	public void setContacts2(List<Contact> contacts2) {
		this.contacts2 = contacts2;
	}

	public Contact addContacts2(Contact contacts2) {
		getContacts2().add(contacts2);
		contacts2.setUtilisateur2Bean(this);

		return contacts2;
	}

	public Contact removeContacts2(Contact contacts2) {
		getContacts2().remove(contacts2);
		contacts2.setUtilisateur2Bean(null);

		return contacts2;
	}

	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Media addMedia(Media media) {
		getMedias().add(media);
		media.setUtilisateur(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setUtilisateur(null);

		return media;
	}

	public List<Salle> getSalles() {
		return this.salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public Salle addSalle(Salle salle) {
		getSalles().add(salle);
		salle.setUtilisateur(this);

		return salle;
	}

	public Salle removeSalle(Salle salle) {
		getSalles().remove(salle);
		salle.setUtilisateur(null);

		return salle;
	}

}