package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the school database table.
 * 
 */
@Entity
@Table(name="school")
@NamedQuery(name="School.findAll", query="SELECT s FROM School s")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String contact;

	//bi-directional many-to-one association to AssessmentEducation
	@OneToMany(mappedBy="schoolBean", fetch=FetchType.EAGER)
	private Set<AssessmentEducation> assessmentEducations;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address")
	private Address addressBean;

	public School() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Set<AssessmentEducation> getAssessmentEducations() {
		return this.assessmentEducations;
	}

	public void setAssessmentEducations(Set<AssessmentEducation> assessmentEducations) {
		this.assessmentEducations = assessmentEducations;
	}

	public AssessmentEducation addAssessmentEducation(AssessmentEducation assessmentEducation) {
		getAssessmentEducations().add(assessmentEducation);
		assessmentEducation.setSchoolBean(this);

		return assessmentEducation;
	}

	public AssessmentEducation removeAssessmentEducation(AssessmentEducation assessmentEducation) {
		getAssessmentEducations().remove(assessmentEducation);
		assessmentEducation.setSchoolBean(null);

		return assessmentEducation;
	}

	public Address getAddressBean() {
		return this.addressBean;
	}

	public void setAddressBean(Address addressBean) {
		this.addressBean = addressBean;
	}

}