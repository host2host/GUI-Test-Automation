package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

import java.io.IOException;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoView;

public class h2hProducts {

    WebDriver driver;

    //TODO Have check that on "Onboard customer pag"
    // By h2hGeneralInformationText = By.id("dashboard");

    public h2hProducts(WebDriver driver){

        this.driver = driver;

    }

    public void populateh2hProducts(Sheet h2hTestDataSheet, int rowno) throws InterruptedException, IOException {

        By productsToggler = By.xpath("//products-form//div[@class='card-toggle']");

        By statementsCheckBox = By.xpath("//products-form//input[@value='STATEMENTS']");
        By EODCheckBox = By.xpath("//products-form//input[@value='EOD']");
        By INTRADAYCheckBox = By.xpath("//products-form//input[@value='INTRADAY']");
        By CSVCheckBox = By.xpath("//products-form//input[@value='CSV']");
        By MTCheckBox = By.xpath("//products-form//input[@value='MT']");
        By PAINCheckBox = By.xpath("//products-form//input[@value='PAIN']");
        By saveProductsButton = By.xpath("//products-form//button[@class='btn btn-primary']");

        clickTogglerIfNecessary(driver, productsToggler, CSVCheckBox);

        Row row = h2hTestDataSheet.getRow(rowno);

        //h2hUtilities.scrollIntoView(driver, techMobileNumber);
        //h2hWaitUntil(WebDriver driver, By waitElement, Integer waitTime, String infoString)

        if ((row.getCell(32).getStringCellValue()).equals("Y")) {
            driver.findElement(statementsCheckBox).click();
            h2hUtilities.h2hWaitUntil(driver, INTRADAYCheckBox, 15, "From populateh2h Products wait for INTRADAY");
        }
        if ((row.getCell(33).getStringCellValue()).equals("Y")) {
            driver.findElement(EODCheckBox).click();
        }
        if ((row.getCell(34).getStringCellValue()).equals("Y")) {
            driver.findElement(INTRADAYCheckBox).click();
        }
        if ((row.getCell(35).getStringCellValue()).equals("Y")) {
            driver.findElement(CSVCheckBox).click();
        }
        if ((row.getCell(36).getStringCellValue()).equals("Y")) {
            driver.findElement(MTCheckBox).click();
        }
        if ((row.getCell(37).getStringCellValue()).equals("Y")) {
            driver.findElement(PAINCheckBox).click();
        }

        h2hUtilities.h2hWaitUntil(driver, saveProductsButton, 15, "From h2hProducts clicksaveroductsButton");
        //h2hUtilities.scrollIntoView(driver, registerNewCustomerButton);
        h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_clicksaveroductsButton.png");
        scrollIntoView(driver, saveProductsButton);
        driver.findElement(saveProductsButton).click();
        }

}


