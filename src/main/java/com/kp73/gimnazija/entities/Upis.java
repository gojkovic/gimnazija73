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
@Table(name = "upis")
public class Upis {

	@Id
	@Column(name = "upis_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "datum_upisa")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date datumUpisa;

	//bi-directional many-to-one association to Odeljenje
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="odeljenje_id", nullable=false)
	private Odeljenje odeljenje;
	
	//bi-directional many-to-one association to Ucenik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="ucenik_id", nullable=false)
	private Ucenik ucenik;
	
	//bi-directional one-to-many association to Zaduzenja
	@OneToMany(mappedBy = "upis")
	private Set<Zaduzenja> zaduzenja;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Set<Zaduzenja> getZaduzenja() {
		return zaduzenja;
	}

	public void setZaduzenja(Set<Zaduzenja> zaduzenja) {
		this.zaduzenja = zaduzenja;
	}
	
	


}