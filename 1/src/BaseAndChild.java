import java.io.IOException;
import java.util.concurrent.TimeoutException;

class Base {
	void f() throws TimeoutException,IOException {
	}
}

class Child extends Base {
	
	 void f(int i) //ok
	 {}
	


//	 int f() // error
//	 { return 1; }
	

	int f(int i) // ok
	{
		return 1;
	}

	
	 public void f() throws IOException //error 
	 {}
	
}

public class BaseAndChild {

	public static void main(String[] args) {

	}

}
