package testclasses;

public class Childclass extends Testclass {

//	@Override
//	public int test1(){
//		System.out.println("private");
//		int c= 10+20;
//		return c;
//		}
	
	public static void main(String[] args) {
		Testclass tc= new Testclass();
		tc.test1(10, 10);
	}
}
