package com.kp73.gimnazija.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roditelj")
public class Roditelj {

	@Id
	@Column(name = "roditelj_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    // bi-directional many-to-many association to Ucenik
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable(name = "ucenik_roditelj", joinColumns = @JoinColumn(name = "roditelj_id"), inverseJoinColumns = @JoinColumn(name = "ucenik_id"))
	private Set<Ucenik> ucenik;
		
	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	//bi-directional one-to-many association to RoditeljskiSastanak
	@OneToMany(mappedBy = "roditelj")
	private Set<RoditeljskiSastanak> roditeljski_sastanak;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Ucenik> getUcenik() {
		return ucenik;
	}

	public void setUcenik(Set<Ucenik> ucenik) {
		this.ucenik = ucenik;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<RoditeljskiSastanak> getRoditeljski_sastanak() {
		return roditeljski_sastanak;
	}

	public void setRoditeljski_sastanak(Set<RoditeljskiSastanak> roditeljski_sastanak) {
		this.roditeljski_sastanak = roditeljski_sastanak;
	}
	
	
	
}