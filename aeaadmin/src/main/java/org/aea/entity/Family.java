package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the family database table.
 * 
 */
@Entity
@Table(name = "family")
@NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f")
public class Family implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  @Column(name = "family_id", length = 45)
  private String familyId;

  private String notes;

  private String category;

  @Column(name = "prinary_ngo")
  private int prinaryNgo;

  @Temporal(TemporalType.DATE)
  private Date registration;

  // bi-directional many-to-one association to Assessment
  @OneToMany(mappedBy = "familyBean", fetch = FetchType.EAGER)
  private Set<Assessment> assessments;

  // bi-directional many-to-one association to Address
  @ManyToOne
  @JoinColumn(name = "current_address")
  private Address address1;

  // bi-directional many-to-one association to Address
  @ManyToOne
  @JoinColumn(name = "primary_address")
  private Address address2;

  // bi-directional many-to-one association to Person
  @ManyToOne
  @JoinColumn(name = "family_head")
  private Person person;

  // bi-directional many-to-one association to Worksite
  @ManyToOne
  @JoinColumn(name = "worksite")
  private Worksite worksiteBean;

  // bi-directional many-to-one association to FamilyTransfer
  @OneToMany(mappedBy = "familyBean", fetch = FetchType.EAGER)
  private Set<FamilyTransfer> familyTransfers;

  public Family() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFamilyId() {
    return this.familyId;
  }

  public void setFamilyId(String familyId) {
    this.familyId = familyId;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public int getPrinaryNgo() {
    return this.prinaryNgo;
  }

  public void setPrinaryNgo(int prinaryNgo) {
    this.prinaryNgo = prinaryNgo;
  }

  public Date getRegistration() {
    return this.registration;
  }

  public void setRegistration(Date registration) {
    this.registration = registration;
  }

  public Set<Assessment> getAssessments() {
    return this.assessments;
  }

  public void setAssessments(Set<Assessment> assessments) {
    this.assessments = assessments;
  }

  public Assessment addAssessment(Assessment assessment) {
    getAssessments().add(assessment);
    assessment.setFamilyBean(this);

    return assessment;
  }

  public Assessment removeAssessment(Assessment assessment) {
    getAssessments().remove(assessment);
    assessment.setFamilyBean(null);

    return assessment;
  }

  public Address getAddress1() {
    return this.address1;
  }

  public void setAddress1(Address address1) {
    this.address1 = address1;
  }

  public Address getAddress2() {
    return this.address2;
  }

  public void setAddress2(Address address2) {
    this.address2 = address2;
  }

  public Person getPerson() {
    return this.person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Worksite getWorksiteBean() {
    return this.worksiteBean;
  }

  public void setWorksiteBean(Worksite worksiteBean) {
    this.worksiteBean = worksiteBean;
  }

  public Set<FamilyTransfer> getFamilyTransfers() {
    return this.familyTransfers;
  }

  public void setFamilyTransfers(Set<FamilyTransfer> familyTransfers) {
    this.familyTransfers = familyTransfers;
  }

  public FamilyTransfer addFamilyTransfer(FamilyTransfer familyTransfer) {
    getFamilyTransfers().add(familyTransfer);
    familyTransfer.setFamilyBean(this);

    return familyTransfer;
  }

  public FamilyTransfer removeFamilyTransfer(FamilyTransfer familyTransfer) {
    getFamilyTransfers().remove(familyTransfer);
    familyTransfer.setFamilyBean(null);

    return familyTransfer;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


}
