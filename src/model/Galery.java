package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the galerie database table.
 * 
 */
@Entity
@NamedQuery(name="Galery.findAll", query="SELECT g FROM Galery g")
public class Galery implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp createdAt;

	private String description;

	@Id
	private Integer id;

	private Integer publisher;

	private Boolean published;

	private Integer theme;

	private String title;

	public Galery() {
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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

	public Integer getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Integer publisher) {
		this.publisher = publisher;
	}

	public Boolean getPublished() {
		return this.published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Integer getTheme() {
		return this.theme;
	}

	public void setTheme(Integer theme) {
		this.theme = theme;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}