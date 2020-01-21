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

public class Test03_WebElementTest {
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
    public void frameTest01() throws Exception{
        driver.get(url);
        driver.switchTo().frame("aa");
        WebElement element = driver.findElement(By.id("user"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
    }
    @Test
    public void frameTest02() throws Exception{
        driver.get(url);
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.id("user"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
    }
    @Test
    public void frameTest03() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
        driver.switchTo().frame(element);
        element = driver.findElement(By.id("user"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
    }
    @Test
    public void frameTest04() throws Exception{
        driver.get(url);
        driver.switchTo().frame("aa");
        WebElement element = driver.findElement(By.id("user"));
        element.sendKeys("selenium inner");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        element = driver.findElement(By.linkText("登陆界面"));
        element.click();
        Thread.sleep(3000);
    }
}
