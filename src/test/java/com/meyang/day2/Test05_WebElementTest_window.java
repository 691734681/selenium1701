package com.meyang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Test05_WebElementTest_window {
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
    public void windowTest() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.linkText("Open new window"));
        String handle = driver.getWindowHandle();
        element.click();
        Set<String> handles = driver.getWindowHandles();
        for(String h:handles){
            if(h.equals(handle)){
                driver.switchTo().window(h);
                break;
            }
        }
        driver.findElement(By.id("user")).sendKeys("selenium in new window");
        Thread.sleep(5000);
        driver.switchTo().window(handle);
        driver.findElement(By.id("user")).sendKeys("selenium in old window");
        Thread.sleep(1000);
    }
}
