package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_LoginPage {
    WebDriver driver;

    // create constructor
    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Variable And Locator
    final private By EmailAddress = By.xpath("//input[@id='input-email']");
    final private By Password = By.xpath("//input[@id='input-password']");
    final private By LoginBtn= By.xpath("//input[@type='submit']");
    final private By ForgetPasswordBtn= By.xpath("//a[text()='Forgotten Password'][1]");

    final private By LogoutBtn = By.xpath("//a[@class='list-group-item'][13]");

    //Methods

    //1- LoginMethod
    public void UserLogin(String emailAddress, String password) throws InterruptedException {
        driver.findElement(EmailAddress).sendKeys(emailAddress);
        driver.findElement(Password).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(LoginBtn).click();
    }


    // 2- CheckUserLoginSuccess
    public boolean CheckLogOutButtonExistAfterLogin() {
        return driver.findElement(LogoutBtn).isDisplayed();

    }
    // 2- CheckUserNotLogIn
    public boolean IsLogInBtnExist() {
        return driver.findElement(LoginBtn).isDisplayed();

    }



    // 3-  Open ForgetPasswordMethod
    public void OpenForgetPasswordPage(){
        driver.findElement(ForgetPasswordBtn).click();
    }






}
