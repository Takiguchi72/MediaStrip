package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the episode database table.
 * 
 */
@Entity
@NamedQuery(name="Episode.findAll", query="SELECT e FROM Episode e")
public class Episode implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cheminfichier;

	private Timestamp datecreation;

	private String description;

	@Id
	private Integer id;

	private Integer numero;

	private Integer publieur;

	private Boolean publique;

	private String serie;

	private Integer theme;

	private String titre;

	public Episode() {
	}

	public String getCheminfichier() {
		return this.cheminfichier;
	}

	public void setCheminfichier(String cheminfichier) {
		this.cheminfichier = cheminfichier;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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