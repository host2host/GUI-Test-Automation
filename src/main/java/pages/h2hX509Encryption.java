package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.h2hUtilities;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoView;

public class h2hX509Encryption {

    WebDriver driver;

    public h2hX509Encryption(WebDriver driver) {

        this.driver = driver;

    }

    public void populateh2hX509Encryption(Sheet h2hTestDataSheet, int rowno) throws InterruptedException {

        By X509EncryptionToggler = By.xpath("//X509-encryption//div[@class='card-toggle']");
        By commonName = By.xpath("//input[@formcontrolname='commonName']");
        By certThumbprint = By.xpath("//input[@formcontrolname='certThumbprint']");
        By certificateStatus = By.xpath("//select[@formcontrolname='certificateStatus']");
        By publicKey = By.xpath("//textarea[@formcontrolname='publicKey']");
        By certificateAuthority = By.xpath("//input[@formcontrolname='certificateAuthority']");
        By expiryDate = By.xpath("//X509-encryption//input[@formcontrolname='expiryDate']");
        By addX509Encryption = By.xpath("//X509-encryption//div[@class='card-footer']//button[@class='btn btn-linkbutton']");
        By X509EncryptionSaveButton = By.xpath("//X509-encryption//button[@class='btn btn-primary pull-right']");

        h2hUtilities.scrollIntoView(driver, X509EncryptionToggler);
        clickTogglerIfNecessary(driver, X509EncryptionToggler,X509EncryptionToggler);

        h2hUtilities.scrollIntoView(driver, commonName);

        Row row = h2hTestDataSheet.getRow(rowno);
        driver.findElement(commonName).sendKeys(row.getCell(9).getStringCellValue());

        scrollIntoView(driver, certThumbprint);
        driver.findElement(certThumbprint).sendKeys(row.getCell(10).getStringCellValue());

        scrollIntoView(driver, certificateStatus);
        Select selectKeyStatus = new Select(driver.findElement(certificateStatus));
        selectKeyStatus.selectByVisibleText((row.getCell(11).getStringCellValue()));

        scrollIntoView(driver, publicKey);
        driver.findElement(publicKey).sendKeys(row.getCell(12).getStringCellValue());

        scrollIntoView(driver, certificateAuthority);
        driver.findElement(certificateAuthority).sendKeys(row.getCell(13).getStringCellValue());

        String convertForDatePicker = row.getCell(14).getStringCellValue();

        convertForDatePicker = "00" + convertForDatePicker;

        scrollIntoView(driver, expiryDate);
        driver.findElement(expiryDate).sendKeys(convertForDatePicker);

        scrollIntoView(driver, addX509Encryption);
        driver.findElement(addX509Encryption).click();

        scrollIntoView(driver, X509EncryptionSaveButton);
        driver.findElement(X509EncryptionSaveButton).click();

    }
}