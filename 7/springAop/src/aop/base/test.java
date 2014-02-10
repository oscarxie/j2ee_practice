package aop.base;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        IBaseBusiness business = (IBaseBusiness ) context.getBean("businessProxy");
        business.add("猫");
    }
}
