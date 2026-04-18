package tests;

import java.util.List;

import org.testng.annotations.Test;

import base.baseTest;
import pages.homePage;

public class secondtest extends baseTest {

    @Test
    public void verifyMenuItems() {

    homePage listElement = new homePage(driver);

    List<String> items = listElement.elements();

    for (String item : items) {
        System.out.println(item);
    }
    
}
}