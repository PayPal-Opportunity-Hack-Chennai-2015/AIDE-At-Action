package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private int adoloscent;

	private int age;

	private int dissability;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(length=45)
	private String fname;

	private int gender;

	@Column(length=45)
	private String lname;

	@Column(length=255)
	private String notes;

	private int pregnencay;

	@Column(length=45)
	private String title;

	//bi-directional many-to-one association to AssessmentEducation
	@OneToMany(mappedBy="personBean", fetch=FetchType.EAGER)
	private Set<AssessmentEducation> assessmentEducations;

	//bi-directional many-to-one association to Family
	@OneToMany(mappedBy="person", fetch=FetchType.EAGER)
	private Set<Family> families;

	//bi-directional many-to-one association to SchoolTransfer
	@OneToMany(mappedBy="personBean", fetch=FetchType.EAGER)
	private Set<SchoolTransfer> schoolTransfers;

	public Person() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdoloscent() {
		return this.adoloscent;
	}

	public void setAdoloscent(int adoloscent) {
		this.adoloscent = adoloscent;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDissability() {
		return this.dissability;
	}

	public void setDissability(int dissability) {
		this.dissability = dissability;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPregnencay() {
		return this.pregnencay;
	}

	public void setPregnencay(int pregnencay) {
		this.pregnencay = pregnencay;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AssessmentEducation> getAssessmentEducations() {
		return this.assessmentEducations;
	}

	public void setAssessmentEducations(Set<AssessmentEducation> assessmentEducations) {
		this.assessmentEducations = assessmentEducations;
	}

	public AssessmentEducation addAssessmentEducation(AssessmentEducation assessmentEducation) {
		getAssessmentEducations().add(assessmentEducation);
		assessmentEducation.setPersonBean(this);

		return assessmentEducation;
	}

	public AssessmentEducation removeAssessmentEducation(AssessmentEducation assessmentEducation) {
		getAssessmentEducations().remove(assessmentEducation);
		assessmentEducation.setPersonBean(null);

		return assessmentEducation;
	}

	public Set<Family> getFamilies() {
		return this.families;
	}

	public void setFamilies(Set<Family> families) {
		this.families = families;
	}

	public Family addFamily(Family family) {
		getFamilies().add(family);
		family.setPerson(this);

		return family;
	}

	public Family removeFamily(Family family) {
		getFamilies().remove(family);
		family.setPerson(null);

		return family;
	}

	public Set<SchoolTransfer> getSchoolTransfers() {
		return this.schoolTransfers;
	}

	public void setSchoolTransfers(Set<SchoolTransfer> schoolTransfers) {
		this.schoolTransfers = schoolTransfers;
	}

	public SchoolTransfer addSchoolTransfer(SchoolTransfer schoolTransfer) {
		getSchoolTransfers().add(schoolTransfer);
		schoolTransfer.setPersonBean(this);

		return schoolTransfer;
	}

	public SchoolTransfer removeSchoolTransfer(SchoolTransfer schoolTransfer) {
		getSchoolTransfers().remove(schoolTransfer);
		schoolTransfer.setPersonBean(null);

		return schoolTransfer;
	}

}