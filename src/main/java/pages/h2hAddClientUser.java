package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.h2hUtilities;

import java.io.IOException;

import static utilities.h2hUtilities.scrollIntoView;
import static utilities.h2hUtilities.scrollIntoViewNoClick;

public class h2hAddClientUser {

    WebDriver driver;

    public h2hAddClientUser(WebDriver driver) {

        this.driver = driver;

    }

//TODO Still to make allowance for capturing password

    public void populateh2hAddClientUser(Sheet h2hTestDataSheet, int rowno, String pushOrPull) throws InterruptedException, IOException {

        By userIdentifier = By.xpath("//input[@formcontrolname='userIdentifier']");
        By statementFileNameFormatType = By.xpath("//select[@formcontrolname='statementFileNameFormatType']");
        By statementBespokeFileNameFormat = By.xpath("//input[@formcontrolname='statementBespokeFileNameFormat']");
        By linkToAccount = By.xpath("//client-user-form//input[@name='options']");
        By linkToProduct = By.xpath("//client-user-form//span//input[@name='options']");
        By authenticationTypePublicKey = By.xpath("//input[@value='PUBLIC_KEY']");
        By authenticationTypePasswordAndPublicKey = By.xpath("//input[@value='PASSWORD_AND_PUBLIC_KEY']");
        By sftpUserName = By.xpath("//input[@formcontrolname='sftpUserName']");
        By userPublicKey = By.xpath("//input[@formcontrolname='userPublicKey']");
        By fingerprint = By.xpath("//client-user-form//input[@formcontrolname='fingerprint']");
        By keyStatus = By.xpath("//select[@formcontrolname='keyStatus']");
        By expiryDate = By.xpath("//client-user-form//input[@formcontrolname='expiryDate']");
        By preferredDirectory = By.xpath("//client-user-form//input[@formcontrolname='preferredDirectory']");
        By addAccountLink = By.xpath("//client-user-form//div[@class='form-group']//button[@class='btn btn-linkbutton']");
        By addUserLink = By.xpath("//client-user-form//div[@class='card-footer']//button[@class='btn btn-linkbutton']");
        By sftpPassword = By.xpath("//client-user-form//input[@formcontrolname='sftpPassword']");

        Row row = h2hTestDataSheet.getRow(rowno);

        driver.findElement(userIdentifier).sendKeys(row.getCell(0).getStringCellValue());
        driver.findElement(statementFileNameFormatType).sendKeys(row.getCell(1).getStringCellValue());

        if ((row.getCell(1).getStringCellValue()).equals("Bespoke Naming Format")) {
            driver.findElement(statementBespokeFileNameFormat).sendKeys(row.getCell(1).getStringCellValue());
        }

        scrollIntoViewNoClick(driver, linkToAccount);
        driver.findElement(linkToAccount).click();

        h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_LINKTOPRODUCT.png");

        scrollIntoViewNoClick(driver, linkToProduct);
        Thread.sleep(1000);
        driver.findElement(linkToProduct).click();

        scrollIntoView(driver, authenticationTypePasswordAndPublicKey);
        if ((row.getCell(2).getStringCellValue()).equals("Public Key + Username")) {
            driver.findElement(authenticationTypePublicKey).click();
        } else {
            driver.findElement(authenticationTypePasswordAndPublicKey).click();
        }

        scrollIntoView(driver, sftpUserName);
        driver.findElement(sftpUserName).sendKeys(row.getCell(3).getStringCellValue());

        // Start of pull specific info

        if (pushOrPull.equals("Pull")) {

            scrollIntoView(driver, userPublicKey);
            driver.findElement(userPublicKey).sendKeys(row.getCell(4).getStringCellValue());

            scrollIntoView(driver, fingerprint);
            driver.findElement(fingerprint).sendKeys(row.getCell(5).getStringCellValue());

            scrollIntoView(driver, keyStatus);
            Select selectKeyStatus = new Select(driver.findElement(keyStatus));
            selectKeyStatus.selectByVisibleText((row.getCell(6).getStringCellValue()));

            String convertForDatePicker = row.getCell(7).getStringCellValue();
            convertForDatePicker = "00" + convertForDatePicker;

            scrollIntoView(driver, expiryDate);
            driver.findElement(expiryDate).sendKeys(convertForDatePicker);

            scrollIntoView(driver, addAccountLink);
            driver.findElement(addAccountLink).click();

            // Pull specific info ends here ends here
        }

        scrollIntoView(driver, preferredDirectory);
        driver.findElement(preferredDirectory).sendKeys(row.getCell(8).getStringCellValue());

        if ((row.getCell(2).getStringCellValue()).equals("Public Key + Username + Password")) {
            scrollIntoView(driver, sftpPassword);
            driver.findElement(sftpPassword).sendKeys(row.getCell(9).getStringCellValue());
        }
            scrollIntoView(driver, addUserLink);
            driver.findElement(addUserLink).click();

    }
}
