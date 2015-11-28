package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the school_transfer database table.
 * 
 */
@Entity
@Table(name="school_transfer")
@NamedQuery(name="SchoolTransfer.findAll", query="SELECT s FROM SchoolTransfer s")
public class SchoolTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="education_break", length=45)
	private String educationBreak;

	private int tc;

	@Column(name="tc_acknowledge")
	private int tcAcknowledge;

	@Temporal(TemporalType.DATE)
	@Column(name="tc_expiry")
	private Date tcExpiry;

	//bi-directional many-to-one association to FamilyTransfer
	@ManyToOne
	@JoinColumn(name="transfer")
	private FamilyTransfer familyTransfer;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person")
	private Person personBean;

	public SchoolTransfer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEducationBreak() {
		return this.educationBreak;
	}

	public void setEducationBreak(String educationBreak) {
		this.educationBreak = educationBreak;
	}

	public int getTc() {
		return this.tc;
	}

	public void setTc(int tc) {
		this.tc = tc;
	}

	public int getTcAcknowledge() {
		return this.tcAcknowledge;
	}

	public void setTcAcknowledge(int tcAcknowledge) {
		this.tcAcknowledge = tcAcknowledge;
	}

	public Date getTcExpiry() {
		return this.tcExpiry;
	}

	public void setTcExpiry(Date tcExpiry) {
		this.tcExpiry = tcExpiry;
	}

	public FamilyTransfer getFamilyTransfer() {
		return this.familyTransfer;
	}

	public void setFamilyTransfer(FamilyTransfer familyTransfer) {
		this.familyTransfer = familyTransfer;
	}

	public Person getPersonBean() {
		return this.personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

}