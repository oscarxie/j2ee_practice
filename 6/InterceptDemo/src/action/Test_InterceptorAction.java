package action;

import com.opensymphony.xwork2.ActionSupport;  

public class Test_InterceptorAction extends ActionSupport    
{  
      
    private String username;  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
      
      
    public String execute() throws Exception  
    {  
        return SUCCESS;  
    }  
      
    public String test() throws Exception  
    {  
          
        System.out.println("此时所有拦截器完毕，已经调用了action中的test方法");  
        return SUCCESS;  
    }  
  
}  