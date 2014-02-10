package action;

import com.opensymphony.xwork2.ActionSupport;
public class SayHelloAction extends ActionSupport {
     String username;
 
     public String getUsername() {
         return username;
     }
 
     public void setUsername(String username) {
         this.username = username;
     }

     public String execute() throws Exception {
         return SUCCESS;
     }
}