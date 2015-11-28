package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assessment_health database table.
 * 
 */
@Entity
@Table(name="assessment_health")
@NamedQuery(name="AssessmentHealth.findAll", query="SELECT a FROM AssessmentHealth a")
public class AssessmentHealth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="activity_taken")
	private int activityTaken;

	@Column(name="adoloscent_meetings")
	private int adoloscentMeetings;

	private int anemic;

	private int cclc;

	private int cleanwater;

	private int housing;

	private int immunization;

	@Column(name="mothers_comitte")
	private int mothersComitte;

	private int nutrition;

	private int person;

	private int playbenifits;

	private int ration;

	@Column(name="resource_mobilization")
	private int resourceMobilization;

	private int sanitation;

	//bi-directional many-to-one association to Assessment
	@ManyToOne
	@JoinColumn(name="assessment")
	private Assessment assessmentBean;

	public AssessmentHealth() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivityTaken() {
		return this.activityTaken;
	}

	public void setActivityTaken(int activityTaken) {
		this.activityTaken = activityTaken;
	}

	public int getAdoloscentMeetings() {
		return this.adoloscentMeetings;
	}

	public void setAdoloscentMeetings(int adoloscentMeetings) {
		this.adoloscentMeetings = adoloscentMeetings;
	}

	public int getAnemic() {
		return this.anemic;
	}

	public void setAnemic(int anemic) {
		this.anemic = anemic;
	}

	public int getCclc() {
		return this.cclc;
	}

	public void setCclc(int cclc) {
		this.cclc = cclc;
	}

	public int getCleanwater() {
		return this.cleanwater;
	}

	public void setCleanwater(int cleanwater) {
		this.cleanwater = cleanwater;
	}

	public int getHousing() {
		return this.housing;
	}

	public void setHousing(int housing) {
		this.housing = housing;
	}

	public int getImmunization() {
		return this.immunization;
	}

	public void setImmunization(int immunization) {
		this.immunization = immunization;
	}

	public int getMothersComitte() {
		return this.mothersComitte;
	}

	public void setMothersComitte(int mothersComitte) {
		this.mothersComitte = mothersComitte;
	}

	public int getNutrition() {
		return this.nutrition;
	}

	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}

	public int getPerson() {
		return this.person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getPlaybenifits() {
		return this.playbenifits;
	}

	public void setPlaybenifits(int playbenifits) {
		this.playbenifits = playbenifits;
	}

	public int getRation() {
		return this.ration;
	}

	public void setRation(int ration) {
		this.ration = ration;
	}

	public int getResourceMobilization() {
		return this.resourceMobilization;
	}

	public void setResourceMobilization(int resourceMobilization) {
		this.resourceMobilization = resourceMobilization;
	}

	public int getSanitation() {
		return this.sanitation;
	}

	public void setSanitation(int sanitation) {
		this.sanitation = sanitation;
	}

	public Assessment getAssessmentBean() {
		return this.assessmentBean;
	}

	public void setAssessmentBean(Assessment assessmentBean) {
		this.assessmentBean = assessmentBean;
	}

}