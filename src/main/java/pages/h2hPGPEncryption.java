package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.h2hUtilities;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoView;
import static utilities.h2hUtilities.scrollIntoViewNoClick;

public class h2hPGPEncryption {

    WebDriver driver;

    public h2hPGPEncryption(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hPGPEncryption(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

        By PGPEncryptionToggler = By.xpath("//pgp-encryption//div[@class='card-toggle']");
        By clientPublicKey = By.xpath("//textarea[@formcontrolname='clientPublicKey']");
        By keyFingerprint = By.xpath("//input[@formcontrolname='keyFingerprint']");
        By certificateStatus = By.xpath("//select[@formcontrolname='certificateStatus']");
        By expiryDate = By.xpath("//pgp-encryption//input[@formcontrolname='expiryDate']");
        By addPGPEncryption = By.xpath("//pgp-encryption//div[@class='card-footer']//button[@class='btn btn-linkbutton']");
        By PGPEncryptionSaveButton = By.xpath("//pgp-encryption//button[@class='btn btn-primary pull-right']");

        h2hUtilities.scrollIntoView(driver, PGPEncryptionToggler);

        //TODO Replace PGPEncryptionToggler with a field inside PGP encryption toggler  *****
        clickTogglerIfNecessary(driver, PGPEncryptionToggler,PGPEncryptionToggler);

        h2hUtilities.scrollIntoView(driver, clientPublicKey);

        Row row = h2hTestDataSheet.getRow(rowno);
        driver.findElement(clientPublicKey).sendKeys(row.getCell(5).getStringCellValue());
        driver.findElement(keyFingerprint).sendKeys(row.getCell(6).getStringCellValue());

        scrollIntoView(driver, certificateStatus);
        Select selectKeyStatus = new Select(driver.findElement(certificateStatus));
        selectKeyStatus.selectByVisibleText((row.getCell(7).getStringCellValue()));

        String convertForDatePicker = row.getCell(8).getStringCellValue();

        convertForDatePicker = "00" + convertForDatePicker;

        scrollIntoView(driver, expiryDate);
        driver.findElement(expiryDate).sendKeys(convertForDatePicker);

        scrollIntoView(driver, addPGPEncryption);
        driver.findElement(addPGPEncryption).click();

        scrollIntoViewNoClick(driver, PGPEncryptionSaveButton);
        driver.findElement(PGPEncryptionSaveButton).click();

    }
}