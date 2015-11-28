package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assessment_education database table.
 * 
 */
@Entity
@Table(name="assessment_education")
@NamedQuery(name="AssessmentEducation.findAll", query="SELECT a FROM AssessmentEducation a")
public class AssessmentEducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private int books;

	private int entitlements;

	@Column(length=45)
	private String grade;

	private int scholarship;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person")
	private Person personBean;

	//bi-directional many-to-one association to School
	@ManyToOne
	@JoinColumn(name="school")
	private School schoolBean;

	public AssessmentEducation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBooks() {
		return this.books;
	}

	public void setBooks(int books) {
		this.books = books;
	}

	public int getEntitlements() {
		return this.entitlements;
	}

	public void setEntitlements(int entitlements) {
		this.entitlements = entitlements;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getScholarship() {
		return this.scholarship;
	}

	public void setScholarship(int scholarship) {
		this.scholarship = scholarship;
	}

	public Person getPersonBean() {
		return this.personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public School getSchoolBean() {
		return this.schoolBean;
	}

	public void setSchoolBean(School schoolBean) {
		this.schoolBean = schoolBean;
	}

}