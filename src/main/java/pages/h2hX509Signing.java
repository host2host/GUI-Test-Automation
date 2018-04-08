package pages;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoView;

public class h2hX509Signing {

    WebDriver driver;

    public h2hX509Signing(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hX509Signing(Sheet h2hTestDataSheet, int rowno) throws InterruptedException, IOException {

        By X509SigningToggler = By.xpath("//app-x509-signing//div[@class='card-toggle']");
        By X509SigningCheckBox = By.xpath("//app-x509-signing//label[@class='custom-control custom-checkbox']");
        By X509SigningSaveButton = By.xpath("//app-x509-signing//button[@class='btn btn-primary']");

        scrollIntoView(driver, X509SigningToggler);
        clickTogglerIfNecessary(driver, X509SigningToggler, X509SigningCheckBox);

        scrollIntoView(driver, X509SigningCheckBox);
        //driver.findElement(X509SigningCheckBox).click();

        scrollIntoView(driver, X509SigningSaveButton);
        driver.findElement(X509SigningSaveButton).click();

    }
}
