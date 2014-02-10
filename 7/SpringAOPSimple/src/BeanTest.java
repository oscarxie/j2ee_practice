import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class BeanTest
{
    public static void main(String[] args)throws Exception
{
  //创建Spring容器
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/ApplicationContext.xml");
  //获取代理对象
  Person p = (Person)ctx.getBean("person");
  //执行info方法
  p.info();
         System.out.println("===========================================");
  //执行run方法
  p.run();
    }
}
