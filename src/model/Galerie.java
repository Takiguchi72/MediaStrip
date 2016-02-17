package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the galerie database table.
 * 
 */
@Entity
@NamedQuery(name="Galerie.findAll", query="SELECT g FROM Galerie g")
public class Galerie implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp datecreation;

	private String description;

	@Id
	private Integer id;

	private Integer publieur;

	private Boolean publique;

	private Integer theme;

	private String titre;

	public Galerie() {
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

	public Integer getId() {
		return this.id;
	}

	@Id
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPublieur() {
		return this.publieur;
	}

	public void setPublieur(Integer publieur) {
		this.publieur = publieur;
	}

	public Boolean getPublique() {
		return this.publique;
	}

	public void setPublique(Boolean publique) {
		this.publique = publique;
	}

	public Integer getTheme() {
		return this.theme;
	}

	public void setTheme(Integer theme) {
		this.theme = theme;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}