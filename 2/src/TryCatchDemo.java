


public class TryCatchDemo {
	public static void main(String[] args) {
		int[] ints = new int[] { 1, 2, 3, 4 };
		System.out.println("before");
		try {
			System.out.println(ints[4]);
			System.out.println("after");// 发生异常以后，后面的代码不能被执行
		} catch (IndexOutOfBoundsException e) {
			System.out.println("array out of range");
		}
		System.out.println("at last");
	}

}
