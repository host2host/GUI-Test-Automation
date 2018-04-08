package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class customerOnboardingPage {

    WebDriver driver;
    By customerOnboardingPageTitleText = By.id("***********");

    public customerOnboardingPage(WebDriver driver) {

        this.driver = driver;

    }

    public String customerOnboardingPageTitleText() {

        return    driver.findElement(customerOnboardingPageTitleText).getText();

    }
}
