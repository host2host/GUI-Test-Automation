package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static utilities.h2hUtilities.h2hWaitUntil;

public class h2hAccounts {

    WebDriver driver;

    public h2hAccounts(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hAccounts(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

        By accountId = By.xpath("//account-form//input[@formcontrolname='accountId']");
        By sourceId = By.xpath("//account-form//input[@formcontrolname='sourceId']");
        By sortCode = By.xpath("//account-form//input[@formcontrolname='sortCode']");
        By branchCode = By.xpath("//input[@formcontrolname='branchCode']");
        By bicCode = By.xpath("//account-form//input[@formcontrolname='bicCode']");
        By currency = By.xpath("//account-form//select[@formcontrolname='currency']");
        By country = By.xpath("//account-form//select[@formcontrolname='country']");
        By searchBySubProduct = By.xpath("//input[@class='form-control ui-select-search']");
        By addAccountLink = By.xpath("//account-form//button[@class='btn btn-linkbutton']");
        By saveProductsButton = By.xpath("//account-form//button[@class='btn btn-primary pull-right']");

        Row row = h2hTestDataSheet.getRow(rowno);

        driver.findElement(accountId).sendKeys(row.getCell(0).getStringCellValue());
        driver.findElement(sourceId).sendKeys(row.getCell(1).getStringCellValue());
        driver.findElement(sortCode).sendKeys(row.getCell(2).getStringCellValue());
        driver.findElement(branchCode).sendKeys(row.getCell(3).getStringCellValue());
        driver.findElement(bicCode).sendKeys(row.getCell(4).getStringCellValue());

        Select selectCurrency = new Select(driver.findElement(currency));
        selectCurrency.selectByVisibleText((row.getCell(5).getStringCellValue()));

        Select selectCountry = new Select(driver.findElement(country));
        selectCountry.selectByVisibleText((row.getCell(6).getStringCellValue()));

        //driver.findElement(searchBySubProduct).click();

        //Select preferredSubProduct = new Select(driver.findElement(searchBySubProduct));
        //preferredSubProduct.selectByVisibleText((row.getCell(7).getStringCellValue()));

        driver.findElement(searchBySubProduct).sendKeys((row.getCell(7).getStringCellValue()));
        System.out.println("Preferred Sub Products="+ row.getCell(7).getStringCellValue());
        //List<WebElement> listItems = driver.findElements(By.className("//ul[@class='ui-select-choices dropdown-menu']//a[@class='dropdown-item']/div"));
        //listItems.get(0).click();
        driver.findElement(searchBySubProduct).sendKeys(Keys.RETURN);

        h2hWaitUntil(driver, addAccountLink, 10, "Waiting for addAccount to be clickable");
        driver.findElement(addAccountLink).click();

    }
}