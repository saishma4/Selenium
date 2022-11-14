package priorityDemo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {
	
	@Test
	public void test1() {
		System.out.println("I'm inside Test1");
	}
	@Test(priority = 1)
	public void test2() {
		System.out.println("I'm inside Test2");
		
	}
	@Test(priority = 0)
	public void test3() {
		System.out.println("I'm inside Test3");
		
	}
	
	@Test(priority = 2)
	public void one() {
		System.out.println("I'm inside Testone");
	}
	@Test(priority = 2)
	public void two() {
		System.out.println("I'm inside Testtwo");
	}
	@Test(priority = 2)
	public void three() {
		System.out.println("I'm inside Testthree");
	}

}
