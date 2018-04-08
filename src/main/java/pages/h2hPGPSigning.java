package pages;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoView;

public class h2hPGPSigning {

    WebDriver driver;

    public h2hPGPSigning(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hPGPSigning(Sheet h2hTestDataSheet, int rowno) throws InterruptedException, IOException {

        By PGPSigningToggler = By.xpath("//pgp-signing//div[@class='card-toggle']");
        By PGPSigningCheckBox = By.xpath("//pgp-signing//label[@class='custom-control custom-checkbox']");
        By PGPSigningSaveButton = By.xpath("//pgp-signing//button[@class='btn btn-primary']");

        scrollIntoView(driver, PGPSigningToggler);
        clickTogglerIfNecessary(driver, PGPSigningToggler, PGPSigningCheckBox);

        scrollIntoView(driver, PGPSigningCheckBox);
        //driver.findElement(PGPSigningCheckBox).click();

        scrollIntoView(driver, PGPSigningSaveButton);
        driver.findElement(PGPSigningSaveButton).click();

    }
}
