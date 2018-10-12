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
@Table(name = "zaduzenja")
public class Zaduzenja {

	@Id
	@Column(name = "zaduzenja_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "viznos_zaduzenja")
	private Double iznosZaduzenja;
	
	@Column(name = "rok_za_placanje")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date rokZaPlacanje;
	
	@Column(name = "popust_iznos")
	private Double popustIznos;

	@Column(name = "napomena")
	private String napomena;

	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date dateCreated;
	
	@Column(name = "modified_by")
	private Integer modifiedBy;
	
	@Column(name = "date_modified")
	private Date dateModified;

	//bi-directional many-to-one association to Cenovnik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="cenovnik_id", nullable=false)
	private Cenovnik cenovnik;
		
	//bi-directional many-to-one association to Upis
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="upis_id", nullable=false)
	private Upis upis;
	
	//bi-directional one-to-many association to Uplate
	@OneToMany(mappedBy = "zaduzenja")
	private Set<Uplate> uplate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getIznosZaduzenja() {
		return iznosZaduzenja;
	}

	public void setIznosZaduzenja(Double iznosZaduzenja) {
		this.iznosZaduzenja = iznosZaduzenja;
	}

	public Date getRokZaPlacanje() {
		return rokZaPlacanje;
	}

	public void setRokZaPlacanje(Date rokZaPlacanje) {
		this.rokZaPlacanje = rokZaPlacanje;
	}

	public Double getPopustIznos() {
		return popustIznos;
	}

	public void setPopustIznos(Double popustIznos) {
		this.popustIznos = popustIznos;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public Upis getUpis() {
		return upis;
	}

	public void setUpis(Upis upis) {
		this.upis = upis;
	}

	public Set<Uplate> getUplate() {
		return uplate;
	}

	public void setUplate(Set<Uplate> uplate) {
		this.uplate = uplate;
	}
	
	
}