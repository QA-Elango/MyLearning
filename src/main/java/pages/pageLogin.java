package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageLogin {
    
    WebDriver driver;
    
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By btn = By.id("submit");

    public pageLogin(WebDriver driver){
        this.driver=driver;

    }


public void enterUsername(String user){
    driver.findElement(username).sendKeys(user);
}
public void enterPassword(String pass){
    driver.findElement(password).sendKeys(pass);
}

    public void clickLogin() {
        driver.findElement(btn).click();
    }


     public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
}
}
