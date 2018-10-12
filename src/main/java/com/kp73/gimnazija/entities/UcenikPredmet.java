package com.kp73.gimnazija.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ucenik_predmet")
public class UcenikPredmet {

	@Id
	@Column(name = "ucenik_predmet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "ocena")
	private Integer ocena;

	@Column(name = "tip_ocene")
	private String tipOcene;

	@Column(name = "polugodiste")
	private Integer polugodiste;
	
	@Column(name = "datum_unosa")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date datumUnosa;
	
	@Column(name = "napomena")
	private String napomena;

	//bi-directional many-to-one association to Nastavni_plan_predmet
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavni_plan_predmet_id", nullable=false)
	private NastavniPlanPredmet nastavni_plan_predmet;
	
	//bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavnik_id", nullable=false)
	private Nastavnik nastavnik;
	
	//bi-directional many-to-one association to Ucenik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="ucenik_id", nullable=false)
	private Ucenik ucenik;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public String getTipOcene() {
		return tipOcene;
	}

	public void setTipOcene(String tipOcene) {
		this.tipOcene = tipOcene;
	}

	public Integer getPolugodiste() {
		return polugodiste;
	}

	public void setPolugodiste(Integer polugodiste) {
		this.polugodiste = polugodiste;
	}

	public Date getDatumUnosa() {
		return datumUnosa;
	}

	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public NastavniPlanPredmet getNastavni_plan_predmet() {
		return nastavni_plan_predmet;
	}

	public void setNastavni_plan_predmet(NastavniPlanPredmet nastavni_plan_predmet) {
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	
	

}


