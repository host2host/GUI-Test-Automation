package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

import static utilities.h2hUtilities.clickTogglerIfNecessary;

public class h2hRelationshipManager {

    WebDriver driver;

    public h2hRelationshipManager(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hRelationshipManager(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

        By relationshipManagerToggler = By.xpath("//div[@class='relationship-manager']//div[@class='card-toggle']");
        //By relationshipManagerToggler = By.xpath("//div[@class='relationship-manager']/div/div/div/div");

        By relationshipManagerEmployeeId = By.xpath("//input[@formcontrolname='relationshipManagerEmployeeId']");
        By relationshipContactPersonName = By.xpath("//input[@formcontrolname='relationshipContactPersonName']");
        By relationContactTelephoneNumber = By.xpath("//input[@formcontrolname='relationContactTelephoneNumber']");
        By relationContactMobileNumber = By.xpath("//input[@formcontrolname='relationContactMobileNumber']");
        By relationManagerEmailAddress = By.xpath("//input[@formcontrolname='relationManagerEmailAddress']");

        h2hUtilities.scrollIntoView(driver, relationshipManagerToggler);
        //driver.findElement(relationshipManagerToggler).click();
        //  No need to click toggler, not sure why

        clickTogglerIfNecessary(driver, relationshipManagerToggler, relationContactTelephoneNumber);

        h2hUtilities.scrollIntoView(driver, relationContactTelephoneNumber);

        Row row = h2hTestDataSheet.getRow(rowno);
        driver.findElement(relationshipManagerEmployeeId).sendKeys(row.getCell(27).getStringCellValue());
        driver.findElement(relationshipContactPersonName).sendKeys(row.getCell(28).getStringCellValue());
        driver.findElement(relationContactTelephoneNumber).sendKeys(row.getCell(29).getStringCellValue());
        driver.findElement(relationContactMobileNumber).sendKeys(row.getCell(30).getStringCellValue());
        driver.findElement(relationManagerEmailAddress).sendKeys(row.getCell(31).getStringCellValue());

    }
}