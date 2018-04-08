package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoViewNoClick;

public class h2hSFTPPush {

    WebDriver driver;


    public h2hSFTPPush(WebDriver driver){

        this.driver = driver;

    }

    public void populateh2hSFTPPush(Sheet h2hTestDataSheet, int rowno) throws InterruptedException, IOException {

        By SFTPPushToggler = By.xpath("//sftp-push//div[@class='card-toggle']");
        By saveSFTPPushSaveButton = By.xpath("//sftp-push//button[@class='btn btn-primary']");
        By hostName = By.xpath("//input[@formcontrolname ='hostName']");
        By port = By.xpath("//input[@formcontrolname ='port']");
        By fingerprint = By.xpath("//input[@formcontrolname ='fingerprint']");
        By fingerprintLinks = By.xpath("//sftp-push//button[@class='btn btn-linkbutton']");
        By alternativeHostName = By.xpath("//input[@formcontrolname ='alternativeHostName']");
        By alternativePort = By.xpath("//input[@formcontrolname ='alternativePort']");
        By alternativeFingerprint = By.xpath("//input[@formcontrolname ='alternativeFingerprint']");
        By testHostName = By.xpath("//input[@formcontrolname ='testHostName']");
        By testPort = By.xpath("//input[@formcontrolname ='testPort']");
        By testFingerprint = By.xpath("//input[@formcontrolname ='testFingerprint']");

        clickTogglerIfNecessary(driver, SFTPPushToggler, saveSFTPPushSaveButton);

        Row row = h2hTestDataSheet.getRow(rowno);

       // h2hUtilities.h2hWaitUntil(driver, saveSFTPPushSaveButton, 15, "From populateh2hSFTPPush saveSFTPPushSaveButton");

        driver.findElement(hostName).sendKeys(row.getCell(0).getStringCellValue());
        driver.findElement(port).sendKeys(row.getCell(1).getStringCellValue());
        driver.findElement(fingerprint).sendKeys(row.getCell(2).getStringCellValue());

        List<WebElement> addFingerPrintLinks = driver.findElements(fingerprintLinks);

        System.out.println("Number of elements in addFingerPrintLinks" + addFingerPrintLinks.size());

        scrollIntoViewNoClick(driver, alternativeHostName);
        addFingerPrintLinks.get(0).click();

        scrollIntoViewNoClick(driver, alternativeHostName);
        driver.findElement(alternativeHostName).sendKeys(row.getCell(3).getStringCellValue());
        scrollIntoViewNoClick(driver, alternativePort);
        driver.findElement(alternativePort).sendKeys(row.getCell(4).getStringCellValue());
        driver.findElement(alternativeFingerprint).sendKeys(row.getCell(5).getStringCellValue());

        scrollIntoViewNoClick(driver, testHostName);
        addFingerPrintLinks.get(1).click();

        scrollIntoViewNoClick(driver, testHostName);
        driver.findElement(testHostName).sendKeys(row.getCell(6).getStringCellValue());
        scrollIntoViewNoClick(driver, testPort);
        driver.findElement(testPort).sendKeys(row.getCell(7).getStringCellValue());
        scrollIntoViewNoClick(driver, testFingerprint);
        driver.findElement(testFingerprint).sendKeys(row.getCell(8).getStringCellValue());

        scrollIntoViewNoClick(driver, saveSFTPPushSaveButton);
        addFingerPrintLinks.get(2).click();

        //h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_clicksaveSFTPButton.png");
        scrollIntoViewNoClick(driver, saveSFTPPushSaveButton);
        driver.findElement(saveSFTPPushSaveButton).click();
        //System.exit(0);
        }
}


