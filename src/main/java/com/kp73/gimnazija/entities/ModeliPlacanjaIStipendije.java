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
@Table(name = "modeli_placanja_i_stipendije")
public class ModeliPlacanjaIStipendije {

	@Id
	@Column(name = "modeli_placanja_i_stipendije_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "naziv_modela")
	private String nazivMdela;
	
	@Column(name = "opis")
	private String opis;

	@Column(name = "popust")
	private Double popust;
	
	@Column(name = "kamata")
	private Double kamata;
	
	@Column(name = "zatezna_kamata")
	private Double zateznaKamata;

	//bi-directional one-to-many association to Cenovnik
	@OneToMany(mappedBy = "modeli_placanja_i_stipendije")
	private Set<Cenovnik> cenovnik;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazivMdela() {
		return nazivMdela;
	}

	public void setNazivMdela(String nazivMdela) {
		this.nazivMdela = nazivMdela;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(Double popust) {
		this.popust = popust;
	}

	public Double getKamata() {
		return kamata;
	}

	public void setKamata(Double kamata) {
		this.kamata = kamata;
	}

	public Double getZateznaKamata() {
		return zateznaKamata;
	}

	public void setZateznaKamata(Double zateznaKamata) {
		this.zateznaKamata = zateznaKamata;
	}

	public Set<Cenovnik> getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Set<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	

}