package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m")
public class Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp datecreation;

	private String description;

	private Boolean publique;

	private String titre;

	//bi-directional many-to-many association to Tag
	@ManyToMany(mappedBy="medias1")
	private List<Tag> tags;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="theme")
	private Tag tag;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="publieur")
	private Utilisateur utilisateur;

	public Media() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatecreation() {
		return this.datecreation;
	}

	public void setDatecreation(Timestamp datecreation) {
		this.datecreation = datecreation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPublique() {
		return this.publique;
	}

	public void setPublique(Boolean publique) {
		this.publique = publique;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}