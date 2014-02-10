package com.javatrian.struts2.model;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String loginName;
     private String pwd;
     private String userName;
     private String remark;
     private String test;


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(String loginName, String pwd, String userName) {
        this.loginName = loginName;
        this.pwd = pwd;
        this.userName = userName;
    }
    
    /** full constructor */
    public UserInfo(String loginName, String pwd, String userName, String remark, String test) {
        this.loginName = loginName;
        this.pwd = pwd;
        this.userName = userName;
        this.remark = remark;
        this.test = test;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTest() {
        return this.test;
    }
    
    public void setTest(String test) {
        this.test = test;
    }
   








}