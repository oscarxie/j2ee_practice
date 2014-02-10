public class PersonImpl implements Person {
	// 两个成员属性
	private String name;
	private int age;

	// name属性的 setter方法
	public void setName(String name) {
		this.name = name;
	}

	// age属性的setter方法
	public void setAge(int age) {
		this.age = age;
	}

	// info方法，该方法仅仅在控制台打印一行字符串
	public void info() {
		System.out.println("我的名字是:  " + name + " , 今年年龄为:  " + age);
	}

	// run方法，该方法也在控制台打印一行字符串。
	public void run() {
		if (age < 45) {
			System.out.println("我还年轻，奔跑迅速...");
		} else {
			System.out.println("我年老体弱，只能慢跑...");
		}
	}
}