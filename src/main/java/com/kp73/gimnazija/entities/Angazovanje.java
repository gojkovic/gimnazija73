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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "angazovanje")
public class Angazovanje {

	@Id
	@Column(name = "angazovanje_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "pocetak")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date pocetak;

	@Column(name = "kraj")
	@Temporal(TemporalType.DATE)
	@NotNull(message="datum ne sme biti prazan")
	private Date kraj;
	
    // bi-directional many-to-many association to Odeljenje
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable(name = "angazovanje_odeljenje", joinColumns = @JoinColumn(name = "angazovanje_id"), inverseJoinColumns = @JoinColumn(name = "odeljenje_id"))
	private Set<Odeljenje> odeljenjes;
		
	//bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavnik_id", nullable=false)
	private Nastavnik nastavnik;
		
	//bi-directional many-to-one association to Nastavni_plan_predmet
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavni_plan_predmet_id", nullable=false)
	private NastavniPlanPredmet nastavni_plan_predmet;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Date getPocetak() {
			return pocetak;
		}

		public void setPocetak(Date pocetak) {
			this.pocetak = pocetak;
		}

		public Date getKraj() {
			return kraj;
		}

		public void setKraj(Date kraj) {
			this.kraj = kraj;
		}

		public Set<Odeljenje> getOdeljenjes() {
			return odeljenjes;
		}

		public void setOdeljenjes(Set<Odeljenje> odeljenjes) {
			this.odeljenjes = odeljenjes;
		}

		public Nastavnik getNastavnik() {
			return nastavnik;
		}

		public void setNastavnik(Nastavnik nastavnik) {
			this.nastavnik = nastavnik;
		}

		public NastavniPlanPredmet getNastavni_plan_predmet() {
			return nastavni_plan_predmet;
		}

		public void setNastavni_plan_predmet(NastavniPlanPredmet nastavni_plan_predmet) {
			this.nastavni_plan_predmet = nastavni_plan_predmet;
		}

	
	
}