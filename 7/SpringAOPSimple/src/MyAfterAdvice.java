import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice
{
 //实现AfterReturningAdvice接口必须实现afterReturning方法，该方法将在目标方法
 //调用结束后，自动被调用。
     public void afterReturning(Object returnValue, Method m, Object[] args, Object target)throws Throwable
 {
  System.out.println("方法调用结束...");
System.out.println("目标方法的返回值是 : " + returnValue);
  System.out.println("目标方法是 : " + m);
  System.out.println("目标方法的参数是 : " + args);
  System.out.println("目标对象是 : " + target);
    }
}