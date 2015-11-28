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
  
  private Worksite work;
  
  private Date startDate;
  
  private String category;

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

  public Worksite getWork() {
    return work;
  }

  public void setWork(Worksite work) {
    this.work = work;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
  
  
}
