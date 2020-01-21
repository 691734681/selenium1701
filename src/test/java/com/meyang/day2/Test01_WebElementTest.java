package com.meyang.day2;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01_WebElementTest {
    WebDriver driver;
    String url = "https://www.baidu.com/";
    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
    @Test
    public void clickTest() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.linkText("新闻"));
        element.click();
        Thread.sleep(10000);
        String s = driver.getCurrentUrl();
        Assert.assertEquals(s,"http://news.baidu.com/");
    }
    @Test
    public void sendkeysTest() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
    }
    @Test
    public void clearTest() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
        element.clear();
        Thread.sleep(3000);
    }
    @Test
    public void getTextTest() throws Exception{
        driver.get(url);
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//*[@id='u1']/a[1]"));
        String s = element.getText();
        Assert.assertEquals(s,"新闻");
    }
    @Test
    public void getTagNameTest(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='u1']/a[1]"));
        String s = element.getTagName();
        Assert.assertEquals(s,"a");
    }
    @Test
    public void getAttributeTest(){
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        String s = element.getAttribute("value");
        Assert.assertEquals(s,"百度一下");
    }
    @Test
    public void isDisplayedTest() throws Exception{
        driver.get(url);
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("su"));
        boolean s = element.isDisplayed();
        Assert.assertTrue(s);
    }
    @Test
    public void screenshotTest() throws Exception{
        driver.get(url);
        Thread.sleep(3000);
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time=si.format(new Date());
            time = time.trim().replaceAll("\\s+","_");
            String filename = time+".jpg";
            System.out.println(filename);
            FileUtils.copyFile(file, new File("D:\\doc\\selenium_java\\screenshot",filename));
//            FileUtils.copyFile(file, new File("D:\\doc\\selenium_java\\screenshot\\test.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
