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
@Table(name = "nastavni_plan_predmet")
public class NastavniPlanPredmet {

	@Id
	@Column(name = "nastavni_plan_predmet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "ime_plana")
	private String imePlana;

	@Column(name = "razred")
	private String razred;
	
	@Column(name = "nedeljno_nastave")
	private Integer nedeljnoNastave;
	
	@Column(name = "nedeljno_vezbi")
	private Integer nedeljnoVzbi;
	
	@Column(name = "ukupno_nedelja")
	private Integer ukupnoNedelja;

	//bi-directional many-to-one association to Predmet
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="predmet_id", nullable=false)
	private Predmet predmet;
	
	//bi-directional many-to-one association to GodisnjiPlan
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="godisnji_plan_id", nullable=false)
	private GodisnjiPlan godisnji_plan;
	
	//bi-directional one-to-many association to UcenikPredmet
	@OneToMany(mappedBy = "nastavni_plan_predmet")
	private Set<UcenikPredmet> ucenik_predmet;
	
	//bi-directional one-to-many association to Cas
	@OneToMany(mappedBy = "nastavni_plan_predmet")
	private Set<Cas> cas;
	
	//bi-directional one-to-many association to Angazovanje
	@OneToMany(mappedBy = "nastavni_plan_predmet")
	private Set<Angazovanje> angazovanje;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImePlana() {
		return imePlana;
	}

	public void setImePlana(String imePlana) {
		this.imePlana = imePlana;
	}

	public String getRazred() {
		return razred;
	}

	public void setRazred(String razred) {
		this.razred = razred;
	}

	public Integer getNedeljnoNastave() {
		return nedeljnoNastave;
	}

	public void setNedeljnoNastave(Integer nedeljnoNastave) {
		this.nedeljnoNastave = nedeljnoNastave;
	}

	public Integer getNedeljnoVzbi() {
		return nedeljnoVzbi;
	}

	public void setNedeljnoVzbi(Integer nedeljnoVzbi) {
		this.nedeljnoVzbi = nedeljnoVzbi;
	}

	public Integer getUkupnoNedelja() {
		return ukupnoNedelja;
	}

	public void setUkupnoNedelja(Integer ukupnoNedelja) {
		this.ukupnoNedelja = ukupnoNedelja;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public GodisnjiPlan getGodisnji_plan() {
		return godisnji_plan;
	}

	public void setGodisnji_plan(GodisnjiPlan godisnji_plan) {
		this.godisnji_plan = godisnji_plan;
	}

	public Set<UcenikPredmet> getUcenik_predmet() {
		return ucenik_predmet;
	}

	public void setUcenik_predmet(Set<UcenikPredmet> ucenik_predmet) {
		this.ucenik_predmet = ucenik_predmet;
	}

	public Set<Cas> getCas() {
		return cas;
	}

	public void setCas(Set<Cas> cas) {
		this.cas = cas;
	}

	public Set<Angazovanje> getAngazovanje() {
		return angazovanje;
	}

	public void setAngazovanje(Set<Angazovanje> angazovanje) {
		this.angazovanje = angazovanje;
	}
	
	
}
