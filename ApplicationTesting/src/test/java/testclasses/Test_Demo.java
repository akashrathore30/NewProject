package testclasses;

import org.testng.annotations.Test;

public class Test_Demo {
	
	
	

	
	public static void testOne(String employee) {
		if(employee==null||employee.length()<1){
			System.out.println("Employee lenth is either null or blank");
		}
		else{
			System.out.println("Has a value equal ="+ employee);
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Test_Demo.testOne("");
	} 
}
