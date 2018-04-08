package test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utilities.ExcelFileUtilities;
import utilities.h2hUtilities;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class h2hScenarios01 {

    WebDriver driver;

    h2hLogin objLogin;

    h2hHomePage objHomePage;
    h2hNavigationBar objNavigationBar;
    h2hGeneralInformation objGeneralInformation;
    h2hContactDetails objContactDetails;
    h2hTechnicalContact objTechnicalContact;
    h2hImplementationManager objImplementationManager;
    h2hRelationshipManager objRelationshipManager;
    h2hProducts objProducts;
    h2hSFTPPull objSFTPPull;
    h2hSFTPPush objSFTPPush;
    h2hAccounts objh2hAccounts;
    h2hAddClientUser objAddClientUser;
    h2hReview objh2hReview;
    h2hPGPSigning objPGPSigning;
    h2hX509Signing objX509Signing;
    h2hPGPEncryption objPGPEncryption;
    h2hX509Encryption objX509Encryption;
    h2hCompression objCompression;

    String userName1 = "absuperHost";
    String userPassword1 = "superPass";

    String dataDirectory = "/Users/waynesinclair/Documents/MyProjects/Data";

    String CustomerDataFileName = "h2hCustomerData.xlsx";
    String CustomerDataSheetName = "CustomerData1";

    String SFTPPullDataFileName = "h2hSFTPPullData.xlsx";
    String SFTPPullDataSheetName = "SFTPPullData1";

    String SFTPPushFileName = "h2hSFTPPushData.xlsx";
    String SFTPPushSheetName = "SFTPPushData1";

    String CustomerSecurityFileName = "h2hCustomerSecurity.xlsx";
    String CustomerSecuritySheetName = "CustomerSecurity1";

    String AccountsDataFileName = "h2hAccountsData.xlsx";
    String AccountsDataSheetName = "AccountsData1";

    String ClientUserDataFileName = "h2hClientUserData.xlsx";
    String ClientUserDataSheetName = "ClientUserData1";

    @BeforeTest

    public void setup() {

        driver = h2hUtilities.h2hSetup();

    }

    @Test(priority = 0)

    public void Test_h2h_scenario_01() throws Exception {

        objLogin = new h2hLogin(driver);
        objLogin.loginToh2h(userName1, userPassword1);

        objNavigationBar = new h2hNavigationBar(driver);
        objNavigationBar.clickonOnboarding();

        Sheet h2hTestDataSheet = ExcelFileUtilities.readExcel(dataDirectory, CustomerDataFileName, CustomerDataSheetName);
        Sheet h2hSFTPPullData = ExcelFileUtilities.readExcel(dataDirectory, SFTPPullDataFileName, SFTPPullDataSheetName);
        Sheet h2hSFTPPushData = ExcelFileUtilities.readExcel(dataDirectory, SFTPPushFileName, SFTPPushSheetName);
        Sheet h2hCustomerSecurity = ExcelFileUtilities.readExcel(dataDirectory, CustomerSecurityFileName, CustomerSecuritySheetName);
        Sheet h2hAccountsData = ExcelFileUtilities.readExcel(dataDirectory, AccountsDataFileName, AccountsDataSheetName);
        Sheet h2hClientUserData = ExcelFileUtilities.readExcel(dataDirectory, ClientUserDataFileName, ClientUserDataSheetName);

        // TODO get better wait
        sleep(3000);
        objNavigationBar.clickRegisterNewCustomerButton();

        int activeRowNo = 1;

        objGeneralInformation = new h2hGeneralInformation(driver);
        objGeneralInformation.populateh2hGeneralInformation(h2hTestDataSheet, activeRowNo);

        objContactDetails = new h2hContactDetails(driver);
        objContactDetails.populateh2hContactDetails(h2hTestDataSheet, activeRowNo);

        objTechnicalContact = new h2hTechnicalContact(driver);
        objTechnicalContact.populateh2hTechnicalContact(h2hTestDataSheet, activeRowNo);

        objImplementationManager = new h2hImplementationManager(driver);
        objImplementationManager.populateh2hImplementationManager(h2hTestDataSheet, activeRowNo);

        objRelationshipManager = new h2hRelationshipManager(driver);
        objRelationshipManager.populateh2hRelationshipManager(h2hTestDataSheet, activeRowNo);

        objNavigationBar.clickonSaveOnboarding();
        //objNavigationBar.clickonNextOnboarding();

        objNavigationBar.clickonStepper1();

        h2hProducts objProducts;
        objProducts = new h2hProducts(driver);
        objProducts.populateh2hProducts(h2hTestDataSheet, activeRowNo);

        Row securityRow = h2hCustomerSecurity.getRow(activeRowNo);

        System.out.println("PushOrPull = " + securityRow.getCell(1).getStringCellValue());

        String pushOrPull = securityRow.getCell(1).getStringCellValue();

        if ((securityRow.getCell(1).getStringCellValue()).equals("Pull")) {

            objSFTPPull = new h2hSFTPPull(driver);
            objSFTPPull.populateh2hSFTPPull(h2hSFTPPullData, activeRowNo);
        }

        if ((securityRow.getCell(1).getStringCellValue()).equals("Push")) {

            objSFTPPush = new h2hSFTPPush(driver);
            objSFTPPush.populateh2hSFTPPush(h2hSFTPPushData, activeRowNo);
        }

        System.out.println("Signing = " + securityRow.getCell(2).getStringCellValue());

        if ((securityRow.getCell(2).getStringCellValue()).equals("PGP")) {
            h2hSFTPPush objSFTPPush;

            objSFTPPush = new h2hSFTPPush(driver);
            objSFTPPush.populateh2hSFTPPush(h2hSFTPPushData, activeRowNo);
        }

        if ((securityRow.getCell(2).getStringCellValue()).equals("X509")) {

            objX509Signing = new h2hX509Signing(driver);
            objX509Signing.populateh2hX509Signing(h2hCustomerSecurity, activeRowNo);
        }

        System.out.println("Encryption = " + securityRow.getCell(3).getStringCellValue());

        if ((securityRow.getCell(3).getStringCellValue()).equals("PGP")) {
            objPGPEncryption = new h2hPGPEncryption(driver);
            objPGPEncryption.populateh2hPGPEncryption(h2hCustomerSecurity, activeRowNo);
            //objNavigationBar.clickonPGPEncryptionSaveButton();
        }

        if ((securityRow.getCell(3).getStringCellValue()).equals("X509")) {
            objX509Encryption = new h2hX509Encryption(driver);
            objX509Encryption.populateh2hX509Encryption(h2hCustomerSecurity, activeRowNo);
            //objNavigationBar.clickonX509EncryptionSaveButton();
        }

        String compression = securityRow.getCell(4).getStringCellValue();

        System.out.println("Compression=" + compression);

        if ((compression.equals("ZIP")) | (compression.equals("GZIP"))) {
            h2hCompression objCompression;

            objCompression = new h2hCompression(driver);
            objCompression.populateh2hCompression(h2hCustomerSecurity, activeRowNo);

        }

        objNavigationBar.clickonStepper2();

        objh2hAccounts = new h2hAccounts(driver);
        objh2hAccounts.populateh2hAccounts(h2hAccountsData, activeRowNo);

        objNavigationBar.clickonSaveAccount();

        objNavigationBar.clickonStepper3();

        objAddClientUser = new h2hAddClientUser(driver);
        objAddClientUser.populateh2hAddClientUser(h2hClientUserData, activeRowNo, pushOrPull);

        objNavigationBar.clickonSaveUsers();

        objNavigationBar.clickonStepper4();

        objh2hReview = new h2hReview(driver);
        objh2hReview.populateh2hReview();
        // Next line temporarily commented out
        // objNavigationBar.clickonSendForApprovalButton();

    }

    @Test(priority = 0)

    public void test_Home_Page_Appear_Correct() throws IOException, InterruptedException {

        //Create Login Page object
        objLogin = new h2hLogin(driver);

        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        System.out.println("loginPageTitle=" + loginPageTitle);
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("celine non prod"));
        //login to application

        objLogin.loginToh2h(userName1, userPassword1);

        // go the next page
        objHomePage = new h2hHomePage(driver);

        //Verify home page
        String homePageTitle = objHomePage.getHomePageTitleText();
        System.out.println("homePageTitle=" + homePageTitle);
        Assert.assertTrue(homePageTitle.toLowerCase().contains("dashboard"));

        //Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123

        // Verify onboarding page
        objNavigationBar = new h2hNavigationBar(driver);

        //h2hUtilities.takeSnapShot(driver,"/Users/waynesinclair/Documents/MyProjects/snapshots/snapshot_login5.png");
        objNavigationBar.clickonOnboarding();

    }
}