package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class h2hHomePage {

    WebDriver driver;
    //By homePageTitleText = By.className("landingDashBoardTitle");
    By homePageTitleText = By.id("dashboard");

    public h2hHomePage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public String getHomePageTitleText(){

        return    driver.findElement(homePageTitleText).getText();

    }

}