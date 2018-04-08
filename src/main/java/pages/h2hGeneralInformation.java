package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static utilities.h2hUtilities.*;

public class h2hGeneralInformation  {

    WebDriver driver;
    private String LegalEntityNameWithDateAndTime;

    //TODO Have check that on "Onboard customer page"

    public h2hGeneralInformation(WebDriver driver){

        this.driver = driver;

    }

    public void populateh2hGeneralInformation(Sheet h2hTestDataSheet, int rowno) throws Exception {

        By registerNewCustomerButton = By.partialLinkText("Register");
        By GeneralInformationToggler = By.xpath("//div[@class='client information']//div[@class='card-toggle']");

        By legalEntityName = By.xpath("//input[@formcontrolname='companyName']");
        By LegaEntityRegistrationNumber = By.xpath("//input[@formcontrolname='registrationNumber']");
        By sourceId = By.xpath("//input[@formcontrolname='sourceId']");
        By clientUniqueIdentifier = By.xpath("//input[@formcontrolname='clientUniqueIdentifier']");
        By billingAccount = By.xpath("//input[@formcontrolname='billingAccount']");
        By address1 = By.xpath("//input[@formcontrolname='address1']");
        By address2 = By.xpath("//input[@formcontrolname='address2']");
        By address3 = By.xpath("//input[@formcontrolname='address3']");
        By city = By.xpath("//input[@formcontrolname='city']");
        By country = By.xpath("//select[@formcontrolname='country']");
        By postalCode = By.xpath("//input[@formcontrolname='postalCode']");
        //By notificationTypeSMS = By.xpath("//input[@value='SMS']");
        By notificationTypeSMS = By.xpath("(//input[@name='notificationType'])[2]");
        By notificationTypeEmail = By.xpath("//input[@value='EMAIL']");
        By notificationTypeBoth = By.xpath("//input[@value='BOTH']");
        //By Loader = By.id("loader");
        By Loader = By.id("loader");

        //TODO put this code in utilities
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(GeneralInformationToggler ));

        clickTogglerIfNecessary(driver, GeneralInformationToggler, LegaEntityRegistrationNumber);

        Row row = h2hTestDataSheet.getRow(rowno);


        LegalEntityNameWithDateAndTime = row.getCell(0).getStringCellValue();
        //LegalEntityNameWithDateAndTime = LegalEntityNameWithDateAndTime + " - " + getDateAndTime();;
        driver.findElement(legalEntityName).sendKeys(LegalEntityNameWithDateAndTime);
        driver.findElement(LegaEntityRegistrationNumber).sendKeys(row.getCell(1).getStringCellValue());
        driver.findElement(sourceId).sendKeys(row.getCell(2).getStringCellValue());
        driver.findElement(clientUniqueIdentifier).sendKeys(row.getCell(3).getStringCellValue());
        driver.findElement(billingAccount).sendKeys(row.getCell(4).getStringCellValue());
        driver.findElement(address1).sendKeys(row.getCell(5).getStringCellValue());
        driver.findElement(address2).sendKeys(row.getCell(6).getStringCellValue());
        driver.findElement(address3).sendKeys(row.getCell(7).getStringCellValue());
        driver.findElement(city).sendKeys(row.getCell(8).getStringCellValue());

        Select s = new Select(driver.findElement(country));
        s.selectByVisibleText((row.getCell(9).getStringCellValue()));

        driver.findElement(postalCode).sendKeys(row.getCell(10).getStringCellValue());

        //h2hUtilities.h2hWaitUntil(driver, notificationTypeBoth, 15, "From h2h~GeneralInfoemation click Notification Type");

        //driver.findElement(notificationTypeSMS).click();
        //driver.findElement(notificationTypeEmail).click();
        //driver.findElement(notificationTypeBoth).click();

        scrollIntoView(driver, notificationTypeBoth);

        if ((row.getCell(11).getStringCellValue()).equals("SMS")) {
            driver.findElement(notificationTypeSMS).click();
        }
            else { if ((row.getCell(11).getStringCellValue()).equals("EMAIL")) {
            driver.findElement(notificationTypeEmail).click();
        }
                else {
                driver.findElement(notificationTypeBoth).click();
            }
        }


    }

}


