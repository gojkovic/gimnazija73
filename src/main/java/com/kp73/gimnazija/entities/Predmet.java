package com.kp73.gimnazija.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "predmet")
public class Predmet {

	@Id
	@Column(name = "predmet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "sifra")
	private String sifra;

	@Column(name = "pun_naziv")
	private String punNaziv;

	//bi-directional one-to-many association to NastavniPlanPredmet
	@OneToMany(mappedBy = "predmet")
	private Set<NastavniPlanPredmet> nastavni_plan_predmet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getPunNaziv() {
		return punNaziv;
	}

	public void setPunNaziv(String punNaziv) {
		this.punNaziv = punNaziv;
	}

	public Set<NastavniPlanPredmet> getNastavni_plan_predmet() {
		return nastavni_plan_predmet;
	}

	public void setNastavni_plan_predmet(Set<NastavniPlanPredmet> nastavni_plan_predmet) {
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}
	
	
}