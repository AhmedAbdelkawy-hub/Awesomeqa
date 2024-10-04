package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class P06_CheckOutPage {
    // 1- initiate WebDriver
    // 2- constructor ->
    // 3- locators -> private
    // 4- action methods -> public

    WebDriver driver;

    public P06_CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }


    // 3- locators -> private
    By FirstNameText = By.xpath("//input [@name='firstname']");
    By lastNameText = By.xpath("//input [@name='lastname']");
    By CompanyText = By.xpath("//input [@name='company']");
    By AddressText = By.xpath("//input [@name='address_1']");
    By CityText = By.xpath("//input [@name='city']");
    By PostCodeText = By.xpath("//input [@name='postcode']");
    By CountryDropDown =By.xpath("//select[@name='country_id']");
    By RegionDropDown =By.xpath("//select[@name='zone_id']");
    By ContinueBillingBtn =By.xpath("//input[@id='button-payment-address']");
    By ContinueDeliveryDetailsBtn =By.xpath("//input[@id='button-shipping-address']");
    By ContinueDeliveryMethodBtn =By.xpath("//input[@id='button-shipping-method']");
    By AddCommentsText =By.xpath("//textarea[@name='comment']");
    By AgreeCheckBox =By.xpath("//input[@type='checkbox']");
    By ContinuePaymentMethodBtn =By.xpath("//input[@id='button-payment-method']");
    By ConfirmOrderBtn =By.xpath("//input[@value='Confirm Order']");
    By GetTextSuccessOrder = By.xpath("//p[text()='Your order has been successfully processed!']");


    // 4- action methods -> public
    //1- fillBillDetails
    public void FillBillingDetails(String firstName,String lastName,
                                   String company,String address,String city,String postCode) throws InterruptedException {

        driver.findElement(FirstNameText).sendKeys(firstName);
        driver.findElement(lastNameText).sendKeys(lastName);
        driver.findElement(CompanyText).sendKeys(company);
        driver.findElement(AddressText).sendKeys(address);
        driver.findElement(CityText).sendKeys(city);
        driver.findElement(PostCodeText).sendKeys(postCode);

   Thread.sleep(200);
        // Select Randomly form country list
        // Create a Select object for interacting with the dropdown
        WebElement countryElement = driver.findElement(CountryDropDown);
        Select selectCountry = new Select(countryElement);
        // Get all the options in the dropdown
        List<WebElement> optionsCountry = selectCountry.getOptions();
        // Exclude the first option if it is "Please Select" (usually index 0)
        int randomIndexCountry = new Random().nextInt(optionsCountry.size() - 1) + 1; // Starts from 1 to avoid first item
        // Select a random option from the dropdown
        selectCountry.selectByIndex(randomIndexCountry);
        Thread.sleep(500);



        // Select Randomly from Region list
        WebElement regionDropdown = driver.findElement(RegionDropDown);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(regionDropdown));  // Wait until the region dropdown is enabled

// Now, check if the region dropdown is enabled
        if (regionDropdown.isEnabled()) {
            Select selectRegion = new Select(regionDropdown);
            List<WebElement> optionsRegion = selectRegion.getOptions();

            // Exclude the first option if it is "Please Select" (usually index 0)
            if (optionsRegion.size() > 1) {  // Ensure there are options available
                int randomIndexRegion = new Random().nextInt(optionsRegion.size() - 1) + 1; // Starts from 1 to avoid the first item
                selectRegion.selectByIndex(randomIndexRegion);
            } else {
                System.out.println("Region dropdown has no selectable options.");
            }
        } else {
            System.out.println("Region dropdown is disabled.");
        }

        Thread.sleep(500);
        driver.findElement(ContinueBillingBtn).click();

    }

   //2- DeliveryDetails

    public void DeliveryDetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueDeliveryDetailsBtn));
        continueBtn.click();

    }

  // 3- DeliveryMethod
    public void DeliveryMethod(String Comments) {
        // Wait until AddCommentsText is clickable and then send the comments
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentsField = wait.until(ExpectedConditions.elementToBeClickable(AddCommentsText));
        commentsField.sendKeys(Comments);

        // Wait until ContinueDeliveryMethodBtn is clickable and then click it
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueDeliveryMethodBtn));
        continueBtn.click();
    }

    // 4- PaymentMethod
    public void PaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the AgreeCheckBox is clickable and then click it
        WebElement agreeCheckBox = wait.until(ExpectedConditions.elementToBeClickable(AgreeCheckBox));
        agreeCheckBox.click();

        // Wait until ContinuePaymentMethodBtn is clickable and then click it
        WebElement continuePaymentBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinuePaymentMethodBtn));
        continuePaymentBtn.click();
    }

   //5- ConfirmOrder
    public void ConfirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until ConfirmOrderBtn is clickable and then click it
        WebElement confirmOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrderBtn));
        confirmOrderBtn.click();
    }


      //6- GetSuccessOrderMessage
    public String GetSuccessOrderMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until GetTextSuccessOrder is visible and then get the text
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(GetTextSuccessOrder));
        return successMessage.getText();
    }


}
