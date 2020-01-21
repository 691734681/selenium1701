package com.meyang.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test02_TestNGDemo02 {
    @Test
    public void assertEqualsTest(){
        String s1 = "abc";
        String s2 = "abc";
        Assert.assertEquals(s1,s2);
    }
    @Test
    public void assertNotEqualTest(){
        String s1 = "abc";
        String s2 = "abc";
        Assert.assertEquals(s1,s2,"the case fail");
    }
    @Test
    public void assertTrueTest(){
        boolean f = true;
        Assert.assertTrue(f);
    }
    @Test
    public void assertFalseTest(){
        boolean f = true;
        Assert.assertFalse(f);
    }
    @Test
    public void assertNullTest(){
        String s = "";
        Assert.assertNull(s);
    }
    @Test
    public void assertNotNullTest(){
        String s = "";
        Assert.assertNotNull(s);
    }
}
