package demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {
	
	@Test
	@Parameters({"MyName"})
	//(@Optional("default") String name)
	public void test(String name) {
		System.out.println("Name:"+name);
	}

}
