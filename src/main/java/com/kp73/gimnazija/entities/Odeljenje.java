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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "odeljenje")
public class Odeljenje {

	@Id
	@Column(name = "odeljenje_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "oznaka")
	private Integer oznaka;
	
	@Column(name = "razred")
	private String razred;

	//bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="nastavnik_id", nullable=false)
	private Nastavnik nastavnik;
		
	//bi-directional many-to-one association to SkolskaGodina
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="skolska_godina_id", nullable=false)
	private SkolskaGodina skolska_godina;
	
    // bi-directional many-to-many association to Angazovanje
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable(name = "angazovanje_odeljenje", joinColumns = @JoinColumn(name = "odeljenje_id"), inverseJoinColumns = @JoinColumn(name = "angazovanje_id"))
	private Set<Angazovanje> angazovanje;
	
	//bi-directional one-to-many association to Upis
	@OneToMany(mappedBy = "odeljenje")
	private Set<Upis> upis;
	
	//bi-directional one-to-many association to Cas
	@OneToMany(mappedBy = "odeljenje")
	private Set<Cas> cas;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Integer getOznaka() {
			return oznaka;
		}

		public void setOznaka(Integer oznaka) {
			this.oznaka = oznaka;
		}

		public String getRazred() {
			return razred;
		}

		public void setRazred(String razred) {
			this.razred = razred;
		}

		public Nastavnik getNastavnik() {
			return nastavnik;
		}

		public void setNastavnik(Nastavnik nastavnik) {
			this.nastavnik = nastavnik;
		}

		public SkolskaGodina getSkolska_godina() {
			return skolska_godina;
		}

		public void setSkolska_godina(SkolskaGodina skolska_godina) {
			this.skolska_godina = skolska_godina;
		}

		public Set<Angazovanje> getAngazovanje() {
			return angazovanje;
		}

		public void setAngazovanje(Set<Angazovanje> angazovanje) {
			this.angazovanje = angazovanje;
		}

		public Set<Upis> getUpis() {
			return upis;
		}

		public void setUpis(Set<Upis> upis) {
			this.upis = upis;
		}

		public Set<Cas> getCas() {
			return cas;
		}

		public void setCas(Set<Cas> cas) {
			this.cas = cas;
		}
		
	
}