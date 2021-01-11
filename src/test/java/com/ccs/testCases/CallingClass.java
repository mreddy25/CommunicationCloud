package com.ccs.testCases;
import java.io.IOException;

import org.testng.annotations.Test;


public class CallingClass extends BaseClass
{
	@Test
	public void msignIn() throws InterruptedException, IOException {
		TC_LoginTest_001 signIn = new TC_LoginTest_001();
		signIn.signInTest();
		
		//System.out.println("passed");

		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();
	
	}

}
