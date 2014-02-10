package com.meixin.beans;

public class User 
{ 
  private Long userID; 
  private String userName; 
  private String password; 
  private Profile profile; 
    
  public Long getUserID() 
  { 
    return userID; 
  } 
  public void setUserID(Long userID) 
  { 
    this.userID = userID; 
  } 
  public String getUserName() 
  { 
    return userName; 
  } 
  public void setUserName(String userName) 
  { 
    this.userName = userName; 
  } 
  public String getPassword() 
  { 
    return password; 
  } 
  public void setPassword(String password) 
  { 
    this.password = password; 
  } 
  public Profile getProfile() 
  { 
    return profile; 
  } 
  public void setProfile(Profile profile) 
  { 
    this.profile = profile; 
  } 
    
} 
