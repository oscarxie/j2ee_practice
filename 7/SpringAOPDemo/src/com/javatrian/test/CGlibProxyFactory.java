package com.javatrian.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.javatrian.imp.PersonServiceBean;


public class CGlibProxyFactory implements MethodInterceptor {  
    private Object targetObject;  
  
    public Object createProxyIntance(Object targetObject) {  
        this.targetObject = targetObject;  
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObject.getClass());  
        enhancer.setCallback(this); 
        return enhancer.create();  
    }  
  
    public Object intercept(Object proxy, Method method, Object[] args,  
            MethodProxy methodProxy) throws Throwable {  
        PersonServiceBean bean = (PersonServiceBean) this.targetObject;  
        Object result = null;  
        if (bean.getUser() != null) {  
            result = methodProxy.invoke(targetObject, args);  
        }  
        return result;  
    }  
}  
