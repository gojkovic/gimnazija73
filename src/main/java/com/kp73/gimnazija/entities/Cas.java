package com.kp73.gimnazija.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cas")
public class Cas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cas_id")
	private long id;

	@Column(name = "redni_broj_casa")
	private Integer redniBrojCasa;
	
	@Column(name = "ukupan_rb_casa")
	private Integer ukupanRbCasa;
	
	@Column(name = "opis_casa")
	private String opisCasa;

	@Column(name = "napomena")
	private String napomena;

	@Column(name = "datum_unosa")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date datumUnosa;
	
		
	//bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavnik_id", nullable=false)
	private Nastavnik nastavnik;
		
	//bi-directional one-to-many association to Prisustvo
	@OneToMany(mappedBy = "cas")
	private Set<Prisustvo> prisustvo;
	
	//bi-directional many-to-one association to Nastavni_plan_predmet
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavni_plan_predmet_id", nullable=false)
	private NastavniPlanPredmet nastavni_plan_predmet;
	
	//bi-directional many-to-one association to Odeljenje
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="odeljenje_id", nullable=false)
	private Odeljenje odeljenje;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getRedniBrojCasa() {
		return redniBrojCasa;
	}

	public void setRedniBrojCasa(Integer redniBrojCasa) {
		this.redniBrojCasa = redniBrojCasa;
	}

	public Integer getUkupanRbCasa() {
		return ukupanRbCasa;
	}

	public void setUkupanRbCasa(Integer ukupanRbCasa) {
		this.ukupanRbCasa = ukupanRbCasa;
	}

	public String getOpisCasa() {
		return opisCasa;
	}

	public void setOpisCasa(String opisCasa) {
		this.opisCasa = opisCasa;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Date getDatumUnosa() {
		return datumUnosa;
	}

	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Set<Prisustvo> getPrisustvo() {
		return prisustvo;
	}

	public void setPrisustvo(Set<Prisustvo> prisustvo) {
		this.prisustvo = prisustvo;
	}

	public NastavniPlanPredmet getNastavni_plan_predmet() {
		return nastavni_plan_predmet;
	}

	public void setNastavni_plan_predmet(NastavniPlanPredmet nastavni_plan_predmet) {
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}
	

	
	

}