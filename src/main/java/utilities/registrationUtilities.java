package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import pages.*;

import static java.lang.Thread.sleep;


public class registrationUtilities {

    public static String addRegistration(WebDriver driver, Sheet h2hTestDataSheet, Sheet h2hCustomerSecurity,
                                         Sheet h2hSFTPPullData, Sheet h2hSFTPPushData, Sheet h2hAccountsData,
                                         Sheet h2hClientUserData, String approve, int activeRowNo) throws Exception {

        // Login
        // Navigate to new registration
        // Create a new registration
        // Logout
        // Return channel ID

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

        objLogin = new h2hLogin(driver);
        objLogin.loginToh2h(userName1, userPassword1);

        objNavigationBar = new h2hNavigationBar(driver);
        objNavigationBar.clickonOnboarding();

        // TODO get better wait, not recommended to use thread.sleep
        sleep(3000);
        objNavigationBar.clickRegisterNewCustomerButton();

        //int activeRowNo = 1;

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

        //h2hProducts objProducts;
        objProducts = new h2hProducts(driver);
        objProducts.populateh2hProducts(h2hTestDataSheet, activeRowNo);

        Row securityRow = h2hCustomerSecurity.getRow(activeRowNo);

        System.out.println("PushOrPull = " + securityRow.getCell(1).getStringCellValue());

        //TODO accept upper or lower case for pusj and pull
        String pushOrPull = securityRow.getCell(1).getStringCellValue();

        if ((securityRow.getCell(1).getStringCellValue()).toUpperCase().equals("PULL")) {

            objSFTPPull = new h2hSFTPPull(driver);
            objSFTPPull.populateh2hSFTPPull(h2hSFTPPullData, activeRowNo);
        }

        if ((securityRow.getCell(1).getStringCellValue()).equals("Push")) {

            objSFTPPush = new h2hSFTPPush(driver);
            objSFTPPush.populateh2hSFTPPush(h2hSFTPPushData, activeRowNo);
        }

        System.out.println("Signing = " + securityRow.getCell(2).getStringCellValue());

        if ((securityRow.getCell(2).getStringCellValue()).equals("PGP")) {
            //h2hSFTPPush objSFTPPush;

            objPGPSigning = new h2hPGPSigning(driver);
            objPGPSigning.populateh2hPGPSigning(h2hCustomerSecurity, activeRowNo);
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
            //h2hCompression objCompression;

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

        //TODO Need to extract channel ID

        // Approve
        if (approve.equals("Y")) {
            objNavigationBar.clickonsendForApprovalButton();
            objNavigationBar.clickonpendingApprovalTab();
            // get channel ID
        }
        else {
        // Approve the registratio
            // Get the channel ID
        }

        return ("Channel ID");

    }
}



