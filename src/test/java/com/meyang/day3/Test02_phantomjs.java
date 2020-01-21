package com.meyang.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test02_phantomjs {
    WebDriver driver;
    String url = "http://localhost:8080/selenium_html/";
    @BeforeMethod
    public void init(){
        System.setProperty("phantomjs.binary.path",".\\drivers\\phantomjs.exe");
        driver = new PhantomJSDriver();
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
    @Test
    public void phantomjsTest(){
        driver.get(url);
        String s = driver.getCurrentUrl();
        System.out.println(s);
    }
}
