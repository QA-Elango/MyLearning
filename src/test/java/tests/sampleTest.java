package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Retry;
import base.baseTest;
import pages.pageLogin;

public class sampleTest extends baseTest {
   @Test (priority = 1,retryAnalyzer = Retry.class)
    public  void verifyLogin() {

        pageLogin verify = new pageLogin(driver);

        verify.login("student", "Password123");

        WebElement link = driver.findElement(By.xpath("//p[@class=\"has-text-align-center\"]"));

      System.out.println(link.getText());
    }
    @Test(priority = 2) 
    public void verifyPageName(){

          System.out.println(driver.getTitle());
    }
}
