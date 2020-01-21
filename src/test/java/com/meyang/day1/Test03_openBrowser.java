package com.meyang.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Test03_openBrowser {

    WebDriver driver;
    @AfterMethod
    public void quitDriver() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void openIE(){
        //System.setProperty("webdriver.ie.driver","D:\\doc\\selenium_java\\Selenium1701\\drivers\\IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.get("https://www.baidu.com/");
    }
    @Test
    public void openChrome(){
        //System.setProperty("webdriver.chrome.driver","D:\\doc\\selenium_java\\Selenium1701\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }
    @Test
    public void openFirefox(){
        //System.setProperty("webdriver.gecko.driver","D:\\doc\\selenium_java\\Selenium1701\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "D:\\dev\\Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
    }
//    @Test
//    public void openEdge(){
//        System.setProperty("webdriver.edge.driver","D:\\doc\\selenium_java\\Selenium1701\\drivers\\msedgedriver.exe");
//        System.setProperty("webdriver.edge.bin","C:\\Windows\\SystemApps\\Microsoft.MicrosoftEdge_8wekyb3d8bbwe\\MicrosoftEdge.exe");
//        driver = new EdgeDriver();
//        driver.get("https://www.baidu.com");
//    }
}
