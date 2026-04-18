package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverfactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        driver.set(new ChromeDriver());
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}

