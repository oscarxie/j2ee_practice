package tutorial;

import com.opensymphony.xwork2.ActionSupport;
public class Action1 extends ActionSupport{
 private static final long serialVersionUID = 1L;
 String msg = "";
 public String getMsg() {
 return msg;
 }
 public void setMsg(String msg) {
  this.msg = msg+"1!";
  System.out.println("Action1.setter;");
  System.out.println(msg);
 }
 public String execute(){
 return SUCCESS;
 }
}