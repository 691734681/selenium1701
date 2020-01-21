package com.meyang.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test01_JS {
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
    public void jsTest01() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.id("user"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jscript = "document.getElementById(\"user\").setAttribute(\"value\",\"abc\")\n";
        js.executeScript(jscript);
        Thread.sleep(5000);
    }
}
