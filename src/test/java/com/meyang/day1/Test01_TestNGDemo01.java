package com.meyang.day1;

import org.testng.annotations.*;

public class Test01_TestNGDemo01 {
    @BeforeClass
    public void beforeClass01(){
        System.out.println("&&&&& this is beforeClass &&&&&");
    }
    @AfterClass
    public void afterClass01(){
        System.out.println("&&&&&& this is afterClass &&&&");
    }
    @BeforeTest
    public void beforeTest01(){
        System.out.println("########## this is beforeTest ##########");
    }
    @AfterTest
    public void afterTest01(){
        System.out.println("########## this is afterTest ###########");
    }
    @BeforeMethod
    public void beforeMethod01(){
        System.out.println("+++++ this is beforeMethod +++++");
    }
    @AfterMethod
    public void afterMethod01(){
        System.out.println("+++++ this is afterMethod +++++");
    }
    @Test
    public void testCase01(){
        System.out.println("this is testCase01");
    }
    @Test
    public void testCase02(){
        System.out.println("this is testCase02");
    }
}
