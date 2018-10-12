package com.kp73.gimnazija.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	
	@Column(name = "JMBG")
//	@NotEmpty(message = "*Please provide your JMBG")
	private String jmbg;
	
	@CreatedDate
	@Column(name = "datum_rodjenja")
//	@NotEmpty(message = "*Please provide your birth date")
	private Date datumRodjenja;
	
	@Column(name = "adresa")
//	@NotEmpty(message = "*Please provide your adress")
	private String adresa;
	
	@Column(name = "grad")
//	@NotEmpty(message = "*Please provide your City")
	private String grad;
	
	@Column(name = "telefon")
//	@NotEmpty(message = "*Please provide your telephone")
	private String telefon;
	
	@Column(name = "display_name")
//	@NotEmpty(message = "*Please provide your display name")
	private String displayName;
	
	@Column(name = "user_name")
	@NotEmpty(message = "*Please provide your user name")
	private String userName;
	
	@Column(name = "LDAPCN")
//	@NotEmpty(message = "*Please provide your LADAPNC")
	private String ldapcn;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;
	
	
	
	@Column(name = "active")
	private int active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	//bi-directional one-to-many association to Zaposleni
	@OneToMany(mappedBy = "user")
	private Set<Zaposleni> zaposleni;
	
	//bi-directional one-to-many association to Roditelj
	@OneToMany(mappedBy = "user")
	private Set<Roditelj> roditelj;
	
	//bi-directional one-to-many association to Ucenik
	@OneToMany(mappedBy = "user")
	private Set<Ucenik> ucenik;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLdapcn() {
		return ldapcn;
	}

	public void setLdapcn(String ldapcn) {
		this.ldapcn = ldapcn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Set<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public Set<Roditelj> getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Set<Roditelj> roditelj) {
		this.roditelj = roditelj;
	}

	public Set<Ucenik> getUcenik() {
		return ucenik;
	}

	public void setUcenik(Set<Ucenik> ucenik) {
		this.ucenik = ucenik;
	}
	
	

	
}