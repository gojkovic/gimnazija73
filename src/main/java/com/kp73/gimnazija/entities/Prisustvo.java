package com.kp73.gimnazija.entities;

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

@Entity
@Table(name = "prisustvo")
public class Prisustvo {

	@Id
	@Column(name = "prisustvo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "opravdano")
	private Integer opravdano;

	//bi-directional many-to-one association to Cas
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="cas_id", nullable=false)
	private Cas cas;
	
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

	public Integer getOpravdano() {
		return opravdano;
	}

	public void setOpravdano(Integer opravdano) {
		this.opravdano = opravdano;
	}

	public Cas getCas() {
		return cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}
	
}