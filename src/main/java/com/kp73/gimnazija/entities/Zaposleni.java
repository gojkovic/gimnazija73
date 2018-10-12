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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zaposleni")
public class Zaposleni {

	@Id
	@Column(name = "zaposleni_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "zvanje")
	private String zvanje;
	
	@Column(name = "SSS")
	private String SSS;
	
	@Column(name = "pozicija")
	private String pozicija;
	
	@Column(name = "banka")
	private String banka;
	
	@Column(name = "broj_racuna")
	private String brojRacuna;

	//bi-directional one-to-many association to Nastavnik
	@OneToMany(mappedBy = "zaposleni")
	private Set<Nastavnik> nastavnik;
	
	//bi-directional one-to-many association to RoditeljskiSastanak
	@OneToMany(mappedBy = "zaposleni")
	private Set<RoditeljskiSastanak> roditeljski_sastanak;
	
	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public String getSSS() {
		return SSS;
	}

	public void setSSS(String sSS) {
		SSS = sSS;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	public String getBanka() {
		return banka;
	}

	public void setBanka(String banka) {
		this.banka = banka;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Set<Nastavnik> getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Set<Nastavnik> nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Set<RoditeljskiSastanak> getRoditeljski_sastanak() {
		return roditeljski_sastanak;
	}

	public void setRoditeljski_sastanak(Set<RoditeljskiSastanak> roditeljski_sastanak) {
		this.roditeljski_sastanak = roditeljski_sastanak;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}