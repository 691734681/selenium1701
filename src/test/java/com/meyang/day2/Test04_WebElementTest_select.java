package com.meyang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test04_WebElementTest_select {
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
    public void selectedTest01() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.id("moreSelect"));
        Select select = new Select(element);
        select.selectByIndex(3);
        Thread.sleep(5000);
        select.selectByValue("huawei");
        Thread.sleep(5000);
        select.selectByVisibleText("meizu");
        Thread.sleep(5000);
    }
    @Test
    public void selectTest02() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        Select select = new Select(element);
        select.deselectAll();
        Thread.sleep(10000);
        select.selectByIndex(2);
        select.selectByIndex(3);
        Thread.sleep(10000);
        select.deselectAll();
        Thread.sleep(10000);
    }
}
