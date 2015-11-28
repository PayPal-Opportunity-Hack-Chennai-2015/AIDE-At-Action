package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ngo database table.
 * 
 */
@Entity
@Table(name = "ngo")
@NamedQuery(name = "Ngo.findAll", query = "SELECT n FROM Ngo n")
public class Ngo implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  private int address;

  private String email;

  private String password;

  @Column(length = 255)
  private String logo;

  @Column(length = 45)
  private String name;

  // bi-directional many-to-one association to FamilyTransfer
  @OneToMany(mappedBy = "ngo1", fetch = FetchType.EAGER)
  private Set<FamilyTransfer> familyTransfers1;

  // bi-directional many-to-one association to FamilyTransfer
  @OneToMany(mappedBy = "ngo2", fetch = FetchType.EAGER)
  private Set<FamilyTransfer> familyTransfers2;

  public Ngo() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAddress() {
    return this.address;
  }

  public void setAddress(int address) {
    this.address = address;
  }

  public String getLogo() {
    return this.logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<FamilyTransfer> getFamilyTransfers1() {
    return this.familyTransfers1;
  }

  public void setFamilyTransfers1(Set<FamilyTransfer> familyTransfers1) {
    this.familyTransfers1 = familyTransfers1;
  }

  public FamilyTransfer addFamilyTransfers1(FamilyTransfer familyTransfers1) {
    getFamilyTransfers1().add(familyTransfers1);
    familyTransfers1.setNgo1(this);

    return familyTransfers1;
  }

  public FamilyTransfer removeFamilyTransfers1(FamilyTransfer familyTransfers1) {
    getFamilyTransfers1().remove(familyTransfers1);
    familyTransfers1.setNgo1(null);

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
    familyTransfers2.setNgo2(this);

    return familyTransfers2;
  }

  public FamilyTransfer removeFamilyTransfers2(FamilyTransfer familyTransfers2) {
    getFamilyTransfers2().remove(familyTransfers2);
    familyTransfers2.setNgo2(null);

    return familyTransfers2;
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

}
