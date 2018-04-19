package test;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.h2hLogout;
import utilities.ExcelFileUtilities;
import utilities.h2hUtilities;

import java.io.IOException;

import static utilities.registrationUtilities.addRegistration;


public class h2hScenarios02 {

    WebDriver driver;

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

    String ChannelID;
    //String draft;
    String approve;
    int rowno;

    Sheet h2hTestDataSheet;
    Sheet h2hSFTPPullData;
    Sheet h2hSFTPPushData;
    Sheet h2hCustomerSecurity;
    Sheet h2hAccountsData;
    Sheet h2hClientUserData;

    @Test
    public void h2hTest01() throws Exception {

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("\n\n*****************************************************************\n");
        System.out.println(methodName + " is executing....");
        System.out.println("\n*****************************************************************\n");

        // Add draft registration
        // TODO - match scenario to regression test

        approve = "Y";
        rowno = 1;
            ChannelID = addRegistration(driver, h2hTestDataSheet, h2hCustomerSecurity,
                h2hSFTPPullData, h2hSFTPPushData, h2hAccountsData,
                h2hClientUserData,approve,rowno);
    }

    @Test
    public void h2hTest02() throws Exception {

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("\n\n*****************************************************************\n");
        System.out.println(methodName + " is executing....");
        System.out.println("\n*****************************************************************\n");

// Add draft registration and approve
        approve = "N";
        rowno = 2;

        ChannelID = addRegistration(driver, h2hTestDataSheet, h2hCustomerSecurity,
                h2hSFTPPullData, h2hSFTPPushData, h2hAccountsData,
                h2hClientUserData,approve,rowno);

    }

    @Test
    public void h2hTest03() throws Exception {

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("\n\n*****************************************************************\n");
        System.out.println(methodName + " is executing....");
        System.out.println("\n*****************************************************************\n");

        approve = "N";
        rowno = 3;

        ChannelID = addRegistration(driver, h2hTestDataSheet, h2hCustomerSecurity,
                h2hSFTPPullData, h2hSFTPPushData, h2hAccountsData,
                h2hClientUserData,approve,rowno);

    }

    @BeforeSuite

    public void setupBeforSuite() throws IOException {

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("\n\n*****************************************************************\n");
        System.out.println(methodName + " is executing....");
        System.out.println("\n*****************************************************************\n");

        System.out.println("\nReading data from Excel spreadsheets....\n");

        //driver = h2hUtilities.h2hSetup();

        h2hTestDataSheet = ExcelFileUtilities.readExcel(dataDirectory, CustomerDataFileName, CustomerDataSheetName);
        h2hSFTPPullData = ExcelFileUtilities.readExcel(dataDirectory, SFTPPullDataFileName, SFTPPullDataSheetName);
        h2hSFTPPushData = ExcelFileUtilities.readExcel(dataDirectory, SFTPPushFileName, SFTPPushSheetName);
        h2hCustomerSecurity = ExcelFileUtilities.readExcel(dataDirectory, CustomerSecurityFileName, CustomerSecuritySheetName);
        h2hAccountsData = ExcelFileUtilities.readExcel(dataDirectory, AccountsDataFileName, AccountsDataSheetName);
        h2hClientUserData = ExcelFileUtilities.readExcel(dataDirectory, ClientUserDataFileName, ClientUserDataSheetName);
    }

    //@BeforeTest
    @BeforeMethod

    public void setupBeforeTest() {

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("\n\n *****************************************************************\n");
        System.out.println(methodName + " is executing....");
        System.out.println("\n\n *****************************************************************\n");

// TODO check if we need to add anything here
        driver = h2hUtilities.h2hSetup();

    }

    //@AfterTest
    @AfterMethod

    public void teardownAfterTest() {

        h2hLogout objLogout;

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("\n\n*****************************************************************\n");
        System.out.println(methodName + " is executing....");
        System.out.println("\n*****************************************************************\n");

        objLogout = new h2hLogout(driver);
        //objLogout.logoutOfh2h();

        //driver.close();

    }

}