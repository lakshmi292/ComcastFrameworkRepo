package com.comcast.crm.generic.annotationTest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class createcontactTest {

	@BeforeSuite
	public void confiBS()
	{
		System.out.println("==executed BS==");
	}
	@BeforeClass
	public void confiBC()
	{
		System.out.println("==executed BC==");
	}
	@BeforeMethod
	public void confiBM()
	{
		System.out.println("==executed Bm==");
	}
	@Test
	public void  createcontact()
	{
		System.out.println("executed createcontace");
	}
	@Test
	public void createcontactwithdate()
	{
		System.out.println("executed createcontactwithdate");
	}
	@AfterMethod
	public void confiAM()
	{
		System.out.println("==executed AM==");
	}
	@AfterClass
	public void confiAC()
	{
		System.out.println("==executed AC==");
	}
	@AfterSuite
	public void confiAS()
	{
		System.out.println("==executed AS==");
	}
}
