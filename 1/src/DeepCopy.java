import java.util.ArrayList;

class MyStudent implements Cloneable {
	public int id;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class DeepCopy {
	public static void main(String[] args) {
		MyStudent s = new MyStudent();
		s.id = 1;
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add(s);

		// Ç³¿½±´
		// a2.add(a1.get(0));

		// ((MyStudent) (a1.get(0))).id = 2;
		// System.out.println(((MyStudent) (a2.get(0))).id);

		// resume to 1
		// ((MyStudent) (a1.get(0))).id = 1;

		// System.out.println(((MyStudent) (a1.get(0))).id);

		// deep copy
		try {
			a2.add(((MyStudent) a1.get(0)).clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println(a1.get(0) == a2.get(0));

		((MyStudent) (a1.get(0))).id = 2;
		System.out.println(((MyStudent) (a2.get(0))).id);
	}
}
