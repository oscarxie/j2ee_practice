package tutorial;

import com.opensymphony.xwork2.ActionSupport;
public class Action2 extends ActionSupport{
 private static final long serialVersionUID = 1L;
 String msg = "";
 public String getMsg() {
 return msg;
 }
 public void setMsg(String msg) {
  this.msg = msg+"2!";
  System.out.println("Action2.setter;");
  System.out.println(msg);
 }
 public String execute(){
 return SUCCESS;
 }
}