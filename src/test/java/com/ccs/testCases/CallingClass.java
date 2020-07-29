package com.ccs.testCases;
import java.io.IOException;


public class CallingClass extends TC_LoginTest_001
{
	
	public void signIn() throws InterruptedException, IOException {
		TC_LoginTest_001 signIn = new TC_LoginTest_001();
		signIn.signInTest();
		
		//System.out.println("passed");
	}
  
	

}
