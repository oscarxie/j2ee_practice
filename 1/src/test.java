public abstract class test {

	class Base {
     int i=8;
      final public	   void f() {
		}
    
		
		public Base(int i) {
			this.i=i;
			System.out.print("Base(i)"+this.i);
		}

		public Base() {
			System.out.print("Base()"+this.i);
		}
	}

	class Child extends Base {
		int i=9;
		public Child(int i) {
			this.i = i;
			System.out.print("Child(i)"+this.i);
		}
		 public	   void f() {
		}
    
		public Child() {
			
			System.out.print("Child()"+this.i);
		}
	}

	abstract  public	static     void f() ;
 
	public static void main(String[] args) {
	
		//Child child =new test().new Child();
	}
}
