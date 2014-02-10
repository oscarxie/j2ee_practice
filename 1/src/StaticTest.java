

public class StaticTest {
	private static String name = "javaJohn";
	private String id = "X001";

	static class Person {
		private String address = "swjtu,chenDu,China";
		public String mail = "josserchai@yahoo.com";// 内部类公有成员

		public void display() {
			// System.out.println(id);//不能直接访问外部类的非静态成员
			System.out.println(name);// 只能直接访问外部类的静态成员
			System.out.println("Inner" + address); // 访问本内部类成员
		}
	}

	public void printInfo() {
		Person person = new Person();
		person.display();
		
		//System.out.println(mail);//不可访问
		// System.out.println(address);//不可访问
		System.out.println(person.address);// 可以访问内部类的私有成员
		System.out.println(person.mail);// 可以访问内部类的公有成员
	}

	public static void main(String[] args) {
		StaticTest staticTest = new StaticTest();
		staticTest.printInfo();
	}
}
