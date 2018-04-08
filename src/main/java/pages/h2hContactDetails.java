package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

import static utilities.h2hUtilities.clickTogglerIfNecessary;

public class h2hContactDetails {

    WebDriver driver;

    public h2hContactDetails(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hContactDetails(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

        By contactDetailsToggler = By.xpath("//div[@class='contact details']/div[1]//div/div");
       // By contactDetailsToggler = By.xpath("//div[@class='contact details']//div[@class='card-toggle']");
        //By contactDetailsToggler = By.xpath("//div[2]/div/div/div[2]/div");

        By primaryContactPersonName = By.xpath("//input[@formcontrolname='primaryContactPersonName']");
        By primaryContactDesignation = By.xpath("//input[@formcontrolname='primaryContactDesignation']");
        By primaryContactTelephoneNumber = By.xpath("//input[@formcontrolname='primaryContactTelephoneNumber']");
        By primaryContactPersonMobileNumber = By.xpath("//input[@formcontrolname='primaryContactPersonMobileNumber']");
        By primaryContactEmail = By.xpath("//input[@formcontrolname='primaryContactEmail']");

        h2hUtilities.scrollIntoView(driver, contactDetailsToggler);

        //driver.findElement(contactDetailsToggler).click();
        clickTogglerIfNecessary(driver, contactDetailsToggler, primaryContactTelephoneNumber);

        Row row = h2hTestDataSheet.getRow(rowno);
        driver.findElement(primaryContactPersonName).sendKeys(row.getCell(12).getStringCellValue());
        driver.findElement(primaryContactDesignation).sendKeys(row.getCell(13).getStringCellValue());
        driver.findElement(primaryContactTelephoneNumber).sendKeys(row.getCell(14).getStringCellValue());
        driver.findElement(primaryContactPersonMobileNumber).sendKeys(row.getCell(15).getStringCellValue());
        driver.findElement(primaryContactEmail).sendKeys(row.getCell(16).getStringCellValue());

    }
}