package Testpart;

import org.testng.annotations.Test;

import PagePackage.Loginpage;

public class TestClass extends Loginpage
{
	@Test
	public void Test1() throws Exception
	{	
		Loginpage.Repository();
		
	}

}
