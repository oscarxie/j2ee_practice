

import java.lang.reflect.Method;

public class CallGetAndSet {
	public static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setter(Object obj, String att, Object value,
            Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		 Class<?> demo = null;
	        Object obj=null;
	        try {
	            demo = Class.forName("class3.Person");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        try{
	         obj=demo.newInstance();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	        setter(obj,"Name","Tom",String.class);
	        getter(obj,"Name");

	}

}
