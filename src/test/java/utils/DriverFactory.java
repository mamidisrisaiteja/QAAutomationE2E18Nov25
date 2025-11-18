package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.concurrent.ThreadFactory;

public class DriverFactory {

    private static Logger logger= LogManager.getLogger(DriverFactory.class);

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static void initBrowser(String browser){
        switch(browser.toLowerCase()){
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            default:
                logger.warn("Invalid browser specified: {}. Launching Chrome by default.", browser);
        }
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
            logger.info("Browser closed and instance removed");
        }
    }
}
