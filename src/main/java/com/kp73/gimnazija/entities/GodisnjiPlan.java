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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "godisnji_plan")
public class GodisnjiPlan {

	@Id
	@Column(name = "godisnji_plan_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "naziv_skole")
	private String nazivSkole;

	@Column(name = "usvojen")
	private boolean usvojen;
	
	@Column(name = "datum_usvajanja")
	@NotNull(message="datum ne sme biti prazan")
	private String datumUsvajanja;
	
	@Column(name = "vazi_do")
	@NotNull(message="datum ne sme biti prazan")
	private String vaziDo;

	//bi-directional many-to-one association to SkolskaGodina
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="skolska_godina_id", nullable=false)
	private SkolskaGodina skolska_godina;
	
	//bi-directional one-to-many association to NastavniPlanPredmet
	@OneToMany(mappedBy = "godisnji_plan")
	private Set<NastavniPlanPredmet> nastavni_plan_predmet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazivSkole() {
		return nazivSkole;
	}

	public void setNazivSkole(String nazivSkole) {
		this.nazivSkole = nazivSkole;
	}

	public boolean isUsvojen() {
		return usvojen;
	}

	public void setUsvojen(boolean usvojen) {
		this.usvojen = usvojen;
	}

	public String getDatumUsvajanja() {
		return datumUsvajanja;
	}

	public void setDatumUsvajanja(String datumUsvajanja) {
		this.datumUsvajanja = datumUsvajanja;
	}

	public String getVaziDo() {
		return vaziDo;
	}

	public void setVaziDo(String vaziDo) {
		this.vaziDo = vaziDo;
	}

	public SkolskaGodina getSkolska_godina() {
		return skolska_godina;
	}

	public void setSkolska_godina(SkolskaGodina skolska_godina) {
		this.skolska_godina = skolska_godina;
	}

	public Set<NastavniPlanPredmet> getNastavni_plan_predmet() {
		return nastavni_plan_predmet;
	}

	public void setNastavni_plan_predmet(Set<NastavniPlanPredmet> nastavni_plan_predmet) {
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}
	
	

}