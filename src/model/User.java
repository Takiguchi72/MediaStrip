package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean administrator;

	@Temporal(TemporalType.DATE)
	private Date registerAt;

	private Timestamp lastLogin;

	private String mail;

	private String password;

	private String name;

	private String firstname;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="abonnement"
		, joinColumns={
			@JoinColumn(name="publisher")
			}
		, inverseJoinColumns={
			@JoinColumn(name="abonne")
			}
		)
	private List<User> users1;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="users1")
	private List<User> users2;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user1Bean")
	private List<Contact> contacts1;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user2Bean")
	private List<Contact> contacts2;

	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="user")
	private List<Media> medias;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="user")
	private List<Room> rooms;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	public Date getRegisterAt() {
		return this.registerAt;
	}

	public void setRegisterAt(Date registerAt) {
		this.registerAt = registerAt;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public List<Contact> getContacts1() {
		return this.contacts1;
	}

	public void setContacts1(List<Contact> contacts1) {
		this.contacts1 = contacts1;
	}

	public Contact addContacts1(Contact contacts1) {
		getContacts1().add(contacts1);
		contacts1.setUser1Bean(this);

		return contacts1;
	}

	public Contact removeContacts1(Contact contacts1) {
		getContacts1().remove(contacts1);
		contacts1.setUser1Bean(null);

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
		contacts2.setUser2Bean(this);

		return contacts2;
	}

	public Contact removeContacts2(Contact contacts2) {
		getContacts2().remove(contacts2);
		contacts2.setUser2Bean(null);

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
		media.setUser(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setUser(null);

		return media;
	}

	public List<Room> getSalles() {
		return this.rooms;
	}

	public void setSalles(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addSalle(Room room) {
		getSalles().add(room);
		room.setUser(this);

		return room;
	}

	public Room removeSalle(Room room) {
		getSalles().remove(room);
		room.setUser(null);

		return room;
	}

}