package com.meyang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test07_WebElementTest_MouseActions {
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
    public void rightClick() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.linkText("登陆界面"));
        Actions actions = new Actions(driver);
        //actions.contextClick().perform(); // right click on the moue position
        //Thread.sleep(10000);
        actions.contextClick(element).perform(); // right click on the element
        Thread.sleep(10000);
//        element = driver.findElement(By.partialLinkText("在新窗口中打开链接")); // error
//        element.click();
//        Thread.sleep(10000);
    }
    @Test
    public void doubleClick() throws Exception{
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/b"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        Thread.sleep(10000);
    }
    @Test
    public void MouseOver(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='action']/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@id='over']/div"));
        String s = element.getText();
        Assert.assertEquals(s,"Hello World!");
    }
    @Test
    public void dragTest() throws Exception{
        driver.get("http://localhost:8080/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        WebElement element1 = driver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(driver);
//        actions.dragAndDropBy(element,500,500).perform();
//        Thread.sleep(10000);
        actions.dragAndDrop(element,element1).perform();
        Thread.sleep(10000);
    }
}
