package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT s FROM Room s")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="creator")
	private User user;

	public Room() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}