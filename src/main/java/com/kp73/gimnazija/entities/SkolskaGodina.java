package com.kp73.gimnazija.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skolska_godina")
public class SkolskaGodina {

	@Id
	@Column(name = "skolska_godina_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "datum_pocetka")
	@NotNull(message="datum ne sme biti prazan")
	private String datumPocetk;

	@Column(name = "datum_kraja")
	@NotNull(message="datum ne sme biti prazan")
	private String datumKraja;

	//bi-directional one-to-many association to Odeljenje
	@OneToMany(mappedBy = "skolska_godina")
	private Set<Odeljenje> odeljenje;
	
	//bi-directional one-to-many association to Cenovnik
	@OneToMany(mappedBy = "skolska_godina")
	private Set<Cenovnik> cenovnik;
	
	//bi-directional one-to-many association to GodisnjiPlan
	@OneToMany(mappedBy = "skolska_godina")
	private Set<GodisnjiPlan> godisnji_plan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDatumPocetk() {
		return datumPocetk;
	}

	public void setDatumPocetk(String datumPocetk) {
		this.datumPocetk = datumPocetk;
	}

	public String getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(String datumKraja) {
		this.datumKraja = datumKraja;
	}

	public Set<Odeljenje> getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Set<Odeljenje> odeljenje) {
		this.odeljenje = odeljenje;
	}

	public Set<Cenovnik> getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Set<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}

	public Set<GodisnjiPlan> getGodisnji_plan() {
		return godisnji_plan;
	}

	public void setGodisnji_plan(Set<GodisnjiPlan> godisnji_plan) {
		this.godisnji_plan = godisnji_plan;
	}
	
	
}