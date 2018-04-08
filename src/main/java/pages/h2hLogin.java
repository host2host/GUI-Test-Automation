package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
public class h2hLogin {

    WebDriver driver;

    By h2hUserName = By.name("username");
    By h2hPassword = By.name("password");
    By titleText = By.id("kc-header-wrapper");
    By login = By.name("login");

    public h2hLogin(WebDriver driver) {
        this.driver = driver;
    }

    //Set user name in textbox
    public void setUserName(String strUserName) {

        driver.findElement(h2hUserName).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword) {

        driver.findElement(h2hPassword).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin() {

        driver.findElement(login).click();

    }

    //Get the title of Login Page

    public String getLoginTitle() {

        return driver.findElement(titleText).getText();

    }

    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginToh2h(String strUserName, String strPasword) {

        //Fill user name
        this.setUserName(strUserName);

        //Fill password
        this.setPassword(strPasword);

        //Click Login button
        this.clickLogin();

    }
}
