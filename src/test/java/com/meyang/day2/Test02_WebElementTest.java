package com.meyang.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test02_WebElementTest {
    WebDriver driver;
    String url = "http://localhost:8080/selenium_html/";
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
    public void isSelectTest(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='radio']/input[1]"));
        element.click();
        boolean b = element.isSelected();
        Assert.assertTrue(b);
    }
    @Test
    public void isEnableTest(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"button\"]/input[1]"));
        boolean b = element.isEnabled();
        Assert.assertTrue(!b);
    }
    @Test
    public void alertTest() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.className("alert"));
        element.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void confirmTest()throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.className("confirm"));
        element.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void promptTest() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.className("prompt"));
        element.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        alert.sendKeys("selenium");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }
}
