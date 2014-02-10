package action;

import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.Interceptor;  
  
public class MyInterceptor implements Interceptor {  
  
    public void destroy() {  
  
        System.out.println("destroy");  
    }  
  
    public void init() {                 
  
                       System.out.println("拦截器已经被加载");  
    }  
  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
                                     System.out.println("调用intercept方法");  
                                       
                                     String result = invocation.invoke();       // invocation.invoke（）方法检查是否还有拦截器 有的话继续调用余下的拦截器 没有了  执行action的业务逻辑  
        return result;  
    }  
  
}  