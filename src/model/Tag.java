package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String label;

	//bi-directional many-to-many association to Media
	@ManyToMany
	@JoinTable(
		name="associationtag"
		, joinColumns={
			@JoinColumn(name="tag")
			}
		, inverseJoinColumns={
			@JoinColumn(name="media")
			}
		)
	private List<Media> medias1;

	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="tag")
	private List<Media> medias2;

	public Tag() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Media> getMedias1() {
		return this.medias1;
	}

	public void setMedias1(List<Media> medias1) {
		this.medias1 = medias1;
	}

	public List<Media> getMedias2() {
		return this.medias2;
	}

	public void setMedias2(List<Media> medias2) {
		this.medias2 = medias2;
	}

	public Media addMedias2(Media medias2) {
		getMedias2().add(medias2);
		medias2.setTag(this);

		return medias2;
	}

	public Media removeMedias2(Media medias2) {
		getMedias2().remove(medias2);
		medias2.setTag(null);

		return medias2;
	}

}