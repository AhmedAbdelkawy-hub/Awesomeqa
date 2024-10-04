package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_ForgetPasswordPage {
    // 1- initiate WebDriver
    // 2- constructor ->
    // 3- locators -> private
    // 4- action methods -> public

    WebDriver driver;

    public P04_ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3- locators -> private
    final private By Email = By.xpath("//input[@id='input-email']");
    final private By ContinueBtn = By.xpath("//input[@value='Continue']");
    final private By EmailSentMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    // 4- action methods -> public
    public void RequestNewPassword(String email) throws InterruptedException {
        driver.findElement(Email).sendKeys(email);
        Thread.sleep(5000);
        driver.findElement(ContinueBtn).click();
    }

    // 4- ForgetPasswordEmailSentMessage
    public String GetForgetPasswordEmailSentMessage(){
       return driver.findElement(EmailSentMessage).getText();
    }

}
