/**
 * 
 */
package org.aea.dto;

import java.util.Date;

/**
 * @author Prasad
 *
 */
public class User {

  private String name;
  
  private int age;
  
  private String dob;
  
  private int gender;
  
  private String relation;
  
  private int enrolledSchol;
  
  private int schoolId;
  
  private String standard;
  
  private int isPregrant;
  
  private String expectedDelivery;
  
  private int handicaped;
  
  private int islactating;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public int getEnrolledSchol() {
    return enrolledSchol;
  }

  public void setEnrolledSchol(int enrolledSchol) {
    this.enrolledSchol = enrolledSchol;
  }

  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }

  public int getIsPregrant() {
    return isPregrant;
  }

  public void setIsPregrant(int isPregrant) {
    this.isPregrant = isPregrant;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getExpectedDelivery() {
    return expectedDelivery;
  }

  public void setExpectedDelivery(String expectedDelivery) {
    this.expectedDelivery = expectedDelivery;
  }

  public int getHandicaped() {
    return handicaped;
  }

  public void setHandicaped(int handicaped) {
    this.handicaped = handicaped;
  }

  public int getIslactating() {
    return islactating;
  }

  public void setIslactating(int islactating) {
    this.islactating = islactating;
  }

  public int getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(int schoolId) {
    this.schoolId = schoolId;
  }

  @Override
  public String toString() {
    return "User [name=" + name + ", age=" + age + ", dob=" + dob + ", gender=" + gender + ", relation=" + relation
        + ", enrolledSchol=" + enrolledSchol + ", standard=" + standard + ", isPregrant=" + isPregrant
        + ", expectedDelivery=" + expectedDelivery + ", handicaped=" + handicaped + ", islactating=" + islactating
        + "]";
  }
  
  
}
