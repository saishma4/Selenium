package demo;

import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	
	@Test
	public void test1() {
		System.out.println("Test 1");
		
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class )
	public void test2() {
		System.out.println("Test 2");
		int i =1/0;
	}

}
