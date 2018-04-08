package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

public class h2hTechnicalContact {

    WebDriver driver;

    //TODO Have check that on "Onboard customer pag"
    // By h2hGeneralInformationText = By.id("dashboard");

    public h2hTechnicalContact(WebDriver driver){

        this.driver = driver;

    }

    public void populateh2hTechnicalContact(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

       // By technicalContactPersonToggler = By.xpath("//div[@class='contact details']/div[1]//div/div");

        //By primaryIsTechnicalPerson = By.xpath("//input[@formcontrolname='primaryIsTechnicalPerson']");
        By primaryIsTechnicalPerson = By.xpath("//div[@class='form group']/label");

        By technicalContactPersonName = By.xpath("//input[@formcontrolname='technicalContactPersonName']");
        By technicalContactDesignation = By.xpath("//input[@formcontrolname='technicalContactDesignation']");
        By technicalContactTelephoneNumber = By.xpath("//input[@formcontrolname='technicalContactTelephoneNumber']");
        By techMobileNumber = By.xpath("//input[@formcontrolname='techMobileNumber']");
        By technicalContactEmail = By.xpath("//input[@formcontrolname='technicalContactEmail']");

        Row row = h2hTestDataSheet.getRow(rowno);

        //driver.findElement(primaryIsTechnicalPerson).click();

        h2hUtilities.scrollIntoView(driver, techMobileNumber);

        if ((row.getCell(17).getStringCellValue()).equals("Y")) {
            driver.findElement(primaryIsTechnicalPerson).click();

        } else {

            driver.findElement(technicalContactPersonName).sendKeys(row.getCell(18).getStringCellValue());
            driver.findElement(technicalContactDesignation).sendKeys(row.getCell(19).getStringCellValue());
            driver.findElement(technicalContactTelephoneNumber).sendKeys(row.getCell(20).getStringCellValue());
            driver.findElement(techMobileNumber).sendKeys(row.getCell(21).getStringCellValue());
            driver.findElement(technicalContactEmail).sendKeys(row.getCell(22).getStringCellValue());
        }
        }

}


