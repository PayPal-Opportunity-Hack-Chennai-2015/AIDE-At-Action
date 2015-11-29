/**
 * 
 */
package org.aea.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Prasad
 *
 */
public class FamilyRegistration {

  private User familyHead;
  
  private Address address;
  
  private List<User> family;
  
  private int work;
  
  private String startDate;
  
  private String category;
  
  private String workName;

  public User getFamilyHead() {
    return familyHead;
  }

  public void setFamilyHead(User familyHead) {
    this.familyHead = familyHead;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<User> getFamily() {
    return family;
  }

  public void setFamily(List<User> family) {
    this.family = family;
  }

  public int getWork() {
    return work;
  }

  public void setWork(int work) {
    this.work = work;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "FamilyRegistration [familyHead=" + familyHead + ", address=" + address + ", family=" + family + ", work="
        + work + ", startDate=" + startDate + ", category=" + category + "]";
  }

  public String getWorkName() {
    return workName;
  }

  public void setWorkName(String workName) {
    this.workName = workName;
  }
  
}
