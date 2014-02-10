package com.meixin.beans;

import java.util.Date; 
import java.util.Map; 
public class Profile 
{ 
  private String email; 
  private Date birthday; 
  private Address[] address; 
  private Map<String, String> phone; 
  public String getEmail() 
  { 
    return email; 
  } 
  public void setEmail(String email) 
  { 
    this.email = email; 
  } 
  public Date getBirthday() 
  { 
    return birthday; 
  } 
  public void setBirthday(Date birthday) 
  { 
    this.birthday = birthday; 
  } 
  public Address[] getAddress() 
  { 
    return address; 
  } 
  public void setAddress(Address[] address) 
  { 
    this.address = address; 
  } 
  public Map<String, String> getPhone() 
  { 
    return phone; 
  } 
  public void setPhone(Map<String, String> phone) 
  { 
    this.phone = phone; 
  } 
} 
