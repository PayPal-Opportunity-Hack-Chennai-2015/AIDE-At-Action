/**
 * 
 */
package org.aea.dto;

/**
 * @author Prasad
 *
 */
public class Address {

  private String village;

  private String gp;

  private String block;

  private String state;

  private String pin;

  private String contact;

  private String district;

  public String getVillage() {
    return village;
  }

  public void setVillage(String village) {
    this.village = village;
  }

  public String getGp() {
    return gp;
  }

  public void setGp(String gp) {
    this.gp = gp;
  }

  public String getBlock() {
    return block;
  }

  public void setBlock(String block) {
    this.block = block;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  @Override
  public String toString() {
    return "Address [village=" + village + ", gp=" + gp + ", block=" + block + ", state=" + state + ", pin=" + pin
        + ", contact=" + contact + ", district=" + district + "]";
  }


}
