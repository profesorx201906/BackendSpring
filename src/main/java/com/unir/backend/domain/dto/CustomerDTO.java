package com.unir.backend.domain.dto;

public class CustomerDTO {
  private String customerID;
  private String firstName;
  private String lastName;
  private Long phone;
  private String address;
  public String getCustomerID() {
    return customerID;
  }
  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public Long getPhone() {
    return phone;
  }
  public void setPhone(Long phone) {
    this.phone = phone;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  
 
  
}
