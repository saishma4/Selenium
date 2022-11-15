package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore(class level)
public class TestNGIgnoreDemo {
	
	@Ignore
	@Test
	public void test1() {
		System.out.println("Test1 ");
		
	}
	@Test
	public void test2() {
		System.out.println("Test2 ");
		
	}

}
