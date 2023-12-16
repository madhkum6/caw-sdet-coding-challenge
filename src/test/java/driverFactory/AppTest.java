package driverFactory;

import org.testng.annotations.Test;

public class AppTest {
	
DriverScript ds = new DriverScript();
	
	@Test
	public void quickStart() throws Throwable {
		
		ds.startTest();
		
	}

}
