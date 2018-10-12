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
@Table(name = "uplate")
public class Uplate {

	@Id
	@Column(name = "uplate_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "datum_placanja")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date datum_placanja;
	
	@Column(name = "iznos_uplate_din")
	private Float iznos_uplate_din;
	
	@Column(name = "iznos_uplate_eur")
	private Float iznos_uplate_eur;
	
	@Column(name = "srednji_kurs")
	private Float srednji_kurs;

	@Column(name = "napomena")
	private String napomena;

	//bi-directional many-to-one association to Zaduzenja
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="zaduzenja_id", nullable=false)
	private Zaduzenja zaduzenja;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatum_placanja() {
		return datum_placanja;
	}

	public void setDatum_placanja(Date datum_placanja) {
		this.datum_placanja = datum_placanja;
	}

	public Float getIznos_uplate_din() {
		return iznos_uplate_din;
	}

	public void setIznos_uplate_din(Float iznos_uplate_din) {
		this.iznos_uplate_din = iznos_uplate_din;
	}

	public Float getIznos_uplate_eur() {
		return iznos_uplate_eur;
	}

	public void setIznos_uplate_eur(Float iznos_uplate_eur) {
		this.iznos_uplate_eur = iznos_uplate_eur;
	}

	public Float getSrednji_kurs() {
		return srednji_kurs;
	}

	public void setSrednji_kurs(Float srednji_kurs) {
		this.srednji_kurs = srednji_kurs;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Zaduzenja getZaduzenja() {
		return zaduzenja;
	}

	public void setZaduzenja(Zaduzenja zaduzenja) {
		this.zaduzenja = zaduzenja;
	}
	
	
}