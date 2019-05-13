package testclasses;

import static org.junit.Assert.assertTrue;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Testclass implements ITestListener    {
	public boolean

@test
public void test1(){
System.out.println("inside test1");
assert.assertTrue("Value is matched to condition", true);

}

public void test2(){
System.out.println("inside test2");

}

public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}



}
