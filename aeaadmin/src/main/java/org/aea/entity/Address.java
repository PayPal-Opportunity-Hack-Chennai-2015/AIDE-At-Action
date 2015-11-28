package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String city;

	@Column(length=45)
	private String district;

	@Column(length=45)
	private String fline;

	@Column(length=45)
	private String region;

	@Column(length=45)
	private String sline;

	@Column(length=45)
	private String state;

	@Column(length=45)
	private String zip;

	//bi-directional many-to-one association to Family
	@OneToMany(mappedBy="address1", fetch=FetchType.EAGER)
	private Set<Family> families1;

	//bi-directional many-to-one association to Family
	@OneToMany(mappedBy="address2", fetch=FetchType.EAGER)
	private Set<Family> families2;

	//bi-directional many-to-one association to School
	@OneToMany(mappedBy="addressBean", fetch=FetchType.EAGER)
	private Set<School> schools;

	//bi-directional many-to-one association to Worksite
	@OneToMany(mappedBy="addressBean", fetch=FetchType.EAGER)
	private Set<Worksite> worksites;

	//bi-directional many-to-one association to FamilyTransfer
	@OneToMany(mappedBy="address", fetch=FetchType.EAGER)
	private Set<FamilyTransfer> familyTransfers;

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getFline() {
		return this.fline;
	}

	public void setFline(String fline) {
		this.fline = fline;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSline() {
		return this.sline;
	}

	public void setSline(String sline) {
		this.sline = sline;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<Family> getFamilies1() {
		return this.families1;
	}

	public void setFamilies1(Set<Family> families1) {
		this.families1 = families1;
	}

	public Family addFamilies1(Family families1) {
		getFamilies1().add(families1);
		families1.setAddress1(this);

		return families1;
	}

	public Family removeFamilies1(Family families1) {
		getFamilies1().remove(families1);
		families1.setAddress1(null);

		return families1;
	}

	public Set<Family> getFamilies2() {
		return this.families2;
	}

	public void setFamilies2(Set<Family> families2) {
		this.families2 = families2;
	}

	public Family addFamilies2(Family families2) {
		getFamilies2().add(families2);
		families2.setAddress2(this);

		return families2;
	}

	public Family removeFamilies2(Family families2) {
		getFamilies2().remove(families2);
		families2.setAddress2(null);

		return families2;
	}

	public Set<School> getSchools() {
		return this.schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}

	public School addSchool(School school) {
		getSchools().add(school);
		school.setAddressBean(this);

		return school;
	}

	public School removeSchool(School school) {
		getSchools().remove(school);
		school.setAddressBean(null);

		return school;
	}

	public Set<Worksite> getWorksites() {
		return this.worksites;
	}

	public void setWorksites(Set<Worksite> worksites) {
		this.worksites = worksites;
	}

	public Worksite addWorksite(Worksite worksite) {
		getWorksites().add(worksite);
		worksite.setAddressBean(this);

		return worksite;
	}

	public Worksite removeWorksite(Worksite worksite) {
		getWorksites().remove(worksite);
		worksite.setAddressBean(null);

		return worksite;
	}

	public Set<FamilyTransfer> getFamilyTransfers() {
		return this.familyTransfers;
	}

	public void setFamilyTransfers(Set<FamilyTransfer> familyTransfers) {
		this.familyTransfers = familyTransfers;
	}

	public FamilyTransfer addFamilyTransfer(FamilyTransfer familyTransfer) {
		getFamilyTransfers().add(familyTransfer);
		familyTransfer.setAddress(this);

		return familyTransfer;
	}

	public FamilyTransfer removeFamilyTransfer(FamilyTransfer familyTransfer) {
		getFamilyTransfers().remove(familyTransfer);
		familyTransfer.setAddress(null);

		return familyTransfer;
	}

}