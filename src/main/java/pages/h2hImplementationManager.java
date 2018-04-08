package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

import static utilities.h2hUtilities.clickTogglerIfNecessary;

public class h2hImplementationManager {

    WebDriver driver;

    public h2hImplementationManager(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hImplementationManager(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

            By ImplementationManagerToggler = By.xpath("//div[@class='implementation-manager-details']//div[@class='card-toggle']");
       // By contactDetailsToggler = By.xpath("//div[@class='contact details']//div[@class='card-toggle']");
        //By contactDetailsToggler = By.xpath("//div[2]/div/div/div[2]/div");

        By implementationManagerEmployeeId = By.xpath("//input[@formcontrolname='implementationManagerEmployeeId']");
        By implementationManagerEmployeeName = By.xpath("//input[@formcontrolname='implementationManagerEmployeeName']");
        By implementationManagerContactNumber = By.xpath("//input[@formcontrolname='implementationManagerContactNumber']");
        By implementationManagerEmailAddress = By.xpath("//input[@formcontrolname='implementationManagerEmailAddress']");

        h2hUtilities.scrollIntoView(driver, ImplementationManagerToggler);
        clickTogglerIfNecessary(driver, ImplementationManagerToggler, implementationManagerContactNumber);

        h2hUtilities.scrollIntoView(driver, implementationManagerContactNumber);

        Row row = h2hTestDataSheet.getRow(rowno);
        driver.findElement(implementationManagerEmployeeId).sendKeys(row.getCell(23).getStringCellValue());
        driver.findElement(implementationManagerEmployeeName).sendKeys(row.getCell(24).getStringCellValue());
        driver.findElement(implementationManagerContactNumber).sendKeys(row.getCell(25).getStringCellValue());
        driver.findElement(implementationManagerEmailAddress).sendKeys(row.getCell(26).getStringCellValue());

    }
}