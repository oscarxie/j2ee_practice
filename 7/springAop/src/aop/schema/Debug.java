package aop.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.schema.AspectBusiness;

public class Debug {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("schema_aop.xml");
        AspectBusiness business = (AspectBusiness) context.getBean("aspectBusiness");
        business.delete("猫");
    }

}