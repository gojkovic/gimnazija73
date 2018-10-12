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
@Table(name = "ucenik")
public class Ucenik {

	@Id
	@Column(name = "ucenik_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "broj_knjizice")
	private String brojKnjizice;

	@Column(name = "ime_roditelja")
	private String imeRoditelja;
	
	@Column(name = "osnovna_skola")
	private String osnovnaSkola;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
    // bi-directional many-to-many association to Roditelj
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable(name = "ucenik_roditelj", joinColumns = @JoinColumn(name = "ucenik_id"), inverseJoinColumns = @JoinColumn(name = "roditelj_id"))
	private Set<Roditelj> roditelj;
	
	//bi-directional one-to-many association to Prisustvo
	@OneToMany(mappedBy = "ucenik")
	private Set<Prisustvo> prisustvo;
	
	//bi-directional one-to-many association to UcenikPredmet
	@OneToMany(mappedBy = "ucenik")
	private Set<UcenikPredmet> ucenik_predmet;
	
	//bi-directional one-to-many association to Upis
	@OneToMany(mappedBy = "ucenik")
	private Set<Upis> upis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrojKnjizice() {
		return brojKnjizice;
	}

	public void setBrojKnjizice(String brojKnjizice) {
		this.brojKnjizice = brojKnjizice;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getOsnovnaSkola() {
		return osnovnaSkola;
	}

	public void setOsnovnaSkola(String osnovnaSkola) {
		this.osnovnaSkola = osnovnaSkola;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Roditelj> getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Set<Roditelj> roditelj) {
		this.roditelj = roditelj;
	}

	public Set<Prisustvo> getPrisustvo() {
		return prisustvo;
	}

	public void setPrisustvo(Set<Prisustvo> prisustvo) {
		this.prisustvo = prisustvo;
	}

	public Set<UcenikPredmet> getUcenik_predmet() {
		return ucenik_predmet;
	}

	public void setUcenik_predmet(Set<UcenikPredmet> ucenik_predmet) {
		this.ucenik_predmet = ucenik_predmet;
	}

	public Set<Upis> getUpis() {
		return upis;
	}

	public void setUpis(Set<Upis> upis) {
		this.upis = upis;
	}
	
	
}


