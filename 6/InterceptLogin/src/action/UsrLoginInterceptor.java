package action;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import action.LoginAction;

public class UsrLoginInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation arg0) throws Exception {
         // 判断是否请求为登录界面(login),如果是则不拦截
        if (LoginAction.class == arg0.getAction().getClass())
             return arg0.invoke();
        
       // 如果是请求其他页面，进行拦截
         Map map = arg0.getInvocationContext().getSession();
        String[] users = (String[])arg0.getInvocationContext().getParameters().get("username");
        String username = users[0];
         if (null == map.get(username))
             return Action.LOGIN;
 
         return arg0.invoke();
     }
}