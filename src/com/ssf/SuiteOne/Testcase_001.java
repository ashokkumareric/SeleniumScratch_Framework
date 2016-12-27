package com.ssf.SuiteOne;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_001 {

	@BeforeSuite
	public void TestSetupSuite(){
		System.out.println("Start of the Test Suite ");
	}
	
	@BeforeTest
	public void TestLaunchApp(){
		System.out.println("Start of the Test");
	}
	
	@BeforeClass
	public void TestSetupConfig(){
		System.out.println("Start of the Class");
	}
	
	@BeforeMethod
	public void TestMethod1(){
		System.out.println("Test Method 1");
	}
	
	@BeforeMethod
	public void TestMethod2(){
		System.out.println("Test Method 2");
	}
	
	@Test
	@Parameters({"character","str"})
	public void TestDryrun1(String chara, String string){
		System.out.println("Dry run test 1");
		System.out.println("The Parametered Value is: "+ chara);
		System.out.println("The second Parameter is: " + string);
	}
	@AfterMethod
	public void TestAfterMethod1(){
		System.out.println("End of Test Method 1");
	}
	
	@AfterMethod
	public void TestAfterMethod2(){
		System.out.println("End of Test Method 2");
	}
	
	@Test
	public void TestDryrun2(){
		System.out.println("Dry run test 2");
	}
	
	
	@AfterClass
	public void TestTearupConfig(){
		System.out.println("End of the Class");
	}
	
	@AfterTest
	public void TestCloseApp(){
		System.out.println("End of the Test");
	}
	
	@AfterSuite
	public void TestTearupSuite(){
		System.out.println("End of the Test Suite ");
	}
}
