package com.meyang.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Test05_FindElementsTest {
    WebDriver driver;
    String url = "https://www.baidu.com/";
    @BeforeMethod
    public void initTest(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
    @Test
    public void ByIdTest(){
        driver.get(url);
        driver.findElement(By.id("kw"));
    }
    @Test
    public void ByNameTest(){
        driver.get(url);
        driver.findElement(By.name("wd"));
    }
    @Test
    public void ByClassNameTest(){
        driver.get(url);
        driver.findElement(By.className("s_ipt"));
    }
    @Test
    public void ByLinkTest(){
        driver.get(url);
        driver.findElement(By.linkText("新闻"));
    }
    @Test
    public void ByPartialLinkTest(){
        driver.get(url);
        driver.findElement(By.partialLinkText("hao"));
    }
    @Test
    public void ByCssTest(){
        driver.get(url);
        driver.findElement(By.cssSelector("#su"));
    }
    @Test
    public void ByXpath(){
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='su']"));
    }
}
