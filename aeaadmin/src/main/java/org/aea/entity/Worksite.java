package org.aea.entity;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the worksite database table.
 * 
 */
@Entity
@Table(name = "worksite")
@NamedQuery(name = "Worksite.findAll", query = "SELECT w FROM Worksite w")
public class Worksite implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  @Column(length = 45)
  private String contact;

  @Column(length = 45)
  private String owner;

  @Column(length = 45)
  private String name;

  @Column(length = 45)
  private String type;

  @Column(length = 45)
  private String worksitecol;

  // bi-directional many-to-one association to Assessment
  @OneToMany(mappedBy = "worksiteBean", fetch = FetchType.EAGER)
  private Set<Assessment> assessments;

  // bi-directional many-to-one association to Family
  @OneToMany(mappedBy = "worksiteBean", fetch = FetchType.EAGER)
  private Set<Family> families;

  // bi-directional many-to-one association to Address
  @ManyToOne
  @JoinColumn(name = "address")
  private Address addressBean;

  // bi-directional many-to-one association to FamilyTransfer
  @OneToMany(mappedBy = "worksite1", fetch = FetchType.EAGER)
  private Set<FamilyTransfer> familyTransfers1;

  // bi-directional many-to-one association to FamilyTransfer
  @OneToMany(mappedBy = "worksite2", fetch = FetchType.EAGER)
  private Set<FamilyTransfer> familyTransfers2;

  public Worksite() {}

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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getWorksitecol() {
    return this.worksitecol;
  }

  public void setWorksitecol(String worksitecol) {
    this.worksitecol = worksitecol;
  }

  public Set<Assessment> getAssessments() {
    return this.assessments;
  }

  public void setAssessments(Set<Assessment> assessments) {
    this.assessments = assessments;
  }

  public Assessment addAssessment(Assessment assessment) {
    getAssessments().add(assessment);
    assessment.setWorksiteBean(this);

    return assessment;
  }

  public Assessment removeAssessment(Assessment assessment) {
    getAssessments().remove(assessment);
    assessment.setWorksiteBean(null);

    return assessment;
  }

  public Set<Family> getFamilies() {
    return this.families;
  }

  public void setFamilies(Set<Family> families) {
    this.families = families;
  }

  public Family addFamily(Family family) {
    getFamilies().add(family);
    family.setWorksiteBean(this);

    return family;
  }

  public Family removeFamily(Family family) {
    getFamilies().remove(family);
    family.setWorksiteBean(null);

    return family;
  }

  public Address getAddressBean() {
    return this.addressBean;
  }

  public void setAddressBean(Address addressBean) {
    this.addressBean = addressBean;
  }

  public Set<FamilyTransfer> getFamilyTransfers1() {
    return this.familyTransfers1;
  }

  public void setFamilyTransfers1(Set<FamilyTransfer> familyTransfers1) {
    this.familyTransfers1 = familyTransfers1;
  }

  public FamilyTransfer addFamilyTransfers1(FamilyTransfer familyTransfers1) {
    getFamilyTransfers1().add(familyTransfers1);
    familyTransfers1.setWorksite1(this);

    return familyTransfers1;
  }

  public FamilyTransfer removeFamilyTransfers1(FamilyTransfer familyTransfers1) {
    getFamilyTransfers1().remove(familyTransfers1);
    familyTransfers1.setWorksite1(null);

    return familyTransfers1;
  }

  public Set<FamilyTransfer> getFamilyTransfers2() {
    return this.familyTransfers2;
  }

  public void setFamilyTransfers2(Set<FamilyTransfer> familyTransfers2) {
    this.familyTransfers2 = familyTransfers2;
  }

  public FamilyTransfer addFamilyTransfers2(FamilyTransfer familyTransfers2) {
    getFamilyTransfers2().add(familyTransfers2);
    familyTransfers2.setWorksite2(this);

    return familyTransfers2;
  }

  public FamilyTransfer removeFamilyTransfers2(FamilyTransfer familyTransfers2) {
    getFamilyTransfers2().remove(familyTransfers2);
    familyTransfers2.setWorksite2(null);

    return familyTransfers2;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("contact", contact)
            .add("owner", owner)
            .add("name", name)
            .add("type", type)
            .add("worksitecol", worksitecol)
            .add("assessments", assessments)
            .add("families", families)
            .add("addressBean", addressBean)
            .add("familyTransfers1", familyTransfers1)
            .add("familyTransfers2", familyTransfers2)
            .toString();
  }
}
