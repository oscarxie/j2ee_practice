package aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.annotation.AspectBusiness;

public class Debug {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation_aop.xml");
        AspectBusiness business = (AspectBusiness) context.getBean("aspectBusiness");
        business.add("猫");
    }

}