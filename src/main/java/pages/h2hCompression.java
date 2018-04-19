package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoView;
import static utilities.h2hUtilities.scrollIntoViewNoClick;

public class h2hCompression {

    WebDriver driver;

    public h2hCompression(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hCompression(Sheet h2hTestDataSheet, int rowno) throws InterruptedException, IOException {

        By compressionToggler = By.xpath("//compression//div[@class='card-toggle']");
        By compressionCheckBox = By.xpath("//compression//label[@class='custom-control custom-checkbox']");
        By gzipRadioButton = By.xpath("//compression//input[@value='GZIP']");
        By zipRadioButton = By.xpath("//compression//input[@value='ZIP']");
        By compressionSaveButton = By.xpath("//compression//button[@class='btn btn-primary']");

        scrollIntoViewNoClick(driver, compressionToggler);
        clickTogglerIfNecessary(driver, compressionToggler, compressionSaveButton);

        scrollIntoView(driver, compressionCheckBox);
        driver.findElement(compressionCheckBox).click();

        Row row = h2hTestDataSheet.getRow(rowno);

        if ((row.getCell(4).getStringCellValue()).equals("GZIP")) {
            driver.findElement(gzipRadioButton).click();
        }

        if ((row.getCell(4).getStringCellValue()).equals("ZIP")) {
            driver.findElement(zipRadioButton).click();
        }

        scrollIntoView(driver, compressionSaveButton);
        //driver.findElement(compressionSaveButton).click();

    }
}
