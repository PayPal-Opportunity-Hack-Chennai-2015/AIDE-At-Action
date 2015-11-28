package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the assessment database table.
 * 
 */
@Entity
@Table(name="assessment")
@NamedQuery(name="Assessment.findAll", query="SELECT a FROM Assessment a")
public class Assessment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="assess_date")
	private Date assessDate;

	@Column(name="marriage_scheme")
	private int marriageScheme;

	@Column(name="meternal_benifits")
	private int meternalBenifits;

	private int ngo;

	private String notes;

	@Column(name="oldage_pesion")
	private int oldagePesion;

	private int ration;

	@Column(name="widow_pension")
	private int widowPension;

	//bi-directional many-to-one association to Family
	@ManyToOne
	@JoinColumn(name="family")
	private Family familyBean;

	//bi-directional many-to-one association to Worksite
	@ManyToOne
	@JoinColumn(name="worksite")
	private Worksite worksiteBean;

	//bi-directional many-to-one association to AssessmentHealth
	@OneToMany(mappedBy="assessmentBean", fetch=FetchType.EAGER)
	private Set<AssessmentHealth> assessmentHealths;

	public Assessment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAssessDate() {
		return this.assessDate;
	}

	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}

	public int getMarriageScheme() {
		return this.marriageScheme;
	}

	public void setMarriageScheme(int marriageScheme) {
		this.marriageScheme = marriageScheme;
	}

	public int getMeternalBenifits() {
		return this.meternalBenifits;
	}

	public void setMeternalBenifits(int meternalBenifits) {
		this.meternalBenifits = meternalBenifits;
	}

	public int getNgo() {
		return this.ngo;
	}

	public void setNgo(int ngo) {
		this.ngo = ngo;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getOldagePesion() {
		return this.oldagePesion;
	}

	public void setOldagePesion(int oldagePesion) {
		this.oldagePesion = oldagePesion;
	}

	public int getRation() {
		return this.ration;
	}

	public void setRation(int ration) {
		this.ration = ration;
	}

	public int getWidowPension() {
		return this.widowPension;
	}

	public void setWidowPension(int widowPension) {
		this.widowPension = widowPension;
	}

	public Family getFamilyBean() {
		return this.familyBean;
	}

	public void setFamilyBean(Family familyBean) {
		this.familyBean = familyBean;
	}

	public Worksite getWorksiteBean() {
		return this.worksiteBean;
	}

	public void setWorksiteBean(Worksite worksiteBean) {
		this.worksiteBean = worksiteBean;
	}

	public Set<AssessmentHealth> getAssessmentHealths() {
		return this.assessmentHealths;
	}

	public void setAssessmentHealths(Set<AssessmentHealth> assessmentHealths) {
		this.assessmentHealths = assessmentHealths;
	}

	public AssessmentHealth addAssessmentHealth(AssessmentHealth assessmentHealth) {
		getAssessmentHealths().add(assessmentHealth);
		assessmentHealth.setAssessmentBean(this);

		return assessmentHealth;
	}

	public AssessmentHealth removeAssessmentHealth(AssessmentHealth assessmentHealth) {
		getAssessmentHealths().remove(assessmentHealth);
		assessmentHealth.setAssessmentBean(null);

		return assessmentHealth;
	}

}