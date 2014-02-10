import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib动态代理
 * 
 * around advice
 * 
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     * 
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
       
        // 回调方法
        enhancer.setCallback(this);
      
      
        // 创建代理对象
        return enhancer.create();
    }

    public Object getInstance(Class c, Class[] clazz, Object[] obj ) {
       
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);   
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
      return  enhancer.create(clazz,obj);
    
    }
    
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("事物开始");
        result = methodProxy.invokeSuper(proxy, args);
        System.out.println("事物结束");
        return result;
    }

    
    public static void main(String[] args) {
    	PeopleTalk target = new PeopleTalk();
    	target.setName("name");
    	target.setAge("18");
        PeopleTalk peopleTalk = (PeopleTalk) new CglibProxy().getInstance(target);
        peopleTalk.talk("业务方法");
        
        Class[] clazz = new Class[]{String.class,String.class};
        Object[] obj = new  String[]{"name","18"};
        
        peopleTalk = (PeopleTalk) new CglibProxy().getInstance(PeopleTalk.class,clazz,obj);
        peopleTalk.talk("业务方法");
       
    }
}