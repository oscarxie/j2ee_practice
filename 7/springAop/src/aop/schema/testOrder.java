package aop.schema;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class testOrder {
	public static void main(String[] args) {
		  ApplicationContext context = new ClassPathXmlApplicationContext("schema_aop_order.xml");
	        AspectBusiness business = (AspectBusiness) context.getBean("aspectBusiness");
	        business.delete("猫");
    }
}
