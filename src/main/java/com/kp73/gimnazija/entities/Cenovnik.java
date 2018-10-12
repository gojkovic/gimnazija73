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
@Table(name = "cenovnik")
public class Cenovnik {

	@Id
	@Column(name = "cenovnik_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "naziv_stavke")
	private String nazivStavke;

	@Column(name = "sifra_stavke")
	private Integer sifraStavke;
	
	@Column(name = "cena_stavke")
	private Float cenaStavke;
	
	@Column(name = "valuta")
	private String valuta;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date dateCreated;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "date_modified")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date dateModified;
	
	@Column(name = "modified_by")
	private Integer modifiedBy;

	//bi-directional many-to-one association to SkolskaGodina
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="skolska_godina_id", nullable=false)
	private SkolskaGodina skolska_godina;
	
	//bi-directional many-to-one association to ModeliPlacanjaIStipendije
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="modeli_placanja_i_stipendije_id", nullable=false)
	private ModeliPlacanjaIStipendije modeli_placanja_i_stipendije;
	
	//bi-directional one-to-many association to Zaduzenja
	@OneToMany(mappedBy = "cenovnik")
	private Set<Zaduzenja> zaduzenja;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazivStavke() {
		return nazivStavke;
	}

	public void setNazivStavke(String nazivStavke) {
		this.nazivStavke = nazivStavke;
	}

	public Integer getSifraStavke() {
		return sifraStavke;
	}

	public void setSifraStavke(Integer sifraStavke) {
		this.sifraStavke = sifraStavke;
	}

	public Float getCenaStavke() {
		return cenaStavke;
	}

	public void setCenaStavke(Float cenaStavke) {
		this.cenaStavke = cenaStavke;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public SkolskaGodina getSkolska_godina() {
		return skolska_godina;
	}

	public void setSkolska_godina(SkolskaGodina skolska_godina) {
		this.skolska_godina = skolska_godina;
	}

	public ModeliPlacanjaIStipendije getModeli_placanja_i_stipendije() {
		return modeli_placanja_i_stipendije;
	}

	public void setModeli_placanja_i_stipendije(ModeliPlacanjaIStipendije modeli_placanja_i_stipendije) {
		this.modeli_placanja_i_stipendije = modeli_placanja_i_stipendije;
	}

	public Set<Zaduzenja> getZaduzenja() {
		return zaduzenja;
	}

	public void setZaduzenja(Set<Zaduzenja> zaduzenja) {
		this.zaduzenja = zaduzenja;
	}
	
	
}