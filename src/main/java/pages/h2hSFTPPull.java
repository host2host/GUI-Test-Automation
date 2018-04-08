package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

import java.io.IOException;

import static utilities.h2hUtilities.clickTogglerIfNecessary;
import static utilities.h2hUtilities.scrollIntoViewNoClick;

public class h2hSFTPPull {

    WebDriver driver;

    //TODO Have check that on right page
    // By h2hGeneralInformationText = By.id("dashboard");

    public h2hSFTPPull(WebDriver driver){

        this.driver = driver;

    }

    public void populateh2hSFTPPull(Sheet h2hTestDataSheet, int rowno) throws InterruptedException, IOException {

        By SFTPPullToggler = By.xpath("//sftp-pull//div[@class='card-toggle']");

        By saveSFTPPullSaveButton = By.xpath("//sftp-pull//button[@class='btn btn-primary']");

        clickTogglerIfNecessary(driver, SFTPPullToggler, saveSFTPPullSaveButton);

        Row row = h2hTestDataSheet.getRow(rowno);


        h2hUtilities.h2hWaitUntil(driver, saveSFTPPullSaveButton, 15, "From h2hProducts clicksaveSFTP");
        //h2hUtilities.scrollIntoView(driver, registerNewCustomerButton);
        h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_clicksaveSFTPButton.png");
        scrollIntoViewNoClick(driver, saveSFTPPullSaveButton);
        driver.findElement(saveSFTPPullSaveButton).click();
        }

}


