package demo;

import org.testng.annotations.Test;

public class TestNGDependency {
	//dependsOnGroups,dependsOnMethods
	
	@Test(dependsOnMethods= {"test2"}, priority=1)
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("Test 2");
	}

}
