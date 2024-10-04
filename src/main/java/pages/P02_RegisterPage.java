package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Utilities;
import java.util.List;

public class P02_RegisterPage {
    WebDriver driver;
    // create constructor
    public P02_RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    //Variable And Locator
    final private By RegisterPageText =By.xpath("//h1[text()='Register Account']");
    final private By FirstName = By.xpath("//input[@id ='input-firstname']");
    final private By LastName = By.xpath("//input[@id ='input-lastname']");
    final private By Email = By.xpath("//input[@id ='input-email']");
    final private By Telephone = By.xpath("//input[@id ='input-telephone']");
    final private By Password = By.xpath("//input[@id ='input-password']");
    final private By PasswordConfirm = By.xpath(" //input[@id ='input-confirm']");
    final private By SubscribeRadioBtns = By.className("radio-inline");
    final private By PrivacyPolicyCheckBox = By.xpath(" //input[@type ='checkbox']");
    final private By  ContinueBtn = By.xpath(" //input[@value ='Continue']");
    final private By SuccessRegText = By.xpath("//p[text() ='Congratulations! Your new account has been successfully created!']");
    final private By LogoutBtn = By.xpath("//a[@class='list-group-item'][13]");


    // Methods
    // 1- Registration methods
    public void userRegistration(String firstName,String lastName, String email, String telephone,
                                 String password, String passwordConfirm) throws InterruptedException {
        driver.findElement(FirstName).sendKeys(firstName);
        driver.findElement(LastName).sendKeys(lastName);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Telephone).sendKeys(telephone);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(PasswordConfirm).sendKeys(passwordConfirm);

        // Select random radio button (assuming locators for both radio buttons are available)
        // Get radio buttons and select a random one
        List<WebElement> radioButtons = driver.findElements(SubscribeRadioBtns);
        int randomIndex = Utilities.RadioButtonSelector.selectRandomRadioButtonIndex(radioButtons);
        radioButtons.get(randomIndex).click();
        driver.findElement(PrivacyPolicyCheckBox).click();
        Thread.sleep(5000);
        driver.findElement(ContinueBtn).click();
    }

// 2- Get Success Register Message
    public String GettextSuccessRegister() {
        String SuccessText= driver.findElement(SuccessRegText).getText();
        return SuccessText;
    }
    // 2- CheckUserRegisterSuccess
    public boolean CheckLogOutButtonExistAfterRegister() {
       return driver.findElement(LogoutBtn).isDisplayed();

    }
    // 2- CheckUserNotRegister
    public boolean IsContinueBtnExist() {
        return driver.findElement(ContinueBtn).isDisplayed();

    }


}