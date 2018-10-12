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
@Table(name = "nastavnik")
public class Nastavnik {

	@Id
	@Column(name = "nastavniki_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "fakultet")
	private String fakultet;

	@Column(name = "razredni")
	private Integer razredni;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFakultet() {
		return fakultet;
	}

	public void setFakultet(String fakultet) {
		this.fakultet = fakultet;
	}

	public Integer getRazredni() {
		return razredni;
	}

	public void setRazredni(Integer razredni) {
		this.razredni = razredni;
	}
	
	//bi-directional many-to-one association to Zaposleni
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="zaposleni_id", nullable=false)
	private Zaposleni zaposleni;
	
	//bi-directional one-to-many association to Angazovanje
	@OneToMany(mappedBy = "nastavnik")
	private Set<Angazovanje> angazovanje;
	
	//bi-directional one-to-many association to Cas
	@OneToMany(mappedBy = "nastavnik")
	private Set<Cas> cas;
	
	//bi-directional one-to-many association to Odeljenje
	@OneToMany(mappedBy = "nastavnik")
	private Set<Odeljenje> odeljenje;

	//bi-directional one-to-many association to UcenikPredmet
	@OneToMany(mappedBy = "nastavnik")
	private Set<UcenikPredmet> ucenik_predmet;

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public Set<Angazovanje> getAngazovanje() {
		return angazovanje;
	}

	public void setAngazovanje(Set<Angazovanje> angazovanje) {
		this.angazovanje = angazovanje;
	}

	public Set<Cas> getCas() {
		return cas;
	}

	public void setCas(Set<Cas> cas) {
		this.cas = cas;
	}

	public Set<Odeljenje> getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Set<Odeljenje> odeljenje) {
		this.odeljenje = odeljenje;
	}

	public Set<UcenikPredmet> getUcenik_predmet() {
		return ucenik_predmet;
	}

	public void setUcenik_predmet(Set<UcenikPredmet> ucenik_predmet) {
		this.ucenik_predmet = ucenik_predmet;
	}





}