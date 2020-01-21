package com.meyang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test06_WebElementTest_wait {
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
    public void selectedTest() throws Exception{

    }
    @Test
    public void waitTest01(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='wait']/input"));
        element.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String s = driver.findElement(By.xpath("//*[@id='display']/div")).getText();
        Assert.assertEquals(s,"wait for display");
    }
    @Test
    public void waitTest02(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='wait']/input"));
        element.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='display']/div")));
        String s = driver.findElement(By.xpath("//*[@id='display']/div")).getText();
        Assert.assertEquals(s,"wait for display");
    }
}
