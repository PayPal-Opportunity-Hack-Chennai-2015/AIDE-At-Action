package org.aea.dto;

/**
 * @author Prasad
 *
 */
public class Worksite {

  private String name;
  
  private Address address;
  
  private String owner;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
  
  
}
