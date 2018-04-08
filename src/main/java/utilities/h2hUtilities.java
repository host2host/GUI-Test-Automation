package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class h2hUtilities {
    public static void takeSnapShot(WebDriver snapshotwebdriver, String fileWithPath) throws IOException {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) snapshotwebdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static void h2hWaitUntil(WebDriver driver, By waitElement, Integer waitTime, String infoString) throws InterruptedException {
        System.out.println("In h2hWaitUntil. waitTime=" + waitTime + " : infoString=" + infoString);

        WebDriverWait wait2 = new WebDriverWait(driver, waitTime);
        wait2.until(ExpectedConditions.elementToBeClickable(waitElement));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public static void h2hWaitForLoaderToDisappear(WebDriver driver, By waitElement, Integer waitTime, String infoString) throws InterruptedException {

        System.out.println("In h2hWaitUntil. waitTime=" + waitTime + " : infoString=" + infoString);
        Boolean loaderIsPresent = driver.findElements(waitElement).size() > 0;
        if (driver.findElements(waitElement).size() > 0) {
            WebDriverWait wait3 = new WebDriverWait(driver, waitTime);
            wait3.until(ExpectedConditions.invisibilityOfElementLocated(waitElement));
        }
    }

    public static WebDriver h2hSetup() {

        /* driver = new FirefoxDriver();                    */
        System.setProperty("webdriver.chrome.driver", "/Users/waynesinclair/Documents/MyDrivers/Chrome/chromedriver");
        String baseUrl = "http://celine-celine-sit.nonprod.ocp.absa.co.za";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //TODO Bring browser in focus
        
        return driver;

    }

    public static void scrollIntoView(WebDriver driver, By scrollElement) throws InterruptedException {

        WebElement element = driver.findElement(scrollElement );
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(scrollElement ));

    }

    public static void scrollIntoViewNoClick(WebDriver driver, By scrollElement) throws InterruptedException {

        WebElement element = driver.findElement(scrollElement );
        Actions actions = new Actions(driver);
        actions.moveToElement(element);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(scrollElement ));

        //WebElement myelement = driver.findElement(scrollElement);
        //JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        //jse2.executeScript("arguments[0].scrollIntoView()", myelement);

    }

    public static void clickTogglerIfNecessary(WebDriver driver, By toggler, By elementToCheck) throws InterruptedException {

        if( driver.findElement(elementToCheck).isDisplayed()){
            System.out.println("Element is Visible");
        }else{
            System.out.println("Element is Not Visible");
            driver.findElement(toggler).click();
        }

    }

    public static String getDateAndTime() {
        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }
}
