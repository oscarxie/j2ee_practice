import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyAroundInterceptor implements MethodInterceptor
{
 //实现MethodInterceptor接口必须实现invoke方法
     public Object invoke(MethodInvocation invocation) throws Throwable
 {
  //调用目标方法之前执行的动作
         System.out.println("调用方法之前: invocation对象：[" + invocation + "]");
  //调用目标方法
         Object rval = invocation.proceed();
  //调用目标方法之后执行的动作
         System.out.println("调用结束...");
         return rval;
    }
}