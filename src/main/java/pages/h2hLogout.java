package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class h2hLogout {

    WebDriver driver;
    By  userIcon = By.xpath("//span[@class='ico ico-user svg dropdown-toggle']");
    By  logOutButton = By.id("logOutButton");

    public h2hLogout(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUserIcon(By byuserIcon) {

        driver.findElement(byuserIcon).click();
    }

    //Set password in password textbox
    public void clickLogoutButton(By byLogOutButton) {

        driver.findElement(byLogOutButton).click();

    }

    public void logoutOfh2h() {

        this.clickUserIcon(userIcon);

        this.clickLogoutButton(logOutButton);

    }
}
