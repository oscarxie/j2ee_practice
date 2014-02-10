/**
 * 外部类，不能声明为 static
 * 
 * 
 * 
 */
public class OutClass {

    private int ab = 1;
    private static int sab = 2;

    /**
     * 普通内部类
     */
    public class NormalInnerClass {

       // private static int age1 = 22;
        private int age = 22; // 不能声明为static

        public NormalInnerClass() {
            // 可以访问外部类静态与非静态成员
            System.out.println(ab);
            System.out.println(sab);
        }
    }

    /**
     * 静态内部类
     */
    public static class StaticInnerClass {
        // 定义静态与非静态成员都是可以的
        private static int age = 22;
        private int age2 = 22;

        private void echo() {
   //          System.out.println(ab);
            System.out.println(sab);// 只能访问外部类的静态成员
        }
    }
    
    /**
     * 普通方法
     */
    public void method() {
        StaticInnerClass sic = new StaticInnerClass();
        NormalInnerClass nic = new NormalInnerClass();
    }

    /**
     * Main
     */
    public static void main(String[] args) {
        // 在静态方法中，只能访问静态成员，静态内部类
     //   NormalInnerClass nic = new NormalInnerClass();
        StaticInnerClass sic = new StaticInnerClass();
        
    }
}