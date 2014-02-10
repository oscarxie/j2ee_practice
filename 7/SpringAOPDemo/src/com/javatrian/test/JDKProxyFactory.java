package com.javatrian.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.javatrian.imp.PersonServiceBean;


public class JDKProxyFactory implements InvocationHandler {  
    private Object targetObject;  
  
    public Object createProxyIntance(Object targetObject) {  
        this.targetObject = targetObject;  

        return Proxy.newProxyInstance(this.targetObject.getClass()  
                .getClassLoader(),  
                this.targetObject.getClass().getInterfaces(), this);  
    }  
  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable { 
        PersonServiceBean bean = (PersonServiceBean) this.targetObject;  
        Object result = null;  
        if (bean.getUser() != null) {  
            try {  
                result = method.invoke(targetObject, args);   
            } catch (RuntimeException e) {  
                
            } finally {  
            }  
        }  
        return result;  
    }  
}  