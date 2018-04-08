package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.h2hUtilities;

import java.io.IOException;

import static utilities.h2hUtilities.h2hWaitForLoaderToDisappear;
import static utilities.h2hUtilities.scrollIntoView;
import static utilities.h2hUtilities.scrollIntoViewNoClick;

public class h2hNavigationBar {

    WebDriver driver;

    By onBoardingTab = By.linkText("Onboarding");
    By registerNewCustomerButton = By.partialLinkText("Register");
    By saveOnboarding = By.xpath("//client-information-form//button[@class='btn btn-primary']");
    By saveAccount = By.xpath("//account-form//button[@class='btn btn-primary pull-right']");
    By saveUserButton = By.xpath("//client-user-form//button[@class='btn btn-primary pull-right']");
    By saveProductsButton = By.xpath("//account-form//button[@class='btn btn-primary pull-right']");
    By sendForApprovalButton = By.xpath("//review-form//button[@class='btn btn-primary']");
    By nextOnOnboarding = By.xpath("//client-information-form//button[@class='btn btn-primary']");
    By stepperStep1Span = By.id("stepper-step_1_span");
    By stepperStep2Span = By.id("stepper-step_2_span");
    By stepperStep3Span = By.id("stepper-step_3_span");
    By stepperStep4Span = By.id("stepper-step_4_span");
    By Loader = By.id("loader");
    By PGPEncryptionSaveButton = By.xpath("//pgp-encryption//button[@class='btn btn-primary pull-right']");

    public h2hNavigationBar(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public void clickonOnboarding() throws InterruptedException {

        h2hUtilities.h2hWaitUntil(driver, onBoardingTab, 15, "From h2hNavigationBar clickonOnboarding");
        driver.findElement(onBoardingTab).click();

    }

   public void clickRegisterNewCustomerButton() throws Exception {

       By registerNewCustomerButton = By.partialLinkText("Register");

 //TODO - rejig snapshots
       h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_Register_before loader wait.png");
       h2hWaitForLoaderToDisappear(driver, Loader, 15, "Register button - wait for loader to disappear");
       h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_Register_after loader wait.png");


       driver.findElement(registerNewCustomerButton).click();
       //System.exit(1);

    }

    public void clickonSaveOnboarding() throws InterruptedException {

        h2hUtilities.h2hWaitUntil(driver, saveOnboarding, 15, "From h2hNavigationBar saveOnnOnboarding");
        driver.findElement(saveOnboarding).click();

    }

    public  void clickonSaveAccount() throws InterruptedException {

        scrollIntoView(driver,saveAccount);
        h2hUtilities.h2hWaitUntil(driver, saveAccount, 15, "From h2hNavigationBar saveAccount");
        driver.findElement(saveAccount).click();

    }

    public  void clickonSaveUsers() throws InterruptedException {

        h2hUtilities.h2hWaitUntil(driver, saveUserButton, 15, "From h2hNavigationBar saveUserButton");
        scrollIntoView(driver,saveUserButton);
        //driver.findElement(saveUserButton).click();

    }

    public  void clickonPGPEncryptionSaveButton() throws InterruptedException {

        h2hUtilities.h2hWaitUntil(driver, PGPEncryptionSaveButton, 15, "From h2hNavigationBar PGPEncryptionSaveButton");
        scrollIntoView(driver,PGPEncryptionSaveButton);
        //driver.findElement(saveUserButton).click();

    }

    public  void clickonSendForApprovalButton() throws InterruptedException {

        h2hUtilities.h2hWaitUntil(driver, sendForApprovalButton, 15, "From h2hNavigationBar sendForApprovalButton");
        scrollIntoView(driver,sendForApprovalButton);
        driver.findElement(sendForApprovalButton).click();
    }

    public void clickonNextOnboarding() throws InterruptedException, IOException {

        h2hUtilities.h2hWaitUntil(driver, nextOnOnboarding, 15, "From h2hNavigationBar clickRegisterNewCustomerButton");
        h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_Register1_Orig.png");
        driver.findElement(nextOnOnboarding).click();

    }

    public void clickonStepper1() throws InterruptedException, IOException {

        //TODO This is sometimes flaky, does not find stepper 1 SOMETIMES
        scrollIntoView(driver,stepperStep1Span);
        driver.findElement(stepperStep1Span).click();

    }

    public void clickonStepper2() throws InterruptedException, IOException {

        scrollIntoView(driver,stepperStep2Span);
        driver.findElement(stepperStep2Span).click();

    }
    public void clickonStepper3() throws InterruptedException, IOException {

        //TODO This is sometimes flaky, does not find stepper 2 sometimes
        scrollIntoView(driver,stepperStep3Span);
        driver.findElement(stepperStep3Span).click();
    }

    public void clickonStepper4() throws InterruptedException, IOException {

        scrollIntoViewNoClick(driver,stepperStep4Span);
        driver.findElement(stepperStep4Span).click();
    }


}
