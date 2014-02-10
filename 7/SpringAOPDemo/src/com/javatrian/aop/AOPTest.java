package com.javatrian.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AOPTest {

    private AService aService;  
      
    private BServiceImpl bService;  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AOPTest AOPTest = new AOPTest();
		AOPTest.aService = (AService)context.getBean("aService");
		AOPTest.bService = (BServiceImpl)context.getBean("bService");
		AOPTest.testCall()  ;
		
	}
	
    protected String[] getConfigLocations() {  
        String[] configs = new String[] { "/applicationContext.xml"};  
        return configs;  
    }        
 
    public void testCall()  
    {  
        System.out.println("SpringTest JUnit test");  
        aService.fooA("JUnit test fooA");  
        aService.barA();  
        bService.fooB();  
        bService.barB("JUnit test barB",0);  
    }  
      
    public void testThrow()  
    {  
        try {  
            bService.barB("JUnit call barB",1);  
        } catch (IllegalArgumentException e) {  
              
        }  
    }  
      
    public void setAService(AService service) {  
        aService = service;  
    }  
      
    public void setBService(BServiceImpl service) {  
        bService = service;  
    }  

}
