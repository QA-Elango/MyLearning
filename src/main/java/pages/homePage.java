package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
    WebDriver driver;

    @FindBy(xpath = "//ul[@id='menu-primary-items']//li")
    List <WebElement> menuitems;

 public homePage (WebDriver driver){
        this.driver=driver;
                PageFactory.initElements(driver, this); 


    }

    public List<String>elements(){

        List <String> listItem = new ArrayList<>();
         for (WebElement item : menuitems) {
            listItem.add(item.getText());
        }
            return listItem;
    }



}
