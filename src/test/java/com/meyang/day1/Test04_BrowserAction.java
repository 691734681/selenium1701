package com.meyang.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.*;

public class Test04_BrowserAction {
    WebDriver driver ;
    String url = "https://www.baidu.com/";
    @BeforeMethod
    public void initTest(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void quitTest(){
        driver.quit();
    }
    @Test
    public void window() throws Exception {
        driver.get(url);
        Dimension dimension = new Dimension(400,400);
        driver.manage().window().setSize(dimension);
        sleep(5000);
        driver.manage().window().maximize();
        sleep(5000);
    }
    @Test
    public void backAndForward() throws Exception {
        driver.get(url);
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
    }
    @Test
    public void getURL(){
        driver.get(url);
        String s = driver.getCurrentUrl();
        System.out.println(s);
        Assert.assertEquals(s,url);
    }
    @Test
    public void getTitle(){
        driver.get(url);
        String s = driver.getTitle();
        System.out.println(s);
        Assert.assertEquals(s,"百度一下，你就知道");
    }
}
