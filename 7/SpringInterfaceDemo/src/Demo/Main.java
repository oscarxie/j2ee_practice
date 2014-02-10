package Demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

        Resource res = new ClassPathResource("Demo/bean.xml");
        BeanFactory ft = new XmlBeanFactory(res);

        Hello h = (Hello) ft.getBean("hello");

        Random r1 = h.getRandom();
        Random r2 = h.getRandom();
        System.out.println("没有采用Lookup方法注入：");
        System.out.println("Random 的两个实例指向同一个引用：" + (r1 == r2));
        r1.printRandom();
        r2.printRandom();

        Random r3 = h.createRandom();
        Random r4 = h.createRandom();
        System.out.println("采用Lookup方法注入：");
        System.out.println("Random 的两个实例指向同一个引用：" + (r3 == r4));
        r3.printRandom();
        r4.printRandom();
        
        //不使用抽象类
        Random r5=h.createRandom1();
        Random r6=h.createRandom1();
        System.out.println("没有采用Lookup方法注入：");
        System.out.println("Random 的两个实例指向同一个引用：" + (r5 == r6));
        r5.printRandom();
        r6.printRandom();

    }

}  