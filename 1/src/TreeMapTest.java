import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {

		// 不指定排序器
		TreeMap<String, String> treeMap1 = new TreeMap<String, String>();
		treeMap1.put("2", "1");
		treeMap1.put("b", "1");
		treeMap1.put("1", "1");
		treeMap1.put("a", "1");
		System.out.println("treeMap1=" + treeMap1);

		// 指定排序器
		TreeMap<String, String> treeMap2 = new TreeMap<String, String>(
				new Comparator<String>() {

					/*
					 * int compare(Object o1, Object o2) 返回一个基本类型的整型， 返回负数表示：o1
					 * 小于o2， 返回0 表示：o1和o2相等， 返回正数表示：o1大于o2。
					 */
					public int compare(String o1, String o2) {

						// 指定排序器按照降序排列
						return o2.compareTo(o1);
					}
				});
		treeMap2.put("2", "1");
		treeMap2.put("b", "1");
		treeMap2.put("1", "1");
		treeMap2.put("a", "1");
		System.out.println("treeMap2=" + treeMap2);
	}

}
