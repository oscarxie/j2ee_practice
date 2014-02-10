package action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.UserExist;

public class LoginAction extends ActionSupport {
     private String username;
     private String password;
 
     public String getUsername() {
         return username;
     }
 
     public void setUsername(String username) {
         this.username = username;
     }
 
     public String getPassword() {
         return password;
     }
 
     public void setPassword(String password) {
         this.password = password;
     }

     public String execute() throws Exception {
         // 设置session
         Map map = ActionContext.getContext().getSession();
         // 如果用户存在
         if (UserExist.isExist(username, password)) {
             if (null == map.get("username"))
                 map.put( username,password);
             return SUCCESS;
         }
 
         return LOGIN;
     }
}